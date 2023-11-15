/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hubsante.model.emsi;

import java.util.Objects;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Etype
 */
@JsonPropertyOrder({
        Etype.JSON_PROPERTY_C_A_T_E_G_O_R_Y,
        Etype.JSON_PROPERTY_A_C_T_O_R,
        Etype.JSON_PROPERTY_L_O_C_T_Y_P_E,
        Etype.JSON_PROPERTY_E_N_V
})
@JsonTypeName("etype")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-09T17:02:55.258+01:00[Europe/Paris]")
public class Etype {
    /**
     * Le champ peut ne pas être interprété ou renseigné avec une valeur comme &#39;UKN&#39; &#x3D; &#39;UNKOWN&#39;
     */
    public enum CATEGORYEnum {
        ASB("ASB"),

        ASR("ASR"),

        EXP("EXP"),

        FIR("FIR"),

        FLD("FLD"),

        GND("GND"),

        HLT("HLT"),

        POL("POL"),

        PSW("PSW"),

        TRP("TRP"),

        ASB_ABV("/ASB/ABV"),

        ASR_ATM("/ASR/ATM"),

        ASR_HGT("/ASR/HGT"),

        ASR_ICE("/ASR/ICE"),

        ASR_MAR("/ASR/MAR"),

        ASR_SIL("/ASR/SIL"),

        ASR_TRP("/ASR/TRP"),

        ASR_UDG("/ASR/UDG"),

        ASR_WAT("/ASR/WAT"),

        EXP_AER("/EXP/AER"),

        EXP_AMM("/EXP/AMM"),

        EXP_BLEVE("/EXP/BLEVE"),

        EXP_CHM("/EXP/CHM"),

        EXP_CYL("/EXP/CYL"),

        EXP_DST("/EXP/DST"),

        EXP_FRW("/EXP/FRW"),

        EXP_GAS("/EXP/GAS"),

        EXP_HGHFLM("/EXP/HGHFLM"),

        EXP_HPP("/EXP/HPP"),

        EXP_IMP("/EXP/IMP"),

        EXP_LPG("/EXP/LPG"),

        EXP_NUK("/EXP/NUK"),

        EXP_PRD("/EXP/PRD"),

        EXP_UKN("/EXP/UKN"),

        FIR_CLA("/FIR/CLA"),

        FIR_CLB("/FIR/CLB"),

        FIR_CLC("/FIR/CLC"),

        FIR_CLD("/FIR/CLD"),

        FIR_UKN("/FIR/UKN"),

        FLD_FLS("/FLD/FLS"),

        FLD_PLN("/FLD/PLN"),

        FLD_TID("/FLD/TID"),

        GND_AVL("/GND/AVL"),

        GND_EQK("/GND/EQK"),

        GND_GEY("/GND/GEY"),

        GND_LDS("/GND/LDS"),

        GND_MUD("/GND/MUD"),

        GND_SUB("/GND/SUB"),

        GND_VUL("/GND/VUL"),

        HLT_EPI("/HLT/EPI"),

        HLT_FMN("/HLT/FMN"),

        HLT_NDS("/HLT/NDS"),

        POL_BIO("/POL/BIO"),

        POL_CHM("/POL/CHM"),

        POL_NUK("/POL/NUK"),

        POL_RAD("/POL/RAD"),

        PSW_ALM("/PSW/ALM"),

        PSW_ASY("/PSW/ASY"),

        PSW_DEM("/PSW/DEM"),

        PSW_IMM("/PSW/IMM"),

        PSW_MEV("/PSW/MEV"),

        PSW_MIS("/PSW/MIS"),

        PSW_PKG("/PSW/PKG"),

        PSW_PRO("/PSW/PRO"),

        PSW_PRSUIT("/PSW/PRSUIT"),

        PSW_RIOT("/PSW/RIOT"),

        PSW_SUS("/PSW/SUS"),

        PSW_WNG("/PSW/WNG"),

        TRP_BRK("/TRP/BRK"),

        TRP_COL("/TRP/COL"),

        TRP_CRS("/TRP/CRS");

        private String value;

        CATEGORYEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static CATEGORYEnum fromValue(String value) {
            for (CATEGORYEnum b : CATEGORYEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_C_A_T_E_G_O_R_Y = "CATEGORY";
    private List<CATEGORYEnum> CATEGORY = new ArrayList<>();

    /**
     * Dans de futures versions de NexSIS, les demandes de concours seront diffusées à plusieurs partenaires. Seul le système de la force concernée par la demande de concours devra répondre effectivement à la demande. Ce système de la force concernée sera identifié comme le \&quot;concourant\&quot; à la demande de concours.  Le libellé du champ ACTOR permet d&#39;identifier le concourant souhaité dans la demande de concours. Pour les premières implémentations du contrat d&#39;interface 15-18, il n&#39;y a pas de nécessité pour les systèmes récepteurs de filtrer les demandes de concours reçues via le Hub Santé. Le champ MISSION TYPE permet en complément d&#39;identifier l&#39;effet à obtenir souhaité à partir de la combinaison du code ACTOR et du code TYPE. Le transcodage entre ces deux nomenclature est décrit dans l&#39;annexe \&quot;Référentiel Effets à Obtenir - correspondance EMSI\&quot;
     */
    public enum ACTOREnum {
        ANI("ANI"),

        BEV("BEV"),

        PPL("PPL"),

        VEH("VEH"),

        _ANI_CON("/ANI/CON"),

        _ANI_DEA("/ANI/DEA"),

        _ANI_DGR("/ANI/DGR"),

        _ANI_FRM("/ANI/FRM"),

        _ANI_HRD("/ANI/HRD"),

        _ANI_INJ("/ANI/INJ"),

        _ANI_LIV("/ANI/LIV"),

        _ANI_PET("/ANI/PET"),

        _ANI_PRO("/ANI/PRO"),

        _ANI_SPC("/ANI/SPC"),

        _ANI_WLD("/ANI/WLD"),

        _BEV_ASR("/BEV/ASR"),

        _BEV_IND("/BEV/IND"),

        _BEV_NRES("/BEV/NRES"),

        _BEV_OFF("/BEV/OFF"),

        _BEV_OTH("/BEV/OTH"),

        _BEV_RESDW("/BEV/RESDW"),

        _BEV_RESIN("/BEV/RESIN"),

        _BEV_RESINT("/BEV/RESINT"),

        _BEV_RESOTH("/BEV/RESOTH"),

        _BEV_SHP("/BEV/SHP"),

        _PPL_1("/PPL/1"),

        _PPL_ADU("/PPL/ADU"),

        _PPL_CHD("/PPL/CHD"),

        _PPL_CNT("/PPL/CNT"),

        _PPL_DED("/PPL/DED"),

        _PPL_EVC("/PPL/EVC"),

        _PPL_GND("/PPL/GND"),

        _PPL_GRP("/PPL/GRP"),

        _PPL_HST("/PPL/HST"),

        _PPL_INT("/PPL/INT"),

        _PPL_OTH("/PPL/OTH"),

        _PPL_PRS("/PPL/PRS"),

        _PPL_SNS("/PPL/SNS"),

        _PPL_VIO("/PPL/VIO"),

        _PPL_VLN("/PPL/VLN"),

        _PPL_WTN("/PPL/WTN"),

        _PPL_CHD_BAB("/PPL/CHD/BAB"),

        _PPL_CHD_CHILD("/PPL/CHD/CHILD"),

        _PPL_CHD_INF("/PPL/CHD/INF"),

        _PPL_CHD_YOUTH("/PPL/CHD/YOUTH"),

        _PPL_GND_FML("/PPL/GND/FML"),

        _PPL_GND_MAL("/PPL/GND/MAL"),

        _PPL_GND_UND("/PPL/GND/UND"),

        _PPL_HST_PCF("/PPL/HST/PCF"),

        _PPL_HST_SUI("/PPL/HST/SUI"),

        _PPL_HST_THT("/PPL/HST/THT"),

        _PPL_HST_WPN("/PPL/HST/WPN"),

        _PPL_PRS_CST("/PPL/PRS/CST"),

        _PPL_PRS_ESC("/PPL/PRS/ESC"),

        _PPL_PRS_HGS("/PPL/PRS/HGS"),

        _PPL_SNS_ETH("/PPL/SNS/ETH"),

        _PPL_SNS_FOR("/PPL/SNS/FOR"),

        _PPL_SNS_LAN("/PPL/SNS/LAN"),

        _PPL_SNS_REL("/PPL/SNS/REL"),

        _PPL_SNS_VIP("/PPL/SNS/VIP"),

        _PPL_VLN_BLD("/PPL/VLN/BLD"),

        _PPL_VLN_DEF("/PPL/VLN/DEF"),

        _PPL_VLN_DSB("/PPL/VLN/DSB"),

        _PPL_VLN_ELD("/PPL/VLN/ELD"),

        _PPL_VLN_INJ("/PPL/VLN/INJ"),

        _PPL_VLN_LDF("/PPL/VLN/LDF"),

        _PPL_VLN_OBS("/PPL/VLN/OBS"),

        _PPL_VLN_PAT("/PPL/VLN/PAT"),

        _PPL_VLN_PGN("/PPL/VLN/PGN"),

        _PPL_VLN_SLFPRS("/PPL/VLN/SLFPRS"),

        _PPL_VLN_UNC("/PPL/VLN/UNC"),

        _VEH_AIR("/VEH/AIR"),

        _VEH_ANI("/VEH/ANI"),

        _VEH_BIC("/VEH/BIC"),

        _VEH_CAR("/VEH/CAR"),

        _VEH_EMG("/VEH/EMG"),

        _VEH_MBK("/VEH/MBK"),

        _VEH_MIL("/VEH/MIL"),

        _VEH_OTH("/VEH/OTH"),

        _VEH_TRK("/VEH/TRK"),

        _VEH_TRN("/VEH/TRN"),

        _VEH_VES("/VEH/VES"),

        _VEH_AIR_ARM("/VEH/AIR/ARM"),

        _VEH_AIR_FLBA("/VEH/AIR/FLBA"),

        _VEH_AIR_FRG("/VEH/AIR/FRG"),

        _VEH_AIR_FXBA("/VEH/AIR/FXBA"),

        _VEH_AIR_GLD("/VEH/AIR/GLD"),

        _VEH_AIR_HEL("/VEH/AIR/HEL"),

        _VEH_AIR_HVY("/VEH/AIR/HVY"),

        _VEH_AIR_JET("/VEH/AIR/JET"),

        _VEH_AIR_LGT("/VEH/AIR/LGT"),

        _VEH_AIR_MIL("/VEH/AIR/MIL"),

        _VEH_AIR_ORD("/VEH/AIR/ORD"),

        _VEH_AIR_OTH("/VEH/AIR/OTH"),

        _VEH_AIR_PAS("/VEH/AIR/PAS"),

        _VEH_AIR_PRBA("/VEH/AIR/PRBA"),

        _VEH_AIR_PST("/VEH/AIR/PST"),

        _VEH_AIR_RKT("/VEH/AIR/RKT"),

        _VEH_AIR_SEA("/VEH/AIR/SEA"),

        _VEH_AIR_SNO("/VEH/AIR/SNO"),

        _VEH_AIR_TNK("/VEH/AIR/TNK"),

        _VEH_AIR_UAV("/VEH/AIR/UAV"),

        _VEH_AIR_ULG("/VEH/AIR/ULG"),

        _VEH_OTH_HIL("/VEH/OTH/HIL"),

        _VEH_OTH_SNO("/VEH/OTH/SNO"),

        _VEH_TRK_ART("/VEH/TRK/ART"),

        _VEH_TRK_EXC("/VEH/TRK/EXC"),

        _VEH_TRK_HZD("/VEH/TRK/HZD"),

        _VEH_TRK_NHZ("/VEH/TRK/NHZ"),

        _VEH_TRK_NUK("/VEH/TRK/NUK"),

        _VEH_TRK_REF("/VEH/TRK/REF"),

        _VEH_TRK_UND("/VEH/TRK/UND"),

        _VEH_TRN_3RL("/VEH/TRN/3RL"),

        _VEH_TRN_DSL("/VEH/TRN/DSL"),

        _VEH_TRN_HZD("/VEH/TRN/HZD"),

        _VEH_TRN_LOC("/VEH/TRN/LOC"),

        _VEH_TRN_NHZ("/VEH/TRN/NHZ"),

        _VEH_TRN_NUK("/VEH/TRN/NUK"),

        _VEH_TRN_OVH("/VEH/TRN/OVH"),

        _VEH_TRN_PAS("/VEH/TRN/PAS"),

        _VEH_TRN_REF("/VEH/TRN/REF"),

        _VEH_TRN_STM("/VEH/TRN/STM"),

        _VEH_TRN_TRM("/VEH/TRN/TRM"),

        _VEH_TRN_UDG("/VEH/TRN/UDG"),

        _VEH_TRN_UND("/VEH/TRN/UND"),

        _VEH_TRN_VIP("/VEH/TRN/VIP"),

        _VEH_TRN_VLT("/VEH/TRN/VLT"),

        _VEH_VES_AMB("/VEH/VES/AMB"),

        _VEH_VES_BOT("/VEH/VES/BOT"),

        _VEH_VES_CNO("/VEH/VES/CNO"),

        _VEH_VES_CRG("/VEH/VES/CRG"),

        _VEH_VES_DSL("/VEH/VES/DSL"),

        _VEH_VES_FLO("/VEH/VES/FLO"),

        _VEH_VES_FRY("/VEH/VES/FRY"),

        _VEH_VES_HOV("/VEH/VES/HOV"),

        _VEH_VES_HZD("/VEH/VES/HZD"),

        _VEH_VES_JSK("/VEH/VES/JSK"),

        _VEH_VES_LEI("/VEH/VES/LEI"),

        _VEH_VES_LIS("/VEH/VES/LIS"),

        _VEH_VES_MIL("/VEH/VES/MIL"),

        _VEH_VES_MPW("/VEH/VES/MPW"),

        _VEH_VES_NHZ("/VEH/VES/NHZ"),

        _VEH_VES_NUK("/VEH/VES/NUK"),

        _VEH_VES_PAS("/VEH/VES/PAS"),

        _VEH_VES_POL("/VEH/VES/POL"),

        _VEH_VES_PTL("/VEH/VES/PTL"),

        _VEH_VES_RSC("/VEH/VES/RSC"),

        _VEH_VES_SAI("/VEH/VES/SAI"),

        _VEH_VES_SBM("/VEH/VES/SBM"),

        _VEH_VES_SINK("/VEH/VES/SINK"),

        _VEH_VES_SPC("/VEH/VES/SPC"),

        _VEH_VES_STE("/VEH/VES/STE"),

        _VEH_VES_SUNK("/VEH/VES/SUNK"),

        _VEH_VES_UNM("/VEH/VES/UNM");

        private String value;

        ACTOREnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ACTOREnum fromValue(String value) {
            for (ACTOREnum b : ACTOREnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_A_C_T_O_R = "ACTOR";
    private List<ACTOREnum> ACTOR = new ArrayList<>();

    public static final String JSON_PROPERTY_L_O_C_T_Y_P_E = "LOCTYPE";
    private List<String> LOCTYPE = new ArrayList<>();

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     */
    public enum ENVEnum {
        CDIS("CDIS"),

        DIS("DIS"),

        TER("TER"),

        CDIS_RIOT("/CDIS/RIOT"),

        DIS_CBRN("/DIS/CBRN"),

        DIS_ERTHQK("/DIS/ERTHQK"),

        DIS_FIRE("/DIS/FIRE"),

        DIS_FLOOD("/DIS/FLOOD"),

        DIS_INDHAZ("/DIS/INDHAZ"),

        DIS_LNDSLD("/DIS/LNDSLD"),

        DIS_PWROUT("/DIS/PWROUT"),

        DIS_RADCNT("/DIS/RADCNT"),

        DIS_SNOW("/DIS/SNOW"),

        DIS_STCLPS("/DIS/STCLPS"),

        DIS_STORM("/DIS/STORM"),

        DIS_TRSPRT("/DIS/TRSPRT"),

        DIS_TSNAMI("/DIS/TSNAMI");

        private String value;

        ENVEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ENVEnum fromValue(String value) {
            for (ENVEnum b : ENVEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_E_N_V = "ENV";
    private ENVEnum ENV;

    public Etype() {
    }

    public Etype CATEGORY(List<CATEGORYEnum> CATEGORY) {

        this.CATEGORY = CATEGORY;
        return this;
    }

    public Etype addCATEGORYItem(CATEGORYEnum CATEGORYItem) {
        if (this.CATEGORY == null) {
            this.CATEGORY = new ArrayList<>();
        }
        this.CATEGORY.add(CATEGORYItem);
        return this;
    }

    /**
     * Get CATEGORY
     *
     * @return CATEGORY
     **/
    @JsonProperty(JSON_PROPERTY_C_A_T_E_G_O_R_Y)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<CATEGORYEnum> getCATEGORY() {
        return CATEGORY;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_C_A_T_E_G_O_R_Y)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCATEGORY(List<CATEGORYEnum> CATEGORY) {
        if (CATEGORY == null) {
            return;
        }
        if (this.CATEGORY == null) {
            this.CATEGORY = new ArrayList<>();
        }
        this.CATEGORY.addAll(CATEGORY);
    }


    public Etype ACTOR(List<ACTOREnum> ACTOR) {

        this.ACTOR = ACTOR;
        return this;
    }

    public Etype addACTORItem(ACTOREnum ACTORItem) {
        if (this.ACTOR == null) {
            this.ACTOR = new ArrayList<>();
        }
        this.ACTOR.add(ACTORItem);
        return this;
    }

    /**
     * Get ACTOR
     *
     * @return ACTOR
     **/
    @JsonProperty(JSON_PROPERTY_A_C_T_O_R)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<ACTOREnum> getACTOR() {
        return ACTOR;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_A_C_T_O_R)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setACTOR(List<ACTOREnum> ACTOR) {
        if (ACTOR == null) {
            return;
        }
        if (this.ACTOR == null) {
            this.ACTOR = new ArrayList<>();
        }
        this.ACTOR.addAll(ACTOR);
    }


    public Etype LOCTYPE(List<String> LOCTYPE) {

        this.LOCTYPE = LOCTYPE;
        return this;
    }

    public Etype addLOCTYPEItem(String LOCTYPEItem) {
        if (this.LOCTYPE == null) {
            this.LOCTYPE = new ArrayList<>();
        }
        this.LOCTYPE.add(LOCTYPEItem);
        return this;
    }

    /**
     * Get LOCTYPE
     *
     * @return LOCTYPE
     **/
    @JsonProperty(JSON_PROPERTY_L_O_C_T_Y_P_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getLOCTYPE() {
        return LOCTYPE;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_L_O_C_T_Y_P_E)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setLOCTYPE(List<String> LOCTYPE) {
        if (LOCTYPE == null) {
            return;
        }
        if (this.LOCTYPE == null) {
            this.LOCTYPE = new ArrayList<>();
        }
        this.LOCTYPE.addAll(LOCTYPE);
    }


    public Etype ENV(ENVEnum ENV) {

        this.ENV = ENV;
        return this;
    }

    /**
     * Dans le cadre d&#39;une demande de concours, optionnel. Le champ peut ne pas être émis ni interprété
     *
     * @return ENV
     **/
    @JsonProperty(JSON_PROPERTY_E_N_V)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ENVEnum getENV() {
        return ENV;
    }


    @JsonProperty(JSON_PROPERTY_E_N_V)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setENV(ENVEnum ENV) {
        this.ENV = ENV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Etype etype = (Etype) o;
        return Objects.equals(this.CATEGORY, etype.CATEGORY) &&
                Objects.equals(this.ACTOR, etype.ACTOR) &&
                Objects.equals(this.LOCTYPE, etype.LOCTYPE) &&
                Objects.equals(this.ENV, etype.ENV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CATEGORY
                , ACTOR
                , LOCTYPE
                , ENV);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Etype {\n");
        sb.append("    CATEGORY: ").append(toIndentedString(CATEGORY)).append("\n");
        sb.append("    ACTOR: ").append(toIndentedString(ACTOR)).append("\n");
        sb.append("    LOCTYPE: ").append(toIndentedString(LOCTYPE)).append("\n");
        sb.append("    ENV: ").append(toIndentedString(ENV)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
