import copy
from typing import Dict, Any


class ConversionMixin:
    @classmethod
    def copy_input_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = copy.deepcopy(input_json)
        message_type = cls.get_message_type()

        message_content = input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})
        if message_type not in message_content:
            raise ValueError(f"Input JSON must contain {message_type} key")

        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][message_type]
        return output_json

    @classmethod
    def copy_input_use_case_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        message_type = cls.get_message_type()
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][message_type]
        return copy.deepcopy(input_use_case_json)

    @classmethod
    def format_output_json(cls, output_json: Dict[str, Any], output_use_case_json: Dict[str, Any]) -> Dict[str, Any]:
        message_type = cls.get_message_type()
        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][message_type] = output_use_case_json
        return output_json
