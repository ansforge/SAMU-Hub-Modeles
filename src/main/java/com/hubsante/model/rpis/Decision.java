/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.rpis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Decision
 */
@JsonPropertyOrder({Decision.JSON_PROPERTY_RESOURCE_CATEGORY,
                    Decision.JSON_PROPERTY_RESOURCE_TYPE,
                    Decision.JSON_PROPERTY_TEAM_CARE})
@JsonTypeName("decision")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Decision {

  /**
   * Précise le type de moyen engagé dans l&#39;intervention (SMUR, TSU, HOSPIT,
   * etc.).  A valoriser par un code de la nomenclature SI-SAMU-TYPE_MOYEN.
   */
  public enum ResourceCategoryEnum {
    SMUR("SMUR"),

    SMUR_ADULT("SMUR.ADULT"),

    SMUR_PED("SMUR.PED"),

    SMUR_UMH_S("SMUR.UMH-S"),

    SMUR_CUMP("SMUR.CUMP"),

    HOSPIT("HOSPIT"),

    LIBERAL("LIBERAL"),

    LIBERAL_MG("LIBERAL.MG"),

    LIBERAL_PHARM("LIBERAL.PHARM"),

    LIBERAL_INF("LIBERAL.INF"),

    LIBERAL_KINE("LIBERAL.KINE"),

    LIBERAL_SOS("LIBERAL.SOS"),

    LIBERAL_MMG("LIBERAL.MMG"),

    LIBERAL_MSPD("LIBERAL.MSPD"),

    LIBERAL_MCS("LIBERAL.MCS"),

    LIBERAL_SPEMED("LIBERAL.SPEMED"),

    LIBERAL_DENT("LIBERAL.DENT"),

    LIBERAL_LABO("LIBERAL.LABO"),

    LIBERAL_AUTREPRO("LIBERAL.AUTREPRO"),

    TSU_("TSU "),

    SIS("SIS"),

    SIS_MEDSP("SIS.MEDSP"),

    SIS_ISP("SIS.ISP"),

    SIS_SP("SIS.SP"),

    AASC("AASC"),

    FDO("FDO"),

    FDO_PN("FDO.PN"),

    FDO_GEND("FDO.GEND"),

    FDO_PM("FDO.PM"),

    FDO_DOUANES("FDO.DOUANES"),

    AUTRE("AUTRE"),

    AUTRE_ADM("AUTRE.ADM"),

    AUTRE_DAE("AUTRE.DAE"),

    AUTRE_AUTRE("AUTRE.AUTRE");

    private String value;

    ResourceCategoryEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResourceCategoryEnum fromValue(String value) {
      for (ResourceCategoryEnum b : ResourceCategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RESOURCE_CATEGORY =
      "resourceCategory";
  private ResourceCategoryEnum resourceCategory;

  /**
   * Précise le type de véhicule terrestre / aérien / maritime engagé dans
   * l&#39;intervention. A valoriser par un code de la nomenclature
   * SI-SAMU-TYPE_VECTEUR.
   */
  public enum ResourceTypeEnum {
    AASC("AASC"),

    AASC_VLSC("AASC.VLSC"),

    AASC_VPSP("AASC.VPSP"),

    AASC_AUTRESC("AASC.AUTRESC"),

    AUTREVEC("AUTREVEC"),

    AUTREVEC_APIED("AUTREVEC.APIED"),

    AUTREVEC_AVION("AUTREVEC.AVION"),

    AUTREVEC_PERSO("AUTREVEC.PERSO"),

    AUTREVEC_TAXI("AUTREVEC.TAXI"),

    AUTREVEC_TRAIN("AUTREVEC.TRAIN"),

    AUTREVEC_TRANSP("AUTREVEC.TRANSP"),

    AUTREVEC_AUTRE("AUTREVEC.AUTRE"),

    AUTREVEC_AUTRETRA("AUTREVEC.AUTRETRA"),

    FSI("FSI"),

    FSI_HELIFSI("FSI.HELIFSI"),

    FSI_VLFSI("FSI.VLFSI"),

    FSI_FFSI("FSI.FFSI"),

    FSI_VHFSI("FSI.VHFSI"),

    LIB("LIB"),

    LIB_MEDV("LIB.MEDV"),

    LIB_INF("LIB.INF"),

    LIB_AUTREPRO("LIB.AUTREPRO"),

    SIS("SIS"),

    SIS_DRAGON("SIS.DRAGON"),

    SIS_AVSC("SIS.AVSC"),

    SIS_FEUSIS("SIS.FEUSIS"),

    SIS_GRIMP("SIS.GRIMP"),

    SIS_NAVISIS("SIS.NAVISIS"),

    SIS_PCSIS("SIS.PCSIS"),

    SIS_SRSIS("SIS.SRSIS"),

    SIS_VCH("SIS.VCH"),

    SIS_VLCG("SIS.VLCG"),

    SIS_VLISP("SIS.VLISP"),

    SIS_VLMSP("SIS.VLMSP"),

    SIS_VLSIS("SIS.VLSIS"),

    SIS_VPL("SIS.VPL"),

    SIS_VPMA("SIS.VPMA"),

    SIS_VR("SIS.VR"),

    SIS_VSAV("SIS.VSAV"),

    SIS_MOYSSE("SIS.MOYSSE"),

    SIS_AUTRESIS("SIS.AUTRESIS"),

    SMUR("SMUR"),

    SMUR_VLM("SMUR.VLM"),

    SMUR_VL("SMUR.VL"),

    SMUR_PSM1("SMUR.PSM1"),

    SMUR_PSM2("SMUR.PSM2"),

    SMUR_PSM3("SMUR.PSM3"),

    SMUR_PSMP("SMUR.PSMP"),

    SMUR_VPC("SMUR.VPC"),

    SMUR_AR("SMUR.AR"),

    SMUR_AR_BAR("SMUR.AR-BAR"),

    SMUR_AR_PED("SMUR.AR-PED"),

    SMUR_HELISMUR("SMUR.HELISMUR"),

    SMUR_HELISAN("SMUR.HELISAN"),

    SMUR_AVSMUR("SMUR.AVSMUR"),

    SMUR_AVSAN("SMUR.AVSAN"),

    SMUR_NAVISMUR("SMUR.NAVISMUR"),

    TSU("TSU"),

    TSU_VSL("TSU.VSL"),

    TSU_AMB_GV("TSU.AMB-GV"),

    TSU_AMB_PV("TSU.AMB-PV"),

    TSU_AMB_BAR("TSU.AMB-BAR"),

    TSU_AMB("TSU.AMB");

    private String value;

    ResourceTypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResourceTypeEnum fromValue(String value) {
      for (ResourceTypeEnum b : ResourceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resourceType";
  private ResourceTypeEnum resourceType;

  /**
   * Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code
   * de la nomenclature SI-SAMU-NIVSOIN.
   */
  public enum TeamCareEnum {
    MED("MED"),

    PARAMED("PARAMED"),

    SECOURS("SECOURS");

    private String value;

    TeamCareEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TeamCareEnum fromValue(String value) {
      for (TeamCareEnum b : TeamCareEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TEAM_CARE = "medicalLevel";
  private TeamCareEnum medicalLevel;

  public Decision() {}

  public Decision resourceCategory(ResourceCategoryEnum resourceCategory) {

    this.resourceCategory = resourceCategory;
    return this;
  }

  /**
   * Précise le type de moyen engagé dans l&#39;intervention (SMUR, TSU, HOSPIT,
   *etc.).  A valoriser par un code de la nomenclature SI-SAMU-TYPE_MOYEN.
   * @return resourceCategory
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceCategoryEnum getResourceCategory() {
    return resourceCategory;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_CATEGORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceCategory(ResourceCategoryEnum resourceCategory) {
    this.resourceCategory = resourceCategory;
  }

  public Decision resourceType(ResourceTypeEnum resourceType) {

    this.resourceType = resourceType;
    return this;
  }

  /**
   * Précise le type de véhicule terrestre / aérien / maritime engagé dans
   *l&#39;intervention. A valoriser par un code de la nomenclature
   *SI-SAMU-TYPE_VECTEUR.
   * @return resourceType
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceTypeEnum getResourceType() {
    return resourceType;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
  }

  public Decision medicalLevel(TeamCareEnum medicalLevel) {

    this.medicalLevel = medicalLevel;
    return this;
  }

  /**
   * Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code
   *de la nomenclature SI-SAMU-NIVSOIN.
   * @return medicalLevel
   **/
  @JsonProperty(JSON_PROPERTY_TEAM_CARE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TeamCareEnum getTeamCare() {
    return medicalLevel;
  }

  @JsonProperty(JSON_PROPERTY_TEAM_CARE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTeamCare(TeamCareEnum medicalLevel) {
    this.medicalLevel = medicalLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Decision decision = (Decision)o;
    return Objects.equals(this.resourceCategory, decision.resourceCategory) &&
        Objects.equals(this.resourceType, decision.resourceType) &&
        Objects.equals(this.medicalLevel, decision.medicalLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceCategory, resourceType, medicalLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Decision {\n");
    sb.append("    resourceCategory: ")
        .append(toIndentedString(resourceCategory))
        .append("\n");
    sb.append("    resourceType: ")
        .append(toIndentedString(resourceType))
        .append("\n");
    sb.append("    medicalLevel: ").append(toIndentedString(medicalLevel)).append("\n");
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
