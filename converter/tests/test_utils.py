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
    extract_message_type_from_message_content,
    switch_field_name,
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


class TestDeletePaths(unittest.TestCase):
    def test_delete_paths(self):
        data = {"a": {"b": {"c": 1, "d": 2}, "e": 3}, "f": 4}

        paths = ["a.b.c", "f"]
        delete_paths(data, paths)

        assert "c" not in data["a"]["b"]
        assert "f" not in data
        assert data["a"]["b"]["d"] == 2

    def test_delete_paths_missing(self):
        data = {"a": {"b": 1}}
        delete_paths(data, ["a.x.y", "z"])
        assert data == {"a": {"b": 1}}

    def test_delete_paths_cleanup(self):
        data = {"a": {"b": {"c": 1}}}
        delete_paths(data, ["a.b.c"])
        assert data == {}  # Empty dictionaries should be cleaned up

    def test_delete_paths_with_list(self):
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

    def test_delete_paths_with_wrong_list(self):
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

    @patch("converter.utils.logger")
    def test_delete_paths_logs_info(self, mock_logger):
        # Arrange
        data = {
            "a": 1,
            "b": {
                "c": 2,
                "d": 3,
            },
        }

        # Act
        delete_paths(data, ["a", "b.c"])

        # Assert logger has been called twice
        assert mock_logger.info.call_count == 2

        # Check the log message content
        first_call_args, _ = mock_logger.info.call_args_list[0]
        second_call_args, _ = mock_logger.info.call_args_list[1]

        assert first_call_args[0] == "Removing path: %s"
        assert first_call_args[1] == "$.a"

        assert second_call_args[0] == "Removing path: %s"
        assert second_call_args[1] == "$.b.c"

    @patch("converter.utils.logger")
    def test_delete_array_logs_info(self, mock_logger):
        # Arrange
        data = {
            "a": [
                {
                    "b": 1,
                },
                {
                    "b": 2,
                    "c": 3,
                },
            ],
        }

        # Act
        delete_paths(data, ["a[].b"])

        # Assert logger has been called twice
        assert mock_logger.info.call_count == 2

        # Check the log message content
        first_call_args, _ = mock_logger.info.call_args_list[0]
        second_call_args, _ = mock_logger.info.call_args_list[1]

        assert first_call_args[0] == "Removing path: %s"
        assert first_call_args[1] == "$.a[0].b"

        assert second_call_args[0] == "Removing path: %s"
        assert second_call_args[1] == "$.a[1].b"

    @patch("converter.utils.logger")
    def test_delete_empty_dict_logs_info(self, mock_logger):
        # Arrange
        data = {
            "a": {
                "b": {
                    "c": 1,
                },
            }
        }

        # Act
        delete_paths(data, ["a.b.c"])

        # Assert logger has been called three times
        assert mock_logger.info.call_count == 3

        # Check the log message content
        first_call_args, _ = mock_logger.info.call_args_list[0]
        second_call_args, _ = mock_logger.info.call_args_list[1]
        third_call_args, _ = mock_logger.info.call_args_list[2]

        assert first_call_args[0] == "Removing path: %s"
        assert first_call_args[1] == "$.a.b.c"

        assert second_call_args[0] == "Removing path: %s"
        assert second_call_args[1] == "$.a.b"

        assert third_call_args[0] == "Removing path: %s"
        assert third_call_args[1] == "$.a"


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

    @patch("converter.utils.logger")
    def test_update_json_value_logs_info(self, mock_logger):
        # Arrange
        data = {"qualification": {"details": {"priority": "P1"}}}

        # Act
        update_json_value(data, "$.qualification.details.priority", "P2")

        # Assert logger has been called
        assert mock_logger.info.call_count == 1

        # Check the log message content
        args, kwargs = mock_logger.info.call_args
        assert args[0] == "Updating value from %s to %s at path $.%s"
        assert args[1] == "P1"
        assert args[2] == "P2"
        assert str(args[3]) == "qualification.details.priority"


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

    @patch("converter.utils.logger")
    def test_add_to_medical_notes_logs_info(self, mock_logger):
        # Arrange
        data = {
            "patient": [
                {
                    "patientId": "fr.health.samuH.ERTYUI.GHK",
                    "key1": "value1",
                }
            ],
            "medicalNote": [],
        }

        # Act
        add_to_medical_notes(
            data,
            data["patient"][0],
            [
                {"path": "key1", "label": "key 1 label: "},
            ],
        )

        # Assert logger has been called
        assert mock_logger.info.call_count == 1

        # Check the log message content
        args, kwargs = mock_logger.info.call_args
        assert args[0] == "Adding field %s to medical notes"
        assert args[1] == "key1"


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

    @patch("converter.utils.logger")
    def test_set_value_logs_info(self, mock_logger):
        # Arrange
        data = {}

        # Act
        set_value(data, "$.a", "b")

        # Assert logger has been called
        assert mock_logger.info.call_count == 1

        # Check the log message content
        args, kwargs = mock_logger.info.call_args
        assert args[0] == "Setting value at path %s"
        assert args[1] == "$.a"


