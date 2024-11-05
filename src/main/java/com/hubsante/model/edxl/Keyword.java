package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Keyword {

    @JsonProperty(value = "ct:ValueListURI", required = true)
    public String ValueListURI;

    @JsonProperty(value = "ct:Value", required = true)
    public String Value;

    public Keyword() {
    }

    public Keyword(String ValueListURI, String Value) {
        this.ValueListURI = ValueListURI;
        this.Value = Value;
    }

    public String getValueListURI() {
        return ValueListURI;
    }

    public void setValueListURI(String ValueListURI) {
        this.ValueListURI = ValueListURI;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
}
