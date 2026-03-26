import pytest

from converter.cisu.resources_info.resources_info_cisu_helper import (
    merge_info_and_resources,
)


@pytest.fixture(autouse=True)
def mock_converter(monkeypatch):
    monkeypatch.setattr(
        "converter.cisu.resources_info.resources_info_cisu_converter.ResourcesInfoCISUConverter.from_rs_to_cisu",
        lambda x: x,
    )


def test_merge_success():
    resources = [
        {"resourceId": "r1"},
        {"resourceId": "r2"},
    ]

    rs_status_list = [
        {"resourceId": "r1", "state": {"status": "OK"}},
        {"resourceId": "r2", "state": {"status": "KO"}},
    ]

    result = merge_info_and_resources(resources, rs_status_list)

    assert result is not None

    assert resources[0]["state"] == [{"status": "OK"}]
    assert resources[1]["state"] == [{"status": "KO"}]


def test_missing_state_for_resource():
    resources = [
        {"resourceId": "r1"},
        {"resourceId": "r2"},
    ]

    resources_status_list = [
        {"resourceId": "r1", "state": {"status": "OK"}},
        # r2 manquant
    ]

    result = merge_info_and_resources(resources, resources_status_list)

    assert result is None


def test_missing_resource_id():
    resources = [
        {"resourceId": "r1"},
        {},  # pas de resourceId
    ]

    resources_status_list = [
        {"resourceId": "r1", "state": {"status": "OK"}},
    ]

    result = merge_info_and_resources(resources, resources_status_list)

    assert result is None


def test_invalid_rs_status_ignored():
    resources = [
        {"resourceId": "r1"},
    ]

    resources_status_list = [
        {},  # invalide
        {"resourceId": "r1", "state": {"status": "OK"}},
    ]

    result = merge_info_and_resources(resources, resources_status_list)

    assert result is not None


def test_duplicate_resource_id_last_wins():
    resources = [
        {"resourceId": "r1"},
    ]

    resources_status_list = [
        {"resourceId": "r1", "state": {"status": "OLD"}},
        {"resourceId": "r1", "state": {"status": "NEW"}},
    ]

    resources = merge_info_and_resources(resources, resources_status_list)

    assert resources[0]["state"] == [{"status": "NEW"}]
