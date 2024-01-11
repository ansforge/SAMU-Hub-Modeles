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
import com.hubsante.model.health.DetailedName;
import com.hubsante.model.health.InsCycle;
import com.hubsante.model.health.InsNumber;
import com.hubsante.model.health.InsStrictFeatures;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * InsIdentity
 */
@JsonPropertyOrder({InsIdentity.JSON_PROPERTY_CYCLE,
                    InsIdentity.JSON_PROPERTY_NUMBER,
                    InsIdentity.JSON_PROPERTY_STRICT_FEATURES,
                    InsIdentity.JSON_PROPERTY_NON_STRICT_FEATURES})
@JsonTypeName("insIdentity")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class InsIdentity {
  public static final String JSON_PROPERTY_CYCLE = "cycle";
  private InsCycle cycle;

  public static final String JSON_PROPERTY_NUMBER = "number";
  private InsNumber number;

  public static final String JSON_PROPERTY_STRICT_FEATURES = "strictFeatures";
  private InsStrictFeatures strictFeatures;

  public static final String JSON_PROPERTY_NON_STRICT_FEATURES =
      "nonStrictFeatures";
  private DetailedName nonStrictFeatures;

  public InsIdentity() {}

  public InsIdentity cycle(InsCycle cycle) {

    this.cycle = cycle;
    return this;
  }

  /**
   * Get cycle
   * @return cycle
   **/
  @JsonProperty(JSON_PROPERTY_CYCLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InsCycle getCycle() {
    return cycle;
  }

  @JsonProperty(JSON_PROPERTY_CYCLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCycle(InsCycle cycle) {
    this.cycle = cycle;
  }

  public InsIdentity number(InsNumber number) {

    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
   **/
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InsNumber getNumber() {
    return number;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(InsNumber number) {
    this.number = number;
  }

  public InsIdentity strictFeatures(InsStrictFeatures strictFeatures) {

    this.strictFeatures = strictFeatures;
    return this;
  }

  /**
   * Get strictFeatures
   * @return strictFeatures
   **/
  @JsonProperty(JSON_PROPERTY_STRICT_FEATURES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public InsStrictFeatures getStrictFeatures() {
    return strictFeatures;
  }

  @JsonProperty(JSON_PROPERTY_STRICT_FEATURES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStrictFeatures(InsStrictFeatures strictFeatures) {
    this.strictFeatures = strictFeatures;
  }

  public InsIdentity nonStrictFeatures(DetailedName nonStrictFeatures) {

    this.nonStrictFeatures = nonStrictFeatures;
    return this;
  }

  /**
   * Get nonStrictFeatures
   * @return nonStrictFeatures
   **/
  @JsonProperty(JSON_PROPERTY_NON_STRICT_FEATURES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DetailedName getNonStrictFeatures() {
    return nonStrictFeatures;
  }

  @JsonProperty(JSON_PROPERTY_NON_STRICT_FEATURES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNonStrictFeatures(DetailedName nonStrictFeatures) {
    this.nonStrictFeatures = nonStrictFeatures;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InsIdentity insIdentity = (InsIdentity)o;
    return Objects.equals(this.cycle, insIdentity.cycle) &&
        Objects.equals(this.number, insIdentity.number) &&
        Objects.equals(this.strictFeatures, insIdentity.strictFeatures) &&
        Objects.equals(this.nonStrictFeatures, insIdentity.nonStrictFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cycle, number, strictFeatures, nonStrictFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InsIdentity {\n");
    sb.append("    cycle: ").append(toIndentedString(cycle)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    strictFeatures: ")
        .append(toIndentedString(strictFeatures))
        .append("\n");
    sb.append("    nonStrictFeatures: ")
        .append(toIndentedString(nonStrictFeatures))
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
