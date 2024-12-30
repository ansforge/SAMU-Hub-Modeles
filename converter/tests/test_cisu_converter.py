import pytest
import json
from pathlib import Path
from jsonschema import validate
from converter.cisu_converter import CISUConverter

def get_json_files(directory):
    """Get all JSON files from the specified directory"""
    path = Path(directory)
    return list(path.glob("*.json"))

def load_json_file(file_path):
    """Load JSON from file"""
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

SCHEMA_DIR = "../src/main/resources/json-schema"  
EDXL_FULL_SCHEMA = load_json_file(f"{SCHEMA_DIR}/EDXL-DE-full.schema.json")
RS_EDA_SCHEMA = load_json_file(f"{SCHEMA_DIR}/RS-EDA.schema.json") 
RC_EDA_SCHEMA = load_json_file(f"{SCHEMA_DIR}/RC-EDA.schema.json")

def conversion_helper(sample_dir, request_base_file, conversion_method, schema, additional_tests_function=None):
    """Helper method to test conversions with schema validation
    
    Args:
        sample_dir: Directory containing sample files
        request_base_file: File containing the request with the envelope
        conversion_method: Method to convert between formats
        schema: JSON schema to validate against
        additional_tests_function: Optional function to run additional tests on the usecase_json output
    """
    usecase_json_files = get_json_files(f"../src/main/resources/sample/examples/{sample_dir}")
    assert len(usecase_json_files) > 0, f"No JSON files found in {sample_dir}"

    # Read the envelope file  
    with open(request_base_file) as f:
        edxl_json = json.load(f)['edxl']

    for usecase_json_file in usecase_json_files:
        print(f"Testing conversion of {usecase_json_file.name}")
        usecase_json = load_json_file(usecase_json_file)

        # Update the message in the envelope with the usecase
        edxl_json['content'][0]['jsonContent']['embeddedJsonContent']['message'].update(usecase_json)

        result = conversion_method(edxl_json)
        # Validate the full EDXL message | ToDo: make a RefResolver work to validate the full EDXL using subschemas
        # validate(instance=result, schema=EDXL_FULL_SCHEMA, resolver=resolver)
        # Validate the usecase inside the EDXL envelope is OK with the target schema
        usecase_name = schema['title']
        usecase_json = result['content'][0]['jsonContent']['embeddedJsonContent']['message'][usecase_name]
        validate(instance=usecase_json, schema=schema)
        
        if additional_tests_function:
            additional_tests_function(usecase_json)

def test_from_cisu_conversion_on_all_samples():
    """
    Test conversion from CISU to Health format for all sample files
    """
    def additiona_health_checks(result):
        assert 'owner' in result

    conversion_helper(
        "RC-EDA",
        "tests/edxl_envelope_fire_to_health.json",
        CISUConverter.from_cisu,
        RS_EDA_SCHEMA,
        additiona_health_checks
    )

def test_to_cisu_conversion_on_all_samples():
    """
    Test conversion from Health to CISU format for all sample files
    """
    conversion_helper(
        "RS-EDA",
        "tests/edxl_envelope_health_to_fire.json",
        CISUConverter.to_cisu,
        RC_EDA_SCHEMA
    )