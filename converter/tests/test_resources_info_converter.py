import json
from snapshottest import TestCase
from converter.constants import Constants
from converter.versions.resources_info.resources_info_converter import ResourcesInfoConverter
from .test_helpers import TestHelper, get_file_endpoint

def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG, Constants.RS_RI_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_RI_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=ResourcesInfoConverter.convert_v1_to_v2,
        target_schema=v2_schema,
        online_tag=Constants.V1_GITHUB_TAG
    )

class TestSnapshotV1V2Converter(TestCase):
    def test_exhaustive_snapshot_V1_to_V2_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V1.0_exhaustive_fill.json"
        )
        output_data = ResourcesInfoConverter.convert_v1_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_fields_snapshot_V1_to_V2_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V1.0_required_fields.json"
        )
        output_data = ResourcesInfoConverter.convert_v1_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

def test_V2_to_V1_downgrade():
    v1_schema_endpoint = get_file_endpoint(Constants.V1_GITHUB_TAG, Constants.RS_RI_TAG)
    v1_schema = TestHelper.load_json_file_online(v1_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_RI_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=ResourcesInfoConverter.convert_v2_to_v1,
        target_schema=v1_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )

class TestSnapshotV2V1Converter(TestCase):
    def test_exhaustive_snapshot_V2_to_V1_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V2.0_exhaustive_fill.json"
        )
        output_data = ResourcesInfoConverter.convert_v2_to_v1(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_fields_snapshot_V2_to_V1_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V2.0_required_fields.json"
        )
        output_data = ResourcesInfoConverter.convert_v2_to_v1(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

def test_V2_to_V3_upgrade():
    v3_schema_endpoint = get_file_endpoint(Constants.V3_GITHUB_TAG, Constants.RS_RI_TAG)
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_RI_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=ResourcesInfoConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )

class TestSnapshotV2V3Converter(TestCase):
    def test_exhaustive_snapshot_V2_to_V3_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V2.0_exhaustive_fill.json"
        )
        output_data = ResourcesInfoConverter.convert_v2_to_v3(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_fields_snapshot_V2_to_V3_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V2.0_required_fields.json"
        )
        output_data = ResourcesInfoConverter.convert_v2_to_v3(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_exhaustive_snapshot_V3_to_V2_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V3.0_exhaustive_fill.json"
        )
        output_data = ResourcesInfoConverter.convert_v3_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    def test_required_fields_snapshot_V3_to_V2_upgrade(self):
        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-RI/RS-RI_V3.0_required_fields.json"
        )
        output_data = ResourcesInfoConverter.convert_v3_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))
