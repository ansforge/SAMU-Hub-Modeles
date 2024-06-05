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
import com.hubsante.model.cisu.Destination;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * TransportDetails
 */
@JsonPropertyOrder({TransportDetails.JSON_PROPERTY_ORIENTATION,
                    TransportDetails.JSON_PROPERTY_CONCOURS_REQUEST,
                    TransportDetails.JSON_PROPERTY_TRANSPORTATION_I_D,
                    TransportDetails.JSON_PROPERTY_TEAM_CARE,
                    TransportDetails.JSON_PROPERTY_DESTINATION})
@JsonTypeName("transportDetails")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class TransportDetails {
  public static final String JSON_PROPERTY_ORIENTATION = "orientation";
  private String orientation;

  public static final String JSON_PROPERTY_CONCOURS_REQUEST = "concoursRequest";
  private String concoursRequest;

  public static final String JSON_PROPERTY_TRANSPORTATION_I_D =
      "transportationID";
  private String transportationID;

  public static final String JSON_PROPERTY_TEAM_CARE = "teamCare";
  private String teamCare;

  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private Destination destination;

  public TransportDetails() {}

  public TransportDetails orientation(String orientation) {

    this.orientation = orientation;
    return this;
  }

  /**
   * Décision(s) d&#39;orientation prise par le médecin régulateur :  - A
   *transporter - Laisser sur place
   * @return orientation
   **/
  @JsonProperty(JSON_PROPERTY_ORIENTATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOrientation() {
    return orientation;
  }

  @JsonProperty(JSON_PROPERTY_ORIENTATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  public TransportDetails concoursRequest(String concoursRequest) {

    this.concoursRequest = concoursRequest;
    return this;
  }

  /**
   * Identifiant de la ou des demandes de concours
   * @return concoursRequest
   **/
  @JsonProperty(JSON_PROPERTY_CONCOURS_REQUEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getConcoursRequest() {
    return concoursRequest;
  }

  @JsonProperty(JSON_PROPERTY_CONCOURS_REQUEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConcoursRequest(String concoursRequest) {
    this.concoursRequest = concoursRequest;
  }

  public TransportDetails transportationID(String transportationID) {

    this.transportationID = transportationID;
    return this;
  }

  /**
   * Identifiant du véhicule terrestre / aérien / maritime de transport
   *principal (&#x3D; celui dans lequel se trouve le patient), permettant
   *d&#39;associer la décision à un véhicule spécifique + au patient.
   * @return transportationID
   **/
  @JsonProperty(JSON_PROPERTY_TRANSPORTATION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTransportationID() {
    return transportationID;
  }

  @JsonProperty(JSON_PROPERTY_TRANSPORTATION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransportationID(String transportationID) {
    this.transportationID = transportationID;
  }

  public TransportDetails teamCare(String teamCare) {

    this.teamCare = teamCare;
    return this;
  }

  /**
   * Type d’équipe (médical, paramédicale, non médicale, standard, incomplete,
   *...)
   * @return teamCare
   **/
  @JsonProperty(JSON_PROPERTY_TEAM_CARE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTeamCare() {
    return teamCare;
  }

  @JsonProperty(JSON_PROPERTY_TEAM_CARE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTeamCare(String teamCare) {
    this.teamCare = teamCare;
  }

  public TransportDetails destination(Destination destination) {

    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * @return destination
   **/
  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Destination getDestination() {
    return destination;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransportDetails transportDetails = (TransportDetails)o;
    return Objects.equals(this.orientation, transportDetails.orientation) &&
        Objects.equals(this.concoursRequest,
                       transportDetails.concoursRequest) &&
        Objects.equals(this.transportationID,
                       transportDetails.transportationID) &&
        Objects.equals(this.teamCare, transportDetails.teamCare) &&
        Objects.equals(this.destination, transportDetails.destination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orientation, concoursRequest, transportationID,
                        teamCare, destination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransportDetails {\n");
    sb.append("    orientation: ")
        .append(toIndentedString(orientation))
        .append("\n");
    sb.append("    concoursRequest: ")
        .append(toIndentedString(concoursRequest))
        .append("\n");
    sb.append("    transportationID: ")
        .append(toIndentedString(transportationID))
        .append("\n");
    sb.append("    teamCare: ").append(toIndentedString(teamCare)).append("\n");
    sb.append("    destination: ")
        .append(toIndentedString(destination))
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