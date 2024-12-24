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
 * OpenAPI
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
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
import com.hubsante.model.technical.LevelThreeData;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * LevelTwoData
 */
@JsonPropertyOrder({LevelTwoData.JSON_PROPERTY_OBJECT1_LEVEL3,
                    LevelTwoData.JSON_PROPERTY_STRING_LEVEL3})
@JsonTypeName("levelTwoData")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class LevelTwoData {
  public static final String JSON_PROPERTY_OBJECT1_LEVEL3 = "object1Level3";
  private LevelThreeData object1Level3;

  public static final String JSON_PROPERTY_STRING_LEVEL3 = "stringLevel3";
  private String stringLevel3;

  public LevelTwoData() {}

  public LevelTwoData object1Level3(LevelThreeData object1Level3) {

    this.object1Level3 = object1Level3;
    return this;
  }

  /**
   * Get object1Level3
   * @return object1Level3
   **/
  @JsonProperty(JSON_PROPERTY_OBJECT1_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LevelThreeData getObject1Level3() {
    return object1Level3;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT1_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObject1Level3(LevelThreeData object1Level3) {
    this.object1Level3 = object1Level3;
  }

  public LevelTwoData stringLevel3(String stringLevel3) {

    this.stringLevel3 = stringLevel3;
    return this;
  }

  /**
   * String field at level 3
   * @return stringLevel3
   **/
  @JsonProperty(JSON_PROPERTY_STRING_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStringLevel3() {
    return stringLevel3;
  }

  @JsonProperty(JSON_PROPERTY_STRING_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStringLevel3(String stringLevel3) {
    this.stringLevel3 = stringLevel3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LevelTwoData levelTwoData = (LevelTwoData)o;
    return Objects.equals(this.object1Level3, levelTwoData.object1Level3) &&
        Objects.equals(this.stringLevel3, levelTwoData.stringLevel3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object1Level3, stringLevel3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LevelTwoData {\n");
    sb.append("    object1Level3: ")
        .append(toIndentedString(object1Level3))
        .append("\n");
    sb.append("    stringLevel3: ")
        .append(toIndentedString(stringLevel3))
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
