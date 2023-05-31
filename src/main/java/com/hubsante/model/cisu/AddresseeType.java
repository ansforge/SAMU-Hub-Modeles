package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
              
public class AddresseeType {
  @JsonProperty("name")
  @NotNull
  private String name;
  @JsonProperty("uri")
  @JacksonXmlProperty(localName = "URI")
  @NotNull
  private String uri;

  public AddresseeType(){
  }

  public AddresseeType(
    String name, String uri
  ) {
  	this.name = name;
  	this.uri = uri;
  }

  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }

  public String getUri() { return this.uri; }
  public void setUri(String uri) { this.uri = uri; }

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
        Objects.equals(this.uri, self.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)name, (Object)uri);
  }

  @Override
  public String toString() {
    return "class AddresseeType {\n" +   
      "    name: " + toIndentedString(name) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
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