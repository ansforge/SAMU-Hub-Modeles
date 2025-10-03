import pytest
from converter.versions.identical_message_converter import IdenticalMessageConverter

mock_message = {"error": { "code": 500 }}
test_cases = [
    ("v1", "v2", mock_message),
    ("v2", "v1", mock_message),
    ("v2", "v3", mock_message),
    ("v3", "v2", mock_message),
    ("v1", "v3", mock_message),
    ("v3", "v1", mock_message),
]

@pytest.mark.parametrize("source_version,target_version,expected", test_cases)
def test_conversion(source_version, target_version, expected):
    initial_message = {"error": { "code": 500 }}
    converted_message = IdenticalMessageConverter.convert(source_version, target_version, initial_message)
    assert converted_message == expected
