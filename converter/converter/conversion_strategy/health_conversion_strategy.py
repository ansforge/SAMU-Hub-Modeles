
from converter.v1_v2.base_message_converter import BaseMessageConverter
from converter.v1_v2.create_case_health_converter import CreateHealthCaseConverter
from converter.v1_v2.reference_converter import ReferenceConverter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")

    message_content = edxl_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})
    if 'createCaseHealth' in message_content:
        return CreateHealthCaseConverter().convert(source_version, target_version, edxl_json)
    elif 'reference' in message_content:
        return ReferenceConverter().convert(source_version, target_version, edxl_json)
    else:
        deducted_message_type = extract_message_type_from_message_content(message_content)
        BaseMessageConverter(deducted_message_type).raise_conversion_not_implemented_error(source_version, target_version)

unwanted_keys = ["messageId", "sender", "sentAt", "kind", "status", "recipient"]

def extract_message_type_from_message_content(message_content):
    filtered_keys = list(filter(lambda key: key not in unwanted_keys, message_content.keys()))
    if len(filtered_keys) == 0:
        return "unknownMessageType"
    return filtered_keys[0]