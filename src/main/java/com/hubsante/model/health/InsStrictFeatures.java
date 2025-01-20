/**
 * Copyright © 2023-2025 Agence du Numerique en Sante (ANS)
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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * InsStrictFeatures
 */
@JsonPropertyOrder({InsStrictFeatures.JSON_PROPERTY_BIRTH_NAME,
                    InsStrictFeatures.JSON_PROPERTY_BIRTH_DATE,
                    InsStrictFeatures.JSON_PROPERTY_SEX})
@JsonTypeName("insStrictFeatures")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class InsStrictFeatures {
  public static final String JSON_PROPERTY_BIRTH_NAME = "birthName";
  private String birthName;

  public static final String JSON_PROPERTY_BIRTH_DATE = "birthDate";
  private String birthDate;

  /**
   * A valoriser avec le sexe du patient
   */
  public enum SexEnum {
    M("M"),

    F("F"),

    O("O"),

    UN("UN");

    private String value;

    SexEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_SEX = "sex";
  private SexEnum sex;

  public InsStrictFeatures() {}

  public InsStrictFeatures birthName(String birthName) {

    this.birthName = birthName;
    return this;
  }

  /**
   * A valoriser avec le nom de naissance du patient. Egalement appelé nom de
   *famille.
   * @return birthName
   **/
  @JsonProperty(JSON_PROPERTY_BIRTH_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBirthName() {
    return birthName;
  }

  @JsonProperty(JSON_PROPERTY_BIRTH_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthName(String birthName) {
    this.birthName = birthName;
  }

  public InsStrictFeatures birthDate(String birthDate) {

    this.birthDate = birthDate;
    return this;
  }

  /**
   * A valoriser avec la date de naissance du patient
   * @return birthDate
   **/
  @JsonProperty(JSON_PROPERTY_BIRTH_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBirthDate() {
    return birthDate;
  }

  @JsonProperty(JSON_PROPERTY_BIRTH_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public InsStrictFeatures sex(SexEnum sex) {

    this.sex = sex;
    return this;
  }

  /**
   * A valoriser avec le sexe du patient
   * @return sex
   **/
  @JsonProperty(JSON_PROPERTY_SEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SexEnum getSex() {
    return sex;
  }

  @JsonProperty(JSON_PROPERTY_SEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsStrictFeatures insStrictFeatures = (InsStrictFeatures)o;
    return Objects.equals(this.birthName, insStrictFeatures.birthName) &&
        Objects.equals(this.birthDate, insStrictFeatures.birthDate) &&
        Objects.equals(this.sex, insStrictFeatures.sex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(birthName, birthDate, sex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsStrictFeatures {\n");
    sb.append("    birthName: ")
        .append(toIndentedString(birthName))
        .append("\n");
    sb.append("    birthDate: ")
        .append(toIndentedString(birthDate))
        .append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
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
