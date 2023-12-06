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
import com.hubsante.model.common.DistributionElement;

public class EmsiWrapper extends DistributionElement {
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
}
