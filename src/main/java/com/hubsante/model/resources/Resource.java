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

package com.hubsante.model.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.Contact;
import com.hubsante.model.resources.State;
import com.hubsante.model.resources.Team;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Resource
 */
@JsonPropertyOrder(
    {Resource.JSON_PROPERTY_COMMITMENT_DATE_TIME,
     Resource.JSON_PROPERTY_ORIGIN_DATE_TIME,
     Resource.JSON_PROPERTY_DESTINATION_DATE_TIME,
     Resource.JSON_PROPERTY_RESOURCE_I_D, Resource.JSON_PROPERTY_ORG_I_D,
     Resource.JSON_PROPERTY_TYPE, Resource.JSON_PROPERTY_PLATE,
     Resource.JSON_PROPERTY_NAME, Resource.JSON_PROPERTY_ORDER,
     Resource.JSON_PROPERTY_CENTER_NAME, Resource.JSON_PROPERTY_CENTER_TYPE,
     Resource.JSON_PROPERTY_CENTER_CITY, Resource.JSON_PROPERTY_MAKE,
     Resource.JSON_PROPERTY_MODEL, Resource.JSON_PROPERTY_TEAM,
     Resource.JSON_PROPERTY_STATE, Resource.JSON_PROPERTY_CONTACT,
     Resource.JSON_PROPERTY_FREETEXT})
