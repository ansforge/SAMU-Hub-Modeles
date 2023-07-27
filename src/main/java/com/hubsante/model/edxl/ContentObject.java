package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class ContentObject {

    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlns() {
        return "resource";
    }

    @JsonProperty(value = "jsonContent", required = true)
    @JacksonXmlProperty(localName = "contentXML")
    private ContentWrapper contentWrapper;

    public ContentObject() {
    }

    public ContentObject(ContentWrapper contentWrapper) {
        this.contentWrapper = contentWrapper;
    }

    public ContentWrapper getContentWrapper() {
        return contentWrapper;
    }

    public void setContentWrapper(ContentWrapper contentWrapper) {
        this.contentWrapper = contentWrapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentObject that = (ContentObject) o;
        return Objects.equals(contentWrapper, that.contentWrapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentWrapper);
    }

    @Override
    public String toString() {
        return "ContentObject{" +
                "contentXML=" + contentWrapper +
                '}';
    }
}
