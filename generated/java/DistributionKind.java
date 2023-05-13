package com.hubsante.message;
              
import com.fasterxml.jackson.annotation.*;
              
public enum DistributionKind {
  REPORT((String)"Report"), UPDATE((String)"Update"), CANCEL((String)"Cancel"), REQUEST((String)"Request"), RESPONSE((String)"Response"), DISPATCH((String)"Dispatch"), ACK((String)"Ack"), ERROR((String)"Error"), SENSOR_CONFIGURATION((String)"SensorConfiguration"), SENSOR_CONTROL((String)"SensorControl"), SENSOR_STATUS((String)"SensorStatus"), SENSOR_DETECTION((String)"SensorDetection"), UNKNOWN((String)"Unknown"), NO_APPROPRIATE_DEFAULT((String)"NoAppropriateDefault");

  private String value;

  DistributionKind(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static DistributionKind fromValue(String value) {
    for (DistributionKind e : DistributionKind.values()) {
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