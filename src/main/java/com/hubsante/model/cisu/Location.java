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
import com.hubsante.model.cisu.Access;
import com.hubsante.model.cisu.City;
import com.hubsante.model.cisu.DetailedAddress;
import com.hubsante.model.cisu.ExternalInfo;
import com.hubsante.model.cisu.ExternalLocationId;
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
     Location.JSON_PROPERTY_NAME, Location.JSON_PROPERTY_EXTERNAL_LOCATION_ID,
     Location.JSON_PROPERTY_DETAILED_ADDRESS, Location.JSON_PROPERTY_CITY,
     Location.JSON_PROPERTY_ACCESS, Location.JSON_PROPERTY_GEOMETRY,
     Location.JSON_PROPERTY_EXTERNAL_INFO, Location.JSON_PROPERTY_COUNTRY,
     Location.JSON_PROPERTY_FREETEXT})
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

  /**
   * Gets or Sets country
   */
  public enum CountryEnum {
    AF("AF"),

    AX("AX"),

    AL("AL"),

    DZ("DZ"),

    AS("AS"),

    AD("AD"),

    AO("AO"),

    AI("AI"),

    AQ("AQ"),

    AG("AG"),

    AR("AR"),

    AM("AM"),

    AW("AW"),

    AU("AU"),

    AT("AT"),

    AZ("AZ"),

    BS("BS"),

    BH("BH"),

    BD("BD"),

    BB("BB"),

    BY("BY"),

    BE("BE"),

    BZ("BZ"),

    BJ("BJ"),

    BM("BM"),

    BT("BT"),

    BO("BO"),

    BA("BA"),

    BW("BW"),

    BV("BV"),

    BR("BR"),

    IO("IO"),

    BN("BN"),

    BG("BG"),

    BF("BF"),

    BI("BI"),

    CV("CV"),

    KH("KH"),

    CM("CM"),

    CA("CA"),

    KY("KY"),

    CF("CF"),

    TD("TD"),

    CL("CL"),

    CN("CN"),

    CX("CX"),

    CC("CC"),

    CO("CO"),

    KM("KM"),

    CG("CG"),

    CK("CK"),

    CR("CR"),

    CI("CI"),

    HR("HR"),

    CU("CU"),

    CW("CW"),

    CY("CY"),

    CZ("CZ"),

    DK("DK"),

    DJ("DJ"),

    DM("DM"),

    DO("DO"),

    EC("EC"),

    EG("EG"),

    SV("SV"),

    GQ("GQ"),

    ER("ER"),

    EE("EE"),

    SZ("SZ"),

    ET("ET"),

    FK("FK"),

    FO("FO"),

    FJ("FJ"),

    FI("FI"),

    FR("FR"),

    GF("GF"),

    PF("PF"),

    TF("TF"),

    GA("GA"),

    GM("GM"),

    GE("GE"),

    DE("DE"),

    GH("GH"),

    GI("GI"),

    GR("GR"),

    GL("GL"),

    GD("GD"),

    GP("GP"),

    GU("GU"),

    GT("GT"),

    GG("GG"),

    GN("GN"),

    GW("GW"),

    GY("GY"),

    HT("HT"),

    HM("HM"),

    VA("VA"),

    HN("HN"),

    HK("HK"),

    HU("HU"),

    IS("IS"),

    IN("IN"),

    ID("ID"),

    IR("IR"),

    IQ("IQ"),

    IE("IE"),

    IM("IM"),

    IL("IL"),

    IT("IT"),

    JM("JM"),

    JP("JP"),

    JE("JE"),

    JO("JO"),

    KZ("KZ"),

    KE("KE"),

    KI("KI"),

    KP("KP"),

    KW("KW"),

    KG("KG"),

    LA("LA"),

    LV("LV"),

    LB("LB"),

    LS("LS"),

    LR("LR"),

    LY("LY"),

    LI("LI"),

    LT("LT"),

    LU("LU"),

    MO("MO"),

    MG("MG"),

    MW("MW"),

    MY("MY"),

    MV("MV"),

    ML("ML"),

    MT("MT"),

    MH("MH"),

    MQ("MQ"),

    MR("MR"),

    MU("MU"),

    YT("YT"),

    MX("MX"),

    FM("FM"),

    MC("MC"),

    MN("MN"),

    ME("ME"),

    MS("MS"),

    MA("MA"),

    MZ("MZ"),

    MM("MM"),

    NA("NA"),

    NR("NR"),

    NP("NP"),

    NL("NL"),

    NC("NC"),

    NZ("NZ"),

    NI("NI"),

    NE("NE"),

    NG("NG"),

    NU("NU"),

    NF("NF"),

    MK("MK"),

    MP("MP"),

    NO("NO"),

    OM("OM"),

    PK("PK"),

    PW("PW"),

    PA("PA"),

    PG("PG"),

    PY("PY"),

    PE("PE"),

    PH("PH"),

    PN("PN"),

    PL("PL"),

    PT("PT"),

    PR("PR"),

    QA("QA"),

    RE("RE"),

    RO("RO"),

    RU("RU"),

    RW("RW"),

    BL("BL"),

    KN("KN"),

    LC("LC"),

    MF("MF"),

    PM("PM"),

    VC("VC"),

    WS("WS"),

    SM("SM"),

    ST("ST"),

    SA("SA"),

    SN("SN"),

    RS("RS"),

    SC("SC"),

    SL("SL"),

    SG("SG"),

    SX("SX"),

    SK("SK"),

    SI("SI"),

    SB("SB"),

    SO("SO"),

    ZA("ZA"),

    GS("GS"),

    SS("SS"),

    ES("ES"),

    LK("LK"),

    SD("SD"),

    SR("SR"),

    SJ("SJ"),

    SE("SE"),

    CH("CH"),

    SY("SY"),

    TJ("TJ"),

    TH("TH"),

    TL("TL"),

    TG("TG"),

    TK("TK"),

    TO("TO"),

    TT("TT"),

    TN("TN"),

    TR("TR"),

    TM("TM"),

    TC("TC"),

    TV("TV"),

    UG("UG"),

    UA("UA"),

    AE("AE"),

    GB("GB"),

    US("US"),

    UM("UM"),

    UY("UY"),

    UZ("UZ"),

    VU("VU"),

    VE("VE"),

    VN("VN"),

    VG("VG"),

    VI("VI"),

    WF("WF"),

    EH("EH"),

    YE("YE"),

    ZM("ZM"),

    ZW("ZW");

    private String value;

    CountryEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CountryEnum fromValue(String value) {
      for (CountryEnum b : CountryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_COUNTRY = "country";
  private CountryEnum country;

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

  public Location country(CountryEnum country) {

    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public CountryEnum getCountry() {
    return country;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCountry(CountryEnum country) {
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
        Objects.equals(this.externalLocationId, location.externalLocationId) &&
        Objects.equals(this.detailedAddress, location.detailedAddress) &&
        Objects.equals(this.city, location.city) &&
        Objects.equals(this.access, location.access) &&
        Objects.equals(this.geometry, location.geometry) &&
        Objects.equals(this.externalInfo, location.externalInfo) &&
        Objects.equals(this.country, location.country) &&
        Objects.equals(this.freetext, location.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locID, locLabel, name, externalLocationId,
                        detailedAddress, city, access, geometry, externalInfo,
                        country, freetext);
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
