import unittest
from unittest.mock import patch, ANY

from converter.cisu_transcoders.constants import CISUConstants
from converter.conversion_strategy.cisu_version_conversion_strategy import (
    cisu_version_conversion_strategy,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

V3 = CISUConstants.HEALTH_EXPECTED_VERSION_FOR_CISU_CONVERSION
VACTIVE = CISUConstants.CISU_EXPECTED_MODEL_VERSION


class TestCisuVersionConversionStrategy(unittest.TestCase):
    @staticmethod
    def run_v3_to_vactive_cisu_version_conversion_strategy(message_type: str) -> None:
        message_json_path = TestHelper.get_json_files(message_type)[0]["path"]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH, message_json_path
        )
        cisu_version_conversion_strategy(edxl_json, V3, VACTIVE)

    @staticmethod
    def run_vactive_to_v3_cisu_version_conversion_strategy(message_type: str) -> None:
        message_json_path = TestHelper.get_json_files(message_type)[0]["path"]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, message_json_path
        )
        cisu_version_conversion_strategy(edxl_json, VACTIVE, V3)

    def test_cisu_version_conversion_strategy_raise_error_when_converting_unsupported_message_type(
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

        with self.assertRaisesRegex(
            ValueError,
            "Perimeter translation for message type 'notSupportedMessageType' is not implemented.",
        ):
            cisu_version_conversion_strategy(edxl_json, V3, VACTIVE)

    @patch(
        "converter.conversion_strategy.cisu_version_conversion_strategy.CreateCaseVersionConverter.convert"
    )
    def test_create_case_v3_to_vactive(self, mock_convert):
        self.run_v3_to_vactive_cisu_version_conversion_strategy(
            TestConstants.RC_EDA_TAG
        )

        mock_convert.assert_called_once_with(V3, VACTIVE, ANY)

    @patch(
        "converter.conversion_strategy.cisu_version_conversion_strategy.CreateCaseVersionConverter.convert"
    )
    def test_create_case_vactive_to_v3(self, mock_convert):
        self.run_vactive_to_v3_cisu_version_conversion_strategy(
            TestConstants.RC_EDA_TAG
        )

        mock_convert.assert_called_once_with(VACTIVE, V3, ANY)

    @patch(
        "converter.conversion_strategy.cisu_version_conversion_strategy.ResourcesInfoCISUVersionConverter.convert"
    )
    def test_resources_info_cisu_v3_to_vactive(self, mock_convert):
        self.run_v3_to_vactive_cisu_version_conversion_strategy(TestConstants.RC_RI_TAG)
        mock_convert.assert_called_once_with(V3, VACTIVE, ANY)

    @patch(
        "converter.conversion_strategy.cisu_version_conversion_strategy.ResourcesInfoCISUVersionConverter.convert"
    )
    def test_resources_info_cisu_vactive_to_v3(self, mock_convert):
        self.run_vactive_to_v3_cisu_version_conversion_strategy(TestConstants.RC_RI_TAG)
        mock_convert.assert_called_once_with(VACTIVE, V3, ANY)
