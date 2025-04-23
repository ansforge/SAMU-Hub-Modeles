
from converter.v1_v2.v1_v2_converter import V1_V2Converter
from converter.v2_v3.v2_v3_converter import V2_V3Converter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")
    converter = V1_V2Converter()
    V2V3Converter = V2_V3Converter()

    if source_version == 'v1' and target_version == 'v2':
        return converter.upgrade(edxl_json)

    elif source_version == 'v2' and target_version == 'v1':
        return converter.downgrade(edxl_json)

    # todo - implement chain pattern
    elif source_version == 'v2' and target_version == 'v3':
        return V2V3Converter.upgrade(edxl_json)

    elif source_version == 'v3' and target_version == 'v2':
        return V2V3Converter.downgrade(edxl_json)

    else:
        raise ValueError(f'Version conversion from {source_version} to {target_version} is currently not implemented')
