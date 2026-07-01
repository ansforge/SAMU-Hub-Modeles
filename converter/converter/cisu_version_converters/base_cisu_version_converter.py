from typing import Any, Dict

from converter.conversion_mixin import ConversionMixin
from converter.cisu_transcoders.constants import CISUConstants


class BaseCISUVersionConverter(ConversionMixin):
    def __init__(self):
        raise ValueError(
            "BaseCISUVersionConverter is an abstract class and cannot be instantiated directly. Use a subclass instead."
        )

    @classmethod
    def convert_v3_to_vactive(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        raise NotImplementedError("convert_v3_to_vactive not implemented yet.")

    @classmethod
    def convert_vactive_to_v3(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        raise NotImplementedError("convert_vactive_to_v3 not implemented yet.")

    @classmethod
    def get_message_type(cls) -> str:
        raise NotImplementedError(
            "Subclasses must implement this method to return the message type in RS specifications."
        )

    @classmethod
    def convert(
        cls, source_version: str, target_version: str, edxl_json: Dict[str, Any]
    ):
        if (
            source_version == CISUConstants.CISU_EXPECTED_MODEL_VERSION
            and target_version
            == CISUConstants.HEALTH_EXPECTED_VERSION_FOR_CISU_CONVERSION
        ):
            return cls.convert_vactive_to_v3(edxl_json)
        elif (
            source_version == CISUConstants.HEALTH_EXPECTED_VERSION_FOR_CISU_CONVERSION
            and target_version == CISUConstants.CISU_EXPECTED_MODEL_VERSION
        ):
            return cls.convert_v3_to_vactive(edxl_json)
        else:
            raise ValueError(
                f"CISU version conversion from '{source_version}' to '{target_version}' for message type '{cls.get_message_type()}' is currently not implemented."
            )
