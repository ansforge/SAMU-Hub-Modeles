
from converter.v1_v2.v1_v2_converter import V1_V2Converter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")
    converter = V1_V2Converter()

    if source_version == 'v1' and target_version == 'v2':
        return converter.upgrade(edxl_json)

    elif source_version == 'v2' and target_version == 'v1':
        return converter.downgrade(edxl_json)

    else:
        raise ValueError(f'Version conversion from {source_version} to {target_version} is currently not implemented')
