from converter.cisu_transcoders.identical_cisu_converter import IdenticalCISUConverter
from converter.cisu_transcoders.reference.reference_cisu_constants import (
    ReferenceCISUConstants,
)
from converter.utils import delete_paths


class ReferenceConverter(IdenticalCISUConverter):
    REFERENCE_MESSAGE_TYPE = "reference"

    @classmethod
    def get_rs_message_type(cls) -> str:
        return cls.REFERENCE_MESSAGE_TYPE

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return cls.REFERENCE_MESSAGE_TYPE

    @classmethod
    def from_rs_to_cisu(cls, edxl_json):
        output_json = cls.copy_rs_input_content(edxl_json)
        output_use_case_json = cls.copy_rs_input_use_case_content(edxl_json)

        delete_paths(output_use_case_json, ReferenceCISUConstants.CISU_PATHS_TO_DELETE)

        return cls.format_cisu_output_json(output_json, output_use_case_json)
