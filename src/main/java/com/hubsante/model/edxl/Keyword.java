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
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Keyword {

    @JsonProperty(value = "ct:ValueListURI", required = true)
    public String ValueListURI;

    @JsonProperty(value = "ct:Value", required = true)
    public String Value;

    public Keyword() {
    }

    public Keyword(String ValueListURI, String Value) {
        this.ValueListURI = ValueListURI;
        this.Value = Value;
    }

    public String getValueListURI() {
        return ValueListURI;
    }

    public void setValueListURI(String ValueListURI) {
        this.ValueListURI = ValueListURI;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }
}
