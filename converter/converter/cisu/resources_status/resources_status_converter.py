from converter.cisu.base_cisu_converter import BaseCISUConverter
from converter.repositories.message_repository import (
    get_last_rs_ri_by_case_id,
    get_last_rs_sr_per_resource_by_case_id,
)
from converter.cisu.resources_info.resources_info_cisu_helper import (
    merge_info_and_resources,
)

from typing import Any, Dict


class ResourcesStatusConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesStatus"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesInfoCisu"

    @classmethod
    def from_rs_to_cisu(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any] | None:
        try:
            message = edxl_json["content"][0]["jsonContent"]["embeddedJsonContent"][
                "message"
            ]
            case_id = message["resourcesStatus"]["caseId"]
        except KeyError:
            raise ValueError("Could not retrieve caseId in RS-SR message")

        rs_ri = get_last_rs_ri_by_case_id(case_id)
        if rs_ri is None:  # No RS-RI persisted yet, we do nothing
            return None

        rs_sr_list = get_last_rs_sr_per_resource_by_case_id(case_id)

        rs_ri_dict = rs_ri.payload
        rs_sr_dicts = [msg.payload for msg in rs_sr_list]

        # build RC-RI from RS-RI & RS-SRs
        merged_result = merge_info_and_resources(rs_ri_dict, rs_sr_dicts)

        return merged_result
