class CreateCaseCISUConstants:
    CISU_PATHS_TO_DELETE = [
        "qualification.victims",
        "referenceVersion",
        "freetext",
        "location.geometry.point.coord.heading",
        "location.geometry.point.coord.speed",
        "location.geometry.sketch",
        "location.country",
        "location.locID",
        "location.locLabel",
        "location.city.detail",
        "initialAlert.id",
        "initialAlert.attachment",
        "initialAlert.reporting",
        "initialAlert.qualification",
        "initialAlert.location",
        "initialAlert.callTaker",
        "newAlert",
    ]

    HEALTH_PATHS_TO_DELETE = [
        "owner",
        "patient",
        "medicalNote",
        "decision",
        "perimeter",
        "interventionType",
        "qualification.origin",
        "qualification.details",
        "location.detailedAddress.highway",
        "location.geometry.point.isAml",
    ]

    CISU_PATHS_TO_ADD_TO_INITIAL_ALERT_NOTES = [
        {"path": "$.initialAlert.attachment", "label": "Pièces jointes :"},
        {"path": "$.initialAlert.callTaker", "label": "Contact de l'opérateur SIS :"},
        {"path": "$.freetext", "label": ""},
        {"path": "$.newAlert", "label": "Nouvelles alertes :"},
    ]

    MEDICAL_NOTE_KEY_TRANSLATIONS = {
        "freetext:": "Commentaire général :",
        "mainVictim:": "Victime principale :",
        "count:": "Nombre de victimes :",
    }

    DEFAULT_WHATS_HAPPEN = {"code": "C11.06.00", "label": "Autre nature de fait"}

    DEFAULT_LOCATION_EXTERNAL_INFO_TYPE = "AUTRE"

    DEFAULT_LOCATION_COUNTRY = "FR"

    LOCATION_PATH = "$.location"
    LOCATION_FREETEXT_PATH = f"{LOCATION_PATH}.freetext"
    LOCATION_CITY_DETAIL_PATH = f"{LOCATION_PATH}.city.detail"
    LOCATION_EXTERNAL_INFO_PATH = f"{LOCATION_PATH}.externalInfo"
    LOCATION_EXTERNAL_INFO_TYPE_PATH = "$.type"
    LOCATION_LOC_ID_PATH = f"{LOCATION_PATH}.locID"
    LOCATION_COUNTRY_PATH = f"{LOCATION_PATH}.country"

    INITIAL_ALERT_PATH = "$.initialAlert"
    INITIAL_ALERT_REPORTING_PATH = f"{INITIAL_ALERT_PATH}.reporting"
    INITIAL_ALERT_NOTES_PATH = f"{INITIAL_ALERT_PATH}.notes"
    INITIAL_ALERT_ID_PATH = f"{INITIAL_ALERT_PATH}.id"
    INITIAL_ALERT_CALL_TAKER_PATH = f"{INITIAL_ALERT_PATH}.callTaker"
    INITIAL_ALERT_RECEPTION_PATH = f"{INITIAL_ALERT_PATH}.reception"
    INITIAL_ALERT_QUALIFICATION_PATH = f"{INITIAL_ALERT_PATH}.qualification"
    INITIAL_ALERT_LOCATION_PATH = f"{INITIAL_ALERT_PATH}.location"

    QUALIFICATION_PATH = "$.qualification"
    QUALIFICATION_VICTIMS_PATH = f"{QUALIFICATION_PATH}.victims"
    QUALIFICATION_DETAILS_PRIORITY_PATH = f"{QUALIFICATION_PATH}.details.priority"
    QUALIFICATION_WHATS_HAPPEN_PATH = f"{QUALIFICATION_PATH}.whatsHappen"

    MEDICAL_NOTE_PATH = "$.medicalNote"

    OWNER_PATH = "$.owner"

    REFERENCE_VERSION_PATH = "$.referenceVersion"

    CREATION_PATH = "$.creation"
