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
import com.hubsante.model.geolocation.GeoPositionsUpdate;
import com.hubsante.model.rcde.DistributionElement;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * GeoPositionsUpdateWrapper
 */
@JsonPropertyOrder(
    {DistributionElement.JSON_PROPERTY_MESSAGE_ID,
     DistributionElement.JSON_PROPERTY_SENDER,
     DistributionElement.JSON_PROPERTY_SENT_AT,
     DistributionElement.JSON_PROPERTY_KIND,
     DistributionElement.JSON_PROPERTY_STATUS,
     DistributionElement.JSON_PROPERTY_RECIPIENT,
     GeoPositionsUpdateWrapper.JSON_PROPERTY_GEO_POSITIONS_UPDATE})
@JsonTypeName("geoPositionsUpdateWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GeoPositionsUpdateWrapper extends DistributionElement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0";
  public static final String JSON_PROPERTY_GEO_POSITIONS_UPDATE =
      "geoPositionsUpdate";
  private GeoPositionsUpdate geoPositionsUpdate;

  public GeoPositionsUpdateWrapper() {}

  public GeoPositionsUpdateWrapper
  geoPositionsUpdate(GeoPositionsUpdate geoPositionsUpdate) {

    this.geoPositionsUpdate = geoPositionsUpdate;
    return this;
  }

  /**
   * Get geoPositionsUpdate
   * @return geoPositionsUpdate
   **/
  @JsonProperty(JSON_PROPERTY_GEO_POSITIONS_UPDATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public GeoPositionsUpdate getGeoPositionsUpdate() {
    return geoPositionsUpdate;
  }

  @JsonProperty(JSON_PROPERTY_GEO_POSITIONS_UPDATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGeoPositionsUpdate(GeoPositionsUpdate geoPositionsUpdate) {
    this.geoPositionsUpdate = geoPositionsUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoPositionsUpdateWrapper geoPositionsUpdateWrapper =
        (GeoPositionsUpdateWrapper)o;
    return Objects.equals(this.geoPositionsUpdate,
                          geoPositionsUpdateWrapper.geoPositionsUpdate) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(geoPositionsUpdate, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoPositionsUpdateWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    geoPositionsUpdate: ")
        .append(toIndentedString(geoPositionsUpdate))
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
