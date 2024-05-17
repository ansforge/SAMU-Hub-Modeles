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

package com.hubsante.model.smur;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.smur.WayName;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * DetailedAddress
 */
@JsonPropertyOrder({DetailedAddress.JSON_PROPERTY_COMPLETE,
                    DetailedAddress.JSON_PROPERTY_NUMBER,
                    DetailedAddress.JSON_PROPERTY_WAY_NAME})
@JsonTypeName("detailedAddress")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class DetailedAddress {
  public static final String JSON_PROPERTY_COMPLETE = "complete";
  private String complete;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private String number;

  public static final String JSON_PROPERTY_WAY_NAME = "wayName";
  private WayName wayName;

  public DetailedAddress() {}

  public DetailedAddress complete(String complete) {

    this.complete = complete;
    return this;
  }

  /**
   * Numéro, type et nom de la voie.  Utilisé pour tout type de voie : autoroute
   *(PK, nom et sens), voie ferrée, voie navigable… Obligatoire et seule valeur
   *des détails de l&#39;adresse fournie par NexSIS.
   * @return complete
   **/
  @JsonProperty(JSON_PROPERTY_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getComplete() {
    return complete;
  }

  @JsonProperty(JSON_PROPERTY_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setComplete(String complete) {
    this.complete = complete;
  }

  public DetailedAddress number(String number) {

    this.number = number;
    return this;
  }

  /**
   * Numéro dans l&#39;adresse (inclut point kilométrique sur l&#39;autoroute,
   *voie ferrée ou voie navigable). Inclut l&#39;indice de répétition associé au
   *numéro (par exemple bis, a…).
   * @return number
   **/
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNumber() {
    return number;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(String number) {
    this.number = number;
  }

  public DetailedAddress wayName(WayName wayName) {

    this.wayName = wayName;
    return this;
  }

  /**
   * Get wayName
   * @return wayName
   **/
  @JsonProperty(JSON_PROPERTY_WAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WayName getWayName() {
    return wayName;
  }

  @JsonProperty(JSON_PROPERTY_WAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWayName(WayName wayName) {
    this.wayName = wayName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedAddress detailedAddress = (DetailedAddress)o;
    return Objects.equals(this.complete, detailedAddress.complete) &&
        Objects.equals(this.number, detailedAddress.number) &&
        Objects.equals(this.wayName, detailedAddress.wayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complete, number, wayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedAddress {\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    wayName: ").append(toIndentedString(wayName)).append("\n");
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
