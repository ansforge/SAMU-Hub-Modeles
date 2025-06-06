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

package com.hubsante.model.emsi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.emsi.Position;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Rgeo
 */
@JsonPropertyOrder({Rgeo.JSON_PROPERTY_D_A_T_I_M_E, Rgeo.JSON_PROPERTY_T_Y_P_E,
                    Rgeo.JSON_PROPERTY_F_R_E_E_T_E_X_T, Rgeo.JSON_PROPERTY_I_D,
                    Rgeo.JSON_PROPERTY_P_O_S_I_T_I_O_N})
@JsonTypeName("rgeo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Rgeo {
  public static final String JSON_PROPERTY_D_A_T_I_M_E = "DATIME";
  private OffsetDateTime DATIME;

  /**
   * Type de position indiqué pour la ressource : - ASP : assembly point. Point
   * de rassemblement par défaut des ressources liées à la mission. Peut ne pas
   * être utilisé - CUR : current. Position actualisée de la ressource
   * permettant le suivi géolocalisé des véhicules notamment. Peut ne pas être
   * utilisé - INC : incident. Consigne relative au positionnement de la
   * ressource sur le lieu d&#39;intervention. Peut ne pas être utilisé - STG :
   * staging point. Consigne relative au stationnement des véhicules ou au
   * stockage du matériel par exemple. peut ne pas être utilisé - TGT : targer
   * location. Si renseigné, doit être cohérent avec la position renseignée pour
   * la mission. Plusieurs positions du même type avec des horodatages
   * différents peuvent être fournies.
   */
  public enum TYPEEnum {
    ASP("ASP"),

    CUR("CUR"),

    INC("INC"),

    STG("STG"),

    TGT("TGT");

    private String value;

    TYPEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TYPEEnum fromValue(String value) {
      for (TYPEEnum b : TYPEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_T_Y_P_E = "TYPE";
  private TYPEEnum TYPE;

  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  public static final String JSON_PROPERTY_P_O_S_I_T_I_O_N = "POSITION";
  private List<Position> POSITION;

  public Rgeo() {}

  public Rgeo DATIME(OffsetDateTime DATIME) {

    this.DATIME = DATIME;
    return this;
  }

  /**
   * Horaire associé à l&#39;arrivée de la ressource sur la position. En
   *fonction du TYPE de position, peut indiquer un horaire de relevé de
   *position, un horaire cible d&#39;arrivée.
   * @return DATIME
   **/
  @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDATIME() {
    return DATIME;
  }

  @JsonProperty(JSON_PROPERTY_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDATIME(OffsetDateTime DATIME) {
    this.DATIME = DATIME;
  }

  public Rgeo TYPE(TYPEEnum TYPE) {

    this.TYPE = TYPE;
    return this;
  }

  /**
   * Type de position indiqué pour la ressource : - ASP : assembly point. Point
   *de rassemblement par défaut des ressources liées à la mission. Peut ne pas
   *être utilisé - CUR : current. Position actualisée de la ressource permettant
   *le suivi géolocalisé des véhicules notamment. Peut ne pas être utilisé - INC
   *: incident. Consigne relative au positionnement de la ressource sur le lieu
   *d&#39;intervention. Peut ne pas être utilisé - STG : staging point. Consigne
   *relative au stationnement des véhicules ou au stockage du matériel par
   *exemple. peut ne pas être utilisé - TGT : targer location. Si renseigné,
   *doit être cohérent avec la position renseignée pour la mission. Plusieurs
   *positions du même type avec des horodatages différents peuvent être
   *fournies.
   * @return TYPE
   **/
  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TYPEEnum getTYPE() {
    return TYPE;
  }

  @JsonProperty(JSON_PROPERTY_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTYPE(TYPEEnum TYPE) {
    this.TYPE = TYPE;
  }

  public Rgeo FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Permet de rajouter des précisions sur la localisation de la ressource
   *transmise
   * @return FREETEXT
   **/
  @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFREETEXT() {
    return FREETEXT;
  }

  @JsonProperty(JSON_PROPERTY_F_R_E_E_T_E_X_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFREETEXT(String FREETEXT) {
    this.FREETEXT = FREETEXT;
  }

  public Rgeo ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * Identifiant unique de la position dans le système du partenaire
   * @return ID
   **/
  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getID() {
    return ID;
  }

  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setID(String ID) {
    this.ID = ID;
  }

  public Rgeo POSITION(List<Position> POSITION) {

    this.POSITION = POSITION;
    return this;
  }

  public Rgeo addPOSITIONItem(Position POSITIONItem) {
    if (this.POSITION == null) {
      this.POSITION = new ArrayList<>();
    }
    this.POSITION.add(POSITIONItem);
    return this;
  }

  /**
   * Get POSITION
   * @return POSITION
   **/
  @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Position> getPOSITION() {
    return POSITION;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPOSITION(List<Position> POSITION) {
    if (POSITION == null) {
      return;
    }
    if (this.POSITION == null) {
      this.POSITION = new ArrayList<>();
    }
    this.POSITION.addAll(POSITION);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Rgeo rgeo = (Rgeo)o;
    return Objects.equals(this.DATIME, rgeo.DATIME) &&
        Objects.equals(this.TYPE, rgeo.TYPE) &&
        Objects.equals(this.FREETEXT, rgeo.FREETEXT) &&
        Objects.equals(this.ID, rgeo.ID) &&
        Objects.equals(this.POSITION, rgeo.POSITION);
  }

  @Override
  public int hashCode() {
    return Objects.hash(DATIME, TYPE, FREETEXT, ID, POSITION);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rgeo {\n");
    sb.append("    DATIME: ").append(toIndentedString(DATIME)).append("\n");
    sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    POSITION: ").append(toIndentedString(POSITION)).append("\n");
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
