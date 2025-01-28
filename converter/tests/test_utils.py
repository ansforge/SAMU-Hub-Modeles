import pytest
from converter.utils import add_object_to_initial_alert_notes, format_object, delete_paths

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

# ToDo: improve list handling and tests
# def test_format_object_list():
#     result = format_object(["a", "b", "c"])
#     expected = "- a\n- b\n- c"
#     assert result == expected

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

def test_add_note_to_existing_notes():
    output_json = {
        'initialAlert': {
            'notes': [{"freetext": "Existing note"}]
        }
    }
    note_text = "New note"

    add_object_to_initial_alert_notes(output_json, note_text)

    assert {"freetext": "New note"} in output_json['initialAlert']['notes']
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
