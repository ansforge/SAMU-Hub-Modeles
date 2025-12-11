import logging

from converter.cisu.create_case.create_case_cisu_converter import (
    CreateCaseCISUConverter,
)
from converter.cisu.reference.reference_converter import ReferenceConverter
from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from converter.cisu.resources_status.resources_status_converter import (
    ResourcesStatusConverter,
)
from converter.constants import Constants
from converter.cisu.constants import CISUConstants
from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from converter.utils import (
    get_recipient,
    get_sender,
    extract_message_content,
    extract_message_type_from_message_content,
)

logger = logging.getLogger(__name__)


def cisu_conversion_strategy(edxl_json, source_version, target_version):
    logger.info(f"CISU Conversion initiated from {source_version} to {target_version}")

    direction = compute_message_direction(edxl_json)
    message_content = extract_message_content(edxl_json)
    selected_strategy = select_conversion_strategy(message_content)

    if direction == CISUConstants.TO_CISU:
        logger.info(
            "Conversion RS -> CISU",
        )
        if target_version != CISUConstants.MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown target version {target_version}. Must be: {CISUConstants.MAINTAINED_CISU_VERSION}"
            )

        rs_json_message = health_conversion_strategy(
            edxl_json, source_version, CISUConstants.MAINTAINED_CISU_VERSION
        )

        return selected_strategy.from_rs_to_cisu(rs_json_message)
    elif direction == CISUConstants.FROM_CISU:
        logger.info(
            "Conversion CISU -> RS",
        )
        if source_version != CISUConstants.MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown source version {source_version}. Must be: {CISUConstants.MAINTAINED_CISU_VERSION}"
            )

        rc_json_message = selected_strategy.from_cisu_to_rs(edxl_json)
        return health_conversion_strategy(
            rc_json_message, CISUConstants.MAINTAINED_CISU_VERSION, target_version
        )
    else:
        raise ValueError("Invalid direction parameter")


def compute_message_direction(edxl_json):
    # Compute direction based on sender / recipient
    sender = get_sender(edxl_json)
    recipient = get_recipient(edxl_json)
    if sender.startswith(Constants.FR_HEALTH_PREFIX) and recipient.startswith(
        Constants.FR_HEALTH_PREFIX
    ):
        raise ValueError(
            f"Both sender and recipient are health: {sender} -> {recipient}"
        )
    elif sender.startswith(Constants.FR_HEALTH_PREFIX):
        return CISUConstants.TO_CISU
    else:
        return CISUConstants.FROM_CISU


def select_conversion_strategy(message_content):
    if "createCase" in message_content or "createCaseHealth" in message_content:
        return CreateCaseCISUConverter
    elif "resourcesInfo" in message_content or "resourcesInfoCisu" in message_content:
        return ResourcesInfoCISUConverter
    elif (
        "resourcesStatus" in message_content or "resourcesStatusCisu" in message_content
    ):
        return ResourcesStatusConverter
    elif "reference" in message_content:
        return ReferenceConverter
    else:
        deducted_message_type = extract_message_type_from_message_content(
            message_content
        )
        raise ValueError(
            f"Perimeter translation for message type '{deducted_message_type}' is not implemented."
        )
