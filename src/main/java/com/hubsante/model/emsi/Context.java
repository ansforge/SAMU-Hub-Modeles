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
 * OpenAPI
 * OpenAPI
 *
 * The version of the OpenAPI document: 0.0.1
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
import com.hubsante.model.emsi.ExternalInfo;
import com.hubsante.model.emsi.Link;
import com.hubsante.model.emsi.Origin;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Context
 */
@JsonPropertyOrder(
    {Context.JSON_PROPERTY_I_D, Context.JSON_PROPERTY_M_O_D_E,
     Context.JSON_PROPERTY_M_S_G_T_Y_P_E, Context.JSON_PROPERTY_C_R_E_A_T_I_O_N,
     Context.JSON_PROPERTY_L_I_N_K, Context.JSON_PROPERTY_L_E_V_E_L,
     Context.JSON_PROPERTY_S_E_C_L_A_S_S, Context.JSON_PROPERTY_F_R_E_E_T_E_X_T,
     Context.JSON_PROPERTY_O_R_I_G_I_N,
     Context.JSON_PROPERTY_E_X_T_E_R_N_A_L_I_N_F_O,
     Context.JSON_PROPERTY_U_R_G_E_N_C_Y})
@JsonTypeName("context")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Context {
  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  /**
   * Valeur constante dans le cadre des échanges LRM-NexSIS : ACTUAL
   */
  public enum MODEEnum {
    ACTUAL(String.valueOf("ACTUAL")),

    EXERCS(String.valueOf("EXERCS")),

    SYSTEM(String.valueOf("SYSTEM")),

    TEST(String.valueOf("TEST"));

    private String value;

    MODEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MODEEnum fromValue(String value) {
      for (MODEEnum b : MODEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_M_O_D_E = "MODE";
  private MODEEnum MODE;

  /**
   * - A valoriser avec la valeur \&quot;ALERT\&quot; lors du premier échange
   * entre systèmes. - A valoriser avec la valeur constante \&quot;UPDATE\&quot;
   * ensuite. Peut ne pas être interprété par les LRM.
   */
  public enum MSGTYPEEnum {
    ACK(String.valueOf("ACK")),

    ALERT(String.valueOf("ALERT")),

    CANCEL(String.valueOf("CANCEL")),

    ERROR(String.valueOf("ERROR")),

    UPDATE(String.valueOf("UPDATE"));

    private String value;

    MSGTYPEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MSGTYPEEnum fromValue(String value) {
      for (MSGTYPEEnum b : MSGTYPEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_M_S_G_T_Y_P_E = "MSGTYPE";
  private MSGTYPEEnum MSGTYPE;

  public static final String JSON_PROPERTY_C_R_E_A_T_I_O_N = "CREATION";
  private OffsetDateTime CREATION;

  public static final String JSON_PROPERTY_L_I_N_K = "LINK";
  private List<Link> LINK = new ArrayList<>();

  /**
   * A valoriser avec la valeur constante \&quot;OPR\&quot; dans le cadre
   * d&#39;un message EMSI, incluant une mission OPG
   */
  public enum LEVELEnum {
    STRTGC(String.valueOf("STRTGC")),

    OPR(String.valueOf("OPR")),

    TACTCL(String.valueOf("TACTCL"));

    private String value;

    LEVELEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LEVELEnum fromValue(String value) {
      for (LEVELEnum b : LEVELEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_L_E_V_E_L = "LEVEL";
  private LEVELEnum LEVEL;

  /**
   * Optionnel  Dans NexSIS ;  Les messages transmis par NexSIS auront un champ
   * valorisé avec systématiquement le même code:
   * \&quot;RESTRC\&quot;&#x3D;restricted Les LRM doivent également renseigner
   * la valeur \&quot;RESTRC\&quot;
   */
  public enum SECLASSEnum {
    CONFID(String.valueOf("CONFID")),

    RESTRC(String.valueOf("RESTRC")),

    SECRET(String.valueOf("SECRET")),

    TOPSRT(String.valueOf("TOPSRT")),

    UNCLAS(String.valueOf("UNCLAS")),

    UNMARK(String.valueOf("UNMARK"));

    private String value;

    SECLASSEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SECLASSEnum fromValue(String value) {
      for (SECLASSEnum b : SECLASSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_S_E_C_L_A_S_S = "SECLASS";
  private SECLASSEnum SECLASS;

  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public static final String JSON_PROPERTY_O_R_I_G_I_N = "ORIGIN";
  private Origin ORIGIN;

  public static final String JSON_PROPERTY_E_X_T_E_R_N_A_L_I_N_F_O =
      "EXTERNAL_INFO";
  private List<ExternalInfo> EXTERNAL_INFO = new ArrayList<>();

  /**
   * Niveau d&#39;urgence pour l&#39;affaire en cours Dans le cadre des échanges
   * LRM-NexSIS, optionnel
   */
  public enum URGENCYEnum {
    URGENT(String.valueOf("URGENT")),

    NOT_URGENT(String.valueOf("NOT_URGENT"));

    private String value;

    URGENCYEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static URGENCYEnum fromValue(String value) {
      for (URGENCYEnum b : URGENCYEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_U_R_G_E_N_C_Y = "URGENCY";
  private URGENCYEnum URGENCY;

  public Context() {}

  public Context ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * A constituer par le rédacteur du présent EMSI pour être unique, il est
   *préconisé de reprendre la valeur du champ messageId de l&#39;entête RC-DE.
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

  public Context MODE(MODEEnum MODE) {

    this.MODE = MODE;
    return this;
  }

  /**
   * Valeur constante dans le cadre des échanges LRM-NexSIS : ACTUAL
   * @return MODE
   **/
  @JsonProperty(JSON_PROPERTY_M_O_D_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MODEEnum getMODE() {
    return MODE;
  }

  @JsonProperty(JSON_PROPERTY_M_O_D_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMODE(MODEEnum MODE) {
    this.MODE = MODE;
  }

  public Context MSGTYPE(MSGTYPEEnum MSGTYPE) {

    this.MSGTYPE = MSGTYPE;
    return this;
  }

  /**
   * - A valoriser avec la valeur \&quot;ALERT\&quot; lors du premier échange
   *entre systèmes. - A valoriser avec la valeur constante \&quot;UPDATE\&quot;
   *ensuite. Peut ne pas être interprété par les LRM.
   * @return MSGTYPE
   **/
  @JsonProperty(JSON_PROPERTY_M_S_G_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MSGTYPEEnum getMSGTYPE() {
    return MSGTYPE;
  }

  @JsonProperty(JSON_PROPERTY_M_S_G_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMSGTYPE(MSGTYPEEnum MSGTYPE) {
    this.MSGTYPE = MSGTYPE;
  }

  public Context CREATION(OffsetDateTime CREATION) {

    this.CREATION = CREATION;
    return this;
  }

  /**
   * Obligatoire dans le cadre d&#39;une demande de concours, contient la date
   *de création de la demande de concours dans le système du partenaire
   *requérant. A valoriser avec le même horaire que dateTimeSent dans le message
   *RC-DE associé. Dans le cadre d&#39;une demande de concours, obligatoire. Ce
   *champ est valorisée avec l&#39;heure de création de la demande de concours
   *chez le partenaire emetteur. L&#39;heure d&#39;envoi du message peut être
   *obtenue via l&#39;enveloppe EDXL-DE (se référer au DST)
   * @return CREATION
   **/
  @JsonProperty(JSON_PROPERTY_C_R_E_A_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCREATION() {
    return CREATION;
  }

  @JsonProperty(JSON_PROPERTY_C_R_E_A_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCREATION(OffsetDateTime CREATION) {
    this.CREATION = CREATION;
  }

  public Context LINK(List<Link> LINK) {

    this.LINK = LINK;
    return this;
  }

  public Context addlINKItem(Link LINKItem) {
    if (this.LINK == null) {
      this.LINK = new ArrayList<>();
    }
    this.LINK.add(LINKItem);
    return this;
  }

  /**
   * Get LINK
   * @return LINK
   **/
  @JsonProperty(JSON_PROPERTY_L_I_N_K)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Link> getLINK() {
    return LINK;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_L_I_N_K)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLINK(List<Link> LINK) {
    if (LINK == null) {
      return;
    }
    if (this.LINK == null) {
      this.LINK = new ArrayList<>();
    }
    this.LINK.addAll(LINK);
  }

  public Context LEVEL(LEVELEnum LEVEL) {

    this.LEVEL = LEVEL;
    return this;
  }

  /**
   * A valoriser avec la valeur constante \&quot;OPR\&quot; dans le cadre
   *d&#39;un message EMSI, incluant une mission OPG
   * @return LEVEL
   **/
  @JsonProperty(JSON_PROPERTY_L_E_V_E_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LEVELEnum getLEVEL() {
    return LEVEL;
  }

  @JsonProperty(JSON_PROPERTY_L_E_V_E_L)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLEVEL(LEVELEnum LEVEL) {
    this.LEVEL = LEVEL;
  }

  public Context SECLASS(SECLASSEnum SECLASS) {

    this.SECLASS = SECLASS;
    return this;
  }

  /**
   * Optionnel  Dans NexSIS ;  Les messages transmis par NexSIS auront un champ
   *valorisé avec systématiquement le même code:
   *\&quot;RESTRC\&quot;&#x3D;restricted Les LRM doivent également renseigner la
   *valeur \&quot;RESTRC\&quot;
   * @return SECLASS
   **/
  @JsonProperty(JSON_PROPERTY_S_E_C_L_A_S_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SECLASSEnum getSECLASS() {
    return SECLASS;
  }

  @JsonProperty(JSON_PROPERTY_S_E_C_L_A_S_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSECLASS(SECLASSEnum SECLASS) {
    this.SECLASS = SECLASS;
  }

  public Context FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Texte libre, optionnel  Dans NexSIS; Fonction de l&#39;événement générateur
   *RG 1 : la valeur de &lt;context&gt;&lt;freetext&gt; reste à  &#39;Création
   *d&#39;un événement opérationnel EMSI&#39; &amp; version &amp; &#39;suite à
   *réception d&#39;une affaire*&#39; dans le cadre de la création d&#39;une
   *opération commune (conforme RG 2 de NEXSIS-6618) RG 3 : les événements
   *générateurs sont ceux définis au sein de NEXSIS-6619 RG 1 de traçabilité  (
   *input &#x3D; &lt;Evenement à l&#39;origine&gt; &#x3D; CREATION_OPERATION /
   *MAJ_MODIFICATION_ETAT_OPERATION / AJOUT_RESSOURCE / RETRAIT_RESSOURCE /
   *MAJ_ETAT_SITUATION_RESSOURCE / MAJ_LOCALISATION_ADRESSE) auxquels seront
   *ajoutés  les éventuels événements à venir.
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

  public Context ORIGIN(Origin ORIGIN) {

    this.ORIGIN = ORIGIN;
    return this;
  }

  /**
   * Get ORIGIN
   * @return ORIGIN
   **/
  @JsonProperty(JSON_PROPERTY_O_R_I_G_I_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Origin getORIGIN() {
    return ORIGIN;
  }

  @JsonProperty(JSON_PROPERTY_O_R_I_G_I_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setORIGIN(Origin ORIGIN) {
    this.ORIGIN = ORIGIN;
  }

  public Context EXTERNAL_INFO(List<ExternalInfo> EXTERNAL_INFO) {

    this.EXTERNAL_INFO = EXTERNAL_INFO;
    return this;
  }

  public Context addeXTERNALINFOItem(ExternalInfo EXTERNAL_INFOItem) {
    if (this.EXTERNAL_INFO == null) {
      this.EXTERNAL_INFO = new ArrayList<>();
    }
    this.EXTERNAL_INFO.add(EXTERNAL_INFOItem);
    return this;
  }

  /**
   * Get EXTERNAL_INFO
   * @return EXTERNAL_INFO
   **/
  @JsonProperty(JSON_PROPERTY_E_X_T_E_R_N_A_L_I_N_F_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalInfo> getEXTERNALINFO() {
    return EXTERNAL_INFO;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_E_X_T_E_R_N_A_L_I_N_F_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEXTERNALINFO(List<ExternalInfo> EXTERNAL_INFO) {
    if (EXTERNAL_INFO == null) {
      return;
    }
    if (this.EXTERNAL_INFO == null) {
      this.EXTERNAL_INFO = new ArrayList<>();
    }
    this.EXTERNAL_INFO.addAll(EXTERNAL_INFO);
  }

  public Context URGENCY(URGENCYEnum URGENCY) {

    this.URGENCY = URGENCY;
    return this;
  }

  /**
   * Niveau d&#39;urgence pour l&#39;affaire en cours Dans le cadre des échanges
   *LRM-NexSIS, optionnel
   * @return URGENCY
   **/
  @JsonProperty(JSON_PROPERTY_U_R_G_E_N_C_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URGENCYEnum getURGENCY() {
    return URGENCY;
  }

  @JsonProperty(JSON_PROPERTY_U_R_G_E_N_C_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setURGENCY(URGENCYEnum URGENCY) {
    this.URGENCY = URGENCY;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Context context = (Context)o;
    return Objects.equals(this.ID, context.ID) &&
        Objects.equals(this.MODE, context.MODE) &&
        Objects.equals(this.MSGTYPE, context.MSGTYPE) &&
        Objects.equals(this.CREATION, context.CREATION) &&
        Objects.equals(this.LINK, context.LINK) &&
        Objects.equals(this.LEVEL, context.LEVEL) &&
        Objects.equals(this.SECLASS, context.SECLASS) &&
        Objects.equals(this.FREETEXT, context.FREETEXT) &&
        Objects.equals(this.ORIGIN, context.ORIGIN) &&
        Objects.equals(this.EXTERNAL_INFO, context.EXTERNAL_INFO) &&
        Objects.equals(this.URGENCY, context.URGENCY);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, MODE, MSGTYPE, CREATION, LINK, LEVEL, SECLASS,
                        FREETEXT, ORIGIN, EXTERNAL_INFO, URGENCY);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Context {\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    MODE: ").append(toIndentedString(MODE)).append("\n");
    sb.append("    MSGTYPE: ").append(toIndentedString(MSGTYPE)).append("\n");
    sb.append("    CREATION: ").append(toIndentedString(CREATION)).append("\n");
    sb.append("    LINK: ").append(toIndentedString(LINK)).append("\n");
    sb.append("    LEVEL: ").append(toIndentedString(LEVEL)).append("\n");
    sb.append("    SECLASS: ").append(toIndentedString(SECLASS)).append("\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
    sb.append("    ORIGIN: ").append(toIndentedString(ORIGIN)).append("\n");
    sb.append("    EXTERNAL_INFO: ")
        .append(toIndentedString(EXTERNAL_INFO))
        .append("\n");
    sb.append("    URGENCY: ").append(toIndentedString(URGENCY)).append("\n");
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
