import pytest
from converter.converter import app
from converter.constants import Constants
from tests.test_helpers import TestHelper

@pytest.fixture
def client():
    """Create a test client"""
    app.config['TESTING'] = True
    with app.test_client() as client:
        yield client

def test_convert_invalid_content_type(client):
    """Test sending request with invalid content type"""
    response = client.post('/convert', data='not json')
    assert response.status_code == 400
    assert response.json['error'] == 'Content-Type must be application/json'

def test_convert_missing_required_fields(client):
    """Test sending request without required fields"""
    response = client.post('/convert', json={})
    assert response.status_code == 400
    assert 'Missing required fields' in response.json['error']

def test_convert_cisu_invalid_direction(client):
    """Test sending request with both sender and recipient as health"""
    # Load base envelope
    envelope = TestHelper.load_json_file(Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH)

    # Modify sender to be health
    envelope['edxl']['senderID'] = 'fr.health.test'

    response = client.post('/convert', json={
        'sourceVersion': 'v3',
        'targetVersion': 'v3',
        'edxl': envelope['edxl'],
        'cisuConversion': True
    })
    assert response.status_code == 400
    assert 'Both sender and recipient are health' in response.json['error']

def test_convert_version_with_invalid_source_version(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v4',
        'targetVersion': 'v1',
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 400
    assert "Unknown source version" in response.json['error']

def test_convert_version_with_invalid_target_version(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v1',
        'targetVersion': 'v4',
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 400
    assert "Unknown target version" in response.json['error']

@pytest.mark.parametrize("source_version,target_version", [
    ("v1", "v2"),
    ("v2", "v1"),
    ("v2", "v3"),
    ("v3", "v2"),
    ("v3", "v1"),
    ("v1", "v3"),
])
def test_convert_edxl_versions(client, source_version, target_version):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': source_version,
        'targetVersion': target_version,
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 200
    assert 'edxl' in response.json

@pytest.mark.parametrize("rs_target_version", [
    ("v1"),
    ("v2"),
    ("v3"),
])
def test_convert_from_cisu(client,rs_target_version):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RC_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v3',
        'targetVersion': rs_target_version,
        'edxl': edxl_json,
        'cisuConversion': True
    })

    # Verify response
    assert response.status_code == 200
    assert 'edxl' in response.json

    # Verify message is converted
    message = response.json['edxl']['content'][0]['jsonContent']['embeddedJsonContent']['message']
    assert 'createCaseHealth' in message
    assert 'createCase' not in message

@pytest.mark.parametrize("rs_source_version", [
    ("v1"),
    ("v2"),
    ("v3"),
])
def test_convert_to_cisu(client,rs_source_version):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': rs_source_version,
        'targetVersion': 'v3',
        'edxl': edxl_json,
        'cisuConversion': True
    })

    # Verify response
    assert response.status_code == 200
    assert 'edxl' in response.json

    # Verify converted is converted
    message = response.json['edxl']['content'][0]['jsonContent']['embeddedJsonContent']['message']
    assert 'createCase' in message
    assert 'createCaseHealth' not in message

def test_convert_to_cisu_with_invalid_cisu_target_version(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v1',
        'targetVersion': 'v2',
        'edxl': edxl_json,
        'cisuConversion': True
    })

    assert response.status_code == 400
    assert "Unknown target version" in response.json['error']

def test_convert_to_cisu_with_invalid_cisu_source_version(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RC_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v2',
        'targetVersion': 'v1',
        'edxl': edxl_json,
        'cisuConversion': True
    })

    assert response.status_code == 400
    assert "Unknown source version" in response.json['error']


def test_health_endpoint(client):
    response = client.get('/health')
    expected_response = {
        "status": "UP",
    }

    assert response.status_code == 200
    assert  expected_response == response.json
