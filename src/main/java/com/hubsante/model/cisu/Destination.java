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

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.Location;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Destination
 */
@JsonPropertyOrder(
    {Destination.JSON_PROPERTY_TYPE, Destination.JSON_PROPERTY_LOCATION})
@JsonTypeName("destination")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Destination {

  /**
   * Indique le type de destination de la ressource : service d’urgences d’un
   * Etablissement de santé, autres services d’un établissement de santé,
   * cabinet d’un professionnel de santé, domicile personnel, EPHAD ou long
   * séjour, autre
   */
  public enum TypeEnum {
    SERVICE_D_URGENCES_D_UN_ETABLISSEMENT_DE_SANTE(
        "SERVICE D URGENCES D UN ETABLISSEMENT DE SANTE"),

    AUTRES_SERVICES_D_UN_ETABLISSEMENT_DE_SANTE(
        "AUTRES SERVICES D UN ETABLISSEMENT DE SANTE"),

    CABINET_D_UN_PROFESSIONNEL_DE_SANTE("CABINET D UN PROFESSIONNEL DE SANTE"),

    DOMICILE("DOMICILE"),

    EPHAD_OU_LONG_SEJOUR("EPHAD OU LONG SEJOUR"),

    AUTRE("AUTRE");

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

  public static final String JSON_PROPERTY_LOCATION = "location";
  private Location location;

  public Destination() {}

  public Destination type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Indique le type de destination de la ressource : service d’urgences d’un
   *Etablissement de santé, autres services d’un établissement de santé, cabinet
   *d’un professionnel de santé, domicile personnel, EPHAD ou long séjour, autre
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Destination location(Location location) {

    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Location getLocation() {
    return location;
  }

  @JsonProperty(JSON_PROPERTY_LOCATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Destination destination = (Destination)o;
    return Objects.equals(this.type, destination.type) &&
        Objects.equals(this.location, destination.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Destination {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
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
