from typing import Any, Dict, Optional

from converter.utils import delete_paths, get_field_value, set_value


def apply_nomenclature_mapping(
    json_data: Dict[str, Any],
    field_path: str,
    mapping: Dict[str, Optional[Dict[str, str]]],
) -> None:
    """
    Looks up json_data[field_path].code in the given nomenclature mapping and
    updates json_data accordingly:
      - no entry for the code: json_data is left untouched
      - entry maps to a dict: the field at field_path is replaced by that dict
      - entry maps to None: the field at field_path is removed
    """
    code = get_field_value(json_data, f"{field_path}.code")
    if code is None or code not in mapping:
        return

    new_value = mapping[code]
    if new_value is None:
        delete_paths(json_data, [field_path])
    else:
        set_value(json_data, field_path, new_value)


def apply_nomenclature_mapping_to_list(
    json_data: Dict[str, Any],
    field_path: str,
    mapping: Dict[str, Optional[Dict[str, str]]],
) -> None:
    """
    Same semantics as apply_nomenclature_mapping, applied item by item to the
    array field at field_path:
      - an item's code has no entry in mapping: the item is left untouched
      - entry maps to a dict: the item is replaced by that dict
      - entry maps to None: the item is removed from the array
    If the array ends up empty, the field itself is removed.
    """
    items = get_field_value(json_data, field_path)
    if not isinstance(items, list):
        return

    updated_items = []
    for item in items:
        code = item.get("code") if isinstance(item, dict) else None
        if code is None or code not in mapping:
            updated_items.append(item)
            continue

        new_value = mapping[code]
        if new_value is not None:
            updated_items.append(new_value)

    if updated_items:
        set_value(json_data, field_path, updated_items)
    else:
        delete_paths(json_data, [field_path])
