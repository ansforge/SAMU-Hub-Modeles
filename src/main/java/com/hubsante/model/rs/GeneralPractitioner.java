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

package com.hubsante.model.rs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.rs.Contact;
import com.hubsante.model.rs.DetailedName;
import com.hubsante.model.rs.PersonalAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GeneralPractitioner
 */
@JsonPropertyOrder({GeneralPractitioner.JSON_PROPERTY_DETAILED_NAME,
                    GeneralPractitioner.JSON_PROPERTY_ID,
                    GeneralPractitioner.JSON_PROPERTY_PERSONAL_ADDRESS,
                    GeneralPractitioner.JSON_PROPERTY_CONTACT})
@JsonTypeName("generalPractitioner")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class GeneralPractitioner {
  public static final String JSON_PROPERTY_DETAILED_NAME = "detailedName";
  private DetailedName detailedName;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PERSONAL_ADDRESS = "personalAddress";
  private PersonalAddress personalAddress;

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private List<Contact> contact;

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

  public GeneralPractitioner id(String id) {

    this.id = id;
    return this;
  }

  /**
   * Numéro RPPS du médecin traitant
   * @return id
   **/
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  public GeneralPractitioner personalAddress(PersonalAddress personalAddress) {

    this.personalAddress = personalAddress;
    return this;
  }

  /**
   * Get personalAddress
   * @return personalAddress
   **/
  @JsonProperty(JSON_PROPERTY_PERSONAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PersonalAddress getPersonalAddress() {
    return personalAddress;
  }

  @JsonProperty(JSON_PROPERTY_PERSONAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPersonalAddress(PersonalAddress personalAddress) {
    this.personalAddress = personalAddress;
  }

  public GeneralPractitioner contact(List<Contact> contact) {

    this.contact = contact;
    return this;
  }

  public GeneralPractitioner addContactItem(Contact contactItem) {
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

  public List<Contact> getContact() {
    return contact;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContact(List<Contact> contact) {
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
        Objects.equals(this.id, generalPractitioner.id) &&
        Objects.equals(this.personalAddress,
                       generalPractitioner.personalAddress) &&
        Objects.equals(this.contact, generalPractitioner.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(detailedName, id, personalAddress, contact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeneralPractitioner {\n");
    sb.append("    detailedName: ")
        .append(toIndentedString(detailedName))
        .append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    personalAddress: ")
        .append(toIndentedString(personalAddress))
        .append("\n");
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
