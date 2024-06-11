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

package com.hubsante.model.rpis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.rpis.Decision;
import com.hubsante.model.rpis.Destination;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Orientation
 */
@JsonPropertyOrder({Orientation.JSON_PROPERTY_TYPE,
                    Orientation.JSON_PROPERTY_DESTINATION,
                    Orientation.JSON_PROPERTY_DECISION})
@JsonTypeName("orientation")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Orientation {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private Destination destination;

  public static final String JSON_PROPERTY_DECISION = "decision";
  private Decision decision;

  public Orientation() {}

  public Orientation type(String type) {

    this.type = type;
    return this;
  }

  /**
   * Indique si le patient est transporté ou non (Sans transport associé / avec
   *transport associé).  A valoriser par un code de la nomenclature
   *NOMENC_DEVENIR_PAT_200622. Si le type d&#39;orientation est sans transport
   *associé, les objets Destination et Transport sont facultatifs.
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

  public Orientation destination(Destination destination) {

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

  public Orientation decision(Decision decision) {

    this.decision = decision;
    return this;
  }

  /**
   * Get decision
   * @return decision
   **/
  @JsonProperty(JSON_PROPERTY_DECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Decision getDecision() {
    return decision;
  }

  @JsonProperty(JSON_PROPERTY_DECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDecision(Decision decision) {
    this.decision = decision;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Orientation orientation = (Orientation)o;
    return Objects.equals(this.type, orientation.type) &&
        Objects.equals(this.destination, orientation.destination) &&
        Objects.equals(this.decision, orientation.decision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, destination, decision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Orientation {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    destination: ")
        .append(toIndentedString(destination))
        .append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
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