from converter.cisu_converter import CISUConverterV3
from .test_helpers import TestHelper

# Load schemas once for all tests
EDXL_FULL_SCHEMA = TestHelper.load_schema("EDXL-DE-full.schema.json")
RS_EDA_SCHEMA = TestHelper.load_schema("RS-EDA.schema.json")
RC_EDA_SCHEMA = TestHelper.load_schema("RC-EDA.schema.json")

def test_from_cisu_conversion():
    """Test conversion from CISU to Health format"""
    def validate_health_format(result):
        assert 'owner' in result, "Health format must contain owner field"

    TestHelper.conversion_tests_runner(
        sample_dir="RC-EDA",
        envelope_file="tests/edxl_envelope_fire_to_health.json",
        converter_method=CISUConverterV3.from_cisu,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=validate_health_format
    )

def test_to_cisu_conversion():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir="RS-EDA",
        envelope_file="tests/edxl_envelope_health_to_fire.json",
        converter_method=CISUConverterV3.to_cisu,
        target_schema=RC_EDA_SCHEMA
    )
