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
import com.hubsante.model.emsi.Casualties;
import com.hubsante.model.emsi.Egeo;
import com.hubsante.model.emsi.Etype;
import com.hubsante.model.emsi.Evac;
import com.hubsante.model.emsi.Reference;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Event
 */
@JsonPropertyOrder(
    {Event.JSON_PROPERTY_I_D, Event.JSON_PROPERTY_N_A_M_E,
     Event.JSON_PROPERTY_M_A_I_N_E_V_E_N_T_I_D, Event.JSON_PROPERTY_E_T_Y_P_E,
     Event.JSON_PROPERTY_S_O_U_R_C_E, Event.JSON_PROPERTY_S_C_A_L_E,
     Event.JSON_PROPERTY_C_E_R_T_A_I_N_T_Y,
     Event.JSON_PROPERTY_D_E_C_L_D_A_T_I_M_E,
     Event.JSON_PROPERTY_O_C_C_D_A_T_I_M_E,
     Event.JSON_PROPERTY_O_B_S_D_A_T_I_M_E, Event.JSON_PROPERTY_S_T_A_T_U_S,
     Event.JSON_PROPERTY_R_I_S_K_A_S_S_E_S_M_E_N_T,
     Event.JSON_PROPERTY_R_E_F_E_R_E_N_C_E,
     Event.JSON_PROPERTY_C_A_S_U_A_L_T_I_E_S, Event.JSON_PROPERTY_E_V_A_C,
     Event.JSON_PROPERTY_E_G_E_O, Event.JSON_PROPERTY_C_A_U_S_E,
     Event.JSON_PROPERTY_F_R_E_E_T_E_X_T})
