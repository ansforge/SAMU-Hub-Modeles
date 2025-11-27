import unittest
from unittest.mock import patch

from converter.conversion_strategy.cisu_conversion_strategy import (
    cisu_conversion_strategy,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestCisuConversionStrategy(unittest.TestCase):
    def test_cisu_conversion_strategy_raise_error_when_converting_unsupported_message_type(
        self,
    ):
        edxl_json = {
            "content": [
                {
                    "jsonContent": {
                        "embeddedJsonContent": {
                            "message": {"notSupportedMessageType": {}}
                        }
                    }
                }
            ],
            "senderID": "senderId",
            "descriptor": {"explicitAddress": {"explicitAddressValue": "recipientId"}},
        }
        source_version = "v1"
        target_version = "v3"

        with self.assertRaisesRegex(
            ValueError,
            "Perimeter translation for message type 'notSupportedMessageType' is not implemented.",
        ):
            cisu_conversion_strategy(edxl_json, source_version, target_version)

    @staticmethod
    def run_rs_to_cisu_conversion_strategy(message_type: str) -> None:
        message_json_path = TestHelper.get_json_files(message_type)[0]["path"]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, message_json_path
        )
        source_version = "v1"
        target_version = "v3"

        cisu_conversion_strategy(edxl_json, source_version, target_version)

    @patch(
        "converter.cisu.create_case.create_case_cisu_converter.CreateCaseCISUConverter.from_rs_to_cisu"
    )
    def test_rs_to_cisu_conversion_strategy_should_convert_create_case_message(
        self, mock_convert
    ):
        self.run_rs_to_cisu_conversion_strategy(TestConstants.RS_EDA_TAG)
        mock_convert.assert_called_once()

    @patch(
        "converter.cisu.resources_info.resources_info_cisu_converter.ResourcesInfoCISUConverter.from_rs_to_cisu"
    )
    def test_rs_to_cisu_conversion_strategy_should_convert_resources_info_message(
        self, mock_convert
    ):
        self.run_rs_to_cisu_conversion_strategy(TestConstants.RS_RI_TAG)
        mock_convert.assert_called_once()

    @patch(
        "converter.cisu.reference.reference_converter.ReferenceConverter.from_rs_to_cisu"
    )
    def test_rs_to_cisu_conversion_strategy_should_convert_reference_message(
        self, mock_convert
    ):
        self.run_rs_to_cisu_conversion_strategy(TestConstants.RC_REF_TAG)
        mock_convert.assert_called_once()

    @staticmethod
    def run_cisu_to_rs_conversion_strategy(message_type: str) -> None:
        message_json_path = TestHelper.get_json_files(message_type)[0]["path"]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, message_json_path
        )
        source_version = "v3"
        target_version = "v3"

        cisu_conversion_strategy(edxl_json, source_version, target_version)

    @patch(
        "converter.cisu.create_case.create_case_cisu_converter.CreateCaseCISUConverter.from_cisu_to_rs"
    )
    @patch(
        "converter.conversion_strategy.cisu_conversion_strategy.health_conversion_strategy"
    )
    def test_cisu_to_rs_conversion_strategy_should_convert_create_case_message(
        self, mock_health_convert_strategy, mock_convert
    ):
        self.run_cisu_to_rs_conversion_strategy(TestConstants.RS_EDA_TAG)
        mock_convert.assert_called_once()
        mock_health_convert_strategy.assert_called_once()

    @patch(
        "converter.cisu.resources_info.resources_info_cisu_converter.ResourcesInfoCISUConverter.from_cisu_to_rs"
    )
    @patch(
        "converter.conversion_strategy.cisu_conversion_strategy.health_conversion_strategy"
    )
    def test_cisu_to_rs_conversion_strategy_should_convert_resources_info_message(
        self, mock_health_convert_strategy, mock_convert
    ):
        self.run_cisu_to_rs_conversion_strategy(TestConstants.RS_RI_TAG)
        mock_convert.assert_called_once()
        mock_health_convert_strategy.assert_called_once()

    @patch(
        "converter.cisu.reference.reference_converter.ReferenceConverter.from_cisu_to_rs"
    )
    @patch(
        "converter.conversion_strategy.cisu_conversion_strategy.health_conversion_strategy"
    )
    def test_cisu_to_rs_conversion_strategy_should_convert_reference_message(
        self, mock_health_convert_strategy, mock_convert
    ):
        self.run_cisu_to_rs_conversion_strategy(TestConstants.RC_REF_TAG)
        mock_convert.assert_called_once()
        mock_health_convert_strategy.assert_called_once()

    def test_rs_to_cisu_conversion_strategy_should_raise_error_with_invalid_target_version(
        self,
    ):
        message_json_path = TestHelper.get_json_files(TestConstants.RS_EDA_TAG)[0][
            "path"
        ]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, message_json_path
        )
        invalid_target_version = "v1"

        with self.assertRaisesRegex(
            ValueError,
            "Unknown target version v1. Must be: v3",
        ):
            cisu_conversion_strategy(edxl_json, "v1", invalid_target_version)

    def test_cisu_to_rs_conversion_strategy_should_raise_error_with_invalid_source_version(
        self,
    ):
        message_json_path = TestHelper.get_json_files(TestConstants.RC_EDA_TAG)[0][
            "path"
        ]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, message_json_path
        )
        invalid_source_version = "v1"

        with self.assertRaisesRegex(
            ValueError,
            "Unknown source version v1. Must be: v3",
        ):
            cisu_conversion_strategy(edxl_json, invalid_source_version, "v1")
