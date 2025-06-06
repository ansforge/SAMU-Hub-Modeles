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
from typing import Any, ClassVar, Dict, List
from hubsante_model.rpis.models.health_motive import HealthMotive
from hubsante_model.rpis.models.whats_happen import WhatsHappen
from typing import Optional, Set
from typing_extensions import Self

class Regulation(BaseModel):
    """
    Regulation
    """ # noqa: E501
    whats_happen: WhatsHappen = Field(alias="whatsHappen")
    health_motive: HealthMotive = Field(alias="healthMotive")
    medical_level: StrictStr = Field(description="Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code de la nomenclature  SI-SAMU-NIVSOIN. Permet de déduire avec la donnée \"niveau de médicalisation du transport\", si un UMHP est devenu un SMUR. ", alias="medicalLevel")
    __properties: ClassVar[List[str]] = ["whatsHappen", "healthMotive", "medicalLevel"]

    @field_validator('medical_level')
    def medical_level_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['MED', 'PARAMED', 'SECOURS', 'SANS']):
            raise ValueError("must be one of enum values ('MED', 'PARAMED', 'SECOURS', 'SANS')")
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
        """Create an instance of Regulation from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of whats_happen
        if self.whats_happen:
            _dict['whatsHappen'] = self.whats_happen.to_dict()
        # override the default output from pydantic by calling `to_dict()` of health_motive
        if self.health_motive:
            _dict['healthMotive'] = self.health_motive.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Regulation from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "whatsHappen": WhatsHappen.from_dict(obj["whatsHappen"]) if obj.get("whatsHappen") is not None else None,
            "healthMotive": HealthMotive.from_dict(obj["healthMotive"]) if obj.get("healthMotive") is not None else None,
            "medicalLevel": obj.get("medicalLevel")
        })
        return _obj


