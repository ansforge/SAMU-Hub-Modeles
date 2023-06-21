package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Descriptor {

    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlns() {
        return "resource";
    }

    @JsonProperty(value = "language", required = true)
    private String language;

    @JsonProperty(value = "explicitAddress", required = true)
    private ExplicitAddress explicitAddress;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ExplicitAddress getExplicitAddress() {
        return explicitAddress;
    }

    public void setExplicitAddress(ExplicitAddress explicitAddress) {
        this.explicitAddress = explicitAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descriptor that = (Descriptor) o;
        return language.equals(that.language) && explicitAddress.equals(that.explicitAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, explicitAddress);
    }

    @Override
    public String toString() {
        return "Descriptor{" +
                "language='" + language + '\'' +
                ", explicitAddress=" + explicitAddress +
                '}';
    }
}
