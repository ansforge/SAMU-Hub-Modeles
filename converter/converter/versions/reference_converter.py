from converter.versions.identical_message_converter import IdenticalMessageConverter

class ReferenceConverter(IdenticalMessageConverter):
    @staticmethod
    def get_message_type():
        return "reference"
