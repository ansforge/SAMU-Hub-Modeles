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

package com.hubsante.model.rcde;

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
 * Recipient
 */
@JsonPropertyOrder(
    {Recipient.JSON_PROPERTY_NAME, Recipient.JSON_PROPERTY_U_R_I})
@JsonTypeName("recipient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Recipient {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_U_R_I = "URI";
  private String URI;

  public Recipient() {}

  public Recipient name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Identifiant technique du système emetteur Format :  &#x3D;&gt; Pour les
   *SAMU : {clé de routage}-{nom solution LRM} où clé de routage désigne le nom
   *de la clé de routage utilisée par le LRM pour les échanges et {nom solution
   *LRM} est le nom donné par l&#39;éditeur à sa solution (libre) &#x3D;&gt;
   *Pour NeXSIS : à définir {sga|sgo}-nexsis
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  public Recipient URI(String URI) {

    this.URI = URI;
    return this;
  }

  /**
   * uri du système. Permet d&#39;identifier le vecteur utilisé par les échanges
   *Format : &#x3D;&gt; Pour les LRM : sge:{recipient:name} &#x3D;&gt; Pour
   *NexSIS : sge:{recipient:name}
   * @return URI
   **/
  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getURI() {
    return URI;
  }

  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setURI(String URI) {
    this.URI = URI;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient)o;
    return Objects.equals(this.name, recipient.name) &&
        Objects.equals(this.URI, recipient.URI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, URI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipient {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
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
