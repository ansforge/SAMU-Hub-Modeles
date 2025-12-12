from unittest import TestCase

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

    for usecase_file in usecase_files:
        file_name = usecase_file["name"]
        print(f"Testing conversion of {file_name}")
        if file_name in usecase_files_with_empty_state:
            print(f"Skipping test for {file_name} due to known empty state issue.")
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
        "tests/fixtures/RS-RI/RS-RI_V3.0_exhaustive_fill.json",
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
    rs_raw_message = ResourcesInfoCISUConverter.from_cisu_to_rs(cisu_raw_message)
    rs_message = ResourcesInfoCISUConverter.copy_rs_input_use_case_content(
        rs_raw_message
    )

    validate(rs_message, RS_RI_SCHEMA)


@pytest.mark.parametrize(
    "rs_vehicule_type,expected",
    [
        pytest.param("SIS", "SIS", id="translates SIS to SIS"),
        pytest.param("SIS.DRAGON", "SIS", id="translates SIS.DRAGON to SIS"),
        pytest.param("AUTREVEC", "AUTRE", id="translates AUTREVEC to AUTRE"),
        pytest.param("FSI.HELIFSI", "AUTRE", id="translates FSI.HELIFSI to AUTRE"),
        pytest.param("SMUR", "SMUR", id="translates SMUR to SMUR"),
        pytest.param("SMUR.VLM", "SMUR", id="translates SMUR.VLM to SMUR"),
        pytest.param("TSU.VSL", "AUTRE", id="translates TSU.VSL to AUTRE"),
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
