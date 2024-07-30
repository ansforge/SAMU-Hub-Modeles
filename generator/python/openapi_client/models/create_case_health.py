# coding: utf-8

"""
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


from __future__ import annotations
import pprint
import re  # noqa: F401
import json

from datetime import datetime
from typing import Any, ClassVar, Dict, List, Optional
from pydantic import BaseModel, StrictStr, field_validator
from pydantic import Field
from typing_extensions import Annotated
from openapi_client.models.additional_information import AdditionalInformation
from openapi_client.models.alert import Alert
from openapi_client.models.location import Location
from openapi_client.models.medical_note import MedicalNote
from openapi_client.models.patient import Patient
from openapi_client.models.qualification import Qualification
try:
    from typing import Self
except ImportError:
    from typing_extensions import Self

class CreateCaseHealth(BaseModel):
    """
    CreateCaseHealth
    """ # noqa: E501
    case_id: Annotated[str, Field(strict=True)] = Field(description="Identifiant partagé de l'affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l'ensemble des systèmes : le numéro de dossier fourni par celui qui génère l'identifiant partagé doit donc être un numéro unique dans son système.", alias="caseId")
    sender_case_id: Optional[StrictStr] = Field(default=None, description="A valoriser avec le numéro du dossier dans le SI de l'émetteur du message. ", alias="senderCaseId")
    creation: datetime = Field(description="A valoriser avec le groupe date heure de début de partage lié à la création de l'affaire (et donc de génération du caseId).  Lors de l'ajout d'une nouvelle alerte, la valeur de ce champ ne doit pas être modifiée.   L'indicateur de fuseau horaire Z ne doit pas être utilisé.  Spécificité 15-18 : Il doit être renseigné à la fin du processus de la  création de la première alerte.")
    perimeter: Optional[StrictStr] = Field(default=None, description="Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être adressé/affiché, lorsque celle-ci est spécifique ou dédiée.")
    intervention_type: Optional[StrictStr] = Field(default=None, description="A valoriser en indiquant s'il s'agit d'un dossier dit primaire (première intervention urgente) ou secondaire (par exemple TIH)", alias="interventionType")
    qualification: Qualification
    location: Location
    initial_alert: Optional[Alert] = Field(default=None, alias="initialAlert")
    owner: Annotated[str, Field(strict=True)] = Field(description="Attribut qui permet de transférer la prise en charge d'un dossier à un autre CRAA A valoriser avec l'identifiant de l'organisation concerné (orgId = {pays}.{domaine}.{organisation})")
    patient: Optional[List[Patient]] = None
    medical_note: Optional[List[MedicalNote]] = Field(default=None, alias="medicalNote")
    additional_information: Optional[AdditionalInformation] = Field(default=None, alias="additionalInformation")
    __properties: ClassVar[List[str]] = ["caseId", "senderCaseId", "creation", "perimeter", "interventionType", "qualification", "location", "initialAlert", "owner", "patient", "medicalNote", "additionalInformation"]

    @field_validator('case_id')
    def case_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"fr(\.[\w-]+){3,5}", value):
            raise ValueError(r"must validate the regular expression /fr(\.[\w-]+){3,5}/")
        return value

    @field_validator('creation')
    def creation_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}", value):
            raise ValueError(r"must validate the regular expression /\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}[\-+]\d{2}:\d{2}/")
        return value

    @field_validator('perimeter')
    def perimeter_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in ('AMU', 'NEONAT', 'PSY', 'SNP'):
            raise ValueError("must be one of enum values ('AMU', 'NEONAT', 'PSY', 'SNP')")
        return value

    @field_validator('intervention_type')
    def intervention_type_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in ('PRIMAIRE', 'SECONDAIRE', 'RETOUR A DOMICILE'):
            raise ValueError("must be one of enum values ('PRIMAIRE', 'SECONDAIRE', 'RETOUR A DOMICILE')")
        return value

    @field_validator('owner')
    def owner_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"fr(\.[\w-]+){2,4}", value):
            raise ValueError(r"must validate the regular expression /fr(\.[\w-]+){2,4}/")
        return value

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
        """Create an instance of CreateCaseHealth from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of qualification
        if self.qualification:
            _dict['qualification'] = self.qualification.to_dict()
        # override the default output from pydantic by calling `to_dict()` of location
        if self.location:
            _dict['location'] = self.location.to_dict()
        # override the default output from pydantic by calling `to_dict()` of initial_alert
        if self.initial_alert:
            _dict['initialAlert'] = self.initial_alert.to_dict()
        # override the default output from pydantic by calling `to_dict()` of each item in patient (list)
        _items = []
        if self.patient:
            for _item in self.patient:
                if _item:
                    _items.append(_item.to_dict())
            _dict['patient'] = _items
        # override the default output from pydantic by calling `to_dict()` of each item in medical_note (list)
        _items = []
        if self.medical_note:
            for _item in self.medical_note:
                if _item:
                    _items.append(_item.to_dict())
            _dict['medicalNote'] = _items
        # override the default output from pydantic by calling `to_dict()` of additional_information
        if self.additional_information:
            _dict['additionalInformation'] = self.additional_information.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Dict) -> Self:
        """Create an instance of CreateCaseHealth from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "caseId": obj.get("caseId"),
            "senderCaseId": obj.get("senderCaseId"),
            "creation": obj.get("creation"),
            "perimeter": obj.get("perimeter"),
            "interventionType": obj.get("interventionType"),
            "qualification": Qualification.from_dict(obj.get("qualification")) if obj.get("qualification") is not None else None,
            "location": Location.from_dict(obj.get("location")) if obj.get("location") is not None else None,
            "initialAlert": Alert.from_dict(obj.get("initialAlert")) if obj.get("initialAlert") is not None else None,
            "owner": obj.get("owner"),
            "patient": [Patient.from_dict(_item) for _item in obj.get("patient")] if obj.get("patient") is not None else None,
            "medicalNote": [MedicalNote.from_dict(_item) for _item in obj.get("medicalNote")] if obj.get("medicalNote") is not None else None,
            "additionalInformation": AdditionalInformation.from_dict(obj.get("additionalInformation")) if obj.get("additionalInformation") is not None else None
        })
        return _obj


