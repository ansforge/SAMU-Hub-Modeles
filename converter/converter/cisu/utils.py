from typing import Any, Dict, List
import csv
import os

from yaml import dump

from converter.cisu.constants import Constants
from ..utils import concatenate_values, get_field_value, is_field_completed

def add_object_to_initial_alert_notes(json_data: Dict[str, Any], note_text: str):
    if not is_field_completed(json_data, '$.initialAlert.notes'):
        json_data['initialAlert']['notes'] = []

    json_data['initialAlert']['notes'].append({"freetext": note_text})

def add_field_to_initial_alert_notes(data: Dict[str, Any], path_and_label: Dict[str, str]):
    field_value = get_field_value(data,path_and_label['path'])

    if field_value == None:
        return

    formatted_field_value = path_and_label['label']+ concatenate_values(field_value)
    add_object_to_initial_alert_notes(data, formatted_field_value)


def add_to_initial_alert_notes(data: Dict[str, Any], paths: List[Dict[str, str]]):
    for path in paths:
        add_field_to_initial_alert_notes(data, path)

def find_in_cisu_nomenclature(search_value: str, search_columns: list, return_column: str, filename: str) -> str:
    file_path = os.path.join(os.path.dirname(__file__), filename)
    with open(file_path, newline='', encoding='utf-8') as csvfile:
        reader = csv.DictReader(csvfile, delimiter=Constants.CSV_DELIMITER)
        for row in reader:
            for col in search_columns:
                if row.get(col, '').strip() == search_value:
                    return row.get(return_column)
    return None

def get_deprecated_code_cisu_from_health_motive(health_motive_code: str) -> str:
    return find_in_cisu_nomenclature(
        health_motive_code,
        [Constants.MR0_LABEL, Constants.MR1_LABEL],
        Constants.OLD_MR_LABEL,
        Constants.MRSM_CISU_UPDATED_NOMENCLATURE_FILE
    )

def get_code_cisu_mr0_from_health_motive(health_motive_code: str) -> str:
    return find_in_cisu_nomenclature(
        health_motive_code,
        [Constants.OLD_MR_LABEL],
        Constants.MR0_LABEL,
        Constants.MRSM_CISU_UPDATED_NOMENCLATURE_FILE
    )

def update_health_motive_code(json_data: Dict[str, Any], isCodeDeprecated: bool):
    health_motive_code = get_field_value(json_data, '$.qualification.healthMotive.code')

    if health_motive_code is not None:
        if isCodeDeprecated:
            updated_health_motive_code = get_deprecated_code_cisu_from_health_motive(health_motive_code)
        else:
            updated_health_motive_code = get_code_cisu_mr0_from_health_motive(health_motive_code)

        if updated_health_motive_code is not None:
            json_data['qualification']['healthMotive'] = {
                'code': updated_health_motive_code,
                'label': get_field_value(json_data, '$.qualification.healthMotive.label')
            }
