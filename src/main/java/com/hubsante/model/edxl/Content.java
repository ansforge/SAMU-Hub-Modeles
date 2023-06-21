package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Content {

    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlns() {
        return "resource";
    }

    @JsonProperty(value = "contentObject", required = true)
    private ContentObject contentObject;

    public Content() {
    }

    public Content(ContentObject contentObject) {
        this.contentObject = contentObject;
    }

    public ContentObject getContentObject() {
        return contentObject;
    }

    public void setContentObject(ContentObject contentObject) {
        this.contentObject = contentObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(contentObject, content.contentObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentObject);
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentObject=" + contentObject +
                '}';
    }
}
