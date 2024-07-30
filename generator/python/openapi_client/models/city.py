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
from pydantic import BaseModel, StrictStr, field_validator
from pydantic import Field
from typing_extensions import Annotated
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class City(BaseModel):
    """
    City
    """ # noqa: E501
    name: Optional[StrictStr] = Field(default=None, description="A valoriser avec le nom officiel de la commune")
    insee_code: Optional[Annotated[str, Field(strict=True)]] = Field(default=None, description="A valoriser avec le code INSEE de la commune actuelle sur la base du Code Officiel géographique en vigueur.  La valeur du code INSEE est obligatoire dès que le nom de la commune est renseigné (city.name).", alias="inseeCode")
    __properties: ClassVar[List[str]] = ["name", "inseeCode"]

    @field_validator('insee_code')
    def insee_code_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"[0-9]{5}", value):
            raise ValueError(r"must validate the regular expression /[0-9]{5}/")
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
        """Create an instance of City from a JSON string"""
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
        """Create an instance of City from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "name": obj.get("name"),
            "inseeCode": obj.get("inseeCode")
        })
        return _obj


