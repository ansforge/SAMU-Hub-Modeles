from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from converter.conversion_strategy.cisu_conversion_strategy import (
    cisu_conversion_strategy,
)


def conversion_strategy(
    edxl_json, source_version: str, target_version: str, is_cisu_conversion: bool
) -> list:
    if is_cisu_conversion:
        result = cisu_conversion_strategy(edxl_json, source_version, target_version)
    else:
        result = health_conversion_strategy(edxl_json, source_version, target_version)
    return result if isinstance(result, list) else [result]
