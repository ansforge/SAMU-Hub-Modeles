package com.hubsante.model.report;

public enum ErrorCode {
    DELIVERY_MODE_INCONSISTENCY(100, "DELIVERY_MODE_INCONSISTENCY"),
    NOT_ALLOWED_CONTENT_TYPE(101, "NOT_ALLOWED_CONTENT_TYPE"),
    UNRECOGNIZED_MESSAGE_FORMAT(102, "UNRECOGNIZED_MESSAGE_FORMAT"),
    SENDER_INCONSISTENCY(200, "SENDER_INCONSISTENCY"),
    INVALID_MESSAGE(300, "INVALID_MESSAGE"),
    EXPIRED_MESSAGE_BEFORE_ROUTING(400, "EXPIRED_MESSAGE_BEFORE_ROUTING"),
    DEAD_LETTER_QUEUED(500, "DEAD_LETTER_QUEUED");

    ErrorCode(int statusCode, String statusString) {
        this.statusCode = statusCode;
        this.statusString = statusString;
    }

    private int statusCode;
    private String statusString;
    
    public boolean isSetupError() {
        return this.statusCode <200;
    }

    public boolean isUnauthorizedError() {
        return this.statusCode >= 200 && this.statusCode < 300;
    }

    public boolean isParsingError() {
        return this.statusCode >= 300 && this.statusCode < 400;
    }

    public boolean isExpired() {
        return this.statusCode >= 400 && this.statusCode < 500;
    }
}
