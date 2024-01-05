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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * InsCycle
 */
@JsonPropertyOrder(
    {InsCycle.JSON_PROPERTY_STATUS, InsCycle.JSON_PROPERTY_ATTRIBUTE})
@JsonTypeName("insCycle")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class InsCycle {
  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public static final String JSON_PROPERTY_ATTRIBUTE = "attribute";
  private String attribute;

  public InsCycle() {}

  public InsCycle status(String status) {

    this.status = status;
    return this;
  }

  /**
   * Le RNIV exige que les logiciels référentiels d’identités gèrent les 4
   *statuts fonctionnels suivants : - « identité provisoire », - « identité
   *récupérée », - « identité validée », - « identité qualifiée ». Ces statuts
   *fonctionnels sont exclusifs les uns des autres. Le référentiel INS [EXI 18]
   *précise en outre que le matricule INS et l’OID doivent être accompagnés
   *d’informations confirmant qu’ils ont été qualifiés.
   * @return status
   **/
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
  }

  public InsCycle attribute(String attribute) {

    this.attribute = attribute;
    return this;
  }

  /**
   * Le RNIV recommande que les logiciels référentiels d’identités gèrent a
   *minima les 3 attributs suivants : - identité homonyme, - identité douteuse,
   *- identité fictive.
   * @return attribute
   **/
  @JsonProperty(JSON_PROPERTY_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAttribute() {
    return attribute;
  }

  @JsonProperty(JSON_PROPERTY_ATTRIBUTE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsCycle insCycle = (InsCycle)o;
    return Objects.equals(this.status, insCycle.status) &&
        Objects.equals(this.attribute, insCycle.attribute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, attribute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsCycle {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    attribute: ")
        .append(toIndentedString(attribute))
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
