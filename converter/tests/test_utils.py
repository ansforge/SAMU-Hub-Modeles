from unittest.mock import patch
from converter.utils import (
    add_to_medical_notes,
    concatenate_values,
    get_field_value,
    is_field_completed,
    format_object,
    delete_paths,
    map_to_new_value,
    translate_key_words,
    update_json_value,
    set_value,
)
import unittest
import json
import os


def load_json_file(filename):
    file_path = os.path.join(os.path.dirname(__file__), filename)
    with open(file_path, "r", encoding="utf-8") as file:
        return json.load(file)


class ExampleTestVictim:
    def __init__(self, count: str, condition: str):
        self.count = count
        self.condition = condition


class ExampleTestIncident:
    def __init__(self, type: str, location: str, victim: ExampleTestVictim):
        self.type = type
        self.location = location
        self.victim = victim


def test_format_object_primitive():
    assert format_object("test") == "test"
    assert format_object(123) == "123"


def test_format_object_list():
    result = format_object(["a", "b", "c"])
    expected = "- a\n- b\n- c"
    assert result == expected


def test_format_object_dict():
    data = {"key1": "value1", "key2": "value2"}
    result = format_object(data)
    expected = "- Key1:\n  value1\n- Key2:\n  value2"
    assert result == expected


def test_format_object_nested():
    victim = ExampleTestVictim("PLUSIEURS", "GRAVE")
    incident = ExampleTestIncident("Accident", "School", victim)

    result = format_object(incident)
    expected = (
        "Example Test Incident:\n"
        "- Type: Accident\n"
        "- Location: School\n"
        "- Victim:\n"
        "  - Count: PLUSIEURS\n"
        "  - Condition: GRAVE"
    )
    assert result == expected


def test_delete_paths():
    data = {"a": {"b": {"c": 1, "d": 2}, "e": 3}, "f": 4}

    paths = ["a.b.c", "f"]
    delete_paths(data, paths)

    assert "c" not in data["a"]["b"]
    assert "f" not in data
    assert data["a"]["b"]["d"] == 2


def test_delete_paths_missing():
    data = {"a": {"b": 1}}
    delete_paths(data, ["a.x.y", "z"])
    assert data == {"a": {"b": 1}}


def test_delete_paths_cleanup():
    data = {"a": {"b": {"c": 1}}}
    delete_paths(data, ["a.b.c"])
    assert data == {}  # Empty dictionaries should be cleaned up


def test_translate_keys():
    translation_mapping = {"translate": "change", "this": "that ", "a ": "one"}
    input_text = "thisis a random string totranslate"
    output_text = translate_key_words(input_text, translation_mapping)
    assert output_text == "that is onerandom string tochange"


def test_concatenate():
    data = {
        "key1": "this",
        "key2": "should",
        "key3": {"subkey1": "form", "subkey2": "a", "subkey3": "complete"},
        "key4": "sentence",
    }

    assert concatenate_values(data) == " this should form a complete sentence"


def test_empty_concatenate():
    data = {}

    assert concatenate_values(data) == ""


def test_delete_paths_with_list():
    data = {
        "a": {
            "b": {
                "c": [
                    {"delete": 1, "keep": 2},
                    {"delete": 2, "keep": 3},
                    {"delete": 4, "keep": 5},
                ],
                "d": 2,
            },
            "e": 3,
        },
        "f": 4,
    }
    delete_paths(data, ["a.b.c[].delete"])

    assert data["a"]["b"]["c"] == [{"keep": 2}, {"keep": 3}, {"keep": 5}]
    assert len(data["a"]["b"]["c"]) == 3
    assert data["a"]["b"]["d"] == 2
    assert data["a"]["e"] == 3
    assert data["f"] == 4


def test_delete_paths_with_wrong_list():
    data = {
        "a": {
            "b": {
                "c": [
                    {"delete": 1, "keep": 2},
                    {"delete": 2, "keep": 3},
                    {"delete": 4, "keep": 5},
                ],
                "d": 2,
            },
            "e": 3,
        },
        "f": 4,
    }
    delete_paths(data, ["a.b.c[].toto"])

    assert data["a"]["b"]["c"] == [
        {"delete": 1, "keep": 2},
        {"delete": 2, "keep": 3},
        {"delete": 4, "keep": 5},
    ]
    assert len(data["a"]["b"]["c"]) == 3
    assert data["a"]["b"]["d"] == 2
    assert data["a"]["e"] == 3
    assert data["f"] == 4


