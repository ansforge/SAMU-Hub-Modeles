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
)

_CASE_ID = "fr.health.samu800.DRFR158002421400215"
_OTHER_CASE_ID = "fr.health.samu800.OTHERUNRELATEDCASE"
_DIST_ID_A = "fr.health.samu800.abc123"
_DIST_ID_B = "fr.health.samu800.def456"
_SAMPLE_PAYLOAD = json.load(
    Path("tests/fixtures/RC-RI/sample_rc_ri_payload.json").open()
)


def _make_payload(case_id: str) -> dict:
    """Build a minimal RC-RI payload with the given caseId embedded in the real nested structure."""
    payload = copy.deepcopy(_SAMPLE_PAYLOAD)
    payload["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
        "resourcesInfoCisu"
    ]["caseId"] = case_id
    return payload


def _make_doc(distribution_id: str, arrived_at: datetime) -> dict:
    """Build a ResourcesInfoCisuWrapper document with the given distributionID."""
    payload = copy.deepcopy(_SAMPLE_PAYLOAD)
    payload["distributionID"] = distribution_id
    return {
        "type": "ResourcesInfoCisuWrapper",
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
                "payload": _SAMPLE_PAYLOAD,
            }
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result is not None
        assert isinstance(result, PersistedMessage)
        assert result.message_type == "ResourcesInfoCisuWrapper"
        assert result.arrived_at == arrived_at
        assert result.payload == _SAMPLE_PAYLOAD

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
                    "arrivedAt": datetime(2024, 1, 1),
                    "payload": _SAMPLE_PAYLOAD,
                },
                {
                    "type": "ResourcesInfoCisuWrapper",
                    "arrivedAt": datetime(2024, 8, 1),  # le plus récent
                    "payload": _SAMPLE_PAYLOAD,
                },
            ]
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID)

        assert result.arrived_at == datetime(2024, 8, 1)

    def test_ignores_documents_with_wrong_type(self, real_db):
        """Should not return documents whose type is not ResourcesInfoCisuWrapper."""
        real_db["messages"].insert_one(
            {
                "type": "SomeOtherWrapper",
                "arrivedAt": datetime(2024, 8, 1),
                "payload": _SAMPLE_PAYLOAD,
            }
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID)

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
            get_last_rc_ri_by_case_id(_CASE_ID)

    # --- exclude_distribution_id ---

    def test_returns_none_when_only_matching_document_is_excluded(self, real_db):
        """When the only matching document is excluded, should return None."""
        real_db["messages"].insert_one(_make_doc(_DIST_ID_A, datetime(2024, 8, 1)))

        result = get_last_rc_ri_by_case_id(_CASE_ID, exclude_distribution_id=_DIST_ID_A)

        assert result is None

    def test_returns_previous_when_most_recent_document_is_excluded(self, real_db):
        """When the most recent document is excluded, should return the previous one."""
        real_db["messages"].insert_many(
            [
                _make_doc(_DIST_ID_A, datetime(2024, 1, 1)),  # old
                _make_doc(_DIST_ID_B, datetime(2024, 8, 1)),  # new
            ]
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID, exclude_distribution_id=_DIST_ID_B)

        assert result is not None
        assert result.payload["distributionID"] == _DIST_ID_A

    def test_exclude_none_behaves_normally(self, real_db):
        """Passing exclude_distribution_id=None must not filter anything."""
        real_db["messages"].insert_many(
            [
                _make_doc(_DIST_ID_A, datetime(2024, 8, 1)),
                _make_doc(_DIST_ID_B, datetime(2024, 3, 1)),
            ]
        )

        result = get_last_rc_ri_by_case_id(_CASE_ID, exclude_distribution_id=None)

        assert result is not None
        assert result.payload["distributionID"] == _DIST_ID_A
