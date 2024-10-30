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
package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class PocContentObject {


    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlns() {
        return "resource";
    }

    @JsonProperty(value = "jsonContent", required = true)
    @JacksonXmlProperty(localName = "contentXML")
    private PocContentWrapper pocContentWrapper;

    public PocContentObject() {
    }

    public PocContentObject(PocContentWrapper pocContentWrapper) {
        this.pocContentWrapper = pocContentWrapper;
    }

    public PocContentWrapper getPocContentWrapper() {
        return pocContentWrapper;
    }

    public void setPocContentWrapper(PocContentWrapper pocContentWrapper) {
        this.pocContentWrapper = pocContentWrapper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PocContentObject that = (PocContentObject) o;
        return Objects.equals(pocContentWrapper, that.pocContentWrapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pocContentWrapper);
    }

    @Override
    public String toString() {
        return "ContentObject{" +
                "contentXML=" + pocContentWrapper +
                '}';
    }
}
