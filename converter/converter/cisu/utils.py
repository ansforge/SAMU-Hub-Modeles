from typing import Any, Dict, List

from yaml import dump
from ..utils import concatenate_values, get_field_value, is_field_completed


def add_object_to_initial_alert_notes(json_data: Dict[str, Any], note_text: str):
    if not is_field_completed(json_data, "$.initialAlert.notes"):
        json_data["initialAlert"]["notes"] = []

    json_data["initialAlert"]["notes"].append({"freetext": note_text})


def add_field_to_initial_alert_notes(
    data: Dict[str, Any], path_and_label: Dict[str, str]
):
    field_value = get_field_value(data, path_and_label["path"])

    if field_value == None:
        return

    formatted_field_value = path_and_label["label"] + concatenate_values(field_value)
    add_object_to_initial_alert_notes(data, formatted_field_value)


def add_to_initial_alert_notes(data: Dict[str, Any], paths: List[Dict[str, str]]):
    for path in paths:
        add_field_to_initial_alert_notes(data, path)
