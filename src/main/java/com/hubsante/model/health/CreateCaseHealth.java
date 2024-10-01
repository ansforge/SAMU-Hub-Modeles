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
import com.hubsante.model.health.AdditionalInformation;
import com.hubsante.model.health.Alert;
import com.hubsante.model.health.Decision;
import com.hubsante.model.health.Location;
import com.hubsante.model.health.MedicalNote;
import com.hubsante.model.health.Patient;
import com.hubsante.model.health.Qualification;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CreateCaseHealth
 */
@JsonPropertyOrder({CreateCaseHealth.JSON_PROPERTY_CASE_ID,
                    CreateCaseHealth.JSON_PROPERTY_SENDER_CASE_ID,
                    CreateCaseHealth.JSON_PROPERTY_CREATION,
                    CreateCaseHealth.JSON_PROPERTY_EVENT,
                    CreateCaseHealth.JSON_PROPERTY_PERIMETER,
                    CreateCaseHealth.JSON_PROPERTY_INTERVENTION_TYPE,
                    CreateCaseHealth.JSON_PROPERTY_QUALIFICATION,
                    CreateCaseHealth.JSON_PROPERTY_LOCATION,
                    CreateCaseHealth.JSON_PROPERTY_INITIAL_ALERT,
                    CreateCaseHealth.JSON_PROPERTY_OWNER,
                    CreateCaseHealth.JSON_PROPERTY_PATIENT,
                    CreateCaseHealth.JSON_PROPERTY_MEDICAL_NOTE,
                    CreateCaseHealth.JSON_PROPERTY_DECISION,
                    CreateCaseHealth.JSON_PROPERTY_ADDITIONAL_INFORMATION})
@JsonTypeName("createCaseHealth")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CreateCaseHealth {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:createCaseHealth";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_SENDER_CASE_ID = "senderCaseId";
  private String senderCaseId;

  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

  public static final String JSON_PROPERTY_EVENT = "event";
  private String event;

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

  /**
   * A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire
   * (première intervention urgente) ou secondaire (par exemple TIH)
   */
  public enum InterventionTypeEnum {
    PRIMAIRE("PRIMAIRE"),

    SECONDAIRE("SECONDAIRE"),

    RETOUR_A_DOMICILE("RETOUR A DOMICILE");

    private String value;

    InterventionTypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InterventionTypeEnum fromValue(String value) {
      for (InterventionTypeEnum b : InterventionTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_INTERVENTION_TYPE =
      "interventionType";
  private InterventionTypeEnum interventionType;

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

  public static final String JSON_PROPERTY_ADDITIONAL_INFORMATION =
      "additionalInformation";
  private AdditionalInformation additionalInformation;

  public CreateCaseHealth() {}

  public CreateCaseHealth caseId(String caseId) {

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

  public CreateCaseHealth senderCaseId(String senderCaseId) {

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

  public CreateCaseHealth creation(OffsetDateTime creation) {

    this.creation = creation;
    return this;
  }

  /**
   * A valoriser avec le groupe date heure de création du dossier/affaire.
   *Spécificité 15-18 : A valoriser avec le groupe date heure de début de
   *partage lié à la création de l&#39;affaire (et donc de génération du
   *caseId).  Lors de l&#39;ajout d&#39;une nouvelle alerte, la valeur de ce
   *champ ne doit pas être modifiée.   L&#39;indicateur de fuseau horaire Z ne
   *doit pas être utilisé. Il doit être renseigné à la fin du processus de la
   *création de la première alerte.
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

  public CreateCaseHealth event(String event) {

    this.event = event;
    return this;
  }

  /**
   * Identifiant partagé de l’évènement, généré une seule fois par le système
   *qui créé l’évènement et le partage (SI-SAMU, SSE, etc.) Valorisé comme suit
   *lors de sa création :  {OrgId émetteur}.event.{n°évènement unique dans le
   *système émetteur}
   * @return event
   **/
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEvent() {
    return event;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvent(String event) {
    this.event = event;
  }

  public CreateCaseHealth perimeter(PerimeterEnum perimeter) {

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

  public CreateCaseHealth
  interventionType(InterventionTypeEnum interventionType) {

    this.interventionType = interventionType;
    return this;
  }

  /**
   * A valoriser en indiquant s&#39;il s&#39;agit d&#39;un dossier dit primaire
   *(première intervention urgente) ou secondaire (par exemple TIH)
   * @return interventionType
   **/
  @JsonProperty(JSON_PROPERTY_INTERVENTION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InterventionTypeEnum getInterventionType() {
    return interventionType;
  }

  @JsonProperty(JSON_PROPERTY_INTERVENTION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInterventionType(InterventionTypeEnum interventionType) {
    this.interventionType = interventionType;
  }

  public CreateCaseHealth qualification(Qualification qualification) {

    this.qualification = qualification;
    return this;
  }

  /**
   * Get qualification
   * @return qualification
   **/
  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Qualification getQualification() {
    return qualification;
  }

  @JsonProperty(JSON_PROPERTY_QUALIFICATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setQualification(Qualification qualification) {
    this.qualification = qualification;
  }

  public CreateCaseHealth location(Location location) {

    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Location getLocation() {
    return location;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocation(Location location) {
    this.location = location;
  }

  public CreateCaseHealth initialAlert(Alert initialAlert) {

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

  public CreateCaseHealth owner(String owner) {

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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOwner() {
    return owner;
  }

  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOwner(String owner) {
    this.owner = owner;
  }

  public CreateCaseHealth patient(List<Patient> patient) {

    this.patient = patient;
    return this;
  }

  public CreateCaseHealth addPatientItem(Patient patientItem) {
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

  public CreateCaseHealth medicalNote(List<MedicalNote> medicalNote) {

    this.medicalNote = medicalNote;
    return this;
  }

  public CreateCaseHealth addMedicalNoteItem(MedicalNote medicalNoteItem) {
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

  public CreateCaseHealth decision(List<Decision> decision) {

    this.decision = decision;
    return this;
  }

  public CreateCaseHealth addDecisionItem(Decision decisionItem) {
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

  public CreateCaseHealth
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
    CreateCaseHealth createCaseHealth = (CreateCaseHealth)o;
    return Objects.equals(this.caseId, createCaseHealth.caseId) &&
        Objects.equals(this.senderCaseId, createCaseHealth.senderCaseId) &&
        Objects.equals(this.creation, createCaseHealth.creation) &&
        Objects.equals(this.event, createCaseHealth.event) &&
        Objects.equals(this.perimeter, createCaseHealth.perimeter) &&
        Objects.equals(this.interventionType,
                       createCaseHealth.interventionType) &&
        Objects.equals(this.qualification, createCaseHealth.qualification) &&
        Objects.equals(this.location, createCaseHealth.location) &&
        Objects.equals(this.initialAlert, createCaseHealth.initialAlert) &&
        Objects.equals(this.owner, createCaseHealth.owner) &&
        Objects.equals(this.patient, createCaseHealth.patient) &&
        Objects.equals(this.medicalNote, createCaseHealth.medicalNote) &&
        Objects.equals(this.decision, createCaseHealth.decision) &&
        Objects.equals(this.additionalInformation,
                       createCaseHealth.additionalInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, senderCaseId, creation, event, perimeter,
                        interventionType, qualification, location, initialAlert,
                        owner, patient, medicalNote, decision,
                        additionalInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseHealth {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    senderCaseId: ")
        .append(toIndentedString(senderCaseId))
        .append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    perimeter: ")
        .append(toIndentedString(perimeter))
        .append("\n");
    sb.append("    interventionType: ")
        .append(toIndentedString(interventionType))
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
