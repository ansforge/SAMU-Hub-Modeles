from unittest import TestCase
from unittest.mock import MagicMock, patch

import pytest

from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate

RS_RI_SCHEMA = TestHelper.load_schema("RS-RI.schema.json")


def test_rs_to_cisu():
    rc_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.RC_RI_TAG
    )
    rc_schema = TestHelper.load_json_file_online(rc_schema_endpoint)

    usecase_files = TestHelper.get_json_files(
        TestConstants.RS_RI_TAG, tag=TestConstants.V3_GITHUB_TAG
    )

    usecase_files_with_empty_state = [
        "RS-RI_FuiteDeGaz_AliceGregoireNORMAND.06.json",
        "RS-RI_Incendie_RaymondeLECCIA.04.json",
        "RS-RI_Secondaire_RobertVermande.03.json",
        "RS-RI_partageRessources_LolaHalimi.03c.json",
    ]

    usecase_files_with_unsupported_vehicle_type = [
        "RS-RI_partageRessources_MonsieurX.03.json",  # contains TSU.AMB, not mappable to CISU (only SIS/SMUR allowed)
    ]

    for usecase_file in usecase_files:
        file_name = usecase_file["name"]
        print(f"Testing conversion of {file_name}")
        if file_name in usecase_files_with_empty_state:
            print(f"Skipping test for {file_name} due to known empty state issue.")
            continue
        if file_name in usecase_files_with_unsupported_vehicle_type:
            print(
                f"Skipping test for {file_name} due to known unsupported vehicle type."
            )
            continue

        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, usecase_file["path"]
        )
        # Perform conversion
        result = ResourcesInfoCISUConverter.from_rs_to_cisu(edxl_json)

        # Extract and validate the converted message
        usecase_name = rc_schema["title"]
        converted_message = result["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ][usecase_name]
        validate(instance=converted_message, schema=rc_schema)


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
    ],
)
def test_translate_vehicule_type_to_cisu(rs_vehicule_type, expected):
    cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
        rs_vehicule_type
    )
    assert cisu_vehicle_type == expected


@pytest.mark.parametrize(
    "rs_vehicule_type",
    [
        pytest.param("AUTREVEC", id="AUTREVEC is not mappable to CISU"),
        pytest.param("FSI.HELIFSI", id="FSI.HELIFSI is not mappable to CISU"),
        pytest.param("TSU.VSL", id="TSU.VSL is not mappable to CISU"),
    ],
)
def test_translate_vehicule_type_to_cisu_raises_for_unmappable(rs_vehicule_type):
    with pytest.raises(ValueError):
        ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(rs_vehicule_type)


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

_CASE_ID = "fr.health.samu800.DRFR158002421400215"


class TestBuildRsRiFromCisu:
    """Unit tests for _build_rs_ri_from_cisu (1-to-1 conversion helper)."""

    def test_transforms_state_to_list(self):
        """Each resource state must be wrapped in a list."""
        result = ResourcesInfoCISUConverter._build_rs_ri_from_cisu(
            _RC_RI_WITH_POSITION_EDXL
        )
        resources_info = result["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ]["resourcesInfo"]
        for resource in resources_info["resource"]:
            assert isinstance(resource["state"], list)


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
        rs_sr = result["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]["resourcesStatus"]
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


class TestFromCisuToRs:
    """Integration-style tests for the main from_cisu_to_rs entry point."""

    def test_new_case_id_returns_rs_ri_and_rs_sr_per_resource(self):
        """With an unknown caseId, must return 1 RS-RI + 1 RS-SR per resource."""
        with patch(_PATCH_TARGET, return_value=None):
            results = ResourcesInfoCISUConverter.from_cisu_to_rs(
                _RC_RI_WITH_POSITION_EDXL
            )

        # fixture has 2 resources → 1 RS-RI + 2 RS-SR = 3 messages
        assert isinstance(results, list)
        assert len(results) == 3

    def test_new_case_id_remaining_messages_are_rs_sr(self):
        """All messages after the first must be RS-SR."""
        with patch(_PATCH_TARGET, return_value=None):
            results = ResourcesInfoCISUConverter.from_cisu_to_rs(
                _RC_RI_WITH_POSITION_EDXL
            )

        for rs_sr in results[1:]:
            message = rs_sr["content"][0]["jsonContent"]["embeddedJsonContent"][
                "message"
            ]
            assert "resourcesStatus" in message

    def test_new_case_id_rs_sr_have_distinct_distribution_ids(self):
        """Every RS-SR must have a unique distributionID different from the input."""
        with patch(_PATCH_TARGET, return_value=None):
            results = ResourcesInfoCISUConverter.from_cisu_to_rs(
                _RC_RI_WITH_POSITION_EDXL
            )

        dist_ids = [msg["distributionID"] for msg in results]
        assert len(dist_ids) == len(set(dist_ids)), "distributionIDs must be unique"

    def test_new_case_id_rs_ri_has_no_position(self):
        """The RS-RI produced for a new caseId must not contain any position field."""
        with patch(_PATCH_TARGET, return_value=None):
            results = ResourcesInfoCISUConverter.from_cisu_to_rs(
                _RC_RI_WITH_POSITION_EDXL
            )

        resources_info = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ]["resourcesInfo"]
        for resource in resources_info["resource"]:
            assert "position" not in resource

    def test_known_case_id_returns_only_rs_ri(self):
        """With a known caseId, must return only the RS-RI (no RS-SR split)."""
        mock_persisted = MagicMock()
        with patch(_PATCH_TARGET, return_value=mock_persisted):
            results = ResourcesInfoCISUConverter.from_cisu_to_rs(
                _RC_RI_WITH_POSITION_EDXL
            )

        assert isinstance(results, list)
        assert len(results) == 1
        first_message = results[0]["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ]
        assert "resourcesInfo" in first_message
