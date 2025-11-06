class BaseCISUConverter:
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
