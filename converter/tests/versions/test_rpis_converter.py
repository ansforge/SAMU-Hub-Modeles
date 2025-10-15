from converter.versions.rpis.rpis_converter import RpisConverter
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate


def get_v3_schema():
    v3_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.RS_RPIS_TAG
    )
    return TestHelper.load_json_file_online(v3_schema_endpoint)


def get_v2_schema():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.RS_RPIS_TAG
    )
    return TestHelper.load_json_file_online(v2_schema_endpoint)


def test_v2_to_v3_upgrade():
    v3_schema = get_v3_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_RPIS_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=RpisConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


def test_v3_to_v2_downgrade():
    v2_schema = get_v2_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_RPIS_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=RpisConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )


def test_v2_to_v3_upgrade_tsu():
    v3_schema = get_v3_schema()
    message_raw_v2 = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-RPIS/RS-RPIS_V2.0_TSU.json",
    )
    message_raw_v3 = RpisConverter.convert_v2_to_v3(message_raw_v2)
    message_v3 = RpisConverter.copy_input_use_case_content(message_raw_v3)

    validate(message_v3, v3_schema)


def test_v3_to_v2_downgrade_tsu_sans():
    v2_schema = get_v2_schema()
    message_raw_v3 = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-RPIS/RS-RPIS_V3.0_TSU_SANS.json",
    )
    message_raw_v2 = RpisConverter.convert_v3_to_v2(message_raw_v3)
    message_v2 = RpisConverter.copy_input_use_case_content(message_raw_v2)

    validate(message_v2, v2_schema)
