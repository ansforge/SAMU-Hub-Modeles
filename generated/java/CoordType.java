package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class CoordType {
  @JsonProperty("lat")
  @NotNull
  private Double lat;
  @JsonProperty("lon")
  @NotNull
  private Double lon;
  @JsonProperty("height")
  private Double height;
  private Map<String, Object> additionalProperties;

  public CoordType(){
  }

  public CoordType(
    Double lat, Double lon, Double height, Map<String, Object> additionalProperties
  ) {
  	this.lat = lat;
  	this.lon = lon;
  	this.height = height;
  	this.additionalProperties = additionalProperties;
  }

  public Double getLat() { return this.lat; }
  public void setLat(Double lat) { this.lat = lat; }

  public Double getLon() { return this.lon; }
  public void setLon(Double lon) { this.lon = lon; }

  public Double getHeight() { return this.height; }
  public void setHeight(Double height) { this.height = height; }

  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

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
        Objects.equals(this.height, self.height) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)lat, (Object)lon, (Object)height, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class CoordType {\n" +   
      "    lat: " + toIndentedString(lat) + "\n" +
      "    lon: " + toIndentedString(lon) + "\n" +
      "    height: " + toIndentedString(height) + "\n" +
      "    additionalProperties: " + toIndentedString(additionalProperties) + "\n" +
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