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
    {CaseDetails.JSON_PROPERTY_PRIORITY, CaseDetails.JSON_PROPERTY_CARE_LEVEL})
@JsonTypeName("caseDetails")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CaseDetails {

  /**
   * Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3
   */
  public enum PriorityEnum {
    P0("P0"),

    P1("P1"),

    P2("P2"),

    P3("P3"),

    NR("NR");

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

  /**
   * Décrit le niveau de soins global du dossier identifié au cours de
   * l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins
   * différents pour chaque patient, on indique ici le niveau le plus grave.
   * cf.nomenclature associée.
   */
  public enum CareLevelEnum {
    R1("R1"),

    R2("R2"),

    R3("R3"),

    R4("R4");

    private String value;

    CareLevelEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CareLevelEnum fromValue(String value) {
      for (CareLevelEnum b : CareLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CARE_LEVEL = "careLevel";
  private CareLevelEnum careLevel;

  public CaseDetails() {}

  public CaseDetails priority(PriorityEnum priority) {

    this.priority = priority;
    return this;
  }

  /**
   * Décrit la priorité de régulation médicale du dossier : P0, P1, P2, P3
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

  public CaseDetails careLevel(CareLevelEnum careLevel) {

    this.careLevel = careLevel;
    return this;
  }

  /**
   * Décrit le niveau de soins global du dossier identifié au cours de
   *l&#39;acte de régulation médicale : s&#39;il y a plusieurs niveaux de soins
   *différents pour chaque patient, on indique ici le niveau le plus grave.
   *cf.nomenclature associée.
   * @return careLevel
   **/
  @JsonProperty(JSON_PROPERTY_CARE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CareLevelEnum getCareLevel() {
    return careLevel;
  }

  @JsonProperty(JSON_PROPERTY_CARE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCareLevel(CareLevelEnum careLevel) {
    this.careLevel = careLevel;
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
    return Objects.equals(this.priority, caseDetails.priority) &&
        Objects.equals(this.careLevel, caseDetails.careLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, careLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CaseDetails {\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    careLevel: ")
        .append(toIndentedString(careLevel))
        .append("\n");
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
