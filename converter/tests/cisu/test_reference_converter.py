import json
from converter.cisu_transcoders.reference.reference_converter import ReferenceConverter
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestSnapshotReferenceConverter:
    def test_exhaustive_snapshot_rs_to_cisu(self, snapshot):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        output_data = ReferenceConverter.from_rs_to_cisu(message)
        assert json.dumps(output_data, indent=2) == snapshot

    def test_exhaustive_snapshot_cisu_to_rs(self, snapshot):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        output_data = ReferenceConverter.from_cisu_to_rs(message)
        assert json.dumps(output_data, indent=2) == snapshot


class TestReferenceConverterStepRemoval:
    @staticmethod
    def get_reference_content(edxl_json):
        return edxl_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "reference"
        ]

    def test_step_is_removed_when_present(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        assert "step" in self.get_reference_content(message)

        output_data = ReferenceConverter.from_rs_to_cisu(message)

        assert "step" not in self.get_reference_content(output_data)

    def test_message_is_unmodified_when_step_is_absent(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        del self.get_reference_content(message)["step"]

        output_data = ReferenceConverter.from_rs_to_cisu(message)

        assert output_data == message

    def test_step_is_preserved_from_cisu_to_rs(self):
        """ "step" must only be stripped for messages going out to the fire
        brigades (from_rs_to_cisu); messages coming back from CISU are
        untouched."""
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        assert "step" in self.get_reference_content(message)

        output_data = ReferenceConverter.from_cisu_to_rs(message)

        assert self.get_reference_content(output_data) == self.get_reference_content(
            message
        )
