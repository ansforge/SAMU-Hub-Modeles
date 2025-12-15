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
        return ResourcesInfoCISUConstants.VEHICULE_TYPE_OTHER

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
