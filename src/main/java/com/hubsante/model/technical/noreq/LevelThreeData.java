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

package com.hubsante.model.technical.noreq;

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
 * LevelThreeData
 */
@JsonPropertyOrder({LevelThreeData.JSON_PROPERTY_STRING_LEVEL4})
@JsonTypeName("levelThreeData")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class LevelThreeData {
  public static final String JSON_PROPERTY_STRING_LEVEL4 = "stringLevel4";
  private String stringLevel4;

  public LevelThreeData() {}

  public LevelThreeData stringLevel4(String stringLevel4) {

    this.stringLevel4 = stringLevel4;
    return this;
  }

  /**
   * String field at level 4
   * @return stringLevel4
   **/
  @JsonProperty(JSON_PROPERTY_STRING_LEVEL4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStringLevel4() {
    return stringLevel4;
  }

  @JsonProperty(JSON_PROPERTY_STRING_LEVEL4)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStringLevel4(String stringLevel4) {
    this.stringLevel4 = stringLevel4;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LevelThreeData levelThreeData = (LevelThreeData)o;
    return Objects.equals(this.stringLevel4, levelThreeData.stringLevel4);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stringLevel4);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LevelThreeData {\n");
    sb.append("    stringLevel4: ")
        .append(toIndentedString(stringLevel4))
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
