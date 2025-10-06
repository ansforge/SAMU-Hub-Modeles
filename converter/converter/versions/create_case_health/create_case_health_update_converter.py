from converter.versions.create_case_health.create_case_health_converter import (
    CreateHealthCaseConverter,
)


class CreateHealthUpdateCaseConverter(CreateHealthCaseConverter):
    ## RS-EDA-MAJ messages conversion rules are identical to CreateHealthCaseConverter (RS-EDA messages).
    @staticmethod
    def get_message_type():
        return "createCaseHealthUpdate"
