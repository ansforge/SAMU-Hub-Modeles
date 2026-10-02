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

    public Descriptor() {
    }

    public Descriptor(String language, ExplicitAddress explicitAddress) {
        this.language = language;
        this.explicitAddress = explicitAddress;
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
