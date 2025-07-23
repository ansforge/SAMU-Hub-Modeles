import copy
from typing import Dict, Any

from converter.utils import delete_paths, get_field_value, map_to_new_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.resources_info.resources_info_constants import ResourcesInfoConstants
from converter.versions.utils import reverse_map_to_new_value

class ResourcesInfoConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesInfo"

    @classmethod
    def copy_input_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if cls.get_message_type() not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError(f"Input JSON must contain {cls.get_message_type()} key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()]
        return output_json

    @classmethod
    def copy_input_use_case_content(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()]
        return copy.deepcopy(input_use_case_json)

    @classmethod
    def format_output_json(cls, output_json: Dict[str, Any], output_use_case_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()] = output_use_case_json
        return output_json

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        mobilizedResources = get_field_value(output_use_case_json, '$.mobilizedResource')
        if mobilizedResources is not None:
            for mobilizedResource in mobilizedResources:
                map_to_new_value(mobilizedResource, '$.vehiculeType', ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING)
                vehiculeType = get_field_value(mobilizedResource, '$.vehiculeType')
                if vehiculeType is not None:
                    mobilizedResource['vehicleType'] = vehiculeType

                teamCare = get_field_value(mobilizedResource, '$.team.teamCare')
                if teamCare is not None:
                    mobilizedResource['team']['medicalLevel'] = teamCare

        output_use_case_json['resource'] =  mobilizedResources

        delete_paths(output_use_case_json, ResourcesInfoConstants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        other_value = "AUTRE"

        resources = get_field_value(output_use_case_json, '$.resource')
        if resources is not None:
            for resource in resources:
                reverse_map_to_new_value(resource, '$.vehicleType', ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING)
                vehicleType = get_field_value(resource, '$.vehicleType')
                if vehicleType is not None:
                    resource['vehiculeType'] = vehicleType

                medicalLevel = get_field_value(resource, '$.team.medicalLevel')
                if medicalLevel is not None:
                    resource['team']['teamCare'] = medicalLevel

                resource['resourceType'] = other_value

        output_use_case_json['mobilizedResource'] = resources

        delete_paths(output_use_case_json, ResourcesInfoConstants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def map_state_status(cls, output_use_case_json: Dict[str, Any], reverse_mapping: bool):
        resources = get_field_value(output_use_case_json, '$.resource')
        if resources is not None:
            for resource in resources:
                states = get_field_value(resource, '$.state')
                if states is not None:
                    for state in states:
                        if reverse_mapping:
                            reverse_map_to_new_value(state, '$.status', ResourcesInfoConstants.V3_TO_V2_STATUS_MAPPING)
                        else:
                            map_to_new_value(state, '$.status', ResourcesInfoConstants.V3_TO_V2_STATUS_MAPPING)

    @classmethod
    def convert_v2_to_v3(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        cls.map_state_status(output_use_case_json, reverse_mapping=True)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        cls.map_state_status(output_use_case_json, reverse_mapping=False)

        return cls.format_output_json(output_json, output_use_case_json)
