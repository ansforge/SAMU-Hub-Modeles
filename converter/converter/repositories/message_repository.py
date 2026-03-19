import logging

from pymongo import DESCENDING
from typing import Any, Mapping, Sequence

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

_RS_RI_TYPE = "ResourcesInfoWrapper"
_RS_RI_CASE_ID_PATH = ".".join(
    [
        "payload",
        "content",
        "jsonContent",
        "embeddedJsonContent",
        "message",
        "resourcesInfo",
        "caseId",
    ]
)

_RS_SR_TYPE = "ResourcesStatusWrapper"
_RS_SR_CASE_ID_PATH = ".".join(
    [
        "payload",
        "content",
        "jsonContent",
        "embeddedJsonContent",
        "message",
        "resourcesStatus",
        "caseId",
    ]
)
_RS_SR_RESOURCE_ID_PATH = ".".join(
    [
        "payload",
        "content",
        "jsonContent",
        "embeddedJsonContent",
        "message",
        "resourcesStatus",
        "resourceId",
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


def get_rs_messages_by_case_id(
    case_id: str,
) -> tuple[PersistedMessage | None, list[PersistedMessage]]:
    """
    Return:
      - the most recent RS-RI message for the case
      - the most recent RS-SR message for each resource of the case
    """
    if not isinstance(case_id, str) or not case_id:
        logger.warning("Invalid case_id provided: %r", case_id)
        return None, []

    rs_ri = get_last_rs_ri_by_case_id(case_id)
    rs_sr = get_last_rs_sr_by_case_id(case_id)

    return rs_ri, rs_sr


def get_last_rs_ri_by_case_id(case_id: str) -> PersistedMessage | None:
    """Return the most recently persisted RS-RI document for *case_id*, or ``None``."""
    return _get_last_by_case_id(case_id, _RS_RI_TYPE, _RS_RI_CASE_ID_PATH)


def get_last_rs_sr_by_case_id(case_id: str) -> list[PersistedMessage]:
    """Return the most recently persisted RS-SR document for each resource attached to a *case_id*."""
    collection = get_db()[_COLLECTION]

    pipeline: Sequence[Mapping[str, Any]] = [
        {
            "$match": {
                "type": _RS_SR_TYPE,
                _RS_SR_CASE_ID_PATH: case_id,
            }
        },
        {"$sort": {"arrivedAt": -1}},
        {
            "$group": {
                "_id": f"${_RS_SR_RESOURCE_ID_PATH}",
                "doc": {"$first": "$$ROOT"},
            }
        },
        {"$replaceRoot": {"newRoot": "$doc"}},
    ]

    try:
        documents = list(collection.aggregate(pipeline))
    except Exception:
        logger.exception("Error querying RS-SR messages for caseId=%s", case_id)
        raise

    rs_sr: list[PersistedMessage] = []

    for doc in documents:
        try:
            rs_sr.append(PersistedMessage.from_mongo(doc))
        except Exception:
            logger.exception("Invalid RS-SR document (id=%s)", doc.get("_id"))
            raise

    return rs_sr
