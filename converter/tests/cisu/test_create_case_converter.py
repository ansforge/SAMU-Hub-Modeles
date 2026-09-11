import unittest
from unittest.mock import patch
from converter.cisu_transcoders.create_case.create_case_cisu_converter import (
    CreateCaseCISUConverter,
)
from tests.cisu.helpers import get_edxl_message
from tests.constants import TestConstants
from tests.test_helpers import TestHelper
import json
from datetime import datetime

# Load schemas once for all tests
EDXL_FULL_SCHEMA = TestHelper.load_schema("EDXL-DE-full.schema.json")
RS_EDA_SCHEMA = TestHelper.load_schema("RS-EDA.schema.json")
RC_EDA_SCHEMA = TestHelper.load_schema("RC-EDA.schema.json")


def additional_validation(result):
    "Global additional validation (previously validate_health_format)"
    assert "owner" in result, "Health format must contain owner field"
    assert "additionalInformation" in result, (
        "field additionalInformation should be present"
    )
    assert "customMap" in result["additionalInformation"], (
        "field customMap should be present in additionalInformation"
    )
    custom_map_keys = [
        entry["key"] for entry in result["additionalInformation"]["customMap"]
    ]
    assert "initialalert.calltaker.organization" in custom_map_keys, (
        "initialalert.calltaker.organization must be present in customMap"
    )
    assert "qualification.victims.count" in custom_map_keys, (
        "qualification.victims.count must be present in customMap"
    )
    assert "qualification.victims.mainVictim" in custom_map_keys, (
        "qualification.victims.mainVictim must be present in customMap"
    )


def test_from_cisu_conversion_local():
    """Test conversion from CISU to Health format"""

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RC_EDA_TAG,
        envelope_file=TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateCaseCISUConverter.from_cisu_to_rs,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=additional_validation,
    )


def test_to_cisu_conversion_local():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=CreateCaseCISUConverter.from_rs_to_cisu,
        target_schema=RC_EDA_SCHEMA,
    )


def test_from_cisu_conversion_v3():
    """Test conversion from CISU to Health format"""

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RC_EDA_TAG,
        envelope_file=TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
        converter_method=CreateCaseCISUConverter.from_cisu_to_rs,
        target_schema=RS_EDA_SCHEMA,
        additional_validation=additional_validation,
        online_tag="main",  # ToDo: migrate to "v3" once tag is available
    )


def test_to_cisu_conversion_v3():
    """Test conversion from Health to CISU format"""
    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_EDA_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH,
        converter_method=CreateCaseCISUConverter.from_rs_to_cisu,
        target_schema=RC_EDA_SCHEMA,
        online_tag="main",  # ToDo: migrate to "v3" once tag is available
    )


class TestSnapshotCreateCaseConverter:
    edxl_envelope_health_to_fire_path = TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH
    edxl_envelope_fire_to_health_path = TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH
    fixtures_folder_path = "tests/fixtures/"

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.datetime")
    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RS_EDA_exhaustive_message(self, mock_choices, mock_now, snapshot):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RS-EDA/cisu_case/RS-EDA_exhaustive_fill.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_rs_to_cisu(message)
        assert json.dumps(output_data, indent=2) == snapshot

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RC_EDA_exhaustive_message(self, mock_choices, snapshot):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_cisu_to_rs(message)
        assert json.dumps(output_data, indent=2) == snapshot

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.datetime")
    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RS_EDA_required_field_message(
        self, mock_choices, mock_now, snapshot
    ):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path + "RS-EDA/cisu_case/RS-EDA_required_fields.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_rs_to_cisu(message)
        assert json.dumps(output_data, indent=2) == snapshot

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RC_EDA_required_field_message(self, mock_choices, snapshot):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_required_fields.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_cisu_to_rs(message)

        assert json.dumps(output_data, indent=2) == snapshot

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.datetime")
    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RS_EDA_exhaustive_bis_message(
        self, mock_choices, mock_now, snapshot
    ):
        mock_now.now.return_value = datetime(2024, 2, 10, 12, 34, 56)
        mock_now.strftime = datetime.strftime

        mock_choices.choices.return_value = "f5de"

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_health_to_fire_path,
            self.fixtures_folder_path
            + "RS-EDA/cisu_case/RS-EDA_exhaustive_fill_bis.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_rs_to_cisu(message)

        assert json.dumps(output_data, indent=2) == snapshot

    @patch("converter.cisu_transcoders.create_case.create_case_cisu_converter.random")
    def test_snapshot_RC_EDA_exhaustive_bis_message(self, mock_choices, snapshot):
        mock_choices.choices.side_effect = ["f5de7hj", "a3b2YH8", "c9d8jk9", "he9i0kz"]

        message = TestHelper.create_edxl_json_from_sample(
            self.edxl_envelope_fire_to_health_path,
            self.fixtures_folder_path + "RC-EDA/RC-EDA_exhaustive_fill_bis.json",
        )
        converter = CreateCaseCISUConverter

        output_data = converter.from_cisu_to_rs(message)
        assert json.dumps(output_data, indent=2) == snapshot


