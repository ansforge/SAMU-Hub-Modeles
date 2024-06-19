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

package com.hubsante.model.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.Contact;
import com.hubsante.model.resources.Coord;
import com.hubsante.model.resources.State;
import com.hubsante.model.resources.Team;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Resource
 */
@JsonPropertyOrder(
    {Resource.JSON_PROPERTY_DATE_TIME, Resource.JSON_PROPERTY_RESOURCE_I_D,
     Resource.JSON_PROPERTY_RS_D_R_ID, Resource.JSON_PROPERTY_MISSION_I_D,
     Resource.JSON_PROPERTY_ORG_I_D, Resource.JSON_PROPERTY_CENTER_NAME,
     Resource.JSON_PROPERTY_RESOURCE_TYPE, Resource.JSON_PROPERTY_VEHICULE_TYPE,
     Resource.JSON_PROPERTY_PLATE, Resource.JSON_PROPERTY_NAME,
     Resource.JSON_PROPERTY_CENTER_CITY, Resource.JSON_PROPERTY_TEAM,
     Resource.JSON_PROPERTY_STATE, Resource.JSON_PROPERTY_COORD,
     Resource.JSON_PROPERTY_CONTACT, Resource.JSON_PROPERTY_FREETEXT})
@JsonTypeName("resource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Resource {
  public static final String JSON_PROPERTY_DATE_TIME = "dateTime";
  private OffsetDateTime dateTime;

  public static final String JSON_PROPERTY_RESOURCE_I_D = "resourceID";
  private String resourceID;

  public static final String JSON_PROPERTY_RS_D_R_ID = "RSDRId";
  private String rsDRId;

  public static final String JSON_PROPERTY_MISSION_I_D = "missionID";
  private String missionID;

  public static final String JSON_PROPERTY_ORG_I_D = "orgID";
  private String orgID;

  public static final String JSON_PROPERTY_CENTER_NAME = "centerName";
  private String centerName;

  /**
   * Type de ressource mobilisée : Smur, Hospitaliers (hors Smur),
   * Professionnels Libéraux, Ambulanciers privés (Transporteurs Sanitaires
   * Urgent), etc.
   */
  public enum ResourceTypeEnum {
    SMUR("SMUR"),

    HOSPIT("HOSPIT"),

    LIB("LIB"),

    TSU_("TSU "),

    SIS("SIS"),

    AASC("AASC"),

    FDO("FDO"),

    ADM("ADM"),

    DAE("DAE"),

    AUTRE("AUTRE");

    private String value;

    ResourceTypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ResourceTypeEnum fromValue(String value) {
      for (ResourceTypeEnum b : ResourceTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resourceType";
  private ResourceTypeEnum resourceType;

  /**
   * Type de vecteur mobilisé : Véhicule Léger Médicalisé, Ambulance de
   * réanimation, Ambulance de réanimation Bariatrique, Ambulance de réanimation
   * Pédiatrique, etc.
   */
  public enum VehiculeTypeEnum {
    VPSP("VPSP"),

    VLSC("VLSC"),

    AUTRESC("AUTRESC"),

    TAXI("TAXI"),

    TRANSP("TRANSP"),

    AUTRE("AUTRE"),

    TRAIN("TRAIN"),

    AVION("AVION"),

    PERSO("PERSO"),

    APIED("APIED"),

    INCONNU("INCONNU"),

    CONSEIL("CONSEIL"),

    DAE("DAE"),

    HELIFSI("HELIFSI"),

    VLFSI("VLFSI"),

    FFSI("FFSI"),

    VHFSI("VHFSI"),

    MEDC("MEDC"),

    MEDV("MEDV"),

    PHARMA("PHARMA"),

    INF("INF"),

    MEDSPE("MEDSPE"),

    DENT("DENT"),

    AUTREPRO("AUTREPRO"),

    DRAGON("DRAGON"),

    AVSC("AVSC"),

    VSAV("VSAV"),

    GRIMP("GRIMP"),

    VPL("VPL"),

    SRSIS("SRSIS"),

    FEUSIS("FEUSIS"),

    VPMA("VPMA"),

    VCH("VCH"),

    VR("VR"),

    PCSIS("PCSIS"),

    VLISP("VLISP"),

    VLMSP("VLMSP"),

    VLCG("VLCG"),

    VLSIS("VLSIS"),

    MOYSSE("MOYSSE"),

    AUTRESIS("AUTRESIS"),

    VLM("VLM"),

    AR("AR"),

    AR_BAR("AR-BAR"),

    AR_PED("AR-PED"),

    VL("VL"),

    HELISMUR("HELISMUR"),

    HELISAN("HELISAN"),

    AVSMUR("AVSMUR"),

    AVSAN("AVSAN"),

    NAVISMUR("NAVISMUR"),

    PSM1("PSM1"),

    PSM2("PSM2"),

    PSM3("PSM3"),

    PSMP("PSMP"),

    VPC("VPC"),

    AMB_GV("AMB-GV"),

    AMB_PV("AMB-PV"),

    AMB_BAR("AMB-BAR"),

    AMB("AMB"),

    VSL("VSL"),

    NAVISIS("NAVISIS");

    private String value;

    VehiculeTypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VehiculeTypeEnum fromValue(String value) {
      for (VehiculeTypeEnum b : VehiculeTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_VEHICULE_TYPE = "vehiculeType";
  private VehiculeTypeEnum vehiculeType;

  public static final String JSON_PROPERTY_PLATE = "plate";
  private String plate;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CENTER_CITY = "centerCity";
  private String centerCity;

  public static final String JSON_PROPERTY_TEAM = "team";
  private Team team;

  public static final String JSON_PROPERTY_STATE = "state";
  private List<State> state;

  public static final String JSON_PROPERTY_COORD = "coord";
  private Coord coord;

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private Contact contact;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext;

  public Resource() {}

  public Resource dateTime(OffsetDateTime dateTime) {

    this.dateTime = dateTime;
    return this;
  }

  /**
   * date et heure d&#39;engagement de la ressource
   * @return dateTime
   **/
  @JsonProperty(JSON_PROPERTY_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  @JsonProperty(JSON_PROPERTY_DATE_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Resource resourceID(String resourceID) {

    this.resourceID = resourceID;
    return this;
  }

  /**
   * ID partagé unique de la ressource engagée  {orgID}.R.{ID unique de la
   *ressource partagée} Ou, uniquement dans le cas où un ID unique de ressource
   *ne peut pas être garanti par l&#39;organisation propriétaire : {orgID}.R.{ID
   *du dossier partagé}.{numéro d’ordre chronologique ressource}
   * @return resourceID
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getResourceID() {
    return resourceID;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceID(String resourceID) {
    this.resourceID = resourceID;
  }

  public Resource rsDRId(String rsDRId) {

    this.rsDRId = rsDRId;
    return this;
  }

  /**
   * Identifiant unique partagé de la demande de ressource (si la ressource a
   *été engagée suite à une demande de ressource) {orgID}.D.{ID unique de la
   *demande dans le système émetteur}
   * @return rsDRId
   **/
  @JsonProperty(JSON_PROPERTY_RS_D_R_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRsDRId() {
    return rsDRId;
  }

  @JsonProperty(JSON_PROPERTY_RS_D_R_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRsDRId(String rsDRId) {
    this.rsDRId = rsDRId;
  }

  public Resource missionID(String missionID) {

    this.missionID = missionID;
    return this;
  }

  /**
   * Numéro de mission unique du central d’appel (PSAP, …) qui a déclenché le
   *vecteur
   * @return missionID
   **/
  @JsonProperty(JSON_PROPERTY_MISSION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMissionID() {
    return missionID;
  }

  @JsonProperty(JSON_PROPERTY_MISSION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMissionID(String missionID) {
    this.missionID = missionID;
  }

  public Resource orgID(String orgID) {

    this.orgID = orgID;
    return this;
  }

  /**
   * Organisation à laquelle appartient la ressource
   * @return orgID
   **/
  @JsonProperty(JSON_PROPERTY_ORG_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrgID() {
    return orgID;
  }

  @JsonProperty(JSON_PROPERTY_ORG_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrgID(String orgID) {
    this.orgID = orgID;
  }

  public Resource centerName(String centerName) {

    this.centerName = centerName;
    return this;
  }

  /**
   * Lieu de garage principal
   * @return centerName
   **/
  @JsonProperty(JSON_PROPERTY_CENTER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCenterName() {
    return centerName;
  }

  @JsonProperty(JSON_PROPERTY_CENTER_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCenterName(String centerName) {
    this.centerName = centerName;
  }

  public Resource resourceType(ResourceTypeEnum resourceType) {

    this.resourceType = resourceType;
    return this;
  }

  /**
   * Type de ressource mobilisée : Smur, Hospitaliers (hors Smur),
   *Professionnels Libéraux, Ambulanciers privés (Transporteurs Sanitaires
   *Urgent), etc.
   * @return resourceType
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ResourceTypeEnum getResourceType() {
    return resourceType;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResourceType(ResourceTypeEnum resourceType) {
    this.resourceType = resourceType;
  }

  public Resource vehiculeType(VehiculeTypeEnum vehiculeType) {

    this.vehiculeType = vehiculeType;
    return this;
  }

  /**
   * Type de vecteur mobilisé : Véhicule Léger Médicalisé, Ambulance de
   *réanimation, Ambulance de réanimation Bariatrique, Ambulance de réanimation
   *Pédiatrique, etc.
   * @return vehiculeType
   **/
  @JsonProperty(JSON_PROPERTY_VEHICULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public VehiculeTypeEnum getVehiculeType() {
    return vehiculeType;
  }

  @JsonProperty(JSON_PROPERTY_VEHICULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVehiculeType(VehiculeTypeEnum vehiculeType) {
    this.vehiculeType = vehiculeType;
  }

  public Resource plate(String plate) {

    this.plate = plate;
    return this;
  }

  /**
   * N° d&#39;immatriculation du vecteur
   * @return plate
   **/
  @JsonProperty(JSON_PROPERTY_PLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPlate() {
    return plate;
  }

  @JsonProperty(JSON_PROPERTY_PLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPlate(String plate) {
    this.plate = plate;
  }

  public Resource name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Nom donné à la ressource par l’organisation d’appartenance
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

  public Resource centerCity(String centerCity) {

    this.centerCity = centerCity;
    return this;
  }

  /**
   * Code INSEE de la commune du centre d&#39;affectation
   * @return centerCity
   **/
  @JsonProperty(JSON_PROPERTY_CENTER_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCenterCity() {
    return centerCity;
  }

  @JsonProperty(JSON_PROPERTY_CENTER_CITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCenterCity(String centerCity) {
    this.centerCity = centerCity;
  }

  public Resource team(Team team) {

    this.team = team;
    return this;
  }

  /**
   * Get team
   * @return team
   **/
  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Team getTeam() {
    return team;
  }

  @JsonProperty(JSON_PROPERTY_TEAM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTeam(Team team) {
    this.team = team;
  }

  public Resource state(List<State> state) {

    this.state = state;
    return this;
  }

  public Resource addStateItem(State stateItem) {
    if (this.state == null) {
      this.state = new ArrayList<>();
    }
    this.state.add(stateItem);
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<State> getState() {
    return state;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setState(List<State> state) {
    if (state == null) {
      return;
    }
    if (this.state == null) {
      this.state = new ArrayList<>();
    }
    this.state.addAll(state);
  }

  public Resource coord(Coord coord) {

    this.coord = coord;
    return this;
  }

  /**
   * Get coord
   * @return coord
   **/
  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Coord getCoord() {
    return coord;
  }

  @JsonProperty(JSON_PROPERTY_COORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  public Resource contact(Contact contact) {

    this.contact = contact;
    return this;
  }

  /**
   * Get contact
   * @return contact
   **/
  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Contact getContact() {
    return contact;
  }

  @JsonProperty(JSON_PROPERTY_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Resource freetext(List<String> freetext) {

    this.freetext = freetext;
    return this;
  }

  public Resource addFreetextItem(String freetextItem) {
    if (this.freetext == null) {
      this.freetext = new ArrayList<>();
    }
    this.freetext.add(freetextItem);
    return this;
  }

  /**
   * Get freetext
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getFreetext() {
    return freetext;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(List<String> freetext) {
    if (freetext == null) {
      return;
    }
    if (this.freetext == null) {
      this.freetext = new ArrayList<>();
    }
    this.freetext.addAll(freetext);
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
    return Objects.equals(this.dateTime, resource.dateTime) &&
        Objects.equals(this.resourceID, resource.resourceID) &&
        Objects.equals(this.rsDRId, resource.rsDRId) &&
        Objects.equals(this.missionID, resource.missionID) &&
        Objects.equals(this.orgID, resource.orgID) &&
        Objects.equals(this.centerName, resource.centerName) &&
        Objects.equals(this.resourceType, resource.resourceType) &&
        Objects.equals(this.vehiculeType, resource.vehiculeType) &&
        Objects.equals(this.plate, resource.plate) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.centerCity, resource.centerCity) &&
        Objects.equals(this.team, resource.team) &&
        Objects.equals(this.state, resource.state) &&
        Objects.equals(this.coord, resource.coord) &&
        Objects.equals(this.contact, resource.contact) &&
        Objects.equals(this.freetext, resource.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateTime, resourceID, rsDRId, missionID, orgID,
                        centerName, resourceType, vehiculeType, plate, name,
                        centerCity, team, state, coord, contact, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("    resourceID: ")
        .append(toIndentedString(resourceID))
        .append("\n");
    sb.append("    rsDRId: ").append(toIndentedString(rsDRId)).append("\n");
    sb.append("    missionID: ")
        .append(toIndentedString(missionID))
        .append("\n");
    sb.append("    orgID: ").append(toIndentedString(orgID)).append("\n");
    sb.append("    centerName: ")
        .append(toIndentedString(centerName))
        .append("\n");
    sb.append("    resourceType: ")
        .append(toIndentedString(resourceType))
        .append("\n");
    sb.append("    vehiculeType: ")
        .append(toIndentedString(vehiculeType))
        .append("\n");
    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    centerCity: ")
        .append(toIndentedString(centerCity))
        .append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    coord: ").append(toIndentedString(coord)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
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
