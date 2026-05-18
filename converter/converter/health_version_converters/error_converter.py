from converter.health_version_converters.identical_message_converter import (
    IdenticalMessageConverter,
)


class ErrorConverter(IdenticalMessageConverter):
    @staticmethod
    def get_message_type():
        return "error"
