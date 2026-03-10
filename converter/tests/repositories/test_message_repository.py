"""Unit tests for converter.repository.get_last_resource_info_cisu_by_case_id."""
from datetime import datetime, timezone
from unittest.mock import MagicMock, patch

import pytest
from pymongo import DESCENDING

from converter.models.persisted_message import PersistedMessage
from converter.repositories.message_repository import get_last_resource_info_cisu_by_case_id


CASE_ID = "fr.health.samu800.DRFR158002421400215"

_CASE_ID_FIELD = ".".join([
    "payload", "content", "jsonContent",
    "embeddedJsonContent", "message", "resourcesInfoCisu", "caseId",
])


@pytest.fixture
def mock_db():
    """Provide a mocked MongoDB database inside a Flask app context."""
    db = MagicMock()
    with patch("converter.repositories.message_repository.get_db", return_value=db):
        yield db


class TestGetLastResourceInfoCisuByCaseId:
    def test_returns_document_when_found(self, mock_db):
        """Should return a PersistedMessage built from the found document."""
        arrived_at = datetime(2024, 8, 1, 14, 0, 0, tzinfo=timezone.utc)
        raw_doc = {
            "_id": "some-id",
            "type": "ResourcesInfoCisuWrapper",
            "arrivedAt": arrived_at,
            "payload": {},
        }
        mock_db["messages"].find_one.return_value = raw_doc

        result = get_last_resource_info_cisu_by_case_id(CASE_ID)

        assert result == PersistedMessage(
            message_type="ResourcesInfoCisuWrapper",
            payload={},
            id="some-id",
            arrived_at=arrived_at,
        )

    def test_returns_none_when_not_found(self, mock_db):
        """Should return None when no RC-RI document matches the caseId."""
        mock_db["messages"].find_one.return_value = None

        result = get_last_resource_info_cisu_by_case_id(CASE_ID)

        assert result is None

    def test_queries_correct_filter(self, mock_db):
        """find_one must be called with the correct type and caseId filter."""
        mock_db["messages"].find_one.return_value = None

        get_last_resource_info_cisu_by_case_id(CASE_ID)

        call_kwargs = mock_db["messages"].find_one.call_args
        applied_filter = call_kwargs.kwargs.get("filter") or call_kwargs.args[0]

        assert applied_filter["type"] == "ResourcesInfoCisuWrapper"
        assert applied_filter[_CASE_ID_FIELD] == CASE_ID

    def test_sorts_descending_by_arrived_at(self, mock_db):
        """find_one must sort descending on arrivedAt to get the most recent doc."""
        mock_db["messages"].find_one.return_value = None

        get_last_resource_info_cisu_by_case_id(CASE_ID)

        call_kwargs = mock_db["messages"].find_one.call_args
        applied_sort = call_kwargs.kwargs.get("sort") or call_kwargs.args[1]

        assert applied_sort == [("arrivedAt", DESCENDING)]
