import unittest
from unittest.mock import patch

from converter.versions.create_case_health.v1_v2.utils import validate_diagnosis_code

from converter.versions.create_case_health.v1_v2.utils import (
    update_language,
    get_field_value,
    set_value,
)
from converter.versions.create_case_health.constants import Constants

from converter.versions.create_case_health.v1_v2.utils import add_to_initial_alert_notes


class TestValidateDiagnosisCode(unittest.TestCase):
    def test_validate_diagnosis_code_no_diagnosis(self):
        json_data = {
            "otherKey": "value",
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                    "key2": "value2",
                }
            ],
        }
        validate_diagnosis_code(json_data, json_data["patient"][0], "otherDiagnosis")
        validate_diagnosis_code(json_data, json_data["patient"][0], "mainDiagnosis")
        self.assertEqual(
            json_data,
            {
                "otherKey": "value",
                "patient": [
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "key1": "value1",
                        "key2": "value2",
                    }
                ],
            },
        )

    @patch("converter.utils.random")
    def test_validate_diagnosis_code_no_correct_code(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8", "f5de", "a3b2"]
        json_data = {
            "otherKey": "value",
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                    "key2": "value2",
                    "hypothesis": {
                        "mainDiagnosis": {"code": "MAUVAISCODE", "label": "Faux code"},
                        "otherDiagnosis": [
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                        ],
                    },
                }
            ],
        }
        validate_diagnosis_code(json_data, json_data["patient"][0], "otherDiagnosis")
        validate_diagnosis_code(json_data, json_data["patient"][0], "mainDiagnosis")
        self.assertEqual(len(json_data["medicalNote"]), 5)
        self.assertEqual(
            json_data,
            {
                "otherKey": "value",
                "patient": [
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "key1": "value1",
                        "key2": "value2",
                    }
                ],
                "medicalNote": [
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.f5de",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.a3b2",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.c9d8",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.f5de",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.a3b2",
                        "freetext": "Diagnostique principal : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                ],
            },
        )

    @patch("converter.utils.random")
    def test_validate_diagnosis_code_correct_codes(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8", "f5de", "a3b2"]
        json_data = {
            "otherKey": "value",
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                    "key2": "value2",
                    "hypothesis": {
                        "mainDiagnosis": {"code": "E11.9", "label": "correct"},
                        "otherDiagnosis": [
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                            {"code": "E11.9", "label": "correct"},
                            {"code": "MAUVAISCODE", "label": "Faux code"},
                            {"code": "E11.9", "label": "correct"},
                        ],
                    },
                }
            ],
        }
        validate_diagnosis_code(json_data, json_data["patient"][0], "otherDiagnosis")
        validate_diagnosis_code(json_data, json_data["patient"][0], "mainDiagnosis")
        self.assertEqual(len(json_data["medicalNote"]), 2)
        self.assertEqual(
            json_data,
            {
                "otherKey": "value",
                "patient": [
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "key1": "value1",
                        "key2": "value2",
                        "hypothesis": {
                            "mainDiagnosis": {"code": "E11.9", "label": "correct"},
                            "otherDiagnosis": [
                                {"code": "E11.9", "label": "correct"},
                                {"code": "E11.9", "label": "correct"},
                            ],
                        },
                    }
                ],
                "medicalNote": [
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.f5de",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                    {
                        "patientId": "fr.health.samuH.ERTYUI.GHK",
                        "medicalNoteId": "fr.health.samuH.medicalNote.a3b2",
                        "freetext": "Diagnostique(s) secondaire(s) : code: MAUVAISCODE\nlabel: Faux code\n",
                        "operator": {"role": "AUTRE"},
                    },
                ],
            },
        )


class TestUpdateLanguage(unittest.TestCase):
    @staticmethod
    def message(lang):
        data = {"initialAlert": {"caller": {"language": lang}}}
        return data

    def test_update_language_should_change_value_if_available_in_map(self):
        message = self.message("fr")
        update_language(message, {"fr": "FR"})
        assert (
            get_field_value(message, Constants.INITIAL_ALERT_CALLER_LANGUAGE_PATH)
            == "FR"
        )

    def test_update_language_should_delete_path_if_value_not_in_map(self):
        message = self.message("de")
        update_language(message, {"fr": "FR"})
        assert (
            get_field_value(message, Constants.INITIAL_ALERT_CALLER_LANGUAGE_PATH)
            is None
        )

    def test_update_language_should_delete_value_with_empty_mapping(self):
        data = self.message("fr")
        update_language(data, {})
        assert (
            get_field_value(data, Constants.INITIAL_ALERT_CALLER_LANGUAGE_PATH) is None
        )


class TestAddToInitialNotes(unittest.TestCase):
    def test_add_note_when_none_exists(self):
        message = {}

        add_to_initial_alert_notes(message, "First note")

        notes = get_field_value(message, Constants.INITIAL_ALERT_NOTES_PATH)
        assert len(notes) == 1
        assert notes[0]["freetext"] == "First note"

    def test_add_note_when_list_exists(self):
        message = {}
        set_value(
            message, Constants.INITIAL_ALERT_NOTES_PATH, [{"freetext": "Old note"}]
        )

        add_to_initial_alert_notes(message, "New note")

        notes = get_field_value(message, Constants.INITIAL_ALERT_NOTES_PATH)

        assert len(notes) == 2
        assert notes[0]["freetext"] == "Old note"
        assert notes[1]["freetext"] == "New note"

    def test_multiple_additions(self):
        message = {}

        add_to_initial_alert_notes(message, "Note A")
        add_to_initial_alert_notes(message, "Note B")
        add_to_initial_alert_notes(message, "Note C")

        notes = get_field_value(message, Constants.INITIAL_ALERT_NOTES_PATH)

        assert len(notes) == 3
        assert notes[0]["freetext"] == "Note A"
        assert notes[1]["freetext"] == "Note B"
        assert notes[2]["freetext"] == "Note C"
