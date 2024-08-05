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
import com.hubsante.model.rpis.Event;
import com.hubsante.model.rpis.Intervention;
import com.hubsante.model.rpis.Patient;
import com.hubsante.model.rpis.Regulation;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Rpis
 */
@JsonPropertyOrder({Rpis.JSON_PROPERTY_EVENT, Rpis.JSON_PROPERTY_REGULATION,
                    Rpis.JSON_PROPERTY_PATIENT,
                    Rpis.JSON_PROPERTY_INTERVENTION})
@JsonTypeName("rpis")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Rpis {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:rpis";
  public static final String JSON_PROPERTY_EVENT = "event";
  private Event event;

  public static final String JSON_PROPERTY_REGULATION = "regulation";
  private Regulation regulation;

  public static final String JSON_PROPERTY_PATIENT = "patient";
  private Patient patient;

  public static final String JSON_PROPERTY_INTERVENTION = "intervention";
  private Intervention intervention;

  public Rpis() {}

  public Rpis event(Event event) {

    this.event = event;
    return this;
  }

  /**
   * Get event
   * @return event
   **/
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Event getEvent() {
    return event;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEvent(Event event) {
    this.event = event;
  }

  public Rpis regulation(Regulation regulation) {

    this.regulation = regulation;
    return this;
  }

  /**
   * Get regulation
   * @return regulation
   **/
  @JsonProperty(JSON_PROPERTY_REGULATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Regulation getRegulation() {
    return regulation;
  }

  @JsonProperty(JSON_PROPERTY_REGULATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRegulation(Regulation regulation) {
    this.regulation = regulation;
  }

  public Rpis patient(Patient patient) {

    this.patient = patient;
    return this;
  }

  /**
   * Get patient
   * @return patient
   **/
  @JsonProperty(JSON_PROPERTY_PATIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Patient getPatient() {
    return patient;
  }

  @JsonProperty(JSON_PROPERTY_PATIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Rpis intervention(Intervention intervention) {

    this.intervention = intervention;
    return this;
  }

  /**
   * Get intervention
   * @return intervention
   **/
  @JsonProperty(JSON_PROPERTY_INTERVENTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Intervention getIntervention() {
    return intervention;
  }

  @JsonProperty(JSON_PROPERTY_INTERVENTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntervention(Intervention intervention) {
    this.intervention = intervention;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rpis rpis = (Rpis)o;
    return Objects.equals(this.event, rpis.event) &&
        Objects.equals(this.regulation, rpis.regulation) &&
        Objects.equals(this.patient, rpis.patient) &&
        Objects.equals(this.intervention, rpis.intervention);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, regulation, patient, intervention);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rpis {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    regulation: ")
        .append(toIndentedString(regulation))
        .append("\n");
    sb.append("    patient: ").append(toIndentedString(patient)).append("\n");
    sb.append("    intervention: ")
        .append(toIndentedString(intervention))
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
