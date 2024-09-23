# coding: utf-8

"""
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json


from typing import Any, ClassVar, Dict, List
from pydantic import BaseModel, StrictStr, field_validator
from pydantic import Field
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class Contact(BaseModel):
    """
    Contact
    """ # noqa: E501
    channel: StrictStr = Field(description="A valoriser avec  l'origine du canal établi : PERSONNE, APPLICATION, DAU, BAU, DEFIBRILLATEUR, ECALL")
    type: StrictStr = Field(description="A valoriser avec le type de l'URI utilisée.  Cf nomenclature associée.")
    detail: StrictStr = Field(description="A valoriser avec la valeur de l'URI utilisée. Le format attendu pour un numéro de téléphone est le suivant : +{indicatif pays}{numéro de téléphone}")
    __properties: ClassVar[List[str]] = ["channel", "type", "detail"]

    @field_validator('channel')
    def channel_validate_enum(cls, value):
        """Validates the enum"""
        if value not in ('APPLICATION', 'BAU', 'DAU', 'DEFIBRILLATEUR, ', 'ECALL', 'PERSONNE'):
            raise ValueError("must be one of enum values ('APPLICATION', 'BAU', 'DAU', 'DEFIBRILLATEUR, ', 'ECALL', 'PERSONNE')")
        return value

    @field_validator('type')
    def type_validate_enum(cls, value):
        """Validates the enum"""
        if value not in ('TEL', 'EMAIL', 'FAX', 'POSTAL', 'WEB', 'RADIO'):
            raise ValueError("must be one of enum values ('TEL', 'EMAIL', 'FAX', 'POSTAL', 'WEB', 'RADIO')")
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
        """Create an instance of Contact from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Contact from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "channel": obj.get("channel"),
            "type": obj.get("type"),
            "detail": obj.get("detail")
        })
        return _obj

