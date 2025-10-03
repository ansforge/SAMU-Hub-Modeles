from typing import Dict, Any

from converter.utils import delete_paths, get_field_value, map_to_new_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.conversion_mixin import ConversionMixin
from converter.versions.resources_info.resources_info_constants import (
    ResourcesInfoConstants,
)
from converter.versions.utils import reverse_map_to_new_value


class ResourcesInfoConverter(BaseMessageConverter, ConversionMixin):
    @staticmethod
    def get_message_type():
        return "resourcesInfo"

    @classmethod
    def convert_v1_to_v2(cls, input_json) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        mobilizedResources = get_field_value(
            output_use_case_json, "$.mobilizedResource"
        )
        if mobilizedResources is not None:
            for index, mobilizedResource in enumerate(mobilizedResources):
                states = get_field_value(mobilizedResource, "$.state")
                if states is not None:
                    for state in states:
                        map_to_new_value(
                            state,
                            "$.status",
                            ResourcesInfoConstants.V1_TO_V2_STATUS_MAPPING,
                        )

                plate = get_field_value(mobilizedResource, "$.plate")
                if plate is not None:
                    freetext = mobilizedResource.get("freetext", [])
                    freetext.append("Immatriculation : " + plate)
                    output_use_case_json["mobilizedResource"][index]["freetext"] = (
                        freetext
                    )

                map_to_new_value(
                    mobilizedResource,
                    "$.vehiculeType",
                    ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING,
                )
                vehiculeType = get_field_value(mobilizedResource, "$.vehiculeType")
                if vehiculeType is not None:
                    mobilizedResource["vehicleType"] = vehiculeType

                teamCare = get_field_value(mobilizedResource, "$.team.teamCare")
                if teamCare is not None:
                    mobilizedResource["team"]["medicalLevel"] = teamCare

        output_use_case_json["resource"] = mobilizedResources

        delete_paths(output_use_case_json, ResourcesInfoConstants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        other_value = "AUTRE"

        resources = get_field_value(output_use_case_json, "$.resource")
        if resources is not None:
            for resource in resources:
                states = get_field_value(resource, "$.state")
                if states is not None:
                    for state in states:
                        reverse_map_to_new_value(
                            state,
                            "$.status",
                            ResourcesInfoConstants.V1_TO_V2_STATUS_MAPPING,
                        )

                reverse_map_to_new_value(
                    resource,
                    "$.vehicleType",
                    ResourcesInfoConstants.V1_TO_V2_VEHICULE_TYPE_MAPPING,
                )
                vehicleType = get_field_value(resource, "$.vehicleType")
                if vehicleType is not None:
                    resource["vehiculeType"] = vehicleType

                medicalLevel = get_field_value(resource, "$.team.medicalLevel")
                if medicalLevel is not None:
                    resource["team"]["teamCare"] = medicalLevel

                resource["resourceType"] = other_value

        output_use_case_json["mobilizedResource"] = resources

        delete_paths(output_use_case_json, ResourcesInfoConstants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def map_state_status(
        cls, output_use_case_json: Dict[str, Any], reverse_mapping: bool
    ):
        resources = get_field_value(output_use_case_json, "$.resource")
        if resources is not None:
            for resource in resources:
                states = get_field_value(resource, "$.state")
                if states is not None:
                    for state in states:
                        if reverse_mapping:
                            reverse_map_to_new_value(
                                state,
                                "$.status",
                                ResourcesInfoConstants.V3_TO_V2_STATUS_MAPPING,
                            )
                        else:
                            map_to_new_value(
                                state,
                                "$.status",
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

        resources = get_field_value(output_use_case_json, "$.resource")
        if resources is not None:
            for index, resource in enumerate(resources):
                patient_id = get_field_value(resource, "$.patientId")
                if patient_id is not None:
                    freetext = resource.get("freetext", [])
                    freetext.append("Patient ID : " + patient_id)
                    output_use_case_json["resource"][index]["freetext"] = freetext

        delete_paths(output_use_case_json, ResourcesInfoConstants.V3_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)
