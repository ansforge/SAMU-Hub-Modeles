from converter.cisu.utils import add_object_to_initial_alert_notes


def test_add_note_to_existing_notes():
    output_json = {"initialAlert": {"notes": [{"freetext": "Existing note"}]}}
    note_text = "New note"

    add_object_to_initial_alert_notes(output_json, note_text)

    assert {"freetext": "New note"} in output_json["initialAlert"]["notes"]
    assert {"freetext": "Existing note"} in output_json["initialAlert"]["notes"]
    assert len(output_json["initialAlert"]["notes"]) == 2


def test_add_note_to_empty_notes():
    output_json = {"initialAlert": {"otherField": "value"}}
    note_text = "New note"

    add_object_to_initial_alert_notes(output_json, note_text)

    assert {"freetext": "New note"} in output_json["initialAlert"]["notes"]
    assert len(output_json["initialAlert"]["notes"]) == 1
