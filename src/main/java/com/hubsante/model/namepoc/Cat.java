package com.hubsante.model.namepoc;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("cat")
public class Cat{
    public Float speed;

    public String name;
}
