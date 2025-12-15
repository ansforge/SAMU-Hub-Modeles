import logging
from typing import Any, Dict, Optional

from converter.utils import (
    get_field_value,
    is_field_completed,
    update_json_value,
    delete_paths,
    set_value,
)

logger = logging.getLogger(__name__)


def reverse_get(input_value: str, mapping_value: Dict[str, str]) -> str:
    for key, value in mapping_value.items():
        if value.upper() == input_value.upper():
            return key
    return input_value


def reverse_map_to_new_value(
    json_data: Dict[str, Any], json_path: str, mapping_value: Dict[str, str]
):
    current_value = get_field_value(json_data, json_path)

    if current_value is not None:
        new_value = reverse_get(current_value, mapping_value)

        if new_value != current_value:
            update_json_value(json_data, json_path, new_value)


def switch_field_name(
    json_data: Dict[str, Any], previous_field_path: str, new_field_path: str
):
    if is_field_completed(json_data, previous_field_path):
        value = get_field_value(json_data, previous_field_path)
        logger.info(
            "Transforming field name from %s to %s",
            previous_field_path,
            new_field_path,
        )
        set_value(json_data, new_field_path, value)
        delete_paths(json_data, [previous_field_path])


def convert_to_float(value: Optional[str]) -> Optional[float]:
    if value is None:
        return None
    try:
        return float(value)
    except ValueError:
        return None


def convert_to_str(value: float) -> Optional[str]:
    if value is None:
        return None
    return str(value)
