from typing import Dict, Any
import copy
import re


from .utils import delete_paths, get_field_value, is_field_completed, update_json_value

class V1_V2Converter:
    DIAGNOSIS_CODE_VALIDATION_REGEX='^[A-Z]\\d{2}(\\.[\\d\\+\\-]{1,3})?$'

    V1_PATHS_TO_DELETE = [
        "patient[].idPat",
        "decision[].idPat",
        "medicalNote[].idObs",
        "medicalNote[].idPat",
        "location.geometry.obsDatime",
        "decision[].vehiculeType"
    ]

    GENDER_MAPPING = {
        "MASC": "M",
        "FEM": "F",
        "AUTRE": "O",
        "INCONNU": "UN"
    }

    V1_TO_V2_WHATS_HAPPEN_CODE_MAPPING = {
        "C02.15.00": "C02.16.00",
        "C02.15.01": "C02.16.01",
        "C02.15.02": "C02.16.02",
        "C02.15.03": "C02.16.03"
    }

    DETAIL_ATTRIBUTION_MAPPING ={
        "DRM":"DRM",
        "DRMMRU":"DRM.MRU",
        "MU":"DRM.MRU.MU",
        "DENT":"DRM.SPE.DENT",
        "GERIA":"DRM.SPE.GERIA",
        "PEDIA":"DRM.SPE.PEDIA",
        "PSY":"DRM.SPE.PSY",
        "TOXICOL":"DRM.SPE.TOXICOL",
        "INDISPMU:":"DRM.MRU.INDISPMU",
        "SSE":"DRM.MRU.SSE",
        "PLANBLAN":"DRM.MRU.PLANBLAN",
        "PCSAMU:":"DRM.MRU.PCSAMU",
        "DRMMRL":"DRM.MRL",
        "MG":"DRM.MRL.MG",
        "INDISPMG":"DRM.MRL.INDISPMG",
        "ABSML":"DRM.MRL.ABSML",
        "DR":"DR",
        "DREG":"DR.DREG",
        "DRARM":"DR.DREG.DRARM",
        "DRMED":"DR.DREG.DRMED",
        "DRPHARMA":"DR.DREG.DRPHARMA",
        "DRDENT":"DR.DREG.DRDENT",
        "DRINFO":"DR.DREG.DRINFO",
        "DOS-SIS":"DR.DREG.DOS-SIS",
        "DOS-FDO":"DR.DREG.DOS-FDO",
        "D":"D",
        "D-MALV":"D.D-MALV",
        "ERR":"D.D-MALV.ERR",
        "NRP":"D.D-MALV.NRP",
        "MALV":"D.D-MALV.MALV",
        "FAX":"D.D-MALV.FAX",
        "ITERATIF":"D.D-MALV.ITERATIF",
        "D-IDENT":"D.D-IDENT",
        "ADMIN":"D.D-IDENT.ADMIN",
        "PERSO":"D.D-IDENT.PERSO",
        "AUTRE":"D.D-IDENT.AUTRE",
    }

    CALLER_TYPE_MAPPING = {
        "MEDSOS":"MED.MEDSOS",
        "MRL":"MED.MRL",
        "EFFML":"MED.EFFML",
        "INF":"SANTE.INF",
        "AIDESOIN":"SANTE.AIDESOIN",
        "SF":"SANTE.SF",
        "AIDEDOM":"SANTE.AIDEDOM",
    }

    DECISION_RESOURCE_TYPE_MAPPING = {
        "LIB":"LIBERAL",
    }

    V1_TO_V2_LANGUAGE = {
        "FR":"fr",
        "AU":"en",
        "CA":"en",
        "GB":"en",
        "US":"en",
        "DE":"de",
        "IT":"it",
        "ES":"es",
    }


    @staticmethod
    def map_to_new_value(json_data: Dict[str,Any], json_path: str, mapping_value : Dict[str,str]):
        current_value = get_field_value(json_data, json_path)

        if current_value != None:
            new_value = mapping_value.get(current_value, current_value)

            if new_value != current_value:
                update_json_value(json_data, json_path, new_value)

    @staticmethod
    def switch_field_name(json_data: Dict[str, Any], previous_field_name: str, new_field_name: str):
        if is_field_completed(json_data, '$.'+ previous_field_name):
                json_data[new_field_name] = json_data[previous_field_name]

    @classmethod
    def upgrade(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def validate_diagnosis_code(json_data:Dict[str, Any],diagnosis_type:str):
            code = get_field_value(json_data, f"$.hypothesis.{diagnosis_type}.code")
            if code != None:
                pattern = re.compile(cls.DIAGNOSIS_CODE_VALIDATION_REGEX)
                correct_format = pattern.match(code)

                if not correct_format:
                    delete_paths(json_data, [f"hypothesis.{diagnosis_type}"])


        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        output_use_case_json = copy.deepcopy(input_use_case_json)

        cls.map_to_new_value(output_use_case_json,'$.qualification.whatsHappen.code', cls.V1_TO_V2_WHATS_HAPPEN_CODE_MAPPING)
        cls.map_to_new_value(output_use_case_json,'$.qualification.details.attribution',cls.DETAIL_ATTRIBUTION_MAPPING)
        cls.map_to_new_value(output_use_case_json,'$.initialAlert.caller.type',cls.CALLER_TYPE_MAPPING)
        cls.map_to_new_value(output_use_case_json, '$.initialAlert.caller.language', cls.V1_TO_V2_LANGUAGE)

        patients = get_field_value(output_use_case_json,'$.patient')
        for index, patient in enumerate(patients):
            cls.map_to_new_value(output_use_case_json, f"$.patient[{index}].identity.strictFeatures.sex", cls.GENDER_MAPPING)
            validate_diagnosis_code(patient,"otherDiagnosis")
            validate_diagnosis_code(patient,"mainDiagnosis")
            cls.switch_field_name(patient,'idPat','patientId')

        if is_field_completed(output_use_case_json,'$.location.geometry.obsDatime'):
            cls.switch_field_name(output_use_case_json['location']['geometry'],'obsDatime','datetime')

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions != None:
            for index, decision in enumerate(decisions):
                cls.map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", cls.DECISION_RESOURCE_TYPE_MAPPING)
                cls.switch_field_name(decision,'idPat','patientId')

        medical_notes = get_field_value(output_use_case_json, '$.medicalNote')
        if medical_notes != None:
            for note in medical_notes:
                cls.switch_field_name(note,'idPat','patientId')
                cls.switch_field_name(note,'idObs','medicalNoteId')

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, cls.V1_PATHS_TO_DELETE)

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_use_case_json
        return output_json
