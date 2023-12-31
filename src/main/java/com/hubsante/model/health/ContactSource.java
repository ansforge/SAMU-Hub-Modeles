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
 * ContactSource
 */
@JsonPropertyOrder({ContactSource.JSON_PROPERTY_CHANNEL,
                    ContactSource.JSON_PROPERTY_TYPE,
                    ContactSource.JSON_PROPERTY_DETAIL})
@JsonTypeName("contactSource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ContactSource {
  public static final String JSON_PROPERTY_CHANNEL = "channel";
  private String channel;

  /**
   * Type de l&#39;URI utilisée par la source, cf. nomenclature EMSI
   */
  public enum TypeEnum {
    PSTADD("PSTADD"),

    EMLADD("EMLADD"),

    IPADD("IPADD"),

    FTPADD("FTPADD"),

    WWWADD("WWWADD"),

    PHNADD("PHNADD"),

    FAXADD("FAXADD"),

    PMRADD("PMRADD");

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

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public ContactSource() {}

  public ContactSource channel(String channel) {

    this.channel = channel;
    return this;
  }

  /**
   * Permet d&#39;indiquer l&#39;origine du canal établit : Personne,
   *application, DAU, BAU, défibrillateur, ecall
   * @return channel
   **/
  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getChannel() {
    return channel;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setChannel(String channel) {
    this.channel = channel;
  }

  public ContactSource type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Type de l&#39;URI utilisée par la source, cf. nomenclature EMSI
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

  public ContactSource detail(String detail) {

    this.detail = detail;
    return this;
  }

  /**
   * Valeur de l&#39;URI utilisée par la source
   * @return detail
   **/
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
    ContactSource contactSource = (ContactSource)o;
    return Objects.equals(this.channel, contactSource.channel) &&
        Objects.equals(this.type, contactSource.type) &&
        Objects.equals(this.detail, contactSource.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, type, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactSource {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
