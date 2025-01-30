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

package com.hubsante.model.technical;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.technical.Technical;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * TechnicalWrapper
 */
@JsonPropertyOrder({DistributionElement.JSON_PROPERTY_MESSAGE_ID,
                    DistributionElement.JSON_PROPERTY_SENDER,
                    DistributionElement.JSON_PROPERTY_SENT_AT,
                    DistributionElement.JSON_PROPERTY_KIND,
                    DistributionElement.JSON_PROPERTY_STATUS,
                    DistributionElement.JSON_PROPERTY_RECIPIENT,
                    TechnicalWrapper.JSON_PROPERTY_TECHNICAL})
@JsonTypeName("technicalWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class TechnicalWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:eda:1.9";
  public static final String JSON_PROPERTY_TECHNICAL = "technical";
  private Technical technical;

  public TechnicalWrapper() {}

  public TechnicalWrapper technical(Technical technical) {

    this.technical = technical;
    return this;
  }

  /**
   * Get technical
   * @return technical
   **/
  @JsonProperty(JSON_PROPERTY_TECHNICAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Technical getTechnical() {
    return technical;
  }

  @JsonProperty(JSON_PROPERTY_TECHNICAL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTechnical(Technical technical) {
    this.technical = technical;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TechnicalWrapper technicalWrapper = (TechnicalWrapper)o;
    return Objects.equals(this.technical, technicalWrapper.technical) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(technical, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechnicalWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    technical: ")
        .append(toIndentedString(technical))
        .append("\n");
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
