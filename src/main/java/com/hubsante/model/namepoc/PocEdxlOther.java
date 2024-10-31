package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("other")
public class PocEdxlOther {

    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
