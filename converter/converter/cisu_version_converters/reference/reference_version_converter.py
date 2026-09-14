from typing import Any, Dict

from converter.cisu_transcoders.reference.reference_cisu_constants import (
    ReferenceCISUConstants,
)
from converter.cisu_version_converters.base_cisu_version_converter import (
    BaseCISUVersionConverter,
)
from converter.utils import delete_paths


class ReferenceCISUVersionConverter(BaseCISUVersionConverter):
    @classmethod
    def get_message_type(cls) -> str:
        return "reference"

    @classmethod
    def convert_v3_to_vactive(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(edxl_json)
        output_use_case_json = cls.copy_input_use_case_content(edxl_json)

        delete_paths(output_use_case_json, ReferenceCISUConstants.CISU_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_vactive_to_v3(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(edxl_json)
        output_use_case_json = cls.copy_input_use_case_content(edxl_json)

        delete_paths(output_use_case_json, ReferenceCISUConstants.CISU_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)
