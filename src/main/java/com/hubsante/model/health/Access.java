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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Access
 */
@JsonPropertyOrder(
    {Access.JSON_PROPERTY_FLOOR, Access.JSON_PROPERTY_ROOM_NUMBER,
     Access.JSON_PROPERTY_INTERPHONE, Access.JSON_PROPERTY_ACCESS_CODE,
     Access.JSON_PROPERTY_ELEVATOR, Access.JSON_PROPERTY_BUILDING_NAME,
     Access.JSON_PROPERTY_ENTRANCE, Access.JSON_PROPERTY_ENTITY,
     Access.JSON_PROPERTY_PHONE_NUMBER})
@JsonTypeName("access")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Access {
  public static final String JSON_PROPERTY_FLOOR = "floor";
  private String floor;

  public static final String JSON_PROPERTY_ROOM_NUMBER = "roomNumber";
  private String roomNumber;

  public static final String JSON_PROPERTY_INTERPHONE = "interphone";
  private String interphone;

  public static final String JSON_PROPERTY_ACCESS_CODE = "accessCode";
  private List<String> accessCode;

  public static final String JSON_PROPERTY_ELEVATOR = "elevator";
  private String elevator;

  public static final String JSON_PROPERTY_BUILDING_NAME = "buildingName";
  private String buildingName;

  public static final String JSON_PROPERTY_ENTRANCE = "entrance";
  private String entrance;

  public static final String JSON_PROPERTY_ENTITY = "entity";
  private String entity;

  public static final String JSON_PROPERTY_PHONE_NUMBER = "phoneNumber";
  private String phoneNumber;

  public Access() {}

  public Access floor(String floor) {

    this.floor = floor;
    return this;
  }

  /**
   * A valoriser avec le numéro ou nom de l&#39;étage
   * @return floor
   **/
  @JsonProperty(JSON_PROPERTY_FLOOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFloor() {
    return floor;
  }

  @JsonProperty(JSON_PROPERTY_FLOOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFloor(String floor) {
    this.floor = floor;
  }

  public Access roomNumber(String roomNumber) {

    this.roomNumber = roomNumber;
    return this;
  }

  /**
   * A valoriser avec le numéro d&#39;appartement, de chambre, de bureau
   * @return roomNumber
   **/
  @JsonProperty(JSON_PROPERTY_ROOM_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRoomNumber() {
    return roomNumber;
  }

  @JsonProperty(JSON_PROPERTY_ROOM_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public Access interphone(String interphone) {

    this.interphone = interphone;
    return this;
  }

  /**
   * A valoriser avec les informations nécessaires à l&#39;identification de
   *l&#39;interphone (numéro, nom)
   * @return interphone
   **/
  @JsonProperty(JSON_PROPERTY_INTERPHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInterphone() {
    return interphone;
  }

  @JsonProperty(JSON_PROPERTY_INTERPHONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInterphone(String interphone) {
    this.interphone = interphone;
  }

  public Access accessCode(List<String> accessCode) {

    this.accessCode = accessCode;
    return this;
  }

  public Access addAccessCodeItem(String accessCodeItem) {
    if (this.accessCode == null) {
      this.accessCode = new ArrayList<>();
    }
    this.accessCode.add(accessCodeItem);
    return this;
  }

  /**
   * Get accessCode
   * @return accessCode
   **/
  @JsonProperty(JSON_PROPERTY_ACCESS_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAccessCode() {
    return accessCode;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ACCESS_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccessCode(List<String> accessCode) {
    if (accessCode == null) {
      return;
    }
    if (this.accessCode == null) {
      this.accessCode = new ArrayList<>();
    }
    this.accessCode.addAll(accessCode);
  }

  public Access elevator(String elevator) {

    this.elevator = elevator;
    return this;
  }

  /**
   * A valoriser avec le nom ou le numéro de l&#39;ascenseur ou de la cage
   *d&#39;escalier
   * @return elevator
   **/
  @JsonProperty(JSON_PROPERTY_ELEVATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getElevator() {
    return elevator;
  }

  @JsonProperty(JSON_PROPERTY_ELEVATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setElevator(String elevator) {
    this.elevator = elevator;
  }

  public Access buildingName(String buildingName) {

    this.buildingName = buildingName;
    return this;
  }

  /**
   * A valoriser avec le nom du bâtiment
   * @return buildingName
   **/
  @JsonProperty(JSON_PROPERTY_BUILDING_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBuildingName() {
    return buildingName;
  }

  @JsonProperty(JSON_PROPERTY_BUILDING_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBuildingName(String buildingName) {
    this.buildingName = buildingName;
  }

  public Access entrance(String entrance) {

    this.entrance = entrance;
    return this;
  }

  /**
   * A valoriser avec le nom de l&#39;entrée
   * @return entrance
   **/
  @JsonProperty(JSON_PROPERTY_ENTRANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEntrance() {
    return entrance;
  }

  @JsonProperty(JSON_PROPERTY_ENTRANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntrance(String entrance) {
    this.entrance = entrance;
  }

  public Access entity(String entity) {

    this.entity = entity;
    return this;
  }

  /**
   * A valoriser avec le nom du service concerné au sein de l&#39;établissement
   *: infirmerie, service finance, service comptabilité.
   * @return entity
   **/
  @JsonProperty(JSON_PROPERTY_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEntity() {
    return entity;
  }

  @JsonProperty(JSON_PROPERTY_ENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEntity(String entity) {
    this.entity = entity;
  }

  public Access phoneNumber(String phoneNumber) {

    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * A valoriser avec le numéro de téléphone du lieu de l&#39;intervention, par
   *exemple : téléphone du secrétariat, téléphone du service administratif ou se
   *trouve le patient/ la victime. Le format attendu est le suivant :
   *+{indicatif pays}{numéro de téléphone}
   * @return phoneNumber
   **/
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Access access = (Access)o;
    return Objects.equals(this.floor, access.floor) &&
        Objects.equals(this.roomNumber, access.roomNumber) &&
        Objects.equals(this.interphone, access.interphone) &&
        Objects.equals(this.accessCode, access.accessCode) &&
        Objects.equals(this.elevator, access.elevator) &&
        Objects.equals(this.buildingName, access.buildingName) &&
        Objects.equals(this.entrance, access.entrance) &&
        Objects.equals(this.entity, access.entity) &&
        Objects.equals(this.phoneNumber, access.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(floor, roomNumber, interphone, accessCode, elevator,
                        buildingName, entrance, entity, phoneNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Access {\n");
    sb.append("    floor: ").append(toIndentedString(floor)).append("\n");
    sb.append("    roomNumber: ")
        .append(toIndentedString(roomNumber))
        .append("\n");
    sb.append("    interphone: ")
        .append(toIndentedString(interphone))
        .append("\n");
    sb.append("    accessCode: ")
        .append(toIndentedString(accessCode))
        .append("\n");
    sb.append("    elevator: ").append(toIndentedString(elevator)).append("\n");
    sb.append("    buildingName: ")
        .append(toIndentedString(buildingName))
        .append("\n");
    sb.append("    entrance: ").append(toIndentedString(entrance)).append("\n");
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    phoneNumber: ")
        .append(toIndentedString(phoneNumber))
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
