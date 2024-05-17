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
import com.hubsante.model.smur.Access;
import com.hubsante.model.smur.City;
import com.hubsante.model.smur.DetailedAddress;
import com.hubsante.model.smur.ExternalInfo;
import com.hubsante.model.smur.ExternalLocationId;
import com.hubsante.model.smur.Geometry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Location
 */
@JsonPropertyOrder(
    {Location.JSON_PROPERTY_LOC_I_D, Location.JSON_PROPERTY_LOC_LABEL,
     Location.JSON_PROPERTY_NAME, Location.JSON_PROPERTY_EXTERNAL_LOCATION_ID,
     Location.JSON_PROPERTY_DETAILED_ADDRESS, Location.JSON_PROPERTY_CITY,
     Location.JSON_PROPERTY_ACCESS, Location.JSON_PROPERTY_GEOMETRY,
     Location.JSON_PROPERTY_EXTERNAL_INFO})
@JsonTypeName("location")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Location {
  public static final String JSON_PROPERTY_LOC_I_D = "locID";
  private String locID;

  public static final String JSON_PROPERTY_LOC_LABEL = "locLabel";
  private String locLabel;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_EXTERNAL_LOCATION_ID =
      "externalLocationId";
  private List<ExternalLocationId> externalLocationId;

  public static final String JSON_PROPERTY_DETAILED_ADDRESS = "detailedAddress";
  private DetailedAddress detailedAddress;

  public static final String JSON_PROPERTY_CITY = "city";
  private City city;

  public static final String JSON_PROPERTY_ACCESS = "access";
  private Access access;

  public static final String JSON_PROPERTY_GEOMETRY = "geometry";
  private Geometry geometry;

  public static final String JSON_PROPERTY_EXTERNAL_INFO = "externalInfo";
  private List<ExternalInfo> externalInfo;

  public Location() {}

  public Location locID(String locID) {

    this.locID = locID;
    return this;
  }

  /**
   * ID technique et provisoire permettant d&#39;identifier le lieu dans le
   *cadre des échanges de cette affaire.
   * @return locID
   **/
  @JsonProperty(JSON_PROPERTY_LOC_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLocID() {
    return locID;
  }

  @JsonProperty(JSON_PROPERTY_LOC_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLocID(String locID) {
    this.locID = locID;
  }

  public Location locLabel(String locLabel) {

    this.locLabel = locLabel;
    return this;
  }

  /**
   * Permet d&#39;indiquer des indications auto suffisantes permettant pour un
   *opérationnel d&#39;accéder facilement au lieu avec des indications
   *minimales. Dans les messages NexSIS, va souvent correspondre à la
   *concaténation suivant des règles métiers de différentes informations, dont
   *le \&quot;name\&quot; (toponyme) et l&#39;adresse. Comprend au maximum 255
   *caractères
   * @return locLabel
   **/
  @JsonProperty(JSON_PROPERTY_LOC_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLocLabel() {
    return locLabel;
  }

  @JsonProperty(JSON_PROPERTY_LOC_LABEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocLabel(String locLabel) {
    this.locLabel = locLabel;
  }

  public Location name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Indique le nom de lieu : nom commercial, Etablissement, forêt de
   *Fontainebleau, lac du Der (plutôt à destination des systèmes).
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

  public Location
  externalLocationId(List<ExternalLocationId> externalLocationId) {

    this.externalLocationId = externalLocationId;
    return this;
  }

  public Location
  addExternalLocationIdItem(ExternalLocationId externalLocationIdItem) {
    if (this.externalLocationId == null) {
      this.externalLocationId = new ArrayList<>();
    }
    this.externalLocationId.add(externalLocationIdItem);
    return this;
  }

  /**
   * Get externalLocationId
   * @return externalLocationId
   **/
  @JsonProperty(JSON_PROPERTY_EXTERNAL_LOCATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalLocationId> getExternalLocationId() {
    return externalLocationId;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_EXTERNAL_LOCATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void
  setExternalLocationId(List<ExternalLocationId> externalLocationId) {
    if (externalLocationId == null) {
      return;
    }
    if (this.externalLocationId == null) {
      this.externalLocationId = new ArrayList<>();
    }
    this.externalLocationId.addAll(externalLocationId);
  }

  public Location detailedAddress(DetailedAddress detailedAddress) {

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

  public Location city(City city) {

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

  public Location access(Access access) {

    this.access = access;
    return this;
  }

  /**
   * Get access
   * @return access
   **/
  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Access getAccess() {
    return access;
  }

  @JsonProperty(JSON_PROPERTY_ACCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccess(Access access) {
    this.access = access;
  }

  public Location geometry(Geometry geometry) {

    this.geometry = geometry;
    return this;
  }

  /**
   * Get geometry
   * @return geometry
   **/
  @JsonProperty(JSON_PROPERTY_GEOMETRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Geometry getGeometry() {
    return geometry;
  }

  @JsonProperty(JSON_PROPERTY_GEOMETRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGeometry(Geometry geometry) {
    this.geometry = geometry;
  }

  public Location externalInfo(List<ExternalInfo> externalInfo) {

    this.externalInfo = externalInfo;
    return this;
  }

  public Location addExternalInfoItem(ExternalInfo externalInfoItem) {
    if (this.externalInfo == null) {
      this.externalInfo = new ArrayList<>();
    }
    this.externalInfo.add(externalInfoItem);
    return this;
  }

  /**
   * Get externalInfo
   * @return externalInfo
   **/
  @JsonProperty(JSON_PROPERTY_EXTERNAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalInfo> getExternalInfo() {
    return externalInfo;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_EXTERNAL_INFO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalInfo(List<ExternalInfo> externalInfo) {
    if (externalInfo == null) {
      return;
    }
    if (this.externalInfo == null) {
      this.externalInfo = new ArrayList<>();
    }
    this.externalInfo.addAll(externalInfo);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location)o;
    return Objects.equals(this.locID, location.locID) &&
        Objects.equals(this.locLabel, location.locLabel) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.externalLocationId, location.externalLocationId) &&
        Objects.equals(this.detailedAddress, location.detailedAddress) &&
        Objects.equals(this.city, location.city) &&
        Objects.equals(this.access, location.access) &&
        Objects.equals(this.geometry, location.geometry) &&
        Objects.equals(this.externalInfo, location.externalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locID, locLabel, name, externalLocationId,
                        detailedAddress, city, access, geometry, externalInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    sb.append("    locID: ").append(toIndentedString(locID)).append("\n");
    sb.append("    locLabel: ").append(toIndentedString(locLabel)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    externalLocationId: ")
        .append(toIndentedString(externalLocationId))
        .append("\n");
    sb.append("    detailedAddress: ")
        .append(toIndentedString(detailedAddress))
        .append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    access: ").append(toIndentedString(access)).append("\n");
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    externalInfo: ")
        .append(toIndentedString(externalInfo))
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
