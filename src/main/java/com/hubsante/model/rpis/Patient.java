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
 * OpenAPI
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
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
import com.hubsante.model.rpis.ResidentialAddress;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Patient
 */
@JsonPropertyOrder({Patient.JSON_PROPERTY_PATIENT_ID,
                    Patient.JSON_PROPERTY_BIRTH_DATE, Patient.JSON_PROPERTY_SEX,
                    Patient.JSON_PROPERTY_RESIDENTIAL_ADDRESS})
@JsonTypeName("patient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Patient {
  public static final String JSON_PROPERTY_PATIENT_ID = "patientId";
  private String patientId;

  public static final String JSON_PROPERTY_BIRTH_DATE = "birthDate";
  private String birthDate;

  /**
   * Sexe du patient, suivant le libellé court de la nomenclature
   * NOS-NOMENC_SEXE
   */
  public enum SexEnum {
    M(String.valueOf("M")),

    F(String.valueOf("F")),

    O(String.valueOf("O")),

    UN(String.valueOf("UN"));

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

  public static final String JSON_PROPERTY_RESIDENTIAL_ADDRESS =
      "residentialAddress";
  private ResidentialAddress residentialAddress;

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

  public Patient sex(SexEnum sex) {

    this.sex = sex;
    return this;
  }

  /**
   * Sexe du patient, suivant le libellé court de la nomenclature
   *NOS-NOMENC_SEXE
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

  public Patient residentialAddress(ResidentialAddress residentialAddress) {

    this.residentialAddress = residentialAddress;
    return this;
  }

  /**
   * Get residentialAddress
   * @return residentialAddress
   **/
  @JsonProperty(JSON_PROPERTY_RESIDENTIAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResidentialAddress getResidentialAddress() {
    return residentialAddress;
  }

  @JsonProperty(JSON_PROPERTY_RESIDENTIAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResidentialAddress(ResidentialAddress residentialAddress) {
    this.residentialAddress = residentialAddress;
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
        Objects.equals(this.birthDate, patient.birthDate) &&
        Objects.equals(this.sex, patient.sex) &&
        Objects.equals(this.residentialAddress, patient.residentialAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, birthDate, sex, residentialAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    sb.append("    patientId: ")
        .append(toIndentedString(patientId))
        .append("\n");
    sb.append("    birthDate: ")
        .append(toIndentedString(birthDate))
        .append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    residentialAddress: ")
        .append(toIndentedString(residentialAddress))
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
