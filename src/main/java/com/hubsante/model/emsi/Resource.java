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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.emsi.Contact;
import com.hubsante.model.emsi.Rgeo;
import com.hubsante.model.emsi.Rtype;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Resource
 */
@JsonPropertyOrder(
    {Resource.JSON_PROPERTY_R_T_Y_P_E, Resource.JSON_PROPERTY_I_D,
     Resource.JSON_PROPERTY_O_R_G_I_D, Resource.JSON_PROPERTY_N_A_M_E,
     Resource.JSON_PROPERTY_F_R_E_E_T_E_X_T, Resource.JSON_PROPERTY_R_G_E_O,
     Resource.JSON_PROPERTY_Q_U_A_N_T_I_T_Y, Resource.JSON_PROPERTY_U_M,
     Resource.JSON_PROPERTY_S_T_A_T_U_S,
     Resource.JSON_PROPERTY_N_A_T_I_O_N_A_L_I_T_Y,
     Resource.JSON_PROPERTY_C_O_N_T_A_C_T_S})
@JsonTypeName("resource")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
  public static final String JSON_PROPERTY_R_T_Y_P_E = "RTYPE";
  private Rtype RTYPE;

  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  public static final String JSON_PROPERTY_O_R_G_I_D = "ORG_ID";
  private String ORG_ID;

  public static final String JSON_PROPERTY_N_A_M_E = "NAME";
  private String NAME;

  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public static final String JSON_PROPERTY_R_G_E_O = "RGEO";
  private List<Rgeo> RGEO;

  public static final String JSON_PROPERTY_Q_U_A_N_T_I_T_Y = "QUANTITY";
  private BigDecimal QUANTITY;

  /**
   * Dans le cadre d&#39;un échange d&#39;opération, optionnel. Unité de mesure
   * pour des ressources consommables
   */
  public enum UMEnum {
    LSV("LSV"),

    OTH("OTH"),

    PKG("PKG"),

    TIM("TIM"),

    WGT("WGT"),

    LSV_CM("LSV/CM"),

    LSV_CMH("LSV/CMH"),

    LSV_CNTLTR("LSV/CNTLTR"),

    LSV_DEG("LSV/DEG"),

    LSV_HCTLTR("LSV/HCTLTR"),

    LSV_HCTMTR("LSV/HCTMTR"),

    LSV_KM("LSV/KM"),

    LSV_KPH("LSV/KPH"),

    LSV_LI("LSV/LI"),

    LSV_LTPRHR("LSV/LTPRHR"),

    LSV_LTPRMN("LSV/LTPRMN"),

    LSV_METRE("LSV/METRE"),

    LSV_MILLTR("LSV/MILLTR"),

    LSV_MILMTR("LSV/MILMTR"),

    LSV_SMH("LSV/SMH"),

    LSV_SQM("LSV/SQM"),

    OTH_COIL("OTH/COIL"),

    OTH_DOZEN("OTH/DOZEN"),

    OTH_EA("OTH/EA"),

    OTH_GROSS("OTH/GROSS"),

    OTH_MANHUR("OTH/MANHUR"),

    OTH_MHPRHR("OTH/MHPRHR"),

    PKG_BALE("PKG/BALE"),

    PKG_BARREL("PKG/BARREL"),

    PKG_BLK("PKG/BLK"),

    PKG_BOX("PKG/BOX"),

    PKG_CASE("PKG/CASE"),

    PKG_CONTNR("PKG/CONTNR"),

    PKG_CRATE("PKG/CRATE"),

    PKG_DRM("PKG/DRM"),

    PKG_JERCAN("PKG/JERCAN"),

    PKG_PAK("PKG/PAK"),

    PKG_PAL("PKG/PAL"),

    PKG_RATION("PKG/RATION"),

    TIM_DAY("TIM/DAY"),

    TIM_HR("TIM/HR"),

    TIM_MINUTE("TIM/MINUTE"),

    TIM_MON("TIM/MON"),

    TIM_SECOND("TIM/SECOND"),

    TIM_WEK("TIM/WEK"),

    TIM_YEA("TIM/YEA"),

    WGT_CNTGRM("WGT/CNTGRM"),

    WGT_GRAM("WGT/GRAM"),

    WGT_KG("WGT/KG"),

    WGT_KGH("WGT/KGH");

    private String value;

    UMEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UMEnum fromValue(String value) {
      for (UMEnum b : UMEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_U_M = "UM";
  private UMEnum UM;

  /**
   * Définit le statut de disponibilité d&#39;une ressource. - AVAILB :
   * Lorsqu&#39;une mission est terminée, une ressource redevient disponible -
   * RESRVD : Lorsque la ressource est réservée pour intervenir sur
   * l&#39;affaire mais pas encore engagée dans l&#39;opération. Par exemple :
   * un SMUR termine un autre transfert patient/victime avant de rejoindre une
   * autre intervention : il est alors RESRVD - IN_USE/MOBILE : à utiliser pour
   * les véhicules et le personnel lorsqu&#39;ils se déplaces - IN_USE/ON_SCENE
   * : à utiliser pour les véhicules et le personnel lorsqu&#39;ils sont sur les
   * lieux de l&#39;affaire
   */
  public enum STATUSEnum {
    AVAILB("AVAILB"),

    UNAV("UNAV"),

    MAINTC("MAINTC"),

    RESRVD("RESRVD"),

    VIRTUAL("VIRTUAL"),

    IN_USE_MOBILE("IN_USE/MOBILE"),

    IN_USE_ON_SCENE("IN_USE/ON_SCENE");

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

  public static final String JSON_PROPERTY_N_A_T_I_O_N_A_L_I_T_Y =
      "NATIONALITY";
  private String NATIONALITY;

  public static final String JSON_PROPERTY_C_O_N_T_A_C_T_S = "CONTACTS";
  private List<Contact> CONTACTS;

  public Resource() {}

  public Resource RTYPE(Rtype RTYPE) {

    this.RTYPE = RTYPE;
    return this;
  }

  /**
   * Get RTYPE
   * @return RTYPE
   **/
  @JsonProperty(JSON_PROPERTY_R_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Rtype getRTYPE() {
    return RTYPE;
  }

  @JsonProperty(JSON_PROPERTY_R_T_Y_P_E)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRTYPE(Rtype RTYPE) {
    this.RTYPE = RTYPE;
  }

  public Resource ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * Identifiant unique de la ressource  dans le système du partenaire
   *propriétaire. Les systèmes sont garants de l&#39;unicité et de
   *l&#39;invariablité des ids de véhicule dans le temps. Ils peuvent se servir
   *des ids dans les référentiels existants si ils sont uniques et stables. Dans
   *le cas d&#39;un véhicule agrégé par un LRM (comme un SMUR), l&#39;ID doit
   *être valorisé avec son immatriculation. Dans le cas d&#39;un véhicule agrégé
   *par NexSIS, l&#39;ID fournit peut ne pas correspondre à une immatriculation.
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

  public Resource ORG_ID(String ORG_ID) {

    this.ORG_ID = ORG_ID;
    return this;
  }

  /**
   * Identifiant de l&#39;organisation à laquelle la ressource est rattachée
   *(caserne, SAMU etc). Se référer au DSF pour la structure normée des
   *organisations Le format est le suivant {pays}.{domaine}.{code
   *département}.{organisation}.{structure interne}*.{unité fonctionnelle}*.
   *Dans le cas où le LRM/NexSIS sert d&#39;aggrégateur pour des véhicules
   *appartenant à un partenaire tiers (type ambulance privée), l&#39;identifiant
   *d&#39;organisation permet d&#39;identifier ce tiers A constituer par le
   *rédacteur du présent EMSI pour être unique, identique à
   *&lt;CONTEXT&gt;&lt;ORIGIN&gt;&lt;ORG_ID&gt;
   * @return ORG_ID
   **/
  @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getORGID() {
    return ORG_ID;
  }

  @JsonProperty(JSON_PROPERTY_O_R_G_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setORGID(String ORG_ID) {
    this.ORG_ID = ORG_ID;
  }

  public Resource NAME(String NAME) {

    this.NAME = NAME;
    return this;
  }

  /**
   * Nom donné à la ressource par le partenaire. L&#39;immatriculation peut être
   *utilisée dans le nom courant des véhicules. Dans le cas pompier, les
   *véhicules sont nommés Dans le cas d&#39;équipier, cela peut être leur nom
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

  public Resource FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Texte libre permettant de décrire la ressource où d&#39;ajouter des
   *précisions sur son engagement. Permet aussi notamment de décrire des
   *attributs librement pour la ressource. Par exemple, pour un véhicule, sa
   *plaque d&#39;immatriculation.
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

  public Resource RGEO(List<Rgeo> RGEO) {

    this.RGEO = RGEO;
    return this;
  }

  public Resource addRGEOItem(Rgeo RGEOItem) {
    if (this.RGEO == null) {
      this.RGEO = new ArrayList<>();
    }
    this.RGEO.add(RGEOItem);
    return this;
  }

  /**
   * Get RGEO
   * @return RGEO
   **/
  @JsonProperty(JSON_PROPERTY_R_G_E_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Rgeo> getRGEO() {
    return RGEO;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_R_G_E_O)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRGEO(List<Rgeo> RGEO) {
    if (RGEO == null) {
      return;
    }
    if (this.RGEO == null) {
      this.RGEO = new ArrayList<>();
    }
    this.RGEO.addAll(RGEO);
  }

  public Resource QUANTITY(BigDecimal QUANTITY) {

    this.QUANTITY = QUANTITY;
    return this;
  }

  /**
   * Dans le cadre d&#39;un échange d&#39;opération, optionnel. Permet de
   *quantifier une ressource : - à ne pas utiliser pour les véhicules ni le
   *personnel - utilisable pour du matériel - utilisable pour des consommables
   *(dans le cas de consommable, à compléter avec le champ UM)
   * @return QUANTITY
   **/
  @JsonProperty(JSON_PROPERTY_Q_U_A_N_T_I_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getQUANTITY() {
    return QUANTITY;
  }

  @JsonProperty(JSON_PROPERTY_Q_U_A_N_T_I_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQUANTITY(BigDecimal QUANTITY) {
    this.QUANTITY = QUANTITY;
  }

  public Resource UM(UMEnum UM) {

    this.UM = UM;
    return this;
  }

  /**
   * Dans le cadre d&#39;un échange d&#39;opération, optionnel. Unité de mesure
   *pour des ressources consommables
   * @return UM
   **/
  @JsonProperty(JSON_PROPERTY_U_M)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UMEnum getUM() {
    return UM;
  }

  @JsonProperty(JSON_PROPERTY_U_M)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUM(UMEnum UM) {
    this.UM = UM;
  }

  public Resource STATUS(STATUSEnum STATUS) {

    this.STATUS = STATUS;
    return this;
  }

  /**
   * Définit le statut de disponibilité d&#39;une ressource. - AVAILB :
   *Lorsqu&#39;une mission est terminée, une ressource redevient disponible -
   *RESRVD : Lorsque la ressource est réservée pour intervenir sur l&#39;affaire
   *mais pas encore engagée dans l&#39;opération. Par exemple : un SMUR termine
   *un autre transfert patient/victime avant de rejoindre une autre intervention
   *: il est alors RESRVD - IN_USE/MOBILE : à utiliser pour les véhicules et le
   *personnel lorsqu&#39;ils se déplaces - IN_USE/ON_SCENE : à utiliser pour les
   *véhicules et le personnel lorsqu&#39;ils sont sur les lieux de l&#39;affaire
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

  public Resource NATIONALITY(String NATIONALITY) {

    this.NATIONALITY = NATIONALITY;
    return this;
  }

  /**
   * Nationalité d&#39;une ressource, réemployer ISO 3166-1-alpha-2 code
   *elements.
   * @return NATIONALITY
   **/
  @JsonProperty(JSON_PROPERTY_N_A_T_I_O_N_A_L_I_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNATIONALITY() {
    return NATIONALITY;
  }

  @JsonProperty(JSON_PROPERTY_N_A_T_I_O_N_A_L_I_T_Y)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNATIONALITY(String NATIONALITY) {
    this.NATIONALITY = NATIONALITY;
  }

  public Resource CONTACTS(List<Contact> CONTACTS) {

    this.CONTACTS = CONTACTS;
    return this;
  }

  public Resource addCONTACTSItem(Contact CONTACTSItem) {
    if (this.CONTACTS == null) {
      this.CONTACTS = new ArrayList<>();
    }
    this.CONTACTS.add(CONTACTSItem);
    return this;
  }

  /**
   * Get CONTACTS
   * @return CONTACTS
   **/
  @JsonProperty(JSON_PROPERTY_C_O_N_T_A_C_T_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Contact> getCONTACTS() {
    return CONTACTS;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_C_O_N_T_A_C_T_S)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCONTACTS(List<Contact> CONTACTS) {
    if (CONTACTS == null) {
      return;
    }
    if (this.CONTACTS == null) {
      this.CONTACTS = new ArrayList<>();
    }
    this.CONTACTS.addAll(CONTACTS);
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
    return Objects.equals(this.RTYPE, resource.RTYPE) &&
        Objects.equals(this.ID, resource.ID) &&
        Objects.equals(this.ORG_ID, resource.ORG_ID) &&
        Objects.equals(this.NAME, resource.NAME) &&
        Objects.equals(this.FREETEXT, resource.FREETEXT) &&
        Objects.equals(this.RGEO, resource.RGEO) &&
        Objects.equals(this.QUANTITY, resource.QUANTITY) &&
        Objects.equals(this.UM, resource.UM) &&
        Objects.equals(this.STATUS, resource.STATUS) &&
        Objects.equals(this.NATIONALITY, resource.NATIONALITY) &&
        Objects.equals(this.CONTACTS, resource.CONTACTS);
  }

  @Override
  public int hashCode() {
    return Objects.hash(RTYPE, ID, ORG_ID, NAME, FREETEXT, RGEO, QUANTITY, UM,
                        STATUS, NATIONALITY, CONTACTS);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    RTYPE: ").append(toIndentedString(RTYPE)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    ORG_ID: ").append(toIndentedString(ORG_ID)).append("\n");
    sb.append("    NAME: ").append(toIndentedString(NAME)).append("\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
    sb.append("    RGEO: ").append(toIndentedString(RGEO)).append("\n");
    sb.append("    QUANTITY: ").append(toIndentedString(QUANTITY)).append("\n");
    sb.append("    UM: ").append(toIndentedString(UM)).append("\n");
    sb.append("    STATUS: ").append(toIndentedString(STATUS)).append("\n");
    sb.append("    NATIONALITY: ")
        .append(toIndentedString(NATIONALITY))
        .append("\n");
    sb.append("    CONTACTS: ").append(toIndentedString(CONTACTS)).append("\n");
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
