/*
 * 
 * 
 *
 * 
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hubsante.model.cisu;

import java.util.Objects;
import java.util.Arrays;
    import com.fasterxml.jackson.annotation.JsonInclude;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import com.fasterxml.jackson.annotation.JsonCreator;
    import com.fasterxml.jackson.annotation.JsonTypeName;
    import com.fasterxml.jackson.annotation.JsonValue;
    import com.hubsante.model.cisu.Point;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
    import com.fasterxml.jackson.annotation.JsonPropertyOrder;
    import com.fasterxml.jackson.annotation.JsonTypeName;

        /**
* Geometry
*/
    @JsonPropertyOrder({
        Geometry.JSON_PROPERTY_POINT,
        Geometry.JSON_PROPERTY_SKETCH
    })
            @JsonTypeName("geometry")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Geometry {
        public static final String JSON_PROPERTY_POINT = "point";
            private Point point;

        public static final String JSON_PROPERTY_SKETCH = "sketch";
            private String sketch;

public Geometry() {
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
        * Get sketch
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
        Geometry geometry = (Geometry) o;
        return Objects.equals(this.point, geometry.point) &&
        Objects.equals(this.sketch, geometry.sketch);
}

    @Override
    public int hashCode() {
        return Objects.hash(point
            , sketch);
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Geometry {\n");
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
