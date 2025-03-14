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

package com.hubsante.model.interventionreport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.interventionreport.Vital;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Evaluation
 */
@JsonPropertyOrder({Evaluation.JSON_PROPERTY_PROCEDURE,
                    Evaluation.JSON_PROPERTY_MAIN_DIAGNOSIS,
                    Evaluation.JSON_PROPERTY_ASSOCIATED_DIAGNOSIS,
                    Evaluation.JSON_PROPERTY_PARAMETER,
                    Evaluation.JSON_PROPERTY_MEDICAL_HISTORY,
                    Evaluation.JSON_PROPERTY_TREATMENT,
                    Evaluation.JSON_PROPERTY_FREETEXT})
@JsonTypeName("evaluation")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Evaluation {
  public static final String JSON_PROPERTY_PROCEDURE = "procedure";
  private List<String> procedure;

  public static final String JSON_PROPERTY_MAIN_DIAGNOSIS = "mainDiagnosis";
  private String mainDiagnosis;

  public static final String JSON_PROPERTY_ASSOCIATED_DIAGNOSIS =
      "associatedDiagnosis";
  private List<String> associatedDiagnosis;

  public static final String JSON_PROPERTY_PARAMETER = "parameter";
  private List<Vital> parameter;

  public static final String JSON_PROPERTY_MEDICAL_HISTORY = "medicalHistory";
  private String medicalHistory;

  public static final String JSON_PROPERTY_TREATMENT = "treatment";
  private String treatment;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext;

  public Evaluation() {}

  public Evaluation procedure(List<String> procedure) {

    this.procedure = procedure;
    return this;
  }

  public Evaluation addProcedureItem(String procedureItem) {
    if (this.procedure == null) {
      this.procedure = new ArrayList<>();
    }
    this.procedure.add(procedureItem);
    return this;
  }

  /**
   * Get procedure
   * @return procedure
   **/
  @JsonProperty(JSON_PROPERTY_PROCEDURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getProcedure() {
    return procedure;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_PROCEDURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcedure(List<String> procedure) {
    if (procedure == null) {
      return;
    }
    if (this.procedure == null) {
      this.procedure = new ArrayList<>();
    }
    this.procedure.addAll(procedure);
  }

  public Evaluation mainDiagnosis(String mainDiagnosis) {

    this.mainDiagnosis = mainDiagnosis;
    return this;
  }

  /**
   * Thésaurus SFMU-FEDORU. A valoriser par un code de la nomenclature
   *Diagnostic SMUR.
   * @return mainDiagnosis
   **/
  @JsonProperty(JSON_PROPERTY_MAIN_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMainDiagnosis() {
    return mainDiagnosis;
  }

  @JsonProperty(JSON_PROPERTY_MAIN_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMainDiagnosis(String mainDiagnosis) {
    this.mainDiagnosis = mainDiagnosis;
  }

  public Evaluation associatedDiagnosis(List<String> associatedDiagnosis) {

    this.associatedDiagnosis = associatedDiagnosis;
    return this;
  }

  public Evaluation addAssociatedDiagnosisItem(String associatedDiagnosisItem) {
    if (this.associatedDiagnosis == null) {
      this.associatedDiagnosis = new ArrayList<>();
    }
    this.associatedDiagnosis.add(associatedDiagnosisItem);
    return this;
  }

  /**
   * Get associatedDiagnosis
   * @return associatedDiagnosis
   **/
  @JsonProperty(JSON_PROPERTY_ASSOCIATED_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAssociatedDiagnosis() {
    return associatedDiagnosis;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ASSOCIATED_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssociatedDiagnosis(List<String> associatedDiagnosis) {
    if (associatedDiagnosis == null) {
      return;
    }
    if (this.associatedDiagnosis == null) {
      this.associatedDiagnosis = new ArrayList<>();
    }
    this.associatedDiagnosis.addAll(associatedDiagnosis);
  }

  public Evaluation parameter(List<Vital> parameter) {

    this.parameter = parameter;
    return this;
  }

  public Evaluation addParameterItem(Vital parameterItem) {
    if (this.parameter == null) {
      this.parameter = new ArrayList<>();
    }
    this.parameter.add(parameterItem);
    return this;
  }

  /**
   * Get parameter
   * @return parameter
   **/
  @JsonProperty(JSON_PROPERTY_PARAMETER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Vital> getParameter() {
    return parameter;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_PARAMETER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParameter(List<Vital> parameter) {
    if (parameter == null) {
      return;
    }
    if (this.parameter == null) {
      this.parameter = new ArrayList<>();
    }
    this.parameter.addAll(parameter);
  }

  public Evaluation medicalHistory(String medicalHistory) {

    this.medicalHistory = medicalHistory;
    return this;
  }

  /**
   * Précise les antécédents du patient
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

  public Evaluation treatment(String treatment) {

    this.treatment = treatment;
    return this;
  }

  /**
   * Précise le traitement du patient
   * @return treatment
   **/
  @JsonProperty(JSON_PROPERTY_TREATMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTreatment() {
    return treatment;
  }

  @JsonProperty(JSON_PROPERTY_TREATMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public Evaluation freetext(List<String> freetext) {

    this.freetext = freetext;
    return this;
  }

  public Evaluation addFreetextItem(String freetextItem) {
    if (this.freetext == null) {
      this.freetext = new ArrayList<>();
    }
    this.freetext.add(freetextItem);
    return this;
  }

  /**
   * Get freetext
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getFreetext() {
    return freetext;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(List<String> freetext) {
    if (freetext == null) {
      return;
    }
    if (this.freetext == null) {
      this.freetext = new ArrayList<>();
    }
    this.freetext.addAll(freetext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Evaluation evaluation = (Evaluation)o;
    return Objects.equals(this.procedure, evaluation.procedure) &&
        Objects.equals(this.mainDiagnosis, evaluation.mainDiagnosis) &&
        Objects.equals(this.associatedDiagnosis,
                       evaluation.associatedDiagnosis) &&
        Objects.equals(this.parameter, evaluation.parameter) &&
        Objects.equals(this.medicalHistory, evaluation.medicalHistory) &&
        Objects.equals(this.treatment, evaluation.treatment) &&
        Objects.equals(this.freetext, evaluation.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(procedure, mainDiagnosis, associatedDiagnosis,
                        parameter, medicalHistory, treatment, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evaluation {\n");
    sb.append("    procedure: ")
        .append(toIndentedString(procedure))
        .append("\n");
    sb.append("    mainDiagnosis: ")
        .append(toIndentedString(mainDiagnosis))
        .append("\n");
    sb.append("    associatedDiagnosis: ")
        .append(toIndentedString(associatedDiagnosis))
        .append("\n");
    sb.append("    parameter: ")
        .append(toIndentedString(parameter))
        .append("\n");
    sb.append("    medicalHistory: ")
        .append(toIndentedString(medicalHistory))
        .append("\n");
    sb.append("    treatment: ")
        .append(toIndentedString(treatment))
        .append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
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
