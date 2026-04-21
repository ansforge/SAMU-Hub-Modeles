"""Shared helpers for CISU converter tests (RS-RI, RS-SR, RC-RI)."""

import copy
import json
from datetime import datetime
from pathlib import Path

from converter.models.persisted_message import PersistedMessage
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


RS_RI_SAMPLE_PAYLOAD = json.load(
    Path("tests/fixtures/RS-RI/sample_rs_ri_payload.json").open()
)
RS_SR_SAMPLE_PAYLOAD = json.load(
    Path("tests/fixtures/RS-SR/sample_rs_sr_payload.json").open()
)

RS_RI_EDXL = TestHelper.create_edxl_json_from_sample(
    TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
    "tests/fixtures/RS-RI/RS-RI_V3.0_exhaustive_fill.json",
)

RS_SR_EDXL = TestHelper.create_edxl_json_from_sample(
    TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
    "tests/fixtures/RS-SR/RS-SR_V3.0_exhaustive_fill.json",
)

RC_RI_WITH_POSITION_EDXL = TestHelper.create_edxl_json_from_sample(
    TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
    "tests/fixtures/RC-RI/RC-RI_V3.0_with_position.json",
)

RS_SR_RESOURCE_ID = "fr.health.samu440.resource.VLM2"


def get_edxl_message(edxl: dict) -> dict:
    """Extract the message dict from an EDXL envelope."""
    return edxl["content"][0]["jsonContent"]["embeddedJsonContent"]["message"]


def get_cisu_content(edxl: dict) -> dict:
    """Extract the resourcesInfoCisu use-case content from an EDXL envelope."""
    return get_edxl_message(edxl)["resourcesInfoCisu"]


def get_cisu_resources(edxl: dict) -> list[dict]:
    """Extract resource list from resourcesInfoCisu."""
    return get_cisu_content(edxl)["resource"]


def make_rs_ri_from_sample(case_id: str) -> dict:
    """Create a RS-RI EDXL from sample_rs_ri_payload.json with the given caseId."""
    edxl = copy.deepcopy(RS_RI_SAMPLE_PAYLOAD)
    get_edxl_message(edxl)["resourcesInfo"]["caseId"] = case_id
    return edxl


def make_rs_sr_from_sample(case_id: str, resource_id: str, status: str) -> dict:
    """Create a RS-SR EDXL from sample_rs_sr_payload.json with the given fields."""
    edxl = copy.deepcopy(RS_SR_SAMPLE_PAYLOAD)
    rs = get_edxl_message(edxl)["resourcesStatus"]
    rs["caseId"] = case_id
    rs["resourceId"] = resource_id
    rs["state"]["status"] = status
    return edxl


def make_rs_ri_edxl(
    *,
    remove_state: bool = False,
    rs_sr_datetime: str | None = None,
    resource_overrides: list[dict] | None = None,
) -> tuple[dict, dict, dict]:
    """Build a (edxl, rs_ri, rs_sr_edxl) tuple for from_rs_to_cisu tests.

    - Always deep-copies the module-level fixtures.
    - Overrides the resources resourceId to match the RS-SR fixture.
    - Optionally removes the first resource's state.
    - Optionally overrides the RS-SR state datetime.
    """
    edxl = copy.deepcopy(RS_RI_EDXL)
    rs_ri = get_edxl_message(edxl)["resourcesInfo"]

    for res in rs_ri["resource"]:
        res["resourceId"] = RS_SR_RESOURCE_ID
        if remove_state:
            del res["state"]

    rs_sr_edxl = copy.deepcopy(RS_SR_EDXL)
    if rs_sr_datetime is not None:
        get_edxl_message(rs_sr_edxl)["resourcesStatus"]["state"]["datetime"] = (
            rs_sr_datetime
        )

    if resource_overrides is not None:
        rs_ri["resource"] = resource_overrides

    return edxl, rs_ri, rs_sr_edxl


def make_rc_ri_with_resources(resources: list[dict]) -> dict:
    """Return a copy of the RC-RI fixture with the given resource list."""
    edxl = copy.deepcopy(RC_RI_WITH_POSITION_EDXL)
    get_cisu_content(edxl)["resource"] = resources
    return edxl


_DEFAULT_ARRIVED_AT = datetime(2024, 8, 1, 14, 0, 0)


def persisted(edxl: dict, message_type: str = "RC-RI") -> PersistedMessage:
    """Wrap an EDXL dict in a PersistedMessage as the repository would return it."""
    return PersistedMessage(
        message_type=message_type,
        payload=edxl,
        arrived_at=_DEFAULT_ARRIVED_AT,
    )


def persisted_rs_ri_and_rs_sr(
    rs_ri_edxl: dict, rs_sr_edxls: list[dict]
) -> tuple[PersistedMessage, list[PersistedMessage]]:
    """Wrap RS-RI + RS-SR list in PersistedMessages."""
    rs_ri = persisted(rs_ri_edxl, message_type="RS-RI")
    rs_sr = [persisted(edxl, message_type="RS-SR") for edxl in rs_sr_edxls]
    return rs_ri, rs_sr
