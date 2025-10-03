import json
from unittest.mock import patch
from converter.constants import Constants
from converter.versions.create_case_health.create_case_health_converter import CreateHealthCaseConverter
from tests.test_helpers import TestHelper, get_file_endpoint
from snapshottest import TestCase


def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG, Constants.RS_EDA_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v1_to_v2,
        target_schema=v2_schema,
        online_tag=Constants.V1_GITHUB_TAG
    )

def test_V2_to_V1_downgrade():
    v1_schema_endpoint = get_file_endpoint(Constants.V1_GITHUB_TAG, Constants.RS_EDA_TAG)
    v1_schema = TestHelper.load_json_file_online(v1_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v2_to_v1,
        target_schema=v1_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )

class TestSnapshotV1V2Converter(TestCase):
    @patch('converter.utils.random')
    def test_snapshot_V1_to_V2_upgrade(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9","he9i0kz", "ye7jk6k", "pe9rd2t","4h8rh7h", "67jfq0l", "uh88l1h"]

        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V1.0_exhaustive_fill.json"
        )
        output_data = CreateHealthCaseConverter.convert_v1_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch('converter.utils.random')
    def test_snapshot_V2_to_V1_downgrade(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9","he9i0kz", "ye7jk6k", "pe9rd2t","4h8rh7h", "67jfq0l", "uh88l1h"]

        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V2.0_exhaustive_fill_bis.json"
        )
        output_data = CreateHealthCaseConverter.convert_v2_to_v1(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))
