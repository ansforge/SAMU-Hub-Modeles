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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.common.DistributionElement;
import com.hubsante.model.health.CreateCaseHealth;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * CreateCaseHealthWrapper
 */
@JsonPropertyOrder({CreateCaseHealthWrapper.JSON_PROPERTY_CREATE_CASE_HEALTH})
@JsonTypeName("createCaseHealthWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCaseHealthWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0";
  public static final String JSON_PROPERTY_CREATE_CASE_HEALTH =
      "createCaseHealth";
  private CreateCaseHealth createCaseHealth;

  public CreateCaseHealthWrapper() {}

  public CreateCaseHealthWrapper
  createCaseHealth(CreateCaseHealth createCaseHealth) {

    this.createCaseHealth = createCaseHealth;
    return this;
  }

  /**
   * Get createCaseHealth
   * @return createCaseHealth
   **/
  @JsonProperty(JSON_PROPERTY_CREATE_CASE_HEALTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CreateCaseHealth getCreateCaseHealth() {
    return createCaseHealth;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_CASE_HEALTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateCaseHealth(CreateCaseHealth createCaseHealth) {
    this.createCaseHealth = createCaseHealth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCaseHealthWrapper createCaseHealthWrapper =
        (CreateCaseHealthWrapper)o;
    return Objects.equals(this.createCaseHealth,
                          createCaseHealthWrapper.createCaseHealth) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createCaseHealth, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseHealthWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    createCaseHealth: ")
        .append(toIndentedString(createCaseHealth))
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
