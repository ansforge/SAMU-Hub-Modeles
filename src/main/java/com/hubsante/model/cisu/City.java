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

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * City
 */
@JsonPropertyOrder({City.JSON_PROPERTY_NAME, City.JSON_PROPERTY_INSEE_CODE,
                    City.JSON_PROPERTY_DETAIL})
@JsonTypeName("city")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class City {
  public static final String JSON_PROPERTY_NAME = "name";
  private JsonNullable<Object> name = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_INSEE_CODE = "inseeCode";
  private JsonNullable<Object> inseeCode = JsonNullable.<Object>of(null);

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private JsonNullable<Object> detail = JsonNullable.<Object>of(null);

  public City() {}

  public City name(Object name) {
    this.name = JsonNullable.<Object>of(name);

    return this;
  }

  /**
   * Nom officiel de la commune actuelle
   * @return name
   **/
  @JsonIgnore

  public Object getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getName_JsonNullable() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)

  public void setName(Object name) {
    this.name = JsonNullable.<Object>of(name);
  }

  public City inseeCode(Object inseeCode) {
    this.inseeCode = JsonNullable.<Object>of(inseeCode);

    return this;
  }

  /**
   * Code INSEE de la commune actuelle sur la base du Code Officiel géographique
   *en vigueur. Obligatoire si le nom de la commune est renseigné.
   * @return inseeCode
   **/
  @JsonIgnore

  public Object getInseeCode() {
    return inseeCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INSEE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getInseeCode_JsonNullable() {
    return inseeCode;
  }

  @JsonProperty(JSON_PROPERTY_INSEE_CODE)

  public void setInseeCode(Object inseeCode) {
    this.inseeCode = JsonNullable.<Object>of(inseeCode);
  }

  public City detail(Object detail) {
    this.detail = JsonNullable.<Object>of(detail);

    return this;
  }

  /**
   * Informations complémentaires permettant de préciser le quartier, lieu-dit,
   *ancienne commune, … ou autre information aidant à préciser l&#39;adresse et
   *notamment gérer les cas de communes fusionnées pour le système émetteur NB :
   *dans tous les cas, la localisation GPS de la commune doit être fournie afin
   *d&#39;éviter une trop forte ambiguïté
   * @return detail
   **/
  @JsonIgnore

  public Object getDetail() {
    return detail.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<Object> getDetail_JsonNullable() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)

  public void setDetail(Object detail) {
    this.detail = JsonNullable.<Object>of(detail);
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
    return equalsNullable(this.name, city.name) &&
        equalsNullable(this.inseeCode, city.inseeCode) &&
        equalsNullable(this.detail, city.detail);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a,
                                            JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() &&
                      b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(hashCodeNullable(name), hashCodeNullable(inseeCode),
                        hashCodeNullable(detail));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
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
