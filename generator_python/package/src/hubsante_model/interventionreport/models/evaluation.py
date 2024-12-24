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
from hubsante_model.interventionreport.models.vital import Vital
from typing import Optional, Set
from typing_extensions import Self

class Evaluation(BaseModel):
    """
    Evaluation
    """ # noqa: E501
    procedure: Optional[List[StrictStr]] = None
    main_diagnosis: Optional[StrictStr] = Field(default=None, description="Thésaurus SFMU-FEDORU. A valoriser par un code de la nomenclature Diagnostic SMUR.", alias="mainDiagnosis")
    associated_diagnosis: Optional[List[StrictStr]] = Field(default=None, alias="associatedDiagnosis")
    parameter: Optional[List[Vital]] = None
    medical_history: Optional[StrictStr] = Field(default=None, description="Précise les antécédents du patient", alias="medicalHistory")
    treatment: Optional[StrictStr] = Field(default=None, description="Précise le traitement du patient")
    freetext: Optional[List[StrictStr]] = None
    __properties: ClassVar[List[str]] = ["procedure", "mainDiagnosis", "associatedDiagnosis", "parameter", "medicalHistory", "treatment", "freetext"]

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
        """Create an instance of Evaluation from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in parameter (list)
        _items = []
        if self.parameter:
            for _item_parameter in self.parameter:
                if _item_parameter:
                    _items.append(_item_parameter.to_dict())
            _dict['parameter'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Evaluation from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "procedure": obj.get("procedure"),
            "mainDiagnosis": obj.get("mainDiagnosis"),
            "associatedDiagnosis": obj.get("associatedDiagnosis"),
            "parameter": [Vital.from_dict(_item) for _item in obj["parameter"]] if obj.get("parameter") is not None else None,
            "medicalHistory": obj.get("medicalHistory"),
            "treatment": obj.get("treatment"),
            "freetext": obj.get("freetext")
        })
        return _obj

