import json
from snapshottest import TestCase
from converter.constants import Constants
from converter.versions.reference.reference_converter import ReferenceConverter
from tests.test_helpers import TestHelper

class TestSnapshotV2V3Converter(TestCase):
    def test_exhaustive_snapshot_V2_to_V3_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-REF/RC-REF_V3.0_exhaustive_fill.json"
        )
        output_data = ReferenceConverter.convert_v3_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))
