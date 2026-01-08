/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
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
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Objects;

@JsonRootName(value = "JsonContent")
@JacksonXmlRootElement(localName = "ContentXML")
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
