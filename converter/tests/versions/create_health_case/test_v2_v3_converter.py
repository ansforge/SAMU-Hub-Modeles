import json
from unittest.mock import patch
from converter.constants import Constants
from converter.versions.create_case_health.create_case_health_converter import CreateHealthCaseConverter
from tests.test_helpers import TestHelper, get_file_endpoint
from snapshottest import TestCase


def test_V2_to_V3_upgrade():
    v3_schema_endpoint = get_file_endpoint(Constants.V3_GITHUB_TAG, Constants.RS_EDA_TAG)
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )

def test_V3_to_V2_downgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG, Constants.RS_EDA_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=Constants.V3_GITHUB_TAG
    )

class TestSnapshotV2V3Converter(TestCase):
    @patch('converter.utils.random')
    def test_snapshot_V2_to_V3_upgrade(self,mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9","he9i0kz", "ye7jk6k", "pe9rd2t","4h8rh7h", "67jfq0l", "uh88l1h"]

        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V2.0_exhaustive_fill.json"
        )
        output_data = CreateHealthCaseConverter.convert_v2_to_v3(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch('converter.utils.random')
    def test_snapshot_V3_to_V2_downgrade(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9","he9i0kz", "ye7jk6k", "pe9rd2t","4h8rh7h", "67jfq0l", "uh88l1h"]

        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V3.0_exhaustive_fill.json"
        )

        output_data = CreateHealthCaseConverter.convert_v3_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch('converter.utils.random')
    def test_snapshot_V3_to_V2_bis_downgrade(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9","he9i0kz", "ye7jk6k", "pe9rd2t","4h8rh7h", "67jfq0l", "uh88l1h"]

        message = TestHelper.create_edxl_json_from_sample(
            Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V3.0_exhaustive_fill_bis.json"
        )

        output_data = CreateHealthCaseConverter.convert_v3_to_v2(message)
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))
