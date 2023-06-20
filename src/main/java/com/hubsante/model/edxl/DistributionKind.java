package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DistributionKind {

    REPORT("Report"),
    UPDATE("Update"),
    CANCEL("Cancel"),
    REQUEST("Request"),
    RESPONSE("Response"),
    DISPATCH("Dispatch"),
    ACK("Ack"),
    ERROR("Error"),
    SENSOR_CONFIGURATION("SensorConfiguration"),
    SENSOR_CONTROL("SensorControl"),
    SENSOR_STATUS("SensorStatus"),
    SENSOR_DETECTION("SensorDetection"),
    UNKOWN("Unknown"),
    NO_APPROPRIATE_DEFAULT("NoAppropriateDefault");

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
