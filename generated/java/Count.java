package com.hubsante.message;
              
import com.fasterxml.jackson.annotation.*;
              
public enum Count {
  NUMBER_0((String)"0"), NUMBER_1((String)"1"), SEVERAL((String)"SEVERAL"), MANY((String)"MANY"), UNKNOWN((String)"UNKNOWN");

  private String value;

  Count(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static Count fromValue(String value) {
    for (Count e : Count.values()) {
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