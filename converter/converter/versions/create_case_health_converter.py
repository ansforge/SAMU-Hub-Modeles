from typing import Dict, Any, List
import copy

from converter.utils import add_to_medical_notes, delete_paths, get_field_value, is_field_completed, map_to_new_value
from converter.versions.base_message_converter import BaseMessageConverter
from converter.versions.v1_v2.constants import V1V2Constants
from converter.versions.v1_v2.utils import reverse_map_to_new_value, switch_field_name, validate_diagnosis_code
from converter.versions.v2_v3.constants import V2V3Constants


class CreateHealthCaseConverter(BaseMessageConverter):
    @staticmethod
    def get_message_type() -> str:
        return "createCaseHealth"

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
    def convert_v1_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(output_use_case_json,'$.qualification.whatsHappen.code', V1V2Constants.V1_TO_V2_WHATS_HAPPEN_CODE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution',V1V2Constants.DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.type',V1V2Constants.CALLER_TYPE_MAPPING)
        map_to_new_value(output_use_case_json, '$.initialAlert.caller.language', V1V2Constants.V1_TO_V2_LANGUAGE)

        patients = get_field_value(output_use_case_json,'$.patient')
        if patients != None:
            for index, patient in enumerate(patients):
                map_to_new_value(output_use_case_json, f"$.patient[{index}].identity.strictFeatures.sex", V1V2Constants.GENDER_MAPPING)
                switch_field_name(patient,'idPat','patientId')
                validate_diagnosis_code(output_use_case_json,patient,"otherDiagnosis")
                validate_diagnosis_code(output_use_case_json, patient,"mainDiagnosis")

        if is_field_completed(output_use_case_json,'$.location.geometry.obsDatime'):
            switch_field_name(output_use_case_json['location']['geometry'],'obsDatime','datetime')

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions != None:
            for index, decision in enumerate(decisions):
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", V1V2Constants.DECISION_RESOURCE_TYPE_MAPPING)
                switch_field_name(decision,'idPat','patientId')

        medical_notes = get_field_value(output_use_case_json, '$.medicalNote')
        if medical_notes != None:
            for note in medical_notes:
                switch_field_name(note,'idPat','patientId')
                switch_field_name(note,'idObs','medicalNoteId')

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, V1V2Constants.V1_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v1(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def update_language(json_data:Dict[str, Any]):
            language = get_field_value(json_data, '$.initialAlert.caller.language')
            if language in V1V2Constants.V1_TO_V2_LANGUAGE:
                map_to_new_value(json_data, '$.initialAlert.caller.language', V1V2Constants.V2_TO_V1_LANGUAGE)
            else:
                delete_paths(json_data, ['initialAlert.caller.language'])

        def update_practitioner_contact(json_data:Dict[str, Any], patient_index:int):
            practitioner_contact_type = get_field_value(json_data,f'$.patient[{patient_index}].administrativeFile.generalPractitioner.contact')
            if practitioner_contact_type != None:
                for contact in practitioner_contact_type:
                    map_to_new_value(contact, f"$.type", V1V2Constants.V2_TO_V1_CALLER_CONTACT_TYPE)
                json_data['patient'][patient_index]['administrativeFile']['generalPractitioner']['contact']=practitioner_contact_type

        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        map_to_new_value(output_use_case_json,'$.qualification.whatsHappen.code', V1V2Constants.V2_TO_V1_WHATS_HAPPEN_CODE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution',V1V2Constants.V2_TO_V1_DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.type',V1V2Constants.V2_TO_V1_CALLER_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.type',V1V2Constants.V2_TO_V1_CALLER_CONTACT_TYPE)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.type',V1V2Constants.V2_TO_V1_CALLER_CONTACT_TYPE)
        update_language(output_use_case_json)

        patients = get_field_value(output_use_case_json,'$.patient')
        if patients != None:
            for index, patient in enumerate(patients):
                update_practitioner_contact(output_use_case_json, index)
                reverse_map_to_new_value(output_use_case_json, f"$.patient[{index}].identity.strictFeatures.sex", V1V2Constants.GENDER_MAPPING)
                switch_field_name(patient,'patientId','idPat')
                add_to_medical_notes(output_use_case_json, patient, V1V2Constants.V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES)

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions != None:
            for index, decision in enumerate(decisions):
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", V1V2Constants.V2_TO_V1_DECISION_RESOURCE_TYPE_MAPPING)
                switch_field_name(decision,'patientId','idPat')

        medical_notes = get_field_value(output_use_case_json, '$.medicalNote')
        if medical_notes != None:
            for note in medical_notes:
                switch_field_name(note,'patientId','idPat')
                switch_field_name(note,'medicalNoteId','idObs')

        if is_field_completed(output_use_case_json,'$.location.geometry.datetime'):
            switch_field_name(output_use_case_json['location']['geometry'],'datetime','obsDatime')

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, V1V2Constants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v2_to_v3(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message'][cls.get_message_type()]
        output_use_case_json = copy.deepcopy(input_use_case_json)

        map_to_new_value(output_use_case_json,'$.interventionType', V2V3Constants.V2_TO_V3_INTERVENTION_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.origin', V2V3Constants.V2_TO_V3_QUALIFICATION_ORIGIN_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.status', V2V3Constants.V2_TO_V3_QUALIFICATION_DETAILS_STATUS_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.channel', V2V3Constants.V2_TO_V3_CALLER_CONTACT_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.channel', V2V3Constants.V2_TO_V3_CALLER_CONTACT_MAPPING)

        patients = get_field_value(output_use_case_json,'$.patient')
        if patients != None:
            for patient in patients:
                add_to_medical_notes(output_use_case_json, patient, V2V3Constants.V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES)

                if(is_field_completed(patient,'$.administrativeFile.externalId')):
                    external_ids = get_field_value(patient,'$.administrativeFile.externalId')
                    external_valid_ids = []
                    SI_VIC_EXTERNAL_ID = "SI-VIC"
                    for index, external_id in enumerate(external_ids):
                            if(get_field_value(external_id,'$.source') == SI_VIC_EXTERNAL_ID):
                                add_to_medical_notes(output_use_case_json, patient, [{ "path": f"administrativeFile.externalId[{index}]", "label":'Identifiant(s) patient(s) : '}])
                            else :
                                external_valid_ids.append(external_id)
                    patient["administrativeFile"]["externalId"]=external_valid_ids

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions is not None:
            for index, _ in enumerate(decisions):
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", V2V3Constants.V2_TO_V3_DECISION_RESOURCE_TYPE_MAPPING)

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, V2V3Constants.V2_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def update_qualification_origin():
            current_origin = get_field_value(output_use_case_json, "$.qualification.origin")
            if(V2V3Constants.V3_TO_V2_QUALIFICATION_ORIGIN_MAPPING.get(current_origin, current_origin) == None):
                add_to_medical_notes(output_use_case_json, None, [{ "path": f"qualification.origin", "label":'Origine de l`appel : '}])
                delete_paths(output_use_case_json, ["qualification.origin"])
            map_to_new_value(output_use_case_json,'$.qualification.origin', V2V3Constants.V3_TO_V2_QUALIFICATION_ORIGIN_MAPPING)

        def validate_admin_file_external_ids(patient):
            if(is_field_completed(patient,'$.administrativeFile.externalId')):
                external_ids = get_field_value(patient,'$.administrativeFile.externalId')
                external_valid_ids = []
                OTHER_FILE_SOURCE = "AUTRE"
                for index, external_id in enumerate(external_ids):
                    if(get_field_value(external_id,'$.source') == OTHER_FILE_SOURCE):
                        add_to_medical_notes(output_use_case_json, patient, [{ "path": f"administrativeFile.externalId[{index}]", "label":'Type de l`identifiant fourni : '}])
                    else :
                        external_valid_ids.append(external_id)
                patient["administrativeFile"]["externalId"]=external_valid_ids

        def check_qualification_code(path, valid_codes: List[str], default_code_and_label):
            CODE_SEPARATOR = '.'
            ROOT_CODE_DIGITS = '00'
            code_and_label = get_field_value(output_use_case_json, path)
            if(code_and_label == None):
                return

            code = code_and_label["code"]
            if(code in valid_codes):
                return

            code_parts = code.split(CODE_SEPARATOR) # -> ["C11", "06", "01"]
            code_parts[-1] = ROOT_CODE_DIGITS # -> ["C11", "06", "00"]
            root_code = CODE_SEPARATOR.join(code_parts) # -> "C11.06.00"

            if (root_code in valid_codes):
                code_and_label["code"] = root_code
                return

            add_to_medical_notes(output_use_case_json, None, [{ "path": f"{path}.label", "label":'Identifiant(s) patient(s) : '}])
            code_and_label["code"] = default_code_and_label["code"]
            code_and_label["label"] = default_code_and_label["label"]
            return

        output_json = cls.copy_input_content(input_json)
        output_use_case_json = cls.copy_input_use_case_content(input_json)

        update_qualification_origin()
        map_to_new_value(output_use_case_json,'$.interventionType', V2V3Constants.V3_TO_V2_INTERVENTION_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.status', V2V3Constants.V3_TO_V2_QUALIFICATION_DETAILS_STATUS_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution', V2V3Constants.V3_TO_V2_DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.decision.orientationType', V2V3Constants.V3_TO_V2_ORIENTATION_TYPE)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.channel', V2V3Constants.V3_TO_V2_CALLER_CONTACT_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.channel', V2V3Constants.V3_TO_V2_CALLER_CONTACT_MAPPING)

        risk_threat_code = get_field_value(output_use_case_json,'$.qualification.riskThreat.code')
        if(risk_threat_code not in V2V3Constants.V2_RISK_THREAT_CODE):
            add_to_medical_notes(output_use_case_json, None, [f"qualification.riskThreat.label"])
            delete_paths(output_use_case_json, ["qualification.riskThreat"])

        check_qualification_code('$.qualification.whatsHappen', V2V3Constants.V2_WHATS_HAPPEN_CODE, V2V3Constants.WHATS_HAPPEN_DEFAULT)
        check_qualification_code('$.qualification.locationKind', V2V3Constants.V2_LOCATION_KIND_CODE, V2V3Constants.LOCATION_KIND_DEFAULT)
        check_qualification_code('$.qualification.healthMotive', V2V3Constants.V2_HEALTH_MOTIVE_CODE, V2V3Constants.HEALTH_MOTIVE_DEFAULT)

        patients = get_field_value(output_use_case_json,'$.patient')
        if (patients != None):
            for patient in patients:
                validate_admin_file_external_ids(patient)

        medical_notes = get_field_value(output_use_case_json,'$.medicalNote')
        if medical_notes != None:
             for note in medical_notes:
                  map_to_new_value(note,'$.operator.role', V2V3Constants.V3_TO_V2_OPERATOR_ROLE_MAPPING)

        decisions = get_field_value(output_use_case_json,'$.decision')
        if decisions != None:
             for index, decision in enumerate(decisions):
                map_to_new_value(decision,'$.orientationType', V2V3Constants.V3_TO_V2_ORIENTATION_TYPE)
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", V2V3Constants.V3_TO_V2_DECISION_RESOURCE_TYPE_MAPPING)
                add_to_medical_notes(output_use_case_json, None, [{ "path": f"decision[{index}].destination", "label":'Destination : '}])

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, V2V3Constants.V3_PATHS_TO_DELETE)

        return cls.format_output_json(output_json, output_use_case_json)
