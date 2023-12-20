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
 * Contact
 */
@JsonPropertyOrder(
    {Contact.JSON_PROPERTY_T_Y_P_E, Contact.JSON_PROPERTY_D_E_T_A_I_L})
@JsonTypeName("contact")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Contact {

  /**
   * Type de contact, voir énumération associée  1. PMRADD (si RFGI
   * disponible) 2. PHNADD pour téléphonie
   */
  public enum TYPEEnum {
    PSTADD("PSTADD"),

    EMLADD("EMLADD"),

    IPADD("IPADD"),

    FTPADD("FTPADD"),

    WWWADD("WWWADD"),

    PHNADD("PHNADD"),

    FAXADD("FAXADD"),

    PMRADD("PMRADD");

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

  public static final String JSON_PROPERTY_D_E_T_A_I_L = "DETAIL";
  private String DETAIL;

  public Contact() {}

  public Contact TYPE(TYPEEnum TYPE) {

    this.TYPE = TYPE;
    return this;
  }

  /**
   * Type de contact, voir énumération associée  1. PMRADD (si RFGI
   *disponible) 2. PHNADD pour téléphonie
   * @return TYPE
   **/
  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TYPEEnum getTYPE() {
    return TYPE;
  }

  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTYPE(TYPEEnum TYPE) {
    this.TYPE = TYPE;
  }

  public Contact DETAIL(String DETAIL) {

    this.DETAIL = DETAIL;
    return this;
  }

  /**
   * 1. RFGI du moyen NEXSIS (si RFGI disponible) 2. Numéro de téléphone
   * @return DETAIL
   **/
  @JsonProperty(JSON_PROPERTY_D_E_T_A_I_L)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDETAIL() {
    return DETAIL;
  }

  @JsonProperty(JSON_PROPERTY_D_E_T_A_I_L)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDETAIL(String DETAIL) {
    this.DETAIL = DETAIL;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact)o;
    return Objects.equals(this.TYPE, contact.TYPE) &&
        Objects.equals(this.DETAIL, contact.DETAIL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(TYPE, DETAIL);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
    sb.append("    DETAIL: ").append(toIndentedString(DETAIL)).append("\n");
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
