package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("catWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CatWrapper extends PocContentMessage{

    private Cat cat;

    public CatWrapper cat(Cat cat) {
        this.cat = cat;
        return this;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
