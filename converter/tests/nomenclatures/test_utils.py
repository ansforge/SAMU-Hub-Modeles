from converter.nomenclatures.utils import (
    apply_nomenclature_mapping,
    apply_nomenclature_mapping_to_list,
)


def test_no_entry_for_code_leaves_json_untouched():
    json_data = {"qualification": {"whatsHappen": {"code": "UNKNOWN", "label": "X"}}}
    mapping = {"C11.06.00": {"code": "C99.00.00", "label": "Autre"}}

    apply_nomenclature_mapping(json_data, "$.qualification.whatsHappen", mapping)

    assert json_data["qualification"]["whatsHappen"] == {
        "code": "UNKNOWN",
        "label": "X",
    }


def test_entry_with_value_replaces_field():
    json_data = {"qualification": {"whatsHappen": {"code": "C11.06.00", "label": "X"}}}
    mapping = {"C11.06.00": {"code": "C99.00.00", "label": "Autre nature de fait"}}

    apply_nomenclature_mapping(json_data, "$.qualification.whatsHappen", mapping)

    assert json_data["qualification"]["whatsHappen"] == {
        "code": "C99.00.00",
        "label": "Autre nature de fait",
    }


def test_entry_with_none_value_removes_field():
    json_data = {
        "qualification": {
            "healthMotive": {"code": "R36", "label": "X"},
            "whatsHappen": {"code": "C11.06.00", "label": "Y"},
        }
    }
    mapping = {"R36": None}

    apply_nomenclature_mapping(json_data, "$.qualification.healthMotive", mapping)

    assert "healthMotive" not in json_data["qualification"]
    assert json_data["qualification"]["whatsHappen"] == {
        "code": "C11.06.00",
        "label": "Y",
    }


def test_field_absent_is_a_noop():
    json_data = {"qualification": {}}
    mapping = {"C11.06.00": {"code": "C99.00.00", "label": "Autre"}}

    apply_nomenclature_mapping(json_data, "$.qualification.whatsHappen", mapping)

    assert json_data == {"qualification": {}}


def test_list_item_with_no_map_entry_is_untouched():
    unmapped = {"code": "R99", "label": "X"}
    json_data = {"qualification": {"riskThreat": [unmapped]}}
    mapping = {"R36": None}

    apply_nomenclature_mapping_to_list(json_data, "$.qualification.riskThreat", mapping)

    assert json_data["qualification"]["riskThreat"] == [unmapped]


def test_list_item_with_value_entry_is_replaced_in_place():
    json_data = {
        "qualification": {
            "riskThreat": [
                {"code": "R17", "label": "X"},
                {"code": "R99", "label": "Y"},
            ]
        }
    }
    mapping = {"R17": {"code": "R37", "label": "Situation instable/indéterminée"}}

    apply_nomenclature_mapping_to_list(json_data, "$.qualification.riskThreat", mapping)

    assert json_data["qualification"]["riskThreat"] == [
        {"code": "R37", "label": "Situation instable/indéterminée"},
        {"code": "R99", "label": "Y"},
    ]


def test_list_item_with_none_entry_is_removed_but_others_kept():
    unmapped = {"code": "R99", "label": "Y"}
    json_data = {
        "qualification": {"riskThreat": [{"code": "R36", "label": "X"}, unmapped]}
    }
    mapping = {"R36": None}

    apply_nomenclature_mapping_to_list(json_data, "$.qualification.riskThreat", mapping)

    assert json_data["qualification"]["riskThreat"] == [unmapped]


def test_list_becomes_empty_removes_field_entirely():
    json_data = {
        "qualification": {"riskThreat": [{"code": "R36", "label": "X"}]},
        "otherField": "kept",
    }
    mapping = {"R36": None}

    apply_nomenclature_mapping_to_list(json_data, "$.qualification.riskThreat", mapping)

    assert "qualification" not in json_data
    assert json_data["otherField"] == "kept"


def test_list_field_absent_is_a_noop():
    json_data = {"qualification": {}}
    mapping = {"R36": None}

    apply_nomenclature_mapping_to_list(json_data, "$.qualification.riskThreat", mapping)

    assert json_data == {"qualification": {}}
