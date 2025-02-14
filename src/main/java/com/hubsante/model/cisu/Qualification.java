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

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.HealthMotive;
import com.hubsante.model.cisu.LocationKind;
import com.hubsante.model.cisu.RiskThreat;
import com.hubsante.model.cisu.Victims;
import com.hubsante.model.cisu.WhatsHappen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Qualification
 */
@JsonPropertyOrder({Qualification.JSON_PROPERTY_RISK_THREAT,
                    Qualification.JSON_PROPERTY_WHATS_HAPPEN,
                    Qualification.JSON_PROPERTY_LOCATION_KIND,
                    Qualification.JSON_PROPERTY_HEALTH_MOTIVE,
                    Qualification.JSON_PROPERTY_VICTIMS})
@JsonTypeName("qualification")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Qualification {
  public static final String JSON_PROPERTY_RISK_THREAT = "riskThreat";
  private List<RiskThreat> riskThreat;

  public static final String JSON_PROPERTY_WHATS_HAPPEN = "whatsHappen";
  private WhatsHappen whatsHappen;

  public static final String JSON_PROPERTY_LOCATION_KIND = "locationKind";
  private LocationKind locationKind;

  public static final String JSON_PROPERTY_HEALTH_MOTIVE = "healthMotive";
  private HealthMotive healthMotive;

  public static final String JSON_PROPERTY_VICTIMS = "victims";
  private Victims victims;

  public Qualification() {}

  public Qualification riskThreat(List<RiskThreat> riskThreat) {

    this.riskThreat = riskThreat;
    return this;
  }

  public Qualification addRiskThreatItem(RiskThreat riskThreatItem) {
    if (this.riskThreat == null) {
      this.riskThreat = new ArrayList<>();
    }
    this.riskThreat.add(riskThreatItem);
    return this;
  }

  /**
   * Get riskThreat
   * @return riskThreat
   **/
  @JsonProperty(JSON_PROPERTY_RISK_THREAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<RiskThreat> getRiskThreat() {
    return riskThreat;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_RISK_THREAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRiskThreat(List<RiskThreat> riskThreat) {
    if (riskThreat == null) {
      return;
    }
    if (this.riskThreat == null) {
      this.riskThreat = new ArrayList<>();
    }
    this.riskThreat.addAll(riskThreat);
  }

  public Qualification whatsHappen(WhatsHappen whatsHappen) {

    this.whatsHappen = whatsHappen;
    return this;
  }

  /**
   * Get whatsHappen
   * @return whatsHappen
   **/
  @JsonProperty(JSON_PROPERTY_WHATS_HAPPEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WhatsHappen getWhatsHappen() {
    return whatsHappen;
  }

  @JsonProperty(JSON_PROPERTY_WHATS_HAPPEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWhatsHappen(WhatsHappen whatsHappen) {
    this.whatsHappen = whatsHappen;
  }

  public Qualification locationKind(LocationKind locationKind) {

    this.locationKind = locationKind;
    return this;
  }

  /**
   * Get locationKind
   * @return locationKind
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocationKind getLocationKind() {
    return locationKind;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION_KIND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocationKind(LocationKind locationKind) {
    this.locationKind = locationKind;
  }

  public Qualification healthMotive(HealthMotive healthMotive) {

    this.healthMotive = healthMotive;
    return this;
  }

  /**
   * Get healthMotive
   * @return healthMotive
   **/
  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public HealthMotive getHealthMotive() {
    return healthMotive;
  }

  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHealthMotive(HealthMotive healthMotive) {
    this.healthMotive = healthMotive;
  }

  public Qualification victims(Victims victims) {

    this.victims = victims;
    return this;
  }

  /**
   * Get victims
   * @return victims
   **/
  @JsonProperty(JSON_PROPERTY_VICTIMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Victims getVictims() {
    return victims;
  }

  @JsonProperty(JSON_PROPERTY_VICTIMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVictims(Victims victims) {
    this.victims = victims;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Qualification qualification = (Qualification)o;
    return Objects.equals(this.riskThreat, qualification.riskThreat) &&
        Objects.equals(this.whatsHappen, qualification.whatsHappen) &&
        Objects.equals(this.locationKind, qualification.locationKind) &&
        Objects.equals(this.healthMotive, qualification.healthMotive) &&
        Objects.equals(this.victims, qualification.victims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(riskThreat, whatsHappen, locationKind, healthMotive,
                        victims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Qualification {\n");
    sb.append("    riskThreat: ")
        .append(toIndentedString(riskThreat))
        .append("\n");
    sb.append("    whatsHappen: ")
        .append(toIndentedString(whatsHappen))
        .append("\n");
    sb.append("    locationKind: ")
        .append(toIndentedString(locationKind))
        .append("\n");
    sb.append("    healthMotive: ")
        .append(toIndentedString(healthMotive))
        .append("\n");
    sb.append("    victims: ").append(toIndentedString(victims)).append("\n");
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
