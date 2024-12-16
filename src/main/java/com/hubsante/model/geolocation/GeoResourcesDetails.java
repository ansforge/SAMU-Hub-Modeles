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
import com.hubsante.model.geolocation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GeoResourcesDetails
 */
@JsonPropertyOrder({GeoResourcesDetails.JSON_PROPERTY_RESOURCE})
@JsonTypeName("geoResourcesDetails")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GeoResourcesDetails {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:georesourcesdetails";
  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private List<Resource> resource;

  public GeoResourcesDetails() {}

  public GeoResourcesDetails resource(List<Resource> resource) {

    this.resource = resource;
    return this;
  }

  public GeoResourcesDetails addResourceItem(Resource resourceItem) {
    if (this.resource == null) {
      this.resource = new ArrayList<>();
    }
    this.resource.add(resourceItem);
    return this;
  }

  /**
   * Get resource
   * @return resource
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Resource> getResource() {
    return resource;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResource(List<Resource> resource) {
    if (resource == null) {
      return;
    }
    if (this.resource == null) {
      this.resource = new ArrayList<>();
    }
    this.resource.addAll(resource);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoResourcesDetails geoResourcesDetails = (GeoResourcesDetails)o;
    return Objects.equals(this.resource, geoResourcesDetails.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoResourcesDetails {\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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
