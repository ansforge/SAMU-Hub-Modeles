import pytest

from converter.cisu.resources_info.resources_info_cisu_helper import (
    merge_info_and_resources,
)


def build_rs_ri(resources):
    return {
        "content": {
            "jsonContent": {
                "embeddedJsonContent": {
                    "message": {"resourcesInfo": {"resource": resources}}
                }
            }
        }
    }


def build_rs_sr(resource_id, state):
    return {
        "content": {
            "jsonContent": {
                "embeddedJsonContent": {
                    "message": {
                        "resourceStatus": {
                            "resourceId": resource_id,
                            "state": state,
                        }
                    }
                }
            }
        }
    }


@pytest.fixture(autouse=True)
def mock_converter(monkeypatch):
    monkeypatch.setattr(
        "converter.cisu.resources_info.resources_info_cisu_converter.ResourcesInfoCISUConverter.from_rs_to_cisu",
        lambda x: x,
    )


def test_merge_success():
    rs_ri = build_rs_ri(
        [
            {"resourceId": "r1"},
            {"resourceId": "r2"},
        ]
    )

    rs_sr_list = [
        build_rs_sr("r1", {"status": "OK"}),
        build_rs_sr("r2", {"status": "KO"}),
    ]

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    assert result is not None

    resources = result["content"]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfo"
    ]["resource"]

    assert resources[0]["state"] == [{"status": "OK"}]
    assert resources[1]["state"] == [{"status": "KO"}]


def test_missing_resources_info():
    rs_ri = {}
    rs_sr_list = []

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    assert result is None


def test_missing_state_for_resource():
    rs_ri = build_rs_ri(
        [
            {"resourceId": "r1"},
            {"resourceId": "r2"},
        ]
    )

    rs_sr_list = [
        build_rs_sr("r1", {"status": "OK"}),
        # r2 manquant
    ]

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    assert result is None


def test_missing_resource_id():
    rs_ri = build_rs_ri(
        [
            {"resourceId": "r1"},
            {},  # pas de resourceId
        ]
    )

    rs_sr_list = [
        build_rs_sr("r1", {"status": "OK"}),
    ]

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    assert result is None


def test_invalid_rs_sr_ignored():
    rs_ri = build_rs_ri(
        [
            {"resourceId": "r1"},
        ]
    )

    rs_sr_list = [
        {},  # invalide
        build_rs_sr("r1", {"status": "OK"}),
    ]

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    assert result is not None


def test_duplicate_resource_id_last_wins():
    rs_ri = build_rs_ri(
        [
            {"resourceId": "r1"},
        ]
    )

    rs_sr_list = [
        build_rs_sr("r1", {"status": "OLD"}),
        build_rs_sr("r1", {"status": "NEW"}),
    ]

    result = merge_info_and_resources(rs_ri, rs_sr_list)

    resources = result["content"]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfo"
    ]["resource"]

    assert resources[0]["state"] == [{"status": "NEW"}]
