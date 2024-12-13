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

package com.hubsante.model.geolocation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GeoResourcesRequest
 */
@JsonPropertyOrder({GeoResourcesRequest.JSON_PROPERTY_RESOURCE_ID})
@JsonTypeName("geoResourcesRequest")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GeoResourcesRequest {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:georesourcesrequest";
  public static final String JSON_PROPERTY_RESOURCE_ID = "resourceId";
  private List<String> resourceId = new ArrayList<>();

  public GeoResourcesRequest() {}

  public GeoResourcesRequest resourceId(List<String> resourceId) {

    this.resourceId = resourceId;
    return this;
  }

  public GeoResourcesRequest addResourceIdItem(String resourceIdItem) {
    if (this.resourceId == null) {
      this.resourceId = new ArrayList<>();
    }
    this.resourceId.add(resourceIdItem);
    return this;
  }

  /**
   * Get resourceId
   * @return resourceId
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getResourceId() {
    return resourceId;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceId(List<String> resourceId) {
    if (resourceId == null) {
      return;
    }
    if (this.resourceId == null) {
      this.resourceId = new ArrayList<>();
    }
    this.resourceId.addAll(resourceId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoResourcesRequest geoResourcesRequest = (GeoResourcesRequest)o;
    return Objects.equals(this.resourceId, geoResourcesRequest.resourceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resourceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoResourcesRequest {\n");
    sb.append("    resourceId: ")
        .append(toIndentedString(resourceId))
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
