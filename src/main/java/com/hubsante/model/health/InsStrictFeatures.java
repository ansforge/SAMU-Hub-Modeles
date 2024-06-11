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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * InsStrictFeatures
 */
@JsonPropertyOrder({InsStrictFeatures.JSON_PROPERTY_BIRTH_NAME,
                    InsStrictFeatures.JSON_PROPERTY_BIRTH_DATE,
                    InsStrictFeatures.JSON_PROPERTY_SEX,
                    InsStrictFeatures.JSON_PROPERTY_BIRTH_PLACE_CODE})
@JsonTypeName("insStrictFeatures")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class InsStrictFeatures {
  public static final String JSON_PROPERTY_BIRTH_NAME = "birthName";
  private String birthName;

  public static final String JSON_PROPERTY_BIRTH_DATE = "birthDate";
  private String birthDate;

  /**
   * Sexe du patient
   */
  public enum SexEnum {
    MASC("MASC"),

    FEM("FEM"),

    AUTRE("AUTRE"),

    INCONNU("INCONNU");

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

  public static final String JSON_PROPERTY_BIRTH_PLACE_CODE = "birthPlaceCode";
  private BigDecimal birthPlaceCode;

  public InsStrictFeatures() {}

  public InsStrictFeatures birthName(String birthName) {

    this.birthName = birthName;
    return this;
  }

  /**
   * Egalement appelé nom de famille.
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
   * Date de naissance du patient
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
   * Sexe du patient
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

  public InsStrictFeatures birthPlaceCode(BigDecimal birthPlaceCode) {

    this.birthPlaceCode = birthPlaceCode;
    return this;
  }

  /**
   * Il s’agit de la commune de naissance pour les personnes nées en France et
   *du pays de naissance pour les personnes nées à l’étranger. Utilisation du
   *code INSEE (différent du code postal), auquel est associé le nom de la
   *commune ou du pays correspondant.
   * @return birthPlaceCode
   **/
  @JsonProperty(JSON_PROPERTY_BIRTH_PLACE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getBirthPlaceCode() {
    return birthPlaceCode;
  }

  @JsonProperty(JSON_PROPERTY_BIRTH_PLACE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBirthPlaceCode(BigDecimal birthPlaceCode) {
    this.birthPlaceCode = birthPlaceCode;
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
        Objects.equals(this.sex, insStrictFeatures.sex) &&
        Objects.equals(this.birthPlaceCode, insStrictFeatures.birthPlaceCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(birthName, birthDate, sex, birthPlaceCode);
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
    sb.append("    birthPlaceCode: ")
        .append(toIndentedString(birthPlaceCode))
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
