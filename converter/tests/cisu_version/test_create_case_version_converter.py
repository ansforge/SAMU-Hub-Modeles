import unittest

from converter.cisu_version_converters.create_case.rc_eda_version_converter import (
    CreateCaseVersionConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestCreateCaseVersionConverter(unittest.TestCase):
    def setUp(self):
        self.edxl_envelope_health_to_fire_path = (
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH
        )
        self.edxl_envelope_fire_to_health_path = (
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH
        )
        self.fixtures_folder_path = "tests/fixtures/"
        self.converter = CreateCaseVersionConverter

    def test_v3_to_vactive(self):
        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill.json",
        )
        converted_message = self.converter.convert_v3_to_vactive(message)
        assert converted_message == message

    def test_vactive_to_v3(self):
        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill.json",
        )
        converted_message = self.converter.convert_vactive_to_v3(message)
        assert converted_message == message
