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
from typing_extensions import Annotated
from typing import Optional, Set
from typing_extensions import Self

class Etype(BaseModel):
    """
    Etype
    """ # noqa: E501
    category: Annotated[List[StrictStr], Field(min_length=1)] = Field(alias="CATEGORY")
    actor: Annotated[List[StrictStr], Field(min_length=1)] = Field(alias="ACTOR")
    loctype: Annotated[List[StrictStr], Field(min_length=1)] = Field(alias="LOCTYPE")
    env: Optional[StrictStr] = Field(default=None, description="Optionnel", alias="ENV")
    __properties: ClassVar[List[str]] = ["CATEGORY", "ACTOR", "LOCTYPE", "ENV"]

    @field_validator('category')
    def category_validate_enum(cls, value):
        """Validates the enum"""
        for i in value:
            if i not in set(['ASB', 'ASR', 'EXP', 'FIR', 'FLD', 'GND', 'HLT', 'POL', 'PSW', 'TRP', 'ASB/ABV', 'ASR/ATM', 'ASR/HGT', 'ASR/ICE', 'ASR/MAR', 'ASR/SIL', 'ASR/TRP', 'ASR/UDG', 'ASR/WAT', 'EXP/AER', 'EXP/AMM', 'EXP/BLEVE', 'EXP/CHM', 'EXP/CYL', 'EXP/DST', 'EXP/FRW', 'EXP/GAS', 'EXP/HGHFLM', 'EXP/HPP', 'EXP/IMP', 'EXP/LPG', 'EXP/NUK', 'EXP/PRD', 'EXP/UKN', 'FIR/CLA', 'FIR/CLB', 'FIR/CLC', 'FIR/CLD', 'FIR/UKN', 'FLD/FLS', 'FLD/PLN', 'FLD/TID', 'GND/AVL', 'GND/EQK', 'GND/GEY', 'GND/LDS', 'GND/MUD', 'GND/SUB', 'GND/VUL', 'HLT/EPI', 'HLT/FMN', 'HLT/NDS', 'POL/BIO', 'POL/CHM', 'POL/NUK', 'POL/RAD', 'PSW/ALM', 'PSW/ASY', 'PSW/DEM', 'PSW/IMM', 'PSW/MEV', 'PSW/MIS', 'PSW/PKG', 'PSW/PRO', 'PSW/PRSUIT', 'PSW/RIOT', 'PSW/SUS', 'PSW/WNG', 'TRP/BRK', 'TRP/COL', 'TRP/CRS']):
                raise ValueError("each list item must be one of ('ASB', 'ASR', 'EXP', 'FIR', 'FLD', 'GND', 'HLT', 'POL', 'PSW', 'TRP', 'ASB/ABV', 'ASR/ATM', 'ASR/HGT', 'ASR/ICE', 'ASR/MAR', 'ASR/SIL', 'ASR/TRP', 'ASR/UDG', 'ASR/WAT', 'EXP/AER', 'EXP/AMM', 'EXP/BLEVE', 'EXP/CHM', 'EXP/CYL', 'EXP/DST', 'EXP/FRW', 'EXP/GAS', 'EXP/HGHFLM', 'EXP/HPP', 'EXP/IMP', 'EXP/LPG', 'EXP/NUK', 'EXP/PRD', 'EXP/UKN', 'FIR/CLA', 'FIR/CLB', 'FIR/CLC', 'FIR/CLD', 'FIR/UKN', 'FLD/FLS', 'FLD/PLN', 'FLD/TID', 'GND/AVL', 'GND/EQK', 'GND/GEY', 'GND/LDS', 'GND/MUD', 'GND/SUB', 'GND/VUL', 'HLT/EPI', 'HLT/FMN', 'HLT/NDS', 'POL/BIO', 'POL/CHM', 'POL/NUK', 'POL/RAD', 'PSW/ALM', 'PSW/ASY', 'PSW/DEM', 'PSW/IMM', 'PSW/MEV', 'PSW/MIS', 'PSW/PKG', 'PSW/PRO', 'PSW/PRSUIT', 'PSW/RIOT', 'PSW/SUS', 'PSW/WNG', 'TRP/BRK', 'TRP/COL', 'TRP/CRS')")
        return value

    @field_validator('actor')
    def actor_validate_enum(cls, value):
        """Validates the enum"""
        for i in value:
            if i not in set(['ANI', 'BEV', 'PPL', 'VEH', 'ANI/CON', 'ANI/DEA', 'ANI/DGR', 'ANI/FRM', 'ANI/HRD', 'ANI/INJ', 'ANI/LIV', 'ANI/PET', 'ANI/PRO', 'ANI/SPC', 'ANI/WLD', 'BEV/ASR', 'BEV/IND', 'BEV/NRES', 'BEV/OFF', 'BEV/OTH', 'BEV/RESDW', 'BEV/RESIN', 'BEV/RESINT', 'BEV/RESOTH', 'BEV/SHP', 'PPL/1', 'PPL/ADU', 'PPL/CHD', 'PPL/CNT', 'PPL/DED', 'PPL/EVC', 'PPL/GND', 'PPL/GRP', 'PPL/HST', 'PPL/INT', 'PPL/OTH', 'PPL/PRS', 'PPL/SNS', 'PPL/VIO', 'PPL/VLN', 'PPL/WTN', 'PPL/CHD/BAB', 'PPL/CHD/CHILD', 'PPL/CHD/INF', 'PPL/CHD/YOUTH', 'PPL/GND/FML', 'PPL/GND/MAL', 'PPL/GND/UND', 'PPL/HST/PCF', 'PPL/HST/SUI', 'PPL/HST/THT', 'PPL/HST/WPN', 'PPL/PRS/CST', 'PPL/PRS/ESC', 'PPL/PRS/HGS', 'PPL/SNS/ETH', 'PPL/SNS/FOR', 'PPL/SNS/LAN', 'PPL/SNS/REL', 'PPL/SNS/VIP', 'PPL/VLN/BLD', 'PPL/VLN/DEF', 'PPL/VLN/DSB', 'PPL/VLN/ELD', 'PPL/VLN/INJ', 'PPL/VLN/LDF', 'PPL/VLN/OBS', 'PPL/VLN/PAT', 'PPL/VLN/PGN', 'PPL/VLN/SLFPRS', 'PPL/VLN/UNC', 'VEH/AIR', 'VEH/ANI', 'VEH/BIC', 'VEH/CAR', 'VEH/EMG', 'VEH/MBK', 'VEH/MIL', 'VEH/OTH', 'VEH/TRK', 'VEH/TRN', 'VEH/VES', 'VEH/AIR/ARM', 'VEH/AIR/FLBA', 'VEH/AIR/FRG', 'VEH/AIR/FXBA', 'VEH/AIR/GLD', 'VEH/AIR/HEL', 'VEH/AIR/HVY', 'VEH/AIR/JET', 'VEH/AIR/LGT', 'VEH/AIR/MIL', 'VEH/AIR/ORD', 'VEH/AIR/OTH', 'VEH/AIR/PAS', 'VEH/AIR/PRBA', 'VEH/AIR/PST', 'VEH/AIR/RKT', 'VEH/AIR/SEA', 'VEH/AIR/SNO', 'VEH/AIR/TNK', 'VEH/AIR/UAV', 'VEH/AIR/ULG', 'VEH/OTH/HIL', 'VEH/OTH/SNO', 'VEH/TRK/ART', 'VEH/TRK/EXC', 'VEH/TRK/HZD', 'VEH/TRK/NHZ', 'VEH/TRK/NUK', 'VEH/TRK/REF', 'VEH/TRK/UND', 'VEH/TRN/3RL', 'VEH/TRN/DSL', 'VEH/TRN/HZD', 'VEH/TRN/LOC', 'VEH/TRN/NHZ', 'VEH/TRN/NUK', 'VEH/TRN/OVH', 'VEH/TRN/PAS', 'VEH/TRN/REF', 'VEH/TRN/STM', 'VEH/TRN/TRM', 'VEH/TRN/UDG', 'VEH/TRN/UND', 'VEH/TRN/VIP', 'VEH/TRN/VLT', 'VEH/VES/AMB', 'VEH/VES/BOT', 'VEH/VES/CNO', 'VEH/VES/CRG', 'VEH/VES/DSL', 'VEH/VES/FLO', 'VEH/VES/FRY', 'VEH/VES/HOV', 'VEH/VES/HZD', 'VEH/VES/JSK', 'VEH/VES/LEI', 'VEH/VES/LIS', 'VEH/VES/MIL', 'VEH/VES/MPW', 'VEH/VES/NHZ', 'VEH/VES/NUK', 'VEH/VES/PAS', 'VEH/VES/POL', 'VEH/VES/PTL', 'VEH/VES/RSC', 'VEH/VES/SAI', 'VEH/VES/SBM', 'VEH/VES/SINK', 'VEH/VES/SPC', 'VEH/VES/STE', 'VEH/VES/SUNK', 'VEH/VES/UNM']):
                raise ValueError("each list item must be one of ('ANI', 'BEV', 'PPL', 'VEH', 'ANI/CON', 'ANI/DEA', 'ANI/DGR', 'ANI/FRM', 'ANI/HRD', 'ANI/INJ', 'ANI/LIV', 'ANI/PET', 'ANI/PRO', 'ANI/SPC', 'ANI/WLD', 'BEV/ASR', 'BEV/IND', 'BEV/NRES', 'BEV/OFF', 'BEV/OTH', 'BEV/RESDW', 'BEV/RESIN', 'BEV/RESINT', 'BEV/RESOTH', 'BEV/SHP', 'PPL/1', 'PPL/ADU', 'PPL/CHD', 'PPL/CNT', 'PPL/DED', 'PPL/EVC', 'PPL/GND', 'PPL/GRP', 'PPL/HST', 'PPL/INT', 'PPL/OTH', 'PPL/PRS', 'PPL/SNS', 'PPL/VIO', 'PPL/VLN', 'PPL/WTN', 'PPL/CHD/BAB', 'PPL/CHD/CHILD', 'PPL/CHD/INF', 'PPL/CHD/YOUTH', 'PPL/GND/FML', 'PPL/GND/MAL', 'PPL/GND/UND', 'PPL/HST/PCF', 'PPL/HST/SUI', 'PPL/HST/THT', 'PPL/HST/WPN', 'PPL/PRS/CST', 'PPL/PRS/ESC', 'PPL/PRS/HGS', 'PPL/SNS/ETH', 'PPL/SNS/FOR', 'PPL/SNS/LAN', 'PPL/SNS/REL', 'PPL/SNS/VIP', 'PPL/VLN/BLD', 'PPL/VLN/DEF', 'PPL/VLN/DSB', 'PPL/VLN/ELD', 'PPL/VLN/INJ', 'PPL/VLN/LDF', 'PPL/VLN/OBS', 'PPL/VLN/PAT', 'PPL/VLN/PGN', 'PPL/VLN/SLFPRS', 'PPL/VLN/UNC', 'VEH/AIR', 'VEH/ANI', 'VEH/BIC', 'VEH/CAR', 'VEH/EMG', 'VEH/MBK', 'VEH/MIL', 'VEH/OTH', 'VEH/TRK', 'VEH/TRN', 'VEH/VES', 'VEH/AIR/ARM', 'VEH/AIR/FLBA', 'VEH/AIR/FRG', 'VEH/AIR/FXBA', 'VEH/AIR/GLD', 'VEH/AIR/HEL', 'VEH/AIR/HVY', 'VEH/AIR/JET', 'VEH/AIR/LGT', 'VEH/AIR/MIL', 'VEH/AIR/ORD', 'VEH/AIR/OTH', 'VEH/AIR/PAS', 'VEH/AIR/PRBA', 'VEH/AIR/PST', 'VEH/AIR/RKT', 'VEH/AIR/SEA', 'VEH/AIR/SNO', 'VEH/AIR/TNK', 'VEH/AIR/UAV', 'VEH/AIR/ULG', 'VEH/OTH/HIL', 'VEH/OTH/SNO', 'VEH/TRK/ART', 'VEH/TRK/EXC', 'VEH/TRK/HZD', 'VEH/TRK/NHZ', 'VEH/TRK/NUK', 'VEH/TRK/REF', 'VEH/TRK/UND', 'VEH/TRN/3RL', 'VEH/TRN/DSL', 'VEH/TRN/HZD', 'VEH/TRN/LOC', 'VEH/TRN/NHZ', 'VEH/TRN/NUK', 'VEH/TRN/OVH', 'VEH/TRN/PAS', 'VEH/TRN/REF', 'VEH/TRN/STM', 'VEH/TRN/TRM', 'VEH/TRN/UDG', 'VEH/TRN/UND', 'VEH/TRN/VIP', 'VEH/TRN/VLT', 'VEH/VES/AMB', 'VEH/VES/BOT', 'VEH/VES/CNO', 'VEH/VES/CRG', 'VEH/VES/DSL', 'VEH/VES/FLO', 'VEH/VES/FRY', 'VEH/VES/HOV', 'VEH/VES/HZD', 'VEH/VES/JSK', 'VEH/VES/LEI', 'VEH/VES/LIS', 'VEH/VES/MIL', 'VEH/VES/MPW', 'VEH/VES/NHZ', 'VEH/VES/NUK', 'VEH/VES/PAS', 'VEH/VES/POL', 'VEH/VES/PTL', 'VEH/VES/RSC', 'VEH/VES/SAI', 'VEH/VES/SBM', 'VEH/VES/SINK', 'VEH/VES/SPC', 'VEH/VES/STE', 'VEH/VES/SUNK', 'VEH/VES/UNM')")
        return value

    @field_validator('env')
    def env_validate_enum(cls, value):
        """Validates the enum"""
        if value is None:
            return value

        if value not in set(['CDIS', 'DIS', 'TER', 'CDIS/RIOT', 'DIS/CBRN', 'DIS/ERTHQK', 'DIS/FIRE', 'DIS/FLOOD', 'DIS/INDHAZ', 'DIS/LNDSLD', 'DIS/PWROUT', 'DIS/RADCNT', 'DIS/SNOW', 'DIS/STCLPS', 'DIS/STORM', 'DIS/TRSPRT', 'DIS/TSNAMI']):
            raise ValueError("must be one of enum values ('CDIS', 'DIS', 'TER', 'CDIS/RIOT', 'DIS/CBRN', 'DIS/ERTHQK', 'DIS/FIRE', 'DIS/FLOOD', 'DIS/INDHAZ', 'DIS/LNDSLD', 'DIS/PWROUT', 'DIS/RADCNT', 'DIS/SNOW', 'DIS/STCLPS', 'DIS/STORM', 'DIS/TRSPRT', 'DIS/TSNAMI')")
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
        """Create an instance of Etype from a JSON string"""
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
        """Create an instance of Etype from a dict"""
        if obj is None:
            return None

        if not isinstance(obj, dict):
            return cls.model_validate(obj)

        _obj = cls.model_validate({
            "CATEGORY": obj.get("CATEGORY"),
            "ACTOR": obj.get("ACTOR"),
            "LOCTYPE": obj.get("LOCTYPE"),
            "ENV": obj.get("ENV")
        })
        return _obj


