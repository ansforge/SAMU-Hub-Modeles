package com.hubsante.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.edxl.UseCaseMessage;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
public class CustomMessage extends UseCaseMessage {

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
}
