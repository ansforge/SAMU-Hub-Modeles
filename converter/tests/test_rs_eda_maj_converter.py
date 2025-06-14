from converter.constants import Constants
from converter.versions.create_case_health_update_converter import CreateHealthUpdateCaseConverter
from .test_helpers import TestHelper, get_file_endpoint

def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG, Constants.RS_EDA_MAJ_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_MAJ_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v1_to_v2,
        target_schema=v2_schema,
        online_tag=Constants.V1_GITHUB_TAG
    )

def test_V2_to_V1_upgrade():
    v1_schema_endpoint = get_file_endpoint(Constants.V1_GITHUB_TAG, Constants.RS_EDA_MAJ_TAG)
    v1_schema = TestHelper.load_json_file_online(v1_schema_endpoint)



    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_MAJ_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v2_to_v1,
        target_schema=v1_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )

def test_V3_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG, Constants.RS_EDA_MAJ_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_MAJ_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=Constants.V3_GITHUB_TAG
    )

def test_V2_to_V3_upgrade():
    v3_schema_endpoint = get_file_endpoint(Constants.V3_GITHUB_TAG, Constants.RS_EDA_MAJ_TAG)
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_MAJ_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthUpdateCaseConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )
