import copy
from datetime import datetime
from unittest import TestCase
from unittest.mock import patch

import pytest

from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from converter.models.persisted_message import PersistedMessage
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate

RS_RI_SCHEMA = TestHelper.load_schema("RS-RI.schema.json")

usecase_files_with_empty_state = [
    "RS-RI_FuiteDeGaz_AliceGregoireNORMAND.06.json",
    "RS-RI_Incendie_RaymondeLECCIA.04.json",
    "RS-RI_Secondaire_RobertVermande.03.json",
    "RS-RI_partageRessources_LolaHalimi.03c.json",
]

usecase_files_with_unsupported_vehicle_type = [
    "RS-RI_partageRessources_MonsieurX.03.json",  # contains TSU.AMB, not mappable to CISU (only SIS/SMUR allowed)
]
all_usecase_files = TestHelper.get_json_files(
    TestConstants.RS_RI_TAG, tag=TestConstants.V3_GITHUB_TAG
)
all_file_names = [f["name"] for f in all_usecase_files]

# Dictionnaire des cas d'erreur : file_name -> message attendu
ERROR_CASES = {
    **{
        name: "No states found in resource, mandatory for CISU conversion."
        for name in usecase_files_with_empty_state
    },
    **{
        name: "At least one resource must have a CISU compatible vehicleType."
        for name in usecase_files_with_unsupported_vehicle_type
    },
}

TEST_CASES = [
    (name, ValueError, ERROR_CASES[name]) if name in ERROR_CASES else (name, None, None)
    for name in all_file_names
]


@pytest.mark.parametrize(
    "file_name, expected_exception, expected_message",
    TEST_CASES,
    ids=[c[0] for c in TEST_CASES],  # rend les sorties pytest lisibles
)
def test_rs_to_cisu(file_name, expected_exception, expected_message):
    """Test RS → CISU conversion for both success and expected error cases."""

    usecase_file = next(f for f in all_usecase_files if f["name"] == file_name)

    edxl_json = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, usecase_file["path"]
    )

    if expected_exception is None:
        # Cas nominal
        rc_schema_endpoint = get_file_endpoint(
            TestConstants.V3_GITHUB_TAG,
            TestConstants.RC_RI_TAG,
        )
        rc_schema = TestHelper.load_json_file_online(rc_schema_endpoint)

        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl_json)

        usecase_name = rc_schema["title"]
        converted_message = result["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ][usecase_name]

        validate(instance=converted_message, schema=rc_schema)

    else:
        # Cas d'erreur attendu
        with pytest.raises(expected_exception, match=expected_message):
            ResourcesInfoCISUConverter.from_rs_to_cisu(edxl_json)


def test_rs_to_cisu_should_delete_patient_id():
    rs_raw_message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        "tests/fixtures/RS-RI/RS-RI_V3.0_patient_id_deletion.json",
    )
    cisu_raw_message = ResourcesInfoCISUConverter.from_rs_to_cisu(rs_raw_message)
    cisu_message = ResourcesInfoCISUConverter.copy_cisu_input_use_case_content(
        cisu_raw_message
    )
    resources = cisu_message.get("resource", [])

    for resource in resources:
        assert "patientId" not in resource


class TestKeepLatestState(TestCase):
    def test_keep_latest_state_should_keep_latest(self):
        resource = {
            "state": [
                {"datetime": "2025-01-01T10:00:00Z"},
                {"datetime": "2025-01-02T12:00:00Z"},
                {"datetime": "2025-01-02T08:00:00Z"},
            ]
        }
        ResourcesInfoCISUConverter.keep_last_state(resource)

        expected_resource = {"state": {"datetime": "2025-01-02T12:00:00Z"}}

        assert resource == expected_resource

    def test_keep_last_state_should_raise_exception_if_state_empty(self):
        with pytest.raises(ValueError):
            resource = {"state": []}
            ResourcesInfoCISUConverter.keep_last_state(resource)

    def test_keep_last_state_should_raise_exception_if_state_undefined(self):
        with pytest.raises(ValueError):
            resource = {}
            ResourcesInfoCISUConverter.keep_last_state(resource)


def test_cisu_to_rs_breaking_changes():
    cisu_raw_message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RC-RI/RC-RI_V3.0_exhaustive_fill.json",
    )
    with patch(
        "converter.cisu.resources_info.resources_info_cisu_converter.get_last_rc_ri_by_case_id",
        return_value=None,
    ):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(cisu_raw_message)

    # from_cisu_to_rs now returns a list; first element is the RS-RI
    rs_raw_message = results[0]
    rs_message = ResourcesInfoCISUConverter.copy_rs_input_use_case_content(
        rs_raw_message
    )

    validate(rs_message, RS_RI_SCHEMA)


