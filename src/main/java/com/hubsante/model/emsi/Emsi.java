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

package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.emsi.Context;
import com.hubsante.model.emsi.Event;
import com.hubsante.model.emsi.Mission;
import com.hubsante.model.emsi.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Emsi
 */
@JsonPropertyOrder(
    {Emsi.JSON_PROPERTY_C_O_N_T_E_X_T, Emsi.JSON_PROPERTY_E_V_E_N_T,
     Emsi.JSON_PROPERTY_M_I_S_S_I_O_N, Emsi.JSON_PROPERTY_R_E_S_O_U_R_C_E})
@JsonTypeName("emsi")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Emsi {
  public static final String JSON_PROPERTY_C_O_N_T_E_X_T = "CONTEXT";
  private Context CONTEXT;

  public static final String JSON_PROPERTY_E_V_E_N_T = "EVENT";
  private Event EVENT;

  public static final String JSON_PROPERTY_M_I_S_S_I_O_N = "MISSION";
  private List<Mission> MISSION;

  public static final String JSON_PROPERTY_R_E_S_O_U_R_C_E = "RESOURCE";
  private List<Resource> RESOURCE;

  public Emsi() {}

  public Emsi CONTEXT(Context CONTEXT) {

    this.CONTEXT = CONTEXT;
    return this;
  }

  /**
   * Get CONTEXT
   * @return CONTEXT
   **/
  @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Context getCONTEXT() {
    return CONTEXT;
  }

  @JsonProperty(JSON_PROPERTY_C_O_N_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCONTEXT(Context CONTEXT) {
    this.CONTEXT = CONTEXT;
  }

  public Emsi EVENT(Event EVENT) {

    this.EVENT = EVENT;
    return this;
  }

  /**
   * Get EVENT
   * @return EVENT
   **/
  @JsonProperty(JSON_PROPERTY_E_V_E_N_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Event getEVENT() {
    return EVENT;
  }

  @JsonProperty(JSON_PROPERTY_E_V_E_N_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEVENT(Event EVENT) {
    this.EVENT = EVENT;
  }

  public Emsi MISSION(List<Mission> MISSION) {

    this.MISSION = MISSION;
    return this;
  }

  public Emsi addMISSIONItem(Mission MISSIONItem) {
    if (this.MISSION == null) {
      this.MISSION = new ArrayList<>();
    }
    this.MISSION.add(MISSIONItem);
    return this;
  }

  /**
   * Get MISSION
   * @return MISSION
   **/
  @JsonProperty(JSON_PROPERTY_M_I_S_S_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Mission> getMISSION() {
    return MISSION;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_M_I_S_S_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMISSION(List<Mission> MISSION) {
    if (MISSION == null) {
      return;
    }
    if (this.MISSION == null) {
      this.MISSION = new ArrayList<>();
    }
    this.MISSION.addAll(MISSION);
  }

  public Emsi RESOURCE(List<Resource> RESOURCE) {

    this.RESOURCE = RESOURCE;
    return this;
  }

  public Emsi addRESOURCEItem(Resource RESOURCEItem) {
    if (this.RESOURCE == null) {
      this.RESOURCE = new ArrayList<>();
    }
    this.RESOURCE.add(RESOURCEItem);
    return this;
  }

  /**
   * Get RESOURCE
   * @return RESOURCE
   **/
  @JsonProperty(JSON_PROPERTY_R_E_S_O_U_R_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Resource> getRESOURCE() {
    return RESOURCE;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_R_E_S_O_U_R_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRESOURCE(List<Resource> RESOURCE) {
    if (RESOURCE == null) {
      return;
    }
    if (this.RESOURCE == null) {
      this.RESOURCE = new ArrayList<>();
    }
    this.RESOURCE.addAll(RESOURCE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Emsi emsi = (Emsi)o;
    return Objects.equals(this.CONTEXT, emsi.CONTEXT) &&
        Objects.equals(this.EVENT, emsi.EVENT) &&
        Objects.equals(this.MISSION, emsi.MISSION) &&
        Objects.equals(this.RESOURCE, emsi.RESOURCE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(CONTEXT, EVENT, MISSION, RESOURCE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Emsi {\n");
    sb.append("    CONTEXT: ").append(toIndentedString(CONTEXT)).append("\n");
    sb.append("    EVENT: ").append(toIndentedString(EVENT)).append("\n");
    sb.append("    MISSION: ").append(toIndentedString(MISSION)).append("\n");
    sb.append("    RESOURCE: ").append(toIndentedString(RESOURCE)).append("\n");
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
