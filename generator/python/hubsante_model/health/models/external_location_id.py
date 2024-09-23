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
from typing_extensions import Annotated
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class ExternalLocationId(BaseModel):
    """
    ExternalLocationId
    """ # noqa: E501
    source: StrictStr = Field(description="A valoriser avec le type de l'identifiant fourni. Cf nomenclature associée.")
    value: Annotated[str, Field(strict=True)] = Field(description="A valoriser avec l'identifiant en lui-même")
    __properties: ClassVar[List[str]] = ["source", "value"]

    @field_validator('source')
    def source_validate_enum(cls, value):
        """Validates the enum"""
        if value not in ('FINESS_ADMINISTRATIF', 'FINESS_GEOGRAPHIQUE', 'SIREN', 'SIRET', 'APE_NAF'):
            raise ValueError("must be one of enum values ('FINESS_ADMINISTRATIF', 'FINESS_GEOGRAPHIQUE', 'SIREN', 'SIRET', 'APE_NAF')")
        return value

    @field_validator('value')
    def value_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^([0-9A-Z]{2}0\d{5}\d|\d{9}|\d{14}|\d{4}[A-Za-z])$", value):
            raise ValueError(r"must validate the regular expression /^([0-9A-Z]{2}0\d{5}\d|\d{9}|\d{14}|\d{4}[A-Za-z])$/")
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
        """Create an instance of ExternalLocationId from a JSON string"""
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
        """Create an instance of ExternalLocationId from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "source": obj.get("source"),
            "value": obj.get("value")
        })
        return _obj


