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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * DetailedAddress
 */
@JsonPropertyOrder({DetailedAddress.JSON_PROPERTY_INSEE_CODE,
                    DetailedAddress.JSON_PROPERTY_CITY})
@JsonTypeName("detailedAddress")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class DetailedAddress {
  public static final String JSON_PROPERTY_INSEE_CODE = "inseeCode";
  private String inseeCode;

  public static final String JSON_PROPERTY_CITY = "city";
  private String city;

  public DetailedAddress() {}

  public DetailedAddress inseeCode(String inseeCode) {

    this.inseeCode = inseeCode;
    return this;
  }

  /**
   * Code INSEE de la commune actuelle sur la base du Code Officiel géographique
   *en vigueur. Obligatoire si le nom de la commune est renseigné. Le Code INSEE
   *peut également précisé le pays d&#39;intervention, si étranger.
   * @return inseeCode
   **/
  @JsonProperty(JSON_PROPERTY_INSEE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getInseeCode() {
    return inseeCode;
  }

  @JsonProperty(JSON_PROPERTY_INSEE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInseeCode(String inseeCode) {
    this.inseeCode = inseeCode;
  }

  public DetailedAddress city(String city) {

    this.city = city;
    return this;
  }

  /**
   * Nom officiel de la commune actuelle
   * @return city
   **/
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCity() {
    return city;
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(String city) {
    this.city = city;
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
    return Objects.equals(this.inseeCode, detailedAddress.inseeCode) &&
        Objects.equals(this.city, detailedAddress.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inseeCode, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedAddress {\n");
    sb.append("    inseeCode: ")
        .append(toIndentedString(inseeCode))
        .append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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
