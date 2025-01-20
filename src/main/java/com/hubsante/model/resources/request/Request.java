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

package com.hubsante.model.resources.request;

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
 * Request
 */
@JsonPropertyOrder(
    {Request.JSON_PROPERTY_REQUEST_ID, Request.JSON_PROPERTY_DATETIME,
     Request.JSON_PROPERTY_CONVENTION, Request.JSON_PROPERTY_PURPOSE,
     Request.JSON_PROPERTY_DEADLINE, Request.JSON_PROPERTY_FREETEXT})
@JsonTypeName("request")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Request {
  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_DATETIME = "datetime";
  private OffsetDateTime datetime;

  /**
   * A valoriser avec le cadre conventionnel de la demande. Cf nomenclature
   * associée
   */
  public enum ConventionEnum {
    DRSIS("DRSIS"),

    MISSION("MISSION"),

    ITSP("ITSP"),

    CARENCE("CARENCE"),

    CONVENT("CONVENT"),

    SPE("SPE"),

    HORS("HORS"),

    AUTRE1("AUTRE1"),

    AUTRE2("AUTRE2"),

    AUTRE3("AUTRE3");

    private String value;

    ConventionEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ConventionEnum fromValue(String value) {
      for (ConventionEnum b : ConventionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CONVENTION = "convention";
  private ConventionEnum convention;

  /**
   * A valoriser avec le motif de la demande de ressource auprès du partenaire.
   * Cf Nomenclature associée.
   */
  public enum PurposeEnum {
    SAP("SAP"),

    REGUL("REGUL"),

    CUMP("CUMP"),

    SMUR("SMUR"),

    MG("MG"),

    PARAMED("PARAMED"),

    SAMU("SAMU"),

    RELEVE("RELEVE"),

    NOVI("NOVI"),

    TIH("TIH"),

    BRANCARD("BRANCARD"),

    BARIA("BARIA");

    private String value;

    PurposeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PurposeEnum fromValue(String value) {
      for (PurposeEnum b : PurposeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PURPOSE = "purpose";
  private PurposeEnum purpose;

  /**
   * A valoriser avec le délai d&#39;intervention maximum souhaité (cf.
   * nomenclature associée)
   */
  public enum DeadlineEnum {
    DEL0("DEL0"),

    ASAP("ASAP"),

    _30M("30M"),

    _45M("45M"),

    _1H("1H"),

    _2H("2H"),

    _4H("4H"),

    _8H("8H"),

    _12H("12H"),

    _24H("24H"),

    RDV("RDV");

    private String value;

    DeadlineEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DeadlineEnum fromValue(String value) {
      for (DeadlineEnum b : DeadlineEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_DEADLINE = "deadline";
  private DeadlineEnum deadline;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public Request() {}

  public Request requestId(String requestId) {

    this.requestId = requestId;
    return this;
  }

  /**
   * Identifiant unique partagé de la demande de ressource,  généré une seule
   *fois par le système du partenaire qui émet la demande  Il est valorisé comme
   *suit lors de sa création :  {orgID}.request.{ID unique de la demande dans le
   *système émetteur}  OU - uniquement si un ID unique de la demande n&#39;est
   *pas disponible :  {OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre
   *chronologique}
   * @return requestId
   **/
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRequestId() {
    return requestId;
  }

  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Request datetime(OffsetDateTime datetime) {

    this.datetime = datetime;
    return this;
  }

  /**
   * A valoriser avec le groupe date heure de création de la demande
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

  public Request convention(ConventionEnum convention) {

    this.convention = convention;
    return this;
  }

  /**
   * A valoriser avec le cadre conventionnel de la demande. Cf nomenclature
   *associée
   * @return convention
   **/
  @JsonProperty(JSON_PROPERTY_CONVENTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ConventionEnum getConvention() {
    return convention;
  }

  @JsonProperty(JSON_PROPERTY_CONVENTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConvention(ConventionEnum convention) {
    this.convention = convention;
  }

  public Request purpose(PurposeEnum purpose) {

    this.purpose = purpose;
    return this;
  }

  /**
   * A valoriser avec le motif de la demande de ressource auprès du partenaire.
   *Cf Nomenclature associée.
   * @return purpose
   **/
  @JsonProperty(JSON_PROPERTY_PURPOSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PurposeEnum getPurpose() {
    return purpose;
  }

  @JsonProperty(JSON_PROPERTY_PURPOSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPurpose(PurposeEnum purpose) {
    this.purpose = purpose;
  }

  public Request deadline(DeadlineEnum deadline) {

    this.deadline = deadline;
    return this;
  }

  /**
   * A valoriser avec le délai d&#39;intervention maximum souhaité (cf.
   *nomenclature associée)
   * @return deadline
   **/
  @JsonProperty(JSON_PROPERTY_DEADLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DeadlineEnum getDeadline() {
    return deadline;
  }

  @JsonProperty(JSON_PROPERTY_DEADLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeadline(DeadlineEnum deadline) {
    this.deadline = deadline;
  }

  public Request freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Texte libre permettant de détailler la demande
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request)o;
    return Objects.equals(this.requestId, request.requestId) &&
        Objects.equals(this.datetime, request.datetime) &&
        Objects.equals(this.convention, request.convention) &&
        Objects.equals(this.purpose, request.purpose) &&
        Objects.equals(this.deadline, request.deadline) &&
        Objects.equals(this.freetext, request.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, datetime, convention, purpose, deadline,
                        freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    requestId: ")
        .append(toIndentedString(requestId))
        .append("\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    convention: ")
        .append(toIndentedString(convention))
        .append("\n");
    sb.append("    purpose: ").append(toIndentedString(purpose)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
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
