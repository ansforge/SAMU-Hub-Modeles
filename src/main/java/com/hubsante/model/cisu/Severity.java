package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
              
public enum Severity {
  EXTREME((String)"EXTREME"), SEVERE((String)"SEVERE"), MODERATE((String)"MODERATE"), MINOR((String)"MINOR"), UNKNOWN((String)"UNKNOWN");

  private String value;

  Severity(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static Severity fromValue(String value) {
    for (Severity e : Severity.values()) {
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