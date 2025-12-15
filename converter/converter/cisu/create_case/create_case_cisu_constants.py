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
