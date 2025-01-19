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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.DetailedName;
import com.hubsante.model.health.PersonalContact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GeneralPractitioner
 */
@JsonPropertyOrder({GeneralPractitioner.JSON_PROPERTY_DETAILED_NAME,
                    GeneralPractitioner.JSON_PROPERTY_RPPS_ID,
                    GeneralPractitioner.JSON_PROPERTY_CONTACT})
@JsonTypeName("generalPractitioner")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GeneralPractitioner {
  public static final String JSON_PROPERTY_DETAILED_NAME = "detailedName";
  private DetailedName detailedName;

  public static final String JSON_PROPERTY_RPPS_ID = "rppsId";
  private String rppsId;

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private List<PersonalContact> contact = new ArrayList<>();

  public GeneralPractitioner() {}

  public GeneralPractitioner detailedName(DetailedName detailedName) {

    this.detailedName = detailedName;
    return this;
  }

  /**
   * Get detailedName
   * @return detailedName
   **/
  @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DetailedName getDetailedName() {
    return detailedName;
  }

  @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetailedName(DetailedName detailedName) {
    this.detailedName = detailedName;
  }

  public GeneralPractitioner rppsId(String rppsId) {

    this.rppsId = rppsId;
    return this;
  }

  /**
   * Numéro RPPS du médecin traitant
   * @return rppsId
   **/
  @JsonProperty(JSON_PROPERTY_RPPS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRppsId() {
    return rppsId;
  }

  @JsonProperty(JSON_PROPERTY_RPPS_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRppsId(String rppsId) {
    this.rppsId = rppsId;
  }

  public GeneralPractitioner contact(List<PersonalContact> contact) {

    this.contact = contact;
    return this;
  }

  public GeneralPractitioner addcontactItem(PersonalContact contactItem) {
    if (this.contact == null) {
      this.contact = new ArrayList<>();
    }
    this.contact.add(contactItem);
    return this;
  }

  /**
   * Get contact
   * @return contact
   **/
  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PersonalContact> getContact() {
    return contact;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContact(List<PersonalContact> contact) {
    if (contact == null) {
      return;
    }
    if (this.contact == null) {
      this.contact = new ArrayList<>();
    }
    this.contact.addAll(contact);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeneralPractitioner generalPractitioner = (GeneralPractitioner)o;
    return Objects.equals(this.detailedName,
                          generalPractitioner.detailedName) &&
        Objects.equals(this.rppsId, generalPractitioner.rppsId) &&
        Objects.equals(this.contact, generalPractitioner.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailedName, rppsId, contact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralPractitioner {\n");
    sb.append("    detailedName: ")
        .append(toIndentedString(detailedName))
        .append("\n");
    sb.append("    rppsId: ").append(toIndentedString(rppsId)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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
