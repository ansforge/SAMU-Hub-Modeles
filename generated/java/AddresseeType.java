package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class AddresseeType {
  @JsonProperty("name")
  @NotNull
  private String name;
  @JsonProperty("uri")
  @NotNull
  private String uri;
  private Map<String, Object> additionalProperties;

  public AddresseeType(){
  }

  public AddresseeType(
    String name, String uri, Map<String, Object> additionalProperties
  ) {
  	this.name = name;
  	this.uri = uri;
  	this.additionalProperties = additionalProperties;
  }

  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }

  public String getUri() { return this.uri; }
  public void setUri(String uri) { this.uri = uri; }

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
    AddresseeType self = (AddresseeType) o;
      return 
        Objects.equals(this.name, self.name) &&
        Objects.equals(this.uri, self.uri) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)name, (Object)uri, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class AddresseeType {\n" +   
      "    name: " + toIndentedString(name) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
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