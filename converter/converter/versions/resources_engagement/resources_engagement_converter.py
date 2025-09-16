from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.identical_message_converter import IdenticalMessageConverter


class ResourcesEngagementConverter(IdenticalMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesEngagement"

    @classmethod
    def convert_v3_to_v2(cls, input_json):
        output_json = cls.copy_input_content(input_json)
        return output_json

    @classmethod
    def convert_v2_to_v3(cls, input_json):
        output_json = cls.copy_input_content(input_json)
        return output_json
