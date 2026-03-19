"""Unit tests for converter.repository.get_last_rc_ri_by_case_id."""

from datetime import datetime
from pathlib import Path
from unittest.mock import MagicMock, patch

import copy
import json
import uuid
import mongomock
import pytest

from converter.models.persisted_message import PersistedMessage
from converter.repositories.message_repository import (
    get_last_rc_ri_by_case_id,
    get_last_rs_ri_by_case_id,
    get_last_rs_sr_by_case_id,
)

_RC_RI_CASE_ID = "fr.health.samu800.DRFR158002421400215"
_OTHER_RC_RI_CASE_ID = "fr.health.samu800.OTHERUNRELATEDCASE"
_DIST_ID_A = "fr.health.samu800.abc123"
_DIST_ID_B = "fr.health.samu800.def456"
_RC_RI_TYPE = "ResourcesInfoCisuWrapper"
_RC_RI_PAYLOAD = json.load(
    Path("tests/fixtures/RC-RI/sample_rc_ri_payload.json").open()
)

_RS_RI_CASE_ID = "fr.health.samu440.DRFR154402413800236"
_OTHER_RS_RI_CASE_ID = "fr.health.samu440.OTHERUNRELATEDCASE"
_RS_SR_RESOURCE_ID_1 = "fr.fire.sis076.cgo-076.resource.VLM1"
_RS_SR_RESOURCE_ID_2 = "fr.fire.sis076.cgo-076.resource.VLM2"
_RS_RI_TYPE = "ResourcesInfoWrapper"
_RS_RI_PAYLOAD = json.load(
    Path("tests/fixtures/RS-RI/sample_rs_ri_payload.json").open()
)
_RS_SR_TYPE = "ResourcesStatusWrapper"
_RS_SR_PAYLOAD = json.load(
    Path("tests/fixtures/RS-SR/sample_rs_sr_payload.json").open()
)


def _make_rc_ri_payload(case_id: str) -> dict:
    """Build a minimal RC-RI payload with the given caseId embedded in the real nested structure."""
    payload = copy.deepcopy(_RC_RI_PAYLOAD)
    payload["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfoCisu"
    ]["caseId"] = case_id
    return payload


def _make_rs_ri_payload(case_id: str) -> dict:
    payload = copy.deepcopy(_RS_RI_PAYLOAD)
    payload["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfo"
    ]["caseId"] = case_id
    return payload


