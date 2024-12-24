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
from hubsante_model.technical.noreq.models.level_two_data import LevelTwoData
from hubsante_model.technical.noreq.models.second_level_two_data import SecondLevelTwoData
from typing import Optional, Set
from typing_extensions import Self

class LevelOneData(BaseModel):
    """
    LevelOneData
    """ # noqa: E501
    object1_level2: Optional[LevelTwoData] = Field(default=None, alias="object1Level2")
    string_level2: Optional[StrictStr] = Field(default=None, description="String field at level 2", alias="stringLevel2")
    object2_level2: Optional[SecondLevelTwoData] = Field(default=None, alias="object2Level2")
    __properties: ClassVar[List[str]] = ["object1Level2", "stringLevel2", "object2Level2"]

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
        """Create an instance of LevelOneData from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of object1_level2
        if self.object1_level2:
            _dict['object1Level2'] = self.object1_level2.to_dict()
        # override the default output from pydantic by calling `to_dict()` of object2_level2
        if self.object2_level2:
            _dict['object2Level2'] = self.object2_level2.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of LevelOneData from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "object1Level2": LevelTwoData.from_dict(obj["object1Level2"]) if obj.get("object1Level2") is not None else None,
            "stringLevel2": obj.get("stringLevel2"),
            "object2Level2": SecondLevelTwoData.from_dict(obj["object2Level2"]) if obj.get("object2Level2") is not None else None
        })
        return _obj


