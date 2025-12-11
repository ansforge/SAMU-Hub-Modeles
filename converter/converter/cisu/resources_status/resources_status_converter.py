from typing import Dict, Any

from converter.cisu.base_cisu_converter import BaseCISUConverter


class ResourcesStatusConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesStatus"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesStatusCisu"

    @classmethod
    def from_rs_to_cisu(cls, edxl_json) -> Dict[str, Any]:
        output_json = cls.copy_rs_input_content(edxl_json)
        output_use_case_json = cls.copy_rs_input_use_case_content(edxl_json)
        return cls.format_cisu_output_json(output_json, output_use_case_json)

    @classmethod
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_cisu_input_content(edxl_json)
        output_use_case_json = cls.copy_cisu_input_use_case_content(edxl_json)
        return cls.format_rs_output_json(output_json, output_use_case_json)
