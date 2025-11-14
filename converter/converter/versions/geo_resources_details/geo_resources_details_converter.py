from typing import Dict, Any

from converter.utils import get_field_value, map_to_new_value, update_json_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.geo_resources_details.geo_resources_details_constants import (
    GeoResourcesDetailsConstants,
)
from converter.versions.utils import reverse_map_to_new_value


class GeoResourcesDetailsConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "geoResourcesDetails"

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        resources = get_field_value(
            output_use_case_json, GeoResourcesDetailsConstants.RESOURCE_PATH
        )
        for resource in resources:
            reverse_map_to_new_value(
                resource,
                GeoResourcesDetailsConstants.MOBILITY_PATH,
                GeoResourcesDetailsConstants.V3_TO_V2_MOBILITY_MAPPING,
            )
        update_json_value(
            output_use_case_json, GeoResourcesDetailsConstants.RESOURCE_PATH, resources
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        resources = get_field_value(
            output_use_case_json, GeoResourcesDetailsConstants.RESOURCE_PATH
        )
        for resource in resources:
            map_to_new_value(
                resource,
                GeoResourcesDetailsConstants.MOBILITY_PATH,
                GeoResourcesDetailsConstants.V3_TO_V2_MOBILITY_MAPPING,
            )
        update_json_value(
            output_use_case_json, GeoResourcesDetailsConstants.RESOURCE_PATH, resources
        )

        return cls.format_output_json(output_json, output_use_case_json)
