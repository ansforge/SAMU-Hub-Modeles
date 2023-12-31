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

package com.hubsante.model.health;

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
 * CaseDetails
 */
@JsonPropertyOrder(
    {CaseDetails.JSON_PROPERTY_STATUS, CaseDetails.JSON_PROPERTY_TYPE,
     CaseDetails.JSON_PROPERTY_ATTRIBUTION, CaseDetails.JSON_PROPERTY_PRIORITY})
@JsonTypeName("caseDetails")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CaseDetails {

  /**
   * cf. cycle SI SAMU uniquement (si applicable) : échanger l&#39;état du
   * dossier si le cycle de vie du dossier est implémenté de manière conforme au
   * cycle de vie du dossier SI-SAMU
   */
  public enum StatusEnum {
    NOUVEAU_("Nouveau "),

    ACTIF_("Actif "),

    VALID_("Validé "),

    CL_TUR_("Clôturé "),

    CLASS_("Classé ");

    private String value;

    StatusEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_ATTRIBUTION = "attribution";
  private String attribution;

  /**
   * Décrit la priorité de régulation médicale du dossier.
   */
  public enum PriorityEnum {
    P0("P0"),

    P1("P1"),

    P2("P2"),

    P3("P3");

    private String value;

    PriorityEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriorityEnum fromValue(String value) {
      for (PriorityEnum b : PriorityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PRIORITY = "priority";
  private PriorityEnum priority;

  public CaseDetails() {}

  public CaseDetails status(StatusEnum status) {

    this.status = status;
    return this;
  }

  /**
   * cf. cycle SI SAMU uniquement (si applicable) : échanger l&#39;état du
   *dossier si le cycle de vie du dossier est implémenté de manière conforme au
   *cycle de vie du dossier SI-SAMU
   * @return status
   **/
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public CaseDetails type(String type) {

    this.type = type;
    return this;
  }

  /**
   * D/DR/DRM si cycle SI-SAMU implémenté
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }

  public CaseDetails attribution(String attribution) {

    this.attribution = attribution;
    return this;
  }

  /**
   * Décrit le type de professionnel médical à qui le dossier est attribué
   * @return attribution
   **/
  @JsonProperty(JSON_PROPERTY_ATTRIBUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAttribution() {
    return attribution;
  }

  @JsonProperty(JSON_PROPERTY_ATTRIBUTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttribution(String attribution) {
    this.attribution = attribution;
  }

  public CaseDetails priority(PriorityEnum priority) {

    this.priority = priority;
    return this;
  }

  /**
   * Décrit la priorité de régulation médicale du dossier.
   * @return priority
   **/
  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PriorityEnum getPriority() {
    return priority;
  }

  @JsonProperty(JSON_PROPERTY_PRIORITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPriority(PriorityEnum priority) {
    this.priority = priority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CaseDetails caseDetails = (CaseDetails)o;
    return Objects.equals(this.status, caseDetails.status) &&
        Objects.equals(this.type, caseDetails.type) &&
        Objects.equals(this.attribution, caseDetails.attribution) &&
        Objects.equals(this.priority, caseDetails.priority);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, type, attribution, priority);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaseDetails {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    attribution: ")
        .append(toIndentedString(attribution))
        .append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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
