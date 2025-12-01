import unittest
from unittest.mock import patch

from converter.versions.create_case_health.v1_v2.utils import validate_diagnosis_code


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
