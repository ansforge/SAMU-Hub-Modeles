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

from pydantic import BaseModel, ConfigDict, Field, StrictInt, StrictStr
from typing import Any, ClassVar, Dict, List, Optional
from typing import Optional, Set
from typing_extensions import Self

class Attachment(BaseModel):
    """
    Attachment
    """ # noqa: E501
    description: Optional[StrictStr] = Field(default=None, description="Décrit la ressource en précisant le type et le contenu, tels que «carte» ou «photo»")
    mime_type: Optional[StrictStr] = Field(default=None, description="L'identifiant du type MIME de contenu et sous-type décrivant la ressource", alias="mimeType")
    size: Optional[StrictInt] = Field(default=None, description="Taille approximative de la ressource en kO")
    uri: StrictStr = Field(description="Une URI, généralement une URL, qui permet d'atteindre la ressource sur Internet ou sur un réseau privé Nous suggérons d'employer le format suivant de regex (https?|ftp|file)://([\\w-]+(\\.[\\w-]+)*)(/[\\w\\-\\.]*)*/?(\\?[^\\s]*)?", alias="URI")
    deref_uri: Optional[StrictStr] = Field(default=None, description="Peut être utilisé à la place de l'élément 'URI' pour envoyer la ressource encodée en base64 pour éviter des problèmes de transcodage (sur des double quotes qui casseraient le message, …)", alias="derefURI")
    digest: Optional[StrictStr] = Field(default=None, description="Hash de la ressource pour confirmer la réception de la bonne ressource La ressource est hashée avec le protocole SHA-256")
    __properties: ClassVar[List[str]] = ["description", "mimeType", "size", "URI", "derefURI", "digest"]

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
        """Create an instance of Attachment from a JSON string"""
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
        return _dict

    @classmethod
    def from_dict(cls, obj: Optional[Dict[str, Any]]) -> Optional[Self]:
        """Create an instance of Attachment from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "description": obj.get("description"),
            "mimeType": obj.get("mimeType"),
            "size": obj.get("size"),
            "URI": obj.get("URI"),
            "derefURI": obj.get("derefURI"),
            "digest": obj.get("digest")
        })
        return _obj

