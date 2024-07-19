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

package com.hubsante.model.rpis;

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
 * WhatsHappen
 */
@JsonPropertyOrder(
    {WhatsHappen.JSON_PROPERTY_CODE, WhatsHappen.JSON_PROPERTY_LABEL})
@JsonTypeName("whatsHappen")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class WhatsHappen {

  /**
   * A valoriser avec le code de la nomenclature associée.
   */
  public enum CodeEnum {
    C01_00_00("C01.00.00"),

    C01_01_00("C01.01.00"),

    C01_01_01("C01.01.01"),

    C01_01_02("C01.01.02"),

    C01_01_03("C01.01.03"),

    C01_01_04("C01.01.04"),

    C01_01_05("C01.01.05"),

    C01_01_06("C01.01.06"),

    C01_02_00("C01.02.00"),

    C01_02_01("C01.02.01"),

    C01_02_02("C01.02.02"),

    C01_03_00("C01.03.00"),

    C01_03_01("C01.03.01"),

    C01_03_02("C01.03.02"),

    C01_04_00("C01.04.00"),

    C01_04_01("C01.04.01"),

    C01_04_02("C01.04.02"),

    C01_04_03("C01.04.03"),

    C01_04_04("C01.04.04"),

    C01_05_00("C01.05.00"),

    C02_00_00("C02.00.00"),

    C02_01_00("C02.01.00"),

    C02_02_00("C02.02.00"),

    C02_03_00("C02.03.00"),

    C02_03_01("C02.03.01"),

    C02_03_02("C02.03.02"),

    C02_04_00("C02.04.00"),

    C02_04_01("C02.04.01"),

    C02_04_02("C02.04.02"),

    C02_04_03("C02.04.03"),

    C02_05_00("C02.05.00"),

    C02_05_01("C02.05.01"),

    C02_05_02("C02.05.02"),

    C02_05_03("C02.05.03"),

    C02_06_00("C02.06.00"),

    C02_06_01("C02.06.01"),

    C02_07_00("C02.07.00"),

    C02_07_01("C02.07.01"),

    C02_07_02("C02.07.02"),

    C02_07_03("C02.07.03"),

    C02_07_04("C02.07.04"),

    C02_07_05("C02.07.05"),

    C02_08_00("C02.08.00"),

    C02_08_01("C02.08.01"),

    C02_08_02("C02.08.02"),

    C02_08_03("C02.08.03"),

    C02_08_04("C02.08.04"),

    C02_08_05("C02.08.05"),

    C02_08_06("C02.08.06"),

    C02_08_07("C02.08.07"),

    C02_08_08("C02.08.08"),

    C02_09_00("C02.09.00"),

    C02_09_01("C02.09.01"),

    C02_09_02("C02.09.02"),

    C02_09_03("C02.09.03"),

    C02_09_04("C02.09.04"),

    C02_09_05("C02.09.05"),

    C02_09_06("C02.09.06"),

    C02_09_07("C02.09.07"),

    C02_10_00("C02.10.00"),

    C02_11_00("C02.11.00"),

    C02_11_01("C02.11.01"),

    C02_11_02("C02.11.02"),

    C02_12_00("C02.12.00"),

    C02_13_00("C02.13.00"),

    C02_13_01("C02.13.01"),

    C02_13_02("C02.13.02"),

    C02_13_03("C02.13.03"),

    C02_13_04("C02.13.04"),

    C02_13_05("C02.13.05"),

    C02_13_06("C02.13.06"),

    C02_13_07("C02.13.07"),

    C02_13_08("C02.13.08"),

    C02_14_00("C02.14.00"),

    C02_14_01("C02.14.01"),

    C02_14_02("C02.14.02"),

    C02_14_03("C02.14.03"),

    C02_14_04("C02.14.04"),

    C02_14_002("C02.14.00"),

    C02_14_012("C02.14.01"),

    C02_14_022("C02.14.02"),

    C02_14_032("C02.14.03"),

    C02_14_042("C02.14.04"),

    C02_14_05("C02.14.05"),

    C02_14_06("C02.14.06"),

    C02_15_00("C02.15.00"),

    C02_15_01("C02.15.01"),

    C02_15_02("C02.15.02"),

    C02_15_03("C02.15.03"),

    C03_00_00("C03.00.00"),

    C03_01_00("C03.01.00"),

    C03_01_01("C03.01.01"),

    C03_01_02("C03.01.02"),

    C03_01_03("C03.01.03"),

    C03_01_04("C03.01.04"),

    C03_01_05("C03.01.05"),

    C03_02_00("C03.02.00"),

    C03_02_01("C03.02.01"),

    C03_02_02("C03.02.02"),

    C03_02_03("C03.02.03"),

    C03_02_04("C03.02.04"),

    C03_02_05("C03.02.05"),

    C03_02_06("C03.02.06"),

    C03_02_07("C03.02.07"),

    C03_02_08("C03.02.08"),

    C03_02_09("C03.02.09"),

    C03_02_10("C03.02.10"),

    C03_02_11("C03.02.11"),

    C03_02_12("C03.02.12"),

    C03_02_13("C03.02.13"),

    C03_02_14("C03.02.14"),

    C03_02_15("C03.02.15"),

    C03_03_00("C03.03.00"),

    C03_03_01("C03.03.01"),

    C03_03_02("C03.03.02"),

    C03_04_00("C03.04.00"),

    C03_04_01("C03.04.01"),

    C03_04_02("C03.04.02"),

    C03_05_00("C03.05.00"),

    C03_06_00("C03.06.00"),

    C03_07_00("C03.07.00"),

    C03_08_00("C03.08.00"),

    C03_09_00("C03.09.00"),

    C03_10_00("C03.10.00"),

    C03_11_00("C03.11.00"),

    C03_12_00("C03.12.00"),

    C03_13_00("C03.13.00"),

    C03_14_00("C03.14.00"),

    C03_15_00("C03.15.00"),

    C04_00_00("C04.00.00"),

    C04_01_00("C04.01.00"),

    C04_01_01("C04.01.01"),

    C04_01_02("C04.01.02"),

    C04_01_03("C04.01.03"),

    C04_01_04("C04.01.04"),

    C04_01_05("C04.01.05"),

    C04_01_06("C04.01.06"),

    C04_01_07("C04.01.07"),

    C04_01_08("C04.01.08"),

    C04_01_09("C04.01.09"),

    C04_01_10("C04.01.10"),

    C04_01_11("C04.01.11"),

    C04_02_00("C04.02.00"),

    C04_02_01("C04.02.01"),

    C04_02_02("C04.02.02"),

    C04_02_03("C04.02.03"),

    C04_02_04("C04.02.04"),

    C04_03_00("C04.03.00"),

    C04_04_00("C04.04.00"),

    C04_05_00("C04.05.00"),

    C04_06_00("C04.06.00"),

    C04_07_00("C04.07.00"),

    C04_07_01("C04.07.01"),

    C04_07_02("C04.07.02"),

    C04_07_03("C04.07.03"),

    C04_07_04("C04.07.04"),

    C04_08_00("C04.08.00"),

    C04_09_00("C04.09.00"),

    C05_00_00("C05.00.00"),

    C05_00_01("C05.00.01"),

    C05_00_02("C05.00.02"),

    C05_00_03("C05.00.03"),

    C05_00_04("C05.00.04"),

    C05_00_05("C05.00.05"),

    C06_00_00("C06.00.00"),

    C06_01_00("C06.01.00"),

    C06_02_00("C06.02.00"),

    C06_03_00("C06.03.00"),

    C06_03_01("C06.03.01"),

    C06_03_02("C06.03.02"),

    C06_03_03("C06.03.03"),

    C06_03_04("C06.03.04"),

    C06_03_05("C06.03.05"),

    C06_03_06("C06.03.06"),

    C06_04_00("C06.04.00"),

    C06_04_01("C06.04.01"),

    C06_04_02("C06.04.02"),

    C06_05_00("C06.05.00"),

    C06_06_00("C06.06.00"),

    C06_06_01("C06.06.01"),

    C06_07_00("C06.07.00"),

    C06_07_01("C06.07.01"),

    C06_07_02("C06.07.02"),

    C06_08_00("C06.08.00"),

    C06_08_01("C06.08.01"),

    C06_08_02("C06.08.02"),

    C06_08_03("C06.08.03"),

    C06_08_04("C06.08.04"),

    C06_08_05("C06.08.05"),

    C06_08_06("C06.08.06"),

    C07_00_00("C07.00.00"),

    C07_01_00("C07.01.00"),

    C07_02_00("C07.02.00"),

    C07_03_00("C07.03.00"),

    C07_03_01("C07.03.01"),

    C07_03_02("C07.03.02"),

    C07_03_03("C07.03.03"),

    C07_03_04("C07.03.04"),

    C07_03_05("C07.03.05"),

    C07_04_00("C07.04.00"),

    C07_04_01("C07.04.01"),

    C07_04_02("C07.04.02"),

    C07_04_03("C07.04.03"),

    C07_04_04("C07.04.04"),

    C07_05_00("C07.05.00"),

    C07_06_00("C07.06.00"),

    C07_07_00("C07.07.00"),

    C07_07_01("C07.07.01"),

    C07_07_02("C07.07.02"),

    C07_07_03("C07.07.03"),

    C07_07_04("C07.07.04"),

    C07_07_05("C07.07.05"),

    C07_08_00("C07.08.00"),

    C07_08_01("C07.08.01"),

    C07_08_02("C07.08.02"),

    C07_08_03("C07.08.03"),

    C07_09_00("C07.09.00"),

    C07_09_01("C07.09.01"),

    C07_09_02("C07.09.02"),

    C07_09_03("C07.09.03"),

    C07_09_05("C07.09.05"),

    C07_10_00("C07.10.00"),

    C07_11_00("C07.11.00"),

    C07_12_00("C07.12.00"),

    C07_13_00("C07.13.00"),

    C07_13_01("C07.13.01"),

    C07_13_02("C07.13.02"),

    C07_13_03("C07.13.03"),

    C07_13_04("C07.13.04"),

    C07_13_05("C07.13.05"),

    C07_13_06("C07.13.06"),

    C07_13_07("C07.13.07"),

    C08_00_00("C08.00.00"),

    C08_01_00("C08.01.00"),

    C08_02_00("C08.02.00"),

    C08_03_00("C08.03.00"),

    C08_04_00("C08.04.00"),

    C08_05_00("C08.05.00"),

    C08_06_00("C08.06.00"),

    C08_07_00("C08.07.00"),

    C08_08_00("C08.08.00"),

    C08_08_01("C08.08.01"),

    C08_08_02("C08.08.02"),

    C08_09_00("C08.09.00"),

    C08_10_00("C08.10.00"),

    C08_10_01("C08.10.01"),

    C09_00_00("C09.00.00"),

    C09_01_00("C09.01.00"),

    C09_01_01("C09.01.01"),

    C09_01_02("C09.01.02"),

    C09_01_03("C09.01.03"),

    C09_01_04("C09.01.04"),

    C09_02_00("C09.02.00"),

    C09_03_00("C09.03.00"),

    C09_03_01("C09.03.01"),

    C09_04_00("C09.04.00"),

    C09_04_01("C09.04.01"),

    C09_04_02("C09.04.02"),

    C09_05_00("C09.05.00"),

    C09_06_00("C09.06.00"),

    C09_07_00("C09.07.00"),

    C09_08_00("C09.08.00"),

    C10_00_00("C10.00.00"),

    C10_01_00("C10.01.00"),

    C10_01_01("C10.01.01"),

    C10_01_02("C10.01.02"),

    C10_01_03("C10.01.03"),

    C10_01_04("C10.01.04"),

    C10_01_05("C10.01.05"),

    C10_01_06("C10.01.06"),

    C10_01_07("C10.01.07"),

    C10_01_08("C10.01.08"),

    C10_02_00("C10.02.00"),

    C10_02_01("C10.02.01"),

    C10_02_02("C10.02.02"),

    C10_03_00("C10.03.00"),

    C10_03_01("C10.03.01"),

    C10_03_02("C10.03.02"),

    C10_04_00("C10.04.00"),

    C10_04_01("C10.04.01"),

    C10_04_02("C10.04.02"),

    C10_05_00("C10.05.00"),

    C10_06_00("C10.06.00"),

    C10_07_00("C10.07.00"),

    C10_08_00("C10.08.00"),

    C11_00_00("C11.00.00"),

    C11_01_00("C11.01.00"),

    C11_02_00("C11.02.00"),

    C11_02_01("C11.02.01"),

    C11_02_02("C11.02.02"),

    C11_03_00("C11.03.00"),

    C11_03_01("C11.03.01"),

    C11_03_02("C11.03.02"),

    C11_04_00("C11.04.00"),

    C11_05_00("C11.05.00"),

    C11_05_01("C11.05.01"),

    C11_05_02("C11.05.02"),

    C11_05_03("C11.05.03"),

    C11_06_00("C11.06.00");

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

  public WhatsHappen() {}

  public WhatsHappen code(CodeEnum code) {

    this.code = code;
    return this;
  }

  /**
   * A valoriser avec le code de la nomenclature associée.
   * @return code
   **/
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CodeEnum getCode() {
    return code;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(CodeEnum code) {
    this.code = code;
  }

  public WhatsHappen label(String label) {

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
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLabel() {
    return label;
  }

  @JsonProperty(JSON_PROPERTY_LABEL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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
    WhatsHappen whatsHappen = (WhatsHappen)o;
    return Objects.equals(this.code, whatsHappen.code) &&
        Objects.equals(this.label, whatsHappen.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WhatsHappen {\n");
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
