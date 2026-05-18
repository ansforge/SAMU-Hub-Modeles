import unittest
from unittest.mock import patch
import pytest
from converter.conversion_strategy.conversion_strategy import conversion_strategy
from converter.constants import ConversionType


class TestConversionStrategy(unittest.TestCase):
    @patch(
        "converter.conversion_strategy.conversion_strategy.cisu_transcoding_strategy"
    )
    def test_conversion_strategy_with_cisu_conversion(
        self, mock_cisu_transcoding_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        conversion_type = ConversionType.CISUTranscoding

        conversion_strategy(edxl_json, source_version, target_version, conversion_type)

        mock_cisu_transcoding_strategy.assert_called_once_with(
            edxl_json, source_version, target_version
        )

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_version_conversion_strategy"
    )
    def test_conversion_strategy_with_health_conversion(
        self, mock_health_version_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        conversion_type = ConversionType.HealthVersionConversion

        conversion_strategy(edxl_json, source_version, target_version, conversion_type)

        mock_health_version_conversion_strategy.assert_called_once_with(
            edxl_json, source_version, target_version
        )

    def test_conversion_strategy_with_cisu_version_conversion_raises_not_implemented(
        self,
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        conversion_type = ConversionType.CISUVersionConversion

        with pytest.raises(
            NotImplementedError,
            match="Conversion strategy 'cisu_version_conversion_strategy' not yet implemented.",
        ):
            conversion_strategy(
                edxl_json, source_version, target_version, conversion_type
            )

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_version_conversion_strategy"
    )
    def test_conversion_strategy_wraps_single_dict_in_list(
        self, mock_health_version_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        conversion_type = ConversionType.HealthVersionConversion
        single_message = {"distributionID": "single-message"}
        mock_health_version_conversion_strategy.return_value = single_message

        converted_edxl = conversion_strategy(
            edxl_json, source_version, target_version, conversion_type
        )

        assert isinstance(converted_edxl, list)
        assert converted_edxl == [single_message]

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_version_conversion_strategy"
    )
    def test_conversion_strategy_preserves_list_result(
        self, mock_health_version_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        conversion_type = ConversionType.HealthVersionConversion
        list_message = [{"distributionID": "msg-1"}, {"distributionID": "msg-2"}]
        mock_health_version_conversion_strategy.return_value = list_message

        converted_edxl = conversion_strategy(
            edxl_json, source_version, target_version, conversion_type
        )

        assert isinstance(converted_edxl, list)
        assert converted_edxl == list_message


if __name__ == "__main__":
    unittest.main()
