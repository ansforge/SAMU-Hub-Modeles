import datetime
import json
from unittest.mock import patch

from converter.utils import get_field_value, extract_message_content
from converter.versions.create_case_health.create_case_health_converter import (
    CreateHealthCaseConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from snapshottest import TestCase
from jsonschema import validate


def get_v1_schema():
    v1_schema_endpoint = get_file_endpoint(
        TestConstants.V1_GITHUB_TAG, TestConstants.RS_EDA_TAG
    )
    return TestHelper.load_json_file_online(v1_schema_endpoint)


def get_v2_schema():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.RS_EDA_TAG
    )
    return TestHelper.load_json_file_online(v2_schema_endpoint)


def test_V1_to_V2_upgrade():
    v2_schema = get_v2_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v1_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V1_GITHUB_TAG,
    )


def test_V2_to_V1_downgrade():
    v1_schema = get_v1_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateHealthCaseConverter.convert_v2_to_v1,
        target_schema=v1_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


class TestSnapshotV1V2Converter(TestCase):
    @patch("converter.utils.random")
    def test_snapshot_V1_to_V2_upgrade(self, mock_choices):
        mock_choices.choices.side_effect = [
            "f5de7hj",
            "a3b2YH8",
            "c9d8jk9",
            "he9i0kz",
            "ye7jk6k",
            "pe9rd2t",
            "4h8rh7h",
            "67jfq0l",
            "uh88l1h",
        ]

        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V1.0_exhaustive_fill.json",
        )
        validate(
            message["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
                "createCaseHealth"
            ],
            get_v1_schema(),
        )
        output_data = CreateHealthCaseConverter.convert_v1_to_v2(message)

        self.assertMatchSnapshot(json.dumps(output_data, indent=2))

    @patch("converter.versions.create_case_health.v1_v2.utils.datetime")
    @patch("converter.utils.random")
    def test_snapshot_V2_to_V1_downgrade(self, mock_choices, mock_datetime):
        mock_choices.choices.side_effect = [
            "f5de7hj",
            "a3b2YH8",
            "c9d8jk9",
            "he9i0kz",
            "ye7jk6k",
            "pe9rd2t",
            "4h8rh7h",
            "67jfq0l",
            "uh88l1h",
        ]
        mock_datetime.datetime.now.return_value = datetime.datetime(2025, 1, 1, 0, 0, 0)
        mock_datetime.datetime.strftime = datetime.datetime.strftime

        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
            "tests/fixtures/RS-EDA/RS-EDA_V2.0_exhaustive_fill_bis.json",
        )
        output_data = CreateHealthCaseConverter.convert_v2_to_v1(message)

        self.maxDiff = None
        self.assertMatchSnapshot(json.dumps(output_data, indent=2))


def test_upgrade_with_unknown_v2_language_code():
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-EDA/RS-EDA_V1.0_unknown_v2_language.json",
    )
    converted_message = CreateHealthCaseConverter.convert_v1_to_v2(message)
    converted_message_content = extract_message_content(converted_message)[
        "createCaseHealth"
    ]
    validate(converted_message_content, get_v2_schema())

    language = get_field_value(
        converted_message_content, "$.initialAlert.caller.language"
    )
    assert language is None
    notes = get_field_value(converted_message_content, "$.initialAlert.notes")
    assert len(notes) > 1
    assert "Langue du requérant: AX" in notes[-1]["freetext"]


def test_upgrade_with_no_language_field_v1_to_v2():
    """Test that when language field is not provided, no note is created (v1->v2)"""
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-EDA/RS-EDA_V1.0_no_language.json",
    )
    converted_message = CreateHealthCaseConverter.convert_v1_to_v2(message)
    converted_message_content = extract_message_content(converted_message)[
        "createCaseHealth"
    ]
    validate(converted_message_content, get_v2_schema())

    # Language field should not be present
    language = get_field_value(
        converted_message_content, "$.initialAlert.caller.language"
    )
    assert language is None

    # No note should be added about language
    notes = get_field_value(converted_message_content, "$.initialAlert.notes")
    assert len(notes) == 1
    # Verify no note contains any language mention
    for note in notes:
        assert "Langue du requérant" not in note["freetext"]


def test_upgrade_with_no_language_field_v1_to_v3():
    """Test that when language field is not provided, no note is created (v1->v3)"""
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-EDA/RS-EDA_V1.0_no_language.json",
    )
    converted_message = CreateHealthCaseConverter.convert("v1", "v3", message)
    converted_message_content = extract_message_content(converted_message)[
        "createCaseHealth"
    ]

    # Language field should not be present
    language = get_field_value(
        converted_message_content, "$.initialAlert.caller.language"
    )
    assert language is None

    # No note should be added about language
    notes = get_field_value(converted_message_content, "$.initialAlert.notes")
    assert len(notes) == 1
    # Verify no note contains any language mention
    for note in notes:
        assert "Langue du requérant" not in note["freetext"]
