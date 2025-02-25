from converter.v1_v2_converter import V1_V2Converter
from .test_cisu_converter import RS_EDA_SCHEMA
from .test_helpers import TestHelper

# todo - refacto to move in a test constant file + use it where needed
V1_GITHUB_TAG = "v1.0.0-fix"
V2_GITHUB_TAG = "v2.0.0-fix"
EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH="tests/edxl_envelope_health_to_fire.json"

def get_file_endpoint(version_tag: str):
    return f"https://raw.githubusercontent.com/ansforge/SAMU-Hub-Modeles/{version_tag}/src/main/resources/json-schema/RS-EDA.schema.json"

def test_V1_to_V2_upgrade():
    v2_schema_endpoint = get_file_endpoint(V2_GITHUB_TAG)
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir="RS-EDA",
        envelope_file=EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=V1_V2Converter.upgrade,
        target_schema=v2_schema,
        online_tag=V1_GITHUB_TAG
    )
