from dataclasses import dataclass
from typing import Any, Dict, Optional
from datetime import datetime

@dataclass
class PersistedMessage:
    id: Optional[str]
    message_type: str
    arrivedAt: Optional[datetime]
    payload: Dict[str, Any]

    @classmethod
    def from_mongo(cls, doc: dict) -> "PersistedMessage":
        return cls(
            id=str(doc["_id"]),
            message_type=doc.get("type"),
            arrivedAt=doc.get("arrivedAt"),
            payload=doc.get("payload", {}),
        )
