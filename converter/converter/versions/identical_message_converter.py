from typing import Dict, Any

from converter.versions.base_message_converter import BaseMessageConverter


class IdenticalMessageConverter(BaseMessageConverter):
    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        return input_json

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        return input_json