@JsonTypeName("event")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Event {
  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  public static final String JSON_PROPERTY_N_A_M_E = "NAME";
  private String NAME;

  public static final String JSON_PROPERTY_M_A_I_N_E_V_E_N_T_I_D =
      "MAIN_EVENT_ID";
  private String MAIN_EVENT_ID;

  public static final String JSON_PROPERTY_E_T_Y_P_E = "ETYPE";
  private Etype ETYPE;

  /**
   * Optionnel
   */
  public enum SOURCEEnum {
    COMFOR(String.valueOf("COMFOR")),

    HUMDED(String.valueOf("HUMDED")),

    HUMOBS(String.valueOf("HUMOBS")),

    SENSOR(String.valueOf("SENSOR"));

    private String value;

    SOURCEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SOURCEEnum fromValue(String value) {
      for (SOURCEEnum b : SOURCEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_S_O_U_R_C_E = "SOURCE";
  private SOURCEEnum SOURCE;

  /**
   * Optionnel, Niveau de criticité de l&#39;opération
   */
  public enum SCALEEnum {
    _1(String.valueOf("1")),

    _2(String.valueOf("2")),

    _3(String.valueOf("3")),

    _4(String.valueOf("4")),

    _5(String.valueOf("5"));

    private String value;

    SCALEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SCALEEnum fromValue(String value) {
      for (SCALEEnum b : SCALEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_S_C_A_L_E = "SCALE";
  private SCALEEnum SCALE;

  public static final String JSON_PROPERTY_C_E_R_T_A_I_N_T_Y = "CERTAINTY";
  private Integer CERTAINTY;

  public static final String JSON_PROPERTY_D_E_C_L_D_A_T_I_M_E = "DECL_DATIME";
  private OffsetDateTime DECL_DATIME;

  public static final String JSON_PROPERTY_O_C_C_D_A_T_I_M_E = "OCC_DATIME";
  private OffsetDateTime OCC_DATIME;

  public static final String JSON_PROPERTY_O_B_S_D_A_T_I_M_E = "OBS_DATIME";
  private OffsetDateTime OBS_DATIME;

  /**
   * Permet de décrire le status de l&#39;affaire en cours. Ce champ suit une
   * nomenclature EMSI. (COM &#x3D; event complete, IPR &#x3D; event in
   * progress, NST &#x3D; event not started, STOP &#x3D; STOP &#x3D; event under
   * control, no need for additional resource) Dans le cadre d&#39;une opération
   * : - si l&#39;opération est encore en cours : rensigner &#39;IPR&#39;, - si
   * le dispatching de moyens est encore en cours ou que seulement des
   * qualifications d&#39;alertes ont été échangées sans aucune décision de
   * régulation &#39;NST&#39;, - si l&#39;opération est en pause/veille :
   * &#39;STOP&#39; - si le message d&#39;échange opérationnel décrit une fin
   * d&#39;opération, à renseigner avec &#39;COM&#39; Un message EMSI-EO sans
   * RESSOURCE ni
   */
  public enum STATUSEnum {
    COM(String.valueOf("COM")),

    IPR(String.valueOf("IPR")),

    NST(String.valueOf("NST")),

    STOP(String.valueOf("STOP"));

    private String value;

    STATUSEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static STATUSEnum fromValue(String value) {
      for (STATUSEnum b : STATUSEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_S_T_A_T_U_S = "STATUS";
  private STATUSEnum STATUS;

  /**
   * Optionnel
   */
  public enum RISKASSESMENTEnum {
    NCREA(String.valueOf("NCREA")),

    DECREA(String.valueOf("DECREA")),

    STABLE(String.valueOf("STABLE"));

    private String value;

    RISKASSESMENTEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RISKASSESMENTEnum fromValue(String value) {
      for (RISKASSESMENTEnum b : RISKASSESMENTEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_R_I_S_K_A_S_S_E_S_M_E_N_T =
      "RISK_ASSESMENT";
  private RISKASSESMENTEnum RISK_ASSESMENT;

  public static final String JSON_PROPERTY_R_E_F_E_R_E_N_C_E = "REFERENCE";
  private List<Reference> REFERENCE = new ArrayList<>();

  public static final String JSON_PROPERTY_C_A_S_U_A_L_T_I_E_S = "CASUALTIES";
  private List<Casualties> CASUALTIES = new ArrayList<>();

  public static final String JSON_PROPERTY_E_V_A_C = "EVAC";
  private List<Evac> EVAC = new ArrayList<>();

  public static final String JSON_PROPERTY_E_G_E_O = "EGEO";
  private List<Egeo> EGEO = new ArrayList<>();

  /**
   * Optionnel
   */
  public enum CAUSEEnum {
    ACC(String.valueOf("ACC")),

    DEL(String.valueOf("DEL")),

    NAT(String.valueOf("NAT"));

    private String value;

    CAUSEEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CAUSEEnum fromValue(String value) {
      for (CAUSEEnum b : CAUSEEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_C_A_U_S_E = "CAUSE";
  private CAUSEEnum CAUSE;

  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public Event() {}

  public Event ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * A renseigner avec l&#39;identifiant local de l&#39;affaire dans le LRM ou
   *NexSIS
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

  public Event NAME(String NAME) {

    this.NAME = NAME;
    return this;
  }

  /**
   * Optionnel Dans nexSIS; [libelle NF 1 métier] &amp; \&quot; - \&quot; &amp;
   *[libelle TL 1 métier] &amp; \&quot; - \&quot; &amp; [libellé commune]
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

  public Event MAIN_EVENT_ID(String MAIN_EVENT_ID) {

    this.MAIN_EVENT_ID = MAIN_EVENT_ID;
    return this;
  }

  /**
   * A renseigner avec l&#39;identifiant de l&#39;organisation (champ
   *organization du message RC-EDA) suivi de l&#39;identifiant local de
   *l&#39;affaire du partenaire requérant (champ senderCaseId du message
   *RC-EDA). {pays}.{domaine}.{organisation}.{structure interne}*.{unité
   *fonctionnelle}*.{numéro de dossier}  NB : Si l&#39;initiateur du partage de
   *dossier est le même que l&#39;initiateur du message EMSI, l&#39;EVENT.ID
   *&#x3D; EVENT.MAIN_EVENT_ID
   * @return MAIN_EVENT_ID
   **/
  @JsonProperty(JSON_PROPERTY_M_A_I_N_E_V_E_N_T_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMAINEVENTID() {
    return MAIN_EVENT_ID;
  }

  @JsonProperty(JSON_PROPERTY_M_A_I_N_E_V_E_N_T_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMAINEVENTID(String MAIN_EVENT_ID) {
    this.MAIN_EVENT_ID = MAIN_EVENT_ID;
  }

  public Event ETYPE(Etype ETYPE) {

    this.ETYPE = ETYPE;
    return this;
  }

  /**
   * Get ETYPE
   * @return ETYPE
   **/
  @JsonProperty(JSON_PROPERTY_E_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Etype getETYPE() {
    return ETYPE;
  }

  @JsonProperty(JSON_PROPERTY_E_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setETYPE(Etype ETYPE) {
    this.ETYPE = ETYPE;
  }

  public Event SOURCE(SOURCEEnum SOURCE) {

    this.SOURCE = SOURCE;
    return this;
  }

  /**
   * Optionnel
   * @return SOURCE
   **/
  @JsonProperty(JSON_PROPERTY_S_O_U_R_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SOURCEEnum getSOURCE() {
    return SOURCE;
  }

  @JsonProperty(JSON_PROPERTY_S_O_U_R_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSOURCE(SOURCEEnum SOURCE) {
    this.SOURCE = SOURCE;
  }

  public Event SCALE(SCALEEnum SCALE) {

    this.SCALE = SCALE;
    return this;
  }

  /**
   * Optionnel, Niveau de criticité de l&#39;opération
   * @return SCALE
   **/
  @JsonProperty(JSON_PROPERTY_S_C_A_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SCALEEnum getSCALE() {
    return SCALE;
  }

  @JsonProperty(JSON_PROPERTY_S_C_A_L_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSCALE(SCALEEnum SCALE) {
    this.SCALE = SCALE;
  }

  public Event CERTAINTY(Integer CERTAINTY) {

    this.CERTAINTY = CERTAINTY;
    return this;
  }

  /**
   * Prend une valeur entière entre 0 et 100, et décrit à quel point
   *l&#39;alerte associée à l&#39;événement est fiable Optionnel
   * @return CERTAINTY
   **/
  @JsonProperty(JSON_PROPERTY_C_E_R_T_A_I_N_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCERTAINTY() {
    return CERTAINTY;
  }

  @JsonProperty(JSON_PROPERTY_C_E_R_T_A_I_N_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCERTAINTY(Integer CERTAINTY) {
    this.CERTAINTY = CERTAINTY;
  }

  public Event DECL_DATIME(OffsetDateTime DECL_DATIME) {

    this.DECL_DATIME = DECL_DATIME;
    return this;
  }

  /**
   * Dans le cadre d&#39;une demande de concours, ce champ est valorisé avec la
   *date/heure de création de l&#39;affaire ou de l&#39;opération. NexSIS
   *transmettra la date/heure de création de l&#39;opération dans ses systèmes
   *(qui peut diverger de la date/heure de création de l&#39;affaire)
   * @return DECL_DATIME
   **/
  @JsonProperty(JSON_PROPERTY_D_E_C_L_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getDECLDATIME() {
    return DECL_DATIME;
  }

  @JsonProperty(JSON_PROPERTY_D_E_C_L_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDECLDATIME(OffsetDateTime DECL_DATIME) {
    this.DECL_DATIME = DECL_DATIME;
  }

  public Event OCC_DATIME(OffsetDateTime OCC_DATIME) {

    this.OCC_DATIME = OCC_DATIME;
    return this;
  }

  /**
   * Dans le cadre d&#39;une demande de concours, ce champ est valorisé avec la
   *date de la première alerte ou la date évaluée de début de la situation
   *d&#39;urgence. Par exemple : Si un incendie est déclaré est 9h02, il a pu
   *démarré à 8h55 par exemple. NB : temporairement, NexSIS renseignera ce champ
   *avec la date de réception de l&#39;alerte initiale
   * @return OCC_DATIME
   **/
  @JsonProperty(JSON_PROPERTY_O_C_C_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getOCCDATIME() {
    return OCC_DATIME;
  }

  @JsonProperty(JSON_PROPERTY_O_C_C_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOCCDATIME(OffsetDateTime OCC_DATIME) {
    this.OCC_DATIME = OCC_DATIME;
  }

  public Event OBS_DATIME(OffsetDateTime OBS_DATIME) {

    this.OBS_DATIME = OBS_DATIME;
    return this;
  }

  /**
   * Ce champ est idéalement à valoriser avec la date/heure à laquelle
   *l&#39;observation de la situation d&#39;urgence de l&#39;affaire la plus
   *récente a été réalisée. NexSIS transmettra la date/heure d&#39;envoi de la
   *demande de concours dans son système. NB : temporairement, NexSIS
   *renseignera ce champ avec la date de réception de l&#39;alerte initiale
   * @return OBS_DATIME
   **/
  @JsonProperty(JSON_PROPERTY_O_B_S_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getOBSDATIME() {
    return OBS_DATIME;
  }

  @JsonProperty(JSON_PROPERTY_O_B_S_D_A_T_I_M_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOBSDATIME(OffsetDateTime OBS_DATIME) {
    this.OBS_DATIME = OBS_DATIME;
  }

  public Event STATUS(STATUSEnum STATUS) {

    this.STATUS = STATUS;
    return this;
  }

  /**
   * Permet de décrire le status de l&#39;affaire en cours. Ce champ suit une
   *nomenclature EMSI. (COM &#x3D; event complete, IPR &#x3D; event in progress,
   *NST &#x3D; event not started, STOP &#x3D; STOP &#x3D; event under control,
   *no need for additional resource) Dans le cadre d&#39;une opération : - si
   *l&#39;opération est encore en cours : rensigner &#39;IPR&#39;, - si le
   *dispatching de moyens est encore en cours ou que seulement des
   *qualifications d&#39;alertes ont été échangées sans aucune décision de
   *régulation &#39;NST&#39;, - si l&#39;opération est en pause/veille :
   *&#39;STOP&#39; - si le message d&#39;échange opérationnel décrit une fin
   *d&#39;opération, à renseigner avec &#39;COM&#39; Un message EMSI-EO sans
   *RESSOURCE ni
   * @return STATUS
   **/
  @JsonProperty(JSON_PROPERTY_S_T_A_T_U_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public STATUSEnum getSTATUS() {
    return STATUS;
  }

  @JsonProperty(JSON_PROPERTY_S_T_A_T_U_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSTATUS(STATUSEnum STATUS) {
    this.STATUS = STATUS;
  }

  public Event RISK_ASSESMENT(RISKASSESMENTEnum RISK_ASSESMENT) {

    this.RISK_ASSESMENT = RISK_ASSESMENT;
    return this;
  }

  /**
   * Optionnel
   * @return RISK_ASSESMENT
   **/
  @JsonProperty(JSON_PROPERTY_R_I_S_K_A_S_S_E_S_M_E_N_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public RISKASSESMENTEnum getRISKASSESMENT() {
    return RISK_ASSESMENT;
  }

  @JsonProperty(JSON_PROPERTY_R_I_S_K_A_S_S_E_S_M_E_N_T)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRISKASSESMENT(RISKASSESMENTEnum RISK_ASSESMENT) {
    this.RISK_ASSESMENT = RISK_ASSESMENT;
  }

  public Event REFERENCE(List<Reference> REFERENCE) {

    this.REFERENCE = REFERENCE;
    return this;
  }

  public Event addrEFERENCEItem(Reference REFERENCEItem) {
    if (this.REFERENCE == null) {
      this.REFERENCE = new ArrayList<>();
    }
    this.REFERENCE.add(REFERENCEItem);
    return this;
  }

  /**
   * Get REFERENCE
   * @return REFERENCE
   **/
  @JsonProperty(JSON_PROPERTY_R_E_F_E_R_E_N_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getREFERENCE() {
    return REFERENCE;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_R_E_F_E_R_E_N_C_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setREFERENCE(List<Reference> REFERENCE) {
    if (REFERENCE == null) {
      return;
    }
    if (this.REFERENCE == null) {
      this.REFERENCE = new ArrayList<>();
    }
    this.REFERENCE.addAll(REFERENCE);
  }

  public Event CASUALTIES(List<Casualties> CASUALTIES) {

    this.CASUALTIES = CASUALTIES;
    return this;
  }

  public Event addcASUALTIESItem(Casualties CASUALTIESItem) {
    if (this.CASUALTIES == null) {
      this.CASUALTIES = new ArrayList<>();
    }
    this.CASUALTIES.add(CASUALTIESItem);
    return this;
  }

  /**
   * Get CASUALTIES
   * @return CASUALTIES
   **/
  @JsonProperty(JSON_PROPERTY_C_A_S_U_A_L_T_I_E_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Casualties> getCASUALTIES() {
    return CASUALTIES;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_C_A_S_U_A_L_T_I_E_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCASUALTIES(List<Casualties> CASUALTIES) {
    if (CASUALTIES == null) {
      return;
    }
    if (this.CASUALTIES == null) {
      this.CASUALTIES = new ArrayList<>();
    }
    this.CASUALTIES.addAll(CASUALTIES);
  }

  public Event EVAC(List<Evac> EVAC) {

    this.EVAC = EVAC;
    return this;
  }

  public Event addeVACItem(Evac EVACItem) {
    if (this.EVAC == null) {
      this.EVAC = new ArrayList<>();
    }
    this.EVAC.add(EVACItem);
    return this;
  }

  /**
   * Get EVAC
   * @return EVAC
   **/
  @JsonProperty(JSON_PROPERTY_E_V_A_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Evac> getEVAC() {
    return EVAC;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_E_V_A_C)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEVAC(List<Evac> EVAC) {
    if (EVAC == null) {
      return;
    }
    if (this.EVAC == null) {
      this.EVAC = new ArrayList<>();
    }
    this.EVAC.addAll(EVAC);
  }

  public Event EGEO(List<Egeo> EGEO) {

    this.EGEO = EGEO;
    return this;
  }

  public Event addeGEOItem(Egeo EGEOItem) {
    if (this.EGEO == null) {
      this.EGEO = new ArrayList<>();
    }
    this.EGEO.add(EGEOItem);
    return this;
  }

  /**
   * Get EGEO
   * @return EGEO
   **/
  @JsonProperty(JSON_PROPERTY_E_G_E_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Egeo> getEGEO() {
    return EGEO;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_E_G_E_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEGEO(List<Egeo> EGEO) {
    if (EGEO == null) {
      return;
    }
    if (this.EGEO == null) {
      this.EGEO = new ArrayList<>();
    }
    this.EGEO.addAll(EGEO);
  }

  public Event CAUSE(CAUSEEnum CAUSE) {

    this.CAUSE = CAUSE;
    return this;
  }

  /**
   * Optionnel
   * @return CAUSE
   **/
  @JsonProperty(JSON_PROPERTY_C_A_U_S_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public CAUSEEnum getCAUSE() {
    return CAUSE;
  }

  @JsonProperty(JSON_PROPERTY_C_A_U_S_E)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCAUSE(CAUSEEnum CAUSE) {
    this.CAUSE = CAUSE;
  }

  public Event FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Optionnel
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event)o;
    return Objects.equals(this.ID, event.ID) &&
        Objects.equals(this.NAME, event.NAME) &&
        Objects.equals(this.MAIN_EVENT_ID, event.MAIN_EVENT_ID) &&
        Objects.equals(this.ETYPE, event.ETYPE) &&
        Objects.equals(this.SOURCE, event.SOURCE) &&
        Objects.equals(this.SCALE, event.SCALE) &&
        Objects.equals(this.CERTAINTY, event.CERTAINTY) &&
        Objects.equals(this.DECL_DATIME, event.DECL_DATIME) &&
        Objects.equals(this.OCC_DATIME, event.OCC_DATIME) &&
        Objects.equals(this.OBS_DATIME, event.OBS_DATIME) &&
        Objects.equals(this.STATUS, event.STATUS) &&
        Objects.equals(this.RISK_ASSESMENT, event.RISK_ASSESMENT) &&
        Objects.equals(this.REFERENCE, event.REFERENCE) &&
        Objects.equals(this.CASUALTIES, event.CASUALTIES) &&
        Objects.equals(this.EVAC, event.EVAC) &&
        Objects.equals(this.EGEO, event.EGEO) &&
        Objects.equals(this.CAUSE, event.CAUSE) &&
        Objects.equals(this.FREETEXT, event.FREETEXT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, NAME, MAIN_EVENT_ID, ETYPE, SOURCE, SCALE,
                        CERTAINTY, DECL_DATIME, OCC_DATIME, OBS_DATIME, STATUS,
                        RISK_ASSESMENT, REFERENCE, CASUALTIES, EVAC, EGEO,
                        CAUSE, FREETEXT);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
    sb.append("    MAIN_EVENT_ID: ")
        .append(toIndentedString(MAIN_EVENT_ID))
        .append("\n");
    sb.append("    ETYPE: ").append(toIndentedString(ETYPE)).append("\n");
    sb.append("    SOURCE: ").append(toIndentedString(SOURCE)).append("\n");
    sb.append("    SCALE: ").append(toIndentedString(SCALE)).append("\n");
    sb.append("    CERTAINTY: ")
        .append(toIndentedString(CERTAINTY))
        .append("\n");
    sb.append("    DECL_DATIME: ")
        .append(toIndentedString(DECL_DATIME))
        .append("\n");
    sb.append("    OCC_DATIME: ")
        .append(toIndentedString(OCC_DATIME))
        .append("\n");
    sb.append("    OBS_DATIME: ")
        .append(toIndentedString(OBS_DATIME))
        .append("\n");
    sb.append("    STATUS: ").append(toIndentedString(STATUS)).append("\n");
    sb.append("    RISK_ASSESMENT: ")
        .append(toIndentedString(RISK_ASSESMENT))
        .append("\n");
    sb.append("    REFERENCE: ")
        .append(toIndentedString(REFERENCE))
        .append("\n");
    sb.append("    CASUALTIES: ")
        .append(toIndentedString(CASUALTIES))
        .append("\n");
    sb.append("    EVAC: ").append(toIndentedString(EVAC)).append("\n");
    sb.append("    EGEO: ").append(toIndentedString(EGEO)).append("\n");
    sb.append("    CAUSE: ").append(toIndentedString(CAUSE)).append("\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
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
