import copy
from unittest import TestCase
from unittest.mock import patch

import pytest

from converter.cisu.resources_info.resources_info_cisu_converter import (
    ConversionError,
    ResourcesInfoCISUConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate
from tests.cisu.helpers import (
    RC_RI_WITH_POSITION_EDXL,
    get_cisu_content,
    get_edxl_message,
    make_rc_ri_with_resources,
    make_rs_ri_edxl,
    persisted,
    persisted_rs_ri_and_rs_sr,
)

RS_RI_SCHEMA = TestHelper.load_schema("RS-RI.schema.json")

_PATCH_GET_LAST_RC_RI_BY_CASE_ID = "converter.cisu.resources_info.resources_info_cisu_converter.get_last_rc_ri_by_case_id"
_PATCH_GET_RS_MESSAGES_BY_CASE_ID = "converter.cisu.resources_info.resources_info_cisu_converter.get_rs_messages_by_case_id"

usecase_files_returning_no_converted_messages = [
    "RS-RI_Secondaire_RobertVermande.03.json",
    "RS-RI_partageRessources_LolaHalimi.03c.json",
    "RS-RI_partageRessources_MonsieurX.03.json",
]

all_usecase_files = TestHelper.get_json_files(
    TestConstants.RS_RI_TAG, tag=TestConstants.V3_GITHUB_TAG
)
all_file_names = [f["name"] for f in all_usecase_files]

TEST_CASES = [
    (name, name in usecase_files_returning_no_converted_messages)
    for name in all_file_names
]


@pytest.mark.parametrize(
    "file_name, should_return_emtpy_list",
    TEST_CASES,
    ids=[c[0] for c in TEST_CASES],  # rend les sorties pytest lisibles
)
def test_rs_to_cisu(file_name, should_return_emtpy_list):
    """Test RS → CISU conversion for both success and expected error cases."""

    usecase_file = next(f for f in all_usecase_files if f["name"] == file_name)

    edxl_json = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, usecase_file["path"]
    )
    with patch(_PATCH_GET_RS_MESSAGES_BY_CASE_ID, return_value=(None, [])):
        # Cas nominal
        rc_schema_endpoint = get_file_endpoint(
            TestConstants.V3_GITHUB_TAG,
            TestConstants.RC_RI_TAG,
        )
        rc_schema = TestHelper.load_json_file_online(rc_schema_endpoint)

        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl_json)

        if should_return_emtpy_list:
            assert result == [], (
                f"Conversion of message {file_name} should return empty response."
            )
        else:
            usecase_name = rc_schema["title"]
            converted_message = get_edxl_message(result)[usecase_name]
            validate(instance=converted_message, schema=rc_schema)


# @pytest.mark.parametrize(
#     "file_name",
#     usecase_files_with_unsupported_vehicle_type,
# )
# def test_rs_to_cisu_returns_empty_list_when_no_cisu_compatible_resource(file_name):
#     """Quand toutes les ressources ont un vehicleType non supporté, from_rs_to_cisu
#     doit retourner [] au lieu de lever une erreur."""
#     usecase_file = next(f for f in all_usecase_files if f["name"] == file_name)
#     edxl_json = TestHelper.create_edxl_json_from_sample(
#         TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, usecase_file["path"]
#     )

#     with patch(
#         _PATCH_GET_RS_MESSAGES_BY_CASE_ID,
#         return_value=(edxl_json, []),
#     ):
#         result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl_json)
#         assert result == []


def test_rs_to_cisu_should_delete_patient_id():
    rs_raw_message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        "tests/fixtures/RS-RI/RS-RI_V3.0_patient_id_deletion.json",
    )
    with patch(_PATCH_GET_RS_MESSAGES_BY_CASE_ID, return_value=(None, [])):
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
        ResourcesInfoCISUConverter._keep_last_state(resource)

        expected_resource = {"state": {"datetime": "2025-01-02T12:00:00Z"}}

        assert resource == expected_resource

    def test_keep_last_state_should_raise_exception_if_state_empty(self):
        with pytest.raises(ConversionError):
            resource = {"state": []}
            ResourcesInfoCISUConverter._keep_last_state(resource)

    def test_keep_last_state_should_raise_exception_if_state_undefined(self):
        with pytest.raises(ConversionError):
            resource = {}
            ResourcesInfoCISUConverter._keep_last_state(resource)


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
    ],
)
def test_translate_vehicule_type_to_cisu(rs_vehicule_type, expected):
    resource = {"vehicleType": rs_vehicule_type}
    ResourcesInfoCISUConverter._translate_to_cisu_vehicle_type(resource)
    assert resource["vehicleType"] == expected


