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
import com.hubsante.model.rpis.Location;
import com.hubsante.model.rpis.ResourceStatus;
import com.hubsante.model.rpis.Team;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Intervention
 */
@JsonPropertyOrder({Intervention.JSON_PROPERTY_LOCATION,
                    Intervention.JSON_PROPERTY_TEAM,
                    Intervention.JSON_PROPERTY_ACTIONS,
                    Intervention.JSON_PROPERTY_MAIN_DIAGNOSIS,
                    Intervention.JSON_PROPERTY_ASSOCIATED_DIAGNOSIS,
                    Intervention.JSON_PROPERTY_SMUR_STATUS})
@JsonTypeName("intervention")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Intervention {
  public static final String JSON_PROPERTY_LOCATION = "location";
  private Location location;

  public static final String JSON_PROPERTY_TEAM = "team";
  private Team team;

  public static final String JSON_PROPERTY_ACTIONS = "actions";
  private List<String> actions;

  public static final String JSON_PROPERTY_MAIN_DIAGNOSIS = "mainDiagnosis";
  private String mainDiagnosis;

  public static final String JSON_PROPERTY_ASSOCIATED_DIAGNOSIS =
      "associatedDiagnosis";
  private String associatedDiagnosis;

  public static final String JSON_PROPERTY_SMUR_STATUS = "smurStatus";
  private ResourceStatus smurStatus;

  public Intervention() {}

  public Intervention location(Location location) {

    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Location getLocation() {
    return location;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocation(Location location) {
    this.location = location;
  }

  public Intervention team(Team team) {

    this.team = team;
    return this;
  }

  /**
   * Get team
   * @return team
   **/
  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Team getTeam() {
    return team;
  }

  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTeam(Team team) {
    this.team = team;
  }

  public Intervention actions(List<String> actions) {

    this.actions = actions;
    return this;
  }

  public Intervention addActionsItem(String actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<>();
    }
    this.actions.add(actionsItem);
    return this;
  }

  /**
   * Get actions
   * @return actions
   **/
  @JsonProperty(JSON_PROPERTY_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getActions() {
    return actions;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ACTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setActions(List<String> actions) {
    if (actions == null) {
      return;
    }
    if (this.actions == null) {
      this.actions = new ArrayList<>();
    }
    this.actions.addAll(actions);
  }

  public Intervention mainDiagnosis(String mainDiagnosis) {

    this.mainDiagnosis = mainDiagnosis;
    return this;
  }

  /**
   * Thésaurus SFMU-FEDORU. A valoriser par un code de la nomenclature
   *Diagnostic SMUR.
   * @return mainDiagnosis
   **/
  @JsonProperty(JSON_PROPERTY_MAIN_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMainDiagnosis() {
    return mainDiagnosis;
  }

  @JsonProperty(JSON_PROPERTY_MAIN_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMainDiagnosis(String mainDiagnosis) {
    this.mainDiagnosis = mainDiagnosis;
  }

  public Intervention associatedDiagnosis(String associatedDiagnosis) {

    this.associatedDiagnosis = associatedDiagnosis;
    return this;
  }

  /**
   * Thésaurus SFMU-FEDORU. A valoriser par un code de la nomenclature
   *Diagnostic SMUR.
   * @return associatedDiagnosis
   **/
  @JsonProperty(JSON_PROPERTY_ASSOCIATED_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAssociatedDiagnosis() {
    return associatedDiagnosis;
  }

  @JsonProperty(JSON_PROPERTY_ASSOCIATED_DIAGNOSIS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAssociatedDiagnosis(String associatedDiagnosis) {
    this.associatedDiagnosis = associatedDiagnosis;
  }

  public Intervention smurStatus(ResourceStatus smurStatus) {

    this.smurStatus = smurStatus;
    return this;
  }

  /**
   * Get smurStatus
   * @return smurStatus
   **/
  @JsonProperty(JSON_PROPERTY_SMUR_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ResourceStatus getSmurStatus() {
    return smurStatus;
  }

  @JsonProperty(JSON_PROPERTY_SMUR_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSmurStatus(ResourceStatus smurStatus) {
    this.smurStatus = smurStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Intervention intervention = (Intervention)o;
    return Objects.equals(this.location, intervention.location) &&
        Objects.equals(this.team, intervention.team) &&
        Objects.equals(this.actions, intervention.actions) &&
        Objects.equals(this.mainDiagnosis, intervention.mainDiagnosis) &&
        Objects.equals(this.associatedDiagnosis,
                       intervention.associatedDiagnosis) &&
        Objects.equals(this.smurStatus, intervention.smurStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, team, actions, mainDiagnosis,
                        associatedDiagnosis, smurStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Intervention {\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    mainDiagnosis: ")
        .append(toIndentedString(mainDiagnosis))
        .append("\n");
    sb.append("    associatedDiagnosis: ")
        .append(toIndentedString(associatedDiagnosis))
        .append("\n");
    sb.append("    smurStatus: ")
        .append(toIndentedString(smurStatus))
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