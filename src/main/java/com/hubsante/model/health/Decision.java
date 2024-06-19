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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Decision
 */
@JsonPropertyOrder({Decision.JSON_PROPERTY_ID_PAT,
                    Decision.JSON_PROPERTY_CREATION,
                    Decision.JSON_PROPERTY_TYPE})
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
        Objects.equals(this.type, decision.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPat, creation, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Decision {\n");
    sb.append("    idPat: ").append(toIndentedString(idPat)).append("\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
