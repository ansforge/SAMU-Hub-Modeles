# coding: utf-8

"""
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import Any, ClassVar, Dict, List, Optional
from pydantic import BaseModel, field_validator
from pydantic import Field
from typing_extensions import Annotated
from hubsanteModel.health.models.administrative_file import AdministrativeFile
from hubsanteModel.health.models.health_motive import HealthMotive
from hubsanteModel.health.models.hypothesis import Hypothesis
from hubsanteModel.health.models.identity import Identity
from hubsanteModel.health.models.patient_detail import PatientDetail
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class Patient(BaseModel):
    """
    Patient
    """ # noqa: E501
    id_pat: Annotated[str, Field(strict=True)] = Field(description="Identifiant partagé du patient, généré une seule fois par le système du partenaire qui créé le patient. Il est valorisé comme suit lors de sa création :  {OrgId émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un n°patient unique n'existe pas dans le système émetteur : {ID émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}   ", alias="idPat")
    administrative_file: Optional[AdministrativeFile] = Field(default=None, alias="administrativeFile")
    identity: Optional[Identity] = None
    health_motive: Optional[HealthMotive] = Field(default=None, alias="healthMotive")
    detail: Optional[PatientDetail] = None
    hypothesis: Optional[Hypothesis] = None
    __properties: ClassVar[List[str]] = ["idPat", "administrativeFile", "identity", "healthMotive", "detail", "hypothesis"]

    @field_validator('id_pat')
    def id_pat_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"([\w-]+\.?){3}patient(\.[\w-]+){1,2}", value):
            raise ValueError(r"must validate the regular expression /([\w-]+\.?){3}patient(\.[\w-]+){1,2}/")
        return value

    model_config = {
        "populate_by_name": True,
        "validate_assignment": True
    }


    def to_str(self) -> str:
        """Returns the string representation of the model using alias"""
        return pprint.pformat(self.model_dump(by_alias=True))

    def to_json(self) -> str:
        """Returns the JSON representation of the model using alias"""
        # TODO: pydantic v2: use .model_dump_json(by_alias=True, exclude_unset=True) instead
        return json.dumps(self.to_dict())

    @classmethod
    def from_json(cls, json_str: str) -> Self:
        """Create an instance of Patient from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        """
        _dict = self.model_dump(
            by_alias=True,
            exclude={
            },
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of administrative_file
        if self.administrative_file:
            _dict['administrativeFile'] = self.administrative_file.to_dict()
        # override the default output from pydantic by calling `to_dict()` of identity
        if self.identity:
            _dict['identity'] = self.identity.to_dict()
        # override the default output from pydantic by calling `to_dict()` of health_motive
        if self.health_motive:
            _dict['healthMotive'] = self.health_motive.to_dict()
        # override the default output from pydantic by calling `to_dict()` of detail
        if self.detail:
            _dict['detail'] = self.detail.to_dict()
        # override the default output from pydantic by calling `to_dict()` of hypothesis
        if self.hypothesis:
            _dict['hypothesis'] = self.hypothesis.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Patient from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "idPat": obj.get("idPat"),
            "administrativeFile": AdministrativeFile.from_dict(obj.get("administrativeFile")) if obj.get("administrativeFile") is not None else None,
            "identity": Identity.from_dict(obj.get("identity")) if obj.get("identity") is not None else None,
            "healthMotive": HealthMotive.from_dict(obj.get("healthMotive")) if obj.get("healthMotive") is not None else None,
            "detail": PatientDetail.from_dict(obj.get("detail")) if obj.get("detail") is not None else None,
            "hypothesis": Hypothesis.from_dict(obj.get("hypothesis")) if obj.get("hypothesis") is not None else None
        })
        return _obj


