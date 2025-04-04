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
 * DetailedName
 */
@JsonPropertyOrder({DetailedName.JSON_PROPERTY_COMPLETE,
                    DetailedName.JSON_PROPERTY_LAST_NAME,
                    DetailedName.JSON_PROPERTY_FIRST_NAME})
@JsonTypeName("detailedName")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class DetailedName {
  public static final String JSON_PROPERTY_COMPLETE = "complete";
  private String complete;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  private String lastName;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public DetailedName() {}

  public DetailedName complete(String complete) {

    this.complete = complete;
    return this;
  }

  /**
   * A valoriser avec le prénom et le nom usuel du requérant/appelant. Si les
   *champs callerLastName et callerFirstName sont également renseignés, le champ
   *callerName doit être valorisé ainsi : \&quot;{callerFirstName}
   *{callerLastName}\&quot;.  Spécificités 15-18  : NexSIS ne dispose que de ces
   *informations (concaténées) et pas de deux champs séparés.
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

  public DetailedName lastName(String lastName) {

    this.lastName = lastName;
    return this;
  }

  /**
   * A valoriser avec le nom usuel du requérant
   * @return lastName
   **/
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastName() {
    return lastName;
  }

  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public DetailedName firstName(String firstName) {

    this.firstName = firstName;
    return this;
  }

  /**
   * A valoriser avec le prénom usuel du réquérant. Par convention les prénoms
   *composés doivent préférablement être séparés par le caractère
   *\&quot;-\&quot;
   * @return firstName
   **/
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFirstName() {
    return firstName;
  }

  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedName detailedName = (DetailedName)o;
    return Objects.equals(this.complete, detailedName.complete) &&
        Objects.equals(this.lastName, detailedName.lastName) &&
        Objects.equals(this.firstName, detailedName.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complete, lastName, firstName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedName {\n");
    sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ")
        .append(toIndentedString(firstName))
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
