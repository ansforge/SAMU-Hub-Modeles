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
 * Reference
 */
@JsonPropertyOrder({Reference.JSON_PROPERTY_DISTRIBUTION_I_D})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-09T16:25:16.280034Z[Etc/UTC]")
public class Reference {
  public static final String JSON_PROPERTY_DISTRIBUTION_I_D = "distributionID";
  private String distributionID;

  public Reference() {}

  public Reference distributionID(String distributionID) {

    this.distributionID = distributionID;
    return this;
  }

  /**
   * Get distributionID
   * @return distributionID
   **/
  @JsonProperty(JSON_PROPERTY_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDistributionID() {
    return distributionID;
  }

  @JsonProperty(JSON_PROPERTY_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistributionID(String distributionID) {
    this.distributionID = distributionID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reference reference = (Reference)o;
    return Objects.equals(this.distributionID, reference.distributionID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distributionID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reference {\n");
    sb.append("    distributionID: ")
        .append(toIndentedString(distributionID))
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
