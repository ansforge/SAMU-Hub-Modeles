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


if __name__ == "__main__":
    unittest.main()
