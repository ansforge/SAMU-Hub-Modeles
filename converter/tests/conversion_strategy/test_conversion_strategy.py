import unittest
from unittest.mock import patch
from converter.conversion_strategy.conversion_strategy import conversion_strategy


class TestConversionStrategy(unittest.TestCase):
    @patch("converter.conversion_strategy.conversion_strategy.cisu_conversion_strategy")
    def test_conversion_strategy_with_cisu_conversion(
        self, mock_cisu_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        is_cisu_conversion = True

        conversion_strategy(
            edxl_json, source_version, target_version, is_cisu_conversion
        )

        mock_cisu_conversion_strategy.assert_called_once_with(
            edxl_json, source_version, target_version
        )

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_conversion_strategy"
    )
    def test_conversion_strategy_with_health_conversion(
        self, mock_health_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        is_cisu_conversion = False

        conversion_strategy(
            edxl_json, source_version, target_version, is_cisu_conversion
        )

        mock_health_conversion_strategy.assert_called_once_with(
            edxl_json, source_version, target_version
        )

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_conversion_strategy"
    )
    def test_conversion_strategy_wraps_single_dict_in_list(
        self, mock_health_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        is_cisu_conversion = False
        single_message = {"distributionID": "single-message"}
        mock_health_conversion_strategy.return_value = single_message

        converted_edxl = conversion_strategy(
            edxl_json, source_version, target_version, is_cisu_conversion
        )

        assert isinstance(converted_edxl, list)
        assert converted_edxl == [single_message]

    @patch(
        "converter.conversion_strategy.conversion_strategy.health_conversion_strategy"
    )
    def test_conversion_strategy_preserves_list_result(
        self, mock_health_conversion_strategy
    ):
        edxl_json = {}
        source_version = "source_version"
        target_version = "target_version"
        is_cisu_conversion = False
        list_message = [{"distributionID": "msg-1"}, {"distributionID": "msg-2"}]
        mock_health_conversion_strategy.return_value = list_message

        converted_edxl = conversion_strategy(
            edxl_json, source_version, target_version, is_cisu_conversion
        )

        assert isinstance(converted_edxl, list)
        assert converted_edxl == list_message


if __name__ == "__main__":
    unittest.main()
