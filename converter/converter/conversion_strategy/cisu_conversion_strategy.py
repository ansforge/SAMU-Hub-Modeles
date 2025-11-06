from converter.cisu.cisu_converter import CISUConverterV3
from converter.constants import Constants
from converter.cisu.constants import CISUConstants
from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from converter.utils import get_recipient, get_sender


def cisu_conversion_strategy(edxl_json, source_version, target_version):
    print(f"CISU Conversion initiated from {source_version} to {target_version}")

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
        direction = CISUConstants.TO_CISU
    else:
        direction = CISUConstants.FROM_CISU

    if direction == CISUConstants.TO_CISU:
        if target_version != CISUConstants.MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown target version {target_version}. Must be: {CISUConstants.MAINTAINED_CISU_VERSION}"
            )

        rs_json_message = health_conversion_strategy(
            edxl_json, source_version, CISUConstants.MAINTAINED_CISU_VERSION
        )
        return CISUConverterV3.to_cisu(rs_json_message)
    elif direction == CISUConstants.FROM_CISU:
        if source_version != CISUConstants.MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown source version {source_version}. Must be: {CISUConstants.MAINTAINED_CISU_VERSION}"
            )

        rc_json_message = CISUConverterV3.from_cisu(edxl_json)
        return health_conversion_strategy(
            rc_json_message, CISUConstants.MAINTAINED_CISU_VERSION, target_version
        )
    else:
        raise ValueError("Invalid direction parameter")
