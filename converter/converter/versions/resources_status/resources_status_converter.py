from typing import Dict, Any

from converter.utils import map_to_new_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.resources_status.resources_status_constants import (
    ResourcesStatusConstants,
)
from converter.versions.utils import reverse_map_to_new_value, switch_field_name


class ResourcesStatusConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesStatus"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            ResourcesStatusConstants.STATUS_PATH,
            ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING,
        )

        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.DATETIME_PATH,
            ResourcesStatusConstants.STATE_DATETIME_PATH,
        )
        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.STATUS_PATH,
            ResourcesStatusConstants.STATE_STATUS_PATH,
        )
        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.AVAILABILITY_PATH,
            ResourcesStatusConstants.STATE_AVAILABILITY_PATH,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            ResourcesStatusConstants.STATE_STATUS_PATH,
            ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING,
        )

        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.STATE_DATETIME_PATH,
            ResourcesStatusConstants.DATETIME_PATH,
        )
        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.STATE_STATUS_PATH,
            ResourcesStatusConstants.STATUS_PATH,
        )
        switch_field_name(
            output_use_case_json,
            ResourcesStatusConstants.STATE_AVAILABILITY_PATH,
            ResourcesStatusConstants.AVAILABILITY_PATH,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            ResourcesStatusConstants.STATE_STATUS_PATH,
            ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            ResourcesStatusConstants.STATE_STATUS_PATH,
            ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)
