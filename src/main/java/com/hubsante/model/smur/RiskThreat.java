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

package com.hubsante.model.smur;

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
 * RiskThreat
 */
@JsonPropertyOrder({RiskThreat.JSON_PROPERTY_CODE,
                    RiskThreat.JSON_PROPERTY_LABEL,
                    RiskThreat.JSON_PROPERTY_FREETEXT})
@JsonTypeName("riskThreat")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class RiskThreat {

  /**
   * A valoriser avec un code la nomenclature associée
   */
  public enum CodeEnum {
    R01("R01"),

    R02("R02"),

    R03("R03"),

    R04("R04"),

    R05("R05"),

    R06("R06"),

    R07("R07"),

    R08("R08"),

    R09("R09"),

    R10("R10"),

    R11("R11"),

    R12("R12"),

    R13("R13"),

    R14("R14"),

    R15("R15"),

    R16("R16"),

    R17("R17"),

    R18("R18"),

    R19("R19"),

    R20("R20"),

    R21("R21"),

    R22("R22"),

    R23("R23"),

    R24("R24"),

    R25("R25"),

    R26("R26"),

    R27("R27"),

    R28("R28"),

    R29("R29"),

    R30("R30"),

    R31("R31"),

    R32("R32"),

    R33("R33"),

    R34("R34"),

    R35("R35"),

    R36("R36"),

    R37("R37");

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

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public RiskThreat() {}

  public RiskThreat code(CodeEnum code) {

    this.code = code;
    return this;
  }

  /**
   * A valoriser avec un code la nomenclature associée
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

  public RiskThreat label(String label) {

    this.label = label;
    return this;
  }

  /**
   * A valoriser avec le libellé de la nomenclature associée. Dans le cas où un
   *système n&#39;est pas en mesure de reconnaître un code, il peut directement
   *afficher le libellé qui est obligatoirement fourni avec le code.
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

  public RiskThreat freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Commentaire libre permettant de passer des informations complémentaires
   *associées à la nomenclature
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFreetext() {
    return freetext;
  }

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(String freetext) {
    this.freetext = freetext;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RiskThreat riskThreat = (RiskThreat)o;
    return Objects.equals(this.code, riskThreat.code) &&
        Objects.equals(this.label, riskThreat.label) &&
        Objects.equals(this.freetext, riskThreat.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, label, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RiskThreat {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
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