class TestVictimsCount(unittest.TestCase):
    def setUp(self):
        self.fixtures_folder_path = "tests/fixtures/"
        self.converter = CreateCaseCISUConverter

    def test_count_victims_1(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_1.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients), {"count": "1"}
        )

    def test_count_victims_beaucoup(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_beaucoup.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients),
            {"count": "BEAUCOUP"},
        )

    def test_count_victims_plusieurs(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "patients_list_plusieurs.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients),
            {"count": "PLUSIEURS"},
        )

    def test_count_victims_0(self):
        self.assertEqual(
            self.converter.get_victim_count(self.converter, {"patients": []}),
            {"count": "0"},
        )

    def test_count_victims_no_field(self):
        patients = TestHelper.load_json_file(
            self.fixtures_folder_path + "json_data_fixture.json"
        )

        self.assertEqual(
            self.converter.get_victim_count(self.converter, patients), {"count": "0"}
        )


class TestCustomMap(unittest.TestCase):
    def setUp(self):
        self.fixtures_folder_path = "tests/fixtures/RC-EDA/"
        self.converter = CreateCaseCISUConverter

    def test_initial_calltaker(self):

        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_exhaustive_fill.json",
        )

        result_edxl = self.converter.from_cisu_to_rs(message)
        result = get_edxl_message(result_edxl)["createCaseHealth"]

        custom_map = result["additionalInformation"]["customMap"]
        calltaker_entry = next(
            (
                e
                for e in custom_map
                if e["key"] == "initialalert.calltaker.organization"
            ),
            None,
        )

        self.assertIsNotNone(
            calltaker_entry, "initialalert.calltaker.organization must be in customMap"
        )
        self.assertEqual(calltaker_entry["label"], "Identifiant SDIS")
        self.assertIsNotNone(calltaker_entry["value"])

    def test_victim_count(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_exhaustive_fill.json",
        )

        result_edxl = self.converter.from_cisu_to_rs(message)
        result = get_edxl_message(result_edxl)["createCaseHealth"]

        custom_map = result["additionalInformation"]["customMap"]
        victim_count_entry = next(
            (e for e in custom_map if e["key"] == "qualification.victims.count"),
            None,
        )

        self.assertIsNotNone(
            victim_count_entry, "qualification.victims.count must be in customMap"
        )
        self.assertEqual(victim_count_entry["label"], "Nombre de patients-victimes")
        self.assertIsNotNone(victim_count_entry["value"])

    def test_main_victim(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_exhaustive_fill.json",
        )

        result_edxl = self.converter.from_cisu_to_rs(message)
        result = get_edxl_message(result_edxl)["createCaseHealth"]

        custom_map = result["additionalInformation"]["customMap"]
        main_victim_entry = next(
            (e for e in custom_map if e["key"] == "qualification.victims.mainVictim"),
            None,
        )

        self.assertIsNotNone(
            main_victim_entry, "qualification.victims.mainVictim must be in customMap"
        )
        self.assertEqual(
            main_victim_entry["label"], "Type du patient-victime principal"
        )
        self.assertIsNotNone(main_victim_entry["value"])

    def test_custom_map_cleared_before_custom_map_infos_added(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_exhaustive_fill.json",
        )

        get_edxl_message(message)["createCase"].setdefault("additionalInformation", {})[
            "customMap"
        ] = [
            {"key": "existing.key", "label": "Existing", "value": "val", "freetext": ""}
        ]

        result_edxl = self.converter.from_cisu_to_rs(message)
        custom_map = get_edxl_message(result_edxl)["createCaseHealth"][
            "additionalInformation"
        ]["customMap"]
        self.assertEqual(len(custom_map), 3)
        self.assertEqual(custom_map[0]["key"], "qualification.victims.count")
        self.assertEqual(custom_map[1]["key"], "qualification.victims.mainVictim")
        self.assertEqual(custom_map[2]["key"], "initialalert.calltaker.organization")

    def test_no_additional_information_if_empty_cutom_map_initially(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_required_fields.json",
        )
        result_edxl = self.converter.from_cisu_to_rs(message)
        additional_information = get_edxl_message(result_edxl)["createCaseHealth"].get(
            "additionalInformation"
        )
        self.assertIsNone(additional_information)

    def test_no_additional_information_if_calltaker_not_provided(self):
        message = TestHelper.create_edxl_json_from_sample(
            TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH,
            self.fixtures_folder_path + "RC-EDA_required_fields.json",
        )

        get_edxl_message(message)["createCase"].setdefault("additionalInformation", {})[
            "customMap"
        ] = [
            {"key": "existing.key", "label": "Existing", "value": "val", "freetext": ""}
        ]

        result_edxl = self.converter.from_cisu_to_rs(message)
        custom_map = get_edxl_message(result_edxl)["createCaseHealth"][
            "additionalInformation"
        ]["customMap"]
        self.assertEqual(len(custom_map), 0)


if __name__ == "__main__":
    unittest.main()
