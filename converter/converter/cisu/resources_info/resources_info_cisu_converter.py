from converter.cisu.base_cisu_converter import BaseCISUConverter


class ResourcesInfoCISUConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesInfo"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesInfoCisu"
