import copy
from typing import Dict, Any

from converter.utils import get_field_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.resources_response.resources_response_constants import ResourcesResponseConstants

class ResourcesResponseConverter(BaseMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesResponse"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        deadline = get_field_value(output_use_case_json, '$.response.deadline')
        if deadline is not None and deadline not in ResourcesResponseConstants.V2_VALID_DEADLINES:
            output_use_case_json['response']['deadline'] = ResourcesResponseConstants.V2_DEFAULT_DEADLINE

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json
