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

package com.hubsante.model.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Sender
 */
@JsonPropertyOrder({Sender.JSON_PROPERTY_NAME, Sender.JSON_PROPERTY_U_R_I})
@JsonTypeName("sender")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T10:26:54.937045Z[Etc/UTC]")
public class Sender {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_U_R_I = "URI";
  private String URI;

  public Sender() {}

  public Sender name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public Sender URI(String URI) {

    this.URI = URI;
    return this;
  }

  /**
   * Get URI
   * @return URI
   **/
  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getURI() {
    return URI;
  }

  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setURI(String URI) {
    this.URI = URI;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sender sender = (Sender)o;
    return Objects.equals(this.name, sender.name) &&
        Objects.equals(this.URI, sender.URI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, URI);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sender {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
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