def _make_rs_sr_payload(
    case_id: str, resource_id: str, status: str | None = None
) -> dict:
    payload = copy.deepcopy(_RS_SR_PAYLOAD)
    resources_status = payload["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]["resourcesStatus"]

    resources_status["caseId"] = case_id
    resources_status["resourceId"] = resource_id

    if status is not None:
        resources_status["state"]["status"] = status

    return payload


def _make_doc(
    payload: dict, messageType: str, distribution_id: str, arrived_at: datetime
) -> dict:
    """Build a document with the given payload, message type and distributionID."""
    payload = copy.deepcopy(payload)
    # line 82 below
    payload["distributionID"] = distribution_id
    return {
        "type": messageType,
        "arrivedAt": arrived_at,
        "payload": payload,
    }


@pytest.fixture
def mock_db():
    """Provide a MagicMock database for pure unit tests (call verification, error simulation)."""
    db = MagicMock()
    with patch("converter.repositories.message_repository.get_db", return_value=db):
        yield db


@pytest.fixture
def real_db():
    """Provide a real in-memory MongoDB via mongomock, fully isolated per test."""
    client = mongomock.MongoClient()
    db = client[f"testdb_{uuid.uuid4().hex}"]
    with patch("converter.repositories.message_repository.get_db", return_value=db):
        yield db


class TestGetLastRcRiByCaseId:
    def test_returns_document_when_found(self, real_db):
        """Should return a PersistedMessage built from the found document and conform to RC-RI schema."""
        # mongomock (like the real PyMongo driver) returns timezone-naive datetimes
        arrived_at = datetime(2024, 8, 1, 14, 0, 0)
        real_db["messages"].insert_one(
            {
                "type": "ResourcesInfoCisuWrapper",
                "arrivedAt": arrived_at,
                "payload": _RC_RI_PAYLOAD,
            }
        )

        result = get_last_rc_ri_by_case_id(_RC_RI_CASE_ID)

        assert result is not None
        assert isinstance(result, PersistedMessage)
        assert result.message_type == "ResourcesInfoCisuWrapper"
        assert result.arrived_at == arrived_at
        assert result.payload == _RC_RI_PAYLOAD

    def test_returns_none_when_not_found(self, real_db):
        """Should return None when no RC-RI document exists for the given caseId."""
        real_db["messages"].insert_one(
            {
                "type": "ResourcesInfoCisuWrapper",
                "arrivedAt": datetime(2024, 8, 1),
                "payload": _make_rc_ri_payload(
                    _OTHER_RC_RI_CASE_ID
                ),  # different caseId in nested path
            }
        )
        result = get_last_rc_ri_by_case_id(_RC_RI_CASE_ID)

        assert result is None

    def test_returns_most_recent_document(self, real_db):
        """Should return the document with the latest arrivedAt among multiple matches."""
        real_db["messages"].insert_many(
            [
                {
                    "type": "ResourcesInfoCisuWrapper",
                    "arrivedAt": datetime(2024, 1, 1),
                    "payload": _RC_RI_PAYLOAD,
                },
                {
                    "type": "ResourcesInfoCisuWrapper",
                    "arrivedAt": datetime(2024, 8, 1),  # le plus récent
                    "payload": _RC_RI_PAYLOAD,
                },
            ]
        )

        result = get_last_rc_ri_by_case_id(_RC_RI_CASE_ID)

        assert result.arrived_at == datetime(2024, 8, 1)

    def test_ignores_documents_with_wrong_type(self, real_db):
        """Should not return documents whose type is not ResourcesInfoCisuWrapper."""
        real_db["messages"].insert_one(
            {
                "type": "SomeOtherWrapper",
                "arrivedAt": datetime(2024, 8, 1),
                "payload": _RC_RI_PAYLOAD,
            }
        )

        result = get_last_rc_ri_by_case_id(_RC_RI_CASE_ID)

        assert result is None

    @pytest.mark.parametrize("bad_input", [None, ""])
    def test_returns_none_for_invalid_case_id(self, real_db, bad_input):
        """Should return None immediately for invalid input without querying MongoDB."""
        result = get_last_rc_ri_by_case_id(bad_input)

        assert result is None

    def test_raises_on_mongodb_error(self, mock_db):
        """Should re-raise MongoDB exceptions after logging."""
        mock_db["messages"].find_one.side_effect = RuntimeError("connection refused")

        with pytest.raises(RuntimeError, match="connection refused"):
            get_last_rc_ri_by_case_id(_RC_RI_CASE_ID)

    # --- exclude_distribution_id ---

    def test_returns_none_when_only_matching_document_is_excluded(self, real_db):
        """When the only matching document is excluded, should return None."""
        real_db["messages"].insert_one(
            _make_doc(_RC_RI_PAYLOAD, _RC_RI_TYPE, _DIST_ID_A, datetime(2024, 8, 1))
        )

        result = get_last_rc_ri_by_case_id(
            _RC_RI_CASE_ID, exclude_distribution_id=_DIST_ID_A
        )

        assert result is None

    def test_returns_previous_when_most_recent_document_is_excluded(self, real_db):
        """When the most recent document is excluded, should return the previous one."""
        real_db["messages"].insert_many(
            [
                _make_doc(
                    _RC_RI_PAYLOAD, _RC_RI_TYPE, _DIST_ID_A, datetime(2024, 1, 1)
                ),  # old
                _make_doc(
                    _RC_RI_PAYLOAD, _RC_RI_TYPE, _DIST_ID_B, datetime(2024, 8, 1)
                ),  # new
            ]
        )

        result = get_last_rc_ri_by_case_id(
            _RC_RI_CASE_ID, exclude_distribution_id=_DIST_ID_B
        )

        assert result is not None
        assert result.payload["distributionID"] == _DIST_ID_A

    def test_exclude_none_behaves_normally(self, real_db):
        """Passing exclude_distribution_id=None must not filter anything."""
        real_db["messages"].insert_many(
            [
                _make_doc(
                    _RC_RI_PAYLOAD, _RC_RI_TYPE, _DIST_ID_A, datetime(2024, 8, 1)
                ),
                _make_doc(
                    _RC_RI_PAYLOAD, _RC_RI_TYPE, _DIST_ID_B, datetime(2024, 3, 1)
                ),
            ]
        )

        result = get_last_rc_ri_by_case_id(_RC_RI_CASE_ID, exclude_distribution_id=None)

        assert result is not None
        assert result.payload["distributionID"] == _DIST_ID_A


class TestGetLastRsRiByCaseId:
    def test_returns_document_when_found(self, real_db):
        """Should return a PersistedMessage built from the found document and conform to RS-RI schema."""
        arrived_at = datetime(2024, 8, 1, 14, 0, 0)
        real_db["messages"].insert_one(
            {
                "type": _RS_RI_TYPE,
                "arrivedAt": arrived_at,
                "payload": _RS_RI_PAYLOAD,
            }
        )

        result = get_last_rs_ri_by_case_id(_RS_RI_CASE_ID)

        assert result is not None
        assert isinstance(result, PersistedMessage)
        assert result.message_type == _RS_RI_TYPE
        assert result.arrived_at == arrived_at
        assert result.payload == _RS_RI_PAYLOAD

    def test_returns_none_when_not_found(self, real_db):
        """Should return None when no RS-RI document exists for the given caseId."""
        real_db["messages"].insert_one(
            {
                "type": "ResourcesInfoCisuWrapper",
                "arrivedAt": datetime(2024, 8, 1),
                "payload": _make_rs_ri_payload(
                    _OTHER_RS_RI_CASE_ID,
                ),  # different caseId in nested path
            }
        )

        result = get_last_rs_ri_by_case_id(_RS_RI_CASE_ID)

        assert result is None

    def test_returns_most_recent_document(self, real_db):
        """Should return the document with the latest arrivedAt among multiple matches."""
        real_db["messages"].insert_many(
            [
                {
                    "type": _RS_RI_TYPE,
                    "arrivedAt": datetime(2024, 1, 1),
                    "payload": _RS_RI_PAYLOAD,
                },
                {
                    "type": _RS_RI_TYPE,
                    "arrivedAt": datetime(2024, 8, 1),  # le plus récent
                    "payload": _RS_RI_PAYLOAD,
                },
            ]
        )

        result = get_last_rs_ri_by_case_id(_RS_RI_CASE_ID)

        assert result.arrived_at == datetime(2024, 8, 1)


class TestGetLastRsSrByCaseId:
    def test_returns_documents_when_found(self, real_db):
        """Should return a list of PersistedMessage built from the found documents and conform to RS-SR schema."""
        rs_sr_1 = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 14),
            "payload": _make_rs_sr_payload(_RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_1),
        }
        rs_sr_2_v1 = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 14),
            "payload": _make_rs_sr_payload(_RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_2),
        }
        rs_sr_2_v2 = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 16),
            "payload": _make_rs_sr_payload(
                _RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_2, status="DECLENCHE"
            ),
        }
        rs_sr_2_v3 = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 17),
            "payload": _make_rs_sr_payload(
                _RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_2, status="DEPART"
            ),
        }
        rs_sr_2_v4 = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 18),
            "payload": _make_rs_sr_payload(
                _RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_2, status="ANNULE"
            ),
        }
        same_resource_other_case_rs_sr = {
            "type": _RS_SR_TYPE,
            "arrivedAt": datetime(2024, 8, 1, 19),
            "payload": _make_rs_sr_payload(_OTHER_RS_RI_CASE_ID, _RS_SR_RESOURCE_ID_1),
        }

        real_db["messages"].insert_many(
            [
                rs_sr_1,
                rs_sr_2_v1,
                rs_sr_2_v2,
                rs_sr_2_v3,
                rs_sr_2_v4,
                same_resource_other_case_rs_sr,
            ]
        )
        result = get_last_rs_sr_by_case_id(_RS_RI_CASE_ID)

        assert result is not None
        assert isinstance(result, list)
        assert len(result) == 2

        # useful to not rely on list ordering
        result_by_resource = {
            item.payload["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
                "resourcesStatus"
            ]["resourceId"]: item
            for item in result
        }

        # Assertions par resourceId
        assert _RS_SR_RESOURCE_ID_1 in result_by_resource
        assert _RS_SR_RESOURCE_ID_2 in result_by_resource

        # Ressource 1 : on récupère le rs_sr correspondant au case_id (rs_sr_1),
        # et non un plus récent correspondant un autre case_id (same_resource_other_case_rs_sr)
        assert result_by_resource[_RS_SR_RESOURCE_ID_1].arrived_at == datetime(
            2024, 8, 1, 14
        )

        # Ressource 2 : on récupère le rs_sr le plus récent pour la combinaison case_id / resource_id
        assert result_by_resource[_RS_SR_RESOURCE_ID_2].arrived_at == datetime(
            2024, 8, 1, 18
        )
        assert (
            result_by_resource[_RS_SR_RESOURCE_ID_2].payload["content"][0][
                "jsonContent"
            ]["embeddedJsonContent"]["message"]["resourcesStatus"]["state"]["status"]
            == "ANNULE"
        )

    def test_returns_empty_list_when_none_found(self, real_db):
        result = get_last_rs_sr_by_case_id("nonexistent_case")
        assert result == []

    @pytest.mark.parametrize("bad_input", [None, ""])
    def test_returns_none_for_invalid_case_id(self, real_db, bad_input):
        """Should return None immediately for invalid input without querying MongoDB."""
        result = get_last_rs_sr_by_case_id(bad_input)

        assert result == []

    def test_raises_on_mongodb_error(self, mock_db):
        """Should re-raise MongoDB exceptions after logging."""
        mock_db["messages"].aggregate.side_effect = RuntimeError("connection refused")

        with pytest.raises(RuntimeError, match="connection refused"):
            get_last_rs_sr_by_case_id(_RS_RI_CASE_ID)
