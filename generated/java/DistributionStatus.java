package com.hubsante.message;
              
import com.fasterxml.jackson.annotation.*;
              
public enum DistributionStatus {
  ACTUAL((String)"Actual"), EXERCISE((String)"Exercise"), SYSTEM((String)"System"), TEST((String)"Test"), UNKNOWN((String)"Unknown"), NO_APPROPRIATE_DEFAULT((String)"NoAppropriateDefault");

  private String value;

  DistributionStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @JsonCreator
  public static DistributionStatus fromValue(String value) {
    for (DistributionStatus e : DistributionStatus.values()) {
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