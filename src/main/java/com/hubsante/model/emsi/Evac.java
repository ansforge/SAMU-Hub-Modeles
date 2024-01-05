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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Evac
 */
@JsonPropertyOrder({Evac.JSON_PROPERTY_D_A_T_I_M_E,
                    Evac.JSON_PROPERTY_D_I_S_P_L_A_C_E_D,
                    Evac.JSON_PROPERTY_E_V_A_C_U_A_T_E_D})
@JsonTypeName("evac")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Evac {
  public static final String JSON_PROPERTY_D_A_T_I_M_E = "DATIME";
  private OffsetDateTime DATIME;

  public static final String JSON_PROPERTY_D_I_S_P_L_A_C_E_D = "DISPLACED";
  private Integer DISPLACED;

  public static final String JSON_PROPERTY_E_V_A_C_U_A_T_E_D = "EVACUATED";
  private Integer EVACUATED;

  public Evac() {}

  public Evac DATIME(OffsetDateTime DATIME) {

    this.DATIME = DATIME;
    return this;
  }

  /**
   * Optionnel
   * @return DATIME
   **/
  @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDATIME() {
    return DATIME;
  }

  @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDATIME(OffsetDateTime DATIME) {
    this.DATIME = DATIME;
  }

  public Evac DISPLACED(Integer DISPLACED) {

    this.DISPLACED = DISPLACED;
    return this;
  }

  /**
   * Optionnel
   * @return DISPLACED
   **/
  @JsonProperty(JSON_PROPERTY_D_I_S_P_L_A_C_E_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getDISPLACED() {
    return DISPLACED;
  }

  @JsonProperty(JSON_PROPERTY_D_I_S_P_L_A_C_E_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDISPLACED(Integer DISPLACED) {
    this.DISPLACED = DISPLACED;
  }

  public Evac EVACUATED(Integer EVACUATED) {

    this.EVACUATED = EVACUATED;
    return this;
  }

  /**
   * Optionnel
   * @return EVACUATED
   **/
  @JsonProperty(JSON_PROPERTY_E_V_A_C_U_A_T_E_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getEVACUATED() {
    return EVACUATED;
  }

  @JsonProperty(JSON_PROPERTY_E_V_A_C_U_A_T_E_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEVACUATED(Integer EVACUATED) {
    this.EVACUATED = EVACUATED;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Evac evac = (Evac)o;
    return Objects.equals(this.DATIME, evac.DATIME) &&
        Objects.equals(this.DISPLACED, evac.DISPLACED) &&
        Objects.equals(this.EVACUATED, evac.EVACUATED);
  }

  @Override
  public int hashCode() {
    return Objects.hash(DATIME, DISPLACED, EVACUATED);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Evac {\n");
    sb.append("    DATIME: ").append(toIndentedString(DATIME)).append("\n");
    sb.append("    DISPLACED: ")
        .append(toIndentedString(DISPLACED))
        .append("\n");
    sb.append("    EVACUATED: ")
        .append(toIndentedString(EVACUATED))
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
