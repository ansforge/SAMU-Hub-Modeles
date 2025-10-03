import re
from typing import Any, Dict

from converter.utils import (
    add_to_medical_notes,
    delete_paths,
    get_field_value,
    is_field_completed,
    update_json_value,
)


def reverse_get(input_value: str, mapping_value: Dict[str, str]) -> str:
    for key, value in mapping_value.items():
        if value.upper() == input_value.upper():
            return key
    return input_value


def reverse_map_to_new_value(
    json_data: Dict[str, Any], json_path: str, mapping_value: Dict[str, str]
):
    current_value = get_field_value(json_data, json_path)

    if current_value != None:
        new_value = reverse_get(current_value, mapping_value)

        if new_value != current_value:
            update_json_value(json_data, json_path, new_value)


def switch_field_name(
    json_data: Dict[str, Any], previous_field_name: str, new_field_name: str
):
    if is_field_completed(json_data, "$." + previous_field_name) == True:
        json_data[new_field_name] = json_data[previous_field_name]


def validate_diagnosis_code(
    json_data: Dict[str, Any], patient_data: Dict[str, Any], diagnosis_type: str
):
    DIAGNOSIS_CODE_VALIDATION_REGEX = "^[A-Z]\\d{2}(\\.[\\d\\+\\-]{1,3})?$"
    diagnosis = get_field_value(patient_data, f"$.hypothesis.{diagnosis_type}")
    diagnosis_valid_codes = []

    pattern = re.compile(DIAGNOSIS_CODE_VALIDATION_REGEX)

    if diagnosis == None:
        return

    code_label = (
        "Diagnostique(s) secondaire(s) : "
        if diagnosis_type == "otherDiagnosis"
        else "Diagnostique principal : "
    )

    if type(diagnosis) is list:
        for index, diag in enumerate(diagnosis):
            code = get_field_value(diag, "$.code")
            if code != None:
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
        if code != None:
            is_correct_format = pattern.match(code)
            if not is_correct_format:
                add_to_medical_notes(
                    json_data,
                    patient_data,
                    [{"path": f"hypothesis.{diagnosis_type}", "label": code_label}],
                )
                delete_paths(patient_data, [f"hypothesis.{diagnosis_type}"])
