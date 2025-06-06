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

package com.hubsante.model.cisu;

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
                    Coord.JSON_PROPERTY_HEIGHT, Coord.JSON_PROPERTY_HEADING,
                    Coord.JSON_PROPERTY_SPEED, Coord.JSON_PROPERTY_PRECISION})
@JsonTypeName("coord")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Coord {
  public static final String JSON_PROPERTY_LAT = "lat";
  private BigDecimal lat;

  public static final String JSON_PROPERTY_LON = "lon";
  private BigDecimal lon;

  public static final String JSON_PROPERTY_HEIGHT = "height";
  private BigDecimal height;

  public static final String JSON_PROPERTY_HEADING = "heading";
  private BigDecimal heading;

  public static final String JSON_PROPERTY_SPEED = "speed";
  private BigDecimal speed;

  /**
   * Indique via une nomenclature le niveau de précision des coordonnées
   * fournies par le système emetteur. VILLE : Précision à l&#39;échelle de la
   * ville,  RUE : Précision à l&#39;échelle de la rue,  ADRESSE : Adresse
   * précise,  EXACTE : Point coordonnée GPS exact,  INCONNUE : Précision de la
   * localisation non évaluable par l&#39;émetteur
   */
  public enum PrecisionEnum {
    VILLE("VILLE"),

    RUE("RUE"),

    ADRESSE("ADRESSE"),

    EXACTE("EXACTE"),

    INCONNUE("INCONNUE");

    private String value;

    PrecisionEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PrecisionEnum fromValue(String value) {
      for (PrecisionEnum b : PrecisionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_PRECISION = "precision";
  private PrecisionEnum precision;

  public Coord() {}

  public Coord lat(BigDecimal lat) {

    this.lat = lat;
    return this;
  }

  /**
   * A valoriser avec la latitude du point clé de la localisation - dans le
   *système de coordonnées EPSG-4326 (indiquant l&#39;utilisation de WGS-84)
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
   * A valoriser avec la longitude du point clé de la localisation - dans le
   *système de coordonnées EPSG-4326 (indiquant l&#39;utilisation de WGS-84)
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
   * A valoriser avec l&#39;altitude du point clé de la localisation, en mètres.
   *Spécificité 15-18 :  ignoré côté NexSIS.
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

  public Coord heading(BigDecimal heading) {

    this.heading = heading;
    return this;
  }

  /**
   * A valoriser avec le cap, en degré
   * @return heading
   **/
  @JsonProperty(JSON_PROPERTY_HEADING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getHeading() {
    return heading;
  }

  @JsonProperty(JSON_PROPERTY_HEADING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHeading(BigDecimal heading) {
    this.heading = heading;
  }

  public Coord speed(BigDecimal speed) {

    this.speed = speed;
    return this;
  }

  /**
   * Vitesse en km/h, notamment fournie par eCall, tel, nouveau AML, …
   * @return speed
   **/
  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getSpeed() {
    return speed;
  }

  @JsonProperty(JSON_PROPERTY_SPEED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpeed(BigDecimal speed) {
    this.speed = speed;
  }

  public Coord precision(PrecisionEnum precision) {

    this.precision = precision;
    return this;
  }

  /**
   * Indique via une nomenclature le niveau de précision des coordonnées
   *fournies par le système emetteur. VILLE : Précision à l&#39;échelle de la
   *ville,  RUE : Précision à l&#39;échelle de la rue,  ADRESSE : Adresse
   *précise,  EXACTE : Point coordonnée GPS exact,  INCONNUE : Précision de la
   *localisation non évaluable par l&#39;émetteur
   * @return precision
   **/
  @JsonProperty(JSON_PROPERTY_PRECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PrecisionEnum getPrecision() {
    return precision;
  }

  @JsonProperty(JSON_PROPERTY_PRECISION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrecision(PrecisionEnum precision) {
    this.precision = precision;
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
        Objects.equals(this.height, coord.height) &&
        Objects.equals(this.heading, coord.heading) &&
        Objects.equals(this.speed, coord.speed) &&
        Objects.equals(this.precision, coord.precision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon, height, heading, speed, precision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Coord {\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    heading: ").append(toIndentedString(heading)).append("\n");
    sb.append("    speed: ").append(toIndentedString(speed)).append("\n");
    sb.append("    precision: ")
        .append(toIndentedString(precision))
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
