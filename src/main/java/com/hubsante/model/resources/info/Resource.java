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

package com.hubsante.model.resources.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.info.Contact;
import com.hubsante.model.resources.info.State;
import com.hubsante.model.resources.info.Team;
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
    {Resource.JSON_PROPERTY_DATETIME, Resource.JSON_PROPERTY_RESOURCE_ID,
     Resource.JSON_PROPERTY_REQUEST_ID, Resource.JSON_PROPERTY_MISSION_ID,
     Resource.JSON_PROPERTY_ORG_ID, Resource.JSON_PROPERTY_PATIENT_ID,
     Resource.JSON_PROPERTY_CENTER_NAME, Resource.JSON_PROPERTY_VEHICLE_TYPE,
     Resource.JSON_PROPERTY_NAME, Resource.JSON_PROPERTY_CENTER_CITY,
     Resource.JSON_PROPERTY_TEAM, Resource.JSON_PROPERTY_STATE,
     Resource.JSON_PROPERTY_CONTACT, Resource.JSON_PROPERTY_FREETEXT})
@JsonTypeName("resource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Resource {
  public static final String JSON_PROPERTY_DATETIME = "datetime";
  private OffsetDateTime datetime;

  public static final String JSON_PROPERTY_RESOURCE_ID = "resourceId";
  private String resourceId;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_MISSION_ID = "missionId";
  private String missionId;

  public static final String JSON_PROPERTY_ORG_ID = "orgId";
  private String orgId;

  public static final String JSON_PROPERTY_PATIENT_ID = "patientId";
  private String patientId;

  public static final String JSON_PROPERTY_CENTER_NAME = "centerName";
  private String centerName;

  /**
   * A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée
   */
  public enum VehicleTypeEnum {
    AASC("AASC"),

    AASC_VLSC("AASC.VLSC"),

    AASC_VPSP("AASC.VPSP"),

    AASC_AUTRESC("AASC.AUTRESC"),

    AUTREVEC("AUTREVEC"),

    AUTREVEC_APIED("AUTREVEC.APIED"),

    AUTREVEC_AVION("AUTREVEC.AVION"),

    AUTREVEC_PERSO("AUTREVEC.PERSO"),

    AUTREVEC_TAXI("AUTREVEC.TAXI"),

    AUTREVEC_TRAIN("AUTREVEC.TRAIN"),

    AUTREVEC_TRANSP("AUTREVEC.TRANSP"),

    AUTREVEC_AUTRE("AUTREVEC.AUTRE"),

    AUTREVEC_AUTRETRA("AUTREVEC.AUTRETRA"),

    FSI("FSI"),

    FSI_HELIFSI("FSI.HELIFSI"),

    FSI_VLFSI("FSI.VLFSI"),

    FSI_FFSI("FSI.FFSI"),

    FSI_VHFSI("FSI.VHFSI"),

    LIB("LIB"),

    LIB_MEDV("LIB.MEDV"),

    LIB_INF("LIB.INF"),

    LIB_AUTREPRO("LIB.AUTREPRO"),

    SIS("SIS"),

    SIS_DRAGON("SIS.DRAGON"),

    SIS_AVSC("SIS.AVSC"),

    SIS_FEUSIS("SIS.FEUSIS"),

    SIS_GRIMP("SIS.GRIMP"),

    SIS_NAVISIS("SIS.NAVISIS"),

    SIS_PCSIS("SIS.PCSIS"),

    SIS_SRSIS("SIS.SRSIS"),

    SIS_VCH("SIS.VCH"),

    SIS_VLCG("SIS.VLCG"),

    SIS_VLISP("SIS.VLISP"),

    SIS_VLMSP("SIS.VLMSP"),

    SIS_VLSIS("SIS.VLSIS"),

    SIS_VPL("SIS.VPL"),

    SIS_VPMA("SIS.VPMA"),

    SIS_VR("SIS.VR"),

    SIS_VSAV("SIS.VSAV"),

    SIS_MOYSSE("SIS.MOYSSE"),

    SIS_AUTRESIS("SIS.AUTRESIS"),

    SMUR("SMUR"),

    SMUR_VLM("SMUR.VLM"),

    SMUR_VL("SMUR.VL"),

    SMUR_PSM1("SMUR.PSM1"),

    SMUR_PSM2("SMUR.PSM2"),

    SMUR_PSM3("SMUR.PSM3"),

    SMUR_PSMP("SMUR.PSMP"),

    SMUR_VPC("SMUR.VPC"),

    SMUR_AR("SMUR.AR"),

    SMUR_AR_BAR("SMUR.AR-BAR"),

    SMUR_AR_PED("SMUR.AR-PED"),

    SMUR_HELISMUR("SMUR.HELISMUR"),

    SMUR_HELISAN("SMUR.HELISAN"),

    SMUR_AVSMUR("SMUR.AVSMUR"),

    SMUR_AVSAN("SMUR.AVSAN"),

    SMUR_NAVISMUR("SMUR.NAVISMUR"),

    TSU("TSU"),

    TSU_VSL("TSU.VSL"),

    TSU_AMB_GV("TSU.AMB-GV"),

    TSU_AMB_PV("TSU.AMB-PV"),

    TSU_AMB_BAR("TSU.AMB-BAR"),

    TSU_AMB("TSU.AMB");

    private String value;

    VehicleTypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static VehicleTypeEnum fromValue(String value) {
      for (VehicleTypeEnum b : VehicleTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_VEHICLE_TYPE = "vehicleType";
  private VehicleTypeEnum vehicleType;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CENTER_CITY = "centerCity";
  private String centerCity;

  public static final String JSON_PROPERTY_TEAM = "team";
  private Team team;

  public static final String JSON_PROPERTY_STATE = "state";
  private List<State> state = new ArrayList<>();

  public static final String JSON_PROPERTY_CONTACT = "contact";
  private Contact contact;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext = new ArrayList<>();

  public Resource() {}

  public Resource datetime(OffsetDateTime datetime) {

    this.datetime = datetime;
    return this;
  }

  /**
   * A valoriser avec la date et heure d&#39;engagement de la ressource/du
   *vecteur
   * @return datetime
   **/
  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDatetime() {
    return datetime;
  }

  @JsonProperty(JSON_PROPERTY_DATETIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDatetime(OffsetDateTime datetime) {
    this.datetime = datetime;
  }

  public Resource resourceId(String resourceId) {

    this.resourceId = resourceId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant partagé unique de la ressource engagée,
   *normé comme suit : {orgID}.resource.{ID unique de la ressource partagée} OU
   *- uniquement dans le cas où un ID unique de ressource ne peut pas être
   *garanti par l&#39;organisation propriétaire :
   *{orgID}.resource.{sendercaseId}.{n° d’ordre chronologique de la ressource}
   * @return resourceId
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResourceId() {
    return resourceId;
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public Resource requestId(String requestId) {

    this.requestId = requestId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant unique partagé de la demande de
   *ressource (si la ressource a été engagée suite à une demande de ressource),
   *normé comme suit : {orgID}.request.{ID unique de la demande dans le système
   *émetteur} OU - si un ID unique de la demande n&#39;était pas disponible :
   *{OrgId émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}
   * @return requestId
   **/
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRequestId() {
    return requestId;
  }

  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Resource missionId(String missionId) {

    this.missionId = missionId;
    return this;
  }

  /**
   * A valoriser avec le numéro de mission unique du central d’appel (PSAP, …)
   *qui a déclenché le vecteur
   * @return missionId
   **/
  @JsonProperty(JSON_PROPERTY_MISSION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMissionId() {
    return missionId;
  }

  @JsonProperty(JSON_PROPERTY_MISSION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMissionId(String missionId) {
    this.missionId = missionId;
  }

  public Resource orgId(String orgId) {

    this.orgId = orgId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant de l&#39;organisation à laquelle
   *appartient la ressource, normé comme suit :  {pays}.{domaine}.{organisation}
   * @return orgId
   **/
  @JsonProperty(JSON_PROPERTY_ORG_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOrgId() {
    return orgId;
  }

  @JsonProperty(JSON_PROPERTY_ORG_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public Resource patientId(String patientId) {

    this.patientId = patientId;
    return this;
  }

  /**
   * Identifiant partagé du patient qui est transporté. Ce n&#39;est à remplir
   *que lorsque l&#39;on sait quel vecteur transporte quel patient.  Il est
   *valorisé comme suit lors de sa création :  {OrgId
   *émetteur}.patient.{n°patient unique dans le système émetteur}  OU, si un
   *n°patient unique n&#39;existe pas dans le système émetteur : {ID
   *émetteur}.{senderCaseId}.patient.{numéro d’ordre chronologique au dossier}
   * @return patientId
   **/
  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPatientId() {
    return patientId;
  }

  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public Resource centerName(String centerName) {

    this.centerName = centerName;
    return this;
  }

  /**
   * A valoriser avec le lieu de garage principal
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

  public Resource vehicleType(VehicleTypeEnum vehicleType) {

    this.vehicleType = vehicleType;
    return this;
  }

  /**
   * A valoriser avec le type de vecteur mobilisé : cf. nomenclature associée
   * @return vehicleType
   **/
  @JsonProperty(JSON_PROPERTY_VEHICLE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public VehicleTypeEnum getVehicleType() {
    return vehicleType;
  }

  @JsonProperty(JSON_PROPERTY_VEHICLE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVehicleType(VehicleTypeEnum vehicleType) {
    this.vehicleType = vehicleType;
  }

  public Resource name(String name) {

    this.name = name;
    return this;
  }

  /**
   * A valoriser avec le nom donné à la ressource par l’organisation
   *d’appartenance
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
   * A valoriser avec le code INSEE de la commune du centre d&#39;affectation
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

  public Resource addstateItem(State stateItem) {
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

  public Resource addfreetextItem(String freetextItem) {
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
    return Objects.equals(this.datetime, resource.datetime) &&
        Objects.equals(this.resourceId, resource.resourceId) &&
        Objects.equals(this.requestId, resource.requestId) &&
        Objects.equals(this.missionId, resource.missionId) &&
        Objects.equals(this.orgId, resource.orgId) &&
        Objects.equals(this.patientId, resource.patientId) &&
        Objects.equals(this.centerName, resource.centerName) &&
        Objects.equals(this.vehicleType, resource.vehicleType) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.centerCity, resource.centerCity) &&
        Objects.equals(this.team, resource.team) &&
        Objects.equals(this.state, resource.state) &&
        Objects.equals(this.contact, resource.contact) &&
        Objects.equals(this.freetext, resource.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datetime, resourceId, requestId, missionId, orgId,
                        patientId, centerName, vehicleType, name, centerCity,
                        team, state, contact, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
    sb.append("    resourceId: ")
        .append(toIndentedString(resourceId))
        .append("\n");
    sb.append("    requestId: ")
        .append(toIndentedString(requestId))
        .append("\n");
    sb.append("    missionId: ")
        .append(toIndentedString(missionId))
        .append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    patientId: ")
        .append(toIndentedString(patientId))
        .append("\n");
    sb.append("    centerName: ")
        .append(toIndentedString(centerName))
        .append("\n");
    sb.append("    vehicleType: ")
        .append(toIndentedString(vehicleType))
        .append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    centerCity: ")
        .append(toIndentedString(centerCity))
        .append("\n");
    sb.append("    team: ").append(toIndentedString(team)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
