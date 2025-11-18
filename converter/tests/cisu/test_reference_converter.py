import json
from snapshottest import TestCase
from converter.cisu.reference.reference_converter import ReferenceConverter
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestSnapshotReferenceConverter(TestCase):
    def test_exhaustive_snapshot_rs_to_cisu(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        output_data = ReferenceConverter.from_rs_to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_exhaustive_snapshot_cisu_to_rs(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json",
        )
        output_data = ReferenceConverter.from_cisu_to_rs(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))
