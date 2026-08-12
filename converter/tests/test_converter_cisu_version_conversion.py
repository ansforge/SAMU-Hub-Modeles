"""Integration tests for the /convert endpoint, CISUVersionConversion type,
createCase message.

Starts from the minimal RC-EDA fixture (tests/fixtures/RC-EDA/RC-EDA_required_fields.json),
only overriding one qualification nomenclature field at a time, and posts it
through the actual Flask endpoint (in-process test client, no live
server/Mongo needed). A minimal fixture is used rather than a real example so
the assertions stay scoped to the field under test even if the converter
later starts touching more than qualification.

Test cases are generated from the real nomenclature maps rather than
hardcoded codes, so they stay correct if the maps are regenerated. Each map
is only exercised on the scenarios it actually contains: as of this writing,
7 of the 8 (field, direction) maps have no entry mapped to None, and
riskThreat's v1.9->2.3 map (used by vactive_to_v3) has no entry mapped to a
value (its single entry maps to None) -- those scenarios are legitimately
absent, not skipped by omission.
"""

import pytest

from converter.cisu_transcoders.constants import CISUConstants
from converter.converter import app
from converter.nomenclatures.from_v1_9_to_v2_3.health_motive import (
    V1_9_TO_V2_3_HEALTH_MOTIVE_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.location_kind import (
    V1_9_TO_V2_3_LOCATION_KIND_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.risk_threat import (
    V1_9_TO_V2_3_RISK_THREAT_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.whats_happen import (
    V1_9_TO_V2_3_WHATS_HAPPEN_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.health_motive import (
    V2_3_TO_V1_9_HEALTH_MOTIVE_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.location_kind import (
    V2_3_TO_V1_9_LOCATION_KIND_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.risk_threat import (
    V2_3_TO_V1_9_RISK_THREAT_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.whats_happen import (
    V2_3_TO_V1_9_WHATS_HAPPEN_MAP,
)
from tests.cisu.helpers import get_edxl_message
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

V3 = CISUConstants.HEALTH_EXPECTED_VERSION_FOR_CISU_CONVERSION
VACTIVE = CISUConstants.CISU_EXPECTED_MODEL_VERSION

UNCHANGED = "sentinel: field left as injected"
REMOVED = "sentinel: field removed from qualification"
UNMAPPED_CODE = "UNMAPPED-TEST-CODE"

BASE_MESSAGE_PATH = "tests/fixtures/RC-EDA/RC-EDA_required_fields.json"

# (qualification field, is a list field, map used by v3->vactive, map used by vactive->v3)
FIELD_SPECS = [
    (
        "whatsHappen",
        False,
        V2_3_TO_V1_9_WHATS_HAPPEN_MAP,
        V1_9_TO_V2_3_WHATS_HAPPEN_MAP,
    ),
    (
        "healthMotive",
        False,
        V2_3_TO_V1_9_HEALTH_MOTIVE_MAP,
        V1_9_TO_V2_3_HEALTH_MOTIVE_MAP,
    ),
    (
        "riskThreat",
        True,
        V2_3_TO_V1_9_RISK_THREAT_MAP,
        V1_9_TO_V2_3_RISK_THREAT_MAP,
    ),
    (
        "locationKind",
        False,
        V2_3_TO_V1_9_LOCATION_KIND_MAP,
        V1_9_TO_V2_3_LOCATION_KIND_MAP,
    ),
]


def _first_entry(mapping, *, mapped_to_none):
    return next(
        (
            (code, value)
            for code, value in mapping.items()
            if (value is None) == mapped_to_none
        ),
        None,
    )


def _build_cases():
    cases = []
    for field, is_list, v3_to_vactive_map, vactive_to_v3_map in FIELD_SPECS:
        for source_version, target_version, mapping in [
            (V3, VACTIVE, v3_to_vactive_map),
            (VACTIVE, V3, vactive_to_v3_map),
        ]:
            direction = f"{source_version}_to_{target_version}"

            cases.append(
                pytest.param(
                    field,
                    is_list,
                    source_version,
                    target_version,
                    UNMAPPED_CODE,
                    UNCHANGED,
                    id=f"{field}-{direction}-unmapped",
                )
            )

            mapped_value_entry = _first_entry(mapping, mapped_to_none=False)
            if mapped_value_entry is not None:
                code, expected_value = mapped_value_entry
                cases.append(
                    pytest.param(
                        field,
                        is_list,
                        source_version,
                        target_version,
                        code,
                        expected_value,
                        id=f"{field}-{direction}-mapped_to_value",
                    )
                )

            mapped_none_entry = _first_entry(mapping, mapped_to_none=True)
            if mapped_none_entry is not None:
                code, _ = mapped_none_entry
                cases.append(
                    pytest.param(
                        field,
                        is_list,
                        source_version,
                        target_version,
                        code,
                        REMOVED,
                        id=f"{field}-{direction}-mapped_to_none",
                    )
                )
    return cases


@pytest.fixture
def client():
    app.config["TESTING"] = True
    with app.test_client() as client:
        yield client


@pytest.mark.parametrize(
    "field, is_list, source_version, target_version, injected_code, expected",
    _build_cases(),
)
def test_cisu_version_conversion_nomenclature_mapping(
    client, field, is_list, source_version, target_version, injected_code, expected
):
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, BASE_MESSAGE_PATH
    )
    injected_value = {"code": injected_code, "label": "Libellé de test"}
    qualification = get_edxl_message(message)["createCase"]["qualification"]
    qualification[field] = [injected_value] if is_list else injected_value

    response = client.post(
        "/convert",
        json={
            "sourceVersion": source_version,
            "targetVersion": target_version,
            "type": "CISUVersionConversion",
            "edxl": message,
        },
    )

    assert response.status_code == 200
    result_qualification = get_edxl_message(response.json["converted_messages"][0])[
        "createCase"
    ]["qualification"]

    if expected == REMOVED:
        assert field not in result_qualification
    elif expected == UNCHANGED:
        expected_field_value = [injected_value] if is_list else injected_value
        assert result_qualification[field] == expected_field_value
    else:
        expected_field_value = [expected] if is_list else expected
        assert result_qualification[field] == expected_field_value
