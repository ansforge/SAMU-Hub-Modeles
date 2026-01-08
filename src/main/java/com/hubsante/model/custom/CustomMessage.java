/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.edxl.ContentMessage;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
public class CustomMessage extends ContentMessage {

    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:eda:1.9";
    public static final String JSON_PROPERTY_ATTRIBUTES_WRAPPER = "customContent";
    private JsonNode customContent;

    @JsonProperty(JSON_PROPERTY_ATTRIBUTES_WRAPPER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public JsonNode getCustomContent() {
        return customContent;
    }

    @JsonProperty(JSON_PROPERTY_ATTRIBUTES_WRAPPER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCustomContent(JsonNode customContent) {
        this.customContent = customContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomMessage customMessage = (CustomMessage) o;
        return Objects.equals(this.customContent, customMessage.customContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customContent);
    }
}