@pytest.mark.parametrize(
    "rs_vehicule_type,expected",
    [
        pytest.param("SIS", "SIS", id="translates SIS to SIS"),
        pytest.param("SIS.DRAGON", "SIS", id="translates SIS.DRAGON to SIS"),
        pytest.param("SMUR", "SMUR", id="translates SMUR to SMUR"),
        pytest.param("SMUR.VLM", "SMUR", id="translates SMUR.VLM to SMUR"),
        pytest.param("AUTREVEC", None, id="AUTREVEC is not mappable to CISU"),
        pytest.param("FSI.HELIFSI ", None, id="FSI.HELIFSI is not mappable to CISU"),
        pytest.param("TSU.VSL", None, id="TSU.VSL is not mappable to CISU"),
    ],
)
def test_translate_vehicule_type_to_cisu(rs_vehicule_type, expected):
    cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
        rs_vehicule_type
    )
    assert cisu_vehicle_type == expected


@pytest.mark.parametrize(
    "cisu_vehicule_type,expected",
    [
        pytest.param("SIS", "SIS", id="translates SIS to SIS"),
        pytest.param("SMUR", "SMUR", id="translates SMUR to SMUR"),
        pytest.param("AUTRE", "AUTREVEC", id="translates AUTRE to AUTREVEC"),
    ],
)
def test_translate_vehicule_type_to_rs(cisu_vehicule_type, expected):
    rs_vehicle_type = ResourcesInfoCISUConverter.translate_to_rs_vehicle_type(
        cisu_vehicule_type
    )
    assert rs_vehicle_type == expected


# ---------------------------------------------------------------------------
# RC-RI → RS (from_cisu_to_rs) — split logic
# ---------------------------------------------------------------------------

_PATCH_TARGET = "converter.cisu.resources_info.resources_info_cisu_converter.get_last_rc_ri_by_case_id"

_RC_RI_WITH_POSITION_EDXL = TestHelper.create_edxl_json_from_sample(
    TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
    "tests/fixtures/RC-RI/RC-RI_V3.0_with_position.json",
)

