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
from pydantic import BaseModel, ConfigDict, Field, StrictInt, StrictStr, field_validator
from typing import Any, ClassVar, Dict, List, Optional
from hubsante_model.emsi.models.casualties import Casualties
from hubsante_model.emsi.models.egeo import Egeo
from hubsante_model.emsi.models.etype import Etype
from hubsante_model.emsi.models.evac import Evac
from hubsante_model.emsi.models.reference import Reference
from typing import Optional, Set
from typing_extensions import Self

class Event(BaseModel):
    """
    Event
    """ # noqa: E501
    id: StrictStr = Field(description="A renseigner avec l'identifiant local de l'affaire dans le LRM ou NexSIS", alias="ID")
    name: Optional[StrictStr] = Field(default=None, description="Optionnel Dans nexSIS; [libelle NF 1 métier] & \" - \" & [libelle TL 1 métier] & \" - \" & [libellé commune]", alias="NAME")
    main_event_id: Optional[StrictStr] = Field(default=None, description="A renseigner avec l'identifiant de l'organisation (champ organization du message RC-EDA) suivi de l'identifiant local de l'affaire du partenaire requérant (champ senderCaseId du message RC-EDA). {pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*.{numéro de dossier}  NB : Si l'initiateur du partage de dossier est le même que l'initiateur du message EMSI, l'EVENT.ID = EVENT.MAIN_EVENT_ID", alias="MAIN_EVENT_ID")
    etype: Optional[Etype] = Field(default=None, alias="ETYPE")
    source: Optional[StrictStr] = Field(default=None, description="Optionnel", alias="SOURCE")
    scale: Optional[StrictStr] = Field(default=None, description="Optionnel, Niveau de criticité de l'opération", alias="SCALE")
    certainty: Optional[StrictInt] = Field(default=None, description="Prend une valeur entière entre 0 et 100, et décrit à quel point l'alerte associée à l'événement est fiable Optionnel", alias="CERTAINTY")
    decl_datime: Optional[str] = Field(default=None, description="Dans le cadre d'une demande de concours, ce champ est valorisé avec la date/heure de création de l'affaire ou de l'opération. NexSIS transmettra la date/heure de création de l'opération dans ses systèmes (qui peut diverger de la date/heure de création de l'affaire)", alias="DECL_DATIME")
    occ_datime: Optional[str] = Field(default=None, description="Dans le cadre d'une demande de concours, ce champ est valorisé avec la date de la première alerte ou la date évaluée de début de la situation d'urgence. Par exemple : Si un incendie est déclaré est 9h02, il a pu démarré à 8h55 par exemple. NB : temporairement, NexSIS renseignera ce champ avec la date de réception de l'alerte initiale", alias="OCC_DATIME")
    obs_datime: Optional[str] = Field(default=None, description="Ce champ est idéalement à valoriser avec la date/heure à laquelle l'observation de la situation d'urgence de l'affaire la plus récente a été réalisée. NexSIS transmettra la date/heure d'envoi de la demande de concours dans son système. NB : temporairement, NexSIS renseignera ce champ avec la date de réception de l'alerte initiale", alias="OBS_DATIME")
    status: Optional[StrictStr] = Field(default=None, description="Permet de décrire le status de l'affaire en cours. Ce champ suit une nomenclature EMSI. (COM = event complete, IPR = event in progress, NST = event not started, STOP = STOP = event under control, no need for additional resource) Dans le cadre d'une opération : - si l'opération est encore en cours : rensigner 'IPR', - si le dispatching de moyens est encore en cours ou que seulement des qualifications d'alertes ont été échangées sans aucune décision de régulation 'NST', - si l'opération est en pause/veille : 'STOP' - si le message d'échange opérationnel décrit une fin d'opération, à renseigner avec 'COM' Un message EMSI-EO sans RESSOURCE ni ", alias="STATUS")
    risk_assesment: Optional[StrictStr] = Field(default=None, description="Optionnel", alias="RISK_ASSESMENT")
    reference: Optional[List[Reference]] = Field(default=None, alias="REFERENCE")
    casualties: Optional[List[Casualties]] = Field(default=None, alias="CASUALTIES")
    evac: Optional[List[Evac]] = Field(default=None, alias="EVAC")
    egeo: Optional[List[Egeo]] = Field(default=None, alias="EGEO")
    cause: Optional[StrictStr] = Field(default=None, description="Optionnel", alias="CAUSE")
    freetext: Optional[StrictStr] = Field(default=None, description="Optionnel", alias="FREETEXT")
    __properties: ClassVar[List[str]] = ["ID", "NAME", "MAIN_EVENT_ID", "ETYPE", "SOURCE", "SCALE", "CERTAINTY", "DECL_DATIME", "OCC_DATIME", "OBS_DATIME", "STATUS", "RISK_ASSESMENT", "REFERENCE", "CASUALTIES", "EVAC", "EGEO", "CAUSE", "FREETEXT"]

    @field_validator('source')
    def source_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['COMFOR', 'HUMDED', 'HUMOBS', 'SENSOR']):
            raise ValueError("must be one of enum values ('COMFOR', 'HUMDED', 'HUMOBS', 'SENSOR')")
        return value

    @field_validator('scale')
    def scale_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['1', '2', '3', '4', '5']):
            raise ValueError("must be one of enum values ('1', '2', '3', '4', '5')")
        return value

    @field_validator('decl_datime')
    def decl_datime_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('occ_datime')
    def occ_datime_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('obs_datime')
    def obs_datime_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if value is None:
            return value

        if not re.match(r"^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$", value):
            raise ValueError(r"must validate the regular expression /^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}$/")
        return value

    @field_validator('status')
    def status_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['COM', 'IPR', 'NST', 'STOP']):
            raise ValueError("must be one of enum values ('COM', 'IPR', 'NST', 'STOP')")
        return value

    @field_validator('risk_assesment')
    def risk_assesment_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['NCREA', 'DECREA', 'STABLE']):
            raise ValueError("must be one of enum values ('NCREA', 'DECREA', 'STABLE')")
        return value

    @field_validator('cause')
    def cause_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['ACC', 'DEL', 'NAT']):
            raise ValueError("must be one of enum values ('ACC', 'DEL', 'NAT')")
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
        """Create an instance of Event from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of etype
        if self.etype:
            _dict['ETYPE'] = self.etype.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in reference (list)
        _items = []
        if self.reference:
            for _item_reference in self.reference:
                if _item_reference:
                    _items.append(_item_reference.to_dict())
            _dict['REFERENCE'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in casualties (list)
        _items = []
        if self.casualties:
            for _item_casualties in self.casualties:
                if _item_casualties:
                    _items.append(_item_casualties.to_dict())
            _dict['CASUALTIES'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in evac (list)
        _items = []
        if self.evac:
            for _item_evac in self.evac:
                if _item_evac:
                    _items.append(_item_evac.to_dict())
            _dict['EVAC'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in egeo (list)
        _items = []
        if self.egeo:
            for _item_egeo in self.egeo:
                if _item_egeo:
                    _items.append(_item_egeo.to_dict())
            _dict['EGEO'] = _items
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Event from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "ID": obj.get("ID"),
            "NAME": obj.get("NAME"),
            "MAIN_EVENT_ID": obj.get("MAIN_EVENT_ID"),
            "ETYPE": Etype.from_dict(obj["ETYPE"]) if obj.get("ETYPE") is not None else None,
            "SOURCE": obj.get("SOURCE"),
            "SCALE": obj.get("SCALE"),
            "CERTAINTY": obj.get("CERTAINTY"),
            "DECL_DATIME": obj.get("DECL_DATIME"),
            "OCC_DATIME": obj.get("OCC_DATIME"),
            "OBS_DATIME": obj.get("OBS_DATIME"),
            "STATUS": obj.get("STATUS"),
            "RISK_ASSESMENT": obj.get("RISK_ASSESMENT"),
            "REFERENCE": [Reference.from_dict(_item) for _item in obj["REFERENCE"]] if obj.get("REFERENCE") is not None else None,
            "CASUALTIES": [Casualties.from_dict(_item) for _item in obj["CASUALTIES"]] if obj.get("CASUALTIES") is not None else None,
            "EVAC": [Evac.from_dict(_item) for _item in obj["EVAC"]] if obj.get("EVAC") is not None else None,
            "EGEO": [Egeo.from_dict(_item) for _item in obj["EGEO"]] if obj.get("EGEO") is not None else None,
            "CAUSE": obj.get("CAUSE"),
            "FREETEXT": obj.get("FREETEXT")
        })
        return _obj


