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

from pydantic import BaseModel, ConfigDict, Field
from typing import Any, ClassVar, Dict, List, Optional
from hubsante_model.health.models.external_id import ExternalId
from hubsante_model.health.models.general_practitioner import GeneralPractitioner
from typing import Optional, Set
from typing_extensions import Self

class AdministrativeFile(BaseModel):
    """
    AdministrativeFile
    """ # noqa: E501
    external_id: Optional[List[ExternalId]] = Field(default=None, alias="externalId")
    general_practitioner: Optional[GeneralPractitioner] = Field(default=None, alias="generalPractitioner")
    __properties: ClassVar[List[str]] = ["externalId", "generalPractitioner"]

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
        """Create an instance of AdministrativeFile from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in external_id (list)
        _items = []
        if self.external_id:
            for _item_external_id in self.external_id:
                if _item_external_id:
                    _items.append(_item_external_id.to_dict())
            _dict['externalId'] = _items
        # override the default output from pydantic by calling `to_dict()` of general_practitioner
        if self.general_practitioner:
            _dict['generalPractitioner'] = self.general_practitioner.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of AdministrativeFile from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "externalId": [ExternalId.from_dict(_item) for _item in obj["externalId"]] if obj.get("externalId") is not None else None,
            "generalPractitioner": GeneralPractitioner.from_dict(obj["generalPractitioner"]) if obj.get("generalPractitioner") is not None else None
        })
        return _obj


