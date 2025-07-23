import copy
from typing import Dict, Any

from converter.utils import delete_paths, get_field_value, map_to_new_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.resources_status.resources_status_constants import ResourcesStatusConstants
from converter.versions.utils import reverse_map_to_new_value

class ResourcesStatusConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesStatus"

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

        map_to_new_value(output_use_case_json,'$.status', ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING)

        datetime = get_field_value(output_use_case_json, '$.datetime')
        status = get_field_value(output_use_case_json, '$.status')
        availability = get_field_value(output_use_case_json, '$.availability')

        output_use_case_json['state'] = {}
        output_use_case_json['state']['datetime'] = datetime
        output_use_case_json['state']['status'] = status

        if availability is not None:
            output_use_case_json['state']['availability'] = availability

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, ResourcesStatusConstants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(output_use_case_json,'$.state.status', ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING)

        state = get_field_value(output_use_case_json, '$.state')
        if state:
            output_use_case_json.update(state)

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, ResourcesStatusConstants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(output_use_case_json,'$.state.status', ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(output_use_case_json,'$.state.status', ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING)

        return cls.format_output_json(output_json, output_use_case_json)
