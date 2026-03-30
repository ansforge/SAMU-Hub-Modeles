from unittest.mock import patch, MagicMock

from converter.cisu.resources_status.resources_status_converter import (
    ResourcesStatusConverter,
)
from converter.cisu.resources_info.resources_info_cisu_constants import (
    ResourcesInfoCISUConstants,
)


def build_valid_edxl(case_id="CASE123"):
    # we just need the mandatory path here
    return {
        "content": [
            {
                "jsonContent": {
                    "embeddedJsonContent": {
                        "message": {"resourcesStatus": {"caseId": case_id}}
                    }
                }
            }
        ]
    }


def test_from_rs_to_cisu_happy_path():
    edxl_json = build_valid_edxl()

    mock_rs_ri = MagicMock()
    mock_rs_ri.payload = {"ri": "data"}

    mock_rs_sr_1 = MagicMock()
    mock_rs_sr_1.payload = {"sr": "data1"}

    mock_rs_sr_2 = MagicMock()
    mock_rs_sr_2.payload = {"sr": "data2"}

    merged_rs_ri = {"merged": "rs_ri"}
    expected_result = {"final": "rc_ri"}

    def mock_get_field_value(input_data, path):
        if path == "$.caseId":
            return "CASE123"
        if path == "$.resource":
            return {"ri": "data"}
        return None

    with (
        patch(
            "converter.cisu.resources_status.resources_status_converter.get_last_rs_ri_by_case_id",
            return_value=mock_rs_ri,
        ) as mock_get_ri,
        patch(
            "converter.cisu.resources_status.resources_status_converter.get_last_rs_sr_per_resource_by_case_id",
            return_value=[mock_rs_sr_1, mock_rs_sr_2],
        ) as mock_get_sr,
        patch(
            "converter.cisu.resources_status.resources_status_converter.get_field_value",
            side_effect=mock_get_field_value,
        ) as mock_get_field,
        patch(
            "converter.cisu.resources_status.resources_status_converter.set_value"
        ) as mock_set_value,
        patch(
            "converter.cisu.resources_status.resources_status_converter.merge_info_and_resources",
            return_value=merged_rs_ri,
        ) as mock_merge,
        patch(
            "converter.cisu.resources_status.resources_status_converter.ResourcesInfoCISUConverter.from_rs_to_cisu",
            return_value=expected_result,
        ) as mock_convert,
        patch(
            "converter.cisu.resources_status.resources_status_converter.ResourcesStatusConverter.copy_rs_input_use_case_content",
            side_effect=lambda x: x,
        ),
        patch(
            "converter.cisu.resources_status.resources_status_converter.ResourcesInfoCISUConverter.copy_rs_input_use_case_content",
            side_effect=lambda x: x,
        ),
    ):
        result = ResourcesStatusConverter.from_rs_to_cisu(edxl_json)

        assert result == expected_result

        mock_get_ri.assert_called_once_with("CASE123")
        mock_get_sr.assert_called_once_with("CASE123")

        mock_get_field.assert_any_call(mock_rs_ri.payload, "$.resource")

        mock_merge.assert_called_once_with(
            {"ri": "data"}, [{"sr": "data1"}, {"sr": "data2"}]
        )

        mock_set_value.assert_called_once_with(
            mock_rs_ri.payload,
            ResourcesInfoCISUConstants.RESOURCE_PATH,
            merged_rs_ri,
        )

        mock_convert.assert_called_once_with(mock_rs_ri.payload)


def test_from_rs_to_cisu_no_rs_ri():
    edxl_json = build_valid_edxl()

    with patch(
        "converter.cisu.resources_status.resources_status_converter.get_last_rs_ri_by_case_id",
        return_value=None,
    ):
        result = ResourcesStatusConverter.from_rs_to_cisu(edxl_json)
        assert result == []
