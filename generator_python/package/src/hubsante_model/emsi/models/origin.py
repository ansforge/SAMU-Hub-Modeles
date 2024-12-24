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

from pydantic import BaseModel, ConfigDict, Field, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from typing import Optional, Set
from typing_extensions import Self

class Origin(BaseModel):
    """
    Origin
    """ # noqa: E501
    org_id: Optional[StrictStr] = Field(default=None, description="Optionnel, identifiant du service à l'origine de l'EMSI Se référer au DSF pour la structure normée des organisations Le format est le suivant {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.", alias="ORG_ID")
    user_id: Optional[StrictStr] = Field(default=None, description="Optionnel, identifiant de l'opérateur du service à l'origine de l'EMSI, qui gère l'opération.  Ce champ peut être différent du calltakerId du message RC-EDA. ", alias="USER_ID")
    name: Optional[StrictStr] = Field(default=None, description="Optionnel, A constituer par le rédacteur pour être intelligible (exemple [structure] [code département]). Ce champ n'est pas normé obligatoirement. Chaque service décide de la structure de son nom d'origine.", alias="NAME")
    __properties: ClassVar[List[str]] = ["ORG_ID", "USER_ID", "NAME"]

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
        """Create an instance of Origin from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Origin from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "ORG_ID": obj.get("ORG_ID"),
            "USER_ID": obj.get("USER_ID"),
            "NAME": obj.get("NAME")
        })
        return _obj

