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
from hubsante_model.health.models.detailed_name import DetailedName
from hubsante_model.health.models.personal_contact import PersonalContact
from typing import Optional, Set
from typing_extensions import Self

class GeneralPractitioner(BaseModel):
    """
    GeneralPractitioner
    """ # noqa: E501
    detailed_name: DetailedName = Field(alias="detailedName")
    rpps_id: Optional[StrictStr] = Field(default=None, description="Numéro RPPS du médecin traitant", alias="rppsId")
    contact: Optional[List[PersonalContact]] = None
    __properties: ClassVar[List[str]] = ["detailedName", "rppsId", "contact"]

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
        """Create an instance of GeneralPractitioner from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of detailed_name
        if self.detailed_name:
            _dict['detailedName'] = self.detailed_name.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in contact (list)
        _items = []
        if self.contact:
            for _item_contact in self.contact:
                if _item_contact:
                    _items.append(_item_contact.to_dict())
            _dict['contact'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of GeneralPractitioner from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "detailedName": DetailedName.from_dict(obj["detailedName"]) if obj.get("detailedName") is not None else None,
            "rppsId": obj.get("rppsId"),
            "contact": [PersonalContact.from_dict(_item) for _item in obj["contact"]] if obj.get("contact") is not None else None
        })
        return _obj


