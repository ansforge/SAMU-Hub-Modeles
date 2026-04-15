import uuid

from converter.cisu.base_cisu_converter import BaseCISUConverter
from typing import Any, Dict, List, TypedDict

from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
from converter.cisu.resources_info.resources_info_cisu_helper import (
    enrich_rs_ri_with_rs_srs,
    get_latest_state,
)
from converter.repositories.message_repository import (
    get_last_rc_ri_by_case_id,
    get_rs_messages_by_case_id,
)
from converter.utils import get_field_value, set_value, delete_paths
import logging

logger = logging.getLogger(__name__)


class ConversionError(ValueError):
    def __init__(self, message):
        self.message = message
        super().__init__(self.message)


class ResourceUpdateResult(TypedDict):
    engaged_resources_updated: bool
    modified_status_resources: List[Dict[str, Any]]


class ResourcesInfoCISUConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesInfo"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesInfoCisu"

    @classmethod
    def _build_rs_ri_from_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        """Convert a RC-RI to a RS-RI, removing the position field from each resource."""
        logger.info("Building RS-RI from RC-RI.")
        output_json = cls.copy_cisu_input_content(edxl_json)
        output_use_case_json = cls.copy_cisu_input_use_case_content(edxl_json)
        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )

        for index, resource in enumerate(resources):
            logger.debug(f"Processing resource: {resource}")
            current_resource_path = (
                f"{ResourcesInfoCISUConstants.RESOURCE_PATH}[{index}]"
            )

            current_state_path = (
                f"{current_resource_path}.{ResourcesInfoCISUConstants.STATE_PATH}"
            )
            logger.info(
                "Transforming state to list format for RS at path %s",
                current_state_path,
            )
            state = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
            set_value(resource, ResourcesInfoCISUConstants.STATE_PATH, [state])

            # RS-RI does not carry GPS position — remove it if present
            delete_paths(resource, [ResourcesInfoCISUConstants.POSITION_KEY])

        return cls.format_rs_output_json(output_json, output_use_case_json)

    @classmethod
    def _build_rs_sr_from_resource(
        cls,
        edxl_json: Dict[str, Any],
        resource: Dict[str, Any],
        case_id: str,
        use_original_distribution_id: bool = False,
    ) -> Dict[str, Any]:
        """Build an RS-SR from a single RC-RI resource, reusing the EDXL envelope."""
        logger.info(
            "Building RS-SR for resourceId=%s, caseId=%s.",
            resource.get("resourceId"),
            case_id,
        )
        output_json = cls.copy_cisu_input_content(edxl_json)

        if not use_original_distribution_id:
            cls.set_distribution_id(
                output_json, f"{edxl_json['senderID']}_{uuid.uuid4()}"
            )

        output_use_case_json = {
            "caseId": case_id,
            "resourceId": resource.get("resourceId"),
            "state": resource.get("state"),
        }
        return cls._format_output_json(
            output_json, output_use_case_json, "resourcesStatus"
        )

    @classmethod
    def _get_resource_map(cls, edxl_json: Dict[str, Any]) -> Dict[str, Dict[str, Any]]:
        """Extract a resourceId → resource mapping from an RC-RI EDXL message."""
        use_case = cls.copy_cisu_input_use_case_content(edxl_json)
        resources: List[Dict[str, Any]] = (
            get_field_value(use_case, ResourcesInfoCISUConstants.RESOURCE_PATH) or []
        )
        return {r["resourceId"]: r for r in resources}

    @classmethod
    def _has_resources_been_updated(
        cls, reference_edxl: Dict[str, Any], comparison_edxl: Dict[str, Any]
    ) -> ResourceUpdateResult:
        """Compare the resources of two RC-RI messages."""
        reference_map = cls._get_resource_map(reference_edxl)
        comparison_map = cls._get_resource_map(comparison_edxl)

        engaged_resources_updated: bool = set(reference_map.keys()) != set(
            comparison_map.keys()
        )

        modified_status_resources: List[Dict[str, Any]] = []
        for resource_id, comparison_resource in comparison_map.items():
            if resource_id not in reference_map:
                # Newly added resource — receiver has no previous status for it
                logger.debug(
                    "Resource %s is new — adding to modified_status_resources.",
                    resource_id,
                )
                modified_status_resources.append(comparison_resource)
            else:
                ref_status = reference_map[resource_id]["state"]["status"]
                cmp_status = comparison_resource["state"]["status"]
                if ref_status != cmp_status:
                    logger.debug(
                        "Resource %s status changed: %r → %r",
                        resource_id,
                        ref_status,
                        cmp_status,
                    )
                    modified_status_resources.append(comparison_resource)

        # TODO: handle removed resources (present in reference_map but absent from comparison_map).

        return ResourceUpdateResult(
            engaged_resources_updated=engaged_resources_updated,
            modified_status_resources=modified_status_resources,
        )

    @classmethod
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> List[Dict[str, Any]]:
        """RC-RI → RS: on first reception RS-RI + one RS-SR per resource;
        on update RS-RI if the engaged resource list changed + RS-SR per resource with a modified status."""
        logger.info("Converting from CISU to RS format for Resources Info message.")
        logger.debug("Message content: %s", edxl_json)

        cisu_use_case = cls.copy_cisu_input_use_case_content(edxl_json)
        case_id = cisu_use_case.get(ResourcesInfoCISUConstants.CASE_ID_FIELD)
        if not isinstance(case_id, str):
            raise ValueError(f"Missing or invalid caseId in RC-RI message: {case_id!r}")

        current_distribution_id = edxl_json.get("distributionID")
        existing_message = get_last_rc_ri_by_case_id(
            case_id, exclude_distribution_id=current_distribution_id
        )

        # New caseId = first reception, RS-RI + one RS-SR per resource
        if existing_message is None:
            logger.info(
                "New caseId %s — returning RS-RI + one RS-SR per resource.", case_id
            )
            resources = get_field_value(
                cisu_use_case, ResourcesInfoCISUConstants.RESOURCE_PATH
            )

            converted_messages = [cls._build_rs_ri_from_cisu(edxl_json)]
            for resource in resources:
                converted_messages.append(
                    cls._build_rs_sr_from_resource(edxl_json, resource, case_id)
                )
            return converted_messages

        # Known caseId — compare resources and emit only what changed
        logger.info("Known caseId %s — comparing resources for updates.", case_id)

        resources_comparison_result = cls._has_resources_been_updated(
            existing_message.payload, edxl_json
        )
        engaged_resources_updated: bool = resources_comparison_result[
            "engaged_resources_updated"
        ]
        modified_status_resources: List[Dict[str, Any]] = resources_comparison_result[
            "modified_status_resources"
        ]

        messages: List[Dict[str, Any]] = []

        if engaged_resources_updated:
            logger.info(
                "Resources added/removed for caseId %s — adding RS-RI to output.",
                case_id,
            )
            rs_ri = cls._build_rs_ri_from_cisu(edxl_json)
            messages.append(rs_ri)

        for idx, resource in enumerate(modified_status_resources):
            logger.info(
                "Resource %s has a modified status — adding RS-SR to output.",
                resource.get("resourceId"),
            )
            should_use_original_distribution_id = (
                not engaged_resources_updated and idx == 0
            )
            rs_sr = cls._build_rs_sr_from_resource(
                edxl_json, resource, case_id, should_use_original_distribution_id
            )
            messages.append(rs_sr)

        if not messages:
            logger.info("No resource changes detected for caseId %s.", case_id)

        return messages

    @classmethod
    def from_rs_to_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        """
        Mother function that takes a RS-RI message and returns a RC-RI message
        This functions manages:
        - taking the RS-RI as param
        - fetches potential peristed RS-SR in the db
        - merges different resources (following métier rules)
        - makes the conversion from rs to cisu
        - returns the converted message
        """

        logger.info("Converting from RS to CISU format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")
        output_json = cls.copy_rs_input_content(edxl_json)
        current_use_case = cls.copy_rs_input_use_case_content(edxl_json)

        case_id = get_field_value(current_use_case, "caseId")

        _, persisted_rs_sr = get_rs_messages_by_case_id(case_id)
        rs_sr_use_cases = [
            # Hardcoded RS_SR use case to avoid circular dependency
            # TODO: Fix
            cls._copy_input_use_case_content(pm.payload, "resourcesStatus")
            for pm in persisted_rs_sr
        ]
        enriched = enrich_rs_ri_with_rs_srs(current_use_case, rs_sr_use_cases)

        return cls.convert_single_rs_ri(output_json, enriched)

    @classmethod
    def convert_single_rs_ri(
        cls, output_json: Dict[str, Any], output_use_case_json: Dict[str, Any]
    ):
        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )
        converted_resources = cls._convert_resources_to_cisu(resources)

        if len(converted_resources) < 1:
            logger.info(
                "No CISU-compatible resources remain after filtering — returning empty list."
            )
            return []

        set_value(
            output_use_case_json,
            ResourcesInfoCISUConstants.RESOURCE_PATH,
            converted_resources,
        )

        return cls.format_cisu_output_json(output_json, output_use_case_json)

    @classmethod
    def _convert_resources_to_cisu(
        cls, resources: list[Dict[str, Any]]
    ) -> list[Dict[str, Any]]:
        converted_resources = []

        for index, resource in enumerate(resources):
            logger.debug("Processing resource: {resource}")

            try:
                current_resource_path = (
                    f"{ResourcesInfoCISUConstants.RESOURCE_PATH}[{index}]"
                )
                current_state_path = (
                    f"{current_resource_path}.{ResourcesInfoCISUConstants.STATE_PATH}"
                )
                logger.info(
                    "Transforming state to singleton for CISU at path %s",
                    current_state_path,
                )

                cls._translate_to_cisu_vehicle_type(resource)
                cls._keep_last_state(resource)
                cls._remove_patient_id(resource)

                converted_resources.append(resource)
            except ConversionError:
                continue

        return converted_resources

    @classmethod
    def _remove_patient_id(cls, resource):
        delete_paths(resource, [ResourcesInfoCISUConstants.PATIENT_ID_KEY])

    @classmethod
    def _translate_to_cisu_vehicle_type(cls, resource: Dict[str, Any]) -> None:
        """Translate a RS vehicle type to its CISU equivalent, or None if not mappable."""

        vehicle_type = get_field_value(
            resource, ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH
        )

        if vehicle_type is None:
            raise ConversionError(
                f"No vehicle found in RS resource for resource: {resource.get('resourceId')}."
            )

        if vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS):
            set_value(
                resource,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS,
            )
        elif vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR):
            set_value(
                resource,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR,
            )
        else:
            raise ConversionError(
                f"No valid vehicle found for resource: {resource.get('resourceId')}."
            )

    @classmethod
    def _keep_last_state(cls, resource: Dict[str, Any]) -> None:
        states = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
        if not states or len(states) == 0:
            raise ConversionError(
                "No states found in resource, mandatory for CISU conversion."
            )

        set_value(
            resource,
            ResourcesInfoCISUConstants.STATE_PATH,
            get_latest_state(states),
        )
