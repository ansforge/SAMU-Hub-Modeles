/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.hubsante.model.common.DistributionElement;

import java.util.Objects;

@JsonPropertyOrder({
        EmsiWrapper.JSON_PROPERTY_EMSI
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeName("emsiWrapper")
public class EmsiWrapper extends DistributionElement {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    public static final String JSON_PROPERTY_EMSI = "emsi";
    private Emsi emsi;

    public EmsiWrapper() {
    }

    public EmsiWrapper emsi(Emsi emsi) {
        this.emsi = emsi;
        return this;
    }

    @JsonProperty(JSON_PROPERTY_EMSI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Emsi getEmsi() {
        return emsi;
    }

    @JsonProperty(JSON_PROPERTY_EMSI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEmsi(Emsi emsi) {
        this.emsi = emsi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EmsiWrapper that = (EmsiWrapper) o;
        return Objects.equals(emsi, that.emsi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emsi);
    }

    @Override
    public String toString() {
        return "EmsiWrapper{" +
                "emsi=" + emsi +
                '}';
    }
}
