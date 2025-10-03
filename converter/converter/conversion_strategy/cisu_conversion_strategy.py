from converter.cisu.cisu_converter import CISUConverterV3
from converter.constants import Constants
from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from converter.utils import get_recipient, get_sender


def cisu_conversion_strategy(edxl_json, source_version, target_version):
    print(f"CISU Conversion initiated from {source_version} to {target_version}")

    TO_CISU = "to_CISU"
    FROM_CISU = "from_CISU"
    MAINTAINED_CISU_VERSION = "v3"

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
        direction = TO_CISU
    else:
        direction = FROM_CISU

    if direction == TO_CISU:
        if target_version != MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown target version {target_version}. Must be: {MAINTAINED_CISU_VERSION}"
            )

        rs_json_message = health_conversion_strategy(
            edxl_json, source_version, MAINTAINED_CISU_VERSION
        )
        return CISUConverterV3.to_cisu(rs_json_message)
    elif direction == FROM_CISU:
        if source_version != MAINTAINED_CISU_VERSION:
            raise ValueError(
                f"Unknown source version {source_version}. Must be: {MAINTAINED_CISU_VERSION}"
            )

        rc_json_message = CISUConverterV3.from_cisu(edxl_json)
        return health_conversion_strategy(
            rc_json_message, MAINTAINED_CISU_VERSION, target_version
        )
    else:
        raise ValueError("Invalid direction parameter")
