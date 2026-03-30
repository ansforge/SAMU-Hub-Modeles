from converter.cisu.base_cisu_converter import BaseCISUConverter
from converter.repositories.message_repository import (
    get_last_rs_ri_by_case_id,
    get_last_rs_sr_per_resource_by_case_id,
)
from converter.cisu.resources_info.resources_info_cisu_helper import (
    merge_info_and_resources,
)
from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from converter.cisu.resources_status.resources_status_constants import (
    ResourcesStatusConstants,
)
from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)

from typing import Any, Dict

from converter.utils import get_field_value, set_value


class ResourcesStatusConverter(BaseCISUConverter):
    @classmethod
    def get_rs_message_type(cls) -> str:
        return "resourcesStatus"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "resourcesInfoCisu"

    @classmethod
    def from_rs_to_cisu(
        cls, edxl_json: Dict[str, Any]
    ) -> Dict[str, Any] | list[Dict[str, Any]]:
        content = cls.copy_rs_input_use_case_content(edxl_json)
        case_id = get_field_value(content, ResourcesStatusConstants.CASE_ID)

        persisted_rs_ri = get_last_rs_ri_by_case_id(case_id)
        if persisted_rs_ri is None:  # No RS-RI persisted yet, we return an empty list
            return []

        persisted_rs_sr_list = get_last_rs_sr_per_resource_by_case_id(case_id)

        rs_ri = persisted_rs_ri.payload
        rs_ri_content = ResourcesInfoCISUConverter.copy_rs_input_use_case_content(rs_ri)
        rs_sr_content_list = [
            cls.copy_rs_input_use_case_content(msg.payload)
            for msg in persisted_rs_sr_list
        ]

        # merge RS-SRs in RS-RI
        resources = get_field_value(
            rs_ri_content, ResourcesInfoCISUConstants.RESOURCE_PATH
        )

        merged_resources = merge_info_and_resources(resources, rs_sr_content_list)

        set_value(rs_ri, ResourcesInfoCISUConstants.RESOURCE_PATH, merged_resources)

        return ResourcesInfoCISUConverter.from_rs_to_cisu(rs_ri)
