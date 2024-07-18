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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * SecondLevelTwoData
 */
@JsonPropertyOrder({SecondLevelTwoData.JSON_PROPERTY_OBJECT2_LEVEL3})
@JsonTypeName("secondLevelTwoData")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class SecondLevelTwoData {
  public static final String JSON_PROPERTY_OBJECT2_LEVEL3 = "object2Level3";
  private Object object2Level3;

  public SecondLevelTwoData() {}

  public SecondLevelTwoData object2Level3(Object object2Level3) {

    this.object2Level3 = object2Level3;
    return this;
  }

  /**
   * Get object2Level3
   * @return object2Level3
   **/
  @JsonProperty(JSON_PROPERTY_OBJECT2_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Object getObject2Level3() {
    return object2Level3;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT2_LEVEL3)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObject2Level3(Object object2Level3) {
    this.object2Level3 = object2Level3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecondLevelTwoData secondLevelTwoData = (SecondLevelTwoData)o;
    return Objects.equals(this.object2Level3, secondLevelTwoData.object2Level3);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object2Level3);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecondLevelTwoData {\n");
    sb.append("    object2Level3: ")
        .append(toIndentedString(object2Level3))
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
