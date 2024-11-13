/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonPropertyOrder({
        "language",
        "keyword",
        "explicitAddress"
})
public class Descriptor {

    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlns() {
        return "resource";
    }

    @JsonProperty(value = "language", required = true)
    private String language;

    @JsonProperty(value = "keyword", required = true)
    private List<Keyword> keyword = new ArrayList<>();

    @JsonProperty(value = "explicitAddress", required = true)
    private ExplicitAddress explicitAddress;

    public Descriptor() {
    }

    public Descriptor(String language, ExplicitAddress explicitAddress, List<Keyword> keyword) {
        this.language = language;
        this.explicitAddress = explicitAddress;
        this.keyword = keyword;
    }

    /**
     * Get keyword
     * @return keyword
     **/
    @JsonProperty("keyword")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<Keyword> getKeyword() {
        return keyword;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("keyword")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setKeyword(List<Keyword> keyword) {
        if (keyword == null) {
            return;
        }
        if (this.keyword == null) {
            this.keyword = new ArrayList<>();
        }
        this.keyword.addAll(keyword);
    }

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
        return language.equals(that.language) && explicitAddress.equals(that.explicitAddress) && keyword.equals(that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, explicitAddress, keyword);
    }

    @Override
    public String toString() {
        return "Descriptor{" +
                "language='" + language + '\'' +
                ", explicitAddress=" + explicitAddress +
                ", keyword=" + keyword +
                '}';
    }
}
