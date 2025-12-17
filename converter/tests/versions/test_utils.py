import unittest

from converter.versions.utils import (
    reverse_map_to_new_value,
)


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
