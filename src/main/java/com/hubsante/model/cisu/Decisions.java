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
import com.hubsante.model.cisu.Destination;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Decisions
 */
@JsonPropertyOrder(
    {Decisions.JSON_PROPERTY_TYPE, Decisions.JSON_PROPERTY_ORIENTATION,
     Decisions.JSON_PROPERTY_TRANSPORTATION,
     Decisions.JSON_PROPERTY_MEDICALISATION,
     Decisions.JSON_PROPERTY_DESTINATION, Decisions.JSON_PROPERTY_CARELEVEL})
@JsonTypeName("decisions")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Decisions {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_ORIENTATION = "orientation";
  private String orientation;

  public static final String JSON_PROPERTY_TRANSPORTATION = "transportation";
  private List<String> transportation;

  public static final String JSON_PROPERTY_MEDICALISATION = "medicalisation";
  private String medicalisation;

  public static final String JSON_PROPERTY_DESTINATION = "destination";
  private Destination destination;

  /**
   * Gets or Sets carelevel
   */
  public enum CarelevelEnum {
    R1("R1"),

    R2("R2"),

    R3("R3"),

    R4("R4");

    private String value;

    CarelevelEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CarelevelEnum fromValue(String value) {
      for (CarelevelEnum b : CarelevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CARELEVEL = "carelevel";
  private CarelevelEnum carelevel;

  public Decisions() {}

  public Decisions type(String type) {

    this.type = type;
    return this;
  }

  /**
   * Type de décision prise
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }

  public Decisions orientation(String orientation) {

    this.orientation = orientation;
    return this;
  }

  /**
   * Décision(s) d&#39;orientation prise par le médecin régulateur
   * @return orientation
   **/
  @JsonProperty(JSON_PROPERTY_ORIENTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrientation() {
    return orientation;
  }

  @JsonProperty(JSON_PROPERTY_ORIENTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  public Decisions transportation(List<String> transportation) {

    this.transportation = transportation;
    return this;
  }

  public Decisions addTransportationItem(String transportationItem) {
    if (this.transportation == null) {
      this.transportation = new ArrayList<>();
    }
    this.transportation.add(transportationItem);
    return this;
  }

  /**
   * Get transportation
   * @return transportation
   **/
  @JsonProperty(JSON_PROPERTY_TRANSPORTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTransportation() {
    return transportation;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_TRANSPORTATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransportation(List<String> transportation) {
    if (transportation == null) {
      return;
    }
    if (this.transportation == null) {
      this.transportation = new ArrayList<>();
    }
    this.transportation.addAll(transportation);
  }

  public Decisions medicalisation(String medicalisation) {

    this.medicalisation = medicalisation;
    return this;
  }

  /**
   * Type d’équipe (médical, paramédicale, non médicale, standard, incomplete,
   *...)
   * @return medicalisation
   **/
  @JsonProperty(JSON_PROPERTY_MEDICALISATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMedicalisation() {
    return medicalisation;
  }

  @JsonProperty(JSON_PROPERTY_MEDICALISATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalisation(String medicalisation) {
    this.medicalisation = medicalisation;
  }

  public Decisions destination(Destination destination) {

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

  public Decisions carelevel(CarelevelEnum carelevel) {

    this.carelevel = carelevel;
    return this;
  }

  /**
   * Get carelevel
   * @return carelevel
   **/
  @JsonProperty(JSON_PROPERTY_CARELEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CarelevelEnum getCarelevel() {
    return carelevel;
  }

  @JsonProperty(JSON_PROPERTY_CARELEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCarelevel(CarelevelEnum carelevel) {
    this.carelevel = carelevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Decisions decisions = (Decisions)o;
    return Objects.equals(this.type, decisions.type) &&
        Objects.equals(this.orientation, decisions.orientation) &&
        Objects.equals(this.transportation, decisions.transportation) &&
        Objects.equals(this.medicalisation, decisions.medicalisation) &&
        Objects.equals(this.destination, decisions.destination) &&
        Objects.equals(this.carelevel, decisions.carelevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, orientation, transportation, medicalisation,
                        destination, carelevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Decisions {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    orientation: ")
        .append(toIndentedString(orientation))
        .append("\n");
    sb.append("    transportation: ")
        .append(toIndentedString(transportation))
        .append("\n");
    sb.append("    medicalisation: ")
        .append(toIndentedString(medicalisation))
        .append("\n");
    sb.append("    destination: ")
        .append(toIndentedString(destination))
        .append("\n");
    sb.append("    carelevel: ")
        .append(toIndentedString(carelevel))
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
