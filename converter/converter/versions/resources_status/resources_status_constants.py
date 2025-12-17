class ResourcesStatusConstants:
    V1_TO_V2_STATUS_MAPPING = {
        "ARRIVE": "ARRIVEE",
        "TRANSPOR": "TRANSP",
        "FINPEC": "FINMED",
    }

    V3_TO_V2_STATUS_MAPPING = {
        "FINPEC": "FINMED",
        "ORIENTAT": "TRANSP",
    }

    # V1 paths
    DATETIME_PATH = "$.datetime"
    STATUS_PATH = "$.status"
    AVAILABILITY_PATH = "$.availability"

    # V2 and V3 paths
    STATE_PATH = "$.state"
    STATE_DATETIME_PATH = f"{STATE_PATH}.datetime"
    STATE_STATUS_PATH = f"{STATE_PATH}.status"
    STATE_AVAILABILITY_PATH = f"{STATE_PATH}.availability"
