package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
              
public enum Type {
  POINT((String)"POINT"), CIRCLE((String)"CIRCLE"), LINE((String)"LINE"), SURFACE((String)"SURFACE"), GRID((String)"GRID"), POLYGON((String)"POLYGON"), ELLIPSE((String)"ELLIPSE");

  private String value;

  Type(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static Type fromValue(String value) {
    for (Type e : Type.values()) {
      if (e.value.equals(value)) {
        return e;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}