from typing import Dict, Any
import copy

from converter.v1_v2.base_message_converter import BaseMessageConverter

from ..utils import add_to_medical_notes, delete_paths, get_field_value, is_field_completed, map_to_new_value

class CreateHealthCaseConverter(BaseMessageConverter):
    def __init__(self):
        BaseMessageConverter.__init__(self, "createCaseHealth")

    V3_TO_V2_INTERVENTION_TYPE_MAPPING = {
        "T1":"PRIMAIRE",
        "T2-INTER":"SECONDAIRE",
        "T2-INTRA":"SECONDAIRE",
        "T3":"RETOUR A DOMICILE",
        "T4":"SECONDAIRE",
    }

    V2_TO_V3_INTERVENTION_TYPE_MAPPING = {
        "PRIMAIRE":"T1",
        "SECONDAIRE":"T2-INTER",
        "RETOUR A DOMICILE":"T3"
    }

    V2_TO_V3_QUALIFICATION_ORIGIN_MAPPING = {
        "15":"15",
        "116117":"116117",
        "112":"112",
        "18":"CTA-CONF",
        "17":"FDO"
    }

    V3_TO_V2_QUALIFICATION_ORIGIN_MAPPING = {
        "15":"15",
        "116117":"116117",
        "AUTOCOM":None,
        "112":"112",
        "115":None,
        "CRRA":None,
        "AUTREC15":None,
        "CTA-CONF":"18",
        "CTA-PI":None,
        "AUTRECTA":None,
        "CNR":None,
        "FDO":"17",
        "SNATED":None,
        "PDSSOS":None,
        "TELASSIST":None,
        "CROSS":None,
        "PUBLIC":None,
        "DATA":None,
        "AUTRE":None,
    }

    V3_TO_V2_QUALIFICATION_DETAILS_STATUS_MAPPING = {
        "PROGRAM":"PROGRAMME",
        "ACTIF": " ACTIF",
        "ACHEVE":"ACHEVE",
        "VALIDE":"VALIDE",
        "CLOTURE":"CLOTURE",
        "CLASSE":"CLASSE",
        "ARCHIVE":"ARCHIVE",
    }

    V2_TO_V3_QUALIFICATION_DETAILS_STATUS_MAPPING = {
        "PROGRAMME":"PROGRAM",
        " ACTIF":"ACTIF",
        "ACHEVE":"ACHEVE",
        "VALIDE":"VALIDE",
        "CLOTURE":"CLOTURE",
        "CLASSE":"CLASSE",
        "ARCHIVE":"ARCHIVE",
    }

    V2_TO_V3_CALLER_CONTACT_MAPPING = {
        "DEFIBRILLATEUR,":"DEFIBRILLATEUR",
    }
    V3_TO_V2_CALLER_CONTACT_MAPPING = {
        "DEFIBRILLATEUR":"DEFIBRILLATEUR,",
    }

    V3_TO_V2_ORIENTATION_TYPE = {
        "REA-USI":"AUTRE",
    }

    V3_TO_V2_OPERATOR_ROLE_MAPPING ={
        "PILOTE":"INCONNU",
        "TCM":"INCONNU"
    }

    V3_TO_V2_DETAIL_ATTRIBUTION_MAPPING ={
        "DRM.SPE.AUTRESPE":"DRM.SPE"
    }

    V2_PATHS_TO_DELETE = [
        "patient[].healthMotive",
        "patient[].administrativeFile.externalId.source",
        "patient[].administrativeFile.externalId.value",
    ]

    V3_PATHS_TO_DELETE = [
        "decision[].destination",
    ]

    V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES = [
        'healthMotive',
    ]

    @classmethod
    def convert_v2_to_v3(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        output_use_case_json = copy.deepcopy(input_use_case_json)

        map_to_new_value(output_use_case_json,'$.interventionType', cls.V2_TO_V3_INTERVENTION_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.origin', cls.V2_TO_V3_QUALIFICATION_ORIGIN_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.status', cls.V2_TO_V3_QUALIFICATION_DETAILS_STATUS_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.channel', cls.V2_TO_V3_CALLER_CONTACT_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.channel', cls.V2_TO_V3_CALLER_CONTACT_MAPPING)

        patients = get_field_value(output_use_case_json,'$.patient')
        for patient in patients:
            add_to_medical_notes(output_use_case_json, patient, cls.V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES)

            if(is_field_completed(patient,'$.administrativeFile.externalId')):
                external_ids = get_field_value(patient,'$.administrativeFile.externalId')
                external_valid_ids = []
                for index, external_id in enumerate(external_ids):
                        if(get_field_value(external_id,'$.source')=="SI-VIC"):
                            add_to_medical_notes(output_use_case_json, patient, [f"administrativeFile.externalId[{index}]"])
                        else :
                            external_valid_ids.append(external_id)
                patient["administrativeFile"]["externalId"]=external_valid_ids

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, cls.V2_PATHS_TO_DELETE)

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_use_case_json
        return output_json


    @classmethod
    def convert_v3_to_v2(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def update_qualification_origin():
            current_origin = get_field_value(output_use_case_json, "$.qualification.origin")
            if(cls.V3_TO_V2_QUALIFICATION_ORIGIN_MAPPING.get(current_origin, current_origin) == None):
                add_to_medical_notes(output_use_case_json, None, [f"qualification.origin"])
                delete_paths(output_use_case_json, ["qualification.origin"])
            map_to_new_value(output_use_case_json,'$.qualification.origin', cls.V3_TO_V2_QUALIFICATION_ORIGIN_MAPPING)

        def validate_admin_file_external_ids(patient):
            if(is_field_completed(patient,'$.administrativeFile.externalId')):
                external_ids = get_field_value(patient,'$.administrativeFile.externalId')
                external_valid_ids = []
                for index, external_id in enumerate(external_ids):
                        if(get_field_value(external_id,'$.source')=="AUTRE"):
                            add_to_medical_notes(output_use_case_json, patient, [f"administrativeFile.externalId[{index}]"])
                        else :
                            external_valid_ids.append(external_id)
                patient["administrativeFile"]["externalId"]=external_valid_ids

        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        output_use_case_json = copy.deepcopy(input_use_case_json)

        update_qualification_origin()
        map_to_new_value(output_use_case_json,'$.interventionType', cls.V3_TO_V2_INTERVENTION_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.status', cls.V3_TO_V2_QUALIFICATION_DETAILS_STATUS_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution', cls.V3_TO_V2_DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.decision.orientationType', cls.V3_TO_V2_ORIENTATION_TYPE)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.channel', cls.V3_TO_V2_CALLER_CONTACT_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.channel', cls.V3_TO_V2_CALLER_CONTACT_MAPPING)

        patients = get_field_value(output_use_case_json,'$.patient')
        for patient in patients:
            validate_admin_file_external_ids(patient)

        medical_notes = get_field_value(output_use_case_json,'$.medicalNote')
        if medical_notes != None:
             for note in medical_notes:
                  map_to_new_value(note,'$.operator.role', cls.V3_TO_V2_OPERATOR_ROLE_MAPPING)

        decisions = get_field_value(output_use_case_json,'$.decision')
        if decisions != None:
             for index, decision in enumerate(decisions):
                  map_to_new_value(decision,'$.orientationType', cls.V3_TO_V2_ORIENTATION_TYPE)
                  add_to_medical_notes(output_use_case_json, None, [f"decision[{index}].destination"])

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, cls.V3_PATHS_TO_DELETE)

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_use_case_json
        return output_json
