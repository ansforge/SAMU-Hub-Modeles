from converter.utils import map_to_new_value, get_field_value, update_json_value
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.identical_message_converter import IdenticalMessageConverter
from converter.versions.resources_engagement.resources_engagement_constants import (
    ResourcesEngagementConstants,
)


class ResourcesEngagementConverter(IdenticalMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesEngagement"

    @classmethod
    def convert_v3_to_v2(cls, input_json):
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)
        map_to_new_value(
            output_use_case_json,
            "$.resourcesEngagement.resource.team.medicalLevel",
            ResourcesEngagementConstants.V3_TO_V2_MEDICAL_LEVEL_MAPPING,
        )
        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v3(cls, input_json):
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        vehicle_type_path = "$.resourcesEngagement.resource.vehicleType"
        vehicle_type = get_field_value(output_use_case_json, vehicle_type_path)
        if vehicle_type is None:
            update_json_value(
                output_use_case_json,
                vehicle_type_path,
                ResourcesEngagementConstants.V3_DEFAULT_VEHICLE_TYPE,
            )

        return cls.format_output_json(output_json, output_use_case_json)
