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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * WayName
 */
@JsonPropertyOrder({WayName.JSON_PROPERTY_COMPLETE, WayName.JSON_PROPERTY_TYPE,
                    WayName.JSON_PROPERTY_NAME})
@JsonTypeName("wayName")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class WayName {
  public static final String JSON_PROPERTY_COMPLETE = "complete";
  private String complete;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public WayName() {}

  public WayName complete(String complete) {

    this.complete = complete;
    return this;
  }

  /**
   * A valoriser avec le type et le nom de la voie. Si les attributs
   *\&quot;type\&quot; et \&quot;name\&quot; de \&quot;wayName\&quot; sont
   *également renseignés, alors \&quot;complete\&quot; doit être valorisé ainsi
   *: \&quot;{type} {nom}\&quot;.
   * @return complete
   **/
  @JsonProperty(JSON_PROPERTY_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getComplete() {
    return complete;
  }

  @JsonProperty(JSON_PROPERTY_COMPLETE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setComplete(String complete) {
    this.complete = complete;
  }

  public WayName type(String type) {

    this.type = type;
    return this;
  }

  /**
   * A valoriser avec le type de la voie
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }

  public WayName name(String name) {

    this.name = name;
    return this;
  }

  /**
   * A valoriser avec le nom de la voie
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WayName wayName = (WayName)o;
    return Objects.equals(this.complete, wayName.complete) &&
        Objects.equals(this.type, wayName.type) &&
        Objects.equals(this.name, wayName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complete, type, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WayName {\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
