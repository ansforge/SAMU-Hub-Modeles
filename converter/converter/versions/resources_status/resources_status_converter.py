from typing import Dict, Any

from converter.utils import delete_paths, get_field_value, map_to_new_value
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.resources_status.resources_status_constants import (
    ResourcesStatusConstants,
)
from converter.versions.utils import reverse_map_to_new_value


class ResourcesStatusConverter(ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesStatus"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            "$.status",
            ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING,
        )

        datetime = get_field_value(output_use_case_json, "$.datetime")
        status = get_field_value(output_use_case_json, "$.status")
        availability = get_field_value(output_use_case_json, "$.availability")

        output_use_case_json["state"] = {}
        output_use_case_json["state"]["datetime"] = datetime
        output_use_case_json["state"]["status"] = status

        if availability is not None:
            output_use_case_json["state"]["availability"] = availability

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, ResourcesStatusConstants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            "$.state.status",
            ResourcesStatusConstants.V1_TO_V2_STATUS_MAPPING,
        )

        state = get_field_value(output_use_case_json, "$.state")
        if state:
            output_use_case_json.update(state)

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, ResourcesStatusConstants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            "$.state.status",
            ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            "$.state.status",
            ResourcesStatusConstants.V3_TO_V2_STATUS_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)
