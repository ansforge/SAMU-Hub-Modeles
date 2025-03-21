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
import com.hubsante.model.health.DetailedName;
import com.hubsante.model.health.InsStrictFeatures;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Identity
 */
@JsonPropertyOrder({Identity.JSON_PROPERTY_STRICT_FEATURES,
                    Identity.JSON_PROPERTY_NON_STRICT_FEATURES})
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Identity {
  public static final String JSON_PROPERTY_STRICT_FEATURES = "strictFeatures";
  private InsStrictFeatures strictFeatures;

  public static final String JSON_PROPERTY_NON_STRICT_FEATURES =
      "nonStrictFeatures";
  private DetailedName nonStrictFeatures;

  public Identity() {}

  public Identity strictFeatures(InsStrictFeatures strictFeatures) {

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

  public Identity nonStrictFeatures(DetailedName nonStrictFeatures) {

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
    Identity identity = (Identity)o;
    return Objects.equals(this.strictFeatures, identity.strictFeatures) &&
        Objects.equals(this.nonStrictFeatures, identity.nonStrictFeatures);
  }

  @Override
  public int hashCode() {
    return Objects.hash(strictFeatures, nonStrictFeatures);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identity {\n");
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
