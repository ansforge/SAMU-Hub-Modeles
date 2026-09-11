"""Unit tests for CreateCaseVersionConverter.convert_v3_to_vactive /
convert_vactive_to_v3, calling the converter directly (no Flask/HTTP).

convert_v3_to_vactive mirrors from_rs_to_cisu's mapping direction
(2.3 -> 1.9 nomenclature); convert_vactive_to_v3 mirrors from_cisu_to_rs's
(1.9 -> 2.3 nomenclature).

Test cases are generated from the real nomenclature maps rather than
hardcoded codes, so they stay correct if the maps are regenerated. Each map
is only exercised on the scenarios it actually contains: as of this writing,
7 of the 8 (field, direction) maps have no entry mapped to None, and
riskThreat's v1.9->2.3 map (used by convert_vactive_to_v3) has no entry
mapped to a value (its single entry maps to None) -- those scenarios are
legitimately absent, not skipped by omission.

Each (field, direction) case also checks both qualification containers --
the top-level "qualification" and "initialAlert.qualification" -- within the
same test, since both are handled by the same loop in
apply_qualification_nomenclature_mappings and don't warrant separate test IDs.
"""

import pytest

from converter.cisu_version_converters.create_case.create_case_version_converter import (
    CreateCaseVersionConverter,
)
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

UNCHANGED = "sentinel: field left as injected"
REMOVED = "sentinel: field removed from qualification"
UNMAPPED_CODE = "UNMAPPED-TEST-CODE"

BASE_MESSAGE_PATH = "tests/fixtures/RC-EDA/RC-EDA_required_fields.json"

# (qualification field, is a list field, map used by convert_v3_to_vactive, map used by convert_vactive_to_v3)
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
        for method_name, mapping in [
            ("convert_v3_to_vactive", v3_to_vactive_map),
            ("convert_vactive_to_v3", vactive_to_v3_map),
        ]:
            cases.append(
                pytest.param(
                    field,
                    is_list,
                    method_name,
                    UNMAPPED_CODE,
                    UNCHANGED,
                    id=f"{field}-{method_name}-unmapped",
                )
            )

            mapped_value_entry = _first_entry(mapping, mapped_to_none=False)
            if mapped_value_entry is not None:
                code, expected_value = mapped_value_entry
                cases.append(
                    pytest.param(
                        field,
                        is_list,
                        method_name,
                        code,
                        expected_value,
                        id=f"{field}-{method_name}-mapped_to_value",
                    )
                )

            mapped_none_entry = _first_entry(mapping, mapped_to_none=True)
            if mapped_none_entry is not None:
                code, _ = mapped_none_entry
                cases.append(
                    pytest.param(
                        field,
                        is_list,
                        method_name,
                        code,
                        REMOVED,
                        id=f"{field}-{method_name}-mapped_to_none",
                    )
                )
    return cases


QUALIFICATION_CONTAINERS = ["qualification", "initialAlert.qualification"]


def _get_container(create_case, container_path, *, create):
    node = create_case
    for part in container_path.split("."):
        node = node.setdefault(part, {}) if create else node.get(part, {})
    return node


@pytest.mark.parametrize(
    "field, is_list, method_name, injected_code, expected",
    _build_cases(),
)
def test_nomenclature_mapping(field, is_list, method_name, injected_code, expected):
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, BASE_MESSAGE_PATH
    )
    injected_value = {"code": injected_code, "label": "Libellé de test"}
    create_case = get_edxl_message(message)["createCase"]
    for container_path in QUALIFICATION_CONTAINERS:
        qualification = _get_container(create_case, container_path, create=True)
        qualification[field] = [injected_value] if is_list else injected_value

    convert = getattr(CreateCaseVersionConverter, method_name)
    result = convert(message)

    result_create_case = get_edxl_message(result)["createCase"]
    for container_path in QUALIFICATION_CONTAINERS:
        result_qualification = _get_container(
            result_create_case, container_path, create=False
        )

        if expected == REMOVED:
            assert field not in result_qualification
        elif expected == UNCHANGED:
            expected_field_value = [injected_value] if is_list else injected_value
            assert result_qualification[field] == expected_field_value
        else:
            expected_field_value = [expected] if is_list else expected
            assert result_qualification[field] == expected_field_value
