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
import com.hubsante.model.health.Decider;
import com.hubsante.model.health.EngagementDetails;
import com.hubsante.model.health.TransportDetails;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Decision
 */
@JsonPropertyOrder({Decision.JSON_PROPERTY_ID_PAT,
                    Decision.JSON_PROPERTY_CREATION,
                    Decision.JSON_PROPERTY_TYPE, Decision.JSON_PROPERTY_DECIDER,
                    Decision.JSON_PROPERTY_ENGAGEMENT_DETAILS,
                    Decision.JSON_PROPERTY_TRANSPORT_DETAILS})
@JsonTypeName("decision")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Decision {
  public static final String JSON_PROPERTY_ID_PAT = "idPat";
  private String idPat;

  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

  /**
   * Type de décision prise
   */
  public enum TypeEnum {
    CONSEIL("CONSEIL"),

    PMT("PMT"),

    INTER("INTER"),

    ORIENT("ORIENT"),

    PASPLUS("PASPLUS");

    private String value;

    TypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public static final String JSON_PROPERTY_DECIDER = "decider";
  private Decider decider;

  public static final String JSON_PROPERTY_ENGAGEMENT_DETAILS =
      "engagementDetails";
  private List<EngagementDetails> engagementDetails;

  public static final String JSON_PROPERTY_TRANSPORT_DETAILS =
      "transportDetails";
  private List<TransportDetails> transportDetails;

  public Decision() {}

  public Decision idPat(String idPat) {

    this.idPat = idPat;
    return this;
  }

  /**
   * ID partagé du patient concerné par la décision, lorsque le patient existe
   *et est identifié
   * @return idPat
   **/
  @JsonProperty(JSON_PROPERTY_ID_PAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getIdPat() {
    return idPat;
  }

  @JsonProperty(JSON_PROPERTY_ID_PAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdPat(String idPat) {
    this.idPat = idPat;
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

  public Decision type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Type de décision prise
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Decision decider(Decider decider) {

    this.decider = decider;
    return this;
  }

  /**
   * Get decider
   * @return decider
   **/
  @JsonProperty(JSON_PROPERTY_DECIDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Decider getDecider() {
    return decider;
  }

  @JsonProperty(JSON_PROPERTY_DECIDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDecider(Decider decider) {
    this.decider = decider;
  }

  public Decision engagementDetails(List<EngagementDetails> engagementDetails) {

    this.engagementDetails = engagementDetails;
    return this;
  }

  public Decision
  addEngagementDetailsItem(EngagementDetails engagementDetailsItem) {
    if (this.engagementDetails == null) {
      this.engagementDetails = new ArrayList<>();
    }
    this.engagementDetails.add(engagementDetailsItem);
    return this;
  }

  /**
   * Get engagementDetails
   * @return engagementDetails
   **/
  @JsonProperty(JSON_PROPERTY_ENGAGEMENT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EngagementDetails> getEngagementDetails() {
    return engagementDetails;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ENGAGEMENT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEngagementDetails(List<EngagementDetails> engagementDetails) {
    if (engagementDetails == null) {
      return;
    }
    if (this.engagementDetails == null) {
      this.engagementDetails = new ArrayList<>();
    }
    this.engagementDetails.addAll(engagementDetails);
  }

  public Decision transportDetails(List<TransportDetails> transportDetails) {

    this.transportDetails = transportDetails;
    return this;
  }

  public Decision
  addTransportDetailsItem(TransportDetails transportDetailsItem) {
    if (this.transportDetails == null) {
      this.transportDetails = new ArrayList<>();
    }
    this.transportDetails.add(transportDetailsItem);
    return this;
  }

  /**
   * Get transportDetails
   * @return transportDetails
   **/
  @JsonProperty(JSON_PROPERTY_TRANSPORT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<TransportDetails> getTransportDetails() {
    return transportDetails;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_TRANSPORT_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTransportDetails(List<TransportDetails> transportDetails) {
    if (transportDetails == null) {
      return;
    }
    if (this.transportDetails == null) {
      this.transportDetails = new ArrayList<>();
    }
    this.transportDetails.addAll(transportDetails);
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
    return Objects.equals(this.idPat, decision.idPat) &&
        Objects.equals(this.creation, decision.creation) &&
        Objects.equals(this.type, decision.type) &&
        Objects.equals(this.decider, decision.decider) &&
        Objects.equals(this.engagementDetails, decision.engagementDetails) &&
        Objects.equals(this.transportDetails, decision.transportDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPat, creation, type, decider, engagementDetails,
                        transportDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Decision {\n");
    sb.append("    idPat: ").append(toIndentedString(idPat)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    decider: ").append(toIndentedString(decider)).append("\n");
    sb.append("    engagementDetails: ")
        .append(toIndentedString(engagementDetails))
        .append("\n");
    sb.append("    transportDetails: ")
        .append(toIndentedString(transportDetails))
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
