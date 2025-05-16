class V2V3Constants:
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