class TestIsFieldCompleted(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.json_data = load_json_file("./fixtures/json_data_fixture.json")

    def test_existing_path(self):
        self.assertTrue(is_field_completed(self.json_data, "$.caseId"))
        self.assertTrue(
            is_field_completed(
                self.json_data, "$.location.detailedAddress.wayName.type"
            )
        )
        self.assertTrue(
            is_field_completed(self.json_data, "$.qualification.riskThreat[0].label")
        )
        self.assertTrue(
            is_field_completed(self.json_data, "$.qualification.riskThreat[0]")
        )
        self.assertTrue(
            is_field_completed(self.json_data, "$.qualification.riskThreat")
        )
        self.assertTrue(is_field_completed(self.json_data, "$.qualification"))
        self.assertTrue(
            is_field_completed(self.json_data, "$.qualification.healthMotive")
        )

    def test_non_existing_path(self):
        self.assertFalse(is_field_completed(self.json_data, "$.caseId.name"))
        self.assertFalse(is_field_completed(self.json_data, "$.name"))
        self.assertFalse(
            is_field_completed(self.json_data, "$.location.detailedAddress.city.id")
        )

    def test_empty_json_data(self):
        self.assertFalse(is_field_completed({}, "$.caseId"))

    def test_invalid_jsonpath(self):
        with self.assertRaises(Exception):
            is_field_completed(self.json_data, "$..")
        with self.assertRaises(Exception):
            is_field_completed(self.json_data, "$toto")


class TestGetFieldValue(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.json_data = load_json_file("./fixtures/json_data_fixture.json")

    def test_existing_path(self):
        self.assertEqual(
            get_field_value(self.json_data, "$.caseId"),
            "fr.health.samu770.DRFR154878900236",
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.location.detailedAddress.wayName.type"),
            "Rue",
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.qualification.riskThreat[0].label"),
            "Risque d'explosion, présence de gaz",
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.qualification.riskThreat[1].label"),
            "Risque d'incendie",
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.qualification.riskThreat[0]"),
            {"code": "R13", "label": "Risque d'explosion, présence de gaz"},
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.qualification.riskThreat[*]"),
            [
                {"code": "R13", "label": "Risque d'explosion, présence de gaz"},
                {"code": "R12", "label": "Risque d'incendie"},
            ],
        )
        self.assertEqual(
            get_field_value(self.json_data, "$.qualification"),
            {
                "whatsHappen": {"code": "C09.03.00", "label": "Fuite de gaz"},
                "locationKind": {
                    "code": "L01.01.01",
                    "label": "Maison particulière, pavillon, à l'intérieur",
                },
                "riskThreat": [
                    {"code": "R13", "label": "Risque d'explosion, présence de gaz"},
                    {"code": "R12", "label": "Risque d'incendie"},
                ],
                "healthMotive": {
                    "code": "M03.10",
                    "label": "Malaise avec perte de connaissance initiale",
                },
                "details": {"priority": "P1"},
            },
        )

    def test_non_existing_path(self):
        self.assertIsNone(get_field_value(self.json_data, "$.caseId.name"))
        self.assertIsNone(get_field_value(self.json_data, "$.name"))
        self.assertIsNone(
            get_field_value(self.json_data, "$.location.detailedAddress.city.id")
        )

    def test_empty_json_data(self):
        self.assertIsNone(get_field_value({}, "$.caseId"))

    def test_invalid_jsonpath(self):
        with self.assertRaises(Exception):
            get_field_value(self.json_data, "$..")
        with self.assertRaises(Exception):
            get_field_value(self.json_data, "$toto")


class TestUpdateJsonValue(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.json_data = load_json_file("./fixtures/json_data_fixture.json")

    def test_update_json_value_single_match(self):
        self.assertEqual(self.json_data["qualification"]["details"]["priority"], "P1")
        update_json_value(self.json_data, "$.qualification.details.priority", "P2")
        self.assertEqual(self.json_data["qualification"]["details"]["priority"], "P2")

    def test_update_json_value_error_case(self):
        with self.assertRaises(Exception):
            update_json_value(self.json_data, "$..", "Invalid")

    def test_update_json_value_several_matches(self):
        self.assertEqual(
            self.json_data["qualification"]["riskThreat"][0]["code"], "R13"
        )
        update_json_value(self.json_data, "$.qualification.riskThreat[*].code", 100)
        for code in self.json_data["qualification"]["riskThreat"]:
            self.assertEqual(code["code"], 100)

    def test_update_json_value_no_match(self):
        try:
            update_json_value(self.json_data, "$.qualification.riskThreat[*].toto", 100)
        except Exception as e:
            self.fail(f"update_json_value raised an exception: {e}")

    @patch("converter.utils.logger")
    def test_update_json_value_logs_error(self, mock_logger):
        with self.assertRaises(Exception):
            update_json_value(self.json_data, "$..", "Invalid")
        mock_logger.error.assert_called_once_with(
            "Error raised in update_json_value: Parse error near the end of string!"
        )


class TestAddToMedicalNotes(unittest.TestCase):
    @patch("converter.utils.random")
    def test_add_to_empty_medical_notes(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8"]

        json_data = {
            "otherKey": "otherValue",
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                    "key2": "value2",
                }
            ],
        }

        expected_medical_notes = [
            {
                "patientId": "fr.health.samuH.ERTYUI.GHK",
                "medicalNoteId": "fr.health.samuH.medicalNote.f5de",
                "freetext": "key 1 label: value1\n...\n",
                "operator": {"role": "AUTRE"},
            },
            {
                "patientId": "fr.health.samuH.ERTYUI.GHK",
                "medicalNoteId": "fr.health.samuH.medicalNote.a3b2",
                "freetext": "key 2 label: value2\n...\n",
                "operator": {"role": "AUTRE"},
            },
        ]

        add_to_medical_notes(
            json_data,
            json_data["patient"][0],
            [
                {"path": "key1", "label": "key 1 label: "},
                {"path": "key2", "label": "key 2 label: "},
            ],
        )

        self.assertEqual(json_data.get("medicalNote"), expected_medical_notes)
        self.assertEqual(len(json_data.get("medicalNote")), 2)

    @patch("converter.utils.random")
    def test_add_to_medical_notes(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8"]
        medical_note = {
            "operator": {"label": "labello", "role": "AMBULANCIER"},
            "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
            "medicalNoteId": "fr.health.samu770.medicalNote.bout1.bout2",
            "creation": "2025-02-27T12:00:00+01:00",
            "freetext": " note 0",
        }

        json_data = {
            "otherKey": "otherValue",
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                    "key2": "value2",
                }
            ],
            "medicalNote": [medical_note],
        }
        expected_medical_notes = [
            {
                "operator": {"label": "labello", "role": "AMBULANCIER"},
                "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                "medicalNoteId": "fr.health.samu770.medicalNote.bout1.bout2",
                "creation": "2025-02-27T12:00:00+01:00",
                "freetext": " note 0",
            },
            {
                "patientId": "fr.health.samuH.ERTYUI.GHK",
                "medicalNoteId": "fr.health.samuH.medicalNote.f5de",
                "freetext": "key 1 label: value1\n...\n",
                "operator": {"role": "AUTRE"},
            },
            {
                "patientId": "fr.health.samuH.ERTYUI.GHK",
                "medicalNoteId": "fr.health.samuH.medicalNote.a3b2",
                "freetext": "key 2 label: value2\n...\n",
                "operator": {"role": "AUTRE"},
            },
        ]

        add_to_medical_notes(
            json_data,
            json_data["patient"][0],
            [
                {"path": "key1", "label": "key 1 label: "},
                {"path": "key2", "label": "key 2 label: "},
            ],
        )

        self.assertEqual(json_data.get("medicalNote"), expected_medical_notes)
        self.assertEqual(len(json_data.get("medicalNote")), 3)


class TestMapToNewValue(unittest.TestCase):
    def test_value_map_to_new_value_with_valid_mapping(self):
        json_data = {"key": "old_value"}
        json_path_to_update = "$.key"
        mapping_value = {"old_value": "new_value", "other_key": "other_value"}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data["key"], "new_value")

    def test_map_to_new_value_with_no_match(self):
        json_data = {"key": "unchanged_value"}
        json_path_to_update = "$.key"
        mapping_value = {"old_value": "new_value", "other_key": "other_value"}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data["key"], "unchanged_value")

    def test_map_to_new_value_with_none_value(self):
        json_data = {"key": "other_value"}
        json_path_to_update = "$.key"
        mapping_value = {"old_value": "new_value"}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data["key"], "other_value")


