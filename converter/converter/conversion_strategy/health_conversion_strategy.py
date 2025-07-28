
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.create_case_health.create_case_health_update_converter import CreateHealthUpdateCaseConverter
from converter.versions.error_converter import ErrorConverter
from converter.versions.reference_converter import ReferenceConverter
from converter.versions.create_case_health.create_case_health_converter import CreateHealthCaseConverter
from converter.versions.resources_info.resources_info_converter import ResourcesInfoConverter
from converter.versions.resources_request.resources_request_converter import ResourcesRequestConverter
from converter.versions.resources_response.resources_response_converter import ResourcesResponseConverter
from converter.versions.resources_status.resources_status_converter import ResourcesStatusConverter

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
    elif 'resourcesStatus' in message_content:
        return ResourcesStatusConverter.convert(source_version, target_version, edxl_json)
    elif 'resourcesInfo' in message_content:
        return ResourcesInfoConverter.convert(source_version, target_version, edxl_json)
    elif 'resourcesResponse' in message_content:
        return ResourcesResponseConverter.convert(source_version, target_version, edxl_json)
    elif 'resourcesRequest' in message_content:
        return ResourcesRequestConverter.convert(source_version, target_version, edxl_json)
    else:
        deducted_message_type = extract_message_type_from_message_content(message_content)
        raise ValueError(f"Version conversion from {source_version} to {target_version} for message type '{deducted_message_type}' is currently not implemented.")

unwanted_keys = ["messageId", "sender", "sentAt", "kind", "status", "recipient"]

def extract_message_type_from_message_content(message_content):
    filtered_keys = list(filter(lambda key: key not in unwanted_keys, message_content.keys()))
    if len(filtered_keys) == 0:
        return "unknownMessageType"
    return filtered_keys[0]
