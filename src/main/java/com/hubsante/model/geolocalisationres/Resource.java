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

package com.hubsante.model.geolocalisationres;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.geolocalisationres.Contact;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Resource
 */
@JsonPropertyOrder(
    {Resource.JSON_PROPERTY_ID, Resource.JSON_PROPERTY_ORG_ID,
     Resource.JSON_PROPERTY_NAME, Resource.JSON_PROPERTY_TYPE,
     Resource.JSON_PROPERTY_NATURE, Resource.JSON_PROPERTY_MOBILITY,
     Resource.JSON_PROPERTY_CAPACITY, Resource.JSON_PROPERTY_CONTACTS})
@JsonTypeName("resource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Resource {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_ORG_ID = "orgId";
  private String orgId;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  /**
   * Catégorie de la ressource (SMUR, SDIS, TSU, SNP, MSPE, navire)
   */
  public enum TypeEnum {
    SMUR("SMUR"),

    SDIS("SDIS"),

    TSU("TSU"),

    SNP("SNP"),

    MSPE("MSPE"),

    SHIP("SHIP");

    private String value;

    TypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  /**
   * Nature de la ressource (effecteur, base)
   */
  public enum NatureEnum {
    EFFECTEUR("EFFECTEUR"),

    BASE("BASE");

    private String value;

    NatureEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NatureEnum fromValue(String value) {
      for (NatureEnum b : NatureEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_NATURE = "nature";
  private NatureEnum nature;

  /**
   * Mobilité de la ressource (fixe, vehicule, heliporté, navire)
   */
  public enum MobilityEnum {
    FIXE("FIXE"),

    VEHICULE("VEHICULE"),

    HELICOPTERE("HELICOPTERE"),

    SHIP_("SHIP ");

    private String value;

    MobilityEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MobilityEnum fromValue(String value) {
      for (MobilityEnum b : MobilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_MOBILITY = "mobility";
  private MobilityEnum mobility;

  /**
   * Capacité de transport d&#39;un patient
   */
  public enum CapacityEnum {
    URGENCE("URGENCE"),

    MEDICALE("MEDICALE"),

    PARAMEDICALE("PARAMEDICALE"),

    INCONNUE("INCONNUE");

    private String value;

    CapacityEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CapacityEnum fromValue(String value) {
      for (CapacityEnum b : CapacityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_CAPACITY = "capacity";
  private CapacityEnum capacity;

  public static final String JSON_PROPERTY_CONTACTS = "contacts";
  private List<Contact> contacts;

  public Resource() {}

  public Resource id(String id) {

    this.id = id;
    return this;
  }

  /**
   * Identifiant unique de la ressource  dans le système du partenaire
   *propriétaire
   * @return id
   **/
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setId(String id) {
    this.id = id;
  }

  public Resource orgId(String orgId) {

    this.orgId = orgId;
    return this;
  }

  /**
   * Identifiant unique de l&#39;organisme :
   *{pays}.{domaine}.{organisation}.{structure interne}*.{unité fonctionnelle}*
   **données facultatives
   * @return orgId
   **/
  @JsonProperty(JSON_PROPERTY_ORG_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOrgId() {
    return orgId;
  }

  @JsonProperty(JSON_PROPERTY_ORG_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public Resource name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Nom donné à la ressource par l&#39;organisme propriétaire.
   *L&#39;immatriculation peut être utilisée dans le nom courant des véhicules.
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

  public Resource type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Catégorie de la ressource (SMUR, SDIS, TSU, SNP, MSPE, navire)
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Resource nature(NatureEnum nature) {

    this.nature = nature;
    return this;
  }

  /**
   * Nature de la ressource (effecteur, base)
   * @return nature
   **/
  @JsonProperty(JSON_PROPERTY_NATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NatureEnum getNature() {
    return nature;
  }

  @JsonProperty(JSON_PROPERTY_NATURE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNature(NatureEnum nature) {
    this.nature = nature;
  }

  public Resource mobility(MobilityEnum mobility) {

    this.mobility = mobility;
    return this;
  }

  /**
   * Mobilité de la ressource (fixe, vehicule, heliporté, navire)
   * @return mobility
   **/
  @JsonProperty(JSON_PROPERTY_MOBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MobilityEnum getMobility() {
    return mobility;
  }

  @JsonProperty(JSON_PROPERTY_MOBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMobility(MobilityEnum mobility) {
    this.mobility = mobility;
  }

  public Resource capacity(CapacityEnum capacity) {

    this.capacity = capacity;
    return this;
  }

  /**
   * Capacité de transport d&#39;un patient
   * @return capacity
   **/
  @JsonProperty(JSON_PROPERTY_CAPACITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CapacityEnum getCapacity() {
    return capacity;
  }

  @JsonProperty(JSON_PROPERTY_CAPACITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCapacity(CapacityEnum capacity) {
    this.capacity = capacity;
  }

  public Resource contacts(List<Contact> contacts) {

    this.contacts = contacts;
    return this;
  }

  public Resource addContactsItem(Contact contactsItem) {
    if (this.contacts == null) {
      this.contacts = new ArrayList<>();
    }
    this.contacts.add(contactsItem);
    return this;
  }

  /**
   * Get contacts
   * @return contacts
   **/
  @JsonProperty(JSON_PROPERTY_CONTACTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Contact> getContacts() {
    return contacts;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_CONTACTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContacts(List<Contact> contacts) {
    if (contacts == null) {
      return;
    }
    if (this.contacts == null) {
      this.contacts = new ArrayList<>();
    }
    this.contacts.addAll(contacts);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resource resource = (Resource)o;
    return Objects.equals(this.id, resource.id) &&
        Objects.equals(this.orgId, resource.orgId) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.type, resource.type) &&
        Objects.equals(this.nature, resource.nature) &&
        Objects.equals(this.mobility, resource.mobility) &&
        Objects.equals(this.capacity, resource.capacity) &&
        Objects.equals(this.contacts, resource.contacts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orgId, name, type, nature, mobility, capacity,
                        contacts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    nature: ").append(toIndentedString(nature)).append("\n");
    sb.append("    mobility: ").append(toIndentedString(mobility)).append("\n");
    sb.append("    capacity: ").append(toIndentedString(capacity)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
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
