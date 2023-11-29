/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.edxl.ContentMessage;

import java.util.Objects;

@JsonPropertyOrder({"errorCode", "errorCause", "sourceMessage", "referencedDistributionID"})
@JacksonXmlRootElement(localName = "message")
public class ErrorReport extends ContentMessage {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    private final String JSON_PROPERTY_ERROR_CODE = "errorCode";
    private ErrorCode errorCode;
    private final String JSON_PROPERTY_ERROR_CAUSE = "errorCause";
    private String errorCause;
    private final String JSON_PROPERTY_SOURCE_MESSAGE = "sourceMessage";
    private String sourceMessage;
    private final String JSON_PROPERTY_REFERENCED_DISTRIBUTION_ID = "referencedDistributionID";
    private String referencedDistributionID;

    public ErrorReport() {
    }

    public ErrorReport(ErrorCode errorCode, String errorCause, String sourceMessage, String referencedDistributionID) {
        this.errorCode = errorCode;
        this.errorCause = errorCause;
        this.sourceMessage = sourceMessage;
        this.referencedDistributionID = referencedDistributionID;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_CODE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_CODE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_CAUSE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public String getErrorCause() {
        return errorCause;
    }

    @JsonProperty(JSON_PROPERTY_ERROR_CAUSE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public void setErrorCause(String errorCause) {
        this.errorCause = errorCause;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_MESSAGE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public String getSourceMessage() {
        return sourceMessage;
    }

    @JsonProperty(JSON_PROPERTY_SOURCE_MESSAGE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    public void setSourceMessage(String sourceMessage) {
        this.sourceMessage = sourceMessage;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCED_DISTRIBUTION_ID)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getReferencedDistributionID() { return referencedDistributionID; }

    @JsonProperty(JSON_PROPERTY_REFERENCED_DISTRIBUTION_ID)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public void setReferencedDistributionID(String referencedDistributionID) { this.referencedDistributionID = referencedDistributionID; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorReport that = (ErrorReport) o;
        return errorCode == that.errorCode && Objects.equals(errorCause, that.errorCause) && Objects.equals(sourceMessage, that.sourceMessage) && Objects.equals(referencedDistributionID, that.referencedDistributionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorCause, sourceMessage, referencedDistributionID);
    }
}
