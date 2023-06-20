package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ExplicitAddress {

    @JsonProperty(value = "explicitAddressScheme", required = true)
    private String explicitAddressScheme;

    @JsonProperty(value = "explicitAddressValue", required = true)
    private String explicitAddressValue;

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
