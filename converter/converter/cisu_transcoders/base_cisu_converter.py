from converter.conversion_mixin import ConversionMixin
from typing import Any, Dict


class BaseCISUConverter(ConversionMixin):
    def __init__(self):
        raise ValueError(
            "BaseMessageConverter is an abstract class and cannot be instantiated directly. Use a subclass instead."
        )

    @classmethod
    def get_rs_message_type(cls) -> str:
        raise NotImplementedError(
            "Subclasses must implement this method to return the message type in RS specifications."
        )

    @classmethod
    def get_cisu_message_type(cls) -> str:
        raise NotImplementedError(
            "Subclasses must implement this method to return the message type in RC specifications."
        )

    @classmethod
    def from_rs_to_cisu(cls, edxl_json):
        raise ValueError(
            f"Traduction from '{cls.get_rs_message_type()}' to '{cls.get_cisu_message_type()}' is not supported."
        )

    @classmethod
    def from_cisu_to_rs(cls, edxl_json):
        raise ValueError(
            f"Traduction from '{cls.get_cisu_message_type()}' to '{cls.get_rs_message_type()}' is not supported."
        )

    @classmethod
    def copy_cisu_input_content(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        return cls._copy_input_content(edxl_json, cls.get_cisu_message_type())

    @classmethod
    def copy_cisu_input_use_case_content(
        cls, edxl_json: Dict[str, Any]
    ) -> Dict[str, Any]:
        return cls._copy_input_use_case_content(edxl_json, cls.get_cisu_message_type())

    @classmethod
    def format_cisu_output_json(
        cls,
        output_json: Dict[str, Any],
        output_use_case_json: Dict[str, Any],
    ) -> Dict[str, Any]:
        return cls._format_output_json(
            output_json,
            output_use_case_json,
            cls.get_cisu_message_type(),
        )

    @classmethod
    def copy_rs_input_content(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        return cls._copy_input_content(edxl_json, cls.get_rs_message_type())

    @classmethod
    def copy_rs_input_use_case_content(
        cls, edxl_json: Dict[str, Any]
    ) -> Dict[str, Any]:
        return cls._copy_input_use_case_content(edxl_json, cls.get_rs_message_type())

    @classmethod
    def format_rs_output_json(
        cls,
        output_json: Dict[str, Any],
        output_use_case_json: Dict[str, Any],
    ) -> Dict[str, Any]:
        return cls._format_output_json(
            output_json,
            output_use_case_json,
            cls.get_rs_message_type(),
        )
