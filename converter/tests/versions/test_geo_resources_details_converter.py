from converter.versions.geo_resources_details.geo_resources_details_converter import (
    GeoResourcesDetailsConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint


def test_v2_to_v3_upgrade():
    v3_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.GEO_RES_TAG
    )
    v3_schema = TestHelper.load_json_file_online(v3_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.GEO_RES_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=GeoResourcesDetailsConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


def test_v3_to_v2_downgrade():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.GEO_RES_TAG
    )
    v2_schema = TestHelper.load_json_file_online(v2_schema_endpoint)

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.GEO_RES_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=GeoResourcesDetailsConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )


def test_v2_to_v3_upgrade_with_ship_mobility():
    message_raw_v2 = {
        "content": [
            {
                "jsonContent": {
                    "embeddedJsonContent": {
                        "message": {
                            "geoResourcesDetails": {
                                "resource": [
                                    {
                                        "mobility": "SHIP ",
                                    },
                                    {
                                        "mobility": "VEHICLE",
                                    },
                                    {
                                        "mobility": "SHIP ",
                                    },
                                ]
                            }
                        }
                    }
                }
            }
        ]
    }

    message_raw_v3 = GeoResourcesDetailsConverter.convert_v2_to_v3(message_raw_v2)
    message_v3 = message_raw_v3["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]
    resources_v3 = message_v3["geoResourcesDetails"]["resource"]

    assert resources_v3[0]["mobility"] == "SHIP"
    assert resources_v3[1]["mobility"] == "VEHICLE"
    assert resources_v3[2]["mobility"] == "SHIP"


def test_v3_to_v2_upgrade_with_ship_mobility():
    message_raw_v3 = {
        "content": [
            {
                "jsonContent": {
                    "embeddedJsonContent": {
                        "message": {
                            "geoResourcesDetails": {
                                "resource": [
                                    {
                                        "mobility": "SHIP",
                                    },
                                    {
                                        "mobility": "VEHICLE",
                                    },
                                    {
                                        "mobility": "SHIP",
                                    },
                                ]
                            }
                        }
                    }
                }
            }
        ]
    }

    message_raw_v2 = GeoResourcesDetailsConverter.convert_v3_to_v2(message_raw_v3)
    message_v2 = message_raw_v2["content"][0]["jsonContent"]["embeddedJsonContent"][
        "message"
    ]
    resources_v2 = message_v2["geoResourcesDetails"]["resource"]

    assert resources_v2[0]["mobility"] == "SHIP "
    assert resources_v2[1]["mobility"] == "VEHICLE"
    assert resources_v2[2]["mobility"] == "SHIP "
