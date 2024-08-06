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

package com.hubsante.model.health.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.update.AdditionalInformation;
import com.hubsante.model.health.update.Alert;
import com.hubsante.model.health.update.Decision;
import com.hubsante.model.health.update.Location;
import com.hubsante.model.health.update.MedicalNote;
import com.hubsante.model.health.update.Patient;
import com.hubsante.model.health.update.Qualification;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CreateCaseHealthUpdate
 */
@JsonPropertyOrder(
    {CreateCaseHealthUpdate.JSON_PROPERTY_CASE_ID,
     CreateCaseHealthUpdate.JSON_PROPERTY_SENDER_CASE_ID,
     CreateCaseHealthUpdate.JSON_PROPERTY_PERIMETER,
     CreateCaseHealthUpdate.JSON_PROPERTY_QUALIFICATION,
     CreateCaseHealthUpdate.JSON_PROPERTY_LOCATION,
     CreateCaseHealthUpdate.JSON_PROPERTY_INITIAL_ALERT,
     CreateCaseHealthUpdate.JSON_PROPERTY_OWNER,
     CreateCaseHealthUpdate.JSON_PROPERTY_PATIENT,
     CreateCaseHealthUpdate.JSON_PROPERTY_MEDICAL_NOTE,
     CreateCaseHealthUpdate.JSON_PROPERTY_DECISION,
     CreateCaseHealthUpdate.JSON_PROPERTY_FREETEXT,
     CreateCaseHealthUpdate.JSON_PROPERTY_ADDITIONAL_INFORMATION})
