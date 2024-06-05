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
 * ExternalLocationId
 */
@JsonPropertyOrder({ExternalLocationId.JSON_PROPERTY_SOURCE,
                    ExternalLocationId.JSON_PROPERTY_VALUE})
@JsonTypeName("externalLocationId")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ExternalLocationId {

  /**
   * Type de l&#39;identifiant fourni
   */
  public enum SourceEnum {
    FINESS_ADMINISTRATIF("FINESS administratif"),

    FINESS_G_OGRAPHIQUE("FINESS géographique"),

    SIREN("SIREN"),

    SIRET("SIRET"),

    APE_NAF("APE/NAF");

    private String value;

    SourceEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SourceEnum fromValue(String value) {
      for (SourceEnum b : SourceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_SOURCE = "source";
  private SourceEnum source;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public ExternalLocationId() {}

  public ExternalLocationId source(SourceEnum source) {

    this.source = source;
    return this;
  }

  /**
   * Type de l&#39;identifiant fourni
   * @return source
   **/
  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SourceEnum getSource() {
    return source;
  }

  @JsonProperty(JSON_PROPERTY_SOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSource(SourceEnum source) {
    this.source = source;
  }

  public ExternalLocationId value(String value) {

    this.value = value;
    return this;
  }

  /**
   * L&#39;identifiant en lui-même
   * @return value
   **/
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValue() {
    return value;
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExternalLocationId externalLocationId = (ExternalLocationId)o;
    return Objects.equals(this.source, externalLocationId.source) &&
        Objects.equals(this.value, externalLocationId.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternalLocationId {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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