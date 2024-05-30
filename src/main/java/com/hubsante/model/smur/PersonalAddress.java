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
import com.hubsante.model.smur.City;
import com.hubsante.model.smur.DetailedAddress;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * PersonalAddress
 */
@JsonPropertyOrder({PersonalAddress.JSON_PROPERTY_DETAILED_ADDRESS,
                    PersonalAddress.JSON_PROPERTY_CITY})
@JsonTypeName("personalAddress")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class PersonalAddress {
  public static final String JSON_PROPERTY_DETAILED_ADDRESS = "detailedAddress";
  private DetailedAddress detailedAddress;

  public static final String JSON_PROPERTY_CITY = "city";
  private City city;

  public PersonalAddress() {}

  public PersonalAddress detailedAddress(DetailedAddress detailedAddress) {

    this.detailedAddress = detailedAddress;
    return this;
  }

  /**
   * Get detailedAddress
   * @return detailedAddress
   **/
  @JsonProperty(JSON_PROPERTY_DETAILED_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DetailedAddress getDetailedAddress() {
    return detailedAddress;
  }

  @JsonProperty(JSON_PROPERTY_DETAILED_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetailedAddress(DetailedAddress detailedAddress) {
    this.detailedAddress = detailedAddress;
  }

  public PersonalAddress city(City city) {

    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
   **/
  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public City getCity() {
    return city;
  }

  @JsonProperty(JSON_PROPERTY_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCity(City city) {
    this.city = city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonalAddress personalAddress = (PersonalAddress)o;
    return Objects.equals(this.detailedAddress,
                          personalAddress.detailedAddress) &&
        Objects.equals(this.city, personalAddress.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailedAddress, city);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonalAddress {\n");
    sb.append("    detailedAddress: ")
        .append(toIndentedString(detailedAddress))
        .append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
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