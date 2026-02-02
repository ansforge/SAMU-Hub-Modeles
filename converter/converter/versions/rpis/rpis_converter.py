from typing import Dict, Any

from converter.utils import map_to_new_value, update_json_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.rpis.rpis_constants import RpisConstants
from converter.versions.utils import reverse_map_to_new_value


class RpisConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "rpis"

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        reverse_map_to_new_value(
            output_use_case_json,
            RpisConstants.RESOURCE_TYPE_PATH,
            RpisConstants.V3_TO_V2_RESOURCE_TYPE_MAPPING,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(
            output_use_case_json,
            RpisConstants.REGULATION_MEDICAL_LEVEL_PATH,
            RpisConstants.V3_TO_V2_MEDICAL_LEVEL_MAPPING,
        )

        map_to_new_value(
            output_use_case_json,
            RpisConstants.ORIENTATION_MEDICAL_LEVEL_PATH,
            RpisConstants.V3_TO_V2_MEDICAL_LEVEL_MAPPING,
        )

        map_to_new_value(
            output_use_case_json,
            RpisConstants.RESOURCE_TYPE_PATH,
            RpisConstants.V3_TO_V2_RESOURCE_TYPE_MAPPING,
        )

        # Map v2 codes to v1.18 fallback values
        update_json_value(
            output_use_case_json,
            RpisConstants.WHATS_HAPPEN_CODE_PATH,
            RpisConstants.WHATS_HAPPEN_FALLBACK,
        )

        update_json_value(
            output_use_case_json,
            RpisConstants.HEALTH_MOTIVE_CODE_PATH,
            RpisConstants.HEALTH_MOTIVE_FALLBACK,
        )

        update_json_value(
            output_use_case_json,
            RpisConstants.LOCATION_TYPE_PATH,
            RpisConstants.LOCATION_FALLBACK,
        )

        return cls.format_output_json(output_json, output_use_case_json)
