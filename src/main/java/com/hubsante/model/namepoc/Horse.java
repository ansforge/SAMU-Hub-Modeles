package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("horse")
public class Horse{
    public Float speed;

    public String name;
}
