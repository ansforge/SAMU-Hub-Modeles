
from converter.versions.create_case_health_update_converter import CreateHealthUpdateCaseConverter
from converter.versions.reference_converter import ReferenceConverter
from converter.versions.create_case_health_converter import CreateHealthCaseConverter
from converter.versions.error_converter import ErrorConverter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")

    message_content = edxl_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})
    if 'createCaseHealth' in message_content:
        return CreateHealthCaseConverter.convert(source_version, target_version, edxl_json)
    elif 'createCaseHealthUpdate' in message_content:
        return CreateHealthUpdateCaseConverter.convert(source_version, target_version, edxl_json)
    elif 'reference' in message_content:
        return ReferenceConverter.convert(source_version, target_version, edxl_json)
    elif 'error' in message_content:
        return ErrorConverter.convert(source_version, target_version, edxl_json)
    else:
        deducted_message_type = extract_message_type_from_message_content(message_content)
        raise ValueError(f"Version conversion from {source_version} to {target_version} for message type '{deducted_message_type}' is currently not implemented.")

unwanted_keys = ["messageId", "sender", "sentAt", "kind", "status", "recipient"]

def extract_message_type_from_message_content(message_content):
    filtered_keys = list(filter(lambda key: key not in unwanted_keys, message_content.keys()))
    if len(filtered_keys) == 0:
        return "unknownMessageType"
    return filtered_keys[0]
