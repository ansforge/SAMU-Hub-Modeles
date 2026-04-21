from converter.conversion_mixin import ConversionMixin
from converter.utils import get_field_value, set_value
from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
import logging

logger = logging.getLogger(__name__)

_DISTRIBUTION_ID_KEY = ConversionMixin.EDXL_DISTRIBUTION_ID_KEY


def enrich_rs_ri_with_rs_srs(
    rs_ri_edxl: dict,
    rs_sr_edxl_list: list[dict],
) -> dict:
    """Enrich RS-RI resources with state from RS-SR messages.
    Receives full EDXL envelopes, extracts use cases and distribution IDs internally.
    Centralizes all distribution-ID logging for both RS-RI and RS-SR conversion flows.
    """
    rs_ri_distribution_id = rs_ri_edxl.get(_DISTRIBUTION_ID_KEY)
    rs_sr_distribution_ids = [sr.get(_DISTRIBUTION_ID_KEY) for sr in rs_sr_edxl_list]

    logger.info(
        "Persisted RS-SRs found for RS-RI message with distributionID: %s -> %s",
        rs_ri_distribution_id,
        rs_sr_distribution_ids,
    )

    rs_ri_use_case = ConversionMixin._copy_input_use_case_content(
        rs_ri_edxl, "resourcesInfo"
    )

    if not rs_sr_edxl_list:
        return rs_ri_use_case

    rs_sr_entries = [
        (
            ConversionMixin._copy_input_use_case_content(sr, "resourcesStatus"),
            sr.get(_DISTRIBUTION_ID_KEY),
        )
        for sr in rs_sr_edxl_list
    ]
    sr_by_resource_id = {
        use_case.get("resourceId"): (use_case, dist_id)
        for use_case, dist_id in rs_sr_entries
    }

    rs_ri_resources = get_field_value(
        rs_ri_use_case, ResourcesInfoCISUConstants.RESOURCE_PATH
    )
    used_sr_distribution_ids = []

    for resource in rs_ri_resources:
        resource_id = resource.get("resourceId")
        entry = sr_by_resource_id.get(resource_id)
        if entry is None:
            continue

        persisted_sr, sr_dist_id = entry
        persisted_state = persisted_sr.get("state")
        if persisted_state is None:
            logger.warning(
                "No state found in persisted RS-SR for resourceId: %s", resource_id
            )
            continue

        current_states = get_field_value(
            resource, ResourcesInfoCISUConstants.STATE_PATH
        )
        if current_states is None or len(current_states) == 0:
            set_value(
                resource,
                ResourcesInfoCISUConstants.STATE_PATH,
                [persisted_state],
            )
        else:
            latest_state = get_latest_state([*current_states, persisted_state])
            set_value(
                resource,
                ResourcesInfoCISUConstants.STATE_PATH,
                [latest_state],
            )

        used_sr_distribution_ids.append(sr_dist_id)

    logger.info(
        "Enriched RS-RI (%s) with %s RS-SR (%s) before conversion",
        rs_ri_distribution_id,
        len(used_sr_distribution_ids),
        used_sr_distribution_ids,
    )

    return rs_ri_use_case


def get_latest_state(states: list[dict]) -> dict:
    """Return the state with the most recent datetime from a list of states."""
    return sorted(states, key=lambda x: x.get("datetime", ""))[-1]


def log_cisu_to_rs_converted_messages_ids(
    original_message: dict, rs_ri: dict | None, rs_sr_list: list[dict]
) -> None:
    if rs_ri is None and len(rs_sr_list) == 0:
        logger.info(
            f"No RS message produced when converting RC-RI with distributionId {original_message.get('distributionID')}."
        )

    else:
        log_message = f"Converted RC-RI with distributionID {original_message.get('distributionID')} into"

        if rs_ri is not None:
            log_message += f" RS-RI {rs_ri.get('distributionID')}"

        if rs_sr_list:
            if rs_ri is not None:
                log_message += " and"
            rs_sr_ids = [rs_sr.get("distributionID") for rs_sr in rs_sr_list]
            log_message += f" {len(rs_sr_list)} RS-SR(s) {rs_sr_ids}"

        logger.info(log_message)
