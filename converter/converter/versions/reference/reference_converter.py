from converter.utils import delete_paths
from converter.versions.identical_message_converter import IdenticalMessageConverter
from converter.versions.reference.reference_constants import ReferenceConstants


class ReferenceConverter(IdenticalMessageConverter):
    @staticmethod
    def get_message_type():
        return "reference"

    @classmethod
    def convert_v3_to_v2(cls, input_json):
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        delete_paths(output_use_case_json, ReferenceConstants.V3_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)
