import unittest
from unittest.mock import patch
from converter.cisu.cisu_converter import CISUConverterV3
from tests.constants import TestConstants
from .test_helpers import TestHelper
import json
from snapshottest import TestCase
from datetime import datetime

# Load schemas once for all tests
EDXL_FULL_SCHEMA = TestHelper.load_schema("EDXL-DE-full.schema.json")
RS_EDA_SCHEMA = TestHelper.load_schema("RS-EDA.schema.json")
RC_EDA_SCHEMA = TestHelper.load_schema("RC-EDA.schema.json")


def test_from_cisu_conversion_local():
    """Test conversion from CISU to Health format"""

    def validate_health_format(result):
        assert "owner" in result, "Health format must contain owner field"

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RC_EDA_TAG,
        envelope_file=TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CISUConverterV3.from_cisu,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=validate_health_format,
    )


def test_to_cisu_conversion_local():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=CISUConverterV3.to_cisu,
        target_schema=RC_EDA_SCHEMA,
    )


def test_from_cisu_conversion_v3():
    """Test conversion from CISU to Health format"""

    def validate_health_format(result):
        assert "owner" in result, "Health format must contain owner field"

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RC_EDA_TAG,
        envelope_file=TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CISUConverterV3.from_cisu,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=validate_health_format,
        online_tag="main",  # ToDo: migrate to "v3" once tag is available
    )


def test_to_cisu_conversion_v3():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=CISUConverterV3.to_cisu,
        target_schema=RC_EDA_SCHEMA,
        online_tag="main",  # ToDo: migrate to "v3" once tag is available
    )


class TestSnapshotCisuConverter(TestCase):
    def setUp(self):
        self.edxl_envelope_health_to_fire_path = (
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH
        )
        self.edxl_envelope_fire_to_health_path = (
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH
        )
        self.fixtures_folder_path = "tests/fixtures/"

    @patch("converter.cisu.cisu_converter.datetime")
    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RS_EDA_exhaustive_message(self, mock_choices, mock_now):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RS-EDA/cisu_case/RS-EDA_exhaustive_fill.json",
        )
        converter = CISUConverterV3()

        output_data = converter.to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RC_EDA_exhaustive_message(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill.json",
        )
        converter = CISUConverterV3()

        output_data = converter.from_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu.cisu_converter.datetime")
    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RS_EDA_required_field_message(self, mock_choices, mock_now):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RS-EDA/cisu_case/RS-EDA_required_fields.json",
        )
        converter = CISUConverterV3()

        output_data = converter.to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RC_EDA_required_field_message(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_required_fields.json",
        )
        converter = CISUConverterV3()

        output_data = converter.from_cisu(message)

        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu.cisu_converter.datetime")
    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RS_EDA_exhaustive_bis_message(self, mock_choices, mock_now):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path
            + "RS-EDA/cisu_case/RS-EDA_exhaustive_fill_bis.json",
        )
        converter = CISUConverterV3()

        output_data = converter.to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu.cisu_converter.random")
    def test_snapshot_RC_EDA_exhaustive_bis_message(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill_bis.json",
        )
        converter = CISUConverterV3()

        output_data = converter.from_cisu(message)

        self.assertMatchSnapshot(json.dumps(output_data, indent=2))


class TestVictimsCount(TestCase):
    def setUp(self):
        self.fixtures_folder_path = "tests/fixtures/"
        self.converter = CISUConverterV3()

    def test_count_victims_1(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_1.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients), {"count": "1"}
        )

    def test_count_victims_beaucoup(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_beaucoup.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients),
            {"count": "BEAUCOUP"},
        )

    def test_count_victims_plusieurs(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_plusieurs.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients),
            {"count": "PLUSIEURS"},
        )

    def test_count_victims_1(self):
        self.assertEqual(
            self.converter.get_victim_count(self.converter, {"patients": []}),
            {"count": "0"},
        )

    def test_count_victims_no_field(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "json_data_fixture.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients), {"count": "0"}
        )


if __name__ == "__main__":
    unittest.main()
