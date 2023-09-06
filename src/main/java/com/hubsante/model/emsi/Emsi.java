package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hubsante.model.edxl.ContentMessage;

@JacksonXmlRootElement(localName = "emsi")
public class Emsi extends ContentMessage {

    @JacksonXmlProperty(isAttribute = true)
    private String xmlns = "http://emsi";

    @JsonProperty(value = "property1")
    private String property1;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getXmlns() {
        return xmlns;
    }
}
