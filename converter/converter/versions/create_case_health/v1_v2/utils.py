from converter.versions.create_case_health.constants import Constants
from converter.utils import get_field_value, map_to_new_value, delete_paths
import re
from typing import Any, Dict

from converter.utils import (
    add_to_medical_notes,
)
from converter.versions.create_case_health.v1_v2.constants import V1V2Constants


def validate_diagnosis_code(
    json_data: Dict[str, Any], patient_data: Dict[str, Any], diagnosis_type: str
):
    diagnosis = get_field_value(patient_data, f"$.hypothesis.{diagnosis_type}")
    diagnosis_valid_codes = []

    pattern = re.compile(V1V2Constants.DIAGNOSIS_CODE_VALIDATION_REGEX)

    if diagnosis is None:
        return

    code_label = (
        "Diagnostique(s) secondaire(s) : "
        if diagnosis_type == "otherDiagnosis"
        else "Diagnostique principal : "
    )

    if type(diagnosis) is list:
        for index, diag in enumerate(diagnosis):
            code = get_field_value(diag, "$.code")
            if code is not None:
                is_correct_format = pattern.match(code)
                if not is_correct_format:
                    add_to_medical_notes(
                        json_data,
                        patient_data,
                        [
                            {
                                "path": f"hypothesis.{diagnosis_type}[{index}]",
                                "label": code_label,
                            }
                        ],
                    )
                else:
                    diagnosis_valid_codes.append(diag)

        if len(diagnosis_valid_codes) == 0:  # no code matches the pattern
            delete_paths(patient_data, [f"hypothesis.{diagnosis_type}"])
        else:
            patient_data["hypothesis"]["otherDiagnosis"] = diagnosis_valid_codes

    else:
        code = get_field_value(diagnosis, "$.code")
        if code is not None:
            is_correct_format = pattern.match(code)
            if not is_correct_format:
                add_to_medical_notes(
                    json_data,
                    patient_data,
                    [{"path": f"hypothesis.{diagnosis_type}", "label": code_label}],
                )
                delete_paths(patient_data, [f"hypothesis.{diagnosis_type}"])


def update_language(message: Dict[str, Any], language_map: Dict[str, str]) -> None:
    language = get_field_value(message, Constants.INITIAL_ALERT_CALLER_LANGUAGE_PATH)
    if language in language_map:
        map_to_new_value(
            message,
            Constants.INITIAL_ALERT_CALLER_LANGUAGE_PATH,
            language_map,
        )
    else:
        delete_paths(message, [Constants.INITIAL_ALERT_CALLER_LANGUAGE_KEY])
