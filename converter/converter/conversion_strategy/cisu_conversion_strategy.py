from converter.cisu.cisu_converter import CISUConverterV3
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
    if sender.startswith('fr.health') and recipient.startswith('fr.health'):
        raise ValueError(f'Both sender and recipient are health: {sender} -> {recipient}')
    elif sender.startswith('fr.health'):
        direction = TO_CISU
    else:
        direction = FROM_CISU

    if source_version not in converters:
        raise ValueError(f"Invalid version {source_version} for CISU conversion")
    converter = converters[source_version]
    print(f"Converting {direction} {source_version}")

    if direction == TO_CISU:
        return converter.to_cisu(edxl_json)
    elif direction == FROM_CISU:
        return converter.from_cisu(edxl_json)
    else:
        raise ValueError('Invalid direction parameter')
