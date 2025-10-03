from converter.versions.create_case_health.create_case_health_update_converter import CreateHealthUpdateCaseConverter
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint

def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(TestConstants.V2_GITHUB_TAG, TestConstants.RS_EDA_MAJ_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_MAJ_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v1_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V1_GITHUB_TAG
    )

def test_V2_to_V1_upgrade():
    v1_schema_endpoint = get_file_endpoint(TestConstants.V1_GITHUB_TAG, TestConstants.RS_EDA_MAJ_TAG)
    v1_schema = TestHelper.load_json_file_online(v1_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_MAJ_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v2_to_v1,
        target_schema=v1_schema,
        online_tag=TestConstants.V2_GITHUB_TAG
    )

def test_V3_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(TestConstants.V2_GITHUB_TAG, TestConstants.RS_EDA_MAJ_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_MAJ_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG
    )

def test_V2_to_V3_upgrade():
    v3_schema_endpoint = get_file_endpoint(TestConstants.V3_GITHUB_TAG, TestConstants.RS_EDA_MAJ_TAG)
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_MAJ_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG
    )
