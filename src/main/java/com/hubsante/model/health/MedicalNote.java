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
import com.hubsante.model.health.Operator;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * MedicalNote
 */
@JsonPropertyOrder(
    {MedicalNote.JSON_PROPERTY_OPERATOR, MedicalNote.JSON_PROPERTY_CREATION,
     MedicalNote.JSON_PROPERTY_FREETEXT,
     MedicalNote.JSON_PROPERTY_MEDICAL_HISTORY,
     MedicalNote.JSON_PROPERTY_TREATMENTS, MedicalNote.JSON_PROPERTY_ALLERGIES})
@JsonTypeName("medicalNote")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalNote {
  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private Operator operator;

  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public static final String JSON_PROPERTY_MEDICAL_HISTORY = "medicalHistory";
  private String medicalHistory;

  public static final String JSON_PROPERTY_TREATMENTS = "treatments";
  private String treatments;

  public static final String JSON_PROPERTY_ALLERGIES = "allergies";
  private String allergies;

  public MedicalNote() {}

  public MedicalNote operator(Operator operator) {

    this.operator = operator;
    return this;
  }

  /**
   * Get operator
   * @return operator
   **/
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Operator getOperator() {
    return operator;
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public MedicalNote creation(OffsetDateTime creation) {

    this.creation = creation;
    return this;
  }

  /**
   * Groupe date heure de début de partage lié à la création de
   *l&#39;interrogatoire.  L&#39;indicateur de fuseau horaire Z ne doit pas être
   *utilisé.
   * @return creation
   **/
  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreation() {
    return creation;
  }

  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreation(OffsetDateTime creation) {
    this.creation = creation;
  }

  public MedicalNote freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Observations médicales du professionnel de santé qui réalise
   *l&#39;interrogatoire (texte libre) Champ à utiliser pour aggréger
   *l&#39;ensemble des antécédents /traitements/allergies du patient si les
   *catégories ne sont pas disctinctes dans le LRM
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFreetext() {
    return freetext;
  }

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(String freetext) {
    this.freetext = freetext;
  }

  public MedicalNote medicalHistory(String medicalHistory) {

    this.medicalHistory = medicalHistory;
    return this;
  }

  /**
   * Texte libre  pour décrire les antécédents du patient
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

  public MedicalNote treatments(String treatments) {

    this.treatments = treatments;
    return this;
  }

  /**
   * Texte libre  pour décrire les traitements du patient
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

  public MedicalNote allergies(String allergies) {

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MedicalNote medicalNote = (MedicalNote)o;
    return Objects.equals(this.operator, medicalNote.operator) &&
        Objects.equals(this.creation, medicalNote.creation) &&
        Objects.equals(this.freetext, medicalNote.freetext) &&
        Objects.equals(this.medicalHistory, medicalNote.medicalHistory) &&
        Objects.equals(this.treatments, medicalNote.treatments) &&
        Objects.equals(this.allergies, medicalNote.allergies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operator, creation, freetext, medicalHistory,
                        treatments, allergies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MedicalNote {\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
    sb.append("    medicalHistory: ")
        .append(toIndentedString(medicalHistory))
        .append("\n");
    sb.append("    treatments: ")
        .append(toIndentedString(treatments))
        .append("\n");
    sb.append("    allergies: ")
        .append(toIndentedString(allergies))
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