@pytest.mark.parametrize(
    "rs_vehicule_type",
    [
        pytest.param("AUTREVEC", id="AUTREVEC is not mappable to CISU"),
        pytest.param("FSI.HELIFSI", id="FSI.HELIFSI is not mappable to CISU"),
        pytest.param("TSU.VSL", id="TSU.VSL is not mappable to CISU"),
    ],
)
def test_translate_vehicule_type_to_cisu_raises_on_unmappable(rs_vehicule_type):
    resource = {"vehicleType": rs_vehicule_type}
    with pytest.raises(ConversionError):
        ResourcesInfoCISUConverter._translate_to_cisu_vehicle_type(resource)


# ---------------------------------------------------------------------------
# RC-RI → RS (from_cisu_to_rs) — split logic
# ---------------------------------------------------------------------------

_CASE_ID = get_cisu_content(RC_RI_WITH_POSITION_EDXL)["caseId"]


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
            RC_RI_WITH_POSITION_EDXL, self._RESOURCE, _CASE_ID
        )
        rs_sr = get_edxl_message(result)["resourcesStatus"]
        assert rs_sr["caseId"] == _CASE_ID
        assert rs_sr["resourceId"] == self._RESOURCE["resourceId"]
        assert rs_sr["state"] == self._RESOURCE["state"]

    def test_rs_sr_does_not_contain_cisu_key(self):
        """The RS-SR message envelope must not contain the original CISU key."""
        result = ResourcesInfoCISUConverter._build_rs_sr_from_resource(
            RC_RI_WITH_POSITION_EDXL, self._RESOURCE, _CASE_ID
        )
        message = get_edxl_message(result)
        assert "resourcesInfoCisu" not in message


def test_from_cisu_to_rs_new_case_id():
    """With an unknown caseId, from_cisu_to_rs must return 1 RS-RI + 1 RS-SR per resource."""
    with patch(_PATCH_GET_LAST_RC_RI_BY_CASE_ID, return_value=None):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(RC_RI_WITH_POSITION_EDXL)

    # fixture has 2 resources → 1 RS-RI + 2 RS-SR = 3 messages
    assert isinstance(results, list), "result must be a list"
    assert len(results) == 3, (
        f"expected 3 messages (1 RS-RI + 2 RS-SR), got {len(results)}"
    )

    first_message = get_edxl_message(results[0])
    assert "resourcesInfo" in first_message, (
        "first message must be a RS-RI (resourcesInfo key expected)"
    )

    for i, rs_sr in enumerate(results[1:], start=1):
        message = get_edxl_message(rs_sr)
        assert "resourcesStatus" in message, (
            f"message {i} must be a RS-SR (resourcesStatus key expected)"
        )

    for msg in results:
        dist_id = msg["distributionID"]
        msg_id = msg["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "messageId"
        ]

        assert dist_id == msg_id, f"distributionID '{dist_id}' != messageId '{msg_id}'"

    dist_ids = [msg["distributionID"] for msg in results]
    assert len(dist_ids) == len(set(dist_ids)), "all distributionIDs must be unique"

    resources_info = get_edxl_message(results[0])["resourcesInfo"]
    for resource in resources_info["resource"]:
        assert "position" not in resource, (
            f"RS-RI resource {resource.get('resourceId')} must not contain a position field"
        )


# ---------------------------------------------------------------------------
# _has_resources_been_updated — unit tests
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


