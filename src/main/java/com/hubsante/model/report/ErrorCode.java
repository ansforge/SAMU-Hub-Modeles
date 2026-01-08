/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.report;

import com.fasterxml.jackson.annotation.*;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
  DELIVERY_MODE_INCONSISTENCY(100, "DELIVERY_MODE_INCONSISTENCY"),
  NOT_ALLOWED_CONTENT_TYPE(101, "NOT_ALLOWED_CONTENT_TYPE"),
  UNRECOGNIZED_MESSAGE_FORMAT(102, "UNRECOGNIZED_MESSAGE_FORMAT"),
  SENDER_INCONSISTENCY(200, "SENDER_INCONSISTENCY"),
  INVALID_MESSAGE(300, "INVALID_MESSAGE"),
  SCHEMA_NOT_FOUND(301, "SCHEMA_NOT_FOUND"),
  EXPIRED_MESSAGE_BEFORE_ROUTING(400, "EXPIRED_MESSAGE_BEFORE_ROUTING"),
  DEAD_LETTER_QUEUED(500, "DEAD_LETTER_QUEUED"),
  UNROUTABLE_MESSAGE(501, "UNROUTABLE_MESSAGE"),
  MESSAGE_CONVERSION_ERROR(600, "MESSAGE_CONVERSION_ERROR"),
  INTERNAL_CLIENT_ERROR(700, "INTERNAL_CLIENT_ERROR"),
  CASE_ALREADY_EXISTS(701, "CASE_ALREADY_EXISTS"),
  WRONG_MESSAGE_SEQUENCE(702, "WRONG_MESSAGE_SEQUENCE"),
  UNKNOWN_SENDER(703, "UNKNOWN_SENDER"),
  INSUFFICIENT_DATA(704, "INSUFFICIENT_DATA");

  private final String JSON_PROPERTY_STATUS_CODE = "statusCode";
  private final int statusCode;
  private final String JSON_PROPERTY_STATUS_STRING = "statusString";
  private final String statusString;

  ErrorCode(int statusCode, String statusString) {
    this.statusCode = statusCode;
    this.statusString = statusString;
  }

  @JsonCreator
  public static ErrorCode forValues(@JsonProperty("statusCode") int statusCode, @JsonProperty("statusString") String statusString) {
    for (ErrorCode errorCode : ErrorCode.values()) {
      if (errorCode.statusCode == statusCode && errorCode.statusString.equals(statusString)) {
        return errorCode;
      }
    }
    throw new IllegalArgumentException("Inconsistent ErrorCode values");
  }
  @JsonProperty(JSON_PROPERTY_STATUS_CODE)
  public int getStatusCode() {
    return this.statusCode;
  }

  @JsonProperty(JSON_PROPERTY_STATUS_STRING)
  public String getStatusString() {
    return this.statusString;
  }

  @JsonIgnore
  public boolean isSetupError() {
    return this.statusCode < 200;
  }

  @JsonIgnore
  public boolean isUnauthorizedError() {
    return this.statusCode >= 200 && this.statusCode < 300;
  }

  @JsonIgnore
  public boolean isParsingError() {
    return this.statusCode >= 300 && this.statusCode < 400;
  }

  @JsonIgnore
  public boolean isExpired() {
    return this.statusCode >= 400 && this.statusCode < 500;
  }

  @JsonIgnore
  public boolean isUndelivered() {
    return this.statusCode >= 500;
  }
}
