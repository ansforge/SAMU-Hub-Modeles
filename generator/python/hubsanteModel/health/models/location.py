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
from pydantic import BaseModel, StrictStr
from pydantic import Field
from hubsanteModel.health.models.access import Access
from hubsanteModel.health.models.city import City
from hubsanteModel.health.models.detailed_address import DetailedAddress
from hubsanteModel.health.models.external_info import ExternalInfo
from hubsanteModel.health.models.external_location_id import ExternalLocationId
from hubsanteModel.health.models.geometry import Geometry
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class Location(BaseModel):
    """
    Location
    """ # noqa: E501
    name: Optional[StrictStr] = Field(default=None, description="A valoriser avec le nom de lieu : nom commercial, nom d'établissement, forêt de Fontainebleau, lac du Der, etc.")
    external_location_id: Optional[List[ExternalLocationId]] = Field(default=None, alias="externalLocationId")
    detailed_address: Optional[DetailedAddress] = Field(default=None, alias="detailedAddress")
    city: Optional[City] = None
    access: Optional[Access] = None
    geometry: Optional[Geometry] = None
    external_info: Optional[List[ExternalInfo]] = Field(default=None, alias="externalInfo")
    freetext: Optional[StrictStr] = Field(default=None, description="Champ libre qui permet de compléter les informations liées à la localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper ici toute valeur en lien avec la localisation de l'intervention qui ne pourrait pas être transmise de manière structurée dans l'objet location.  En réception, il est très important d'intégrer et d'afficher la valeur de cet attribut, qui est suceptible de contenir des informations d'accès importantes.")
    __properties: ClassVar[List[str]] = ["name", "externalLocationId", "detailedAddress", "city", "access", "geometry", "externalInfo", "freetext"]

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
        """Create an instance of Location from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in external_location_id (list)
        _items = []
        if self.external_location_id:
            for _item in self.external_location_id:
                if _item:
                    _items.append(_item.to_dict())
            _dict['externalLocationId'] = _items
        # override the default output from pydantic by calling `to_dict()` of detailed_address
        if self.detailed_address:
            _dict['detailedAddress'] = self.detailed_address.to_dict()
        # override the default output from pydantic by calling `to_dict()` of city
        if self.city:
            _dict['city'] = self.city.to_dict()
        # override the default output from pydantic by calling `to_dict()` of access
        if self.access:
            _dict['access'] = self.access.to_dict()
        # override the default output from pydantic by calling `to_dict()` of geometry
        if self.geometry:
            _dict['geometry'] = self.geometry.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in external_info (list)
        _items = []
        if self.external_info:
            for _item in self.external_info:
                if _item:
                    _items.append(_item.to_dict())
            _dict['externalInfo'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Location from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "name": obj.get("name"),
            "externalLocationId": [ExternalLocationId.from_dict(_item) for _item in obj.get("externalLocationId")] if obj.get("externalLocationId") is not None else None,
            "detailedAddress": DetailedAddress.from_dict(obj.get("detailedAddress")) if obj.get("detailedAddress") is not None else None,
            "city": City.from_dict(obj.get("city")) if obj.get("city") is not None else None,
            "access": Access.from_dict(obj.get("access")) if obj.get("access") is not None else None,
            "geometry": Geometry.from_dict(obj.get("geometry")) if obj.get("geometry") is not None else None,
            "externalInfo": [ExternalInfo.from_dict(_item) for _item in obj.get("externalInfo")] if obj.get("externalInfo") is not None else None,
            "freetext": obj.get("freetext")
        })
        return _obj


