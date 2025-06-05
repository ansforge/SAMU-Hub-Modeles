from typing import Dict, Any

from converter.versions.base_message_converter import BaseMessageConverter

class ReferenceConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "reference"

    @classmethod
    def convert_v1_to_v2(self, input_json) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v2_to_v1(self, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v2_to_v3(self, input_json) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v3_to_v2(self, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json
