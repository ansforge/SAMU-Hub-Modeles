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

package com.hubsante.model.cisu;

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
 * Destination
 */
@JsonPropertyOrder(
    {Destination.JSON_PROPERTY_TYPE, Destination.JSON_PROPERTY_FACILITY,
     Destination.JSON_PROPERTY_ADMIN_FINESS,
     Destination.JSON_PROPERTY_GEO_FINESS, Destination.JSON_PROPERTY_SERVICE,
     Destination.JSON_PROPERTY_FREETEXT})
@JsonTypeName("destination")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Destination {

  /**
   * Indique le type de destination de la ressource : service d’urgences d’un
   * Etablissement de santé, autres services d’un établissement de santé,
   * cabinet d’un professionnel de santé, domicile personnel, EPHAD ou long
   * séjour, autre
   */
  public enum TypeEnum {
    SERVICE_D_URGENCES_D_UN_ETABLISSEMENT_DE_SANT_(
        "service d’urgences d’un Etablissement de santé"),

    AUTRES_SERVICES_D_UN_TABLISSEMENT_DE_SANT_(
        "autres services d’un établissement de santé"),

    CABINET_D_UN_PROFESSIONNEL_DE_SANT_("cabinet d’un professionnel de santé"),

    DOMICILE_PERSONNEL("domicile personnel"),

    EPHAD_OU_LONG_S_JOUR("EPHAD ou long séjour"),

    AUTRE("autre");

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

  public static final String JSON_PROPERTY_FACILITY = "facility";
  private String facility;

  public static final String JSON_PROPERTY_ADMIN_FINESS = "adminFiness";
  private String adminFiness;

  public static final String JSON_PROPERTY_GEO_FINESS = "geoFiness";
  private String geoFiness;

  public static final String JSON_PROPERTY_SERVICE = "service";
  private String service;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public Destination() {}

  public Destination type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Indique le type de destination de la ressource : service d’urgences d’un
   *Etablissement de santé, autres services d’un établissement de santé, cabinet
   *d’un professionnel de santé, domicile personnel, EPHAD ou long séjour, autre
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Destination facility(String facility) {

    this.facility = facility;
    return this;
  }

  /**
   * Nom de l&#39;établissement
   * @return facility
   **/
  @JsonProperty(JSON_PROPERTY_FACILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFacility() {
    return facility;
  }

  @JsonProperty(JSON_PROPERTY_FACILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFacility(String facility) {
    this.facility = facility;
  }

  public Destination adminFiness(String adminFiness) {

    this.adminFiness = adminFiness;
    return this;
  }

  /**
   * N° Finess administratif de l&#39;établissement
   * @return adminFiness
   **/
  @JsonProperty(JSON_PROPERTY_ADMIN_FINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAdminFiness() {
    return adminFiness;
  }

  @JsonProperty(JSON_PROPERTY_ADMIN_FINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdminFiness(String adminFiness) {
    this.adminFiness = adminFiness;
  }

  public Destination geoFiness(String geoFiness) {

    this.geoFiness = geoFiness;
    return this;
  }

  /**
   * N° Finess géographique de l&#39;établissement
   * @return geoFiness
   **/
  @JsonProperty(JSON_PROPERTY_GEO_FINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGeoFiness() {
    return geoFiness;
  }

  @JsonProperty(JSON_PROPERTY_GEO_FINESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGeoFiness(String geoFiness) {
    this.geoFiness = geoFiness;
  }

  public Destination service(String service) {

    this.service = service;
    return this;
  }

  /**
   * Service concerné par l&#39;admission du patient
   * @return service
   **/
  @JsonProperty(JSON_PROPERTY_SERVICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getService() {
    return service;
  }

  @JsonProperty(JSON_PROPERTY_SERVICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setService(String service) {
    this.service = service;
  }

  public Destination freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Get freetext
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFreetext() {
    return freetext;
  }

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(String freetext) {
    this.freetext = freetext;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Destination destination = (Destination)o;
    return Objects.equals(this.type, destination.type) &&
        Objects.equals(this.facility, destination.facility) &&
        Objects.equals(this.adminFiness, destination.adminFiness) &&
        Objects.equals(this.geoFiness, destination.geoFiness) &&
        Objects.equals(this.service, destination.service) &&
        Objects.equals(this.freetext, destination.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, facility, adminFiness, geoFiness, service,
                        freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Destination {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    facility: ").append(toIndentedString(facility)).append("\n");
    sb.append("    adminFiness: ")
        .append(toIndentedString(adminFiness))
        .append("\n");
    sb.append("    geoFiness: ")
        .append(toIndentedString(geoFiness))
        .append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
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
