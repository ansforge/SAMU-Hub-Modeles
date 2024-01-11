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

package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.emsi.Coord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Position
 */
@JsonPropertyOrder(
    {Position.JSON_PROPERTY_L_O_C_I_D, Position.JSON_PROPERTY_N_A_M_E,
     Position.JSON_PROPERTY_T_Y_P_E, Position.JSON_PROPERTY_H_E_I_G_H_T_R_O_L_E,
     Position.JSON_PROPERTY_C_O_O_R_D_S_Y_S, Position.JSON_PROPERTY_C_O_O_R_D,
     Position.JSON_PROPERTY_A_D_D_R_E_S_S})
@JsonTypeName("position")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {
  public static final String JSON_PROPERTY_L_O_C_I_D = "LOC_ID";
  private String LOC_ID;

  public static final String JSON_PROPERTY_N_A_M_E = "NAME";
  private String NAME;

  public static final String JSON_PROPERTY_T_Y_P_E = "TYPE";
  private String TYPE;

  public static final String JSON_PROPERTY_H_E_I_G_H_T_R_O_L_E = "HEIGHT_ROLE";
  private String HEIGHT_ROLE;

  public static final String JSON_PROPERTY_C_O_O_R_D_S_Y_S = "COORDSYS";
  private String COORDSYS;

  public static final String JSON_PROPERTY_C_O_O_R_D = "COORD";
  private List<Coord> COORD;

  public static final String JSON_PROPERTY_A_D_D_R_E_S_S = "ADDRESS";
  private List<String> ADDRESS;

  public Position() {}

  public Position LOC_ID(String LOC_ID) {

    this.LOC_ID = LOC_ID;
    return this;
  }

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   *message RC-EDA et le lieu souhaité pour l&#39;intervention est
   *systématiquement reprécisé dans un objet MISSION.  Lorsque le lieu
   *d&#39;intervention est identique à celle d&#39;une position de l&#39;affaire
   *partagée dans le message RC-EDA, le champ MISSION.RGEO.POSITION.LOC_ID doit
   *être alimenté valorisé comme le champ eventLocation.locId du message RC-EDA
   *envoyé en amont.
   * @return LOC_ID
   **/
  @JsonProperty(JSON_PROPERTY_L_O_C_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLOCID() {
    return LOC_ID;
  }

  @JsonProperty(JSON_PROPERTY_L_O_C_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLOCID(String LOC_ID) {
    this.LOC_ID = LOC_ID;
  }

  public Position NAME(String NAME) {

    this.NAME = NAME;
    return this;
  }

  /**
   * Optionnel, non utilisé par NexSIS nom de lieu
   * @return NAME
   **/
  @JsonProperty(JSON_PROPERTY_N_A_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNAME() {
    return NAME;
  }

  @JsonProperty(JSON_PROPERTY_N_A_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNAME(String NAME) {
    this.NAME = NAME;
  }

  public Position TYPE(String TYPE) {

    this.TYPE = TYPE;
    return this;
  }

  /**
   * Optionnel Dans le cadre de l&#39;interface LRM NexSIS, seul le libellé
   *POINT doit obligatoirement être interprétable par les deux partenaires. Cf.
   *Nomenclature EMSI - POSITION pour plus de détails
   * @return TYPE
   **/
  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTYPE() {
    return TYPE;
  }

  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTYPE(String TYPE) {
    this.TYPE = TYPE;
  }

  public Position HEIGHT_ROLE(String HEIGHT_ROLE) {

    this.HEIGHT_ROLE = HEIGHT_ROLE;
    return this;
  }

  /**
   * Optionnel
   * @return HEIGHT_ROLE
   **/
  @JsonProperty(JSON_PROPERTY_H_E_I_G_H_T_R_O_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getHEIGHTROLE() {
    return HEIGHT_ROLE;
  }

  @JsonProperty(JSON_PROPERTY_H_E_I_G_H_T_R_O_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHEIGHTROLE(String HEIGHT_ROLE) {
    this.HEIGHT_ROLE = HEIGHT_ROLE;
  }

  public Position COORDSYS(String COORDSYS) {

    this.COORDSYS = COORDSYS;
    return this;
  }

  /**
   * Optionnel
   * @return COORDSYS
   **/
  @JsonProperty(JSON_PROPERTY_C_O_O_R_D_S_Y_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCOORDSYS() {
    return COORDSYS;
  }

  @JsonProperty(JSON_PROPERTY_C_O_O_R_D_S_Y_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCOORDSYS(String COORDSYS) {
    this.COORDSYS = COORDSYS;
  }

  public Position COORD(List<Coord> COORD) {

    this.COORD = COORD;
    return this;
  }

  public Position addCOORDItem(Coord COORDItem) {
    if (this.COORD == null) {
      this.COORD = new ArrayList<>();
    }
    this.COORD.add(COORDItem);
    return this;
  }

  /**
   * Get COORD
   * @return COORD
   **/
  @JsonProperty(JSON_PROPERTY_C_O_O_R_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Coord> getCOORD() {
    return COORD;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_C_O_O_R_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCOORD(List<Coord> COORD) {
    if (COORD == null) {
      return;
    }
    if (this.COORD == null) {
      this.COORD = new ArrayList<>();
    }
    this.COORD.addAll(COORD);
  }

  public Position ADDRESS(List<String> ADDRESS) {

    this.ADDRESS = ADDRESS;
    return this;
  }

  public Position addADDRESSItem(String ADDRESSItem) {
    if (this.ADDRESS == null) {
      this.ADDRESS = new ArrayList<>();
    }
    this.ADDRESS.add(ADDRESSItem);
    return this;
  }

  /**
   * Get ADDRESS
   * @return ADDRESS
   **/
  @JsonProperty(JSON_PROPERTY_A_D_D_R_E_S_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getADDRESS() {
    return ADDRESS;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_A_D_D_R_E_S_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setADDRESS(List<String> ADDRESS) {
    if (ADDRESS == null) {
      return;
    }
    if (this.ADDRESS == null) {
      this.ADDRESS = new ArrayList<>();
    }
    this.ADDRESS.addAll(ADDRESS);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position)o;
    return Objects.equals(this.LOC_ID, position.LOC_ID) &&
        Objects.equals(this.NAME, position.NAME) &&
        Objects.equals(this.TYPE, position.TYPE) &&
        Objects.equals(this.HEIGHT_ROLE, position.HEIGHT_ROLE) &&
        Objects.equals(this.COORDSYS, position.COORDSYS) &&
        Objects.equals(this.COORD, position.COORD) &&
        Objects.equals(this.ADDRESS, position.ADDRESS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(LOC_ID, NAME, TYPE, HEIGHT_ROLE, COORDSYS, COORD,
                        ADDRESS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Position {\n");
    sb.append("    LOC_ID: ").append(toIndentedString(LOC_ID)).append("\n");
    sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
    sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
    sb.append("    HEIGHT_ROLE: ")
        .append(toIndentedString(HEIGHT_ROLE))
        .append("\n");
    sb.append("    COORDSYS: ").append(toIndentedString(COORDSYS)).append("\n");
    sb.append("    COORD: ").append(toIndentedString(COORD)).append("\n");
    sb.append("    ADDRESS: ").append(toIndentedString(ADDRESS)).append("\n");
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
