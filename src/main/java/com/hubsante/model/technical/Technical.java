/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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
/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.technical;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.technical.LevelOneData;
import com.hubsante.model.technical.TechnicalObject;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Technical
 */
@JsonPropertyOrder(
    {Technical.JSON_PROPERTY_REQUIRED_STRING_FIELD,
     Technical.JSON_PROPERTY_OPTIONAL_STRING_FIELD,
     Technical.JSON_PROPERTY_ENUMERATION_FIELD,
     Technical.JSON_PROPERTY_NUMBER_FIELD, Technical.JSON_PROPERTY_OBJECT_FIELD,
     Technical.JSON_PROPERTY_ARRAY_FIELD,
     Technical.JSON_PROPERTY_ENUM_ARRAY_FIELD,
     Technical.JSON_PROPERTY_REQUIRED_ARRAY,
     Technical.JSON_PROPERTY_ARRAY_WITH_MAX_LENGTH,
     Technical.JSON_PROPERTY_PHONE_NUMBER_FIELD,
     Technical.JSON_PROPERTY_DATE_FIELD, Technical.JSON_PROPERTY_EMAIL_FIELD,
     Technical.JSON_PROPERTY_DATETIME_FIELD,
     Technical.JSON_PROPERTY_OBJECT_LEVEL1})
