from typing import Dict, Any
import copy
import random
import string
from datetime import datetime

from yaml import dump

from converter.cisu.utils import add_to_initial_alert_notes
from converter.constants import Constants
from converter.utils import (
    delete_paths,
    get_field_value,
    get_recipient,
    get_sender,
    is_field_completed,
    translate_key_words,
)
from converter.cisu.base_cisu_converter import BaseCISUConverter


class CreateCaseCISUConverter(BaseCISUConverter):
    """Handles CISU format conversions"""

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

    @classmethod
    def get_rs_message_type(cls) -> str:
        return "createCaseHealth"

    @classmethod
    def get_cisu_message_type(cls) -> str:
        return "createCase"

    @classmethod
    def from_cisu_to_rs(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        """
        Convert from CISU to Health format

        Args:
            input_json: Input EDXL CISU JSON

        Returns:
            Converted EDXL Health JSON
        """

        def set_default_location_freetext(json_data: Dict[str, Any]):
            if not is_field_completed(json_data, "$.location.freetext"):
                json_data["location"]["freetext"] = (
                    ""  # need at least empty value to pass validation
                )

        def add_location_detail(json_data: Dict[str, Any]):
            if is_field_completed(json_data, "$.location.city.detail"):
                set_default_location_freetext(json_data)
                json_data["location"]["freetext"] += (
                    "\nDétails de commune : " + json_data["location"]["city"]["detail"]
                )

        def add_case_priority(json_data: Dict[str, Any]):
            if is_field_completed(json_data, "$.initialAlert.reporting"):
                if not is_field_completed(json_data, "$.qualification.details"):
                    json_data["qualification"]["details"] = {}
                json_data["qualification"]["details"]["priority"] = (
                    "P0"
                    if get_field_value(json_data, "$.initialAlert.reporting")
                    == "ATTENTION"
                    else "P2"
                )

        def merge_notes_freetext(json_data: Dict[str, Any]):
            if not is_field_completed(json_data, "$.initialAlert.notes"):
                return json_data

            merged_texts = []
            other_notes = []

            for note in json_data["initialAlert"]["notes"]:
                if "freetext" in note:
                    merged_texts.append(note["freetext"])
                else:
                    other_notes.append(note)

            merged_note = {"freetext": "; ".join(merged_texts)} if merged_texts else {}

            result_notes = [merged_note] if merged_note else []
            result_notes.extend(other_notes)
            json_data["initialAlert"]["notes"] = result_notes

            return json_data

        def add_victims_to_medical_notes(json_data: Dict[str, Any], sender_id: str):
            field_value = get_field_value(json_data, "$.qualification.victims")

            if field_value is None:
                return
            else:
                formatted_field_value = dump(field_value, allow_unicode=True)
                translated_text = translate_key_words(
                    formatted_field_value, cls.MEDICAL_NOTE_KEY_TRANSLATIONS
                )
                add_object_to_medical_notes(json_data, translated_text, sender_id)

        def add_object_to_medical_notes(
            json_data: Dict[str, Any], note_text: str, sender_id: str
        ):
            if not is_field_completed(json_data, "$.medicalNote"):
                json_data["medicalNote"] = []

            random_str = "".join(
                random.choices(
                    string.ascii_lowercase + string.digits,
                    k=Constants.MEDICAL_NOTE_RANDOM_ID_LENGTH,
                )
            )
            medical_note_id = f"{sender_id}.medicalNote.{random_str}"

            new_note = {
                "medicalNoteId": medical_note_id,
                "freetext": note_text,
                "operator": {"role": "AUTRE"},
            }

            json_data["medicalNote"].append(new_note)

        # Create independent envelope copy without usecase for output
        output_json = copy.deepcopy(input_json)
        if "createCase" not in input_json.get("content", [{}])[0].get(
            "jsonContent", {}
        ).get("embeddedJsonContent", {}).get("message", {}):
            raise ValueError("Input JSON must contain 'createCase' key")
        del output_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "createCase"
        ]

        # Create independent use case copy for output
        input_use_case_json = input_json["content"][0]["jsonContent"][
            "embeddedJsonContent"
        ]["message"]["createCase"]
        sender_id = get_sender(input_json)
        output_use_case_json = copy.deepcopy(input_use_case_json)

        # - Updates
        output_use_case_json["owner"] = get_recipient(input_json)

        set_default_location_freetext(output_use_case_json)
        add_location_detail(output_use_case_json)

        if is_field_completed(output_use_case_json, "$.initialAlert"):
            add_case_priority(output_use_case_json)
            add_to_initial_alert_notes(
                output_use_case_json, cls.CISU_PATHS_TO_ADD_TO_INITIAL_ALERT_NOTES
            )
            merge_notes_freetext(output_use_case_json)

        add_victims_to_medical_notes(output_use_case_json, sender_id)

        # - Delete paths - /!\ It must be the last step
        delete_paths(output_use_case_json, cls.CISU_PATHS_TO_DELETE)

        output_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "createCaseHealth"
        ] = output_use_case_json
        return output_json

    @staticmethod
    def count_victims(json_data: Dict[str, Any]) -> int:
        victims = get_field_value(json_data, "$.patient")
        if victims is None:
            return 0
        return len(victims)

    @staticmethod
    def get_victim_count(cls, json_data: Dict[str, Any]):
        victims_count = cls.count_victims(json_data)
        if victims_count == 0:
            return {"count": "0"}
        if victims_count == 1:
            return {"count": "1"}
        if victims_count < 5:
            return {"count": "PLUSIEURS"}
        return {"count": "BEAUCOUP"}

    @classmethod
    def from_rs_to_cisu(cls, input_json: Dict[str, Any]) -> Dict[str, Any]:
        """
        Convert from Health to CISU format

        Args:
            input_json: Input EDXL Health JSON

        Returns:
            Converted EDXL CISU JSON
        """

        def add_victim_information(json_data: Dict[str, Any]):
            if not is_field_completed(json_data, "$.qualification"):
                json_data["qualification"] = {}
            json_data["qualification"]["victims"] = cls.get_victim_count(
                cls, input_usecase_json
            )

        def get_call_taker_information(json_data: Dict[str, Any]):
            sender_id = get_sender(json_data)
            crra_code = sender_id[
                len("fr.health.") :
            ]  # fr.health.samu780(.xxx) -> samu780(.xxx)
            return {
                "organization": sender_id,
                "controlRoom": "CRRA " + crra_code,  # samu780(.xxx) -> Samu780( Xxx)
            }

        def add_default_external_info_type(json_data: Dict[str, Any]):
            external_info = get_field_value(json_data, "$.location.externalInfo")
            if external_info is not None:
                for info in external_info:
                    if not is_field_completed(info, "$.type"):
                        info["type"] = "AUTRE"

        # Create independent envelope copy without usecase for output
        output_json = copy.deepcopy(input_json)
        if "createCaseHealth" not in input_json.get("content", [{}])[0].get(
            "jsonContent", {}
        ).get("embeddedJsonContent", {}).get("message", {}):
            raise ValueError("Input JSON must contain 'createCaseHealth' key")
        del output_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "createCaseHealth"
        ]

        # Create independent usecase copy for output
        input_usecase_json = input_json["content"][0]["jsonContent"][
            "embeddedJsonContent"
        ]["message"]["createCaseHealth"]
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # Generate unique IDs
        timestamp = datetime.now().strftime("%Y%m%d%H%M%S")
        random_str = "".join(
            random.choices(string.ascii_lowercase + string.digits, k=4)
        )

        # - Updates
        # ToDo: pass this by ConfigMap and based on the version of the model
        output_usecase_json["referenceVersion"] = "2.0"
        add_victim_information(output_usecase_json)

        if not is_field_completed(output_usecase_json, "$.location"):
            output_usecase_json["location"] = {}

        output_usecase_json["location"]["locID"] = f"LOC-{timestamp}-{random_str}"
        # ToDo: get country from INSEE code | Ref.: https://www.insee.fr/fr/information/7766585#titre-bloc-25
        output_usecase_json["location"]["country"] = "FR"  # Default value

        if not is_field_completed(output_usecase_json, "$.qualification.whatsHappen"):
            output_usecase_json["qualification"]["whatsHappen"] = (
                cls.DEFAULT_WHATS_HAPPEN
            )

        add_default_external_info_type(output_usecase_json)

        # Deletions - /!\ it must be done before copying qualification and location fields
        delete_paths(output_usecase_json, cls.HEALTH_PATHS_TO_DELETE)

        if is_field_completed(input_usecase_json, "$.initialAlert"):
            output_usecase_json["initialAlert"]["id"] = f"INAL-{timestamp}-{random_str}"
            output_usecase_json["initialAlert"]["callTaker"] = (
                get_call_taker_information(input_json)
            )
            output_usecase_json["initialAlert"]["reception"] = get_field_value(
                input_usecase_json, "$.creation"
            )
            output_usecase_json["initialAlert"]["reporting"] = (
                "ATTENTION"
                if get_field_value(
                    input_usecase_json, "$.qualification.details.priority"
                )
                in ["P0", "P1"]
                else "STANDARD"
            )
            output_usecase_json["initialAlert"]["qualification"] = copy.deepcopy(
                get_field_value(output_usecase_json, "$.qualification")
            )
            output_usecase_json["initialAlert"]["location"] = copy.deepcopy(
                get_field_value(output_usecase_json, "$.location")
            )

        output_json["content"][0]["jsonContent"]["embeddedJsonContent"]["message"][
            "createCase"
        ] = output_usecase_json
        return output_json
