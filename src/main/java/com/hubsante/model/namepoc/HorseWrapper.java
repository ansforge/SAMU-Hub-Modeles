package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("horseWrapper")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HorseWrapper extends PocContentMessage{

    private Horse horse;

    public HorseWrapper horse(Horse horse) {
        this.horse = horse;
        return this;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