@JsonTypeName("technical")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Technical {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:technical";
  public static final String JSON_PROPERTY_REQUIRED_STRING_FIELD =
      "requiredStringField";
  private String requiredStringField;

  public static final String JSON_PROPERTY_OPTIONAL_STRING_FIELD =
      "optionalStringField";
  private String optionalStringField;

  /**
   * This is an enumeration
   */
  public enum EnumerationFieldEnum {
    REPORT("REPORT"),

    UPDATE("UPDATE"),

    CANCEL("CANCEL"),

    ACK("ACK"),

    ERROR("ERROR");

    private String value;

    EnumerationFieldEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EnumerationFieldEnum fromValue(String value) {
      for (EnumerationFieldEnum b : EnumerationFieldEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ENUMERATION_FIELD =
      "enumerationField";
  private EnumerationFieldEnum enumerationField;

  public static final String JSON_PROPERTY_NUMBER_FIELD = "numberField";
  private BigDecimal numberField;

  public static final String JSON_PROPERTY_OBJECT_FIELD = "objectField";
  private TechnicalObject objectField = null;

  public static final String JSON_PROPERTY_ARRAY_FIELD = "arrayField";
  private List<String> arrayField;

  /**
   * This is an array of enumerations
   */
  public enum EnumArrayFieldEnum {
    REPORT("REPORT"),

    UPDATE("UPDATE"),

    CANCEL("CANCEL"),

    ACK("ACK"),

    ERROR("ERROR");

    private String value;

    EnumArrayFieldEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EnumArrayFieldEnum fromValue(String value) {
      for (EnumArrayFieldEnum b : EnumArrayFieldEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ENUM_ARRAY_FIELD = "enumArrayField";
  private List<EnumArrayFieldEnum> enumArrayField;

  public static final String JSON_PROPERTY_REQUIRED_ARRAY = "requiredArray";
  private List<String> requiredArray = new ArrayList<>();

  public static final String JSON_PROPERTY_ARRAY_WITH_MAX_LENGTH =
      "arrayWithMaxLength";
  private List<String> arrayWithMaxLength;

  public static final String JSON_PROPERTY_PHONE_NUMBER_FIELD =
      "phoneNumberField";
  private String phoneNumberField;

  public static final String JSON_PROPERTY_DATE_FIELD = "dateField";
  private String dateField;

  public static final String JSON_PROPERTY_EMAIL_FIELD = "emailField";
  private String emailField;

  public static final String JSON_PROPERTY_DATETIME_FIELD = "datetimeField";
  private OffsetDateTime datetimeField;

  public static final String JSON_PROPERTY_OBJECT_LEVEL1 = "objectLevel1";
  private LevelOneData objectLevel1 = null;

  public Technical() {}

  public Technical requiredStringField(String requiredStringField) {

    this.requiredStringField = requiredStringField;
    return this;
  }

  /**
   * This field is required
   * @return requiredStringField
   **/
  @JsonProperty(JSON_PROPERTY_REQUIRED_STRING_FIELD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRequiredStringField() {
    return requiredStringField;
  }

  @JsonProperty(JSON_PROPERTY_REQUIRED_STRING_FIELD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequiredStringField(String requiredStringField) {
    this.requiredStringField = requiredStringField;
  }

  public Technical optionalStringField(String optionalStringField) {

    this.optionalStringField = optionalStringField;
    return this;
  }

  /**
   * This field is optional
   * @return optionalStringField
   **/
  @JsonProperty(JSON_PROPERTY_OPTIONAL_STRING_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOptionalStringField() {
    return optionalStringField;
  }

  @JsonProperty(JSON_PROPERTY_OPTIONAL_STRING_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOptionalStringField(String optionalStringField) {
    this.optionalStringField = optionalStringField;
  }

  public Technical enumerationField(EnumerationFieldEnum enumerationField) {

    this.enumerationField = enumerationField;
    return this;
  }

  /**
   * This is an enumeration
   * @return enumerationField
   **/
  @JsonProperty(JSON_PROPERTY_ENUMERATION_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public EnumerationFieldEnum getEnumerationField() {
    return enumerationField;
  }

  @JsonProperty(JSON_PROPERTY_ENUMERATION_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnumerationField(EnumerationFieldEnum enumerationField) {
    this.enumerationField = enumerationField;
  }

  public Technical numberField(BigDecimal numberField) {

    this.numberField = numberField;
    return this;
  }

  /**
   * This is a number
   * @return numberField
   **/
  @JsonProperty(JSON_PROPERTY_NUMBER_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getNumberField() {
    return numberField;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberField(BigDecimal numberField) {
    this.numberField = numberField;
  }

  public Technical objectField(TechnicalObject objectField) {

    this.objectField = objectField;
    return this;
  }

  /**
   * This is an object
   * @return objectField
   **/
  @JsonProperty(JSON_PROPERTY_OBJECT_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TechnicalObject getObjectField() {
    return objectField;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObjectField(TechnicalObject objectField) {
    this.objectField = objectField;
  }

  public Technical arrayField(List<String> arrayField) {

    this.arrayField = arrayField;
    return this;
  }

  public Technical addArrayFieldItem(String arrayFieldItem) {
    if (this.arrayField == null) {
      this.arrayField = new ArrayList<>();
    }
    this.arrayField.add(arrayFieldItem);
    return this;
  }

  /**
   * Get arrayField
   * @return arrayField
   **/
  @JsonProperty(JSON_PROPERTY_ARRAY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getArrayField() {
    return arrayField;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ARRAY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrayField(List<String> arrayField) {
    if (arrayField == null) {
      return;
    }
    if (this.arrayField == null) {
      this.arrayField = new ArrayList<>();
    }
    this.arrayField.addAll(arrayField);
  }

  public Technical enumArrayField(List<EnumArrayFieldEnum> enumArrayField) {

    this.enumArrayField = enumArrayField;
    return this;
  }

  public Technical
  addEnumArrayFieldItem(EnumArrayFieldEnum enumArrayFieldItem) {
    if (this.enumArrayField == null) {
      this.enumArrayField = new ArrayList<>();
    }
    this.enumArrayField.add(enumArrayFieldItem);
    return this;
  }

  /**
   * Get enumArrayField
   * @return enumArrayField
   **/
  @JsonProperty(JSON_PROPERTY_ENUM_ARRAY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EnumArrayFieldEnum> getEnumArrayField() {
    return enumArrayField;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ENUM_ARRAY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEnumArrayField(List<EnumArrayFieldEnum> enumArrayField) {
    if (enumArrayField == null) {
      return;
    }
    if (this.enumArrayField == null) {
      this.enumArrayField = new ArrayList<>();
    }
    this.enumArrayField.addAll(enumArrayField);
  }

  public Technical requiredArray(List<String> requiredArray) {

    this.requiredArray = requiredArray;
    return this;
  }

  public Technical addRequiredArrayItem(String requiredArrayItem) {
    if (this.requiredArray == null) {
      this.requiredArray = new ArrayList<>();
    }
    this.requiredArray.add(requiredArrayItem);
    return this;
  }

  /**
   * Get requiredArray
   * @return requiredArray
   **/
  @JsonProperty(JSON_PROPERTY_REQUIRED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getRequiredArray() {
    return requiredArray;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_REQUIRED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequiredArray(List<String> requiredArray) {
    if (requiredArray == null) {
      return;
    }
    if (this.requiredArray == null) {
      this.requiredArray = new ArrayList<>();
    }
    this.requiredArray.addAll(requiredArray);
  }

  public Technical arrayWithMaxLength(List<String> arrayWithMaxLength) {

    this.arrayWithMaxLength = arrayWithMaxLength;
    return this;
  }

  public Technical addArrayWithMaxLengthItem(String arrayWithMaxLengthItem) {
    if (this.arrayWithMaxLength == null) {
      this.arrayWithMaxLength = new ArrayList<>();
    }
    this.arrayWithMaxLength.add(arrayWithMaxLengthItem);
    return this;
  }

  /**
   * Get arrayWithMaxLength
   * @return arrayWithMaxLength
   **/
  @JsonProperty(JSON_PROPERTY_ARRAY_WITH_MAX_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getArrayWithMaxLength() {
    return arrayWithMaxLength;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_ARRAY_WITH_MAX_LENGTH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setArrayWithMaxLength(List<String> arrayWithMaxLength) {
    if (arrayWithMaxLength == null) {
      return;
    }
    if (this.arrayWithMaxLength == null) {
      this.arrayWithMaxLength = new ArrayList<>();
    }
    this.arrayWithMaxLength.addAll(arrayWithMaxLength);
  }

  public Technical phoneNumberField(String phoneNumberField) {

    this.phoneNumberField = phoneNumberField;
    return this;
  }

  /**
   * Phone number with regex
   * @return phoneNumberField
   **/
  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPhoneNumberField() {
    return phoneNumberField;
  }

  @JsonProperty(JSON_PROPERTY_PHONE_NUMBER_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPhoneNumberField(String phoneNumberField) {
    this.phoneNumberField = phoneNumberField;
  }

  public Technical dateField(String dateField) {

    this.dateField = dateField;
    return this;
  }

  /**
   * Date with regex
   * @return dateField
   **/
  @JsonProperty(JSON_PROPERTY_DATE_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDateField() {
    return dateField;
  }

  @JsonProperty(JSON_PROPERTY_DATE_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDateField(String dateField) {
    this.dateField = dateField;
  }

  public Technical emailField(String emailField) {

    this.emailField = emailField;
    return this;
  }

  /**
   * Email with regex
   * @return emailField
   **/
  @JsonProperty(JSON_PROPERTY_EMAIL_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEmailField() {
    return emailField;
  }

  @JsonProperty(JSON_PROPERTY_EMAIL_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEmailField(String emailField) {
    this.emailField = emailField;
  }

  public Technical datetimeField(OffsetDateTime datetimeField) {

    this.datetimeField = datetimeField;
    return this;
  }

  /**
   * Datetime
   * @return datetimeField
   **/
  @JsonProperty(JSON_PROPERTY_DATETIME_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDatetimeField() {
    return datetimeField;
  }

  @JsonProperty(JSON_PROPERTY_DATETIME_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDatetimeField(OffsetDateTime datetimeField) {
    this.datetimeField = datetimeField;
  }

  public Technical objectLevel1(LevelOneData objectLevel1) {

    this.objectLevel1 = objectLevel1;
    return this;
  }

  /**
   * Object at data level 1
   * @return objectLevel1
   **/
  @JsonProperty(JSON_PROPERTY_OBJECT_LEVEL1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LevelOneData getObjectLevel1() {
    return objectLevel1;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_LEVEL1)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObjectLevel1(LevelOneData objectLevel1) {
    this.objectLevel1 = objectLevel1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Technical technical = (Technical)o;
    return Objects.equals(this.requiredStringField,
                          technical.requiredStringField) &&
        Objects.equals(this.optionalStringField,
                       technical.optionalStringField) &&
        Objects.equals(this.enumerationField, technical.enumerationField) &&
        Objects.equals(this.numberField, technical.numberField) &&
        Objects.equals(this.objectField, technical.objectField) &&
        Objects.equals(this.arrayField, technical.arrayField) &&
        Objects.equals(this.enumArrayField, technical.enumArrayField) &&
        Objects.equals(this.requiredArray, technical.requiredArray) &&
        Objects.equals(this.arrayWithMaxLength, technical.arrayWithMaxLength) &&
        Objects.equals(this.phoneNumberField, technical.phoneNumberField) &&
        Objects.equals(this.dateField, technical.dateField) &&
        Objects.equals(this.emailField, technical.emailField) &&
        Objects.equals(this.datetimeField, technical.datetimeField) &&
        Objects.equals(this.objectLevel1, technical.objectLevel1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredStringField, optionalStringField,
                        enumerationField, numberField, objectField, arrayField,
                        enumArrayField, requiredArray, arrayWithMaxLength,
                        phoneNumberField, dateField, emailField, datetimeField,
                        objectLevel1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Technical {\n");
    sb.append("    requiredStringField: ")
        .append(toIndentedString(requiredStringField))
        .append("\n");
    sb.append("    optionalStringField: ")
        .append(toIndentedString(optionalStringField))
        .append("\n");
    sb.append("    enumerationField: ")
        .append(toIndentedString(enumerationField))
        .append("\n");
    sb.append("    numberField: ")
        .append(toIndentedString(numberField))
        .append("\n");
    sb.append("    objectField: ")
        .append(toIndentedString(objectField))
        .append("\n");
    sb.append("    arrayField: ")
        .append(toIndentedString(arrayField))
        .append("\n");
    sb.append("    enumArrayField: ")
        .append(toIndentedString(enumArrayField))
        .append("\n");
    sb.append("    requiredArray: ")
        .append(toIndentedString(requiredArray))
        .append("\n");
    sb.append("    arrayWithMaxLength: ")
        .append(toIndentedString(arrayWithMaxLength))
        .append("\n");
    sb.append("    phoneNumberField: ")
        .append(toIndentedString(phoneNumberField))
        .append("\n");
    sb.append("    dateField: ")
        .append(toIndentedString(dateField))
        .append("\n");
    sb.append("    emailField: ")
        .append(toIndentedString(emailField))
        .append("\n");
    sb.append("    datetimeField: ")
        .append(toIndentedString(datetimeField))
        .append("\n");
    sb.append("    objectLevel1: ")
        .append(toIndentedString(objectLevel1))
        .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
