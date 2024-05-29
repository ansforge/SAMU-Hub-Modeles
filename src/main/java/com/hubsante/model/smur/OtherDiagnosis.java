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
 * OtherDiagnosis
 */
@JsonPropertyOrder(
    {OtherDiagnosis.JSON_PROPERTY_CODE, OtherDiagnosis.JSON_PROPERTY_LABEL})
@JsonTypeName("otherDiagnosis")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class OtherDiagnosis {
  public static final String JSON_PROPERTY_CODE = "code";
  private String code;

  public static final String JSON_PROPERTY_LABEL = "label";
  private String label;

  public OtherDiagnosis() {}

  public OtherDiagnosis code(String code) {

    this.code = code;
    return this;
  }

  /**
   * A valoriser avec un code la nomenclature associée
   * @return code
   **/
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCode() {
    return code;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(String code) {
    this.code = code;
  }

  public OtherDiagnosis label(String label) {

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtherDiagnosis otherDiagnosis = (OtherDiagnosis)o;
    return Objects.equals(this.code, otherDiagnosis.code) &&
        Objects.equals(this.label, otherDiagnosis.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OtherDiagnosis {\n");
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
