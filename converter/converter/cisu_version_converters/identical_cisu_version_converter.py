from typing import Dict, Any

from converter.cisu_version_converters.base_cisu_version_converter import (
    BaseCISUVersionConverter,
)


class IdenticalCISUVersionConverter(BaseCISUVersionConverter):
    @classmethod
    def convert_v3_to_vactive(cls, edxl_json) -> Dict[str, Any]:
        return edxl_json

    @classmethod
    def convert_vactive_to_v3(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        return edxl_json
