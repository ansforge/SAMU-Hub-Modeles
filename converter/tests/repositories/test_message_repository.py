"""Unit tests for converter.repository.get_last_rc_ri_by_case_id."""

from datetime import datetime, timezone
from functools import reduce
from unittest.mock import MagicMock, patch

import pytest
from pymongo import DESCENDING

from converter.models.persisted_message import PersistedMessage
from converter.repositories.message_repository import (
    _RC_RI_CASE_ID_PATH as _CASE_ID_FIELD,
    get_last_rc_ri_by_case_id,
)

_CASE_ID = "fr.health.samu800.DRFR158002421400215"

# Reflects the actual structure persisted by the dispatcher: content is a list.
_SAMPLE_PAYLOAD = {
    "distributionID": "fr.health.samu800.abc123",
    "content": [
        {
            "jsonContent": {
                "embeddedJsonContent": {
                    "message": {
                        "resourcesInfoCisu": {
                            "caseId": _CASE_ID,
                            "resource": [
                                {"resourceId": "fr.health.samu800.resource.VLM1"}
                            ],
                        }
                    }
                }
            }
        }
    ],
}


@pytest.fixture
def mock_db():
    """Provide a mocked MongoDB database inside a Flask app context."""
    db = MagicMock()
    with patch("converter.repositories.message_repository.get_db", return_value=db):
        yield db


class TestGetLastRcRiByCaseId:
    def test_returns_document_when_found(self, mock_db):
        """Should return a PersistedMessage built from the found document."""
        arrived_at = datetime(2024, 8, 1, 14, 0, 0, tzinfo=timezone.utc)
        raw_doc = {
            "_id": "some-id",
            "type": "ResourcesInfoCisuWrapper",
            "arrivedAt": arrived_at,
            "payload": _SAMPLE_PAYLOAD,
        }
        mock_db["messages"].find_one.return_value = raw_doc

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result == PersistedMessage(
            message_type="ResourcesInfoCisuWrapper",
            payload=_SAMPLE_PAYLOAD,
            id="some-id",
            arrived_at=arrived_at,
        )

    def test_returns_none_when_not_found(self, mock_db):
        """Should return None when no RC-RI document matches the caseId."""
        mock_db["messages"].find_one.return_value = None

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result is None

    def test_find_one_called_with_correct_args(self, mock_db):
        """find_one must receive the correct filter and sort in a single call."""
        mock_db["messages"].find_one.return_value = None

        get_last_rc_ri_by_case_id(_CASE_ID)

        mock_db["messages"].find_one.assert_called_once_with(
            {"type": "ResourcesInfoCisuWrapper", _CASE_ID_FIELD: _CASE_ID},
            sort=[("arrivedAt", DESCENDING)],
        )

    @pytest.mark.parametrize("bad_input", [None, "", 42, [], {}])
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

    def test_raises_on_corrupted_document(self, mock_db):
        """Should propagate KeyError when MongoDB returns a document missing required fields."""
        mock_db["messages"].find_one.return_value = {
            "_id": "some-id"
        }  # missing type/arrivedAt/payload

        with pytest.raises(KeyError):
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
