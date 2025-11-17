import datetime

from converter.cisu.base_cisu_converter import BaseCISUConverter
from typing import Any, Dict

from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
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
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        logger.info("Converting from CISU to RS format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")
        output_json = cls.copy_cisu_input_content(edxl_json)
        output_use_case_json = cls.copy_cisu_input_use_case_content(edxl_json)
        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )

        for resource in resources:
            logger.debug(f"Processing resource: {resource}")
            state = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
            set_value(resource, ResourcesInfoCISUConstants.STATE_PATH, [state])

        return cls.format_rs_output_json(output_json, output_use_case_json)

    @classmethod
    def from_rs_to_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        logger.info("Converting from RS to CISU format for Resources Info message.")
        logger.debug(f"Message content: {edxl_json}")
        output_json = cls.copy_rs_input_content(edxl_json)
        output_use_case_json = cls.copy_rs_input_use_case_content(edxl_json)

        resources = get_field_value(
            output_use_case_json, ResourcesInfoCISUConstants.RESOURCE_PATH
        )
        for resource in resources:
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

            cls.keep_last_state(resource)

            delete_paths(resource, [ResourcesInfoCISUConstants.PATIENT_ID_KEY])

        return cls.format_cisu_output_json(output_json, output_use_case_json)

    @classmethod
    def translate_to_cisu_vehicle_type(cls, rs_vehicle_type: str) -> str:
        if rs_vehicle_type.startswith(ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS):
            return ResourcesInfoCISUConstants.VEHICLE_TYPE_SIS
        return ResourcesInfoCISUConstants.DEFAULT_CISU_STATE_VEHICLE_TYPE

    @classmethod
    def keep_last_state(cls, resource: Dict[str, Any]) -> None:
        states = get_field_value(resource, ResourcesInfoCISUConstants.STATE_PATH)
        if states and len(states) > 0:
            latest_state = sorted(states, key=lambda x: x.get("datetime", ""))[-1]
        else:
            latest_state = {
                "datetime": datetime.datetime.now(datetime.timezone.utc).isoformat(
                    timespec="seconds"
                ),
                "status": ResourcesInfoCISUConstants.DEFAULT_CISU_STATE_STATUS,
            }

        set_value(resource, ResourcesInfoCISUConstants.STATE_PATH, latest_state)
