import unittest
from unittest.mock import patch
from converter.v1_v2.utils import add_to_medical_notes, map_to_new_value, reverse_map_to_new_value, switch_field_name, validate_diagnosis_code


class TestSwitchFieldName(unittest.TestCase):
    def test_switch_field_name(self):
            json_data = {
                'oldFieldName': 'value1',
                'otherField': 'value2'
            }
            previous_field_name = 'oldFieldName'
            new_field_name = 'newFieldName'

            self.assertNotIn(new_field_name, json_data)

            switch_field_name(json_data, previous_field_name, new_field_name)

            self.assertIn(new_field_name, json_data)
            self.assertEqual(json_data[new_field_name], 'value1')

class TestReverseMapToNewValue(unittest.TestCase):
    def test_reverse_map_to_new_value_with_valid_mapping(self):
        json_data = {'field': 'value1'}
        json_path_to_update = '$.field'
        mapping_value = {'key1': 'VALUE1', 'key2': 'value2'}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        expected_value = 'key1'
        self.assertEqual(json_data['field'], expected_value)

    def test_reverse_map_to_new_value_with_no_match(self):
        json_data = {'field': 'value3'}
        json_path_to_update = '$.field'
        mapping_value = {'key1': 'value1', 'key2': 'value2'}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        expected_value = 'value3'
        self.assertEqual(json_data['field'], expected_value)

    def test_reverse_map_to_new_value_with_none_value(self):
        json_data = {'field': None}
        json_path_to_update = '$.field'
        mapping_value = {'key1': 'value1', 'key2': 'value2'}

        reverse_map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertIsNone(json_data['field'])


class TestMapToNewValue(unittest.TestCase):
    def test_value_map_to_new_value_with_valid_mapping(self):
        json_data = {'key': 'old_value'}
        json_path_to_update = '$.key'
        mapping_value = {'old_value': 'new_value', 'other_key': 'other_value'}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data['key'], 'new_value')

    def test_map_to_new_value_with_no_match(self):
        json_data = {'key': 'unchanged_value'}
        json_path_to_update = '$.key'
        mapping_value = {'old_value': 'new_value', 'other_key': 'other_value'}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data['key'], 'unchanged_value')

    def test_map_to_new_value_with_none_value(self):
        json_data = {'key': 'other_value'}
        json_path_to_update = '$.key'
        mapping_value = {'old_value': 'new_value'}

        map_to_new_value(json_data, json_path_to_update, mapping_value)

        self.assertEqual(json_data['key'], 'other_value')

class TestAddToMedicalNotes(unittest.TestCase):
    @patch('converter.v1_v2.utils.random')
    def test_add_to_empty_medical_notes(self,mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8"]

        json_data = {
            'otherKey': 'otherValue',
            'patient': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2'}]
        }

        expected_medical_notes=[{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.f5de', 'freetext': 'value1\n...\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.a3b2', 'freetext': 'value2\n...\n', 'operator': {'role': 'AUTRE'}}]

        add_to_medical_notes(json_data, json_data['patient'][0], ['key1','key2'])

        self.assertEqual(json_data.get('medicalNote'), expected_medical_notes)
        self.assertEqual(len(json_data.get('medicalNote')), 2)

    @patch('converter.v1_v2.utils.random')
    def test_add_to_medical_notes(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8"]
        medical_note = {
                "operator": {
                "label": "labello",
                "role": "AMBULANCIER"
                },
                "patientId": "fr.health.samu770.patient.DRFR157702400400055.1",
                "medicalNoteId": "fr.health.samu770.medicalNote.bout1.bout2",
                "creation": "2025-02-27T12:00:00+01:00",
                "freetext": " note 0"
        }

        json_data = {
            'otherKey': 'otherValue',
            'patient': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2'}],
            'medicalNote': [medical_note]
        }
        expected_medical_notes=[{'operator': {'label': 'labello', 'role': 'AMBULANCIER'}, 'patientId': 'fr.health.samu770.patient.DRFR157702400400055.1', 'medicalNoteId': 'fr.health.samu770.medicalNote.bout1.bout2', 'creation': '2025-02-27T12:00:00+01:00', 'freetext': ' note 0'}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.f5de', 'freetext': 'value1\n...\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.a3b2', 'freetext': 'value2\n...\n', 'operator': {'role': 'AUTRE'}}]

        add_to_medical_notes(json_data, json_data['patient'][0], ['key1','key2'])

        self.assertEqual(json_data.get('medicalNote'), expected_medical_notes)
        self.assertEqual(len(json_data.get('medicalNote')), 3)

class TestValidateDiagnosisCode(unittest.TestCase):
    def test_validate_diagnosis_code_no_diagnosis(self):
        json_data = {"otherKey": "value", "patient":[{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2'}]}
        validate_diagnosis_code(json_data,json_data['patient'][0], "otherDiagnosis")
        validate_diagnosis_code(json_data,json_data['patient'][0], "mainDiagnosis")
        self.assertEqual(json_data, {"otherKey": "value", "patient":[{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2'}]})

    @patch('converter.v1_v2.utils.random')
    def test_validate_diagnosis_code_no_correct_code(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8", "f5de", "a3b2"]
        json_data = {"otherKey": "value", "patient":[{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2', "hypothesis": {
                "mainDiagnosis":
                    {"code": "MAUVAISCODE", "label": "Faux code"},

                "otherDiagnosis": [
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                ]
            }}]}
        validate_diagnosis_code(json_data,json_data['patient'][0], "otherDiagnosis")
        validate_diagnosis_code(json_data,json_data['patient'][0], "mainDiagnosis")
        self.assertEqual(len(json_data['medicalNote']), 5)
        self.assertEqual(json_data, {'otherKey': 'value', 'patient': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1': 'value1', 'key2': 'value2'}], 'medicalNote': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.f5de', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.a3b2', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.c9d8', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.f5de', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.a3b2', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}]})

    @patch('converter.v1_v2.utils.random')
    def test_validate_diagnosis_code_correct_codes(self, mock_choices):
        mock_choices.choices.side_effect = ["f5de", "a3b2", "c9d8", "f5de", "a3b2"]
        json_data = {"otherKey": "value", "patient":[{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1':'value1', 'key2':'value2', "hypothesis": {
                "mainDiagnosis":
                    {"code": "E11.9", "label": "correct"},
                "otherDiagnosis": [
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                    {"code": "E11.9", "label": "correct"},
                    {"code": "MAUVAISCODE", "label": "Faux code"},
                    {"code": "E11.9", "label": "correct"},
                ]
            }}]}
        validate_diagnosis_code(json_data,json_data['patient'][0], "otherDiagnosis")
        validate_diagnosis_code(json_data,json_data['patient'][0], "mainDiagnosis")
        self.assertEqual(len(json_data['medicalNote']), 2)
        self.assertEqual(json_data, {'otherKey': 'value', 'patient': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'key1': 'value1', 'key2': 'value2', 'hypothesis': {'mainDiagnosis': {'code': 'E11.9', 'label': 'correct'}, 'otherDiagnosis': [{'code': 'E11.9', 'label': 'correct'}, {'code': 'E11.9', 'label': 'correct'}]}}], 'medicalNote': [{'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.f5de', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}, {'patientId': 'fr.health.samuH.ERTYUI.GHK', 'medicalNoteId': 'fr.health.samuH.medicalNote.a3b2', 'freetext': 'code: MAUVAISCODE\nlabel: Faux code\n', 'operator': {'role': 'AUTRE'}}]})
