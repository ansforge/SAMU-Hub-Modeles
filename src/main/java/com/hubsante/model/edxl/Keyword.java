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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
public class Keyword {
    @JsonProperty(value = "valueListURI", required = true)
    @JacksonXmlProperty( namespace = "ct",localName = "ValueListURI" )
    public String valueListURI;

    @JsonProperty(value = "value", required = true)
    @JacksonXmlProperty( namespace = "ct", localName = "Value" )
    public String value;

    public Keyword() {
    }

    public Keyword(String ValueListURI, String Value) {
        this.valueListURI = ValueListURI;
        this.value = Value;
    }

    public String getValueListURI() {
        return valueListURI;
    }

    public void setValueListURI(String ValueListURI) {
        this.valueListURI = ValueListURI;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String Value) {
        this.value = Value;
    }
}
