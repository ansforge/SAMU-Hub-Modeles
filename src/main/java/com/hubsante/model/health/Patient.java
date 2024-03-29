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
import com.hubsante.model.health.HealthMotive;
import com.hubsante.model.health.Hypothesis;
import com.hubsante.model.health.InsIdentity;
import com.hubsante.model.health.PatientDetail;
import com.hubsante.model.health.ResourceDiagnosis;
import java.io.File;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Patient
 */
@JsonPropertyOrder(
    {Patient.JSON_PROPERTY_ID, Patient.JSON_PROPERTY_FILE,
     Patient.JSON_PROPERTY_IDENTITY, Patient.JSON_PROPERTY_HEALTH_MOTIVE,
     Patient.JSON_PROPERTY_DETAIL, Patient.JSON_PROPERTY_HYPOTHESIS,
     Patient.JSON_PROPERTY_RESOURCE_DIAGNOSIS})
@JsonTypeName("patient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Patient {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_FILE = "file";
  private File _file;

  public static final String JSON_PROPERTY_IDENTITY = "identity";
  private InsIdentity identity;

  public static final String JSON_PROPERTY_HEALTH_MOTIVE = "healthMotive";
  private HealthMotive healthMotive;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private PatientDetail detail;

  public static final String JSON_PROPERTY_HYPOTHESIS = "hypothesis";
  private Hypothesis hypothesis;

  public static final String JSON_PROPERTY_RESOURCE_DIAGNOSIS =
      "resourceDiagnosis";
  private ResourceDiagnosis resourceDiagnosis;

  public Patient() {}

  public Patient id(String id) {

    this.id = id;
    return this;
  }

  /**
   * Identifiant technique du patient pour permettre les rapprochements
   *d&#39;infos. Le 1er qui créé l&#39;ID patient a raison.
   * @return id
   **/
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }

  public Patient _file(File _file) {

    this._file = _file;
    return this;
  }

  /**
   * Get _file
   * @return _file
   **/
  @JsonProperty(JSON_PROPERTY_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public File getFile() {
    return _file;
  }

  @JsonProperty(JSON_PROPERTY_FILE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFile(File _file) {
    this._file = _file;
  }

  public Patient identity(InsIdentity identity) {

    this.identity = identity;
    return this;
  }

  /**
   * Get identity
   * @return identity
   **/
  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InsIdentity getIdentity() {
    return identity;
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdentity(InsIdentity identity) {
    this.identity = identity;
  }

  public Patient healthMotive(HealthMotive healthMotive) {

    this.healthMotive = healthMotive;
    return this;
  }

  /**
   * Get healthMotive
   * @return healthMotive
   **/
  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public HealthMotive getHealthMotive() {
    return healthMotive;
  }

  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHealthMotive(HealthMotive healthMotive) {
    this.healthMotive = healthMotive;
  }

  public Patient detail(PatientDetail detail) {

    this.detail = detail;
    return this;
  }

  /**
   * Get detail
   * @return detail
   **/
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PatientDetail getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetail(PatientDetail detail) {
    this.detail = detail;
  }

  public Patient hypothesis(Hypothesis hypothesis) {

    this.hypothesis = hypothesis;
    return this;
  }

  /**
   * Get hypothesis
   * @return hypothesis
   **/
  @JsonProperty(JSON_PROPERTY_HYPOTHESIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Hypothesis getHypothesis() {
    return hypothesis;
  }

  @JsonProperty(JSON_PROPERTY_HYPOTHESIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHypothesis(Hypothesis hypothesis) {
    this.hypothesis = hypothesis;
  }

  public Patient resourceDiagnosis(ResourceDiagnosis resourceDiagnosis) {

    this.resourceDiagnosis = resourceDiagnosis;
    return this;
  }

  /**
   * Get resourceDiagnosis
   * @return resourceDiagnosis
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceDiagnosis getResourceDiagnosis() {
    return resourceDiagnosis;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceDiagnosis(ResourceDiagnosis resourceDiagnosis) {
    this.resourceDiagnosis = resourceDiagnosis;
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
    return Objects.equals(this.id, patient.id) &&
        Objects.equals(this._file, patient._file) &&
        Objects.equals(this.identity, patient.identity) &&
        Objects.equals(this.healthMotive, patient.healthMotive) &&
        Objects.equals(this.detail, patient.detail) &&
        Objects.equals(this.hypothesis, patient.hypothesis) &&
        Objects.equals(this.resourceDiagnosis, patient.resourceDiagnosis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, _file, identity, healthMotive, detail, hypothesis,
                        resourceDiagnosis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Patient {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    _file: ").append(toIndentedString(_file)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    healthMotive: ")
        .append(toIndentedString(healthMotive))
        .append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    hypothesis: ")
        .append(toIndentedString(hypothesis))
        .append("\n");
    sb.append("    resourceDiagnosis: ")
        .append(toIndentedString(resourceDiagnosis))
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
