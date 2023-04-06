package com.hubsante.message;
              
import com.fasterxml.jackson.annotation.*;
              
public enum CancelReason {
  ERROR((String)"ERROR"), MALEVOLENCE((String)"MALEVOLENCE"), OTHER((String)"OTHER");

  private String value;

  CancelReason(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static CancelReason fromValue(String value) {
    for (CancelReason e : CancelReason.values()) {
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