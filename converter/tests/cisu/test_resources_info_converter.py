from converter.cisu.resources_info.resources_info_cisu_converter import (
    ResourcesInfoCISUConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper
from jsonschema import validate

RS_RI_SCHEMA = TestHelper.load_schema("RS-RI.schema.json")


def test_cisu_to_rs_breaking_changes():
    cisu_raw_message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RC-RI/RC-RI_V3.0_exhaustive_fill.json",
    )
    rs_raw_message = ResourcesInfoCISUConverter.from_cisu_to_rs(cisu_raw_message)
    rs_message = ResourcesInfoCISUConverter.copy_rs_input_use_case_content(
        rs_raw_message
    )

    validate(rs_message, RS_RI_SCHEMA)
