from typing import Dict, Any

from converter.utils import get_field_value, update_json_value, map_to_new_value
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.intervention_report.intervention_report_constants import (
    InterventionReportConstants,
)
from converter.versions.utils import reverse_map_to_new_value


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

    @staticmethod
    def add_to_evaluation_freetext(
        input_json: Dict[str, Any], text_to_add: str
    ) -> None:
        freetext = get_field_value(
            input_json, InterventionReportConstants.EVALUATION_FREETEXT_PATH
        )
        if freetext is not None:
            freetext.append(text_to_add)

    @classmethod
    def update_redactor_role_v3_to_v2(cls, input_json: Dict[str, Any]) -> None:
        redactor_role = get_field_value(
            input_json, InterventionReportConstants.REDACTOR_ROLE_PATH
        )
        if redactor_role in InterventionReportConstants.V3_TO_V2_REDACTOR_ROLE_MAPPING:
            cls.add_to_evaluation_freetext(
                input_json,
                f"Rôle du rédacteur: {redactor_role}",
            )

        map_to_new_value(
            input_json,
            InterventionReportConstants.REDACTOR_ROLE_PATH,
            InterventionReportConstants.V3_TO_V2_REDACTOR_ROLE_MAPPING,
        )

    @classmethod
    def update_associated_diagnosis_v3_to_v2(cls, input_json: Dict[str, Any]) -> None:
        associated_diagnosis = get_field_value(
            input_json, InterventionReportConstants.ASSOCIATED_DIAGNOSIS_PATH
        )
        if associated_diagnosis is not None and len(associated_diagnosis) > 0:
            update_json_value(
                input_json,
                InterventionReportConstants.ASSOCIATED_DIAGNOSIS_PATH,
                associated_diagnosis[0],
            )
            if len(associated_diagnosis) > 1:
                remaining_associated_diagnosis_formatted = ", ".join(
                    associated_diagnosis[1:]
                )
                cls.add_to_evaluation_freetext(
                    input_json,
                    f"Diagnostic(s) associé(s) supplémentaire(s): {remaining_associated_diagnosis_formatted}",
                )

    @classmethod
    def update_evaluation_parameter_v3_to_v2(cls, input_json: Dict[str, Any]) -> None:
        evaluation_parameters = get_field_value(
            input_json, InterventionReportConstants.EVALUATION_PARAMETER_PATH
        )

        for parameter in evaluation_parameters:
            precision = parameter.pop(
                InterventionReportConstants.EVALUATION_PARAMETER_PRECISION_KEY, None
            )
            if precision is not None:
                parameter_type = parameter.get(
                    InterventionReportConstants.EVALUATION_PARAMETER_TYPE_KEY, ""
                )
                cls.add_to_evaluation_freetext(
                    input_json,
                    f"Précision du paramètre {parameter_type}: {precision}",
                )

    @classmethod
    def update_external_ids_v3_to_v2(cls, input_json: Dict[str, Any]) -> None:
        external_ids = get_field_value(
            input_json, InterventionReportConstants.EXTERNAL_ID_PATH
        )

        for external_id in external_ids:
            source = external_id.get(
                InterventionReportConstants.EXTERNAL_ID_SOURCE_KEY, None
            )
            if (
                source
                in InterventionReportConstants.V2_TO_V3_EXTERNAL_ID_SOURCE_MAPPING.values()
            ):
                value = external_id.get(
                    InterventionReportConstants.EXTERNAL_ID_VALUE_KEY, ""
                )
                cls.add_to_evaluation_freetext(
                    input_json,
                    f"Source de l'identifiant externe patient {value}: {source}",
                )

            reverse_map_to_new_value(
                external_id,
                InterventionReportConstants.EXTERNAL_ID_SOURCE_PATH,
                InterventionReportConstants.V2_TO_V3_EXTERNAL_ID_SOURCE_MAPPING,
            )

        update_json_value(
            input_json,
            InterventionReportConstants.EXTERNAL_ID_PATH,
            external_ids,
        )

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        cls.update_redactor_role_v3_to_v2(output_use_case_json)

        cls.update_associated_diagnosis_v3_to_v2(output_use_case_json)

        cls.update_evaluation_parameter_v3_to_v2(output_use_case_json)

        cls.update_external_ids_v3_to_v2(output_use_case_json)

        return cls.format_output_json(output_json, output_use_case_json)
