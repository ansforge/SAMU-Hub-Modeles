import copy
import uuid

from converter.cisu.base_cisu_converter import BaseCISUConverter
from typing import Any, Dict, List

from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
from converter.repositories.message_repository import get_last_rc_ri_by_case_id
from converter.utils import get_field_value, set_value, delete_paths
import logging

logger = logging.getLogger(__name__)


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

            cisu_vehicle_type = get_field_value(
                resource, ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH
            )
            rs_vehicle_type = cls.translate_to_rs_vehicle_type(cisu_vehicle_type)
            set_value(
                resource,
                ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH,
                rs_vehicle_type,
            )

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
        output_json = copy.deepcopy(edxl_json)

        # Generate a new distributionID for the RS-SR message
        output_json["distributionID"] = str(uuid.uuid4())

        message = output_json["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ]

        # Drop the original CISU use-case payload
        message.pop(cls.get_cisu_message_type(), None)

        message["resourcesStatus"] = {
            "caseId": case_id,
            "resourceId": resource.get("resourceId"),
            "state": resource.get("state"),
        }
        return output_json

    @classmethod
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> List[Dict[str, Any]]:
        """RC-RI → RS: always one RS-RI; on first reception also one RS-SR per resource."""
        logger.info("Converting from CISU to RS format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")

        cisu_use_case = cls.copy_cisu_input_use_case_content(edxl_json)
        case_id = cisu_use_case.get(ResourcesInfoCISUConstants.CASE_ID_FIELD)
        if not isinstance(case_id, str):
            raise ValueError(f"Missing or invalid caseId in RC-RI message: {case_id!r}")

        rs_ri = cls._build_rs_ri_from_cisu(edxl_json)

        # Known caseId = subsequent update, RS-RI only
        current_distribution_id = edxl_json.get("distributionID")
        existing_message = get_last_rc_ri_by_case_id(
            case_id, exclude_distribution_id=current_distribution_id
        )
        if existing_message is not None:
            logger.info(
                "Known caseId %s — returning RS-RI only (no RS-SR split).", case_id
            )
            return [rs_ri]

        # New caseId = first reception, split into RS-RI + one RS-SR per resource
        logger.info(
            "New caseId %s — splitting into RS-RI + one RS-SR per resource.", case_id
        )
        resources = get_field_value(
            cisu_use_case, ResourcesInfoCISUConstants.RESOURCE_PATH
        )
        messages: List[Dict[str, Any]] = [rs_ri]
        for resource in resources:
            rs_sr = cls._build_rs_sr_from_resource(edxl_json, resource, case_id)
            messages.append(rs_sr)

        return messages

    @classmethod
    def from_rs_to_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        logger.info("Converting from RS to CISU format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")
        output_json = cls.copy_rs_input_content(edxl_json)
        output_use_case_json = cls.copy_rs_input_use_case_content(edxl_json)

        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )
        for index, resource in enumerate(resources):
            logger.debug(f"Processing resource: {resource}")
            rs_vehicle_type = get_field_value(
                resource, ResourcesInfoCISUConstants.VEHICLE_TYPE_PATH
            )
            cisu_vehicle_type = cls.translate_to_cisu_vehicle_type(rs_vehicle_type)
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

        return cls.format_cisu_output_json(output_json, output_use_case_json)

    @classmethod
    def translate_to_cisu_vehicle_type(cls, rs_vehicle_type: str) -> str:
        if rs_vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS):
            return ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS
        if rs_vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR):
            return ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR
        raise ValueError(
            f"Vehicle type '{rs_vehicle_type}' cannot be mapped to a valid CISU vehicle type. "
            f"Accepted values are: {ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS}, {ResourcesInfoCISUConstants.VEHICLE_TYPE_SMUR}."
        )

    @classmethod
    def translate_to_rs_vehicle_type(cls, cisu_vehicle_type: str) -> str:
        if cisu_vehicle_type == ResourcesInfoCISUConstants.VEHICULE_TYPE_OTHER:
            return ResourcesInfoCISUConstants.RS_VEHICULE_TYPE_AUTREVEC
        return cisu_vehicle_type

    @classmethod
    def keep_last_state(cls, resource: Dict[str, Any]) -> None:
        states = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
        if not states or len(states) == 0:
            raise ValueError(
                "No states found in resource, mandatory for CISU conversion."
            )

        latest_state = sorted(states, key=lambda x: x.get("datetime", ""))[-1]
        set_value(resource, ResourcesInfoCISUConstants.STATE_PATH, latest_state)
