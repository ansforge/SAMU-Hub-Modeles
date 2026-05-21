import logging
from converter.cisu_version_converters.create_case.rc_eda_version_converter import (
    CreateCaseVersionConverter,
)
from converter.cisu_version_converters.resources_info_cisu.resources_info_cisu_version_converter import (
    ResourcesInfoCISUVersionConverter,
)
from converter.utils import (
    extract_message_type_from_message_content,
    extract_message_content,
)
from converter.cisu_version_converters.identical_cisu_version_converter import (
    IdenticalCISUVersionConverter,
)

logger = logging.getLogger(__name__)


def cisu_version_conversion_strategy(edxl_json, source_version, target_version):
    logger.info(f"CISU Conversion initiated from {source_version} to {target_version}")

    message_content = extract_message_content(edxl_json)
    selected_strategy = select_conversion_strategy(message_content)

    return selected_strategy.convert(source_version, target_version, edxl_json)


def select_conversion_strategy(message_content):
    if "createCase" in message_content:
        return CreateCaseVersionConverter
    elif "resourcesInfoCisu" in message_content:
        return ResourcesInfoCISUVersionConverter
    elif "reference" in message_content:
        return IdenticalCISUVersionConverter
    elif "error" in message_content:
        return IdenticalCISUVersionConverter
    else:
        deducted_message_type = extract_message_type_from_message_content(
            message_content
        )
        raise ValueError(
            f"CISU Version conversion for message type '{deducted_message_type}' is not implemented."
        )
