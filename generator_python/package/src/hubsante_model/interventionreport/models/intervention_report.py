# coding: utf-8

"""
    OpenAPI

    OpenAPI

    The version of the OpenAPI document: 0.0.1
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from datetime import datetime
from pydantic import BaseModel, ConfigDict, Field, StrictStr, field_validator
from typing import Any, ClassVar, Dict, List, Optional
from typing_extensions import Annotated
from hubsante_model.interventionreport.models.evaluation import Evaluation
from hubsante_model.interventionreport.models.patient import Patient
from hubsante_model.interventionreport.models.redactor import Redactor
from typing import Optional, Set
from typing_extensions import Self

class InterventionReport(BaseModel):
    """
    InterventionReport
    """ # noqa: E501
    case_id: Annotated[str, Field(strict=True)] = Field(description="Identifiant partagé du dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l'ensemble des systèmes : le numéro de dossier fourni par celui qui génère l'identifiant partagé doit donc être un numéro unique dans son système.", alias="caseId")
    report_id: StrictStr = Field(description="Identifiant du bilan du logiciel SMUR", alias="reportId")
    redactor: Redactor
    creation: str = Field(description="s'exprime au format ISO 8601 YYY-MM-DDThh:mm:ss")
    patient: Patient
    evaluation: Optional[Evaluation] = None
    __properties: ClassVar[List[str]] = ["caseId", "reportId", "redactor", "creation", "patient", "evaluation"]

    @field_validator('case_id')
    def case_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^fr(\.[\w-]+){3,4}$", value):
            raise ValueError(r"must validate the regular expression /^fr(\.[\w-]+){3,4}$/")
        return value

    @field_validator('creation')
    def creation_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    model_config = ConfigDict(
        populate_by_name=True,
        validate_assignment=True,
        protected_namespaces=(),
    )


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Optional[Self]:
        """Create an instance of InterventionReport from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of redactor
        if self.redactor:
            _dict['redactor'] = self.redactor.to_dict()
        # override the default output from pydantic by calling `to_dict()` of patient
        if self.patient:
            _dict['patient'] = self.patient.to_dict()
        # override the default output from pydantic by calling `to_dict()` of evaluation
        if self.evaluation:
            _dict['evaluation'] = self.evaluation.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of InterventionReport from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "caseId": obj.get("caseId"),
            "reportId": obj.get("reportId"),
            "redactor": Redactor.from_dict(obj["redactor"]) if obj.get("redactor") is not None else None,
            "creation": obj.get("creation"),
            "patient": Patient.from_dict(obj["patient"]) if obj.get("patient") is not None else None,
            "evaluation": Evaluation.from_dict(obj["evaluation"]) if obj.get("evaluation") is not None else None
        })
        return _obj


