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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:10:46.052+01:00[Europe/Paris]")
public class Etype {
                  /**
   * Le champ peut ne pas être interprété ou renseigné avec une valeur comme &#39;UKN&#39; &#x3D; &#39;UNKOWN&#39;
   */
  public enum CATEGORYEnum {
    ASB("/ASB"),
    
    ASR("/ASR"),
    
    EXP("/EXP"),
    
    FIR("/FIR"),
    
    FLD("/FLD"),
    
    GND("/GND"),
    
    HLT("/HLT"),
    
    POL("/POL"),
    
    PSW("/PSW"),
    
    TRP("/TRP"),
    
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
    COAST("/COAST"),
    
    INW("/INW"),
    
    NAT("/NAT"),
    
    OSEA("/OSEA"),
    
    OTH("/OTH"),
    
    RAIL("/RAIL"),
    
    ROAD("/ROAD"),
    
    UDGN("/UDGN"),
    
    URB("/URB"),
    
    COAST_BNK("/COAST/BNK"),
    
    COAST_CLF("/COAST/CLF"),
    
    COAST_CSTW("/COAST/CSTW"),
    
    COAST_EST("/COAST/EST"),
    
    COAST_FEN("/COAST/FEN"),
    
    INW_BOG("/INW/BOG"),
    
    INW_CAN("/INW/CAN"),
    
    INW_ICELK("/INW/ICELK"),
    
    INW_LKE("/INW/LKE"),
    
    INW_RIV("/INW/RIV"),
    
    NAT_CRP("/NAT/CRP"),
    
    NAT_GRS("/NAT/GRS"),
    
    NAT_HFR("/NAT/HFR"),
    
    NAT_HLS("/NAT/HLS"),
    
    NAT_HMT("/NAT/HMT"),
    
    NAT_LMT("/NAT/LMT"),
    
    NAT_SSSI("/NAT/SSSI"),
    
    OSEA_OFF("/OSEA/OFF"),
    
    OTH_CUT("/OTH/CUT"),
    
    OTH_ELV("/OTH/ELV"),
    
    OTH_EMB("/OTH/EMB"),
    
    OTH_LFR("/OTH/LFR"),
    
    OTH_SRB("/OTH/SRB"),
    
    PRIVAT("/PRIVAT"),
    
    RAIL_TRK("/RAIL/TRK"),
    
    ROAD_1RD("/ROAD/1RD"),
    
    ROAD_DCA("/ROAD/DCA"),
    
    ROAD_NOR("/ROAD/NOR"),
    
    ROAD_PTH("/ROAD/PTH"),
    
    ROAD_RRD("/ROAD/RRD"),
    
    ROAD_SRD("/ROAD/SRD"),
    
    ROAD_TRK("/ROAD/TRK"),
    
    UDGN_MIN("/UDGN/MIN"),
    
    UDGN_TUN("/UDGN/TUN"),
    
    UDGN_UND("/UDGN/UND"),
    
    URB_ASR("/URB/ASR"),
    
    URB_HOSP("/URB/HOSP"),
    
    URB_IND("/URB/IND"),
    
    URB_MALL("/URB/MALL"),
    
    URB_OFF("/URB/OFF"),
    
    URB_PRK("/URB/PRK"),
    
    URB_RES("/URB/RES"),
    
    URB_STRT("/URB/STRT");

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
    CDIS("/CDIS"),
    
    DIS("/DIS"),
    
    TER("/TER"),
    
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
                if (CATEGORY == null) { return; }
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
                if (ACTOR == null) { return; }
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
                if (LOCTYPE == null) { return; }
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
