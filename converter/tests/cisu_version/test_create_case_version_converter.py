import unittest

from converter.cisu_version_converters.create_case.create_case_version_converter import (
    CreateCaseVersionConverter,
)
from tests.cisu.helpers import get_edxl_message
from tests.constants import TestConstants
from tests.test_helpers import TestHelper


class TestCreateCaseVersionConverter(unittest.TestCase):
    def setUp(self):
        self.converter = CreateCaseVersionConverter

    def build_message(self, envelope_path: str) -> dict:
        return TestHelper.create_edxl_json_from_sample(
            envelope_path,
            "tests/fixtures/RC-EDA/RC-EDA_exhaustive_fill.json",
        )

    def test_v3_to_vactive_leaves_unmapped_codes_untouched(self):
        message = self.build_message(TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH)
        converted_message = self.converter.convert_v3_to_vactive(message)
        assert converted_message == message

    def test_vactive_to_v3_leaves_unmapped_codes_untouched(self):
        message = self.build_message(TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH)
        converted_message = self.converter.convert_vactive_to_v3(message)
        assert converted_message == message

    # convert_v3_to_vactive mirrors from_rs_to_cisu's mapping direction
    # (2.3 -> 1.9 nomenclature); convert_vactive_to_v3 mirrors from_cisu_to_rs's
    # (1.9 -> 2.3 nomenclature).

    def test_v3_to_vactive_maps_whats_happen(self):
        message = self.build_message(TestConstants.EDXL_HEALTH_TO_FIRE_ENVELOPE_PATH)
        get_edxl_message(message)["createCase"]["qualification"]["whatsHappen"] = {
            "code": "C02.17.00",
            "label": "Ancien libellé",
        }

        result = self.converter.convert_v3_to_vactive(message)

        whats_happen = get_edxl_message(result)["createCase"]["qualification"][
            "whatsHappen"
        ]
        self.assertEqual(whats_happen, {"code": "C10.02.01", "label": "Mort suspecte"})

    def test_vactive_to_v3_maps_whats_happen(self):
        message = self.build_message(TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH)
        get_edxl_message(message)["createCase"]["qualification"]["whatsHappen"] = {
            "code": "C02.05.03",
            "label": "Ancien libellé",
        }

        result = self.converter.convert_vactive_to_v3(message)

        whats_happen = get_edxl_message(result)["createCase"]["qualification"][
            "whatsHappen"
        ]
        self.assertEqual(
            whats_happen,
            {"code": "C02.18.00", "label": "Problème psychiatrique, menace de suicide"},
        )

    def test_vactive_to_v3_removes_risk_threat_mapped_to_none(self):
        message = self.build_message(TestConstants.EDXL_FIRE_TO_HEALTH_ENVELOPE_PATH)
        get_edxl_message(message)["createCase"]["qualification"]["riskThreat"] = [
            {"code": "R36", "label": "Code retiré de la nomenclature"}
        ]

        result = self.converter.convert_vactive_to_v3(message)

        self.assertNotIn(
            "riskThreat", get_edxl_message(result)["createCase"]["qualification"]
        )
