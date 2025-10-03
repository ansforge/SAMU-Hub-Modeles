from converter.conversion_strategy.health_conversion_strategy import (
    health_conversion_strategy,
)
from .cisu_conversion_strategy import cisu_conversion_strategy


def conversion_strategy(
    edxl_json, source_version: str, target_version: str, is_cisu_conversion: bool
):
    if is_cisu_conversion:
        return cisu_conversion_strategy(edxl_json, source_version, target_version)
    else:
        return health_conversion_strategy(edxl_json, source_version, target_version)
