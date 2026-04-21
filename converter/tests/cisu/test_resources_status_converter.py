import pytest
from unittest.mock import patch

from converter.cisu.resources_status.resources_status_converter import (
    ResourcesStatusConverter,
)
from tests.cisu.helpers import (
    get_cisu_resources,
    make_rs_ri_from_sample,
    make_rs_sr_from_sample,
    persisted_rs_ri_and_rs_sr,
)

_CASE_ID = "CASE123"
_RESOURCE_ID_1 = "fr.fire.sis076.cgo-076.resource.VLM1"
_RESOURCE_ID_2 = "fr.fire.sis076.cgo-076.resource.VLM2"

_PATCH_GET_RS_MESSAGES = "converter.cisu.resources_status.resources_status_converter.get_rs_messages_by_case_id"


def test_from_rs_to_cisu_real_data():
    rs_ri = make_rs_ri_from_sample(_CASE_ID)

    rs_sr_old_1 = make_rs_sr_from_sample(
        _CASE_ID,
        _RESOURCE_ID_1,
        "DECISION",
    )

    rs_sr_old_2 = make_rs_sr_from_sample(
        _CASE_ID,
        _RESOURCE_ID_2,
        "DECISION",
    )

    rs_sr_new = make_rs_sr_from_sample(
        _CASE_ID,
        _RESOURCE_ID_1,
        "ARRIVEE",
    )

    with patch(
        _PATCH_GET_RS_MESSAGES,
        return_value=persisted_rs_ri_and_rs_sr(
            rs_ri,
            [rs_sr_old_1, rs_sr_old_2, rs_sr_new],
        ),
    ):
        result = ResourcesStatusConverter.from_rs_to_cisu(rs_sr_new)

    assert result is not None
    assert result != []

    assert result["distributionID"] == rs_sr_new["distributionID"]

    resources = get_cisu_resources(result)

    assert len(resources) == 2

    vlm1 = next(r for r in resources if r["resourceId"] == _RESOURCE_ID_1)
    assert vlm1["state"]["status"] == "ARRIVEE"

    vlm2 = next(r for r in resources if r["resourceId"] == _RESOURCE_ID_2)
    assert vlm2["state"].get("status") == "DECISION"


def test_from_rs_to_cisu_no_rs_ri():
    rs_sr_new = make_rs_sr_from_sample(
        _CASE_ID,
        _RESOURCE_ID_1,
        "ARRIVEE",
    )

    with patch(
        _PATCH_GET_RS_MESSAGES,
        return_value=(None, []),
    ):
        with pytest.raises(ValueError, match="No RS-RI found for caseId"):
            ResourcesStatusConverter.from_rs_to_cisu(rs_sr_new)


def test_from_rs_to_cisu_resource_not_in_rs_ri():
    unknown_resource_id = "fr.fire.sis076.cgo-076.resource.UNKNOWN_VLM"
    rs_sr = make_rs_sr_from_sample(_CASE_ID, unknown_resource_id, "ARRIVEE")
    rs_ri = make_rs_ri_from_sample(_CASE_ID)

    with (
        patch(
            _PATCH_GET_RS_MESSAGES,
            return_value=persisted_rs_ri_and_rs_sr(rs_ri, []),
        ),
        pytest.raises(
            ValueError,
            match=f"Resource '{unknown_resource_id}' from RS-SR not found in RS-RI for caseId '{_CASE_ID}'",
        ),
    ):
        ResourcesStatusConverter.from_rs_to_cisu(rs_sr)
