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
 * OpenAPI
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.resources.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.resources.info.ResourcesInfo;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * ResourcesInfoWrapper
 */
@JsonPropertyOrder({DistributionElement.JSON_PROPERTY_MESSAGE_ID,
                    DistributionElement.JSON_PROPERTY_SENDER,
                    DistributionElement.JSON_PROPERTY_SENT_AT,
                    DistributionElement.JSON_PROPERTY_KIND,
                    DistributionElement.JSON_PROPERTY_STATUS,
                    DistributionElement.JSON_PROPERTY_RECIPIENT,
                    ResourcesInfoWrapper.JSON_PROPERTY_RESOURCES_INFO})
@JsonTypeName("resourcesInfoWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourcesInfoWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:eda:1.9";
  public static final String JSON_PROPERTY_RESOURCES_INFO = "resourcesInfo";
  private ResourcesInfo resourcesInfo;

  public ResourcesInfoWrapper() {}

  public ResourcesInfoWrapper resourcesInfo(ResourcesInfo resourcesInfo) {

    this.resourcesInfo = resourcesInfo;
    return this;
  }

  /**
   * Get resourcesInfo
   * @return resourcesInfo
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCES_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourcesInfo getResourcesInfo() {
    return resourcesInfo;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCES_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourcesInfo(ResourcesInfo resourcesInfo) {
    this.resourcesInfo = resourcesInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcesInfoWrapper resourcesInfoWrapper = (ResourcesInfoWrapper)o;
    return Objects.equals(this.resourcesInfo,
                          resourcesInfoWrapper.resourcesInfo) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourcesInfo, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesInfoWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    resourcesInfo: ")
        .append(toIndentedString(resourcesInfo))
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
