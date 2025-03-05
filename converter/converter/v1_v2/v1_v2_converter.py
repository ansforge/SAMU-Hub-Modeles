from typing import Dict, Any
import copy
import re

from converter.v1_v2.utils import add_to_medical_notes, map_to_new_value, reverse_map_to_new_value, switch_field_name

from ..utils import delete_paths, get_field_value, is_field_completed

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

    V2_PATHS_TO_DELETE = [
        "patient[].patientId",
        "decision[].patientId",
        "medicalNote[].medicalNoteId",
        "medicalNote[].patientId",
        "location.geometry.datetime",
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

    V2_TO_V1_WHATS_HAPPEN_CODE_MAPPING = {
        "C02.15.00":"C02.14.00",
        "C02.15.01":"C02.14.01",
        "C02.15.02":"C02.14.02",
        "C02.15.03":"C02.14.03",
        "C02.15.04":"C02.14.04",
        "C02.15.05":"C02.14.05",
        "C02.15.06":"C02.14.06",
        "C02.16.00":"C02.15.00",
        "C02.16.01":"C02.15.01",
        "C02.16.02":"C02.15.02",
        "C02.16.03":"C02.15.03",
    }

    V2_TO_V1_DETAIL_ATTRIBUTION_MAPPING = {
        "DRM":"DRM",
        "DRM.MRU":"DRMMRU",
        "DRM.MRU.MU":"MU",
        "DRM.MRU.INDISPMU":"INDISPMU",
        "DRM.MRU.SSE":"SSE",
        "DRM.MRU.PLANBLAN":"PLANBLAN",
        "DRM.MRU.PCSAMU":"PCSAMU",
        "DRM.SPE":"DRM",
        "DRM.SPE.DENT":"DENT",
        "DRM.SPE.GERIA":"GERIA",
        "DRM.SPE.PEDIA":"PEDIA",
        "DRM.SPE.OBST":"DRM",
        "DRM.SPE.PSY":"PSY",
        "DRM.SPE.TOXICOL":"TOXICOL",
        "DRM.MRL":"DRMMRL",
        "DRM.MRL.MG":"MG",
        "DRM.MRL.INDISPMG":"INDISPMG",
        "DRM.MRL.ABSML":"ABSML",
        "DR":"DR",
        "DR.DREG":"DREG",
        "DR.DREG.DRARM":"DRARM",
        "DR.DREG.DRDAC":"DR",
        "DR.DREG.DRMED":"DRMED",
        "DR.DREG.DRPHARMA":"DRPHARMA",
        "DR.DREG.DRDENT":"DRDENT",
        "DR.DREG.DRINFO":"DRINFO",
        "DR.DREG.DOS-SIS":"DOS-SIS",
        "DR.DREG.DOS-FDO":"DOS-FDO",
        "D":"D",
        "D.D-MALV":"D-MALV",
        "D.D-MALV.ERR":"ERR",
        "D.D-MALV.NRP":"NRP",
        "D.D-MALV.MALV":"MALV",
        "D.D-MALV.FAX":"FAX",
        "D.D-MALV.ITERATIF":"ITERATIF",
        "D.D-IDENT":"D-IDENT",
        "D.D-IDENT.ADMIN":"ADMIN",
        "D.D-IDENT.PERSO":"PERSO",
        "D.D-IDENT.AUTRE":"AUTRE"
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

    V2_TO_V1_CALLER_TYPE_MAPPING = {
        "SUJET":"SUJET",
        "FAMILLE":"FAMILLE",
        "TIERS":"TIERS",
        "POMPIER":"POMPIER",
        "AMBULANC":"AMBULANC",
        "AMBULANC.AASC":"AMBULANC",
        "AMBULANC.AUTRESEC":"AMBULANC",
        "SECOUR":"SECOUR",
        "MED":"MED",
        "MED.MEDSOS":"MED.MEDSOS",
        "MED.MRL":"MED.MRL",
        "MED.EFFML":"MED.EFFML",
        "SANTE":"SANTE",
        "SANTE.INF":"SANTE.INF",
        "SANTE.AIDESOIN":"SANTE.AIDESOIN",
        "SANTE.SF":"SANTE.SF",
        "SANTE.AIDEDOM":"SANTE.AIDEDOM",
        "SANTE.PHARMA":"SANTE",
        "SANTE.DENTISTE":"SANTE",
        "SANTE.LABO":"SANTE",
        "FDO-MILI":"FDO-MILI",
        "FDO-MILI.POL":"FDO-MILI",
        "FDO-MILI.GENDARM":"FDO-MILI",
        "FDO-MILI.MILI":"FDO-MILI",
        "ADM-TUTL":"ADM-TUTL",
        "VIP":"VIP",
        "OBJCONNC":"OBJCONNC",
        "AUTRE":"AUTRE",
        "INCONNU":"INCONNU",
    }

    DECISION_RESOURCE_TYPE_MAPPING = {
        "LIB":"LIBERAL",
    }
    V2_TO_V1_DECISION_RESOURCE_TYPE_MAPPING = {
        "SMUR":"SMUR",
        "SMUR.ADULT":"SMUR",
        "SMUR.PED":"SMUR",
        "SMUR.UMH-S":"SMUR",
        "SMUR.CUMP":"SMUR",
        "HOSPIT":"HOSPIT",
        "LIBERAL":"LIB",
        "LIBERAL.MG":"LIB",
        "LIBERAL.PHARM":"LIB",
        "LIBERAL.INF":"LIB",
        "LIBERAL.KINE":"LIB",
        "LIBERAL.SOS":"LIB",
        "LIBERAL.MMG":"LIB",
        "LIBERAL.MSPD":"LIB",
        "LIBERAL.MCS":"LIB",
        "LIBERAL.SPEMED":"LIB",
        "LIBERAL.DENT":"LIB",
        "LIBERAL.LABO":"LIB",
        "LIBERAL.AUTREPRO":"LIB",
        "TSU ":"TSU",
        "SIS":"SIS",
        "SIS.MEDSP":"SIS",
        "SIS.ISP":"SIS",
        "SIS.SP":"SIS",
        "AASC":"AASC",
        "FDO":"FDO",
        "FDO.PN":"FDO",
        "FDO.GEND":"FDO",
        "FDO.PM":"FDO",
        "FDO.DOUANES":"FDO",
        "AUTRE":"AUTRE",
    }

    V2_TO_V1_LANGUAGE = {
        "fr":"FR",
        "en":"GB",
        "de":"DE",
        "it":"IT",
        "es":"ES",
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

    V2_TO_V1_CALLER_CONTACT_TYPE = {
        'MSS':'EMAIL'
    }

    V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES =[
        'detail.treatment',
        'detail.medicalHistory',
        'administrativeFile.generalPractitioner'
    ]

    @classmethod
    def upgrade(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def validate_diagnosis_code(json_data:Dict[str, Any],diagnosis_type:str):
            code = get_field_value(json_data, f"$.hypothesis.{diagnosis_type}.code")
            if code != None:
                pattern = re.compile(cls.DIAGNOSIS_CODE_VALIDATION_REGEX)
                correct_format = pattern.match(code)

                if not correct_format:
                    add_to_medical_notes(output_use_case_json, json_data, [f"hypothesis.{diagnosis_type}"])
                    delete_paths(json_data, [f"hypothesis.{diagnosis_type}"])


        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        output_use_case_json = copy.deepcopy(input_use_case_json)

        map_to_new_value(output_use_case_json,'$.qualification.whatsHappen.code', cls.V1_TO_V2_WHATS_HAPPEN_CODE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution',cls.DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.type',cls.CALLER_TYPE_MAPPING)
        map_to_new_value(output_use_case_json, '$.initialAlert.caller.language', cls.V1_TO_V2_LANGUAGE)

        patients = get_field_value(output_use_case_json,'$.patient')
        for index, patient in enumerate(patients):
            map_to_new_value(output_use_case_json, f"$.patient[{index}].identity.strictFeatures.sex", cls.GENDER_MAPPING)
            switch_field_name(patient,'idPat','patientId')
            validate_diagnosis_code(patient,"otherDiagnosis")
            validate_diagnosis_code(patient,"mainDiagnosis")

        if is_field_completed(output_use_case_json,'$.location.geometry.obsDatime'):
            switch_field_name(output_use_case_json['location']['geometry'],'obsDatime','datetime')

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions != None:
            for index, decision in enumerate(decisions):
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", cls.DECISION_RESOURCE_TYPE_MAPPING)
                switch_field_name(decision,'idPat','patientId')

        medical_notes = get_field_value(output_use_case_json, '$.medicalNote')
        if medical_notes != None:
            for note in medical_notes:
                switch_field_name(note,'idPat','patientId')
                switch_field_name(note,'idObs','medicalNoteId')

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, cls.V1_PATHS_TO_DELETE)

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_use_case_json
        return output_json

    @classmethod
    def downgrade(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        def update_language(json_data:Dict[str, Any]):
            language = get_field_value(json_data, '$.initialAlert.caller.language')
            if language in cls.V1_TO_V2_LANGUAGE:
                map_to_new_value(json_data, '$.initialAlert.caller.language', cls.V2_TO_V1_LANGUAGE)
            else:
                delete_paths(json_data, ['initialAlert.caller.language'])

        # Create independent envelope copy without use case for output
        output_json = copy.deepcopy(input_json)
        if 'createCaseHealth' not in input_json.get('content', [{}])[0].get('jsonContent', {}).get('embeddedJsonContent', {}).get('message', {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']

        # Create independent use case copy for output
        input_use_case_json = input_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth']
        output_use_case_json = copy.deepcopy(input_use_case_json)

        map_to_new_value(output_use_case_json,'$.qualification.whatsHappen.code', cls.V2_TO_V1_WHATS_HAPPEN_CODE_MAPPING)
        map_to_new_value(output_use_case_json,'$.qualification.details.attribution',cls.V2_TO_V1_DETAIL_ATTRIBUTION_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.type',cls.V2_TO_V1_CALLER_TYPE_MAPPING)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callerContact.type',cls.V2_TO_V1_CALLER_CONTACT_TYPE)
        map_to_new_value(output_use_case_json,'$.initialAlert.caller.callbackContact.type',cls.V2_TO_V1_CALLER_CONTACT_TYPE)
        update_language(output_use_case_json)

        patients = get_field_value(output_use_case_json,'$.patient')
        for index, patient in enumerate(patients):
            reverse_map_to_new_value(output_use_case_json, f"$.patient[{index}].identity.strictFeatures.sex", cls.GENDER_MAPPING)
            switch_field_name(patient,'patientId','idPat')
            add_to_medical_notes(output_use_case_json, patient, cls.V2_PATIENT_PATHS_TO_ADD_TO_MEDICAL_NOTES)

        decisions = get_field_value(output_use_case_json, '$.decision')
        if decisions != None:
            for index, decision in enumerate(decisions):
                map_to_new_value(output_use_case_json, f"$.decision[{index}].resourceType", cls.V2_TO_V1_DECISION_RESOURCE_TYPE_MAPPING)
                switch_field_name(decision,'patientId','idPat')

        medical_notes = get_field_value(output_use_case_json, '$.medicalNote')
        if medical_notes != None:
            for note in medical_notes:
                switch_field_name(note,'patientId','idPat')
                switch_field_name(note,'medicalNoteId','idObs')

        if is_field_completed(output_use_case_json,'$.location.geometry.datetime'):
            switch_field_name(output_use_case_json['location']['geometry'],'datetime','obsDatime')

        # /!\ Warning - It must be the last step
        delete_paths(output_use_case_json, cls.V2_PATHS_TO_DELETE)

        output_json['content'][0]['jsonContent']['embeddedJsonContent']['message']['createCaseHealth'] = output_use_case_json
        return output_json
