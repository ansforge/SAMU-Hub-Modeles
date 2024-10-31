package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonPropertyOrder({
        EdxlOther.JSON_PROPERTY_MODEL
})
@JsonTypeName("other")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EdxlOther {

    public static final String JSON_PROPERTY_MODEL = "model";
    private String model;

    @JsonValue
    public String getModel() {
        return model;
    }

    @JsonProperty(JSON_PROPERTY_MODEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setModel(String model) {
        this.model = model;
    }
}
