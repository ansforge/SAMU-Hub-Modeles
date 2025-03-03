from converter.constants import Constants
from converter.v1_v2_converter import V1_V2Converter
from .test_helpers import TestHelper


def get_file_endpoint(version_tag: str):
    return f"https://raw.githubusercontent.com/ansforge/SAMU-Hub-Modeles/{version_tag}/src/main/resources/json-schema/RS-EDA.schema.json"

def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(Constants.V2_GITHUB_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=V1_V2Converter.upgrade,
        target_schema=v2_schema,
        online_tag=Constants.V1_GITHUB_TAG
    )

def test_V2_to_V1_downgrade():
    v1_schema_endpoint = get_file_endpoint(Constants.V1_GITHUB_TAG)
    v1_schema = TestHelper.load_json_file_online(v1_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=Constants.RS_EDA_TAG,
        envelope_file=Constants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=V1_V2Converter.downgrade,
        target_schema=v1_schema,
        online_tag=Constants.V2_GITHUB_TAG
    )
