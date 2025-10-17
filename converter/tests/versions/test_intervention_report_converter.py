from converter.versions.intervention_report.intervention_report_converter import (
    InterventionReportConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint


def get_v3_schema():
    v3_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.RS_BPV_TAG
    )
    return TestHelper.load_json_file_online(v3_schema_endpoint)


def get_v2_schema():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.RS_BPV_TAG
    )
    return TestHelper.load_json_file_online(v2_schema_endpoint)


def test_v2_to_v3_upgrade():
    v3_schema = get_v3_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_BPV_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=InterventionReportConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


def test_v3_to_v2_downgrade():
    v2_schema = get_v2_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_BPV_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=InterventionReportConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )
