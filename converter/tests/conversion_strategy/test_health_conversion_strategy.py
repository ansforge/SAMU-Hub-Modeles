import unittest
from typing import Tuple, Dict
from unittest.mock import patch

from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestConversionStrategy(unittest.TestCase):
    def test_health_conversion_strategy_raise_error_when_converting_unsupported_message_type(
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
            ]
        }
        source_version = "v1"
        target_version = "v2"

        with self.assertRaisesRegex(
            ValueError,
            "Version conversion for message type 'notSupportedMessageType' is currently not implemented.",
        ):
            health_conversion_strategy(edxl_json, source_version, target_version)

    @staticmethod
    def run_health_conversion_strategy(message_type: str) -> Tuple[str, str, Dict]:
        message_json_path = TestHelper.get_json_files(message_type)[0]["path"]
        edxl_json = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH, message_json_path
        )
        source_version = "v1"
        target_version = "v2"

        health_conversion_strategy(edxl_json, source_version, target_version)

        return source_version, target_version, edxl_json

    @patch(
        "converter.versions.create_case_health.create_case_health_converter.CreateHealthCaseConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_create_case_health_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_EDA_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.create_case_health.create_case_health_update_converter.CreateHealthUpdateCaseConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_create_case_health_update_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_EDA_MAJ_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.reference.reference_converter.ReferenceConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_reference_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RC_REF_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch("converter.versions.error_converter.ErrorConverter.convert")
    def test_health_conversion_strategy_should_convert_error_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_ERROR_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.resources_status.resources_status_converter.ResourcesStatusConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_resources_status_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_SR_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.resources_info.resources_info_converter.ResourcesInfoConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_resources_info_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_RI_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.resources_response.resources_response_converter.ResourcesResponseConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_resources_response_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_RR_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.resources_request.resources_request_converter.ResourcesRequestConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_resources_request_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_DR_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.resources_engagement.resources_engagement_converter.ResourcesEngagementConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_resources_engagement_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_ER_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.geo_positions_update.geo_positions_update_converter.GeoPositionsUpdateConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_geo_positions_update_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.GEO_POS_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.identical_message_converter.IdenticalMessageConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_geo_resources_requests_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.GEO_REQ_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.geo_resources_details.geo_resources_details_converter.GeoResourcesDetailsConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_geo_resources_details_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.GEO_RES_TAG)
        mock_convert.assert_called_once_with(*args)

    @patch(
        "converter.versions.intervention_report.intervention_report_converter.InterventionReportConverter.convert"
    )
    def test_health_conversion_strategy_should_convert_intervention_report_message(
        self, mock_convert
    ):
        args = self.run_health_conversion_strategy(TestConstants.RS_BPV_TAG)
        mock_convert.assert_called_once_with(*args)
