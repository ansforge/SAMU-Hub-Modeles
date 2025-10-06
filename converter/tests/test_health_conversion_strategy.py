import unittest
from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)


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


if __name__ == "__main__":
    unittest.main()
