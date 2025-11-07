from converter.cisu.base_cisu_converter import BaseCISUConverter
from typing import Any, Dict

from converter.utils import get_field_value, set_value


class ResourcesInfoCISUConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesInfo"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesInfoCisu"

    @classmethod
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_cisu_input_content(edxl_json)
        output_use_case_json = cls.copy_cisu_input_use_case_content(edxl_json)
        resources = get_field_value(output_use_case_json, "$.resource")

        for resource in resources:
            state = get_field_value(resource, "$.state")
            set_value(resource, "$.state", [state])

        return cls.format_rs_output_json(output_json, output_use_case_json)
