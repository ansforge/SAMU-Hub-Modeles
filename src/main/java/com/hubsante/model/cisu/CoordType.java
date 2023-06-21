package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoordType {
  @JsonProperty("lat")
  @NotNull
  private Double lat;
  @JsonProperty("lon")
  @NotNull
  private Double lon;
  @JsonProperty("height")
  private Double height;

  public CoordType(){
  }

  public CoordType(
    Double lat, Double lon, Double height
  ) {
  	this.lat = lat;
  	this.lon = lon;
  	this.height = height;
  }

  public Double getLat() { return this.lat; }
  public void setLat(Double lat) { this.lat = lat; }

  public Double getLon() { return this.lon; }
  public void setLon(Double lon) { this.lon = lon; }

  public Double getHeight() { return this.height; }
  public void setHeight(Double height) { this.height = height; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CoordType self = (CoordType) o;
      return 
        Objects.equals(this.lat, self.lat) &&
        Objects.equals(this.lon, self.lon) &&
        Objects.equals(this.height, self.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)lat, (Object)lon, (Object)height);
  }

  @Override
  public String toString() {
    return "class CoordType {\n" +   
      "    lat: " + toIndentedString(lat) + "\n" +
      "    lon: " + toIndentedString(lon) + "\n" +
      "    height: " + toIndentedString(height) + "\n" +
    "}";
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