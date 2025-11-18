from typing import Dict, Any

from converter.cisu.base_cisu_converter import BaseCISUConverter


class IdenticalCISUConverter(BaseCISUConverter):
    @classmethod
    def from_rs_to_cisu(cls, edxl_json) -> Dict[str, Any]:
        return edxl_json

    @classmethod
    def from_cisu_to_rs(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        return edxl_json
