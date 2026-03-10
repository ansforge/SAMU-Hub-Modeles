from __future__ import annotations

from dataclasses import dataclass
from datetime import datetime
from typing import Any


@dataclass
class PersistedMessage:
    message_type: str
    payload: dict[str, Any]
    id: str | None = None
    arrived_at: datetime | None = None

    @classmethod
    def from_mongo(cls, doc: dict) -> PersistedMessage:
        return cls(
            message_type=doc.get("type"),
            payload=doc.get("payload", {}),
            id=str(doc["_id"]) if doc.get("_id") is not None else None,
            arrived_at=doc.get("arrivedAt"),
        )
