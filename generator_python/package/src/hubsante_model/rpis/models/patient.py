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

from pydantic import BaseModel, ConfigDict, Field, StrictStr, field_validator
from typing import Any, ClassVar, Dict, List, Optional
from hubsante_model.rpis.models.residential_address import ResidentialAddress
from typing import Optional, Set
from typing_extensions import Self

class Patient(BaseModel):
    """
    Patient
    """ # noqa: E501
    patient_id: StrictStr = Field(description="Identifiant unique du patient.  A valoriser par {ID du SAMU qui engage le SMUR}.{ID du DRM}.P{numéro d’ordre chronologique} : fr.health.samu690.DRFR15DDXAAJJJ00001.P01", alias="patientId")
    birth_date: StrictStr = Field(description="Date de naissance du patient", alias="birthDate")
    sex: StrictStr = Field(description="Sexe du patient, suivant le libellé court de la nomenclature NOS-NOMENC_SEXE")
    residential_address: Optional[ResidentialAddress] = Field(default=None, alias="residentialAddress")
    __properties: ClassVar[List[str]] = ["patientId", "birthDate", "sex", "residentialAddress"]

    @field_validator('sex')
    def sex_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['M', 'F', 'O', 'UN']):
            raise ValueError("must be one of enum values ('M', 'F', 'O', 'UN')")
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
        excluded_fields: Set[str] = set([
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of residential_address
        if self.residential_address:
            _dict['residentialAddress'] = self.residential_address.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Patient from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "patientId": obj.get("patientId"),
            "birthDate": obj.get("birthDate"),
            "sex": obj.get("sex"),
            "residentialAddress": ResidentialAddress.from_dict(obj["residentialAddress"]) if obj.get("residentialAddress") is not None else None
        })
        return _obj

