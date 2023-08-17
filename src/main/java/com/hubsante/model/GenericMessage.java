package com.hubsante.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.edxl.UseCaseMessage;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
public class GenericMessage extends UseCaseMessage {

    public static final String JSON_PROPERTY_GENERIC_MESSAGE_ID = "genericMessageId";
    private String genericMessageId;

    public static final String JSON_PROPERTY_ATTRIBUTES_WRAPPER = "wrapper";
    private JsonNode attributesWrapper;

    @JsonProperty(JSON_PROPERTY_GENERIC_MESSAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getGenericMessageId() {
        return genericMessageId;
    }

    @JsonProperty(JSON_PROPERTY_GENERIC_MESSAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setGenericMessageId(String genericMessageId) {
        this.genericMessageId = genericMessageId;
    }

    @JsonProperty(JSON_PROPERTY_ATTRIBUTES_WRAPPER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public JsonNode getAttributesWrapper() {
        return attributesWrapper;
    }

    @JsonProperty(JSON_PROPERTY_ATTRIBUTES_WRAPPER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAttributesWrapper(JsonNode attributesWrapper) {
        this.attributesWrapper = attributesWrapper;
    }
}
