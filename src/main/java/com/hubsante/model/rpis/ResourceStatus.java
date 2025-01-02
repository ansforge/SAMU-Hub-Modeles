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
 * OpenAPI
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.rpis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * ResourceStatus
 */
@JsonPropertyOrder({ResourceStatus.JSON_PROPERTY_DEPART_SMUR,
                    ResourceStatus.JSON_PROPERTY_ARRIVED_SMUR,
                    ResourceStatus.JSON_PROPERTY_DEPART_LOCATION,
                    ResourceStatus.JSON_PROPERTY_ARRIVED_DESTINATION,
                    ResourceStatus.JSON_PROPERTY_TEAM_AVAILABLE,
                    ResourceStatus.JSON_PROPERTY_RETURN_SMUR})
@JsonTypeName("resourceStatus")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourceStatus {
  public static final String JSON_PROPERTY_DEPART_SMUR = "departSmur";
  private OffsetDateTime departSmur;

  public static final String JSON_PROPERTY_ARRIVED_SMUR = "arrivedSmur";
  private OffsetDateTime arrivedSmur;

  public static final String JSON_PROPERTY_DEPART_LOCATION = "departLocation";
  private OffsetDateTime departLocation;

  public static final String JSON_PROPERTY_ARRIVED_DESTINATION =
      "arrivedDestination";
  private OffsetDateTime arrivedDestination;

  public static final String JSON_PROPERTY_TEAM_AVAILABLE = "teamAvailable";
  private OffsetDateTime teamAvailable;

  public static final String JSON_PROPERTY_RETURN_SMUR = "returnSmur";
  private OffsetDateTime returnSmur;

  public ResourceStatus() {}

  public ResourceStatus departSmur(OffsetDateTime departSmur) {

    this.departSmur = departSmur;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR quitte sa base.  s&#39;exprime au format
   *ISO 8601 YYY-MM-DDThh:mm:ss
   * @return departSmur
   **/
  @JsonProperty(JSON_PROPERTY_DEPART_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDepartSmur() {
    return departSmur;
  }

  @JsonProperty(JSON_PROPERTY_DEPART_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDepartSmur(OffsetDateTime departSmur) {
    this.departSmur = departSmur;
  }

  public ResourceStatus arrivedSmur(OffsetDateTime arrivedSmur) {

    this.arrivedSmur = arrivedSmur;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR arrive sur les lieux de
   *l&#39;intervention.  s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
   * @return arrivedSmur
   **/
  @JsonProperty(JSON_PROPERTY_ARRIVED_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getArrivedSmur() {
    return arrivedSmur;
  }

  @JsonProperty(JSON_PROPERTY_ARRIVED_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrivedSmur(OffsetDateTime arrivedSmur) {
    this.arrivedSmur = arrivedSmur;
  }

  public ResourceStatus departLocation(OffsetDateTime departLocation) {

    this.departLocation = departLocation;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR quitte les lieux de l&#39;intervention.
   *s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
   * @return departLocation
   **/
  @JsonProperty(JSON_PROPERTY_DEPART_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDepartLocation() {
    return departLocation;
  }

  @JsonProperty(JSON_PROPERTY_DEPART_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDepartLocation(OffsetDateTime departLocation) {
    this.departLocation = departLocation;
  }

  public ResourceStatus arrivedDestination(OffsetDateTime arrivedDestination) {

    this.arrivedDestination = arrivedDestination;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR qui transporte arrive à destination.
   *s&#39;exprime au format ISO 8601 YYY-MM-DDThh:mm:ss
   * @return arrivedDestination
   **/
  @JsonProperty(JSON_PROPERTY_ARRIVED_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getArrivedDestination() {
    return arrivedDestination;
  }

  @JsonProperty(JSON_PROPERTY_ARRIVED_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrivedDestination(OffsetDateTime arrivedDestination) {
    this.arrivedDestination = arrivedDestination;
  }

  public ResourceStatus teamAvailable(OffsetDateTime teamAvailable) {

    this.teamAvailable = teamAvailable;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR est disponible (dispose de tout les
   *équipements pour faire une autre intervention).  s&#39;exprime au format ISO
   *8601 YYY-MM-DDThh:mm:ss
   * @return teamAvailable
   **/
  @JsonProperty(JSON_PROPERTY_TEAM_AVAILABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getTeamAvailable() {
    return teamAvailable;
  }

  @JsonProperty(JSON_PROPERTY_TEAM_AVAILABLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTeamAvailable(OffsetDateTime teamAvailable) {
    this.teamAvailable = teamAvailable;
  }

  public ResourceStatus returnSmur(OffsetDateTime returnSmur) {

    this.returnSmur = returnSmur;
    return this;
  }

  /**
   * Date et heure à laquelle le SMUR est de retour à la base.  s&#39;exprime au
   *format ISO 8601 YYY-MM-DDThh:mm:ss
   * @return returnSmur
   **/
  @JsonProperty(JSON_PROPERTY_RETURN_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getReturnSmur() {
    return returnSmur;
  }

  @JsonProperty(JSON_PROPERTY_RETURN_SMUR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReturnSmur(OffsetDateTime returnSmur) {
    this.returnSmur = returnSmur;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceStatus resourceStatus = (ResourceStatus)o;
    return Objects.equals(this.departSmur, resourceStatus.departSmur) &&
        Objects.equals(this.arrivedSmur, resourceStatus.arrivedSmur) &&
        Objects.equals(this.departLocation, resourceStatus.departLocation) &&
        Objects.equals(this.arrivedDestination,
                       resourceStatus.arrivedDestination) &&
        Objects.equals(this.teamAvailable, resourceStatus.teamAvailable) &&
        Objects.equals(this.returnSmur, resourceStatus.returnSmur);
  }

  @Override
  public int hashCode() {
    return Objects.hash(departSmur, arrivedSmur, departLocation,
                        arrivedDestination, teamAvailable, returnSmur);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceStatus {\n");
    sb.append("    departSmur: ")
        .append(toIndentedString(departSmur))
        .append("\n");
    sb.append("    arrivedSmur: ")
        .append(toIndentedString(arrivedSmur))
        .append("\n");
    sb.append("    departLocation: ")
        .append(toIndentedString(departLocation))
        .append("\n");
    sb.append("    arrivedDestination: ")
        .append(toIndentedString(arrivedDestination))
        .append("\n");
    sb.append("    teamAvailable: ")
        .append(toIndentedString(teamAvailable))
        .append("\n");
    sb.append("    returnSmur: ")
        .append(toIndentedString(returnSmur))
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
