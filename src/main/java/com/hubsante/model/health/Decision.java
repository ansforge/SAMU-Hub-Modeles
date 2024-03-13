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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.Destination;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Decision
 */
@JsonPropertyOrder(
    {Decision.JSON_PROPERTY_ID, Decision.JSON_PROPERTY_CREATION,
     Decision.JSON_PROPERTY_TYPE, Decision.JSON_PROPERTY_ORIENTATION,
     Decision.JSON_PROPERTY_TRANSPORTATION,
     Decision.JSON_PROPERTY_MEDICALISATION, Decision.JSON_PROPERTY_DESTINATION})
@JsonTypeName("decision")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Decision {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

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

  public Decision() {}

  public Decision id(String id) {

    this.id = id;
    return this;
  }

  /**
   * ID partagé du patient concerné, lorsque le patient existe et est identifié
   * @return id
   **/
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  public Decision creation(OffsetDateTime creation) {

    this.creation = creation;
    return this;
  }

  /**
   * Groupe date heure de création de la décision.  L&#39;indicateur de fuseau
   *horaire Z ne doit pas être utilisé.
   * @return creation
   **/
  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getCreation() {
    return creation;
  }

  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreation(OffsetDateTime creation) {
    this.creation = creation;
  }

  public Decision type(String type) {

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

  public Decision orientation(String orientation) {

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

  public Decision transportation(List<String> transportation) {

    this.transportation = transportation;
    return this;
  }

  public Decision addTransportationItem(String transportationItem) {
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

  public Decision medicalisation(String medicalisation) {

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

  public Decision destination(Destination destination) {

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
    Decision decision = (Decision)o;
    return Objects.equals(this.id, decision.id) &&
        Objects.equals(this.creation, decision.creation) &&
        Objects.equals(this.type, decision.type) &&
        Objects.equals(this.orientation, decision.orientation) &&
        Objects.equals(this.transportation, decision.transportation) &&
        Objects.equals(this.medicalisation, decision.medicalisation) &&
        Objects.equals(this.destination, decision.destination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creation, type, orientation, transportation,
                        medicalisation, destination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Decision {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
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