@JsonTypeName("createCaseHealthUpdate")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CreateCaseHealthUpdate {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:createCaseHealthUpdate";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_SENDER_CASE_ID = "senderCaseId";
  private String senderCaseId;

  /**
   * Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être
   * adressé/affiché, lorsque celle-ci est spécifique ou dédiée.
   */
  public enum PerimeterEnum {
    AMU("AMU"),

    NEONAT("NEONAT"),

    PSY("PSY"),

    SNP("SNP");

    private String value;

    PerimeterEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PerimeterEnum fromValue(String value) {
      for (PerimeterEnum b : PerimeterEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PERIMETER = "perimeter";
  private PerimeterEnum perimeter;

  public static final String JSON_PROPERTY_QUALIFICATION = "qualification";
  private Qualification qualification;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private Location location;

  public static final String JSON_PROPERTY_INITIAL_ALERT = "initialAlert";
  private Alert initialAlert;

  public static final String JSON_PROPERTY_OWNER = "owner";
  private String owner;

  public static final String JSON_PROPERTY_PATIENT = "patient";
  private List<Patient> patient;

  public static final String JSON_PROPERTY_MEDICAL_NOTE = "medicalNote";
  private List<MedicalNote> medicalNote;

  public static final String JSON_PROPERTY_DECISION = "decision";
  private List<Decision> decision;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public static final String JSON_PROPERTY_ADDITIONAL_INFORMATION =
      "additionalInformation";
  private AdditionalInformation additionalInformation;

  public CreateCaseHealthUpdate() {}

  public CreateCaseHealthUpdate caseId(String caseId) {

    this.caseId = caseId;
    return this;
  }

  /**
   * Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le
   *système du partenaire qui recoit la primo-demande de secours (créateur du
   *dossier).  Il est valorisé comme suit lors de sa création :
   *{pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré
   *de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être
   *unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par
   *celui qui génère l&#39;identifiant partagé doit donc être un numéro unique
   *dans son système.
   * @return caseId
   **/
  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCaseId() {
    return caseId;
  }

  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public CreateCaseHealthUpdate senderCaseId(String senderCaseId) {

    this.senderCaseId = senderCaseId;
    return this;
  }

  /**
   * A valoriser avec le numéro du dossier dans le SI de l&#39;émetteur du
   *message.
   * @return senderCaseId
   **/
  @JsonProperty(JSON_PROPERTY_SENDER_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSenderCaseId() {
    return senderCaseId;
  }

  @JsonProperty(JSON_PROPERTY_SENDER_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSenderCaseId(String senderCaseId) {
    this.senderCaseId = senderCaseId;
  }

  public CreateCaseHealthUpdate perimeter(PerimeterEnum perimeter) {

    this.perimeter = perimeter;
    return this;
  }

  /**
   * Sert à indiquer à quelle filière du CRRA destinataire le dossier doit être
   *adressé/affiché, lorsque celle-ci est spécifique ou dédiée.
   * @return perimeter
   **/
  @JsonProperty(JSON_PROPERTY_PERIMETER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PerimeterEnum getPerimeter() {
    return perimeter;
  }

  @JsonProperty(JSON_PROPERTY_PERIMETER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPerimeter(PerimeterEnum perimeter) {
    this.perimeter = perimeter;
  }

  public CreateCaseHealthUpdate qualification(Qualification qualification) {

    this.qualification = qualification;
    return this;
  }

  /**
   * Get qualification
   * @return qualification
   **/
  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Qualification getQualification() {
    return qualification;
  }

  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQualification(Qualification qualification) {
    this.qualification = qualification;
  }

  public CreateCaseHealthUpdate location(Location location) {

    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Location getLocation() {
    return location;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocation(Location location) {
    this.location = location;
  }

  public CreateCaseHealthUpdate initialAlert(Alert initialAlert) {

    this.initialAlert = initialAlert;
    return this;
  }

  /**
   * Get initialAlert
   * @return initialAlert
   **/
  @JsonProperty(JSON_PROPERTY_INITIAL_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Alert getInitialAlert() {
    return initialAlert;
  }

  @JsonProperty(JSON_PROPERTY_INITIAL_ALERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInitialAlert(Alert initialAlert) {
    this.initialAlert = initialAlert;
  }

  public CreateCaseHealthUpdate owner(String owner) {

    this.owner = owner;
    return this;
  }

  /**
   * Attribut qui permet de transférer la prise en charge d&#39;un dossier à un
   *autre CRAA A valoriser avec l&#39;identifiant de l&#39;organisation concerné
   *(orgId &#x3D; {pays}.{domaine}.{organisation})
   * @return owner
   **/
  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOwner() {
    return owner;
  }

  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOwner(String owner) {
    this.owner = owner;
  }

  public CreateCaseHealthUpdate patient(List<Patient> patient) {

    this.patient = patient;
    return this;
  }

  public CreateCaseHealthUpdate addPatientItem(Patient patientItem) {
    if (this.patient == null) {
      this.patient = new ArrayList<>();
    }
    this.patient.add(patientItem);
    return this;
  }

  /**
   * Get patient
   * @return patient
   **/
  @JsonProperty(JSON_PROPERTY_PATIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Patient> getPatient() {
    return patient;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_PATIENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPatient(List<Patient> patient) {
    if (patient == null) {
      return;
    }
    if (this.patient == null) {
      this.patient = new ArrayList<>();
    }
    this.patient.addAll(patient);
  }

  public CreateCaseHealthUpdate medicalNote(List<MedicalNote> medicalNote) {

    this.medicalNote = medicalNote;
    return this;
  }

  public CreateCaseHealthUpdate
  addMedicalNoteItem(MedicalNote medicalNoteItem) {
    if (this.medicalNote == null) {
      this.medicalNote = new ArrayList<>();
    }
    this.medicalNote.add(medicalNoteItem);
    return this;
  }

  /**
   * Get medicalNote
   * @return medicalNote
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_NOTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<MedicalNote> getMedicalNote() {
    return medicalNote;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_MEDICAL_NOTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalNote(List<MedicalNote> medicalNote) {
    if (medicalNote == null) {
      return;
    }
    if (this.medicalNote == null) {
      this.medicalNote = new ArrayList<>();
    }
    this.medicalNote.addAll(medicalNote);
  }

  public CreateCaseHealthUpdate decision(List<Decision> decision) {

    this.decision = decision;
    return this;
  }

  public CreateCaseHealthUpdate addDecisionItem(Decision decisionItem) {
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

  public CreateCaseHealthUpdate freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Champ libre qui permet de concaténer en une seule note toutes les autres
   *valeurs modifiées dans le dossier, ne figurant pas de manière structurée
   *dans le RS-EDA-MAJ.
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

  public CreateCaseHealthUpdate
  additionalInformation(AdditionalInformation additionalInformation) {

    this.additionalInformation = additionalInformation;
    return this;
  }

  /**
   * Get additionalInformation
   * @return additionalInformation
   **/
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AdditionalInformation getAdditionalInformation() {
    return additionalInformation;
  }

  @JsonProperty(JSON_PROPERTY_ADDITIONAL_INFORMATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void
  setAdditionalInformation(AdditionalInformation additionalInformation) {
    this.additionalInformation = additionalInformation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCaseHealthUpdate createCaseHealthUpdate = (CreateCaseHealthUpdate)o;
    return Objects.equals(this.caseId, createCaseHealthUpdate.caseId) &&
        Objects.equals(this.senderCaseId,
                       createCaseHealthUpdate.senderCaseId) &&
        Objects.equals(this.perimeter, createCaseHealthUpdate.perimeter) &&
        Objects.equals(this.qualification,
                       createCaseHealthUpdate.qualification) &&
        Objects.equals(this.location, createCaseHealthUpdate.location) &&
        Objects.equals(this.initialAlert,
                       createCaseHealthUpdate.initialAlert) &&
        Objects.equals(this.owner, createCaseHealthUpdate.owner) &&
        Objects.equals(this.patient, createCaseHealthUpdate.patient) &&
        Objects.equals(this.medicalNote, createCaseHealthUpdate.medicalNote) &&
        Objects.equals(this.decision, createCaseHealthUpdate.decision) &&
        Objects.equals(this.freetext, createCaseHealthUpdate.freetext) &&
        Objects.equals(this.additionalInformation,
                       createCaseHealthUpdate.additionalInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, senderCaseId, perimeter, qualification,
                        location, initialAlert, owner, patient, medicalNote,
                        decision, freetext, additionalInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseHealthUpdate {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    senderCaseId: ")
        .append(toIndentedString(senderCaseId))
        .append("\n");
    sb.append("    perimeter: ")
        .append(toIndentedString(perimeter))
        .append("\n");
    sb.append("    qualification: ")
        .append(toIndentedString(qualification))
        .append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    initialAlert: ")
        .append(toIndentedString(initialAlert))
        .append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    medicalNote: ")
        .append(toIndentedString(medicalNote))
        .append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
    sb.append("    additionalInformation: ")
        .append(toIndentedString(additionalInformation))
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
