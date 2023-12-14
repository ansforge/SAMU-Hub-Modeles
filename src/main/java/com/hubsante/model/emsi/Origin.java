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

package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Origin
 */
@JsonPropertyOrder({Origin.JSON_PROPERTY_O_R_G_I_D,
                    Origin.JSON_PROPERTY_U_S_E_R_I_D,
                    Origin.JSON_PROPERTY_N_A_M_E})
@JsonTypeName("origin")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Origin {
  public static final String JSON_PROPERTY_O_R_G_I_D = "ORG_ID";
  private String ORG_ID;

  public static final String JSON_PROPERTY_U_S_E_R_I_D = "USER_ID";
  private String USER_ID;

  public static final String JSON_PROPERTY_N_A_M_E = "NAME";
  private String NAME;

  public Origin() {}

  public Origin ORG_ID(String ORG_ID) {

    this.ORG_ID = ORG_ID;
    return this;
  }

  /**
   * Optionnel, identifiant du service à l&#39;origine de l&#39;EMSI Se référer
   *au DSF pour la structure normée des organisations Le format est le suivant
   *{pays}.{domaine}.{code département}.{organisation}.{structure
   *interne}*.{unité fonctionnelle}*.
   * @return ORG_ID
   **/
  @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getORGID() {
    return ORG_ID;
  }

  @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setORGID(String ORG_ID) {
    this.ORG_ID = ORG_ID;
  }

  public Origin USER_ID(String USER_ID) {

    this.USER_ID = USER_ID;
    return this;
  }

  /**
   * Optionnel, identifiant de l&#39;opérateur du service à l&#39;origine de
   *l&#39;EMSI
   * @return USER_ID
   **/
  @JsonProperty(JSON_PROPERTY_U_S_E_R_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUSERID() {
    return USER_ID;
  }

  @JsonProperty(JSON_PROPERTY_U_S_E_R_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUSERID(String USER_ID) {
    this.USER_ID = USER_ID;
  }

  public Origin NAME(String NAME) {

    this.NAME = NAME;
    return this;
  }

  /**
   * Optionnel
   * @return NAME
   **/
  @JsonProperty(JSON_PROPERTY_N_A_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNAME() {
    return NAME;
  }

  @JsonProperty(JSON_PROPERTY_N_A_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Origin origin = (Origin)o;
    return Objects.equals(this.ORG_ID, origin.ORG_ID) &&
        Objects.equals(this.USER_ID, origin.USER_ID) &&
        Objects.equals(this.NAME, origin.NAME);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ORG_ID, USER_ID, NAME);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Origin {\n");
    sb.append("    ORG_ID: ").append(toIndentedString(ORG_ID)).append("\n");
    sb.append("    USER_ID: ").append(toIndentedString(USER_ID)).append("\n");
    sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
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
