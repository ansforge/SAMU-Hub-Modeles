from typing import Any, Dict, List

from yaml import dump
from ..utils import is_field_completed, get_field_value


def add_field_to_initial_alert_notes(data: Dict[str, Any], json_path: str):
    field_value = get_field_value(data,json_path)

    if field_value == None:
        return

    formatted_field_value = dump(field_value, allow_unicode=True)
    add_object_to_initial_alert_notes(data, formatted_field_value)


def add_to_initial_alert_notes(data: Dict[str, Any], paths: List[str]):
    for path in paths:
        add_field_to_initial_alert_notes(data, path)

def add_object_to_initial_alert_notes(json_data: Dict[str, Any], note_text: str):
    if not is_field_completed(json_data, '$.initialAlert.notes'):
        json_data['initialAlert']['notes'] = []

    json_data['initialAlert']['notes'].append({"freetext": note_text})
