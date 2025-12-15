from typing import Dict, Any

from converter.utils import delete_paths, get_field_value, map_to_new_value, set_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.resources_info.resources_info_constants import (
    ResourcesInfoConstants,
)
from converter.versions.utils import reverse_map_to_new_value


class ResourcesInfoConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type():
        return "resourcesInfo"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        mobilized_resources = get_field_value(
            output_use_case_json, ResourcesInfoConstants.MOBILIZED_RESOURCE_PATH
        )
        if mobilized_resources is not None:
            for mobilizedResource in mobilized_resources:
                states = get_field_value(
                    mobilizedResource, ResourcesInfoConstants.RESOURCE_STATE_PATH
                )
                if states is not None:
                    for state in states:
                        map_to_new_value(
                            state,
                            ResourcesInfoConstants.RESOURCE_STATE_STATUS_PATH,
                            ResourcesInfoConstants.V1_TO_V2_STATUS_MAPPING,
                        )

                plate = get_field_value(
                    mobilizedResource,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_PLATE_PATH,
                )
                if plate is not None:
                    freetext = (
                        get_field_value(
                            mobilizedResource,
                            ResourcesInfoConstants.RESOURCE_FREETEXT_PATH,
                        )
                        or []
                    )
                    freetext.append("Immatriculation : " + plate)
                    set_value(
                        mobilizedResource,
                        ResourcesInfoConstants.RESOURCE_FREETEXT_PATH,
                        freetext,
                    )

                map_to_new_value(
                    mobilizedResource,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_VEHICULE_TYPE_PATH,
                    ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING,
                )
                vehicule_type = get_field_value(
                    mobilizedResource,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_VEHICULE_TYPE_PATH,
                )
                if vehicule_type is not None:
                    set_value(
                        mobilizedResource,
                        ResourcesInfoConstants.RESOURCE_VEHICLE_TYPE_PATH,
                        vehicule_type,
                    )

                team_care = get_field_value(
                    mobilizedResource,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_TEAM_CARE_PATH,
                )
                if team_care is not None:
                    set_value(
                        mobilizedResource,
                        ResourcesInfoConstants.RESOURCE_TEAM_MEDICAL_LEVEL_PATH,
                        team_care,
                    )

        set_value(
            output_use_case_json,
            ResourcesInfoConstants.RESOURCE_PATH,
            mobilized_resources,
        )

        delete_paths(output_use_case_json, ResourcesInfoConstants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        resources = get_field_value(
            output_use_case_json, ResourcesInfoConstants.RESOURCE_PATH
        )
        if resources is not None:
            for resource in resources:
                states = get_field_value(
                    resource, ResourcesInfoConstants.RESOURCE_STATE_PATH
                )
                if states is not None:
                    for state in states:
                        reverse_map_to_new_value(
                            state,
                            ResourcesInfoConstants.RESOURCE_STATE_STATUS_PATH,
                            ResourcesInfoConstants.V1_TO_V2_STATUS_MAPPING,
                        )

                reverse_map_to_new_value(
                    resource,
                    ResourcesInfoConstants.RESOURCE_VEHICLE_TYPE_PATH,
                    ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING,
                )
                vehicle_type = get_field_value(
                    resource, ResourcesInfoConstants.RESOURCE_VEHICLE_TYPE_PATH
                )
                if vehicle_type is not None:
                    set_value(
                        resource,
                        ResourcesInfoConstants.MOBILIZED_RESOURCE_VEHICULE_TYPE_PATH,
                        vehicle_type,
                    )

                medical_level = get_field_value(
                    resource, ResourcesInfoConstants.RESOURCE_TEAM_MEDICAL_LEVEL_PATH
                )
                if medical_level is not None:
                    set_value(
                        resource,
                        ResourcesInfoConstants.MOBILIZED_RESOURCE_TEAM_CARE_PATH,
                        medical_level,
                    )

                set_value(
                    resource,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_RESOURCE_TYPE_PATH,
                    ResourcesInfoConstants.MOBILIZED_RESOURCE_DEFAULT_VALUE,
                )

        set_value(
            output_use_case_json,
            ResourcesInfoConstants.MOBILIZED_RESOURCE_PATH,
            resources,
        )

        delete_paths(output_use_case_json, ResourcesInfoConstants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def map_state_status(
        cls, output_use_case_json: Dict[str, Any], reverse_mapping: bool
    ):
        resources = get_field_value(
            output_use_case_json, ResourcesInfoConstants.RESOURCE_PATH
        )
        if resources is not None:
            for resource in resources:
                states = get_field_value(
                    resource, ResourcesInfoConstants.RESOURCE_STATE_PATH
                )
                if states is not None:
                    for state in states:
                        if reverse_mapping:
                            reverse_map_to_new_value(
                                state,
                                ResourcesInfoConstants.RESOURCE_STATE_STATUS_PATH,
                                ResourcesInfoConstants.V3_TO_V2_STATUS_MAPPING,
                            )
                        else:
                            map_to_new_value(
                                state,
                                ResourcesInfoConstants.RESOURCE_STATE_STATUS_PATH,
                                ResourcesInfoConstants.V3_TO_V2_STATUS_MAPPING,
                            )

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

        resources = get_field_value(
            output_use_case_json, ResourcesInfoConstants.RESOURCE_PATH
        )
        if resources is not None:
            for resource in resources:
                patient_id = get_field_value(
                    resource, ResourcesInfoConstants.RESOURCE_PATIENT_ID_PATH
                )
                if patient_id is not None:
                    freetext = (
                        get_field_value(
                            resource, ResourcesInfoConstants.RESOURCE_FREETEXT_PATH
                        )
                        or []
                    )
                    freetext.append("Patient ID : " + patient_id)
                    set_value(
                        resource,
                        ResourcesInfoConstants.RESOURCE_FREETEXT_PATH,
                        freetext,
                    )

        delete_paths(output_use_case_json, ResourcesInfoConstants.V3_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)
