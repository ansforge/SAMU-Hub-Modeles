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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * PatientDetail
 */
@JsonPropertyOrder(
    {PatientDetail.JSON_PROPERTY_WEIGHT, PatientDetail.JSON_PROPERTY_HEIGHT,
     PatientDetail.JSON_PROPERTY_AGE, PatientDetail.JSON_PROPERTY_CARE_LEVEL,
     PatientDetail.JSON_PROPERTY_MEDICAL_HISTORY,
     PatientDetail.JSON_PROPERTY_TREATMENTS})
@JsonTypeName("patientDetail")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class PatientDetail {
  public static final String JSON_PROPERTY_WEIGHT = "weight";
  private BigDecimal weight;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private BigDecimal height;

  public static final String JSON_PROPERTY_AGE = "age";
  private String age;

  /**
   * A valoriser avec le niveau de soins spécifique au patient
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

  public static final String JSON_PROPERTY_MEDICAL_HISTORY = "medicalHistory";
  private String medicalHistory;

  public static final String JSON_PROPERTY_TREATMENTS = "treatments";
  private String treatments;

  public PatientDetail() {}

  public PatientDetail weight(BigDecimal weight) {

    this.weight = weight;
    return this;
  }

  /**
   * A valoriser avec le poids en kilogrammes
   * @return weight
   **/
  @JsonProperty(JSON_PROPERTY_WEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getWeight() {
    return weight;
  }

  @JsonProperty(JSON_PROPERTY_WEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public PatientDetail height(BigDecimal height) {

    this.height = height;
    return this;
  }

  /**
   * A valoriser avec la taille en centimètres du patient
   * @return height
   **/
  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getHeight() {
    return height;
  }

  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public PatientDetail age(String age) {

    this.age = age;
    return this;
  }

  /**
   * A valoriser avec l&#39;age du patient. Au format \&quot;Durée\&quot; de la
   *norme ISO 8601 (https://fr.wikipedia.org/wiki/ISO_8601#Dur%C3%A9e) et en
   *n&#39;utilisant qu&#39;une seule unité de durée (années, mois, semaines ou
   *jours)
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

  public PatientDetail careLevel(CareLevelEnum careLevel) {

    this.careLevel = careLevel;
    return this;
  }

  /**
   * A valoriser avec le niveau de soins spécifique au patient
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

  public PatientDetail medicalHistory(String medicalHistory) {

    this.medicalHistory = medicalHistory;
    return this;
  }

  /**
   * Texte libre  pour décrire les antécédents du patient.  Si ce n&#39;est pas
   *géré de manière structurés : à afficher dans une note liée au patient en
   *réception.
   * @return medicalHistory
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMedicalHistory() {
    return medicalHistory;
  }

  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalHistory(String medicalHistory) {
    this.medicalHistory = medicalHistory;
  }

  public PatientDetail treatments(String treatments) {

    this.treatments = treatments;
    return this;
  }

  /**
   * Texte libre  pour décrire les traitements du patient. Si ce n&#39;est pas
   *géré de manière structurés : à afficher dans une note liée au patient en
   *réception.
   * @return treatments
   **/
  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTreatments() {
    return treatments;
  }

  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreatments(String treatments) {
    this.treatments = treatments;
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
        Objects.equals(this.careLevel, patientDetail.careLevel) &&
        Objects.equals(this.medicalHistory, patientDetail.medicalHistory) &&
        Objects.equals(this.treatments, patientDetail.treatments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, height, age, careLevel, medicalHistory,
                        treatments);
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
    sb.append("    medicalHistory: ")
        .append(toIndentedString(medicalHistory))
        .append("\n");
    sb.append("    treatments: ")
        .append(toIndentedString(treatments))
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
