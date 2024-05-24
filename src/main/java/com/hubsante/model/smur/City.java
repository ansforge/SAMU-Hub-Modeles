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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * City
 */
@JsonPropertyOrder({City.JSON_PROPERTY_NAME, City.JSON_PROPERTY_INSEE_CODE,
                    City.JSON_PROPERTY_DETAIL})
@JsonTypeName("city")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class City {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_INSEE_CODE = "inseeCode";
  private String inseeCode;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public City() {}

  public City name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Nom officiel de la commune actuelle
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

  public City inseeCode(String inseeCode) {

    this.inseeCode = inseeCode;
    return this;
  }

  /**
   * Code INSEE de la commune actuelle sur la base du Code Officiel géographique
   *en vigueur. Obligatoire si le nom de la commune est renseigné.
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

  public City detail(String detail) {

    this.detail = detail;
    return this;
  }

  /**
   * Informations complémentaires permettant de préciser le quartier, lieu-dit,
   *ancienne commune, … ou autre information aidant à préciser l&#39;adresse et
   *notamment gérer les cas de communes fusionnées pour le système émetteur NB :
   *dans tous les cas, la localisation GPS de la commune doit être fournie afin
   *d&#39;éviter une trop forte ambiguïté.
   * @return detail
   **/
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City)o;
    return Objects.equals(this.name, city.name) &&
        Objects.equals(this.inseeCode, city.inseeCode) &&
        Objects.equals(this.detail, city.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, inseeCode, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    inseeCode: ")
        .append(toIndentedString(inseeCode))
        .append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
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
