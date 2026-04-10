import copy
import json
import pytest
from pathlib import Path
from unittest.mock import patch

from converter.cisu.resources_status.resources_status_converter import (
    ResourcesStatusConverter,
)

RS_RI_PAYLOAD = json.load(Path("tests/fixtures/RS-RI/sample_rs_ri_payload.json").open())
RS_SR_PAYLOAD = json.load(Path("tests/fixtures/RS-SR/sample_rs_sr_payload.json").open())
_CASE_ID = "CASE123"
_RESOURCE_ID_1 = "fr.fire.sis076.cgo-076.resource.VLM1"
_RESOURCE_ID_2 = "fr.fire.sis076.cgo-076.resource.VLM2"


def make_rs_ri(case_id: str):
    edxl = copy.deepcopy(RS_RI_PAYLOAD)
    edxl["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfo"
    ]["caseId"] = case_id
    return edxl


def make_rs_sr(case_id: str, resource_id: str, status: str):
    edxl = copy.deepcopy(RS_SR_PAYLOAD)
    rs = edxl["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesStatus"
    ]

    rs["caseId"] = case_id
    rs["resourceId"] = resource_id
    rs["state"]["status"] = status

    return edxl


def persisted(edxl):
    return type("Msg", (), {"payload": edxl})


def extract_resources_from_result(result):
    return result["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfoCisu"
    ]["resource"]


def test_from_rs_to_cisu_real_data():
    rs_ri = make_rs_ri(_CASE_ID)

    rs_sr_old_1 = make_rs_sr(
        _CASE_ID,
        _RESOURCE_ID_1,
        "DECISION",
    )

    rs_sr_old_2 = make_rs_sr(
        _CASE_ID,
        _RESOURCE_ID_2,
        "DECISION",
    )

    rs_sr_new = make_rs_sr(
        _CASE_ID,
        _RESOURCE_ID_1,
        "ARRIVEE",
    )

    with (
        patch(
            "converter.cisu.resources_status.resources_status_converter.get_last_rs_ri_by_case_id",
            return_value=persisted(rs_ri),
        ),
        patch(
            "converter.cisu.resources_status.resources_status_converter.get_last_rs_sr_per_resource_by_case_id",
            return_value=[
                persisted(rs_sr_old_1),
                persisted(rs_sr_old_2),
                persisted(rs_sr_new),
            ],
        ),
    ):
        result = ResourcesStatusConverter.from_rs_to_cisu(rs_sr_new)

    assert result is not None
    assert result != []

    resources = extract_resources_from_result(result)

    assert len(resources) == 2

    vlm1 = next(r for r in resources if r["resourceId"] == _RESOURCE_ID_1)
    assert vlm1["state"]["status"] == "ARRIVEE"

    vlm2 = next(r for r in resources if r["resourceId"] == _RESOURCE_ID_2)
    assert vlm2["state"].get("status") == "DECISION"


def test_from_rs_to_cisu_no_rs_ri():
    rs_sr_new = make_rs_sr(
        _CASE_ID,
        _RESOURCE_ID_1,
        "ARRIVEE",
    )

    with patch(
        "converter.cisu.resources_status.resources_status_converter.get_last_rs_ri_by_case_id",
        return_value=None,
    ):
        with pytest.raises(ValueError, match="No RS-RI found for caseId"):
            ResourcesStatusConverter.from_rs_to_cisu(rs_sr_new)
