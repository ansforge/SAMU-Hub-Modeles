class ResourcesInfoConstants:
    V3_TO_V2_STATUS_MAPPING = {
        "FINPEC": "FINMED",
    }

    V1_TO_V2_STATUS_MAPPING = {
        "ARRIVE": "ARRIVEE",
        "TRANSPOR": "TRANSP",
        "FINPEC": "FINMED",
    }

    V2_PATHS_TO_DELETE = [
        "resource",
        "mobilizedResource[].team.medicalLevel",
        "mobilizedResource[].vehicleType",
    ]

    V3_PATHS_TO_DELETE = [
        "resource[].patientId",
    ]

    V1_PATHS_TO_DELETE = [
        "resource[].coord",
        "resource[].vehiculeType",
        "resource[].team.teamCare",
        "resource[].resourceType",
        "resource[].plate",
        "mobilizedResource",
    ]

    V1_TO_V2_VEHICULE_TYPE_MAPPING = {
        "AASC": "AASC",
        "VLSC": "AASC.VLSC",
        "VPSP": "AASC.VPSP",
        "AUTRESC": "AASC.AUTRESC",
        "AUTREVEC": "AUTREVEC",
        "TAXI": "AUTREVEC.TAXI",
        "TRANSP": "AUTREVEC.TRANSP",
        "TRAIN": "AUTREVEC.TRAIN",
        "AVION": "AUTREVEC.AVION",
        "PERSO": "AUTREVEC.PERSO",
        "APIED": "AUTREVEC.APIED",
        "AUTRE": "AUTREVEC.AUTRE",
        "AUTRETRA": "AUTREVEC.AUTRETRA",
        "FSI": "FSI",
        "HELIFSI": "FSI.HELIFSI",
        "VLFSI": "FSI.VLFSI",
        "FFSI": "FSI.FFSI",
        "VHFSI": "FSI.VHFSI",
        "LIB": "LIB",
        "MEDV": "LIB.MEDV",
        "INF": "LIB.INF",
        "AUTREPRO": "LIB.AUTREPRO",
        "SIS": "SIS",
        "VSAV": "SIS.VSAV",
        "GRIMP": "SIS.GRIMP",
        "VPL": "SIS.VPL",
        "SRSIS": "SIS.SRSIS",
        "FEUSIS": "SIS.FEUSIS",
        "VPMA": "SIS.VPMA",
        "VCH": "SIS.VCH",
        "VR": "SIS.VR",
        "PCSIS": "SIS.PCSIS",
        "VLISP": "SIS.VLISP",
        "VLMSP": "SIS.VLMSP",
        "VLCG": "SIS.VLCG",
        "VLSIS": "SIS.VLSIS",
        "DRAGON": "SIS.DRAGON",
        "AVSC": "SIS.AVSC",
        "MOYSSE": "SIS.MOYSSE",
        "AUTRESIS": "SIS.AUTRESIS",
        "NAVISIS": "SIS.NAVISIS",
        "SMUR": "SMUR",
        "VLM": "SMUR.VLM",
        "VL": "SMUR.VL",
        "PSM1": "SMUR.PSM1",
        "PSM2": "SMUR.PSM2",
        "PSM3": "SMUR.PSM3",
        "PSMP": "SMUR.PSMP",
        "VPC": "SMUR.VPC",
        "AR": "SMUR.AR",
        "AR-BAR": "SMUR.AR-BAR",
        "AR-PED": "SMUR.AR-PED",
        "HELISMUR": "SMUR.HELISMUR",
        "HELISAN": "SMUR.HELISAN",
        "AVSMUR": "SMUR.AVSMUR",
        "AVSAN": "SMUR.AVSAN",
        "NAVISMUR": "SMUR.NAVISMUR",
        "TSU": "TSU",
        "VSL": "TSU.VSL",
        "AMB-GV": "TSU.AMB-GV",
        "AMB-PV": "TSU.AMB-PV",
        "AMB-BAR": "TSU.AMB-BAR",
        "AMB": "TSU.AMB",
    }

    MOBILIZED_RESOURCE_DEFAULT_VALUE = "AUTRE"

    MOBILIZED_RESOURCE_PATH = "$.mobilizedResource"
    MOBILIZED_RESOURCE_PLATE_PATH = "$.plate"
    MOBILIZED_RESOURCE_TEAM_CARE_PATH = "$.team.teamCare"
    MOBILIZED_RESOURCE_VEHICULE_TYPE_PATH = "$.vehiculeType"
    MOBILIZED_RESOURCE_RESOURCE_TYPE_PATH = "$.resourceType"

    RESOURCE_PATH = "$.resource"
    RESOURCE_STATE_PATH = "$.state"
    RESOURCE_STATE_STATUS_PATH = "$.status"
    RESOURCE_VEHICLE_TYPE_PATH = "$.vehicleType"
    RESOURCE_TEAM_MEDICAL_LEVEL_PATH = "$.team.medicalLevel"
    RESOURCE_PATIENT_ID_PATH = "$.patientId"
    RESOURCE_FREETEXT_PATH = "$.freetext"
