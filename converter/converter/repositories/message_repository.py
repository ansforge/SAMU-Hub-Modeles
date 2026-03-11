import logging

from pymongo import DESCENDING

from converter.database import get_db
from converter.models.persisted_message import PersistedMessage

logger = logging.getLogger(__name__)

_COLLECTION = "messages"
_RC_RI_TYPE = "ResourcesInfoCisuWrapper"
_CASE_ID_PATH = ".".join([
    "payload", "content", "jsonContent",
    "embeddedJsonContent", "message", "resourcesInfoCisu", "caseId",
])


def get_last_resource_info_cisu_by_case_id(case_id: str) -> PersistedMessage | None:
    """Return the most recently persisted RC-RI document for *case_id*, or ``None``."""
    if not isinstance(case_id, str) or not case_id:
        logger.warning("Invalid case_id provided: %r", case_id)
        return None

    logger.info("Querying last RC-RI message for caseId=%s", case_id)

    collection = get_db()[_COLLECTION]
    query = {"type": _RC_RI_TYPE, _CASE_ID_PATH: case_id}
    try:
        document = collection.find_one(query, sort=[("arrivedAt", DESCENDING)])
    except Exception:
        logger.exception("Error querying RC-RI message for caseId=%s", case_id)
        raise

    if document is None:
        logger.info("No RC-RI message found for caseId=%s", case_id)
        return None

    logger.info(
        "Found RC-RI message for caseId=%s (arrivedAt=%s)",
        case_id,
        document.get("arrivedAt"),
    )
    return PersistedMessage.from_mongo(document)
