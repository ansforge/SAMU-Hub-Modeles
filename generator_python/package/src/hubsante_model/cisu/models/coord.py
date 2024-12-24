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

from pydantic import BaseModel, ConfigDict, Field, StrictFloat, StrictInt, StrictStr, field_validator
from typing import Any, ClassVar, Dict, List, Optional, Union
from typing import Optional, Set
from typing_extensions import Self

class Coord(BaseModel):
    """
    Coord
    """ # noqa: E501
    lat: Union[StrictFloat, StrictInt] = Field(description="A valoriser avec la latitude du point clé de la localisation - dans le système de coordonnées EPSG-4326 (indiquant l'utilisation de WGS-84) ")
    lon: Union[StrictFloat, StrictInt] = Field(description="A valoriser avec la longitude du point clé de la localisation - dans le système de coordonnées EPSG-4326 (indiquant l'utilisation de WGS-84) ")
    height: Optional[Union[StrictFloat, StrictInt]] = Field(default=None, description="A valoriser avec l'altitude du point clé de la localisation, en mètres.  Spécificité 15-18 :  ignoré côté NexSIS. ")
    heading: Optional[Union[StrictFloat, StrictInt]] = Field(default=None, description="A valoriser avec le cap, en degré")
    speed: Optional[Union[StrictFloat, StrictInt]] = Field(default=None, description="Vitesse en km/h, notamment fournie par eCall, tel, nouveau AML, …")
    precision: StrictStr = Field(description="Indique via une nomenclature le niveau de précision des coordonnées fournies par le système emetteur. VILLE : Précision à l'échelle de la ville,  RUE : Précision à l'échelle de la rue,  ADRESSE : Adresse précise,  EXACTE : Point coordonnée GPS exact,  INCONNUE : Précision de la localisation non évaluable par l'émetteur")
    __properties: ClassVar[List[str]] = ["lat", "lon", "height", "heading", "speed", "precision"]

    @field_validator('precision')
    def precision_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['VILLE', 'RUE', 'ADRESSE', 'EXACTE', 'INCONNUE']):
            raise ValueError("must be one of enum values ('VILLE', 'RUE', 'ADRESSE', 'EXACTE', 'INCONNUE')")
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
        """Create an instance of Coord from a JSON string"""
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
        """Create an instance of Coord from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "lat": obj.get("lat"),
            "lon": obj.get("lon"),
            "height": obj.get("height"),
            "heading": obj.get("heading"),
            "speed": obj.get("speed"),
            "precision": obj.get("precision")
        })
        return _obj


