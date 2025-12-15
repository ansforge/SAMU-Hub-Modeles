from typing import Dict, Any
import copy
import random
import string
from datetime import datetime

from yaml import dump

from converter.cisu.create_case.create_case_cisu_constants import (
    CreateCaseCISUConstants,
)
from converter.cisu.utils import add_to_initial_alert_notes
from converter.constants import Constants
from converter.utils import (
    delete_paths,
    get_field_value,
    get_recipient,
    get_sender,
    is_field_completed,
    translate_key_words,
    set_value,
)
from converter.cisu.base_cisu_converter import BaseCISUConverter
import logging

logger = logging.getLogger(__name__)


class CreateCaseCISUConverter(BaseCISUConverter):
    """Handles CISU format conversions"""

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
        logger.info("Starting CISU to Health format conversion")

        def set_default_location_freetext(json_data: Dict[str, Any]):
            logger.debug("Setting default location freetext")
            if not is_field_completed(
                json_data, CreateCaseCISUConstants.LOCATION_FREETEXT_PATH
            ):
                set_value(json_data, CreateCaseCISUConstants.LOCATION_FREETEXT_PATH, "")

        def add_location_detail(json_data: Dict[str, Any]):
            logger.debug("Adding location detail to freetext")
            location_city_detail = get_field_value(
                json_data, CreateCaseCISUConstants.LOCATION_CITY_DETAIL_PATH
            )
            if not location_city_detail:
                return

            current_location_freetext = get_field_value(
                json_data, CreateCaseCISUConstants.LOCATION_FREETEXT_PATH
            )
            updated_location_freetext = current_location_freetext + (
                "\nDétails de commune : " + location_city_detail
            )
            set_value(
                json_data,
                CreateCaseCISUConstants.LOCATION_FREETEXT_PATH,
                updated_location_freetext,
            )

        def add_case_priority(json_data: Dict[str, Any]):
            logger.debug("Adding case priority")
            initial_alert_reporting = get_field_value(
                json_data, CreateCaseCISUConstants.INITIAL_ALERT_REPORTING_PATH
            )
            if not initial_alert_reporting:
                return

            new_priority_value = (
                "P0" if initial_alert_reporting == "ATTENTION" else "P2"
            )
            set_value(
                json_data,
                CreateCaseCISUConstants.QUALIFICATION_DETAILS_PRIORITY_PATH,
                new_priority_value,
            )

        def merge_notes_freetext(json_data: Dict[str, Any]):
            logger.debug("Merging freetext notes")
            initial_alert_notes = get_field_value(
                json_data, CreateCaseCISUConstants.INITIAL_ALERT_NOTES_PATH
            )
            if not initial_alert_notes:
                return json_data

            merged_texts = []
            other_notes = []

            for note in initial_alert_notes:
                if "freetext" in note:
                    merged_texts.append(note["freetext"])
                else:
                    other_notes.append(note)

            merged_note = {"freetext": "; ".join(merged_texts)} if merged_texts else {}

            result_notes = [merged_note] if merged_note else []
            result_notes.extend(other_notes)
            set_value(
                json_data,
                CreateCaseCISUConstants.INITIAL_ALERT_NOTES_PATH,
                result_notes,
            )

            return json_data

        def add_victims_to_medical_notes(json_data: Dict[str, Any], sender_id: str):
            logger.debug("Adding victims to medical notes")
            field_value = get_field_value(json_data, "$.qualification.victims")

            if field_value is None:
                return

            formatted_field_value = dump(field_value, allow_unicode=True)
            translated_text = translate_key_words(
                formatted_field_value,
                CreateCaseCISUConstants.MEDICAL_NOTE_KEY_TRANSLATIONS,
            )
            add_object_to_medical_notes(json_data, translated_text, sender_id)

        def add_object_to_medical_notes(
            json_data: Dict[str, Any], note_text: str, sender_id: str
        ):
            logger.debug("Adding object to medical notes")

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

            medical_notes = (
                get_field_value(json_data, CreateCaseCISUConstants.MEDICAL_NOTE_PATH)
                or []
            )
            medical_notes.append(new_note)
            set_value(
                json_data, CreateCaseCISUConstants.MEDICAL_NOTE_PATH, medical_notes
            )

        # Create independent envelope copy without usecase for output
        output_json = cls.copy_cisu_input_content(input_json)

        # Create independent use case copy for output
        sender_id = get_sender(input_json)
        output_use_case_json = cls.copy_cisu_input_use_case_content(input_json)

        # - Updates
        set_value(
            output_use_case_json,
            CreateCaseCISUConstants.OWNER_PATH,
            get_recipient(input_json),
        )

        set_default_location_freetext(output_use_case_json)
        add_location_detail(output_use_case_json)

        add_case_priority(output_use_case_json)
        add_to_initial_alert_notes(
            output_use_case_json,
            CreateCaseCISUConstants.CISU_PATHS_TO_ADD_TO_INITIAL_ALERT_NOTES,
        )
        merge_notes_freetext(output_use_case_json)

        add_victims_to_medical_notes(output_use_case_json, sender_id)

        # - Delete paths - /!\ It must be the last step
        logger.debug("Removing unnecessary paths")
        delete_paths(output_use_case_json, CreateCaseCISUConstants.CISU_PATHS_TO_DELETE)

        return cls.format_rs_output_json(output_json, output_use_case_json)

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
        logger.info("Starting Health format to CISU conversion")

        def add_victim_information(json_data: Dict[str, Any]):
            logger.debug("Adding victim information")
            set_value(
                json_data,
                CreateCaseCISUConstants.QUALIFICATION_VICTIMS_PATH,
                cls.get_victim_count(cls, input_usecase_json),
            )

        def get_call_taker_information(json_data: Dict[str, Any]):
            logger.debug("Getting call taker information")
            sender_id = get_sender(json_data)
            crra_code = sender_id[
                len("fr.health.") :
            ]  # fr.health.samu780(.xxx) -> samu780(.xxx)
            return {
                "organization": sender_id,
                "controlRoom": "CRRA " + crra_code,  # samu780(.xxx) -> Samu780( Xxx)
            }

        def add_default_external_info_type(json_data: Dict[str, Any]):
            logger.debug("Adding default external info type")
            external_info = get_field_value(
                json_data, CreateCaseCISUConstants.LOCATION_EXTERNAL_INFO_PATH
            )
            if external_info is None:
                return
            for info in external_info:
                if not is_field_completed(
                    info, CreateCaseCISUConstants.LOCATION_EXTERNAL_INFO_TYPE_PATH
                ):
                    set_value(
                        info,
                        CreateCaseCISUConstants.LOCATION_EXTERNAL_INFO_TYPE_PATH,
                        CreateCaseCISUConstants.DEFAULT_LOCATION_EXTERNAL_INFO_TYPE,
                    )

        # Create independent envelope copy without usecase for output
        output_json = cls.copy_rs_input_content(input_json)

        # Create independent usecase copy for output
        input_usecase_json = cls.copy_rs_input_use_case_content(input_json)
        output_usecase_json = copy.deepcopy(input_usecase_json)

        # Generate unique IDs
        timestamp = datetime.now().strftime("%Y%m%d%H%M%S")
        random_str = "".join(
            random.choices(string.ascii_lowercase + string.digits, k=4)
        )

        # - Updates
        # ToDo: pass this by ConfigMap and based on the version of the model
        set_value(
            output_usecase_json, CreateCaseCISUConstants.REFERENCE_VERSION_PATH, "2.0"
        )
        add_victim_information(output_usecase_json)

        set_value(
            output_usecase_json,
            CreateCaseCISUConstants.LOCATION_LOC_ID_PATH,
            f"LOC-{timestamp}-{random_str}",
        )
        # ToDo: get country from INSEE code | Ref.: https://www.insee.fr/fr/information/7766585#titre-bloc-25
        set_value(
            output_usecase_json,
            CreateCaseCISUConstants.LOCATION_COUNTRY_PATH,
            CreateCaseCISUConstants.DEFAULT_LOCATION_COUNTRY,
        )

        if not is_field_completed(
            output_usecase_json, CreateCaseCISUConstants.QUALIFICATION_WHATS_HAPPEN_PATH
        ):
            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.QUALIFICATION_WHATS_HAPPEN_PATH,
                CreateCaseCISUConstants.DEFAULT_WHATS_HAPPEN,
            )

        add_default_external_info_type(output_usecase_json)

        # Deletions - /!\ it must be done before copying qualification and location fields
        logger.debug("Removing unnecessary paths")
        delete_paths(
            output_usecase_json, CreateCaseCISUConstants.HEALTH_PATHS_TO_DELETE
        )

        if is_field_completed(
            input_usecase_json, CreateCaseCISUConstants.INITIAL_ALERT_PATH
        ):
            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_ID_PATH,
                f"INAL-{timestamp}-{random_str}",
            )

            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_CALL_TAKER_PATH,
                get_call_taker_information(input_json),
            )

            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_RECEPTION_PATH,
                get_field_value(
                    input_usecase_json, CreateCaseCISUConstants.CREATION_PATH
                ),
            )

            new_initial_alert_reporting = (
                "ATTENTION"
                if get_field_value(
                    input_usecase_json, "$.qualification.details.priority"
                )
                in ["P0", "P1"]
                else "STANDARD"
            )
            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_REPORTING_PATH,
                new_initial_alert_reporting,
            )

            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_QUALIFICATION_PATH,
                get_field_value(
                    output_usecase_json, CreateCaseCISUConstants.QUALIFICATION_PATH
                ),
            )

            set_value(
                output_usecase_json,
                CreateCaseCISUConstants.INITIAL_ALERT_LOCATION_PATH,
                get_field_value(
                    output_usecase_json, CreateCaseCISUConstants.LOCATION_PATH
                ),
            )

        return cls.format_cisu_output_json(output_json, output_usecase_json)
