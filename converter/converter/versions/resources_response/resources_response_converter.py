from typing import Dict, Any

from converter.utils import get_field_value, set_value
from converter.versions.identical_message_converter import IdenticalMessageConverter
from converter.versions.resources_response.resources_response_constants import (
    ResourcesResponseConstants,
)


class ResourcesResponseConverter(IdenticalMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesResponse"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        deadline = get_field_value(
            output_use_case_json, ResourcesResponseConstants.RESPONSE_DEADLINE_PATH
        )
        if (
            deadline is not None
            and deadline not in ResourcesResponseConstants.V2_VALID_DEADLINES
        ):
            set_value(
                output_use_case_json,
                ResourcesResponseConstants.RESPONSE_DEADLINE_PATH,
                ResourcesResponseConstants.V2_DEFAULT_DEADLINE,
            )

        return cls.format_output_json(output_json, output_use_case_json)
