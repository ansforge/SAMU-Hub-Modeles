from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from converter.conversion_strategy.cisu_transcoding_strategy import (
    cisu_transcoding_strategy,
)


def conversion_strategy(
    edxl_json, source_version: str, target_version: str, is_cisu_conversion: bool
) -> list:
    if is_cisu_conversion:
        converted_edxl = cisu_transcoding_strategy(
            edxl_json, source_version, target_version
        )
    else:
        converted_edxl = health_conversion_strategy(
            edxl_json, source_version, target_version
        )
    return converted_edxl if isinstance(converted_edxl, list) else [converted_edxl]
