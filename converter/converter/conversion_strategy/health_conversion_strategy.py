from converter.versions.create_case_health.create_case_health_update_converter import CreateHealthUpdateCaseConverter
from converter.versions.error_converter import ErrorConverter
from converter.versions.reference.reference_converter import ReferenceConverter
from converter.versions.create_case_health.create_case_health_converter import CreateHealthCaseConverter
from converter.versions.resources_engagement.resources_engagement import ResourcesEngagementConverter
from converter.versions.resources_info.resources_info_converter import ResourcesInfoConverter
from converter.versions.resources_request.resources_request_converter import ResourcesRequestConverter
from converter.versions.resources_response.resources_response_converter import ResourcesResponseConverter
from converter.versions.resources_status.resources_status_converter import ResourcesStatusConverter

def health_conversion_strategy(edxl_json, source_version: str, target_version: str):
    print(f"Health Conversion initiated from {source_version} to {target_version}")

    message_content = extract_message_content(edxl_json)
    selected_strategy = select_conversion_strategy(message_content)
    return selected_strategy.convert(source_version, target_version, edxl_json)

def extract_message_content(edxl_json):
    return edxl_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {})

def select_conversion_strategy(message_content):
    if 'createCaseHealth' in message_content:
        return CreateHealthCaseConverter
    elif 'createCaseHealthUpdate' in message_content:
        return CreateHealthUpdateCaseConverter
    elif 'reference' in message_content:
        return ReferenceConverter
    elif 'error' in message_content:
        return ErrorConverter
    elif 'resourcesStatus' in message_content:
        return ResourcesStatusConverter
    elif 'resourcesInfo' in message_content:
        return ResourcesInfoConverter
    elif 'resourcesResponse' in message_content:
        return ResourcesResponseConverter
    elif 'resourcesRequest' in message_content:
        return ResourcesRequestConverter
    elif 'resourcesEngagement' in message_content:
        return ResourcesEngagementConverter
    else:
        deducted_message_type = extract_message_type_from_message_content(message_content)
        raise ValueError(f"Version conversion for message type '{deducted_message_type}' is currently not implemented.")

unwanted_keys = ["messageId", "sender", "sentAt", "kind", "status", "recipient"]

def extract_message_type_from_message_content(message_content):
    filtered_keys = list(filter(lambda key: key not in unwanted_keys, message_content.keys()))
    if len(filtered_keys) == 0:
        return "unknownMessageType"
    return filtered_keys[0]
