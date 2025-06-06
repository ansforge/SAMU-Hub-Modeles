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
from hubsante_model.emsi.models.external_info import ExternalInfo
from hubsante_model.emsi.models.link import Link
from hubsante_model.emsi.models.origin import Origin
from typing import Optional, Set
from typing_extensions import Self

class Context(BaseModel):
    """
    Context
    """ # noqa: E501
    id: StrictStr = Field(description="A constituer par le rédacteur du présent EMSI pour être unique, il est préconisé de reprendre la valeur du champ messageId de l'entête RC-DE.", alias="ID")
    mode: StrictStr = Field(description="Valeur constante dans le cadre des échanges LRM-NexSIS : ACTUAL", alias="MODE")
    msgtype: StrictStr = Field(description="- A valoriser avec la valeur \"ALERT\" lors du premier échange entre systèmes. - A valoriser avec la valeur constante \"UPDATE\" ensuite. Peut ne pas être interprété par les LRM.", alias="MSGTYPE")
    creation: Optional[str] = Field(default=None, description="Obligatoire dans le cadre d'une demande de concours, contient la date de création de la demande de concours dans le système du partenaire requérant. A valoriser avec le même horaire que dateTimeSent dans le message RC-DE associé. Dans le cadre d'une demande de concours, obligatoire. Ce champ est valorisée avec l'heure de création de la demande de concours chez le partenaire emetteur. L'heure d'envoi du message peut être obtenue via l'enveloppe EDXL-DE (se référer au DST)", alias="CREATION")
    link: Optional[List[Link]] = Field(default=None, alias="LINK")
    level: Optional[StrictStr] = Field(default=None, description="A valoriser avec la valeur constante \"OPR\" dans le cadre d'un message EMSI, incluant une mission OPG", alias="LEVEL")
    seclass: Optional[StrictStr] = Field(default=None, description="Optionnel  Dans NexSIS ;  Les messages transmis par NexSIS auront un champ valorisé avec systématiquement le même code: \"RESTRC\"=restricted Les LRM doivent également renseigner la valeur \"RESTRC\"", alias="SECLASS")
    freetext: Optional[StrictStr] = Field(default=None, description="Texte libre, optionnel  Dans NexSIS; Fonction de l'événement générateur RG 1 : la valeur de <context><freetext> reste à  'Création d'un événement opérationnel EMSI' & version & 'suite à réception d'une affaire*' dans le cadre de la création d'une opération commune (conforme RG 2 de NEXSIS-6618) RG 3 : les événements générateurs sont ceux définis au sein de NEXSIS-6619 RG 1 de traçabilité  ( input = <Evenement à l'origine> = CREATION_OPERATION / MAJ_MODIFICATION_ETAT_OPERATION / AJOUT_RESSOURCE / RETRAIT_RESSOURCE / MAJ_ETAT_SITUATION_RESSOURCE / MAJ_LOCALISATION_ADRESSE) auxquels seront ajoutés  les éventuels événements à venir.", alias="FREETEXT")
    origin: Optional[Origin] = Field(default=None, alias="ORIGIN")
    external_info: Optional[List[ExternalInfo]] = Field(default=None, alias="EXTERNAL_INFO")
    urgency: Optional[StrictStr] = Field(default=None, description="Niveau d'urgence pour l'affaire en cours Dans le cadre des échanges LRM-NexSIS, optionnel", alias="URGENCY")
    __properties: ClassVar[List[str]] = ["ID", "MODE", "MSGTYPE", "CREATION", "LINK", "LEVEL", "SECLASS", "FREETEXT", "ORIGIN", "EXTERNAL_INFO", "URGENCY"]

    @field_validator('mode')
    def mode_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['ACTUAL', 'EXERCS', 'SYSTEM', 'TEST']):
            raise ValueError("must be one of enum values ('ACTUAL', 'EXERCS', 'SYSTEM', 'TEST')")
        return value

    @field_validator('msgtype')
    def msgtype_validate_enum(cls, value):
        """Validates the enum"""
        if value not in set(['ACK', 'ALERT', 'CANCEL', 'ERROR', 'UPDATE']):
            raise ValueError("must be one of enum values ('ACK', 'ALERT', 'CANCEL', 'ERROR', 'UPDATE')")
        return value

    @field_validator('creation')
    def creation_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('level')
    def level_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['STRTGC', 'OPR', 'TACTCL']):
            raise ValueError("must be one of enum values ('STRTGC', 'OPR', 'TACTCL')")
        return value

    @field_validator('seclass')
    def seclass_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['CONFID', 'RESTRC', 'SECRET', 'TOPSRT', 'UNCLAS', 'UNMARK']):
            raise ValueError("must be one of enum values ('CONFID', 'RESTRC', 'SECRET', 'TOPSRT', 'UNCLAS', 'UNMARK')")
        return value

    @field_validator('urgency')
    def urgency_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['URGENT', 'NOT_URGENT']):
            raise ValueError("must be one of enum values ('URGENT', 'NOT_URGENT')")
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
        """Create an instance of Context from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of each item in link (list)
        _items = []
        if self.link:
            for _item_link in self.link:
                if _item_link:
                    _items.append(_item_link.to_dict())
            _dict['LINK'] = _items
        # override the default output from pydantic by calling `to_dict()` of origin
        if self.origin:
            _dict['ORIGIN'] = self.origin.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in external_info (list)
        _items = []
        if self.external_info:
            for _item_external_info in self.external_info:
                if _item_external_info:
                    _items.append(_item_external_info.to_dict())
            _dict['EXTERNAL_INFO'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Context from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "ID": obj.get("ID"),
            "MODE": obj.get("MODE"),
            "MSGTYPE": obj.get("MSGTYPE"),
            "CREATION": obj.get("CREATION"),
            "LINK": [Link.from_dict(_item) for _item in obj["LINK"]] if obj.get("LINK") is not None else None,
            "LEVEL": obj.get("LEVEL"),
            "SECLASS": obj.get("SECLASS"),
            "FREETEXT": obj.get("FREETEXT"),
            "ORIGIN": Origin.from_dict(obj["ORIGIN"]) if obj.get("ORIGIN") is not None else None,
            "EXTERNAL_INFO": [ExternalInfo.from_dict(_item) for _item in obj["EXTERNAL_INFO"]] if obj.get("EXTERNAL_INFO") is not None else None,
            "URGENCY": obj.get("URGENCY")
        })
        return _obj


