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
from hubsante_model.emsi.models.position import Position
from typing import Optional, Set
from typing_extensions import Self

class Rgeo(BaseModel):
    """
    Rgeo
    """ # noqa: E501
    datime: Optional[datetime] = Field(default=None, description="Horaire associé à l'arrivée de la ressource sur la position. En fonction du TYPE de position, peut indiquer un horaire de relevé de position, un horaire cible d'arrivée.", alias="DATIME")
    type: StrictStr = Field(description="Type de position indiqué pour la ressource : - ASP : assembly point. Point de rassemblement par défaut des ressources liées à la mission. Peut ne pas être utilisé - CUR : current. Position actualisée de la ressource permettant le suivi géolocalisé des véhicules notamment. Peut ne pas être utilisé - INC : incident. Consigne relative au positionnement de la ressource sur le lieu d'intervention. Peut ne pas être utilisé - STG : staging point. Consigne relative au stationnement des véhicules ou au stockage du matériel par exemple. peut ne pas être utilisé - TGT : targer location. Si renseigné, doit être cohérent avec la position renseignée pour la mission. Plusieurs positions du même type avec des horodatages différents peuvent être fournies. ", alias="TYPE")
    freetext: Optional[StrictStr] = Field(default=None, description="Permet de rajouter des précisions sur la localisation de la ressource transmise", alias="FREETEXT")
    id: Optional[StrictStr] = Field(default=None, description="Identifiant unique de la position dans le système du partenaire", alias="ID")
    position: Optional[List[Position]] = Field(default=None, alias="POSITION")
    __properties: ClassVar[List[str]] = ["DATIME", "TYPE", "FREETEXT", "ID", "POSITION"]

    @field_validator('datime')
    def datime_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('type')
    def type_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['ASP', 'CUR', 'INC', 'STG', 'TGT']):
            raise ValueError("must be one of enum values ('ASP', 'CUR', 'INC', 'STG', 'TGT')")
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
        """Create an instance of Rgeo from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in position (list)
        _items = []
        if self.position:
            for _item_position in self.position:
                if _item_position:
                    _items.append(_item_position.to_dict())
            _dict['POSITION'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Rgeo from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "DATIME": obj.get("DATIME"),
            "TYPE": obj.get("TYPE"),
            "FREETEXT": obj.get("FREETEXT"),
            "ID": obj.get("ID"),
            "POSITION": [Position.from_dict(_item) for _item in obj["POSITION"]] if obj.get("POSITION") is not None else None
        })
        return _obj