class TestExtractMessageTypeFromMessageContent(unittest.TestCase):
    def test_returns_unknown_when_only_unwanted_keys(self):
        content = {"messageId": "123", "sender": "abc", "status": "active"}
        assert (
            extract_message_type_from_message_content(content) == "unknownMessageType"
        )

    def test_returns_unknown_when_empty_dict(self):
        assert extract_message_type_from_message_content({}) == "unknownMessageType"

    def test_returns_single_allowed_key(self):
        content = {"createCaseHealth": {"foo": "bar"}, "sender": "x"}
        assert extract_message_type_from_message_content(content) == "createCaseHealth"

    def test_returns_first_allowed_key_when_multiple(self):
        content = {
            "createCaseHealth": {},
            "rpis": {},
            "sender": "x",
            "status": "y",
        }
        assert extract_message_type_from_message_content(content) == "createCaseHealth"

    def test_ignores_unwanted_keys_mixed_with_allowed(self):
        content = {
            "messageId": "123",
            "recipient": "abc",
            "createCaseHealth": {},
            "kind": "K",
        }
        assert extract_message_type_from_message_content(content) == "createCaseHealth"

    def test_non_string_values_are_supported(self):
        content = {
            "createCaseHealth": [1, 2, 3],
            "status": "ok",
        }
        assert extract_message_type_from_message_content(content) == "createCaseHealth"


class TestSwitchFieldName(unittest.TestCase):
    def test_switch_field_name(self):
        json_data = {"oldFieldName": "value1", "otherField": "value2"}
        previous_field_name = "oldFieldName"
        new_field_name = "newFieldName"
        previous_field_path = f"$.{previous_field_name}"
        new_field_path = f"$.{new_field_name}"

        self.assertNotIn(new_field_name, json_data)
        self.assertIn(previous_field_name, json_data)

        switch_field_name(json_data, previous_field_path, new_field_path)

        self.assertIn(new_field_name, json_data)
        self.assertEqual(json_data[new_field_name], "value1")
        self.assertNotIn(previous_field_name, json_data)

    def test_switch_field_name_with_nested_field(self):
        json_data = {"parent": {"oldFieldName": "value1"}, "otherField": "value2"}
        previous_field_name = "oldFieldName"
        new_field_name = "newFieldName"
        previous_field_path = f"$.parent.{previous_field_name}"
        new_field_path = f"$.parent.{new_field_name}"

        self.assertNotIn(new_field_name, json_data["parent"])
        self.assertIn(previous_field_name, json_data["parent"])

        switch_field_name(json_data, previous_field_path, new_field_path)

        self.assertIn(new_field_name, json_data["parent"])
        self.assertEqual(json_data["parent"][new_field_name], "value1")
        self.assertNotIn(previous_field_name, json_data["parent"])

    @patch("converter.utils.set_value")
    @patch("converter.utils.delete_paths")
    @patch("converter.utils.logger")
    def test_switch_field_logs_info(
        self, mock_logger, mock_delete_paths, mock_set_value
    ):
        # Arrange
        data = {
            "a": "value1",
        }

        # Act
        switch_field_name(data, "$.a", "$.b")

        # Assert logger has been called
        assert mock_logger.info.call_count == 1

        # Check the log message content
        args, kwargs = mock_logger.info.call_args
        assert args[0] == "Transforming field name from %s to %s"
        assert args[1] == "$.a"
        assert args[2] == "$.b"
