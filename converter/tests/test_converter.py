import pytest
from converter.converter import app
from converter.constants import Constants
from .test_helpers import TestHelper

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
    envelope = TestHelper.load_json_file('tests/edxl_envelope_fire_to_health.json')

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

def test_convert_to_cisu(client):
    """Test conversion from Health to CISU format"""
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v3',
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

def test_convert_from_cisu(client):
    """Test conversion from CISU to Health format"""
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RC_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v3',
        'targetVersion': 'v3',
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

def test_convert_from_v1_to_v2(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v1',
        'targetVersion': 'v2',
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 200
    assert 'edxl' in response.json

def test_convert_from_v2_to_v1(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v2',
        'targetVersion': 'v1',
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 200
    assert 'edxl' in response.json

def test_convert_with_invalid_version(client):
    edxl_json = TestHelper.create_edxl_json_from_schema(
        Constants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        Constants.RS_EDA_TAG
    )
    response = client.post('/convert', json={
        'sourceVersion': 'v3',
        'targetVersion': 'v1',
        'edxl': edxl_json,
        'cisuConversion': False
    })

    assert response.status_code == 400
    assert 'Version conversion from v3 to v1 is currently not implemented' in response.json['error']
