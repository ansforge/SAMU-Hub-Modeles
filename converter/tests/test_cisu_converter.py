import unittest
from unittest.mock import patch
from converter.cisu_converter import CISUConverterV3
from .test_helpers import TestHelper
import json
from snapshottest import TestCase
from datetime import datetime
import pytest
import random

# Load schemas once for all tests
EDXL_FULL_SCHEMA = TestHelper.load_schema("EDXL-DE-full.schema.json")
RS_EDA_SCHEMA = TestHelper.load_schema("RS-EDA.schema.json")
RC_EDA_SCHEMA = TestHelper.load_schema("RC-EDA.schema.json")

def test_from_cisu_conversion_local():
    """Test conversion from CISU to Health format"""
    def validate_health_format(result):
        assert 'owner' in result, "Health format must contain owner field"

    TestHelper.conversion_tests_runner(
        sample_dir="RC-EDA",
        envelope_file="tests/edxl_envelope_fire_to_health.json",
        converter_method=CISUConverterV3.from_cisu,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=validate_health_format
    )

def test_to_cisu_conversion_local():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir="RS-EDA",
        envelope_file="tests/edxl_envelope_health_to_fire.json",
        converter_method=CISUConverterV3.to_cisu,
        target_schema=RC_EDA_SCHEMA
    )

def test_from_cisu_conversion_v3():
    """Test conversion from CISU to Health format"""
    def validate_health_format(result):
        assert 'owner' in result, "Health format must contain owner field"

    TestHelper.conversion_tests_runner(
        sample_dir="RC-EDA",
        envelope_file="tests/edxl_envelope_fire_to_health.json",
        converter_method=CISUConverterV3.from_cisu,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=validate_health_format,
        online_tag="main"  # ToDo: migrate to "v3" once tag is available
    )

def test_to_cisu_conversion_v3():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir="RS-EDA",
        envelope_file="tests/edxl_envelope_health_to_fire.json",
        converter_method=CISUConverterV3.to_cisu,
        target_schema=RC_EDA_SCHEMA,
        online_tag="main"  # ToDo: migrate to "v3" once tag is available
    )


class TestSnapshotCisuConverter(TestCase):
    def setUp(self):
        self.edxl_envelope_health_to_fire_path = "tests/edxl_envelope_health_to_fire.json"
        self.edxl_envelope_fire_to_health_path = "tests/edxl_envelope_fire_to_health.json"
        self.fixtures_folder_path = "tests/fixtures/"

    @patch('converter.cisu_converter.datetime')
    @patch('converter.cisu_converter.random')
    def test_snapshot_RS_EDA_exhaustive_message(self, mock_choices, mock_now):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(self.edxl_envelope_health_to_fire_path, self.fixtures_folder_path + "RS-EDA_exhaustive_fill.json")
        converter = CISUConverterV3()

        output_data = converter.to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_snapshot_RC_EDA_exhaustive_message(self):
        message = TestHelper.create_edxl_json_from_sample(self.edxl_envelope_fire_to_health_path, self.fixtures_folder_path + "RC-EDA_exhaustive_fill.json")
        converter = CISUConverterV3()

        output_data = converter.from_cisu(message)
        print(output_data['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']['initialAlert']['notes'])
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.cisu_converter.datetime")
    @patch('converter.cisu_converter.random')
    def test_snapshot_RS_EDA_required_field_message(self,mock_choices, mock_now):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(self.edxl_envelope_health_to_fire_path, self.fixtures_folder_path + "RS-EDA_required_fields.json")
        converter = CISUConverterV3()

        output_data = converter.to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_snapshot_RC_EDA_required_field_message(self):
        message = TestHelper.create_edxl_json_from_sample(self.edxl_envelope_fire_to_health_path, self.fixtures_folder_path + "RC-EDA_required_fields.json")
        converter = CISUConverterV3()

        output_data = converter.from_cisu(message)

        self.assertMatchSnapshot(json.dumps(output_data, indent=2))


if __name__ == "__main__":
    unittest.main()
