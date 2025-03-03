from typing import Any, Dict, List

from yaml import dump

from converter.utils import get_field_value, is_field_completed

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
    patient_id = patient["patientId"]
    patient_id_parts = patient_id.split('.')
    health_service_id = '.'.join(patient_id_parts[:3])
    random_string_1 = patient_id_parts[-2]
    random_string_2 = patient_id_parts[-1]
    medical_note_id = f'{health_service_id}.medicalNote.{random_string_1}.{random_string_2}'

    new_note = {'patientId': patient_id,'medicalNoteId': medical_note_id,'freetext': note_text, 'operator': {"role": "AUTRE"},}

    json_data['medicalNote'].append(new_note)
    print(json_data['medicalNote'])
