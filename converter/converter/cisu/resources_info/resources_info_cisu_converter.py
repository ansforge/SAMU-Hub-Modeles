import uuid

from converter.cisu.base_cisu_converter import BaseCISUConverter
from typing import Any, Dict, List, TypedDict

from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
from converter.repositories.message_repository import get_last_rc_ri_by_case_id
from converter.utils import get_field_value, set_value, delete_paths
import logging

logger = logging.getLogger(__name__)


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
        cls, edxl_json: Dict[str, Any], resource: Dict[str, Any], case_id: str
    ) -> Dict[str, Any]:
        """Build an RS-SR from a single RC-RI resource, reusing the EDXL envelope."""
        logger.info(
            "Building RS-SR for resourceId=%s, caseId=%s.",
            resource.get("resourceId"),
            case_id,
        )
        output_json = cls.copy_cisu_input_content(edxl_json)

        # Generate a new distributionID for the RS-SR message
        output_json["distributionID"] = f"{edxl_json['senderID']}_{uuid.uuid4()}"

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

        for resource in modified_status_resources:
            logger.info(
                "Resource %s has a modified status — adding RS-SR to output.",
                resource.get("resourceId"),
            )
            rs_sr = cls._build_rs_sr_from_resource(edxl_json, resource, case_id)
            messages.append(rs_sr)

        if not messages:
            logger.info("No resource changes detected for caseId %s.", case_id)

        return messages

    @classmethod
    def from_rs_to_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any] | list[Dict[str, Any]]:
        logger.info("Converting from RS to CISU format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")
        output_json = cls.copy_rs_input_content(edxl_json)
        output_use_case_json = cls.copy_rs_input_use_case_content(edxl_json)

        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )

        converted_resources = cls.convert_resources_to_cisu(resources)

        if len(converted_resources) < 1:
            logger.info("No CISU-compatible resources remain after filtering — returning empty list.")
            return []

        set_value(
            output_use_case_json,
            ResourcesInfoCISUConstants.RESOURCE_PATH,
            converted_resources,
        )

        return cls.format_cisu_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_resources_to_cisu(
        cls, resources: list[Dict[str, Any]]
    ) -> list[Dict[str, Any]]:
        converted_resources = []

        for index, resource in enumerate(resources):
            logger.debug(f"Processing resource: {resource}")
            rs_vehicle_type = get_field_value(
                resource, ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH
            )

            cisu_vehicle_type = cls.translate_to_cisu_vehicle_type(rs_vehicle_type)

            if not cisu_vehicle_type:  # if we couldn't map the vehicleType on a SIS known type, we continue to filter the whole resource out
                continue

            set_value(
                resource,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH,
                cisu_vehicle_type,
            )

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
            cls.keep_last_state(resource)

            delete_paths(resource, [ResourcesInfoCISUConstants.PATIENT_ID_KEY])

            converted_resources.append(resource)

        return converted_resources

    @classmethod
    def translate_to_cisu_vehicle_type(cls, rs_vehicle_type: str) -> str | None:
        if rs_vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS):
            return ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS
        elif rs_vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR):
            return ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR
        else:
            logger.info(
                "Removing resource because vehicleType '%s' is not supported",
                rs_vehicle_type,
            )
            return None

    @classmethod
    def keep_last_state(cls, resource: Dict[str, Any]) -> None:
        states = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
        if not states or len(states) == 0:
            raise ValueError(
                "No states found in resource, mandatory for CISU conversion."
            )

        latest_state = sorted(states, key=lambda x: x.get("datetime", ""))[-1]
        set_value(resource, ResourcesInfoCISUConstants.STATE_PATH, latest_state)
