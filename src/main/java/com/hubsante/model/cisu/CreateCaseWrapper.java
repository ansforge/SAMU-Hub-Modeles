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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.common.DistributionElement;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * CreateCaseWrapper
 */
@JsonPropertyOrder({CreateCaseWrapper.JSON_PROPERTY_CREATE_CASE})
@JsonTypeName("createCaseWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-07T09:49:49.365808Z[Etc/UTC]")
public class CreateCaseWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0";
  public static final String JSON_PROPERTY_CREATE_CASE = "createCase";
  private CreateCase createCase;

  public CreateCaseWrapper() {}

  public CreateCaseWrapper createCase(CreateCase createCase) {

    this.createCase = createCase;
    return this;
  }

  /**
   * Get createCase
   * @return createCase
   **/
  @JsonProperty(JSON_PROPERTY_CREATE_CASE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CreateCase getCreateCase() {
    return createCase;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_CASE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreateCase(CreateCase createCase) {
    this.createCase = createCase;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCaseWrapper createCaseWrapper = (CreateCaseWrapper)o;
    return Objects.equals(this.createCase, createCaseWrapper.createCase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createCase);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseWrapper {\n");
    sb.append("    createCase: ")
        .append(toIndentedString(createCase))
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
