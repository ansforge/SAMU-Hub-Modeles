class InterventionReportConstants:
    ASSOCIATED_DIAGNOSIS_PATH = "$.evaluation.associatedDiagnosis"

    EXTERNAL_ID_PATH = "$.patient.externalId"
    EXTERNAL_ID_VALUE_KEY = "value"
    EXTERNAL_ID_SOURCE_KEY = "source"
    EXTERNAL_ID_SOURCE_PATH = f"$.{EXTERNAL_ID_SOURCE_KEY}"
    V2_TO_V3_EXTERNAL_ID_SOURCE_MAPPING = {"SI-VIC": "AUTRE"}

    REDACTOR_ROLE_PATH = "$.redactor.role"
    V3_TO_V2_REDACTOR_ROLE_MAPPING = {
        "PILOTE": "AUTRE",
        "TCM": "AUTRE",
    }

    EVALUATION_PARAMETER_PATH = "$.evaluation.parameter"
    EVALUATION_PARAMETER_PRECISION_KEY = "precision"
    EVALUATION_PARAMETER_TYPE_KEY = "type"

    EVALUATION_FREETEXT_PATH = "$.evaluation.freetext"
