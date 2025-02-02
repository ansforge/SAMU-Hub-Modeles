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

package com.hubsante.model.emsi;

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
@JsonPropertyOrder({ExternalInfo.JSON_PROPERTY_F_R_E_E_T_E_X_T,
                    ExternalInfo.JSON_PROPERTY_U_R_I,
                    ExternalInfo.JSON_PROPERTY_T_Y_P_E})
@JsonTypeName("externalInfo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ExternalInfo {
  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public static final String JSON_PROPERTY_U_R_I = "URI";
  private String URI;

  /**
   * Optionnel
   */
  public enum TYPEEnum {
    MANUAL("MANUAL"),

    MAP("MAP"),

    OTHER("OTHER"),

    PHOTO("PHOTO"),

    WEBSIT("WEBSIT");

    private String value;

    TYPEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TYPEEnum fromValue(String value) {
      for (TYPEEnum b : TYPEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_T_Y_P_E = "TYPE";
  private TYPEEnum TYPE;

  public ExternalInfo() {}

  public ExternalInfo FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Optionnel
   * @return FREETEXT
   **/
  @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFREETEXT() {
    return FREETEXT;
  }

  @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFREETEXT(String FREETEXT) {
    this.FREETEXT = FREETEXT;
  }

  public ExternalInfo URI(String URI) {

    this.URI = URI;
    return this;
  }

  /**
   * Optionnel
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

  public ExternalInfo TYPE(TYPEEnum TYPE) {

    this.TYPE = TYPE;
    return this;
  }

  /**
   * Optionnel
   * @return TYPE
   **/
  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TYPEEnum getTYPE() {
    return TYPE;
  }

  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTYPE(TYPEEnum TYPE) {
    this.TYPE = TYPE;
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
    return Objects.equals(this.FREETEXT, externalInfo.FREETEXT) &&
        Objects.equals(this.URI, externalInfo.URI) &&
        Objects.equals(this.TYPE, externalInfo.TYPE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(FREETEXT, URI, TYPE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalInfo {\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
    sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
    sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
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
