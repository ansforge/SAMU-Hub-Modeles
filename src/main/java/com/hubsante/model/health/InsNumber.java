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
 * InsNumber
 */
@JsonPropertyOrder({InsNumber.JSON_PROPERTY_VALUE, InsNumber.JSON_PROPERTY_OID})
@JsonTypeName("insNumber")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class InsNumber {
  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_OID = "oid";
  private String oid;

  public InsNumber() {}

  public InsNumber value(String value) {

    this.value = value;
    return this;
  }

  /**
   * n° NIR OU n° NIA de l&#39;individu. Le matricule INS (et son OID) ne doit
   *jamais être propagé (&#x3D; échangé) si l&#39;identité est à un statut autre
   *que qualifiée. Il correspond au numéro personnel de sécurité sociale. Il
   *peut être différent du numéro de sécurité sociale utilisé pour le
   *remboursement des soins par l’assurance maladie, dans le cas par exemple où
   *l’usager n’est pas l’assuré social (ex.: l’enfant qui est rattaché à l’un de
   *ses parents). Le matricule INS est composé des 13 caractères et de la clé de
   *contrôle.
   * @return value
   **/
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getValue() {
    return value;
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
  }

  public InsNumber oid(String oid) {

    this.oid = oid;
    return this;
  }

  /**
   * Identifiant de la structure qui a affecté l’INS sous la forme d&#39;un OID.
   *Les OID (Object Identifier) sont des identifiants universels, représentés
   *sous la forme d&#39;une suite d&#39;entiers. Ils sont organisés sous forme
   *hiérarchique avec des nœuds. L&#39;OID est toujours associé à un matricule
   *INS, il n&#39;est donc pas propagé si le statut de l&#39;identité n&#39;est
   *pas \&quot;qualifiée\&quot;
   * @return oid
   **/
  @JsonProperty(JSON_PROPERTY_OID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOid() {
    return oid;
  }

  @JsonProperty(JSON_PROPERTY_OID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOid(String oid) {
    this.oid = oid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsNumber insNumber = (InsNumber)o;
    return Objects.equals(this.value, insNumber.value) &&
        Objects.equals(this.oid, insNumber.oid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, oid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsNumber {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
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
