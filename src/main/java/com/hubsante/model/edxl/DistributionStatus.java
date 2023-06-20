package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DistributionStatus {
    ACTUAL("Actual"), EXERCISE("Exercise"), SYSTEM("System"), TEST("Test"), UNKOWN("Unknown"), NO_APPROPRIATE_DEFAULT("NoAppropriateDefault");

    private String value;
    DistributionStatus(String value) { this.value = value; }

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
