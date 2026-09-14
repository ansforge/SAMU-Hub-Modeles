import unittest

from converter.cisu_version_converters.reference.reference_version_converter import (
    ReferenceCISUVersionConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestReferenceCisuVersionConverter(unittest.TestCase):
    def setUp(self):
        self.edxl_envelope_health_to_fire_path = (
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH
        )
        self.edxl_envelope_fire_to_health_path = (
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH
        )
        self.fixtures_folder_path = "tests/fixtures/"
        self.converter = ReferenceCISUVersionConverter

    @staticmethod
    def get_reference_content(edxl_json):
        return edxl_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "reference"
        ]

    def test_v3_to_vactive_strips_step(self):
        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        assert "step" in self.get_reference_content(message)

        converted_message = self.converter.convert_v3_to_vactive(message)

        assert "step" not in self.get_reference_content(converted_message)

    def test_vactive_to_v3_strips_step(self):
        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        assert "step" in self.get_reference_content(message)

        converted_message = self.converter.convert_vactive_to_v3(message)

        assert "step" not in self.get_reference_content(converted_message)

    def test_message_is_unmodified_when_step_is_absent(self):
        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        del self.get_reference_content(message)["step"]

        converted_message = self.converter.convert_v3_to_vactive(message)

        assert converted_message == message
