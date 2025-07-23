class ResourcesStatusConstants:
    V1_PATHS_TO_DELETE = [
        "availability",
        "status",
        "datetime",
    ]

    V2_PATHS_TO_DELETE = [
        "state.availability",
        "state.status",
        "state.datetime",
    ]

    V1_TO_V2_STATUS_MAPPING = {
        "ARRIVE": "ARRIVEE",
        "TRANSPOR": "TRANSP"
    }

    V3_TO_V2_STATUS_MAPPING = {
        "FINPEC": "FINMED",
        "ORIENTAT": "TRANSP",
    }
