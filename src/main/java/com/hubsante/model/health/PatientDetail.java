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
 * PatientDetail
 */
@JsonPropertyOrder(
    {PatientDetail.JSON_PROPERTY_WEIGHT, PatientDetail.JSON_PROPERTY_HEIGHT,
     PatientDetail.JSON_PROPERTY_AGE, PatientDetail.JSON_PROPERTY_CARE_LEVEL})
@JsonTypeName("patientDetail")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class PatientDetail {
  public static final String JSON_PROPERTY_WEIGHT = "weight";
  private Integer weight;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private Integer height;

  public static final String JSON_PROPERTY_AGE = "age";
  private String age;

  public static final String JSON_PROPERTY_CARE_LEVEL = "careLevel";
  private String careLevel;

  public PatientDetail() {}

  public PatientDetail weight(Integer weight) {

    this.weight = weight;
    return this;
  }

  /**
   * Poids en kilogrammes
   * @return weight
   **/
  @JsonProperty(JSON_PROPERTY_WEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getWeight() {
    return weight;
  }

  @JsonProperty(JSON_PROPERTY_WEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public PatientDetail height(Integer height) {

    this.height = height;
    return this;
  }

  /**
   * Taille en centimètres
   * @return height
   **/
  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getHeight() {
    return height;
  }

  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHeight(Integer height) {
    this.height = height;
  }

  public PatientDetail age(String age) {

    this.age = age;
    return this;
  }

  /**
   * Age du patient. Au format Durée de la norme ISO 8601
   *(https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) en n&#39;utilisant
   *qu&#39;une seule unité de durée (années, mois, semaines ou jours)
   * @return age
   **/
  @JsonProperty(JSON_PROPERTY_AGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAge() {
    return age;
  }

  @JsonProperty(JSON_PROPERTY_AGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAge(String age) {
    this.age = age;
  }

  public PatientDetail careLevel(String careLevel) {

    this.careLevel = careLevel;
    return this;
  }

  /**
   * Get careLevel
   * @return careLevel
   **/
  @JsonProperty(JSON_PROPERTY_CARE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCareLevel() {
    return careLevel;
  }

  @JsonProperty(JSON_PROPERTY_CARE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCareLevel(String careLevel) {
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
    PatientDetail patientDetail = (PatientDetail)o;
    return Objects.equals(this.weight, patientDetail.weight) &&
        Objects.equals(this.height, patientDetail.height) &&
        Objects.equals(this.age, patientDetail.age) &&
        Objects.equals(this.careLevel, patientDetail.careLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, height, age, careLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatientDetail {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
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
