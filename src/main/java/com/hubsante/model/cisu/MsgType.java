package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
              
public enum MsgType {
  ALERT((String)"ALERT"), ACK((String)"ACK"), UPDATE((String)"UPDATE"), CANCEL((String)"CANCEL");

  private String value;

  MsgType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static MsgType fromValue(String value) {
    for (MsgType e : MsgType.values()) {
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