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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Response
 */
@JsonPropertyOrder(
    {Response.JSON_PROPERTY_DATETIME, Response.JSON_PROPERTY_ANSWER,
     Response.JSON_PROPERTY_DEADLINE, Response.JSON_PROPERTY_FREETEXT})
@JsonTypeName("response")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Response {
  public static final String JSON_PROPERTY_DATETIME = "datetime";
  private OffsetDateTime datetime;

  /**
   * A valoriser avec la réponse apportée. Cf Nomenclature associée ACCEPTEE,
   * REFUSEE, PARTIELLE, DIFFEREE
   */
  public enum AnswerEnum {
    ACCEPTEE("ACCEPTEE"),

    REFUSEE("REFUSEE"),

    PARTIELLE("PARTIELLE"),

    DIFFEREE("DIFFEREE");

    private String value;

    AnswerEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AnswerEnum fromValue(String value) {
      for (AnswerEnum b : AnswerEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ANSWER = "answer";
  private AnswerEnum answer;

  public static final String JSON_PROPERTY_DEADLINE = "deadline";
  private String deadline;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public Response() {}

  public Response datetime(OffsetDateTime datetime) {

    this.datetime = datetime;
    return this;
  }

  /**
   * Groupe date heure de début de la demande
   * @return datetime
   **/
  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getDatetime() {
    return datetime;
  }

  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDatetime(OffsetDateTime datetime) {
    this.datetime = datetime;
  }

  public Response answer(AnswerEnum answer) {

    this.answer = answer;
    return this;
  }

  /**
   * A valoriser avec la réponse apportée. Cf Nomenclature associée ACCEPTEE,
   *REFUSEE, PARTIELLE, DIFFEREE
   * @return answer
   **/
  @JsonProperty(JSON_PROPERTY_ANSWER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AnswerEnum getAnswer() {
    return answer;
  }

  @JsonProperty(JSON_PROPERTY_ANSWER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAnswer(AnswerEnum answer) {
    this.answer = answer;
  }

  public Response deadline(String deadline) {

    this.deadline = deadline;
    return this;
  }

  /**
   * A valoriser avec le délai de réponse auquel s&#39;engage l&#39;expéditeur
   *(en minutes),
   * @return deadline
   **/
  @JsonProperty(JSON_PROPERTY_DEADLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDeadline() {
    return deadline;
  }

  @JsonProperty(JSON_PROPERTY_DEADLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDeadline(String deadline) {
    this.deadline = deadline;
  }

  public Response freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Commentaire libre permettant d&#39;apporter toutes précisions utiles à la
   *réponse. Le motif de refus est notifié dans ce champ.
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
    Response response = (Response)o;
    return Objects.equals(this.datetime, response.datetime) &&
        Objects.equals(this.answer, response.answer) &&
        Objects.equals(this.deadline, response.deadline) &&
        Objects.equals(this.freetext, response.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datetime, answer, deadline, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response {\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    answer: ").append(toIndentedString(answer)).append("\n");
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
