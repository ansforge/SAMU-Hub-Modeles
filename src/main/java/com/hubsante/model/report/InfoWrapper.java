/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.hubsante.model.edxl.ContentMessage;

import java.util.Objects;

/**
 * InfoWrapper
 */
@JsonPropertyOrder({InfoWrapper.JSON_PROPERTY_INFO})
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class InfoWrapper extends ContentMessage {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    public static final String JSON_PROPERTY_INFO = "info";
    private ErrorReport info;

    public InfoWrapper() {}

    public InfoWrapper info(ErrorReport info) {

        this.info = info;
        return this;
    }

    /**
     * Get info
     * @return info
     **/
    @JsonProperty(JSON_PROPERTY_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ErrorReport getInfo() {
        return info;
    }

    @JsonProperty(JSON_PROPERTY_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInfo(ErrorReport info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InfoWrapper that = (InfoWrapper) o;
        return Objects.equals(this.info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InfoWrapper {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    info: ")
                .append(toIndentedString(info))
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
