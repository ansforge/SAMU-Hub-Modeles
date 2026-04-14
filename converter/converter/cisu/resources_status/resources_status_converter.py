from converter.cisu.base_cisu_converter import BaseCISUConverter
from converter.repositories.message_repository import (
    get_rs_messages_by_case_id,
)
from converter.cisu.resources_info.resources_info_cisu_helper import (
    enrich_rs_ri_with_rs_srs,
)
from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from converter.cisu.resources_status.resources_status_constants import (
    ResourcesStatusConstants,
)
from typing import Any, Dict

from converter.utils import get_field_value

import logging

logger = logging.getLogger(__name__)


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
        logger.info(
            "Received RS-SR message with distributionID: %s for CISU conversion",
            edxl_json.get("distributionID"),
        )

        current_use_case = cls.copy_rs_input_use_case_content(edxl_json)
        case_id = get_field_value(current_use_case, ResourcesStatusConstants.CASE_ID)

        rs_ri_msg, persisted_rs_sr = get_rs_messages_by_case_id(case_id)
        if rs_ri_msg is None:
            raise ValueError(f"No RS-RI found for caseId: {case_id!r}")

        rs_ri = rs_ri_msg.payload

        rs_sr_edxl_list = [pm.payload for pm in persisted_rs_sr]
        rs_sr_edxl_list.append(edxl_json)

        output_json = ResourcesInfoCISUConverter.copy_rs_input_content(rs_ri)

        enriched = enrich_rs_ri_with_rs_srs(
            rs_ri_edxl=rs_ri,
            rs_sr_edxl_list=rs_sr_edxl_list,
        )

        return ResourcesInfoCISUConverter.convert_single_rs_ri(output_json, enriched)
