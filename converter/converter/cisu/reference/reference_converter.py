from converter.cisu.identical_cisu_converter import IdenticalCISUConverter


class ReferenceConverter(IdenticalCISUConverter):
    REFERENCE_MESSAGE_TYPE = "reference"

    @classmethod
    def get_rs_message_type(cls) -> str:
        return cls.REFERENCE_MESSAGE_TYPE

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return cls.REFERENCE_MESSAGE_TYPE
