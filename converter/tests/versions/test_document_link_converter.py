from converter.versions.document_link.document_link_converter import (
    DocumentLinkConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint


def test_v2_to_v3_upgrade():
    v3_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.RS_URL_TAG
    )
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_URL_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=DocumentLinkConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


def test_v3_to_v2_downgrade():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.RS_URL_TAG
    )
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_URL_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=DocumentLinkConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )
