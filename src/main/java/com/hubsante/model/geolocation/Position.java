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

package com.hubsante.model.geolocation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.geolocation.Coord;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Position
 */
@JsonPropertyOrder(
    {Position.JSON_PROPERTY_RESOURCE_ID, Position.JSON_PROPERTY_DATETIME,
     Position.JSON_PROPERTY_COORD, Position.JSON_PROPERTY_SPEED,
     Position.JSON_PROPERTY_CAP, Position.JSON_PROPERTY_MOVE,
     Position.JSON_PROPERTY_ENGINE_ON, Position.JSON_PROPERTY_GROUND_STATUS,
     Position.JSON_PROPERTY_STATUS, Position.JSON_PROPERTY_ENGAGED_STATUS})
@JsonTypeName("position")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Position {
  public static final String JSON_PROPERTY_RESOURCE_ID = "resourceId";
  private String resourceId;

  public static final String JSON_PROPERTY_DATETIME = "datetime";
  private OffsetDateTime datetime;

  public static final String JSON_PROPERTY_COORD = "coord";
  private Coord coord;

  public static final String JSON_PROPERTY_SPEED = "speed";
  private BigDecimal speed;

  public static final String JSON_PROPERTY_CAP = "cap";
  private String cap;

  /**
   * Indique si la ressource est en mouvement (MOBILE) ou non (STATIQUE)
   */
  public enum MoveEnum {
    MOBILE("MOBILE"),

    STATIQUE("STATIQUE");

    private String value;

    MoveEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MoveEnum fromValue(String value) {
      for (MoveEnum b : MoveEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_MOVE = "move";
  private MoveEnum move;

  public static final String JSON_PROPERTY_ENGINE_ON = "engineOn";
  private Boolean engineOn;

  public static final String JSON_PROPERTY_GROUND_STATUS = "groundStatus";
  private Boolean groundStatus;

  /**
   * Définit le statut de disponibilité d&#39;une ressource. - DISPONIBLE :
   * Lorsque la ressource est disponible - INDISPONIBLE : Lorsque la ressource
   * n&#39;est pas disponible, celle-ci peut être engagée ou en maintenance -
   * INCONNU : Lorsque le status est inconnu
   */
  public enum StatusEnum {
    DISPONIBLE("DISPONIBLE"),

    INDISPONIBLE("INDISPONIBLE"),

    INCONNU("INCONNU");

    private String value;

    StatusEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  /**
   * Précise le statut d&#39;une ressource qui est engagée sur une mission
   */
  public enum EngagedStatusEnum {
    ALERTEE("ALERTEE"),

    PARTIE("PARTIE"),

    ARRIVEE_LIEU("ARRIVEE_LIEU"),

    TRANSPORT_DESTINATION("TRANSPORT_DESTINATION"),

    ARRIVEE_DESTINATION("ARRIVEE_DESTINATION"),

    FIN_MED("FIN_MED"),

    QUITTE_DESTINATION("QUITTE_DESTINATION"),

    RETOUR_DISPONIBLE("RETOUR_DISPONIBLE"),

    RETOUR_INDISPONIBLE("RETOUR_INDISPONIBLE"),

    ARRIVEE_CENTRE("ARRIVEE_CENTRE");

    private String value;

    EngagedStatusEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EngagedStatusEnum fromValue(String value) {
      for (EngagedStatusEnum b : EngagedStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ENGAGED_STATUS = "engagedStatus";
  private EngagedStatusEnum engagedStatus;

  public Position() {}

  public Position resourceId(String resourceId) {

    this.resourceId = resourceId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant partagé unique de la ressource engagée,
   *normé comme suit : {orgID}.resource.{ID unique de la ressource partagée} OU
   *- uniquement dans le cas où un ID unique de ressource ne peut pas être
   *garanti par l&#39;organisation propriétaire :
   *{orgID}.resource.{sendercaseId}.{n° d’ordre chronologique de la ressource}
   * @return resourceId
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResourceId() {
    return resourceId;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public Position datetime(OffsetDateTime datetime) {

    this.datetime = datetime;
    return this;
  }

  /**
   * Date et heure de réception des coordonnées transmises
   * @return datetime
   **/
  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDatetime() {
    return datetime;
  }

  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDatetime(OffsetDateTime datetime) {
    this.datetime = datetime;
  }

  public Position coord(Coord coord) {

    this.coord = coord;
    return this;
  }

  /**
   * Get coord
   * @return coord
   **/
  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Coord getCoord() {
    return coord;
  }

  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public Position speed(BigDecimal speed) {

    this.speed = speed;
    return this;
  }

  /**
   * Vitesse de la ressource enregistrée, exprimée en km/h
   * @return speed
   **/
  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getSpeed() {
    return speed;
  }

  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpeed(BigDecimal speed) {
    this.speed = speed;
  }

  public Position cap(String cap) {

    this.cap = cap;
    return this;
  }

  /**
   * Direction de la ressource, exprimé en degrés
   * @return cap
   **/
  @JsonProperty(JSON_PROPERTY_CAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCap() {
    return cap;
  }

  @JsonProperty(JSON_PROPERTY_CAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCap(String cap) {
    this.cap = cap;
  }

  public Position move(MoveEnum move) {

    this.move = move;
    return this;
  }

  /**
   * Indique si la ressource est en mouvement (MOBILE) ou non (STATIQUE)
   * @return move
   **/
  @JsonProperty(JSON_PROPERTY_MOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MoveEnum getMove() {
    return move;
  }

  @JsonProperty(JSON_PROPERTY_MOVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMove(MoveEnum move) {
    this.move = move;
  }

  public Position engineOn(Boolean engineOn) {

    this.engineOn = engineOn;
    return this;
  }

  /**
   * Indique si le moteur de la ressource est éteint (FAUX) ou allumé/en marche
   *(VRAI)
   * @return engineOn
   **/
  @JsonProperty(JSON_PROPERTY_ENGINE_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getEngineOn() {
    return engineOn;
  }

  @JsonProperty(JSON_PROPERTY_ENGINE_ON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEngineOn(Boolean engineOn) {
    this.engineOn = engineOn;
  }

  public Position groundStatus(Boolean groundStatus) {

    this.groundStatus = groundStatus;
    return this;
  }

  /**
   * Indique si l&#39;hélicoptère est au sol (VRAI) ou en l&#39;air (FAUX)
   * @return groundStatus
   **/
  @JsonProperty(JSON_PROPERTY_GROUND_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getGroundStatus() {
    return groundStatus;
  }

  @JsonProperty(JSON_PROPERTY_GROUND_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGroundStatus(Boolean groundStatus) {
    this.groundStatus = groundStatus;
  }

  public Position status(StatusEnum status) {

    this.status = status;
    return this;
  }

  /**
   * Définit le statut de disponibilité d&#39;une ressource. - DISPONIBLE :
   *Lorsque la ressource est disponible - INDISPONIBLE : Lorsque la ressource
   *n&#39;est pas disponible, celle-ci peut être engagée ou en maintenance -
   *INCONNU : Lorsque le status est inconnu
   * @return status
   **/
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Position engagedStatus(EngagedStatusEnum engagedStatus) {

    this.engagedStatus = engagedStatus;
    return this;
  }

  /**
   * Précise le statut d&#39;une ressource qui est engagée sur une mission
   * @return engagedStatus
   **/
  @JsonProperty(JSON_PROPERTY_ENGAGED_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EngagedStatusEnum getEngagedStatus() {
    return engagedStatus;
  }

  @JsonProperty(JSON_PROPERTY_ENGAGED_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEngagedStatus(EngagedStatusEnum engagedStatus) {
    this.engagedStatus = engagedStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position)o;
    return Objects.equals(this.resourceId, position.resourceId) &&
        Objects.equals(this.datetime, position.datetime) &&
        Objects.equals(this.coord, position.coord) &&
        Objects.equals(this.speed, position.speed) &&
        Objects.equals(this.cap, position.cap) &&
        Objects.equals(this.move, position.move) &&
        Objects.equals(this.engineOn, position.engineOn) &&
        Objects.equals(this.groundStatus, position.groundStatus) &&
        Objects.equals(this.status, position.status) &&
        Objects.equals(this.engagedStatus, position.engagedStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceId, datetime, coord, speed, cap, move, engineOn,
                        groundStatus, status, engagedStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Position {\n");
    sb.append("    resourceId: ")
        .append(toIndentedString(resourceId))
        .append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    cap: ").append(toIndentedString(cap)).append("\n");
    sb.append("    move: ").append(toIndentedString(move)).append("\n");
    sb.append("    engineOn: ").append(toIndentedString(engineOn)).append("\n");
    sb.append("    groundStatus: ")
        .append(toIndentedString(groundStatus))
        .append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    engagedStatus: ")
        .append(toIndentedString(engagedStatus))
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