class TestHasResourcesBeenUpdated:
    def test_no_change(self):
        """Identical resource lists → no flag raised, no modified resources."""
        edxl = make_rc_ri_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        result = ResourcesInfoCISUConverter._has_resources_been_updated(edxl, edxl)

        assert result["engaged_resources_updated"] is False, (
            "engaged_resources_updated must be False when no resource is added or removed"
        )
        assert result["modified_status_resources"] == [], (
            "modified_status_resources must be empty when no status has changed"
        )

    def test_status_changed(self):
        """A status change → flag stays False, changed resource appears in modified_status_resources in its new version."""
        ref = make_rc_ri_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        updated_vlm1 = copy.deepcopy(_RESOURCE_VLM1)
        updated_vlm1["state"]["status"] = "DISP"
        updated_vlm1["state"]["datetime"] = "2024-08-01T18:00:00+02:00"
        cmp = make_rc_ri_with_resources([updated_vlm1, copy.deepcopy(_RESOURCE_VSAV3A)])

        result = ResourcesInfoCISUConverter._has_resources_been_updated(ref, cmp)

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
        assert changed["state"]["datetime"] == "2024-08-01T18:00:00+02:00", (
            "modified_status_resources must contain the resource from the comparison message, not the reference"
        )

    def test_resource_added(self):
        """A new resource → flag raised and new resource appears in modified_status_resources."""
        ref = make_rc_ri_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        cmp = make_rc_ri_with_resources(
            [
                copy.deepcopy(_RESOURCE_VLM1),
                copy.deepcopy(_RESOURCE_VSAV3A),
                copy.deepcopy(_RESOURCE_NEW),
            ]
        )

        result = ResourcesInfoCISUConverter._has_resources_been_updated(ref, cmp)

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
        ref = make_rc_ri_with_resources(
            [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
        )
        cmp = make_rc_ri_with_resources([copy.deepcopy(_RESOURCE_VLM1)])

        result = ResourcesInfoCISUConverter._has_resources_been_updated(ref, cmp)

        assert result["engaged_resources_updated"] is True, (
            "engaged_resources_updated must be True when a resource is removed"
        )
        resource_ids = [r["resourceId"] for r in result["modified_status_resources"]]
        assert _RESOURCE_VSAV3A["resourceId"] not in resource_ids, (
            f"the removed resource {_RESOURCE_VSAV3A['resourceId']} must not appear in modified_status_resources"
        )


# ---------------------------------------------------------------------------
# from_cisu_to_rs — known caseId scenarios
# ---------------------------------------------------------------------------


def test_from_cisu_to_rs_known_case_id_status_changed_only():
    """Known caseId + only a status change → exactly one RS-SR, no RS-RI."""
    ref_edxl = make_rc_ri_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    updated_vlm1 = copy.deepcopy(_RESOURCE_VLM1)
    updated_vlm1["state"]["status"] = "DISP"
    incoming_edxl = make_rc_ri_with_resources(
        [updated_vlm1, copy.deepcopy(_RESOURCE_VSAV3A)]
    )

    with patch(_PATCH_GET_LAST_RC_RI_BY_CASE_ID, return_value=persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 1, f"expected 1 RS-SR, got {len(results)}"
    message = get_edxl_message(results[0])
    assert "resourcesStatus" in message, "expected RS-SR (resourcesStatus key)"
    assert "resourcesInfo" not in message, (
        "a status-only change must not produce a RS-RI"
    )
    assert message["resourcesStatus"]["resourceId"] == _RESOURCE_VLM1["resourceId"], (
        "RS-SR must reference the resource whose status changed"
    )


def test_from_cisu_to_rs_known_case_id_resource_added():
    """Known caseId + new resource → one RS-RI and one RS-SR for the new resource."""
    ref_edxl = make_rc_ri_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = make_rc_ri_with_resources(
        [
            copy.deepcopy(_RESOURCE_VLM1),
            copy.deepcopy(_RESOURCE_VSAV3A),
            copy.deepcopy(_RESOURCE_NEW),
        ]
    )

    with patch(_PATCH_GET_LAST_RC_RI_BY_CASE_ID, return_value=persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 2, f"expected RS-RI + RS-SR, got {len(results)}"

    first_message = get_edxl_message(results[0])
    assert "resourcesInfo" in first_message, (
        "first message must be RS-RI when the engaged resource list has changed"
    )

    second_message = get_edxl_message(results[1])
    assert "resourcesStatus" in second_message, (
        "second message must be a RS-SR for the newly added resource"
    )
    assert (
        second_message["resourcesStatus"]["resourceId"] == _RESOURCE_NEW["resourceId"]
    ), "RS-SR must reference the newly added resource"


def test_from_cisu_to_rs_known_case_id_resource_removed():
    """Known caseId + resource removed → one RS-RI, no RS-SR."""
    ref_edxl = make_rc_ri_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = make_rc_ri_with_resources([copy.deepcopy(_RESOURCE_VLM1)])

    with patch(_PATCH_GET_LAST_RC_RI_BY_CASE_ID, return_value=persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert isinstance(results, list), "from_cisu_to_rs must return a list"
    assert len(results) == 1, (
        f"expected exactly 1 RS-RI (no RS-SR for a removed resource), got {len(results)}"
    )
    message = get_edxl_message(results[0])
    assert "resourcesInfo" in message, (
        "when a resource is removed the RS-RI must be produced to reflect the new engaged resource list"
    )


def test_from_cisu_to_rs_known_case_id_no_change():
    """Known caseId + no resource or status change → empty list."""
    ref_edxl = make_rc_ri_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )
    incoming_edxl = make_rc_ri_with_resources(
        [copy.deepcopy(_RESOURCE_VLM1), copy.deepcopy(_RESOURCE_VSAV3A)]
    )

    with patch(_PATCH_GET_LAST_RC_RI_BY_CASE_ID, return_value=persisted(ref_edxl)):
        results = ResourcesInfoCISUConverter.from_cisu_to_rs(incoming_edxl)

    assert results == [], f"expected no messages, got {len(results)}"


# ---------------------------------------------------------------------------
# from_rs_to_cisu — RS-RI + RS-SR merge logic
# ---------------------------------------------------------------------------


def test_from_rs_to_cisu_no_persisted_rs_sr():
    """No persisted RS-SR should return original state."""
    edxl, _, _ = make_rs_ri_edxl()

    with patch(_PATCH_GET_RS_MESSAGES_BY_CASE_ID, return_value=(None, [])):
        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl)

    rc_ri = get_cisu_content(result)
    assert rc_ri["resource"][0]["state"]["status"] == "RET-BASE"
    # Two resources present originaly but only one valid vehicle type, so 1 resource expected
    assert (len(rc_ri["resource"])) == 1


def test_from_rs_to_cisu_no_state_but_persisted_rs_sr():
    """A persisted RS-SR should return persisted state if no original state."""
    edxl, rs_ri, rs_sr_edxl = make_rs_ri_edxl(remove_state=True)

    with patch(
        _PATCH_GET_RS_MESSAGES_BY_CASE_ID,
        return_value=persisted_rs_ri_and_rs_sr(rs_ri, [rs_sr_edxl]),
    ):
        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl)

    assert "state" not in rs_ri["resource"][0]
    assert get_cisu_content(result)["resource"][0]["state"]["status"] == "RETOUR"


def test_from_rs_to_cisu_latest_persisted_state():
    """A persisted RS-SR should return the latest state (persisted state is more recent)."""
    later_datetime = "2025-05-18T18:46:00+02:00"
    edxl, rs_ri, rs_sr_edxl = make_rs_ri_edxl(rs_sr_datetime=later_datetime)

    with patch(
        _PATCH_GET_RS_MESSAGES_BY_CASE_ID,
        return_value=persisted_rs_ri_and_rs_sr(rs_ri, [rs_sr_edxl]),
    ):
        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl)

    rc_ri = get_cisu_content(result)
    assert rc_ri["resource"][0]["state"]["status"] == "RETOUR"
    assert rc_ri["resource"][0]["state"]["datetime"] == later_datetime


def test_from_rs_to_cisu_latest_original_state():
    """A persisted RS-SR should return the latest state (original state is more recent)."""
    earlier_datetime = "2023-05-18T18:46:00+02:00"
    edxl, rs_ri, rs_sr_edxl = make_rs_ri_edxl(rs_sr_datetime=earlier_datetime)
    current_datetime = rs_ri["resource"][0]["state"][0]["datetime"]

    with patch(
        _PATCH_GET_RS_MESSAGES_BY_CASE_ID,
        return_value=persisted_rs_ri_and_rs_sr(rs_ri, [rs_sr_edxl]),
    ):
        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl)

    rc_ri = get_cisu_content(result)
    assert rc_ri["resource"][0]["state"]["status"] == "RET-BASE"
    assert rc_ri["resource"][0]["state"]["datetime"] == current_datetime
