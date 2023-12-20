/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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
import com.hubsante.model.cisu.Contact;
import com.hubsante.model.cisu.StringNull;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * CallTaker
 */
@JsonPropertyOrder(
    {CallTaker.JSON_PROPERTY_ORGANIZATION, CallTaker.JSON_PROPERTY_CONTROL_ROOM,
     CallTaker.JSON_PROPERTY_ROLE, CallTaker.JSON_PROPERTY_CALLTAKE_CONTACT,
     CallTaker.JSON_PROPERTY_CALLTAKER_ID})
@JsonTypeName("callTaker")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CallTaker {
  public static final String JSON_PROPERTY_ORGANIZATION = "organization";
  private String organization;

  public static final String JSON_PROPERTY_CONTROL_ROOM = "controlRoom";
  private String controlRoom;

  public static final String JSON_PROPERTY_ROLE = "role";
  private StringNull role = null;

  public static final String JSON_PROPERTY_CALLTAKE_CONTACT = "calltakeContact";
  private Contact calltakeContact;

  public static final String JSON_PROPERTY_CALLTAKER_ID = "calltakerId";
  private StringNull calltakerId = null;

  public CallTaker() {}

  public CallTaker organization(String organization) {

    this.organization = organization;
    return this;
  }

  /**
   * Décrit la structure ou le service à laquelle est rattachée l&#39;agent (en
   *fonction du niveau de précision disponible). Se référer au DSF pour la
   *structure normée des organisations Le format est le suivant
   *{pays}:{domaine}:{code département}:{organisation}:{structure
   *interne}*:{unité fonctionnelle}*.
   * @return organization
   **/
  @JsonProperty(JSON_PROPERTY_ORGANIZATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOrganization() {
    return organization;
  }

  @JsonProperty(JSON_PROPERTY_ORGANIZATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOrganization(String organization) {
    this.organization = organization;
  }

  public CallTaker controlRoom(String controlRoom) {

    this.controlRoom = controlRoom;
    return this;
  }

  /**
   * Décrit le centre d&#39;appel auquel est rattaché l&#39;agent
   * @return controlRoom
   **/
  @JsonProperty(JSON_PROPERTY_CONTROL_ROOM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getControlRoom() {
    return controlRoom;
  }

  @JsonProperty(JSON_PROPERTY_CONTROL_ROOM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setControlRoom(String controlRoom) {
    this.controlRoom = controlRoom;
  }

  public CallTaker role(StringNull role) {

    this.role = role;
    return this;
  }

  /**
   * Décrit le rôle de l&#39;agent au sein du service selon la nomenclature
   *PERSO (nomenclature SI-SAMU)
   * @return role
   **/
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StringNull getRole() {
    return role;
  }

  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRole(StringNull role) {
    this.role = role;
  }

  public CallTaker calltakeContact(Contact calltakeContact) {

    this.calltakeContact = calltakeContact;
    return this;
  }

  /**
   * Get calltakeContact
   * @return calltakeContact
   **/
  @JsonProperty(JSON_PROPERTY_CALLTAKE_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Contact getCalltakeContact() {
    return calltakeContact;
  }

  @JsonProperty(JSON_PROPERTY_CALLTAKE_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCalltakeContact(Contact calltakeContact) {
    this.calltakeContact = calltakeContact;
  }

  public CallTaker calltakerId(StringNull calltakerId) {

    this.calltakerId = calltakerId;
    return this;
  }

  /**
   * Identifiant unique de l&#39;opérateur ayant traité l&#39;alerte (peut être
   *un identifiant technique, un numéro de carte CPS etc)
   * @return calltakerId
   **/
  @JsonProperty(JSON_PROPERTY_CALLTAKER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StringNull getCalltakerId() {
    return calltakerId;
  }

  @JsonProperty(JSON_PROPERTY_CALLTAKER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCalltakerId(StringNull calltakerId) {
    this.calltakerId = calltakerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallTaker callTaker = (CallTaker)o;
    return Objects.equals(this.organization, callTaker.organization) &&
        Objects.equals(this.controlRoom, callTaker.controlRoom) &&
        Objects.equals(this.role, callTaker.role) &&
        Objects.equals(this.calltakeContact, callTaker.calltakeContact) &&
        Objects.equals(this.calltakerId, callTaker.calltakerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organization, controlRoom, role, calltakeContact,
                        calltakerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallTaker {\n");
    sb.append("    organization: ")
        .append(toIndentedString(organization))
        .append("\n");
    sb.append("    controlRoom: ")
        .append(toIndentedString(controlRoom))
        .append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    calltakeContact: ")
        .append(toIndentedString(calltakeContact))
        .append("\n");
    sb.append("    calltakerId: ")
        .append(toIndentedString(calltakerId))
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
