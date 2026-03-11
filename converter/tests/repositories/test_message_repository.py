"""Unit tests for converter.repository.get_last_rc_ri_by_case_id."""

from datetime import datetime
from functools import reduce
from pathlib import Path
from unittest.mock import MagicMock, patch

import copy
import json
import uuid
import mongomock
import pytest
from pymongo import DESCENDING

from converter.models.persisted_message import PersistedMessage
from converter.repositories.message_repository import (
    _RC_RI_CASE_ID_PATH as _CASE_ID_FIELD,
    get_last_rc_ri_by_case_id,
)

_CASE_ID = "fr.health.samu800.DRFR158002421400215"
_OTHER_CASE_ID = "fr.health.samu800.OTHERUNRELATEDCASE"
_SAMPLE_PAYLOAD = json.load(Path("tests/fixtures/sample_rc_ri_payload.json").open())


def _make_payload(case_id: str) -> dict:
    """Build a minimal RC-RI payload with the given caseId embedded in the real nested structure."""
    payload = copy.deepcopy(_SAMPLE_PAYLOAD)
    payload["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfoCisu"
    ]["caseId"] = case_id
    return payload


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
                _CASE_ID_FIELD: _CASE_ID,
                "arrivedAt": arrived_at,
                "payload": _SAMPLE_PAYLOAD,
            }
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result is not None
        assert isinstance(result, PersistedMessage)
        assert result.message_type == "ResourcesInfoCisuWrapper"
        assert result.arrived_at == arrived_at
        assert result.payload == _SAMPLE_PAYLOAD

        # Validate RC-RI schema conformity
        rc_ri = result.payload["content"][0]["jsonContent"]["embeddedJsonContent"][
            "message"
        ]["resourcesInfoCisu"]
        assert "caseId" in rc_ri
        assert isinstance(rc_ri["caseId"], str)
        assert "resource" in rc_ri
        assert isinstance(rc_ri["resource"], list)
        assert len(rc_ri["resource"]) >= 1
        for res in rc_ri["resource"]:
            assert "resourceId" in res

    def test_returns_none_when_not_found(self, real_db):
        """Should return None when no RC-RI document exists for the given caseId."""
        real_db["messages"].insert_one(
            {
                "type": "ResourcesInfoCisuWrapper",
                "arrivedAt": datetime(2024, 8, 1),
                "payload": _make_payload(
                    _OTHER_CASE_ID
                ),  # different caseId in nested path
            }
        )
        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result is None

    def test_returns_most_recent_document(self, real_db):
        """Should return the document with the latest arrivedAt among multiple matches."""
        real_db["messages"].insert_many(
            [
                {
                    "type": "ResourcesInfoCisuWrapper",
                    _CASE_ID_FIELD: _CASE_ID,
                    "arrivedAt": datetime(2024, 1, 1),
                    "payload": _SAMPLE_PAYLOAD,
                },
                {
                    "type": "ResourcesInfoCisuWrapper",
                    _CASE_ID_FIELD: _CASE_ID,
                    "arrivedAt": datetime(2024, 8, 1),  # le plus récent
                    "payload": _SAMPLE_PAYLOAD,
                },
            ]
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result.arrived_at == datetime(2024, 8, 1)

    def test_find_one_called_with_correct_args(self, mock_db):
        """find_one must receive the correct filter and sort in a single call."""
        mock_db["messages"].find_one.return_value = None

        get_last_rc_ri_by_case_id(_CASE_ID)

        mock_db["messages"].find_one.assert_called_once_with(
            {"type": "ResourcesInfoCisuWrapper", _CASE_ID_FIELD: _CASE_ID},
            sort=[("arrivedAt", DESCENDING)],
        )

    @pytest.mark.parametrize("bad_input", [None, ""])
    def test_returns_none_for_invalid_case_id(self, mock_db, bad_input):
        """Should return None immediately without querying MongoDB for invalid input."""
        result = get_last_rc_ri_by_case_id(bad_input)

        assert result is None
        mock_db["messages"].find_one.assert_not_called()

    def test_raises_on_mongodb_error(self, mock_db):
        """Should re-raise MongoDB exceptions after logging."""
        mock_db["messages"].find_one.side_effect = RuntimeError("connection refused")

        with pytest.raises(RuntimeError, match="connection refused"):
            get_last_rc_ri_by_case_id(_CASE_ID)


def _mongo_get(doc: dict, path: str):
    """Resolve a MongoDB dot-notation path against a Python dict, traversing lists transparently."""

    def step(obj, key):
        if isinstance(obj, list):
            return obj[0][key]  # MongoDB implicit array traversal
        return obj[key]

    return reduce(step, path.split("."), doc)


class TestRcRiCaseIdPath:
    def test_path_resolves_case_id_from_real_payload_structure(self):
        """_RC_RI_CASE_ID_PATH must point to caseId in a document with the real dispatcher payload structure."""
        doc = {"payload": _SAMPLE_PAYLOAD}
        assert _mongo_get(doc, _CASE_ID_FIELD) == _CASE_ID
