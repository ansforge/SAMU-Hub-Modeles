import unittest

from converter.versions.utils import (
    reverse_map_to_new_value,
    switch_field_name,
)


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


class TestReverseMapToNewValue(unittest.TestCase):
    def test_reverse_map_to_new_value_with_valid_mapping(self):
        json_data = {"field": "value1"}
        json_path_to_update = "$.field"
        mapping_value = {"key1": "VALUE1", "key2": "value2"}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        expected_value = "key1"
        self.assertEqual(json_data["field"], expected_value)

    def test_reverse_map_to_new_value_with_no_match(self):
        json_data = {"field": "value3"}
        json_path_to_update = "$.field"
        mapping_value = {"key1": "value1", "key2": "value2"}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        expected_value = "value3"
        self.assertEqual(json_data["field"], expected_value)

    def test_reverse_map_to_new_value_with_none_value(self):
        json_data = {"field": None}
        json_path_to_update = "$.field"
        mapping_value = {"key1": "value1", "key2": "value2"}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertIsNone(json_data["field"])
