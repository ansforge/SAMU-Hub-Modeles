"""
Integration tests exercising CreateCaseCISUConverter.from_cisu_to_rs / from_rs_to_cisu
end-to-end against real nomenclature map entries, for the qualification.whatsHappen,
qualification.healthMotive, qualification.riskThreat and qualification.locationKind
fields. Complements the unit tests in tests/nomenclatures/test_utils.py (which cover
apply_nomenclature_mapping/apply_nomenclature_mapping_to_list in isolation) by proving
the maps are actually wired into the converter and that real fixture-shaped messages
produce the expected replace/remove behaviour.
"""

import copy

from converter.cisu_transcoders.create_case.create_case_cisu_converter import (
    CreateCaseCISUConverter,
)
from tests.cisu.helpers import get_edxl_message
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

RC_EDA_BASE = TestHelper.load_json_file(
    "tests/fixtures/RC-EDA/RC-EDA_required_fields.json"
)
RS_EDA_BASE = TestHelper.load_json_file(
    "tests/fixtures/RS-EDA/cisu_case/RS-EDA_required_fields.json"
)


def cisu_to_rs_message(qualification_overrides: dict) -> dict:
    content = copy.deepcopy(RC_EDA_BASE)
    content["createCase"]["qualification"].update(qualification_overrides)
    edxl = TestHelper.combine_edxl_envelope_and_message(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, content
    )
    result = CreateCaseCISUConverter.from_cisu_to_rs(edxl)
    return get_edxl_message(result)["createCaseHealth"]["qualification"]


def rs_to_cisu_message(qualification_overrides: dict) -> dict:
    content = copy.deepcopy(RS_EDA_BASE)
    content["createCaseHealth"]["qualification"].update(qualification_overrides)
    edxl = TestHelper.combine_edxl_envelope_and_message(
        TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, content
    )
    result = CreateCaseCISUConverter.from_rs_to_cisu(edxl)
    return get_edxl_message(result)["createCase"]["qualification"]


# --- from_cisu_to_rs: code has no entry in the map -> field untouched ---


def test_from_cisu_to_rs_whats_happen_unmapped_code_is_untouched():
    unmapped = {"code": "C99.99.99", "label": "Code inconnu"}
    qualification = cisu_to_rs_message({"whatsHappen": unmapped})
    assert qualification["whatsHappen"] == unmapped


# --- from_cisu_to_rs: code has a non-None entry -> field replaced ---


def test_from_cisu_to_rs_whats_happen_mapped_code_is_replaced():
    qualification = cisu_to_rs_message(
        {"whatsHappen": {"code": "C02.05.03", "label": "Menace de suicide"}}
    )
    assert qualification["whatsHappen"] == {
        "code": "C02.18.00",
        "label": "Problème psychiatrique, menace de suicide",
    }


def test_from_cisu_to_rs_health_motive_mapped_code_is_replaced():
    qualification = cisu_to_rs_message(
        {"healthMotive": {"code": "M20.00", "label": "Inconscience"}}
    )
    assert qualification["healthMotive"] == {
        "code": "M08.00.00",
        "label": "Personne inconsciente ",
    }


def test_from_cisu_to_rs_location_kind_mapped_code_is_replaced():
    qualification = cisu_to_rs_message(
        {
            "locationKind": {
                "code": "L02.02.04",
                "label": "Aire de repos sur voie rapide",
            }
        }
    )
    assert qualification["locationKind"] == {
        "code": "L02.02.03",
        "label": "Aire de repos ou de service sur voie rapide",
    }


# --- from_cisu_to_rs: riskThreat is an array -> per-item behaviour ---


def test_from_cisu_to_rs_risk_threat_mapped_to_none_removes_item_and_field():
    qualification = cisu_to_rs_message(
        {"riskThreat": [{"code": "R36", "label": "Menace"}]}
    )
    assert "riskThreat" not in qualification


def test_from_cisu_to_rs_risk_threat_removes_only_the_none_mapped_item():
    unmapped = {"code": "R99", "label": "Autre menace"}
    qualification = cisu_to_rs_message(
        {"riskThreat": [{"code": "R36", "label": "Menace"}, unmapped]}
    )
    assert qualification["riskThreat"] == [unmapped]


# --- from_rs_to_cisu: same three cases, using the reverse maps ---


def test_from_rs_to_cisu_whats_happen_unmapped_code_is_untouched():
    unmapped = {"code": "C99.99.99", "label": "Code inconnu"}
    qualification = rs_to_cisu_message({"whatsHappen": unmapped})
    assert qualification["whatsHappen"] == unmapped


def test_from_rs_to_cisu_whats_happen_mapped_code_is_replaced():
    qualification = rs_to_cisu_message(
        {"whatsHappen": {"code": "C02.17.00", "label": "Mort suspecte/cadavre"}}
    )
    assert qualification["whatsHappen"] == {
        "code": "C10.02.01",
        "label": "Mort suspecte",
    }


def test_from_rs_to_cisu_health_motive_mapped_code_is_replaced():
    qualification = rs_to_cisu_message(
        {"healthMotive": {"code": "M08.00.00", "label": "Personne inconsciente"}}
    )
    assert qualification["healthMotive"] == {
        "code": "M22.00",
        "label": "Personne inconsciente",
    }


def test_from_rs_to_cisu_location_kind_mapped_code_is_replaced():
    qualification = rs_to_cisu_message(
        {"locationKind": {"code": "L01.01.05", "label": "Pavillon"}}
    )
    assert qualification["locationKind"] == {
        "code": "L01.01.00",
        "label": "Maison particulière, pavillon",
    }


def test_from_rs_to_cisu_risk_threat_mapped_code_replaces_matching_item_only():
    unmapped = {"code": "R99", "label": "Autre menace"}
    qualification = rs_to_cisu_message(
        {
            "riskThreat": [
                {"code": "R17", "label": "Situation instable"},
                unmapped,
            ]
        }
    )
    assert qualification["riskThreat"] == [
        {"code": "R37", "label": "Situation instable/indéterminée"},
        unmapped,
    ]
