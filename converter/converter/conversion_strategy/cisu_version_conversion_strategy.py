import logging

logger = logging.getLogger(__name__)


def cisu_version_conversion_strategy(edxl_json, source_version, target_version):
    logger.info(f"CISU Conversion initiated from {source_version} to {target_version}")

    raise NotImplementedError(
        "Conversion strategy 'cisu_version_conversion_strategy' not yet implemented."
    )
