package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hubsante.model.cisu.DistributionElement;

public class EmsiWrapper extends DistributionElement {
    public static final String JSON_PROPERTY_EMSI = "emsi";
    private EMSI emsi;

    public EmsiWrapper() {
    }

    public EmsiWrapper emsi(EMSI emsi) {
        this.emsi = emsi;
        return this;
    }

    @JsonProperty(JSON_PROPERTY_EMSI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public EMSI getEmsi() {
        return emsi;
    }

    @JsonProperty(JSON_PROPERTY_EMSI)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEmsi(EMSI emsi) {
        this.emsi = emsi;
    }
}
