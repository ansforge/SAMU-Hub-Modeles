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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ExplicitAddress {

    @JsonProperty(value = "explicitAddressScheme", required = true)
    private String explicitAddressScheme;

    @JsonProperty(value = "explicitAddressValue", required = true)
    private String explicitAddressValue;

    public ExplicitAddress() {
    }

    public ExplicitAddress(String explicitAddressScheme, String explicitAddressValue) {
        this.explicitAddressScheme = explicitAddressScheme;
        this.explicitAddressValue = explicitAddressValue;
    }

    public String getExplicitAddressScheme() {
        return explicitAddressScheme;
    }

    public void setExplicitAddressScheme(String explicitAddressScheme) {
        this.explicitAddressScheme = explicitAddressScheme;
    }

    public String getExplicitAddressValue() {
        return explicitAddressValue;
    }

    public void setExplicitAddressValue(String explicitAddressValue) {
        this.explicitAddressValue = explicitAddressValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExplicitAddress that = (ExplicitAddress) o;
        return
                explicitAddressScheme.equals(that.explicitAddressScheme) &&
                explicitAddressValue.equals(that.explicitAddressValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(explicitAddressScheme, explicitAddressValue);
    }

    @Override
    public String toString() {
        return "ExplicitAddress{" +
                "explicitAddressScheme='" + explicitAddressScheme + '\'' +
                ", explicitAddressValue='" + explicitAddressValue + '\'' +
                '}';
    }
}
