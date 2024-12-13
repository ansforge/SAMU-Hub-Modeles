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
import com.hubsante.model.health.CreateCaseHealthUpdate;
import com.hubsante.model.rcde.DistributionElement;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * CreateCaseHealthUpdateWrapper
 */
@JsonPropertyOrder(
    {DistributionElement.JSON_PROPERTY_MESSAGE_ID,
     DistributionElement.JSON_PROPERTY_SENDER,
     DistributionElement.JSON_PROPERTY_SENT_AT,
     DistributionElement.JSON_PROPERTY_KIND,
     DistributionElement.JSON_PROPERTY_STATUS,
     DistributionElement.JSON_PROPERTY_RECIPIENT,
     CreateCaseHealthUpdateWrapper.JSON_PROPERTY_CREATE_CASE_HEALTH_UPDATE})
@JsonTypeName("createCaseHealthUpdateWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CreateCaseHealthUpdateWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:3.0:createCaseHealthUpdate";
  public static final String JSON_PROPERTY_CREATE_CASE_HEALTH_UPDATE =
      "createCaseHealthUpdate";
  private CreateCaseHealthUpdate createCaseHealthUpdate;

  public CreateCaseHealthUpdateWrapper() {}

  public CreateCaseHealthUpdateWrapper
  createCaseHealthUpdate(CreateCaseHealthUpdate createCaseHealthUpdate) {

    this.createCaseHealthUpdate = createCaseHealthUpdate;
    return this;
  }

  /**
   * Get createCaseHealthUpdate
   * @return createCaseHealthUpdate
   **/
  @JsonProperty(JSON_PROPERTY_CREATE_CASE_HEALTH_UPDATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CreateCaseHealthUpdate getCreateCaseHealthUpdate() {
    return createCaseHealthUpdate;
  }

  @JsonProperty(JSON_PROPERTY_CREATE_CASE_HEALTH_UPDATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void
  setCreateCaseHealthUpdate(CreateCaseHealthUpdate createCaseHealthUpdate) {
    this.createCaseHealthUpdate = createCaseHealthUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCaseHealthUpdateWrapper createCaseHealthUpdateWrapper =
        (CreateCaseHealthUpdateWrapper)o;
    return Objects.equals(
               this.createCaseHealthUpdate,
               createCaseHealthUpdateWrapper.createCaseHealthUpdate) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createCaseHealthUpdate, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCaseHealthUpdateWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    createCaseHealthUpdate: ")
        .append(toIndentedString(createCaseHealthUpdate))
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
