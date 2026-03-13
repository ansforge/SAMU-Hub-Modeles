import logging

from pymongo import DESCENDING

from converter.database import get_db
from converter.models.persisted_message import PersistedMessage

logger = logging.getLogger(__name__)

_COLLECTION = "messages"

_DISTRIBUTION_ID_PATH = ".".join(["payload", "distributionID"])

_RC_RI_TYPE = "ResourcesInfoCisuWrapper"
_RC_RI_CASE_ID_PATH = ".".join(
    [
        "payload",
        "content",
        "jsonContent",
        "embeddedJsonContent",
        "message",
        "resourcesInfoCisu",
        "caseId",
    ]
)


def _get_last_by_case_id(
    case_id: str,
    message_type: str,
    case_id_path: str,
    exclude_distribution_id: str | None = None,
) -> PersistedMessage | None:
    """Return the most recently persisted message of *message_type* for *case_id*, or ``None``."""
    if not isinstance(case_id, str) or not case_id:
        logger.warning("Invalid case_id provided: %r", case_id)
        return None

    logger.info("Querying last %s message for caseId=%s", message_type, case_id)

    collection = get_db()[_COLLECTION]
    query: dict = {"type": message_type, case_id_path: case_id}

    if exclude_distribution_id:
        query[_DISTRIBUTION_ID_PATH] = {"$ne": exclude_distribution_id}
        logger.debug("Excluding distributionID=%s from query", exclude_distribution_id)
    try:
        document = collection.find_one(query, sort=[("arrivedAt", DESCENDING)])
    except Exception:
        logger.exception(
            "Error querying %s message for caseId=%s", message_type, case_id
        )
        raise

    if document is None:
        logger.info("No %s message found for caseId=%s", message_type, case_id)
        return None

    logger.info(
        "Found %s message for caseId=%s (arrivedAt=%s)",
        message_type,
        case_id,
        document.get("arrivedAt"),
    )
    try:
        return PersistedMessage.from_mongo(document)
    except (KeyError, TypeError) as exc:
        logger.error(
            "Corrupted %s document for caseId=%s (id=%s): %s",
            message_type,
            case_id,
            document.get("_id"),
            exc,
        )
        raise


def get_last_rc_ri_by_case_id(
    case_id: str, exclude_distribution_id: str | None = None
) -> PersistedMessage | None:
    """Return the most recently persisted RC-RI document for *case_id*, or ``None``."""
    return _get_last_by_case_id(
        case_id, _RC_RI_TYPE, _RC_RI_CASE_ID_PATH, exclude_distribution_id
    )
