from unittest import TestCase

from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate

RS_RI_SCHEMA = TestHelper.load_schema("RS-RI.schema.json")


def test_rs_to_cisu():
    rc_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_RC_RI_TAG, TestConstants.RC_RI_TAG
    )
    rc_schema = TestHelper.load_json_file_online(rc_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_RI_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=ResourcesInfoCISUConverter.from_rs_to_cisu,
        target_schema=rc_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )


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


def test_rs_to_cisu_should_keep_latest_state():
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


class TestTranslateToCISUVehicleType(TestCase):
    def test_translate_SIS(self):
        rs_vehicle_type = "SIS"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SIS")

    def test_translate_SIS_DRAGON(self):
        rs_vehicle_type = "SIS.DRAGON"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SIS")

    def test_translate_AUTREVEC(self):
        rs_vehicle_type = "AUTREVEC"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SMUR")

    def test_translate_FSI_HELIFSI(self):
        rs_vehicle_type = "FSI.HELIFSI"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SMUR")

    def test_translate_SMUR(self):
        rs_vehicle_type = "SMUR"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SMUR")

    def test_translate_SMUR_VLM(self):
        rs_vehicle_type = "SMUR.VLM"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SMUR")

    def test_translate_TSU_VSL(self):
        rs_vehicle_type = "TSU.VSL"
        cisu_vehicle_type = ResourcesInfoCISUConverter.translate_to_cisu_vehicle_type(
            rs_vehicle_type
        )
        self.assertEqual(cisu_vehicle_type, "SMUR")
