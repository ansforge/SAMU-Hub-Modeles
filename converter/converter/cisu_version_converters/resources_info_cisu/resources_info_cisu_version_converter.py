from converter.cisu_version_converters.identical_cisu_version_converter import (
    IdenticalCISUVersionConverter,
)


class ResourcesInfoCISUVersionConverter(IdenticalCISUVersionConverter):
    @classmethod
    def get_message_type(cls) -> str:
        return "resourcesInfoCisu"
