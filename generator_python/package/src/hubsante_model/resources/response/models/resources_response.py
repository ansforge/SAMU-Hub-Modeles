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

from pydantic import BaseModel, ConfigDict, Field, field_validator
from typing import Any, ClassVar, Dict, List
from typing_extensions import Annotated
from hubsante_model.resources.response.models.response import Response
from typing import Optional, Set
from typing_extensions import Self

class ResourcesResponse(BaseModel):
    """
    ResourcesResponse
    """ # noqa: E501
    case_id: Annotated[str, Field(strict=True)] = Field(description="A valoriser avec l'identifiant partagé de l'affaire/dossier, généré une seule fois par le système du partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il est valorisé comme suit lors de sa création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être unique dans l'ensemble des systèmes : le numéro de dossier fourni par celui qui génère l'identifiant partagé doit donc être un numéro unique dans son système.", alias="caseId")
    request_id: Annotated[str, Field(strict=True)] = Field(description="A valoriser avec l'identifiant unique partagé de la demande de ressource,  généré une seule fois par le système du partenaire qui émet la demande  Il est valorisé comme suit lors de sa création :  {orgID}.request.{ID unique de la demande dans le système émetteur}  OU - uniquement si un ID unique de la demande n'est pas disponible :  OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}", alias="requestId")
    response: Response
    __properties: ClassVar[List[str]] = ["caseId", "requestId", "response"]

    @field_validator('case_id')
    def case_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^fr(\.[\w-]+){3,4}$", value):
            raise ValueError(r"must validate the regular expression /^fr(\.[\w-]+){3,4}$/")
        return value

    @field_validator('request_id')
    def request_id_validate_regular_expression(cls, value):
        """Validates the regular expression"""
        if not re.match(r"^([\w-]+\.){3,4}request(\.[\w-]+){1,2}$", value):
            raise ValueError(r"must validate the regular expression /^([\w-]+\.){3,4}request(\.[\w-]+){1,2}$/")
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
        """Create an instance of ResourcesResponse from a JSON string"""
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
        # override the default output from pydantic by calling `to_dict()` of response
        if self.response:
            _dict['response'] = self.response.to_dict()
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of ResourcesResponse from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "caseId": obj.get("caseId"),
            "requestId": obj.get("requestId"),
            "response": Response.from_dict(obj["response"]) if obj.get("response") is not None else None
        })
        return _obj

