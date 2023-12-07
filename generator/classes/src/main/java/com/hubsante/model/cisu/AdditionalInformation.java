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
import com.hubsante.model.cisu.CustomMap;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * AdditionalInformation
 */
@JsonPropertyOrder({AdditionalInformation.JSON_PROPERTY_CUSTOM_MAP})
@JsonTypeName("additionalInformation")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-07T09:49:45.602118Z[Etc/UTC]")
public class AdditionalInformation {
  public static final String JSON_PROPERTY_CUSTOM_MAP = "customMap";
  private CustomMap customMap;

  public AdditionalInformation() {}

  public AdditionalInformation customMap(CustomMap customMap) {

    this.customMap = customMap;
    return this;
  }

  /**
   * Get customMap
   * @return customMap
   **/
  @JsonProperty(JSON_PROPERTY_CUSTOM_MAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CustomMap getCustomMap() {
    return customMap;
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM_MAP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomMap(CustomMap customMap) {
    this.customMap = customMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdditionalInformation additionalInformation = (AdditionalInformation)o;
    return Objects.equals(this.customMap, additionalInformation.customMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customMap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdditionalInformation {\n");
    sb.append("    customMap: ")
        .append(toIndentedString(customMap))
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
