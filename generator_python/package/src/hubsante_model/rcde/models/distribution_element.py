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
from typing import Any, ClassVar, Dict, List
from typing_extensions import Annotated
from hubsante_model.rcde.models.recipient import Recipient
from hubsante_model.rcde.models.sender import Sender
from typing import Optional, Set
from typing_extensions import Self

class DistributionElement(BaseModel):
    """
    DistributionElement
    """ # noqa: E501
    message_id: StrictStr = Field(description="Identifiant partagé de l'affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l'ensemble des systèmes : le numéro de dossier fourni par celui qui génère l'identifiant partagé doit donc être un numéro unique dans son système.", alias="messageId")
    sender: Sender
    sent_at: str = Field(description="Groupe date heure de début de partage lié à l'envoi du message. Il doit  être cohérent avec le champ <dateTimeSent> de l'enveloppe EDXL (voir DST).  L'indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par '-00:00'", alias="sentAt")
    kind: StrictStr = Field(description="Prend la valeur <distributionKind de l'enveloppe EDXL (voir DST)")
    status: StrictStr = Field(description="Prend la valeur <distributionStatus> de l'enveloppe EDXL (voir DST)")
    recipient: Annotated[List[Recipient], Field(min_length=1)]
    additional_properties: Dict[str, Any] = {}
    __properties: ClassVar[List[str]] = ["messageId", "sender", "sentAt", "kind", "status", "recipient"]

    @field_validator('sent_at')
    def sent_at_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('kind')
    def kind_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['Report', 'Update', 'Cancel', 'Ack', 'Error']):
            raise ValueError("must be one of enum values ('Report', 'Update', 'Cancel', 'Ack', 'Error')")
        return value

    @field_validator('status')
    def status_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['Actual', 'Exercise', 'System']):
            raise ValueError("must be one of enum values ('Actual', 'Exercise', 'System')")
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
        """Create an instance of DistributionElement from a JSON string"""
        return cls.from_dict(json.loads(json_str))

    def to_dict(self) -> Dict[str, Any]:
        """Return the dictionary representation of the model using alias.

        This has the following differences from calling pydantic's
        `self.model_dump(by_alias=True)`:

        * `None` is only added to the output dict for nullable fields that
          were set at model initialization. Other fields with value `None`
          are ignored.
        * Fields in `self.additional_properties` are added to the output dict.
        """
        excluded_fields: Set[str] = set([
            "additional_properties",
        ])

        _dict = self.model_dump(
            by_alias=True,
            exclude=excluded_fields,
            exclude_none=True,
        )
        # override the default output from pydantic by calling `to_dict()` of sender
        if self.sender:
            _dict['sender'] = self.sender.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in recipient (list)
        _items = []
        if self.recipient:
            for _item_recipient in self.recipient:
                if _item_recipient:
                    _items.append(_item_recipient.to_dict())
            _dict['recipient'] = _items
        # puts key-value pairs in additional_properties in the top level
        if self.additional_properties is not None:
            for _key, _value in self.additional_properties.items():
                _dict[_key] = _value

        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of DistributionElement from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "messageId": obj.get("messageId"),
            "sender": Sender.from_dict(obj["sender"]) if obj.get("sender") is not None else None,
            "sentAt": obj.get("sentAt"),
            "kind": obj.get("kind"),
            "status": obj.get("status"),
            "recipient": [Recipient.from_dict(_item) for _item in obj["recipient"]] if obj.get("recipient") is not None else None
        })
        # store additional fields in additional_properties
        for _key in obj.keys():
            if _key not in cls.__properties:
                _obj.additional_properties[_key] = obj.get(_key)

        return _obj


