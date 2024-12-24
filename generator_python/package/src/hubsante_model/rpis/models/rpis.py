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

from pydantic import BaseModel, ConfigDict
from typing import Any, ClassVar, Dict, List
from hubsante_model.rpis.models.event import Event
from hubsante_model.rpis.models.intervention import Intervention
from hubsante_model.rpis.models.orientation import Orientation
from hubsante_model.rpis.models.patient import Patient
from hubsante_model.rpis.models.regulation import Regulation
from typing import Optional, Set
from typing_extensions import Self

class Rpis(BaseModel):
    """
    Rpis
    """ # noqa: E501
    context: Event
    regulation: Regulation
    patient: Patient
    intervention: Intervention
    orientation: Orientation
    __properties: ClassVar[List[str]] = ["context", "regulation", "patient", "intervention", "orientation"]

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
        """Create an instance of Rpis from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of context
        if self.context:
            _dict['context'] = self.context.to_dict()
        # override the default output from pydantic by calling `to_dict()` of regulation
        if self.regulation:
            _dict['regulation'] = self.regulation.to_dict()
        # override the default output from pydantic by calling `to_dict()` of patient
        if self.patient:
            _dict['patient'] = self.patient.to_dict()
        # override the default output from pydantic by calling `to_dict()` of intervention
        if self.intervention:
            _dict['intervention'] = self.intervention.to_dict()
        # override the default output from pydantic by calling `to_dict()` of orientation
        if self.orientation:
            _dict['orientation'] = self.orientation.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Rpis from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "context": Event.from_dict(obj["context"]) if obj.get("context") is not None else None,
            "regulation": Regulation.from_dict(obj["regulation"]) if obj.get("regulation") is not None else None,
            "patient": Patient.from_dict(obj["patient"]) if obj.get("patient") is not None else None,
            "intervention": Intervention.from_dict(obj["intervention"]) if obj.get("intervention") is not None else None,
            "orientation": Orientation.from_dict(obj["orientation"]) if obj.get("orientation") is not None else None
        })
        return _obj


