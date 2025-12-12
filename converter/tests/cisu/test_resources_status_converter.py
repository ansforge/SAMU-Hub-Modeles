import json
from snapshottest import TestCase
from converter.cisu.resources_status.resources_status_converter import (
    ResourcesStatusConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

RS_SR_SCHEMA = TestHelper.load_schema("RS-SR.schema.json")
RC_SR_SCHEMA = TestHelper.load_schema("RC-SR.schema.json")


class TestResourcesStatusConverter(TestCase):
    def test_exhaustive_snapshot_rs_to_cisu(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-SR/RS-SR_V3.0_exhaustive_fill.json",
        )
        output_data = ResourcesStatusConverter.from_rs_to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_exhaustive_snapshot_cisu_to_rs(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-SR/RC-SR_V3.0_exhaustive_fill.json",
        )
        output_data = ResourcesStatusConverter.from_cisu_to_rs(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_snapshot_rs_to_cisu(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-SR/RS-SR_V3.0_required_fields.json",
        )
        output_data = ResourcesStatusConverter.from_rs_to_cisu(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_snapshot_cisu_to_rs(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RC-SR/RC-SR_V3.0_required_fields.json",
        )
        output_data = ResourcesStatusConverter.from_cisu_to_rs(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_rs_to_cisu(self):
        TestHelper.conversion_tests_runner(
            sample_dir=TestConstants.RS_SR_TAG,
            envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
            converter_method=ResourcesStatusConverter.from_rs_to_cisu,
            target_schema=RC_SR_SCHEMA,
        )

    def test_cisu_to_rs(self):
        TestHelper.conversion_tests_runner(
            sample_dir=TestConstants.RC_SR_TAG,
            envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
            converter_method=ResourcesStatusConverter.from_cisu_to_rs,
            target_schema=RS_SR_SCHEMA,
        )
