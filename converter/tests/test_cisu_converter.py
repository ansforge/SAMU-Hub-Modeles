import pytest
import json
from pathlib import Path
from jsonschema import validate
from converter.cisu_converter import CISUConverter

def get_json_files(directory):
    """Get all JSON files from the specified directory"""
    path = Path(directory)
    return list(path.glob("RC-EDA-*.json"))

def load_json_file(file_path):
    """Load JSON from file"""
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

def test_forward_conversion_all_samples(health_schema):
    """
    Test conversion from CISU to Health format for all sample files
    
    Args:
        health_schema: Fixture containing Health JSON schema
    """
    # Get all sample JSON files
    sample_dir = "../src/main/resources/sample/examples/RC-EDA"
    json_files = get_json_files(sample_dir)
    
    assert len(json_files) > 0, f"No JSON files found in {sample_dir}"
    
    for json_file in json_files:
        print(f"Testing conversion of {json_file.name}")
        
        # Load input JSON
        cisu_input = load_json_file(json_file)
        
        # Convert CISU to Health format
        result = CISUConverter.forward(cisu_input)
        
        # Validate against Health schema
        validate(instance=result, schema=health_schema)
        
        # Check owner field
        assert 'owner' in result
        assert result['owner'] == 'fr.health.samu950'

@pytest.fixture
def health_schema():
    """Fixture for Health JSON schema"""
    schema_path = "../src/main/resources/json-schema/RS-EDA.schema.json"
    return load_json_file(schema_path) 