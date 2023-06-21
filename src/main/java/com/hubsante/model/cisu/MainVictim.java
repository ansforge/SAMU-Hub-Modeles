package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
              
public enum MainVictim {
  INFANT((String)"INFANT"), CHILD((String)"CHILD"), ADULT((String)"ADULT"), PREGNANT((String)"PREGNANT"), SENIOR((String)"SENIOR");

  private String value;

  MainVictim(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static MainVictim fromValue(String value) {
    for (MainVictim e : MainVictim.values()) {
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