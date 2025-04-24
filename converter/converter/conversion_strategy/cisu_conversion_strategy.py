from converter.cisu.cisu_converter import CISUConverterV3
from converter.constants import Constants
from converter.conversion_strategy.health_conversion_strategy import health_conversion_strategy
from converter.utils import get_recipient, get_sender

def cisu_conversion_strategy(edxl_json, source_version):
    """CISU conversion endpoint: back and forth between CISU and Health"""
    TO_CISU = "to_CISU"
    FROM_CISU = "from_CISU"
    converters = {
        'v3': CISUConverterV3
    }

    # Compute direction based on sender / recipient
    sender = get_sender(edxl_json)
    recipient = get_recipient(edxl_json)
    if sender.startswith(Constants.FR_HEALTH_PREFIX) and recipient.startswith(Constants.FR_HEALTH_PREFIX):
        raise ValueError(f'Both sender and recipient are health: {sender} -> {recipient}')
    elif sender.startswith(Constants.FR_HEALTH_PREFIX):
        direction = TO_CISU
    else:
        direction = FROM_CISU

    # if source_version not in converters:
    #     raise ValueError(f"Invalid version {source_version} for CISU conversion")
    converter = converters["v3"]
    print(f"Converting {direction} {source_version}")

    if direction == TO_CISU:
        v3_rs_message = health_conversion_strategy(edxl_json, "v2", "v3")
        return converter.to_cisu(v3_rs_message)
    elif direction == FROM_CISU:
        v3_rs_message = converter.from_cisu(edxl_json)
        return health_conversion_strategy(v3_rs_message, "v3", "v2")
    else:
        raise ValueError('Invalid direction parameter')
