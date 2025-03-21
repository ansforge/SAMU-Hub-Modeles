/**
 * Copyright © 2023-2025 Agence du Numerique en Sante (ANS)
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

package com.hubsante.model.resources.info;

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
 * Team
 */
@JsonPropertyOrder({Team.JSON_PROPERTY_MEDICAL_LEVEL, Team.JSON_PROPERTY_NAME})
@JsonTypeName("team")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Team {

  /**
   * A valoriser avec le  niveau de médicalisation du vecteur. Cf. nomenclature
   * associée
   */
  public enum MedicalLevelEnum {
    MED("MED"),

    PARAMED("PARAMED"),

    SECOURS("SECOURS"),

    SANS("SANS");

    private String value;

    MedicalLevelEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MedicalLevelEnum fromValue(String value) {
      for (MedicalLevelEnum b : MedicalLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_MEDICAL_LEVEL = "medicalLevel";
  private MedicalLevelEnum medicalLevel;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public Team() {}

  public Team medicalLevel(MedicalLevelEnum medicalLevel) {

    this.medicalLevel = medicalLevel;
    return this;
  }

  /**
   * A valoriser avec le  niveau de médicalisation du vecteur. Cf. nomenclature
   *associée
   * @return medicalLevel
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MedicalLevelEnum getMedicalLevel() {
    return medicalLevel;
  }

  @JsonProperty(JSON_PROPERTY_MEDICAL_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalLevel(MedicalLevelEnum medicalLevel) {
    this.medicalLevel = medicalLevel;
  }

  public Team name(String name) {

    this.name = name;
    return this;
  }

  /**
   * A valoriser avec le nom de l&#39;équipe à bord du vecteur (celui communiqué
   *par l&#39;organisation à laquelle l&#39;équipe appartient)
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Team team = (Team)o;
    return Objects.equals(this.medicalLevel, team.medicalLevel) &&
        Objects.equals(this.name, team.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(medicalLevel, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Team {\n");
    sb.append("    medicalLevel: ")
        .append(toIndentedString(medicalLevel))
        .append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
