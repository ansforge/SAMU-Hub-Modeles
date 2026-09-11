class ResourcesResponseConstants:
    V2_VALID_DEADLINES = [
        "DEL0",
        "ASAP",
        "30M",
        "45M",
        "1H",
        "2H",
        "4H",
        "8H",
        "12H",
        "24H",
        "RDV",
    ]

    V2_DEFAULT_DEADLINE = "DEL0"

    RESPONSE_DEADLINE_PATH = "$.response.deadline"
