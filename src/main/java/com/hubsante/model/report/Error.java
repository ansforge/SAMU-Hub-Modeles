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

package com.hubsante.model.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.report.ErrorCode;
import java.util.Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Error
 */
@JsonPropertyOrder({Error.JSON_PROPERTY_ERROR_CODE,
                    Error.JSON_PROPERTY_ERROR_CAUSE,
                    Error.JSON_PROPERTY_SOURCE_MESSAGE,
                    Error.JSON_PROPERTY_REFERENCED_DISTRIBUTION_I_D})
@JsonTypeName("error")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Error {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:eda:1.9:error";
  public static final String JSON_PROPERTY_ERROR_CODE = "errorCode";
  private ErrorCode errorCode;

  public static final String JSON_PROPERTY_ERROR_CAUSE = "errorCause";
  private String errorCause;

  public static final String JSON_PROPERTY_SOURCE_MESSAGE = "sourceMessage";
  private Map<String, Object> sourceMessage = new HashMap<>();

  public static final String JSON_PROPERTY_REFERENCED_DISTRIBUTION_I_D =
      "referencedDistributionID";
  private String referencedDistributionID;

  public Error() {}

  public Error errorCode(ErrorCode errorCode) {

    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
   **/
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ErrorCode getErrorCode() {
    return errorCode;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setErrorCode(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public Error errorCause(String errorCause) {

    this.errorCause = errorCause;
    return this;
  }

  /**
   * La ou les causes d&#39;erreur dans le message source
   * @return errorCause
   **/
  @JsonProperty(JSON_PROPERTY_ERROR_CAUSE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getErrorCause() {
    return errorCause;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CAUSE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setErrorCause(String errorCause) {
    this.errorCause = errorCause;
  }

  public Error sourceMessage(Map<String, Object> sourceMessage) {

    this.sourceMessage = sourceMessage;
    return this;
  }

  public Error putSourceMessageItem(String key, Object sourceMessageItem) {
    if (this.sourceMessage == null) {
      this.sourceMessage = new HashMap<>();
    }
    this.sourceMessage.put(key, sourceMessageItem);
    return this;
  }

  /**
   * Get sourceMessage
   * @return sourceMessage
   **/
  @JsonProperty(JSON_PROPERTY_SOURCE_MESSAGE)
  @JsonInclude(content = JsonInclude.Include.ALWAYS,
               value = JsonInclude.Include.USE_DEFAULTS)

  public Map<String, Object>
  getSourceMessage() {
    return sourceMessage;
  }

  @JsonProperty(JSON_PROPERTY_SOURCE_MESSAGE)
  @JsonInclude(content = JsonInclude.Include.ALWAYS,
               value = JsonInclude.Include.USE_DEFAULTS)
  public void
  setSourceMessage(Map<String, Object> sourceMessage) {
    this.sourceMessage = sourceMessage;
  }

  public Error referencedDistributionID(String referencedDistributionID) {

    this.referencedDistributionID = referencedDistributionID;
    return this;
  }

  /**
   * DistributionID du message source
   * @return referencedDistributionID
   **/
  @JsonProperty(JSON_PROPERTY_REFERENCED_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getReferencedDistributionID() {
    return referencedDistributionID;
  }

  @JsonProperty(JSON_PROPERTY_REFERENCED_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReferencedDistributionID(String referencedDistributionID) {
    this.referencedDistributionID = referencedDistributionID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error)o;
    return Objects.equals(this.errorCode, error.errorCode) &&
        Objects.equals(this.errorCause, error.errorCause) &&
        Objects.equals(this.sourceMessage, error.sourceMessage) &&
        Objects.equals(this.referencedDistributionID,
                       error.referencedDistributionID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, errorCause, sourceMessage,
                        referencedDistributionID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    errorCode: ")
        .append(toIndentedString(errorCode))
        .append("\n");
    sb.append("    errorCause: ")
        .append(toIndentedString(errorCause))
        .append("\n");
    sb.append("    sourceMessage: ")
        .append(toIndentedString(sourceMessage))
        .append("\n");
    sb.append("    referencedDistributionID: ")
        .append(toIndentedString(referencedDistributionID))
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
