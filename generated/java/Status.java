package com.hubsante.message;
              
import com.fasterxml.jackson.annotation.*;
              
public enum Status {
  ACTUAL((String)"ACTUAL"), EXERCISE((String)"EXERCISE"), TEST((String)"TEST"), DRAFT((String)"DRAFT"), SYSTEM((String)"SYSTEM");

  private String value;

  Status(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static Status fromValue(String value) {
    for (Status e : Status.values()) {
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