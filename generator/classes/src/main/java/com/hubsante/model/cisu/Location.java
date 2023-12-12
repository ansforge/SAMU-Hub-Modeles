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
import com.hubsante.model.cisu.Access;
import com.hubsante.model.cisu.City;
import com.hubsante.model.cisu.DetailedAdress;
import com.hubsante.model.cisu.ExternalInfo;
import com.hubsante.model.cisu.Geometry;
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
     Location.JSON_PROPERTY_NAME, Location.JSON_PROPERTY_DETAILED_ADRESS,
     Location.JSON_PROPERTY_CITY, Location.JSON_PROPERTY_ACCESS,
     Location.JSON_PROPERTY_GEOMETRY, Location.JSON_PROPERTY_EXTERNAL_INFO,
     Location.JSON_PROPERTY_COUNTRY, Location.JSON_PROPERTY_FREETEXT})
@JsonTypeName("location")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T12:51:21.739399Z[Etc/UTC]")
public class Location {
  public static final String JSON_PROPERTY_LOC_I_D = "locID";
  private String locID;

  public static final String JSON_PROPERTY_LOC_LABEL = "locLabel";
  private String locLabel;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DETAILED_ADRESS = "detailedAdress";
  private DetailedAdress detailedAdress;

  public static final String JSON_PROPERTY_CITY = "city";
  private City city;

  public static final String JSON_PROPERTY_ACCESS = "access";
  private Access access;

  public static final String JSON_PROPERTY_GEOMETRY = "geometry";
  private Geometry geometry;

  public static final String JSON_PROPERTY_EXTERNAL_INFO = "externalInfo";
  private List<ExternalInfo> externalInfo;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private String country;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

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
   * Indique le nom de lieu : nom commercial, forêt de Fontainebleau, lac du Der
   *(plutôt à destination des systèmes).
   * @return name
   **/
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public Location detailedAdress(DetailedAdress detailedAdress) {

    this.detailedAdress = detailedAdress;
    return this;
  }

  /**
   * Get detailedAdress
   * @return detailedAdress
   **/
  @JsonProperty(JSON_PROPERTY_DETAILED_ADRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DetailedAdress getDetailedAdress() {
    return detailedAdress;
  }

  @JsonProperty(JSON_PROPERTY_DETAILED_ADRESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetailedAdress(DetailedAdress detailedAdress) {
    this.detailedAdress = detailedAdress;
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

  public Location country(String country) {

    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCountry() {
    return country;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCountry(String country) {
    this.country = country;
  }

  public Location freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Champ libre pour compléter les informations de localisation
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
    Location location = (Location)o;
    return Objects.equals(this.locID, location.locID) &&
        Objects.equals(this.locLabel, location.locLabel) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.detailedAdress, location.detailedAdress) &&
        Objects.equals(this.city, location.city) &&
        Objects.equals(this.access, location.access) &&
        Objects.equals(this.geometry, location.geometry) &&
        Objects.equals(this.externalInfo, location.externalInfo) &&
        Objects.equals(this.country, location.country) &&
        Objects.equals(this.freetext, location.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locID, locLabel, name, detailedAdress, city, access,
                        geometry, externalInfo, country, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    sb.append("    locID: ").append(toIndentedString(locID)).append("\n");
    sb.append("    locLabel: ").append(toIndentedString(locLabel)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    detailedAdress: ")
        .append(toIndentedString(detailedAdress))
        .append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    access: ").append(toIndentedString(access)).append("\n");
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    externalInfo: ")
        .append(toIndentedString(externalInfo))
        .append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
