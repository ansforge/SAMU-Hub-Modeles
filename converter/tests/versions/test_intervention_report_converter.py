from converter.versions.intervention_report.intervention_report_converter import (
    InterventionReportConverter,
)
from tests.constants import TestConstants
from tests.test_helpers import TestHelper, get_file_endpoint
from jsonschema import validate


def get_v3_schema():
    v3_schema_endpoint = get_file_endpoint(
        TestConstants.V3_GITHUB_TAG, TestConstants.RS_BPV_TAG
    )
    return TestHelper.load_json_file_online(v3_schema_endpoint)


def get_v2_schema():
    v2_schema_endpoint = get_file_endpoint(
        TestConstants.V2_GITHUB_TAG, TestConstants.RS_BPV_TAG
    )
    return TestHelper.load_json_file_online(v2_schema_endpoint)


def test_v2_to_v3_upgrade():
    v3_schema = get_v3_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_BPV_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=InterventionReportConverter.convert_v2_to_v3,
        target_schema=v3_schema,
        online_tag=TestConstants.V2_GITHUB_TAG,
    )


def test_v3_to_v2_downgrade():
    v2_schema = get_v2_schema()

    TestHelper.conversion_tests_runner(
        sample_dir=TestConstants.RS_BPV_TAG,
        envelope_file=TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        converter_method=InterventionReportConverter.convert_v3_to_v2,
        target_schema=v2_schema,
        online_tag=TestConstants.V3_GITHUB_TAG,
    )


def test_add_to_evaluation_freetext_with_empty_value():
    input_json = {"evaluation": {}}
    InterventionReportConverter.add_to_evaluation_freetext(input_json, "test")

    assert input_json["evaluation"]["freetext"] == ["test"]


def test_add_to_evaluation_freetext_with_existing_values():
    input_json = {"evaluation": {"freetext": ["existing"]}}
    InterventionReportConverter.add_to_evaluation_freetext(input_json, "test")

    assert input_json["evaluation"]["freetext"] == ["existing", "test"]


def test_v2_to_v3_upgrade_breaking_changes():
    message_raw_v2 = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-BPV/RS-BPV_V2.0_breaking_changes_to_V3.0.json",
    )
    message_raw_v3 = InterventionReportConverter.convert_v2_to_v3(message_raw_v2)
    message_v3 = InterventionReportConverter.copy_input_use_case_content(message_raw_v3)
    message_v2 = InterventionReportConverter.copy_input_use_case_content(message_raw_v2)

    validate(message_v2, get_v2_schema())
    validate(message_v3, get_v3_schema())


def test_v3_to_v2_upgrade_breaking_changes():
    message_raw_v3 = TestHelper.create_edxl_json_from_sample(
        TestConstants.EDXL_HEALTH_TO_HEALTH_ENVELOPE_PATH,
        "tests/fixtures/RS-BPV/RS-BPV_V3.0_breaking_changes_to_V2.0.json",
    )
    message_raw_v2 = InterventionReportConverter.convert_v3_to_v2(message_raw_v3)
    message_v2 = InterventionReportConverter.copy_input_use_case_content(message_raw_v2)
    message_v3 = InterventionReportConverter.copy_input_use_case_content(message_raw_v3)

    validate(message_v3, get_v3_schema())
    validate(message_v2, get_v2_schema())

    expected_freetext = [
        message_v3["evaluation"]["freetext"][0],
        "Rôle du rédacteur: PILOTE",
        "Diagnostic(s) associé(s) supplémentaire(s): O22, O23",
        "Précision du paramètre TEMPERATURE: + ou - 1°C",
        "Précision du paramètre FREQUENCE_RESPIRATOIRE: au repos",
        "Source de l'identifiant externe patient 123456789: AUTRE",
    ]

    assert expected_freetext == message_v2["evaluation"]["freetext"]
