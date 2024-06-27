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
 * ExternalInfo
 */
@JsonPropertyOrder({ExternalInfo.JSON_PROPERTY_FREETEXT,
                    ExternalInfo.JSON_PROPERTY_TYPE,
                    ExternalInfo.JSON_PROPERTY_URI})
@JsonTypeName("externalInfo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ExternalInfo {

  /**
   * A valoriser avec le système fournissant le localisant
   */
  public enum FreetextEnum {
    BAN("BAN"),

    IGN("IGN"),

    NEXSIS("NEXSIS");

    private String value;

    FreetextEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static FreetextEnum fromValue(String value) {
      for (FreetextEnum b : FreetextEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private FreetextEnum freetext;

  /**
   * A valoriser avec la définition du type d&#39;objet dans le système  Exemple
   * : SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de
   * route, …)
   */
  public enum TypeEnum {
    MANUEL("MANUEL"),

    CARTE("CARTE"),

    AUTRE("AUTRE"),

    PHOTO("PHOTO"),

    SITE_INTERNET("SITE INTERNET");

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

  public static final String JSON_PROPERTY_URI = "uri";
  private String uri;

  public ExternalInfo() {}

  public ExternalInfo freetext(FreetextEnum freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * A valoriser avec le système fournissant le localisant
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public FreetextEnum getFreetext() {
    return freetext;
  }

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFreetext(FreetextEnum freetext) {
    this.freetext = freetext;
  }

  public ExternalInfo type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * A valoriser avec la définition du type d&#39;objet dans le système  Exemple
   *: SIG NexSIS / OSM ont plusieurs types de données (EGA, POI, tronçon de
   *route, …)
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

  public ExternalInfo uri(String uri) {

    this.uri = uri;
    return this;
  }

  /**
   * Identifiant dans le système concerné
   * @return uri
   **/
  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUri() {
    return uri;
  }

  @JsonProperty(JSON_PROPERTY_URI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUri(String uri) {
    this.uri = uri;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalInfo externalInfo = (ExternalInfo)o;
    return Objects.equals(this.freetext, externalInfo.freetext) &&
        Objects.equals(this.type, externalInfo.type) &&
        Objects.equals(this.uri, externalInfo.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(freetext, type, uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalInfo {\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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
