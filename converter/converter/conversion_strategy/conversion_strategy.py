from typing import Any, Dict

from converter.conversion_strategy.health_version_conversion_strategy import (
    health_version_conversion_strategy,
)
from converter.conversion_strategy.cisu_transcoding_strategy import (
    cisu_transcoding_strategy,
)
from converter.conversion_strategy.cisu_version_conversion_strategy import (
    cisu_version_conversion_strategy,
)
from converter.constants import ConversionType


def conversion_strategy(
    edxl_json, source_version: str, target_version: str, conversion_type: ConversionType
) -> list:
    converted_edxl: Dict[str, Any] | list[Dict[str, Any]] | list = []

    if conversion_type == ConversionType.CISUVersionConversion:
        converted_edxl = cisu_version_conversion_strategy(
            edxl_json, source_version, target_version
        )

    elif conversion_type == ConversionType.HealthVersionConversion:
        converted_edxl = health_version_conversion_strategy(
            edxl_json, source_version, target_version
        )

    elif conversion_type == ConversionType.CISUTranscoding:
        converted_edxl = cisu_transcoding_strategy(
            edxl_json, source_version, target_version
        )

    else:
        raise ValueError(f"Unknown conversion type: {conversion_type}")

    return converted_edxl if isinstance(converted_edxl, list) else [converted_edxl]
