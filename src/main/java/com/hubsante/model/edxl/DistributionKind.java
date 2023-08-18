package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DistributionKind {

    REPORT("Report"),
    UPDATE("Update"),
    CANCEL("Cancel"),
    ACK("Ack"),
    ERROR("Error");

    private String value;
    DistributionKind(String value) { this.value = value; }

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
