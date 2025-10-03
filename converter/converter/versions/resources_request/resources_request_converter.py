import copy
from typing import Dict, Any

from converter.utils import map_to_new_value
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.identical_message_converter import IdenticalMessageConverter
from converter.versions.resources_request.resources_request_constants import (
    ResourcesRequestConstants,
)
from converter.versions.utils import reverse_map_to_new_value


class ResourcesRequestConverter(IdenticalMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesRequest"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            "$.request.deadline",
            ResourcesRequestConstants.V1_TO_V2_DEADLINE_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            "$.request.deadline",
            ResourcesRequestConstants.V1_TO_V2_DEADLINE_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)
