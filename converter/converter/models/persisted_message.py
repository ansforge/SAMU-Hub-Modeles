from __future__ import annotations

from dataclasses import dataclass
from datetime import datetime
from typing import Any


@dataclass
class PersistedMessage:
    message_type: str
    payload: dict[str, Any]
    arrived_at: datetime
    id: str | None = None

    @classmethod
    def from_mongo(cls, doc: dict) -> PersistedMessage:
        return cls(
            message_type=doc["type"],
            payload=doc["payload"],
            arrived_at=doc["arrivedAt"],
            id=str(doc["_id"]) if doc.get("_id") is not None else None,
        )