class TestSetValue(unittest.TestCase):
    def test_set_on_empty_dict(self):
        data = {}
        result = set_value(data, "$.alpha.beta.gamma", 123)
        self.assertEqual(result, 123)
        self.assertEqual(data, {"alpha": {"beta": {"gamma": 123}}})
        self.assertTrue(is_field_completed(data, "$.alpha.beta.gamma"))
        self.assertEqual(get_field_value(data, "$.alpha.beta.gamma"), 123)

    def test_set_on_existing_value(self):
        data = {"alpha": {"beta": {"gamma": 999}}}
        set_value(data, "$.alpha.beta.gamma", 123)
        self.assertEqual(data["alpha"]["beta"]["gamma"], 123)

    def test_creates_missing_intermediate_only(self):
        data = {"alpha": {}}
        set_value(data, "$.alpha.beta.gamma", "x")
        self.assertEqual(data, {"alpha": {"beta": {"gamma": "x"}}})

    def test_partial_path_exists(self):
        data = {"alpha": {"beta": {"other": 1}}}
        set_value(data, "$.alpha.beta.gamma", True)
        self.assertEqual(data["alpha"]["beta"]["gamma"], True)
        self.assertEqual(data["alpha"]["beta"]["other"], 1)

    def test_path_already_exists_with_none(self):
        data = {"alpha": {"beta": {"gamma": None}}}
        set_value(data, "$.alpha.beta.gamma", "new")
        self.assertEqual(data["alpha"]["beta"]["gamma"], "new")

    def test_set_deep_path(self):
        data = {}
        set_value(data, "$.a.b.c.d.e", 5)
        self.assertEqual(get_field_value(data, "$.a.b.c.d.e"), 5)
        self.assertTrue(is_field_completed(data, "$.a.b.c.d"))
        self.assertTrue(is_field_completed(data, "$.a.b.c.d.e"))
