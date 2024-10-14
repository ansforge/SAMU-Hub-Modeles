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

package com.hubsante.model.interventionreport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.interventionreport.ExternalId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Patient
 */
@JsonPropertyOrder(
    {Patient.JSON_PROPERTY_PATIENT_ID, Patient.JSON_PROPERTY_BIRTH_NAME,
     Patient.JSON_PROPERTY_LAST_NAME, Patient.JSON_PROPERTY_FIRST_NAME,
     Patient.JSON_PROPERTY_BIRTH_DATE, Patient.JSON_PROPERTY_AGE,
     Patient.JSON_PROPERTY_SEX, Patient.JSON_PROPERTY_EXTERNAL_ID,
     Patient.JSON_PROPERTY_HEIGHT, Patient.JSON_PROPERTY_WEIGHT})
@JsonTypeName("patient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Patient {
  public static final String JSON_PROPERTY_PATIENT_ID = "patientId";
  private String patientId;

  public static final String JSON_PROPERTY_BIRTH_NAME = "birthName";
  private String birthName;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  private String lastName;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public static final String JSON_PROPERTY_BIRTH_DATE = "birthDate";
  private String birthDate;

  public static final String JSON_PROPERTY_AGE = "age";
  private String age;

  /**
   * Sexe du patient, suivant le libellé court de la nomenclature
   * SI-SAMU-NOMENC_SEXE
   */
  public enum SexEnum {
    M("M"),

    F("F"),

    O("O"),

    UN("UN");

    private String value;

    SexEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_SEX = "sex";
  private SexEnum sex;

  public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
  private List<ExternalId> externalId;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private Integer height;

  public static final String JSON_PROPERTY_WEIGHT = "weight";
  private Integer weight;

  public Patient() {}

  public Patient patientId(String patientId) {

    this.patientId = patientId;
    return this;
  }

  /**
   * Identifiant unique du patient.  A valoriser par {ID du SAMU qui engage le
   *SMUR}.{ID du DRM}.P{numéro d’ordre chronologique} :
   *fr.health.samu690.DRFR15DDXAAJJJ00001.P01
   * @return patientId
   **/
  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPatientId() {
    return patientId;
  }

  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public Patient birthName(String birthName) {

    this.birthName = birthName;
    return this;
  }

  /**
   * Nom de naissance du patient
   * @return birthName
   **/
  @JsonProperty(JSON_PROPERTY_BIRTH_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBirthName() {
    return birthName;
  }

  @JsonProperty(JSON_PROPERTY_BIRTH_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthName(String birthName) {
    this.birthName = birthName;
  }

  public Patient lastName(String lastName) {

    this.lastName = lastName;
    return this;
  }

  /**
   * Nom usuel du patient
   * @return lastName
   **/
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastName() {
    return lastName;
  }

  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Patient firstName(String firstName) {

    this.firstName = firstName;
    return this;
  }

  /**
   * Prénom du patient
   * @return firstName
   **/
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFirstName() {
    return firstName;
  }

  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Patient birthDate(String birthDate) {

    this.birthDate = birthDate;
    return this;
  }

  /**
   * Date de naissance du patient
   * @return birthDate
   **/
  @JsonProperty(JSON_PROPERTY_BIRTH_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBirthDate() {
    return birthDate;
  }

  @JsonProperty(JSON_PROPERTY_BIRTH_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public Patient age(String age) {

    this.age = age;
    return this;
  }

  /**
   * La date de naissance n&#39;est pas tout le temps connu, cette donnée permet
   *d&#39;indiquer un âge entier.
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

  public Patient sex(SexEnum sex) {

    this.sex = sex;
    return this;
  }

  /**
   * Sexe du patient, suivant le libellé court de la nomenclature
   *SI-SAMU-NOMENC_SEXE
   * @return sex
   **/
  @JsonProperty(JSON_PROPERTY_SEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SexEnum getSex() {
    return sex;
  }

  @JsonProperty(JSON_PROPERTY_SEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Patient externalId(List<ExternalId> externalId) {

    this.externalId = externalId;
    return this;
  }

  public Patient addExternalIdItem(ExternalId externalIdItem) {
    if (this.externalId == null) {
      this.externalId = new ArrayList<>();
    }
    this.externalId.add(externalIdItem);
    return this;
  }

  /**
   * Get externalId
   * @return externalId
   **/
  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalId> getExternalId() {
    return externalId;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalId(List<ExternalId> externalId) {
    if (externalId == null) {
      return;
    }
    if (this.externalId == null) {
      this.externalId = new ArrayList<>();
    }
    this.externalId.addAll(externalId);
  }

  public Patient height(Integer height) {

    this.height = height;
    return this;
  }

  /**
   * A valoriser avec le poids en kilogrammes
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

  public Patient weight(Integer weight) {

    this.weight = weight;
    return this;
  }

  /**
   * A valoriser avec la taille en centimètres du patient
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Patient patient = (Patient)o;
    return Objects.equals(this.patientId, patient.patientId) &&
        Objects.equals(this.birthName, patient.birthName) &&
        Objects.equals(this.lastName, patient.lastName) &&
        Objects.equals(this.firstName, patient.firstName) &&
        Objects.equals(this.birthDate, patient.birthDate) &&
        Objects.equals(this.age, patient.age) &&
        Objects.equals(this.sex, patient.sex) &&
        Objects.equals(this.externalId, patient.externalId) &&
        Objects.equals(this.height, patient.height) &&
        Objects.equals(this.weight, patient.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, birthName, lastName, firstName, birthDate,
                        age, sex, externalId, height, weight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    sb.append("    patientId: ")
        .append(toIndentedString(patientId))
        .append("\n");
    sb.append("    birthName: ")
        .append(toIndentedString(birthName))
        .append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ")
        .append(toIndentedString(firstName))
        .append("\n");
    sb.append("    birthDate: ")
        .append(toIndentedString(birthDate))
        .append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    externalId: ")
        .append(toIndentedString(externalId))
        .append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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