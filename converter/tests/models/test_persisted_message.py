"""Unit tests for PersistedMessage.from_mongo mapping robustness."""
from datetime import datetime, timezone

import pytest

from converter.models.persisted_message import PersistedMessage


class TestPersistedMessageFromMongo:
    def test_nominal(self):
        """Should correctly map all fields from a complete document."""
        arrived_at = datetime(2024, 8, 1, 14, 0, 0, tzinfo=timezone.utc)
        doc = {
            "_id": "abc123",
            "type": "ResourcesInfoCisuWrapper",
            "arrivedAt": arrived_at,
            "payload": {"content": {"key": "value"}},
        }

        result = PersistedMessage.from_mongo(doc)

        assert result.id == "abc123"
        assert result.message_type == "ResourcesInfoCisuWrapper"
        assert result.arrived_at == arrived_at
        assert result.payload == {"content": {"key": "value"}}

    def test_missing_id_yields_none(self):
        """Should set id=None when _id is absent from the document."""
        doc = {
            "type": "ResourcesInfoCisuWrapper",
            "arrivedAt": datetime(2024, 1, 1, tzinfo=timezone.utc),
            "payload": {},
        }

        result = PersistedMessage.from_mongo(doc)

        assert result.id is None

    def test_missing_arrived_at_yields_none(self):
        """Should set arrived_at=None when arrivedAt is absent from the document."""
        doc = {
            "_id": "abc123",
            "type": "ResourcesInfoCisuWrapper",
            "payload": {},
        }

        result = PersistedMessage.from_mongo(doc)

        assert result.arrived_at is None

    def test_missing_payload_defaults_to_empty_dict(self):
        """Should default payload to {} when absent from the document."""
        doc = {
            "_id": "abc123",
            "type": "ResourcesInfoCisuWrapper",
        }

        result = PersistedMessage.from_mongo(doc)

        assert result.payload == {}

    def test_all_optional_fields_missing(self):
        """Should produce a valid object even with only required fields present."""
        doc = {"type": "ResourcesInfoCisuWrapper"}

        result = PersistedMessage.from_mongo(doc)

        assert result.message_type == "ResourcesInfoCisuWrapper"
        assert result.id is None
        assert result.arrived_at is None
        assert result.payload == {}
