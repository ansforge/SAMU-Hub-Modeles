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
import com.hubsante.model.cisu.Point;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Geometry
 */
@JsonPropertyOrder({Geometry.JSON_PROPERTY_OBS_DATIME,
                    Geometry.JSON_PROPERTY_POINT,
                    Geometry.JSON_PROPERTY_SKETCH})
@JsonTypeName("geometry")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T13:13:30.743382Z[Etc/UTC]")
public class Geometry {
  public static final String JSON_PROPERTY_OBS_DATIME = "obsDatime";
  private OffsetDateTime obsDatime;

  public static final String JSON_PROPERTY_POINT = "point";
  private Point point;

  public static final String JSON_PROPERTY_SKETCH = "sketch";
  private String sketch;

  public Geometry() {}

  public Geometry obsDatime(OffsetDateTime obsDatime) {

    this.obsDatime = obsDatime;
    return this;
  }

  /**
   * Groupe date heure de renseignement des coordonnées du point clé de la
   *localisation. Permet de connaître la fraîcheur et donc pertinence des
   *informations pour intervenir.
   * @return obsDatime
   **/
  @JsonProperty(JSON_PROPERTY_OBS_DATIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getObsDatime() {
    return obsDatime;
  }

  @JsonProperty(JSON_PROPERTY_OBS_DATIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setObsDatime(OffsetDateTime obsDatime) {
    this.obsDatime = obsDatime;
  }

  public Geometry point(Point point) {

    this.point = point;
    return this;
  }

  /**
   * Get point
   * @return point
   **/
  @JsonProperty(JSON_PROPERTY_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Point getPoint() {
    return point;
  }

  @JsonProperty(JSON_PROPERTY_POINT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPoint(Point point) {
    this.point = point;
  }

  public Geometry sketch(String sketch) {

    this.sketch = sketch;
    return this;
  }

  /**
   * Objet gml (équivalent xml du geojson). Le langage GML permet de décrire une
   *forme dans un système de projection donné.  Dans le cas d&#39;une alerte
   *donnée sur une zone géographique non précise (par exemple une section
   *d&#39;autoroute ou une zone sur un chemin de randonnée), une indication sur
   *la zone de recherche peut être fournie. En XML, un objet gml est encapsulé
   *dans une balise &lt;sketch
   *xmlns:gml&#x3D;&#39;http://www.opengis.net/gml&#39;
   *version&#x3D;&#39;1.0&#39; &gt; &lt;/sketch&gt; En JSON, les balises sont
   *reprises depuis le modèle gml Voir http://www.opengis.net/gml pour le format
   *de l&#39;objet sketch
   * @return sketch
   **/
  @JsonProperty(JSON_PROPERTY_SKETCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSketch() {
    return sketch;
  }

  @JsonProperty(JSON_PROPERTY_SKETCH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSketch(String sketch) {
    this.sketch = sketch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Geometry geometry = (Geometry)o;
    return Objects.equals(this.obsDatime, geometry.obsDatime) &&
        Objects.equals(this.point, geometry.point) &&
        Objects.equals(this.sketch, geometry.sketch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(obsDatime, point, sketch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Geometry {\n");
    sb.append("    obsDatime: ")
        .append(toIndentedString(obsDatime))
        .append("\n");
    sb.append("    point: ").append(toIndentedString(point)).append("\n");
    sb.append("    sketch: ").append(toIndentedString(sketch)).append("\n");
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
