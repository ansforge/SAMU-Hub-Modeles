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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * HealthMotive
 */
@JsonPropertyOrder(
    {HealthMotive.JSON_PROPERTY_CODE, HealthMotive.JSON_PROPERTY_LABEL})
@JsonTypeName("healthMotive")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class HealthMotive {

  /**
   * A valoriser avec le code de la nomenclature associée
   */
  public enum CodeEnum {
    M01_00("M01.00"),

    M01_01("M01.01"),

    M01_02("M01.02"),

    M01_03("M01.03"),

    M02_00("M02.00"),

    M02_01("M02.01"),

    M02_02("M02.02"),

    M02_03("M02.03"),

    M02_04("M02.04"),

    M02_05("M02.05"),

    M02_06("M02.06"),

    M02_07("M02.07"),

    M02_08("M02.08"),

    M02_09("M02.09"),

    M02_10("M02.10"),

    M03_00("M03.00"),

    M03_01("M03.01"),

    M03_02("M03.02"),

    M03_03("M03.03"),

    M03_04("M03.04"),

    M03_05("M03.05"),

    M03_06("M03.06"),

    M03_07("M03.07"),

    M03_08("M03.08"),

    M03_09("M03.09"),

    M03_10("M03.10"),

    M03_11("M03.11"),

    M03_12("M03.12"),

    M03_13("M03.13"),

    M03_14("M03.14"),

    M03_15("M03.15"),

    M03_16("M03.16"),

    M03_17("M03.17"),

    M03_18("M03.18"),

    M03_19("M03.19"),

    M03_20("M03.20"),

    M03_21("M03.21"),

    M03_22("M03.22"),

    M04_00("M04.00"),

    M04_01("M04.01"),

    M04_02("M04.02"),

    M04_03("M04.03"),

    M04_04("M04.04"),

    M05_00("M05.00"),

    M05_01("M05.01"),

    M05_02("M05.02"),

    M06_00("M06.00"),

    M06_01("M06.01"),

    M06_02("M06.02"),

    M06_03("M06.03"),

    M06_04("M06.04"),

    M07_00("M07.00");

    private String value;

    CodeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CodeEnum fromValue(String value) {
      for (CodeEnum b : CodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CODE = "code";
  private CodeEnum code;

  public static final String JSON_PROPERTY_LABEL = "label";
  private String label;

  public HealthMotive() {}

  public HealthMotive code(CodeEnum code) {

    this.code = code;
    return this;
  }

  /**
   * A valoriser avec le code de la nomenclature associée
   * @return code
   **/
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CodeEnum getCode() {
    return code;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public HealthMotive label(String label) {

    this.label = label;
    return this;
  }

  /**
   * A valoriser avec le libellé de la nomenclature associée. Dans le cas où un
   *système n&#39;est pas en mesure de reconnaître un code, il peut choisir
   *d&#39;afficher le libellé qui est obligatoirement fourni avec le code.
   * @return label
   **/
  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLabel() {
    return label;
  }

  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLabel(String label) {
    this.label = label;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthMotive healthMotive = (HealthMotive)o;
    return Objects.equals(this.code, healthMotive.code) &&
        Objects.equals(this.label, healthMotive.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthMotive {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
