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
import com.hubsante.model.health.Coord;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Point
 */
@JsonPropertyOrder({Point.JSON_PROPERTY_COORD, Point.JSON_PROPERTY_AML})
@JsonTypeName("point")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Point {
  public static final String JSON_PROPERTY_COORD = "coord";
  private Coord coord;

  public static final String JSON_PROPERTY_AML = "aml";
  private Boolean aml;

  public Point() {}

  public Point coord(Coord coord) {

    this.coord = coord;
    return this;
  }

  /**
   * Get coord
   * @return coord
   **/
  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Coord getCoord() {
    return coord;
  }

  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public Point aml(Boolean aml) {

    this.aml = aml;
    return this;
  }

  /**
   * Attribut qui permet de préciser si les coordonnées fournies proviennent du
   *dispositif AML (Advanced Mobile Location) -TRUE - ou non - FALSE.
   * @return aml
   **/
  @JsonProperty(JSON_PROPERTY_AML)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAml() {
    return aml;
  }

  @JsonProperty(JSON_PROPERTY_AML)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAml(Boolean aml) {
    this.aml = aml;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point)o;
    return Objects.equals(this.coord, point.coord) &&
        Objects.equals(this.aml, point.aml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coord, aml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Point {\n");
    sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
    sb.append("    aml: ").append(toIndentedString(aml)).append("\n");
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
