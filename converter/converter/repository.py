import logging
from typing import Optional

from pymongo import DESCENDING

from converter.database import get_db

logger = logging.getLogger(__name__)

_COLLECTION = "messages"
_RC_RI_TYPE = "ResourcesInfoCisuWrapper"

# MongoDB dot-notation path to caseId inside the persisted EDXL payload.
# Using .join() keeps each segment explicit and easy to update.
_CASE_ID_PATH = ".".join([
    "payload", "content", "jsonContent",
    "embeddedJsonContent", "message", "resourcesInfoCisu", "caseId",
])


def get_last_resource_info_cisu_by_case_id(case_id: str) -> Optional[dict]:
    """Return the most recently persisted RC-RI document for *case_id*, or ``None``."""
    logger.info("Querying last RC-RI message for caseId=%s", case_id)

    collection = get_db()[_COLLECTION]
    query = {"type": _RC_RI_TYPE, _CASE_ID_PATH: case_id}
    
    document = collection.find_one(query,sort=[("arrivedAt", DESCENDING)])

    if document is None:
        logger.info("No RC-RI message found for caseId=%s", case_id)
    else:
        logger.info(
            "Found RC-RI message for caseId=%s (arrivedAt=%s)",
            case_id,
            document.get("arrivedAt"),
        )

    return document
