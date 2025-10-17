from typing import Dict, Any

from converter.utils import get_field_value, update_json_value, map_to_new_value
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.intervention_report.intervention_report_constants import (
    InterventionReportConstants,
)


class InterventionReportConverter(ConversionMixin):
    @staticmethod
    def get_message_type():
        return "interventionReport"

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        value = get_field_value(
            output_use_case_json, InterventionReportConstants.ASSOCIATED_DIAGNOSIS_PATH
        )
        if value is not None:
            update_json_value(
                output_use_case_json,
                InterventionReportConstants.ASSOCIATED_DIAGNOSIS_PATH,
                [value],
            )

        external_ids = get_field_value(
            output_use_case_json, InterventionReportConstants.EXTERNAL_ID_PATH
        )
        for external_id in external_ids:
            map_to_new_value(
                external_id,
                InterventionReportConstants.EXTERNAL_ID_SOURCE_PATH,
                InterventionReportConstants.V2_TO_V3_EXTERNAL_ID_SOURCE_MAPPING,
            )
        update_json_value(
            output_use_case_json,
            InterventionReportConstants.EXTERNAL_ID_PATH,
            external_ids,
        )

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        return cls.format_output_json(output_json, output_use_case_json)
