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
from converter.cisu_version_converters.create_case.create_case_version_converter import (
    CreateCaseVersionConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper

BASE_MESSAGE_PATH = "tests/fixtures/RC-EDA/RC-EDA_required_fields.json"


@pytest.fixture
def client():
    app.config["TESTING"] = True
    with app.test_client() as client:
        yield client


@patch(
    "converter.conversion_strategy.cisu_version_conversion_strategy.CreateCaseVersionConverter.convert_v3_to_vactive",
    side_effect=CreateCaseVersionConverter.convert_v3_to_vactive,
)
def test_convert_routing_cisu_version_create_case_v3_to_vactive(
    mock_convert_v3_to_vactive, client
):
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, BASE_MESSAGE_PATH
    )

    response = client.post(
        "/convert",
        json={
            "sourceVersion": "v3",
            "targetVersion": "vactive",
            "type": "CISUVersionConversion",
            "edxl": message,
        },
    )

    assert response.status_code == 200
    mock_convert_v3_to_vactive.assert_called_once_with(message)
    assert len(response.json["converted_messages"]) == 1


@patch(
    "converter.conversion_strategy.cisu_version_conversion_strategy.CreateCaseVersionConverter.convert_vactive_to_v3",
    side_effect=CreateCaseVersionConverter.convert_vactive_to_v3,
)
def test_convert_routing_cisu_version_create_case_vactive_to_v3(
    mock_convert_vactive_to_v3, client
):
    message = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH, BASE_MESSAGE_PATH
    )

    response = client.post(
        "/convert",
        json={
            "sourceVersion": "vactive",
            "targetVersion": "v3",
            "type": "CISUVersionConversion",
            "edxl": message,
        },
    )

    assert response.status_code == 200
    mock_convert_vactive_to_v3.assert_called_once_with(message)
    assert len(response.json["converted_messages"]) == 1