@JsonTypeName("resource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Resource {
  public static final String JSON_PROPERTY_COMMITMENT_DATE_TIME =
      "commitmentDateTime";
  private OffsetDateTime commitmentDateTime;

  public static final String JSON_PROPERTY_ORIGIN_DATE_TIME = "originDateTime";
  private OffsetDateTime originDateTime;

  public static final String JSON_PROPERTY_DESTINATION_DATE_TIME =
      "destinationDateTime";
  private OffsetDateTime destinationDateTime;

  public static final String JSON_PROPERTY_RESOURCE_I_D = "resourceID";
  private String resourceID;

  public static final String JSON_PROPERTY_ORG_I_D = "orgID";
  private String orgID;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_PLATE = "plate";
  private String plate;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_ORDER = "order";
  private String order;

  public static final String JSON_PROPERTY_CENTER_NAME = "centerName";
  private String centerName;

  public static final String JSON_PROPERTY_CENTER_TYPE = "centerType";
  private String centerType;

  public static final String JSON_PROPERTY_CENTER_CITY = "centerCity";
  private String centerCity;

  public static final String JSON_PROPERTY_MAKE = "make";
  private String make;

  public static final String JSON_PROPERTY_MODEL = "model";
  private String model;

  public static final String JSON_PROPERTY_TEAM = "team";
  private Team team;

  public static final String JSON_PROPERTY_STATE = "state";
  private State state;

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private Contact contact;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext;

  public Resource() {}

  public Resource commitmentDateTime(OffsetDateTime commitmentDateTime) {

    this.commitmentDateTime = commitmentDateTime;
    return this;
  }

  /**
   * date et heure d&#39;engagement de la ressource
   * @return commitmentDateTime
   **/
  @JsonProperty(JSON_PROPERTY_COMMITMENT_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCommitmentDateTime() {
    return commitmentDateTime;
  }

  @JsonProperty(JSON_PROPERTY_COMMITMENT_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCommitmentDateTime(OffsetDateTime commitmentDateTime) {
    this.commitmentDateTime = commitmentDateTime;
  }

  public Resource originDateTime(OffsetDateTime originDateTime) {

    this.originDateTime = originDateTime;
    return this;
  }

  /**
   * date et heure d&#39;arrivée prévisionnelle sur le lieu de prise en charge
   *du patient
   * @return originDateTime
   **/
  @JsonProperty(JSON_PROPERTY_ORIGIN_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getOriginDateTime() {
    return originDateTime;
  }

  @JsonProperty(JSON_PROPERTY_ORIGIN_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOriginDateTime(OffsetDateTime originDateTime) {
    this.originDateTime = originDateTime;
  }

  public Resource destinationDateTime(OffsetDateTime destinationDateTime) {

    this.destinationDateTime = destinationDateTime;
    return this;
  }

  /**
   * date et heure d&#39;arrivée prévisionnelle sur le lieu de destination du
   *patient
   * @return destinationDateTime
   **/
  @JsonProperty(JSON_PROPERTY_DESTINATION_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDestinationDateTime() {
    return destinationDateTime;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestinationDateTime(OffsetDateTime destinationDateTime) {
    this.destinationDateTime = destinationDateTime;
  }

  public Resource resourceID(String resourceID) {

    this.resourceID = resourceID;
    return this;
  }

  /**
   * ID unique de la ressource engagée
   * @return resourceID
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResourceID() {
    return resourceID;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceID(String resourceID) {
    this.resourceID = resourceID;
  }

  public Resource orgID(String orgID) {

    this.orgID = orgID;
    return this;
  }

  /**
   * Organisation à laquelle appartient la ressource
   * @return orgID
   **/
  @JsonProperty(JSON_PROPERTY_ORG_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrgID() {
    return orgID;
  }

  @JsonProperty(JSON_PROPERTY_ORG_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

  public Resource type(String type) {

    this.type = type;
    return this;
  }

  /**
   * Type de ressource mobilisée (nomenclature type de vecteur à implémenter
   *pour l&#39;instant, voir ensuite si elle est complétée par des ressources
   *autres que des vecteurs)
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public Resource plate(String plate) {

    this.plate = plate;
    return this;
  }

  /**
   * Get plate
   * @return plate
   **/
  @JsonProperty(JSON_PROPERTY_PLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlate() {
    return plate;
  }

  @JsonProperty(JSON_PROPERTY_PLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlate(String plate) {
    this.plate = plate;
  }

  public Resource name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Nom donné par l’organisation d’appartenance
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  public Resource order(String order) {

    this.order = order;
    return this;
  }

  /**
   * S&#39;il existe plusieurs types de vecteurs ou ressource identiques portant
   *le même nom dans un même dans le même centre d’affectation; préciser le
   *numéro d&#39;ordre
   * @return order
   **/
  @JsonProperty(JSON_PROPERTY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrder() {
    return order;
  }

  @JsonProperty(JSON_PROPERTY_ORDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrder(String order) {
    this.order = order;
  }

  public Resource centerName(String centerName) {

    this.centerName = centerName;
    return this;
  }

  /**
   * Lieu de garage principal
   * @return centerName
   **/
  @JsonProperty(JSON_PROPERTY_CENTER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCenterName() {
    return centerName;
  }

  @JsonProperty(JSON_PROPERTY_CENTER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCenterName(String centerName) {
    this.centerName = centerName;
  }

  public Resource centerType(String centerType) {

    this.centerType = centerType;
    return this;
  }

  /**
   * Get centerType
   * @return centerType
   **/
  @JsonProperty(JSON_PROPERTY_CENTER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCenterType() {
    return centerType;
  }

  @JsonProperty(JSON_PROPERTY_CENTER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCenterType(String centerType) {
    this.centerType = centerType;
  }

  public Resource centerCity(String centerCity) {

    this.centerCity = centerCity;
    return this;
  }

  /**
   * Code INSEE de la commune du centre d&#39;affectation
   * @return centerCity
   **/
  @JsonProperty(JSON_PROPERTY_CENTER_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCenterCity() {
    return centerCity;
  }

  @JsonProperty(JSON_PROPERTY_CENTER_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCenterCity(String centerCity) {
    this.centerCity = centerCity;
  }

  public Resource make(String make) {

    this.make = make;
    return this;
  }

  /**
   * Marque vecteur
   * @return make
   **/
  @JsonProperty(JSON_PROPERTY_MAKE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMake() {
    return make;
  }

  @JsonProperty(JSON_PROPERTY_MAKE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMake(String make) {
    this.make = make;
  }

  public Resource model(String model) {

    this.model = model;
    return this;
  }

  /**
   * Modèle vecteur
   * @return model
   **/
  @JsonProperty(JSON_PROPERTY_MODEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getModel() {
    return model;
  }

  @JsonProperty(JSON_PROPERTY_MODEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setModel(String model) {
    this.model = model;
  }

  public Resource team(Team team) {

    this.team = team;
    return this;
  }

  /**
   * Get team
   * @return team
   **/
  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Team getTeam() {
    return team;
  }

  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTeam(Team team) {
    this.team = team;
  }

  public Resource state(State state) {

    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public State getState() {
    return state;
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(State state) {
    this.state = state;
  }

  public Resource contact(Contact contact) {

    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
   **/
  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Contact getContact() {
    return contact;
  }

  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Resource freetext(List<String> freetext) {

    this.freetext = freetext;
    return this;
  }

  public Resource addFreetextItem(String freetextItem) {
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
    Resource resource = (Resource)o;
    return Objects.equals(this.commitmentDateTime,
                          resource.commitmentDateTime) &&
        Objects.equals(this.originDateTime, resource.originDateTime) &&
        Objects.equals(this.destinationDateTime,
                       resource.destinationDateTime) &&
        Objects.equals(this.resourceID, resource.resourceID) &&
        Objects.equals(this.orgID, resource.orgID) &&
        Objects.equals(this.type, resource.type) &&
        Objects.equals(this.plate, resource.plate) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.order, resource.order) &&
        Objects.equals(this.centerName, resource.centerName) &&
        Objects.equals(this.centerType, resource.centerType) &&
        Objects.equals(this.centerCity, resource.centerCity) &&
        Objects.equals(this.make, resource.make) &&
        Objects.equals(this.model, resource.model) &&
        Objects.equals(this.team, resource.team) &&
        Objects.equals(this.state, resource.state) &&
        Objects.equals(this.contact, resource.contact) &&
        Objects.equals(this.freetext, resource.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commitmentDateTime, originDateTime, destinationDateTime,
                        resourceID, orgID, type, plate, name, order, centerName,
                        centerType, centerCity, make, model, team, state,
                        contact, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    commitmentDateTime: ")
        .append(toIndentedString(commitmentDateTime))
        .append("\n");
    sb.append("    originDateTime: ")
        .append(toIndentedString(originDateTime))
        .append("\n");
    sb.append("    destinationDateTime: ")
        .append(toIndentedString(destinationDateTime))
        .append("\n");
    sb.append("    resourceID: ")
        .append(toIndentedString(resourceID))
        .append("\n");
    sb.append("    orgID: ").append(toIndentedString(orgID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    centerName: ")
        .append(toIndentedString(centerName))
        .append("\n");
    sb.append("    centerType: ")
        .append(toIndentedString(centerType))
        .append("\n");
    sb.append("    centerCity: ")
        .append(toIndentedString(centerCity))
        .append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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
