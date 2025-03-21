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
from hubsante_model.health.models.external_location_id import ExternalLocationId
from typing import Optional, Set
from typing_extensions import Self

class Destination(BaseModel):
    """
    Destination
    """ # noqa: E501
    external_location_id: Optional[List[ExternalLocationId]] = Field(default=None, alias="externalLocationId")
    freetext: Optional[StrictStr] = Field(default=None, description="Champ libre qui permet de compléter les informations liées à la localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper ici toute valeur en lien avec la localisation de l'intervention qui ne pourrait pas être transmise de manière structurée dans l'objet location.  En réception, il est très important d'intégrer et d'afficher la valeur de cet attribut, qui est suceptible de contenir des informations d'accès importantes.")
    __properties: ClassVar[List[str]] = ["externalLocationId", "freetext"]

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
        """Create an instance of Destination from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in external_location_id (list)
        _items = []
        if self.external_location_id:
            for _item_external_location_id in self.external_location_id:
                if _item_external_location_id:
                    _items.append(_item_external_location_id.to_dict())
            _dict['externalLocationId'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Destination from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "externalLocationId": [ExternalLocationId.from_dict(_item) for _item in obj["externalLocationId"]] if obj.get("externalLocationId") is not None else None,
            "freetext": obj.get("freetext")
        })
        return _obj


