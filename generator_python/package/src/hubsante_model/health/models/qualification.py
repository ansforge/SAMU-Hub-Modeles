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

from pydantic import BaseModel, ConfigDict, Field, StrictStr, field_validator
from typing import Any, ClassVar, Dict, List, Optional
from hubsante_model.health.models.case_details import CaseDetails
from hubsante_model.health.models.health_motive import HealthMotive
from hubsante_model.health.models.location_kind import LocationKind
from hubsante_model.health.models.risk_threat import RiskThreat
from hubsante_model.health.models.whats_happen import WhatsHappen
from typing import Optional, Set
from typing_extensions import Self

class Qualification(BaseModel):
    """
    Qualification
    """ # noqa: E501
    origin: Optional[StrictStr] = Field(default=None, description="A valoriser avec le numéro de provenance de l'appel.")
    risk_threat: Optional[List[RiskThreat]] = Field(default=None, alias="riskThreat")
    whats_happen: Optional[WhatsHappen] = Field(default=None, alias="whatsHappen")
    location_kind: Optional[LocationKind] = Field(default=None, alias="locationKind")
    health_motive: Optional[HealthMotive] = Field(default=None, alias="healthMotive")
    details: Optional[CaseDetails] = None
    __properties: ClassVar[List[str]] = ["origin", "riskThreat", "whatsHappen", "locationKind", "healthMotive", "details"]

    @field_validator('origin')
    def origin_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['15', '116117', 'AUTOCOM', '112', '115', 'CRRA', 'AUTREC15', 'CTA-CONF', 'CTA-PI', 'AUTRECTA', 'CNR', 'FDO', 'SNATED', 'PDSSOS', 'TELASSIST', 'CROSS', 'PUBLIC', 'DATA', 'AUTRE']):
            raise ValueError("must be one of enum values ('15', '116117', 'AUTOCOM', '112', '115', 'CRRA', 'AUTREC15', 'CTA-CONF', 'CTA-PI', 'AUTRECTA', 'CNR', 'FDO', 'SNATED', 'PDSSOS', 'TELASSIST', 'CROSS', 'PUBLIC', 'DATA', 'AUTRE')")
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
        """Create an instance of Qualification from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in risk_threat (list)
        _items = []
        if self.risk_threat:
            for _item_risk_threat in self.risk_threat:
                if _item_risk_threat:
                    _items.append(_item_risk_threat.to_dict())
            _dict['riskThreat'] = _items
        # override the default output from pydantic by calling `to_dict()` of whats_happen
        if self.whats_happen:
            _dict['whatsHappen'] = self.whats_happen.to_dict()
        # override the default output from pydantic by calling `to_dict()` of location_kind
        if self.location_kind:
            _dict['locationKind'] = self.location_kind.to_dict()
        # override the default output from pydantic by calling `to_dict()` of health_motive
        if self.health_motive:
            _dict['healthMotive'] = self.health_motive.to_dict()
        # override the default output from pydantic by calling `to_dict()` of details
        if self.details:
            _dict['details'] = self.details.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Qualification from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "origin": obj.get("origin"),
            "riskThreat": [RiskThreat.from_dict(_item) for _item in obj["riskThreat"]] if obj.get("riskThreat") is not None else None,
            "whatsHappen": WhatsHappen.from_dict(obj["whatsHappen"]) if obj.get("whatsHappen") is not None else None,
            "locationKind": LocationKind.from_dict(obj["locationKind"]) if obj.get("locationKind") is not None else None,
            "healthMotive": HealthMotive.from_dict(obj["healthMotive"]) if obj.get("healthMotive") is not None else None,
            "details": CaseDetails.from_dict(obj["details"]) if obj.get("details") is not None else None
        })
        return _obj


