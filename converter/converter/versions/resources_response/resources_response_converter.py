import copy
from typing import Dict, Any

from converter.utils import get_field_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.resources_response.resources_response_constants import ResourcesResponseConstants

class ResourcesResponseConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesResponse"

    @classmethod
    def copy_input_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if cls.get_message_type() not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError(f"Input JSON must contain {cls.get_message_type()} key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()]
        return output_json

    @classmethod
    def copy_input_use_case_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()]
        return copy.deepcopy(input_use_case_json)

    @classmethod
    def format_output_json(cls, output_json: Dict[str, Any], output_use_case_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()] = output_use_case_json
        return output_json

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
