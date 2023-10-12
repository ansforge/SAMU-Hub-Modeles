package com.hubsante.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.cisu.CreateCaseMessage;
import com.hubsante.model.edxl.ContentMessage;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
public class CustomMessage extends ContentMessage {

    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
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
