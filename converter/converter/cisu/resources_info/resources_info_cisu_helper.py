from converter.utils import get_field_value, set_value
from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)
import logging

logger = logging.getLogger(__name__)


def enrich_rs_ri_with_rs_srs(rs_ri: dict, rs_sr_list: list[dict]) -> dict:
    """Enrich RS-RI resources with state from a list of RS-SR messages (in-place + return)."""

    if not rs_sr_list:
        return rs_ri

    rs_ri_resources = get_field_value(rs_ri, ResourcesInfoCISUConstants.RESOURCE_PATH)
    sr_by_resource_id = {sr.get("resourceId"): sr for sr in rs_sr_list}

    for resource in rs_ri_resources:
        resource_id = resource.get("resourceId")
        persisted_sr = sr_by_resource_id.get(resource_id)
        if persisted_sr is None:
            continue

        persisted_state = persisted_sr.get("state")
        if persisted_state is None:
            logger.warning(
                f"No state found in persisted rs-sr for resourceId: {resource_id}"
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

    return rs_ri


def get_latest_state(states: list[dict]) -> dict:
    """Return the state with the most recent datetime from a list of states."""
    return sorted(states, key=lambda x: x.get("datetime", ""))[-1]
