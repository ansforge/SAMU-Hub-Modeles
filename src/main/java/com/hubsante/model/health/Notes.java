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
import com.hubsante.model.health.Operators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Notes
 */
@JsonPropertyOrder(
    {Notes.JSON_PROPERTY_OPERATORS, Notes.JSON_PROPERTY_OBSERVATIONS,
     Notes.JSON_PROPERTY_MEDICAL_HISTORY,
     Notes.JSON_PROPERTY_MEDICAL_HISTORY_FREETEXT,
     Notes.JSON_PROPERTY_TREATMENTS, Notes.JSON_PROPERTY_TREATMENTS_FREETEXT,
     Notes.JSON_PROPERTY_ALLERGIES, Notes.JSON_PROPERTY_FREETEXT})
@JsonTypeName("notes")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Notes {
  public static final String JSON_PROPERTY_OPERATORS = "operators";
  private Operators operators;

  public static final String JSON_PROPERTY_OBSERVATIONS = "observations";
  private String observations;

  public static final String JSON_PROPERTY_MEDICAL_HISTORY = "medicalHistory";
  private List<String> medicalHistory;

  public static final String JSON_PROPERTY_MEDICAL_HISTORY_FREETEXT =
      "medicalHistoryFreetext";
  private String medicalHistoryFreetext;

  public static final String JSON_PROPERTY_TREATMENTS = "treatments";
  private List<String> treatments;

  public static final String JSON_PROPERTY_TREATMENTS_FREETEXT =
      "treatmentsFreetext";
  private String treatmentsFreetext;

  public static final String JSON_PROPERTY_ALLERGIES = "allergies";
  private String allergies;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext;

  public Notes() {}

  public Notes operators(Operators operators) {

    this.operators = operators;
    return this;
  }

  /**
   * Get operators
   * @return operators
   **/
  @JsonProperty(JSON_PROPERTY_OPERATORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Operators getOperators() {
    return operators;
  }

  @JsonProperty(JSON_PROPERTY_OPERATORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperators(Operators operators) {
    this.operators = operators;
  }

  public Notes observations(String observations) {

    this.observations = observations;
    return this;
  }

  /**
   * Observations médicales du professionnel de santé qui réalise
   *l&#39;interrogatoire
   * @return observations
   **/
  @JsonProperty(JSON_PROPERTY_OBSERVATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getObservations() {
    return observations;
  }

  @JsonProperty(JSON_PROPERTY_OBSERVATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObservations(String observations) {
    this.observations = observations;
  }

  public Notes medicalHistory(List<String> medicalHistory) {

    this.medicalHistory = medicalHistory;
    return this;
  }

  public Notes addMedicalHistoryItem(String medicalHistoryItem) {
    if (this.medicalHistory == null) {
      this.medicalHistory = new ArrayList<>();
    }
    this.medicalHistory.add(medicalHistoryItem);
    return this;
  }

  /**
   * Get medicalHistory
   * @return medicalHistory
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getMedicalHistory() {
    return medicalHistory;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalHistory(List<String> medicalHistory) {
    if (medicalHistory == null) {
      return;
    }
    if (this.medicalHistory == null) {
      this.medicalHistory = new ArrayList<>();
    }
    this.medicalHistory.addAll(medicalHistory);
  }

  public Notes medicalHistoryFreetext(String medicalHistoryFreetext) {

    this.medicalHistoryFreetext = medicalHistoryFreetext;
    return this;
  }

  /**
   * Texte libre a utiliser au besoin si nomenclature non implémentée,et/ou
   *précisions à apporter
   * @return medicalHistoryFreetext
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMedicalHistoryFreetext() {
    return medicalHistoryFreetext;
  }

  @JsonProperty(JSON_PROPERTY_MEDICAL_HISTORY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalHistoryFreetext(String medicalHistoryFreetext) {
    this.medicalHistoryFreetext = medicalHistoryFreetext;
  }

  public Notes treatments(List<String> treatments) {

    this.treatments = treatments;
    return this;
  }

  public Notes addTreatmentsItem(String treatmentsItem) {
    if (this.treatments == null) {
      this.treatments = new ArrayList<>();
    }
    this.treatments.add(treatmentsItem);
    return this;
  }

  /**
   * Get treatments
   * @return treatments
   **/
  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTreatments() {
    return treatments;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreatments(List<String> treatments) {
    if (treatments == null) {
      return;
    }
    if (this.treatments == null) {
      this.treatments = new ArrayList<>();
    }
    this.treatments.addAll(treatments);
  }

  public Notes treatmentsFreetext(String treatmentsFreetext) {

    this.treatmentsFreetext = treatmentsFreetext;
    return this;
  }

  /**
   * Texte libre a utiliser au besoin si nomenclature non implémentée,et/ou
   *précisions à apporter
   * @return treatmentsFreetext
   **/
  @JsonProperty(JSON_PROPERTY_TREATMENTS_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTreatmentsFreetext() {
    return treatmentsFreetext;
  }

  @JsonProperty(JSON_PROPERTY_TREATMENTS_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreatmentsFreetext(String treatmentsFreetext) {
    this.treatmentsFreetext = treatmentsFreetext;
  }

  public Notes allergies(String allergies) {

    this.allergies = allergies;
    return this;
  }

  /**
   * Texte libre pour décrire les allergies du patient
   * @return allergies
   **/
  @JsonProperty(JSON_PROPERTY_ALLERGIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAllergies() {
    return allergies;
  }

  @JsonProperty(JSON_PROPERTY_ALLERGIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }

  public Notes freetext(List<String> freetext) {

    this.freetext = freetext;
    return this;
  }

  public Notes addFreetextItem(String freetextItem) {
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
    Notes notes = (Notes)o;
    return Objects.equals(this.operators, notes.operators) &&
        Objects.equals(this.observations, notes.observations) &&
        Objects.equals(this.medicalHistory, notes.medicalHistory) &&
        Objects.equals(this.medicalHistoryFreetext,
                       notes.medicalHistoryFreetext) &&
        Objects.equals(this.treatments, notes.treatments) &&
        Objects.equals(this.treatmentsFreetext, notes.treatmentsFreetext) &&
        Objects.equals(this.allergies, notes.allergies) &&
        Objects.equals(this.freetext, notes.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operators, observations, medicalHistory,
                        medicalHistoryFreetext, treatments, treatmentsFreetext,
                        allergies, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notes {\n");
    sb.append("    operators: ")
        .append(toIndentedString(operators))
        .append("\n");
    sb.append("    observations: ")
        .append(toIndentedString(observations))
        .append("\n");
    sb.append("    medicalHistory: ")
        .append(toIndentedString(medicalHistory))
        .append("\n");
    sb.append("    medicalHistoryFreetext: ")
        .append(toIndentedString(medicalHistoryFreetext))
        .append("\n");
    sb.append("    treatments: ")
        .append(toIndentedString(treatments))
        .append("\n");
    sb.append("    treatmentsFreetext: ")
        .append(toIndentedString(treatmentsFreetext))
        .append("\n");
    sb.append("    allergies: ")
        .append(toIndentedString(allergies))
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
