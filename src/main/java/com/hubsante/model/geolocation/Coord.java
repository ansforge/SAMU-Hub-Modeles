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
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Coord
 */
@JsonPropertyOrder({Coord.JSON_PROPERTY_LAT, Coord.JSON_PROPERTY_LON,
                    Coord.JSON_PROPERTY_HEIGHT})
@JsonTypeName("coord")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Coord {
  public static final String JSON_PROPERTY_LAT = "lat";
  private BigDecimal lat;

  public static final String JSON_PROPERTY_LON = "lon";
  private BigDecimal lon;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private BigDecimal height;

  public Coord() {}

  public Coord lat(BigDecimal lat) {

    this.lat = lat;
    return this;
  }

  /**
   * Dernière coordonnée x connue de la ressource, entre −90 and +90
   * @return lat
   **/
  @JsonProperty(JSON_PROPERTY_LAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getLat() {
    return lat;
  }

  @JsonProperty(JSON_PROPERTY_LAT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  public Coord lon(BigDecimal lon) {

    this.lon = lon;
    return this;
  }

  /**
   * Dernière coordonnée y connue de la ressource, entre −180 and +180
   * @return lon
   **/
  @JsonProperty(JSON_PROPERTY_LON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getLon() {
    return lon;
  }

  @JsonProperty(JSON_PROPERTY_LON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLon(BigDecimal lon) {
    this.lon = lon;
  }

  public Coord height(BigDecimal height) {

    this.height = height;
    return this;
  }

  /**
   * Dernière coordonnée z connue de la ressource, en mètres sans bornes
   * @return height
   **/
  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getHeight() {
    return height;
  }

  @JsonProperty(JSON_PROPERTY_HEIGHT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Coord coord = (Coord)o;
    return Objects.equals(this.lat, coord.lat) &&
        Objects.equals(this.lon, coord.lon) &&
        Objects.equals(this.height, coord.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon, height);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coord {\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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
