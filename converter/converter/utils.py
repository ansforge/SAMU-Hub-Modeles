import random
import re
import string
from typing import List, Dict, Any, Optional
from jsonpath_ng import parse
from yaml import dump

from converter.constants import Constants


def get_recipient(edxl_json: Dict[str, Any]) -> str:
    return edxl_json["descriptor"]["explicitAddress"]["explicitAddressValue"]


def get_sender(edxl_json: Dict[str, Any]) -> str:
    return edxl_json["senderID"]


def delete_paths(data: Dict[str, Any], paths: List[str]) -> None:
    """
    Safely deletes keys in a dictionary based on dot-separated paths.

    Args:
        data: Dictionary to modify
        paths: List of dot-separated paths (e.g., "a.b.c")
    """

    def delete_recursively(d: Dict[str, Any], keys: List[str]) -> None:
        if not keys or not isinstance(d, (dict, list)):
            return

        key = keys[0]
        if key.endswith("[]"):  # Handle array notation
            key = key[:-2]  # Remove the array notation
            if key in d and isinstance(d[key], list):
                for item in d[key]:
                    if isinstance(item, dict):
                        delete_recursively(item, keys[1:])
        elif len(keys) == 1:
            # Delete target key if it exists
            if isinstance(d, dict):
                d.pop(key, None)
        else:
            # Recurse if intermediate key exists
            if key in d:
                delete_recursively(d[key], keys[1:])
                # Clean up empty dictionaries or lists
                if isinstance(d[key], (dict, list)) and not d[key]:
                    d.pop(key)

    for path in paths:
        delete_recursively(data, path.split("."))


def add_space_before_uppercase(text):
    # Add a space before each uppercase letter
    return re.sub(r"([A-Z])", r" \1", text).strip()


def format_object(obj: Any, indent: int = 0) -> str:
    """
    Recursively formats an object into a readable string.

    Args:
        obj: Object to format
        indent: Current indentation level (for recursion)

    Returns:
        Formatted string representation with proper indentation and structure
    """
    indent_str = "  " * indent

    if hasattr(obj, "__dict__"):  # Object with attributes
        attributes = vars(obj)
        if not attributes:
            return f"{indent_str}No attributes to display."

        formatted_lines = []

        # Add class name at root level
        if indent == 0:
            formatted_lines.append(
                f"{indent_str}{add_space_before_uppercase(obj.__class__.__name__)}:"
            )

        for field, value in attributes.items():
            if value is None:  # Skip None values
                continue

            if hasattr(value, "__dict__"):  # Nested object
                formatted_lines.append(
                    f"{indent_str}- {field.replace('_', ' ').title()}:"
                )
                formatted_lines.append(format_object(value, indent=indent + 1))
            else:  # Primitive value
                formatted_lines.append(
                    f"{indent_str}- {field.replace('_', ' ').title()}: {value}"
                )

        return "\n".join(formatted_lines)

    # Handle collections
    if isinstance(obj, list):
        return "\n".join(
            f"{indent_str}- {format_object(item, indent + 1).strip()}" for item in obj
        )
    elif isinstance(obj, dict):
        formatted_lines = []
        for key, value in obj.items():
            formatted_lines.append(f"{indent_str}- {key.replace('_', ' ').title()}:")
            formatted_lines.append(format_object(value, indent + 1))
        return "\n".join(formatted_lines)

    # Base case for primitives
    return f"{indent_str}{obj}"


def is_field_completed(json_data: Dict[str, Any], json_path: str):
    try:
        jsonpath_expr = parse(json_path)
        return len(jsonpath_expr.find(json_data)) >= 1
    except Exception as e:
        print(f"Error raised in is_field_completed : {e}")
        raise


def get_field_value(json_data: Dict[str, Any], json_path: str):
    try:
        if not is_field_completed(json_data, json_path):
            return None

        jsonpath_expr = parse(json_path)
        matches = jsonpath_expr.find(json_data)

        if len(matches) > 1:
            return [match.value for match in matches]
        return matches[0].value

    except Exception as e:
        print(f"Error raised in is_field_completed : {e}")
        raise


def concatenate_values(obj):
    result = ""
    DIVIDER = " "

    if isinstance(obj, dict):
        for value in obj.values():
            result += concatenate_values(value)
    elif isinstance(obj, (list, tuple, set)):
        for item in obj:
            result += concatenate_values(item)
    elif isinstance(obj, str):
        result += DIVIDER + obj

    return result


def translate_key_words(text, word_map):
    for key, value in word_map.items():
        text = text.replace(key, value)
    return text


# todo : reuse it where needed (+ add test)
def update_json_value(data, jsonpath_query, new_value):
    try:
        jsonpath_expr = parse(jsonpath_query)
        matches = jsonpath_expr.find(data)

        for match in matches:
            match.full_path.update(data, new_value)

    except Exception as e:
        print(f"Error raised in update_json_value: {e}")
        raise


def map_to_new_value(
    json_data: Dict[str, Any], json_path: str, mapping_value: Dict[str, str]
):
    current_value = get_field_value(json_data, json_path)

    if current_value is not None and current_value in mapping_value:
        new_value = mapping_value.get(current_value, current_value)
        update_json_value(json_data, json_path, new_value)


def add_to_medical_notes(
    json_data: Dict[str, Any],
    patient: Optional[Dict[str, Any]],
    paths_and_labels: List[Dict[str, str]],
):
    if not is_field_completed(json_data, "$.medicalNote"):
        json_data["medicalNote"] = []

    for path_and_label in paths_and_labels:
        add_field_to_medical_notes(json_data, patient, path_and_label)


def add_field_to_medical_notes(
    data: Dict[str, Any],
    patient: Optional[Dict[str, Any]],
    path_and_label: Dict[str, str],
):
    if patient is not None:
        field_value = get_field_value(patient, f"$.{path_and_label['path']}")
    else:
        field_value = get_field_value(data, f"$.{path_and_label['path']}")

    if field_value is None:
        return

    formatted_field_value = path_and_label["label"] + dump(
        field_value, allow_unicode=True
    )
    output_text = translate_key_words(
        formatted_field_value, Constants.MEDICAL_NOTE_KEY_TRANSLATIONS
    )
    add_object_to_medical_notes(data, patient, output_text)


def add_object_to_medical_notes(
    json_data: Dict[str, Any], patient: Optional[Dict[str, Any]], note_text: str
):
    MEDICAL_NOTE_RANDOM_ID_LENGTH = 7
    random_str = "".join(
        random.choices(
            string.ascii_lowercase + string.digits, k=MEDICAL_NOTE_RANDOM_ID_LENGTH
        )
    )

    if patient and "patientId" in patient:
        patient_id = patient["patientId"]
        patient_id_parts = patient_id.split(".")
        health_service_id = ".".join(patient_id_parts[:3])  # -> fr.health.samuXXX
        medical_note_id = f"{health_service_id}.medicalNote.{random_str}"
        new_note = {
            "patientId": patient_id,
            "medicalNoteId": medical_note_id,
            "freetext": note_text,
            "operator": {"role": "AUTRE"},
        }

    else:
        medical_note_id = f"{json_data['owner']}.medicalNote.{random_str}"
        new_note = {
            "medicalNoteId": medical_note_id,
            "freetext": note_text,
            "operator": {"role": "AUTRE"},
        }

    json_data["medicalNote"].append(new_note)
