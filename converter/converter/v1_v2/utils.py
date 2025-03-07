import random
import string
from typing import Any, Dict, List

from yaml import dump

from converter.utils import get_field_value, is_field_completed, update_json_value

def add_to_medical_notes(json_data: Dict[str, Any], patient: Dict[str, Any],paths: List[str]):
    if not is_field_completed(json_data, '$.medicalNote'):
        json_data['medicalNote'] = []

    for path in paths:
        add_field_to_medical_notes(json_data, patient, path)

def add_field_to_medical_notes(data: Dict[str, Any], patient: Dict[str, Any], path: str):
    field_value = get_field_value(patient, f'$.{path}')

    if field_value == None:
        return

    formatted_field_value = dump(field_value, allow_unicode=True)
    add_object_to_medical_notes(data, patient, formatted_field_value)

def add_object_to_medical_notes(json_data: Dict[str, Any], patient: Dict[str, Any], note_text: str):
    MEDICAL_NOTE_RANDOM_ID_LENGTH = 7
    patient_id = patient["patientId"]
    patient_id_parts = patient_id.split('.')
    health_service_id = '.'.join(patient_id_parts[:3]) # -> fr.health.samuXXX
    random_str = ''.join(random.choices(string.ascii_lowercase + string.digits, k=MEDICAL_NOTE_RANDOM_ID_LENGTH))

    medical_note_id = f'{health_service_id}.medicalNote.{random_str}'

    new_note = {'patientId': patient_id,'medicalNoteId': medical_note_id,'freetext': note_text, 'operator': {"role": "AUTRE"},}

    json_data['medicalNote'].append(new_note)

def map_to_new_value(json_data: Dict[str,Any], json_path: str, mapping_value : Dict[str,str]):
    current_value = get_field_value(json_data, json_path)

    if current_value != None and current_value in mapping_value:
        new_value = mapping_value.get(current_value, current_value)
        update_json_value(json_data, json_path, new_value)

def reverse_get(input_value: str, mapping_value : Dict[str,str]) -> str:
        for key, value in mapping_value.items():
            if value.upper() == input_value.upper():
                return key
        return input_value


def reverse_map_to_new_value(json_data: Dict[str,Any], json_path: str, mapping_value : Dict[str,str]):
    current_value = get_field_value(json_data, json_path)

    if current_value != None:
        new_value = reverse_get(current_value, mapping_value)

        if new_value != current_value:
            update_json_value(json_data, json_path, new_value)

def switch_field_name(json_data: Dict[str, Any], previous_field_name: str, new_field_name: str):
    if is_field_completed(json_data, '$.'+ previous_field_name) == True :
            json_data[new_field_name] = json_data[previous_field_name]
