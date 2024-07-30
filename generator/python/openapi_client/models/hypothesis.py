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
from pydantic import BaseModel
from pydantic import Field
from openapi_client.models.main_diagnosis import MainDiagnosis
from openapi_client.models.other_diagnosis import OtherDiagnosis
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class Hypothesis(BaseModel):
    """
    Hypothesis
    """ # noqa: E501
    main_diagnosis: Optional[MainDiagnosis] = Field(default=None, alias="mainDiagnosis")
    other_diagnosis: Optional[List[OtherDiagnosis]] = Field(default=None, alias="otherDiagnosis")
    __properties: ClassVar[List[str]] = ["mainDiagnosis", "otherDiagnosis"]

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
        """Create an instance of Hypothesis from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of main_diagnosis
        if self.main_diagnosis:
            _dict['mainDiagnosis'] = self.main_diagnosis.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in other_diagnosis (list)
        _items = []
        if self.other_diagnosis:
            for _item in self.other_diagnosis:
                if _item:
                    _items.append(_item.to_dict())
            _dict['otherDiagnosis'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of Hypothesis from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "mainDiagnosis": MainDiagnosis.from_dict(obj.get("mainDiagnosis")) if obj.get("mainDiagnosis") is not None else None,
            "otherDiagnosis": [OtherDiagnosis.from_dict(_item) for _item in obj.get("otherDiagnosis")] if obj.get("otherDiagnosis") is not None else None
        })
        return _obj


