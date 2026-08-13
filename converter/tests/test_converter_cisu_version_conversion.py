"""Wiring test for the /convert endpoint, CISUVersionConversion type,
createCase message.

The nomenclature-mapping business logic itself (unmapped / mapped-to-value /
mapped-to-None, for every qualification field and direction) is covered at
the converter-class level in tests/cisu_version/test_create_case_version_converter.py,
which is far cheaper to run than a full HTTP round-trip and does not need
the Flask app. This module only proves that POST /convert actually routes a
CISUVersionConversion request for a createCase message to
CreateCaseVersionConverter.convert with the right arguments -- the part the
class-level tests can't see.
"""

from unittest.mock import patch

import pytest

from converter.converter import app
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

BASE_MESSAGE_PATH = "tests/fixtures/RC-EDA/RC-EDA_required_fields.json"


@pytest.fixture
def client():
    app.config["TESTING"] = True
    with app.test_client() as client:
        yield client


@pytest.mark.parametrize(
    "source_version, target_version",
    [("v3", "vactive"), ("vactive", "v3")],
)
@patch(
    "converter.conversion_strategy.cisu_version_conversion_strategy.CreateCaseVersionConverter.convert"
)
def test_convert_endpoint_routes_cisu_version_conversion_to_create_case_version_converter(
    mock_convert, client, source_version, target_version
):
    mock_convert.return_value = {"fake": "converted-message"}
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, BASE_MESSAGE_PATH
    )

    response = client.post(
        "/convert",
        json={
            "sourceVersion": source_version,
            "targetVersion": target_version,
            "type": "CISUVersionConversion",
            "edxl": message,
        },
    )

    assert response.status_code == 200
    mock_convert.assert_called_once_with(source_version, target_version, message)
    assert response.json["converted_messages"] == [{"fake": "converted-message"}]