_CASE_ID = (
    _RC_RI_WITH_POSITION_EDXL["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]["resourcesInfoCisu"]["caseId"]
)


class TestBuildRsSrFromResource:
    """Unit tests for _build_rs_sr_from_resource."""

    _RESOURCE = {
        "resourceId": "fr.health.samu800.resource.VLM1",
        "orgId": "fr.health.samu800",
        "vehicleType": "SMUR",
        "state": {"datetime": "2024-08-01T16:42:00+02:00", "status": "RET-BASE"},
    }

    def test_rs_sr_content_is_correct(self):
        result = ResourcesInfoCISUConverter._build_rs_sr_from_resource(
            _RC_RI_WITH_POSITION_EDXL, self._RESOURCE, _CASE_ID
        )
        rs_sr = result["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "resourcesStatus"
        ]
        assert rs_sr["caseId"] == _CASE_ID
        assert rs_sr["resourceId"] == self._RESOURCE["resourceId"]
        assert rs_sr["state"] == self._RESOURCE["state"]

    def test_rs_sr_does_not_contain_cisu_key(self):
        """The RS-SR message envelope must not contain the original CISU key."""
        result = ResourcesInfoCISUConverter._build_rs_sr_from_resource(
            _RC_RI_WITH_POSITION_EDXL, self._RESOURCE, _CASE_ID
        )
        message = result["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]
        assert "resourcesInfoCisu" not in message


def test_from_cisu_to_rs_new_case_id():
    """With an unknown caseId, from_cisu_to_rs must return 1 RS-RI + 1 RS-SR per resource."""
    with patch(_PATCH_TARGET, return_value=None):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(_RC_RI_WITH_POSITION_EDXL)

    # fixture has 2 resources → 1 RS-RI + 2 RS-SR = 3 messages
    assert isinstance(results, list), "result must be a list"
    assert len(results) == 3, (
        f"expected 3 messages (1 RS-RI + 2 RS-SR), got {len(results)}"
    )

    first_message = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]
    assert "resourcesInfo" in first_message, (
        "first message must be a RS-RI (resourcesInfo key expected)"
    )

    for i, rs_sr in enumerate(results[1:], start=1):
        message = rs_sr["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]
        assert "resourcesStatus" in message, (
            f"message {i} must be a RS-SR (resourcesStatus key expected)"
        )

    dist_ids = [msg["distributionID"] for msg in results]
    assert len(dist_ids) == len(set(dist_ids)), "all distributionIDs must be unique"

    resources_info = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]["resourcesInfo"]
    for resource in resources_info["resource"]:
        assert "position" not in resource, (
            f"RS-RI resource {resource.get('resourceId')} must not contain a position field"
        )


# ---------------------------------------------------------------------------
# has_ressources_been_updated — unit tests
# ---------------------------------------------------------------------------

_RESOURCE_VLM1 = {
    "resourceId": "fr.health.samu800.resource.VLM1",
    "orgId": "fr.health.samu800",
    "vehicleType": "SMUR",
    "state": {"datetime": "2024-08-01T16:42:00+02:00", "status": "RET-BASE"},
}
_RESOURCE_VSAV3A = {
    "resourceId": "fr.fire.sis076.cgo-076.resource.VSAV3A",
    "orgId": "fr.fire.sdis76.cgo-076",
    "vehicleType": "SIS",
    "state": {"datetime": "2024-08-01T16:40:00+02:00", "status": "FINPEC"},
}
_RESOURCE_NEW = {
    "resourceId": "fr.health.samu800.resource.VLM2",
    "orgId": "fr.health.samu800",
    "vehicleType": "SMUR",
    "state": {"datetime": "2024-08-01T17:00:00+02:00", "status": "RET-BASE"},
}


def _make_edxl_with_resources(resources):
    """Return a copy of the RC-RI fixture with the given resource list."""
    edxl = copy.deepcopy(_RC_RI_WITH_POSITION_EDXL)
    edxl["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfoCisu"
    ]["resource"] = resources
    return edxl


class TestHasRessourcesBeenUpdated:
    def test_no_change(self):
        """Identical resource lists → no flag raised, no modified resources."""
        edxl = _make_edxl_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        result = ResourcesInfoCISUConverter.has_ressources_been_updated(edxl, edxl)

        assert result["engaged_resources_updated"] is False, (
            "engaged_resources_updated must be False when no resource is added or removed"
        )
        assert result["modified_status_resources"] == [], (
            "modified_status_resources must be empty when no status has changed"
        )

    def test_status_changed(self):
        """A status change → flag stays False, changed resource appears in modified_status_resources in its new version."""
        ref = _make_edxl_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        updated_vlm1 = copy.deepcopy(_RESOURCE_VLM1)
        updated_vlm1["state"]["status"] = "DISP"
        cmp = _make_edxl_with_resources(
            [updated_vlm1, copy.deepcopy(_RESOURCE_VSAV3A)]
        )

        result = ResourcesInfoCISUConverter.has_ressources_been_updated(ref, cmp)

        assert result["engaged_resources_updated"] is False, (
            "engaged_resources_updated must stay False when only a status changed (no resource added/removed)"
        )
        assert len(result["modified_status_resources"]) == 1, (
            "exactly one resource should appear in modified_status_resources"
        )
        changed = result["modified_status_resources"][0]
        assert changed["resourceId"] == _RESOURCE_VLM1["resourceId"], (
            "the resource with the changed status must be present in modified_status_resources"
        )
        assert changed["state"]["status"] == "DISP", (
            "modified_status_resources must contain the resource in its most recent version"
        )

    def test_resource_added(self):
        """A new resource → flag raised and new resource appears in modified_status_resources."""
        ref = _make_edxl_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        cmp = _make_edxl_with_resources(
            [
                copy.deepcopy(_RESOURCE_VLM1),
                copy.deepcopy(_RESOURCE_VSAV3A),
                copy.deepcopy(_RESOURCE_NEW),
            ]
        )

        result = ResourcesInfoCISUConverter.has_ressources_been_updated(ref, cmp)

        assert result["engaged_resources_updated"] is True, (
            "engaged_resources_updated must be True when a resource is added"
        )
        resource_ids = [r["resourceId"] for r in result["modified_status_resources"]]
        assert _RESOURCE_NEW["resourceId"] in resource_ids, (
            f"the new resource {_RESOURCE_NEW['resourceId']} must appear in modified_status_resources "
            "so that a RS-SR is generated for it"
        )

    def test_resource_removed(self):
        """A removed resource → flag raised, removed resource absent from modified_status_resources."""
        ref = _make_edxl_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        cmp = _make_edxl_with_resources([copy.deepcopy(_RESOURCE_VLM1)])

        result = ResourcesInfoCISUConverter.has_ressources_been_updated(ref, cmp)

        assert result["engaged_resources_updated"] is True, (
            "engaged_resources_updated must be True when a resource is removed"
        )
        resource_ids = [r["resourceId"] for r in result["modified_status_resources"]]
        assert _RESOURCE_VSAV3A["resourceId"] not in resource_ids, (
            f"the removed resource {_RESOURCE_VSAV3A['resourceId']} must not appear in modified_status_resources"
        )

    def test_status_change_returns_new_version_of_resource(self):
        """modified_status_resources must contain the resource in its most recent version (from comparison message)."""
        ref = _make_edxl_with_resources([copy.deepcopy(_RESOURCE_VLM1)])
        updated = copy.deepcopy(_RESOURCE_VLM1)
        updated["state"]["status"] = "DISP"
        updated["state"]["datetime"] = "2024-08-01T18:00:00+02:00"
        cmp = _make_edxl_with_resources([updated])

        result = ResourcesInfoCISUConverter.has_ressources_been_updated(ref, cmp)

        assert result["modified_status_resources"][0]["state"]["datetime"] == (
            "2024-08-01T18:00:00+02:00"
        ), "modified_status_resources must contain the resource from the comparison message, not the reference"


# ---------------------------------------------------------------------------
# from_cisu_to_rs — known caseId scenarios
# ---------------------------------------------------------------------------


def _persisted(edxl: dict) -> PersistedMessage:
    """Wrap an EDXL dict in a PersistedMessage as the repository would return it."""
    return PersistedMessage(
        message_type="RC-RI",
        payload=edxl,
        arrived_at=datetime(2024, 8, 1, 14, 0, 0),
    )


def test_from_cisu_to_rs_known_case_id_status_changed_only():
    """Known caseId + only a status change → exactly one RS-SR, no RS-RI."""
    ref_edxl = _make_edxl_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    updated_vlm1 = copy.deepcopy(_RESOURCE_VLM1)
    updated_vlm1["state"]["status"] = "DISP"
    incoming_edxl = _make_edxl_with_resources(
        [updated_vlm1, copy.deepcopy(_RESOURCE_VSAV3A)]
    )

    with patch(_PATCH_TARGET, return_value=_persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 1, f"expected 1 RS-SR, got {len(results)}"
    message = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]
    assert "resourcesStatus" in message, "expected RS-SR (resourcesStatus key)"
    assert "resourcesInfo" not in message, "a status-only change must not produce a RS-RI"
    assert message["resourcesStatus"]["resourceId"] == _RESOURCE_VLM1["resourceId"], (
        "RS-SR must reference the resource whose status changed"
    )


def test_from_cisu_to_rs_known_case_id_resource_added():
    """Known caseId + new resource → one RS-RI and one RS-SR for the new resource."""
    ref_edxl = _make_edxl_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = _make_edxl_with_resources(
        [
            copy.deepcopy(_RESOURCE_VLM1),
            copy.deepcopy(_RESOURCE_VSAV3A),
            copy.deepcopy(_RESOURCE_NEW),
        ]
    )

    with patch(_PATCH_TARGET, return_value=_persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 2, f"expected RS-RI + RS-SR, got {len(results)}"

    first_message = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]
    assert "resourcesInfo" in first_message, (
        "first message must be RS-RI when the engaged resource list has changed"
    )

    second_message = results[1]["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]
    assert "resourcesStatus" in second_message, (
        "second message must be a RS-SR for the newly added resource"
    )
    assert second_message["resourcesStatus"]["resourceId"] == _RESOURCE_NEW["resourceId"], (
        "RS-SR must reference the newly added resource"
    )


def test_from_cisu_to_rs_known_case_id_resource_removed():
    """Known caseId + resource removed → one RS-RI, no RS-SR."""
    ref_edxl = _make_edxl_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = _make_edxl_with_resources([copy.deepcopy(_RESOURCE_VLM1)])

    with patch(_PATCH_TARGET, return_value=_persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 1, f"expected exactly 1 RS-RI (no RS-SR for a removed resource), got {len(results)}"
    message = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]
    assert "resourcesInfo" in message, (
        "when a resource is removed the RS-RI must be produced to reflect the new engaged resource list"
    )


def test_from_cisu_to_rs_known_case_id_no_change():
    """Known caseId + no resource or status change → empty list."""
    ref_edxl = _make_edxl_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = _make_edxl_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )

    with patch(_PATCH_TARGET, return_value=_persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert results == [], f"expected no messages, got {len(results)}"
