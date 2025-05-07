
from converter.v1_v2.create_case_health_converter import CreateHealthCaseConverter
from converter.v1_v2.reference_converter import ReferenceConverter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")

    if source_version == 'v1' and target_version == 'v2':
        message_content = edxl_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})
        if 'createCaseHealth' in message_content:
            return CreateHealthCaseConverter().upgrade(edxl_json)
        elif 'reference' in message_content:
            return ReferenceConverter().upgrade(edxl_json)
        else:
            raise ValueError(f'Version conversion from {source_version} to {target_version} for the provided message type is currently not implemented')


    elif source_version == 'v2' and target_version == 'v1':
        message_content = edxl_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})
        if 'createCaseHealth' in message_content:
            return CreateHealthCaseConverter().downgrade(edxl_json)
        elif 'reference' in message_content:
            return ReferenceConverter().downgrade(edxl_json)
        else:
            raise ValueError(f'Version conversion from {source_version} to {target_version} for the provided message type is currently not implemented')


    else:
        raise ValueError(f'Version conversion from {source_version} to {target_version} is currently not implemented')
