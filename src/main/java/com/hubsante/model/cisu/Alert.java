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

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.Attachment;
import com.hubsante.model.cisu.CallTaker;
import com.hubsante.model.cisu.Caller;
import com.hubsante.model.cisu.Location;
import com.hubsante.model.cisu.Notes;
import com.hubsante.model.cisu.Qualification;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Alert
 */
@JsonPropertyOrder({Alert.JSON_PROPERTY_ID, Alert.JSON_PROPERTY_RECEPTION,
                    Alert.JSON_PROPERTY_REPORTING, Alert.JSON_PROPERTY_NOTES,
                    Alert.JSON_PROPERTY_CALLER, Alert.JSON_PROPERTY_LOCATION,
                    Alert.JSON_PROPERTY_QUALIFICATION,
                    Alert.JSON_PROPERTY_CALL_TAKER,
                    Alert.JSON_PROPERTY_ATTACHMENT})
@JsonTypeName("alert")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Alert {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_RECEPTION = "reception";
  private OffsetDateTime reception;

  /**
   * Permet d&#39;attirer l&#39;attention des forces partenaires sur une affaire
   * pour le faire sortir du lot. Eventuellement automatisé en fonction des
   * critères saisis et de leur paramétrage, ou renseigné par l&#39;opérateur.
   * Prend les valeurs définies dans la nomenclature CISU : - standard :
   * STANDARD - signalé : ATTENTION Les systèmes peuvent proposer des
   * fonctionnalités faisant ressortir les dossiers avec le libellé ATTENTION
   */
  public enum ReportingEnum {
    STANDARD("STANDARD"),

    ATTENTION("ATTENTION");

    private String value;

    ReportingEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ReportingEnum fromValue(String value) {
      for (ReportingEnum b : ReportingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_REPORTING = "reporting";
  private ReportingEnum reporting;

  public static final String JSON_PROPERTY_NOTES = "notes";
  private List<Notes> notes;

  public static final String JSON_PROPERTY_CALLER = "caller";
  private Caller caller;

  public static final String JSON_PROPERTY_LOCATION = "location";
  private Location location;

  public static final String JSON_PROPERTY_QUALIFICATION = "qualification";
  private Qualification qualification;

  public static final String JSON_PROPERTY_CALL_TAKER = "callTaker";
  private CallTaker callTaker;

  public static final String JSON_PROPERTY_ATTACHMENT = "attachment";
  private List<Attachment> attachment;

  public Alert() {}

  public Alert id(String id) {

    this.id = id;
    return this;
  }

  /**
   * Identifiant technique unique de l&#39;alerte. Il doit pouvoir être généré
   *automatiquement par le système émetteur et ne doit pas avoir de
   *signification / utilisation particulière par les différents systèmes pour
   *garantir leur découplage. Voir la description de l&#39;identifiant de
   *l&#39;affaire pour voir le format. Lorsqu’une alerte est générée dans NexSIS
   *et crée une affaire, elle est qualifiée d’Alerte Initiale. a) Si cette
   *dernière concerne un partenaire (caractère médical pour la Santé par
   *exemple), elle est relayée seule dans le message. Il y’a un seul objet
   *initialAlert. b) Sinon, une autre alerte liée à la même affaire peut être
   *déclarée ultérieurement, concernant cette fois le partenaire. Lorsqu’elle
   *est déclarée cette Nouvelle Alerte est relayée avec l’Alerte Initiale pour
   *partager un contexte commun. Dans le message de création d’affaire il y’a
   *deux objets alerte : initialAlert et newAlert. Le rattachement des messages
   *à une affaire doivent s&#39;appuyer sur les caseId et non les alertId qui
   *peuvent varier d&#39;un système à l&#39;autre.
   * @return id
   **/
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  public Alert reception(OffsetDateTime reception) {

    this.reception = reception;
    return this;
  }

  /**
   * A valoriser avec le groupe date heure de réception de l&#39;alerte/appel
   * @return reception
   **/
  @JsonProperty(JSON_PROPERTY_RECEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getReception() {
    return reception;
  }

  @JsonProperty(JSON_PROPERTY_RECEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReception(OffsetDateTime reception) {
    this.reception = reception;
  }

  public Alert reporting(ReportingEnum reporting) {

    this.reporting = reporting;
    return this;
  }

  /**
   * Permet d&#39;attirer l&#39;attention des forces partenaires sur une affaire
   *pour le faire sortir du lot. Eventuellement automatisé en fonction des
   *critères saisis et de leur paramétrage, ou renseigné par l&#39;opérateur.
   *Prend les valeurs définies dans la nomenclature CISU : - standard : STANDARD
   *- signalé : ATTENTION Les systèmes peuvent proposer des fonctionnalités
   *faisant ressortir les dossiers avec le libellé ATTENTION
   * @return reporting
   **/
  @JsonProperty(JSON_PROPERTY_REPORTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ReportingEnum getReporting() {
    return reporting;
  }

  @JsonProperty(JSON_PROPERTY_REPORTING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReporting(ReportingEnum reporting) {
    this.reporting = reporting;
  }

  public Alert notes(List<Notes> notes) {

    this.notes = notes;
    return this;
  }

  public Alert addNotesItem(Notes notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
   **/
  @JsonProperty(JSON_PROPERTY_NOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Notes> getNotes() {
    return notes;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_NOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotes(List<Notes> notes) {
    if (notes == null) {
      return;
    }
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.addAll(notes);
  }

  public Alert caller(Caller caller) {

    this.caller = caller;
    return this;
  }

  /**
   * Get caller
   * @return caller
   **/
  @JsonProperty(JSON_PROPERTY_CALLER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Caller getCaller() {
    return caller;
  }

  @JsonProperty(JSON_PROPERTY_CALLER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCaller(Caller caller) {
    this.caller = caller;
  }

  public Alert location(Location location) {

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

  public Alert qualification(Qualification qualification) {

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

  public Alert callTaker(CallTaker callTaker) {

    this.callTaker = callTaker;
    return this;
  }

  /**
   * Get callTaker
   * @return callTaker
   **/
  @JsonProperty(JSON_PROPERTY_CALL_TAKER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CallTaker getCallTaker() {
    return callTaker;
  }

  @JsonProperty(JSON_PROPERTY_CALL_TAKER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallTaker(CallTaker callTaker) {
    this.callTaker = callTaker;
  }

  public Alert attachment(List<Attachment> attachment) {

    this.attachment = attachment;
    return this;
  }

  public Alert addAttachmentItem(Attachment attachmentItem) {
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.add(attachmentItem);
    return this;
  }

  /**
   * Get attachment
   * @return attachment
   **/
  @JsonProperty(JSON_PROPERTY_ATTACHMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Attachment> getAttachment() {
    return attachment;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ATTACHMENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttachment(List<Attachment> attachment) {
    if (attachment == null) {
      return;
    }
    if (this.attachment == null) {
      this.attachment = new ArrayList<>();
    }
    this.attachment.addAll(attachment);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alert alert = (Alert)o;
    return Objects.equals(this.id, alert.id) &&
        Objects.equals(this.reception, alert.reception) &&
        Objects.equals(this.reporting, alert.reporting) &&
        Objects.equals(this.notes, alert.notes) &&
        Objects.equals(this.caller, alert.caller) &&
        Objects.equals(this.location, alert.location) &&
        Objects.equals(this.qualification, alert.qualification) &&
        Objects.equals(this.callTaker, alert.callTaker) &&
        Objects.equals(this.attachment, alert.attachment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, reception, reporting, notes, caller, location,
                        qualification, callTaker, attachment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Alert {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reception: ")
        .append(toIndentedString(reception))
        .append("\n");
    sb.append("    reporting: ")
        .append(toIndentedString(reporting))
        .append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    caller: ").append(toIndentedString(caller)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    qualification: ")
        .append(toIndentedString(qualification))
        .append("\n");
    sb.append("    callTaker: ")
        .append(toIndentedString(callTaker))
        .append("\n");
    sb.append("    attachment: ")
        .append(toIndentedString(attachment))
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
