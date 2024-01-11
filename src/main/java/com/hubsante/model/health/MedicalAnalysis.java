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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.Decision;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * MedicalAnalysis
 */
@JsonPropertyOrder({MedicalAnalysis.JSON_PROPERTY_PATIENT_ID,
                    MedicalAnalysis.JSON_PROPERTY_DECISION})
@JsonTypeName("medicalAnalysis")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalAnalysis {
  public static final String JSON_PROPERTY_PATIENT_ID = "patientId";
  private String patientId;

  public static final String JSON_PROPERTY_DECISION = "decision";
  private List<Decision> decision;

  public MedicalAnalysis() {}

  public MedicalAnalysis patientId(String patientId) {

    this.patientId = patientId;
    return this;
  }

  /**
   * ID du patient concerné, lorsque le patient existe et est identifié
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

  public MedicalAnalysis decision(List<Decision> decision) {

    this.decision = decision;
    return this;
  }

  public MedicalAnalysis addDecisionItem(Decision decisionItem) {
    if (this.decision == null) {
      this.decision = new ArrayList<>();
    }
    this.decision.add(decisionItem);
    return this;
  }

  /**
   * Get decision
   * @return decision
   **/
  @JsonProperty(JSON_PROPERTY_DECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Decision> getDecision() {
    return decision;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_DECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDecision(List<Decision> decision) {
    if (decision == null) {
      return;
    }
    if (this.decision == null) {
      this.decision = new ArrayList<>();
    }
    this.decision.addAll(decision);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MedicalAnalysis medicalAnalysis = (MedicalAnalysis)o;
    return Objects.equals(this.patientId, medicalAnalysis.patientId) &&
        Objects.equals(this.decision, medicalAnalysis.decision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(patientId, decision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MedicalAnalysis {\n");
    sb.append("    patientId: ")
        .append(toIndentedString(patientId))
        .append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
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
