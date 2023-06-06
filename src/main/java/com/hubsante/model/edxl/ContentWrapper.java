package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JsonRootName(value = "JsonContent")
@JacksonXmlRootElement(localName = "ContentXML")
public class ContentWrapper {

    @JsonProperty(value = "embeddedJsonContent")
    @JacksonXmlProperty(localName = "embeddedXMLContent")
    private EmbeddedContent embeddedContent;

    public ContentWrapper() {
    }

    public ContentWrapper(EmbeddedContent embeddedContent) {
        this.embeddedContent = embeddedContent;
    }

    public EmbeddedContent getEmbeddedContent() {
        return embeddedContent;
    }

    public void setEmbeddedContent(EmbeddedContent embeddedContent) {
        this.embeddedContent = embeddedContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentWrapper that = (ContentWrapper) o;
        return Objects.equals(embeddedContent, that.embeddedContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(embeddedContent);
    }

    @Override
    public String toString() {
        return "ContentWrapper{" +
                "embeddedContent=" + embeddedContent.toString() +
                '}';
    }
}
