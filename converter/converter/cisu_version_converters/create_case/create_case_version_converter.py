from typing import Any, Dict

from converter.cisu_transcoders.create_case.create_case_cisu_constants import (
    CreateCaseCISUConstants,
)
from converter.cisu_version_converters.base_cisu_version_converter import (
    BaseCISUVersionConverter,
)
from converter.nomenclatures.utils import (
    apply_nomenclature_mapping,
    apply_nomenclature_mapping_to_list,
)
from converter.nomenclatures.from_v1_9_to_v2_3.whats_happen import (
    V1_9_TO_V2_3_WHATS_HAPPEN_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.health_motive import (
    V1_9_TO_V2_3_HEALTH_MOTIVE_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.risk_threat import (
    V1_9_TO_V2_3_RISK_THREAT_MAP,
)
from converter.nomenclatures.from_v1_9_to_v2_3.location_kind import (
    V1_9_TO_V2_3_LOCATION_KIND_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.whats_happen import (
    V2_3_TO_V1_9_WHATS_HAPPEN_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.health_motive import (
    V2_3_TO_V1_9_HEALTH_MOTIVE_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.risk_threat import (
    V2_3_TO_V1_9_RISK_THREAT_MAP,
)
from converter.nomenclatures.from_v2_3_to_v1_9.location_kind import (
    V2_3_TO_V1_9_LOCATION_KIND_MAP,
)


class CreateCaseVersionConverter(BaseCISUVersionConverter):
    @classmethod
    def get_message_type(cls) -> str:
        return "createCase"

    @classmethod
    def convert_v3_to_vactive(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        def apply_qualification_nomenclature_mappings(json_data: Dict[str, Any]):
            for qualification_path in (
                CreateCaseCISUConstants.QUALIFICATION_PATH,
                CreateCaseCISUConstants.INITIAL_ALERT_QUALIFICATION_PATH,
            ):
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.whatsHappen",
                    V2_3_TO_V1_9_WHATS_HAPPEN_MAP,
                )
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.healthMotive",
                    V2_3_TO_V1_9_HEALTH_MOTIVE_MAP,
                )
                apply_nomenclature_mapping_to_list(
                    json_data,
                    f"{qualification_path}.riskThreat",
                    V2_3_TO_V1_9_RISK_THREAT_MAP,
                )
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.locationKind",
                    V2_3_TO_V1_9_LOCATION_KIND_MAP,
                )

        output_json = cls.copy_input_content(edxl_json)
        output_use_case_json = cls.copy_input_use_case_content(edxl_json)

        apply_qualification_nomenclature_mappings(output_use_case_json)

        return cls.format_output_json(output_json, output_use_case_json)

    @classmethod
    def convert_vactive_to_v3(cls, edxl_json: Dict[str, Any]) -> Dict[str, Any]:
        def apply_qualification_nomenclature_mappings(json_data: Dict[str, Any]):
            for qualification_path in (
                CreateCaseCISUConstants.QUALIFICATION_PATH,
                CreateCaseCISUConstants.INITIAL_ALERT_QUALIFICATION_PATH,
            ):
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.whatsHappen",
                    V1_9_TO_V2_3_WHATS_HAPPEN_MAP,
                )
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.healthMotive",
                    V1_9_TO_V2_3_HEALTH_MOTIVE_MAP,
                )
                apply_nomenclature_mapping_to_list(
                    json_data,
                    f"{qualification_path}.riskThreat",
                    V1_9_TO_V2_3_RISK_THREAT_MAP,
                )
                apply_nomenclature_mapping(
                    json_data,
                    f"{qualification_path}.locationKind",
                    V1_9_TO_V2_3_LOCATION_KIND_MAP,
                )

        output_json = cls.copy_input_content(edxl_json)
        output_use_case_json = cls.copy_input_use_case_content(edxl_json)

        apply_qualification_nomenclature_mappings(output_use_case_json)

        return cls.format_output_json(output_json, output_use_case_json)
