import pytest
from converter.utils import add_object_to_initial_alert_notes, concatenate_values, get_field_value, is_field_completed, format_object, delete_paths, translate_key_words
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
    data = {
        "a": {
            "b": {
                "c": 1,
                "d": 2
            },
            "e": 3
        },
        "f": 4
    }

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
    translation_mapping = {
        "translate":"change",
        "this": "that ",
        "a ": "one"
    }
    input_text = 'thisis a random string totranslate'
    output_text = translate_key_words(input_text, translation_mapping)
    assert output_text == 'that is onerandom string tochange'

def test_concatenate():
    data = {
        "key1": "this",
        "key2": "should",
        "key3": {
            "subkey1": "form",
            "subkey2": "a",
            "subkey3": "complete"
        },
        "key4": "sentence",
    }

    assert concatenate_values(data) == " this should form a complete sentence"

def test_empty_concatenate():
    data = {}

    assert concatenate_values(data) == ""

def test_add_note_to_existing_notes():
    output_json = {
        'initialAlert': {
            'notes': [{"freetext": "Existing note"}]
        }
    }
    note_text = "New note"

    add_object_to_initial_alert_notes(output_json, note_text)

    assert {"freetext": "New note"} in output_json['initialAlert']['notes']
    assert {"freetext": "Existing note"} in output_json['initialAlert']['notes']
    assert len(output_json['initialAlert']['notes']) == 2

def test_add_note_to_empty_notes():
    output_json = {
        'initialAlert': {
            'otherField': 'value'
        }
    }
    note_text = "New note"

    add_object_to_initial_alert_notes(output_json, note_text)

    assert {"freetext": "New note"} in output_json['initialAlert']['notes']
    assert len(output_json['initialAlert']['notes']) == 1

class TestIsFieldCompleted(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.json_data = load_json_file("./fixtures/json_data_fixture.json")

    def test_existing_path(self):
         self.assertTrue(is_field_completed(self.json_data, "$.caseId"))
         self.assertTrue(is_field_completed(self.json_data, "$.location.detailedAddress.wayName.type"))
         self.assertTrue(is_field_completed(self.json_data, "$.qualification.riskThreat[0].label"))
         self.assertTrue(is_field_completed(self.json_data, "$.qualification.riskThreat[0]"))
         self.assertTrue(is_field_completed(self.json_data, "$.qualification.riskThreat"))
         self.assertTrue(is_field_completed(self.json_data, "$.qualification"))
         self.assertTrue(is_field_completed(self.json_data, "$.qualification.healthMotive"))

    def test_non_existing_path(self):
        self.assertFalse(is_field_completed(self.json_data, "$.caseId.name"))
        self.assertFalse(is_field_completed(self.json_data, "$.name"))
        self.assertFalse(is_field_completed(self.json_data, "$.location.detailedAddress.city.id"))

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
        self.assertEqual(get_field_value(self.json_data, "$.caseId"), "fr.health.samu770.DRFR154878900236")
        self.assertEqual(get_field_value(self.json_data, "$.location.detailedAddress.wayName.type"), "Rue")
        self.assertEqual(get_field_value(self.json_data, "$.qualification.riskThreat[0].label"), "Risque d'explosion, présence de gaz")
        self.assertEqual(get_field_value(self.json_data, "$.qualification.riskThreat[1].label"), "Risque d'incendie")
        self.assertEqual(get_field_value(self.json_data, "$.qualification.riskThreat[0]"), { "code": "R13", "label": "Risque d'explosion, présence de gaz" })
        self.assertEqual(get_field_value(self.json_data, "$.qualification.riskThreat[*]"),[
                { "code": "R13", "label": "Risque d'explosion, présence de gaz" },
                { "code": "R12", "label": "Risque d'incendie" }
                ])
        self.assertEqual(get_field_value(self.json_data, "$.qualification"), {
                "whatsHappen": { "code": "C09.03.00", "label": "Fuite de gaz" },
                "locationKind": {
                "code": "L01.01.01",
                "label": "Maison particulière, pavillon, à l'intérieur"
                },
                "riskThreat": [
                { "code": "R13", "label": "Risque d'explosion, présence de gaz" },
                { "code": "R12", "label": "Risque d'incendie" }
                ],
                "healthMotive": {
                "code": "M03.10",
                "label": "Malaise avec perte de connaissance initiale"
                },
                "details": { "priority": "P1" }
            })

    def test_non_existing_path(self):
        self.assertIsNone(get_field_value(self.json_data, "$.caseId.name"))
        self.assertIsNone(get_field_value(self.json_data, "$.name"))
        self.assertIsNone(get_field_value(self.json_data, "$.location.detailedAddress.city.id"))

    def test_empty_json_data(self):
        self.assertIsNone(get_field_value({}, "$.caseId"))

    def test_invalid_jsonpath(self):
        with self.assertRaises(Exception):
            get_field_value(self.json_data, "$..")
        with self.assertRaises(Exception):
            get_field_value(self.json_data, "$toto")


if __name__ == "__main__":
    unittest.main()
