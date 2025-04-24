
from converter.v1_v2.v1_v2_converter import V1_V2Converter
from converter.v2_v3.v2_v3_converter import V2_V3Converter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")
    v1_v2_converter = V1_V2Converter()
    v2_v3_converter = V2_V3Converter()

    if source_version == 'v1' and target_version == 'v2':
        return v1_v2_converter.upgrade(edxl_json)

    elif source_version == 'v2' and target_version == 'v1':
        return v1_v2_converter.downgrade(edxl_json)

    # todo - implement chain pattern
    elif source_version == 'v2' and target_version == 'v3':
        return v2_v3_converter.upgrade(edxl_json)

    elif source_version == 'v3' and target_version == 'v2':
        return v2_v3_converter.downgrade(edxl_json)

    elif source_version == 'v1' and target_version == 'v3':
        v2_message = v1_v2_converter.upgrade(edxl_json)
        return v2_v3_converter.upgrade(v2_message)

    elif source_version == 'v3' and target_version == 'v1':
        v2_message = v2_v3_converter.downgrade(edxl_json)
        return v1_v2_converter.downgrade(v2_message)

    else:
        raise ValueError(f'Version conversion from {source_version} to {target_version} is currently not implemented')
