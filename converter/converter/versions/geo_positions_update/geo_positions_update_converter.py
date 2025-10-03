from typing import Dict, Any

from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.conversion_mixin import ConversionMixin


class GeoPositionsUpdateConverter(BaseMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "geoPositionsUpdate"

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)
        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)
        return cls.format_output_json(output_json, output_use_case_json)
