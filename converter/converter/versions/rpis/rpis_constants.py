class RpisConstants:
    RESOURCE_TYPE_PATH = "$.orientation.decision.resourceType"
    V3_TO_V2_RESOURCE_TYPE_MAPPING = {"TSU": "TSU "}

    REGULATION_MEDICAL_LEVEL_PATH = "$.regulation.medicalLevel"
    ORIENTATION_MEDICAL_LEVEL_PATH = "$.orientation.decision.medicalLevel"
    V3_TO_V2_MEDICAL_LEVEL_MAPPING = {"SANS": "MED"}

    # Code mapping paths and fallback values for v3 to v2 conversion
    WHATS_HAPPEN_CODE_PATH = "$.regulation.whatsHappen.code"
    HEALTH_MOTIVE_CODE_PATH = "$.regulation.healthMotive.code"
    LOCATION_TYPE_PATH = "$.intervention.location.type"

    # Fallback codes for v3 to v2 conversion (all v2 codes map to these generic v1.18 codes)
    WHATS_HAPPEN_FALLBACK = "C11.06.00"  # Autre nature de fait
    HEALTH_MOTIVE_FALLBACK = "M03.14"  # Autre problème médical
    LOCATION_FALLBACK = "L07.00.00"  # Lieu non explicite
