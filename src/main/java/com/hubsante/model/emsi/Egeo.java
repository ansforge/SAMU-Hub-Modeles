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
 * Egeo
 */
@JsonPropertyOrder({Egeo.JSON_PROPERTY_D_A_T_I_M_E, Egeo.JSON_PROPERTY_T_Y_P_E,
                    Egeo.JSON_PROPERTY_W_E_A_T_H_E_R,
                    Egeo.JSON_PROPERTY_F_R_E_E_T_E_X_T,
                    Egeo.JSON_PROPERTY_P_O_S_I_T_I_O_N})
@JsonTypeName("egeo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Egeo {
  public static final String JSON_PROPERTY_D_A_T_I_M_E = "DATIME";
  private OffsetDateTime DATIME;

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   * message RC-EDA et le lieu souhaité pour l&#39;intervention est
   * systématiquement reprécisé dans un objet MISSION. A constituer depuis
   * ref_mapping_EMSI_EVENT_EGEO_TYPE_NEXSIS_ /!\\ plusieurs champs NEXSIS /!\\
   * plusieurs valeurs par champs d&#39;où un groupe&lt;EGEO&gt; à créer par
   * type différents
   */
  public enum TYPEEnum {
    AIR("AIR"),

    CMB("CMB"),

    DGR("DGR"),

    FLAME("FLAME"),

    GEN("GEN"),

    PLUME("PLUME"),

    SMOKE("SMOKE"),

    VULN("VULN"),

    AIR_COR("AIR/COR"),

    AIR_FLDZ("AIR/FLDZ"),

    AIR_LZ("AIR/LZ"),

    AIR_NOFLZN("AIR/NOFLZN"),

    AIR_PZ("AIR/PZ"),

    AIR_UAVASP("AIR/UAVASP"),

    CMB_CZ("CMB/CZ"),

    CMB_DNGR("CMB/DNGR"),

    CMB_EXTZN("CMB/EXTZN"),

    CMB_IMPTPT("CMB/IMPTPT"),

    DGR_BIO("DGR/BIO"),

    DGR_BOMB("DGR/BOMB"),

    DGR_CBRNHZ("DGR/CBRNHZ"),

    DGR_CBRNRSD("DGR/CBRNRSD"),

    DGR_CHM("DGR/CHM"),

    DGR_HZD("DGR/HZD"),

    DGR_MIND("DGR/MIND"),

    DGR_NGA("DGR/NGA"),

    DGR_NGACIV("DGR/NGACIV"),

    DGR_NUKCNL("DGR/NUKCNL"),

    DGR_OBSGEN("DGR/OBSGEN"),

    DGR_PRHBAR("DGR/PRHBAR"),

    DGR_RAD("DGR/RAD"),

    DGR_RADCLD("DGR/RADCLD"),

    DGR_RSTR("DGR/RSTR"),

    DGR_SGA("DGR/SGA"),

    DGR_SITKIL("DGR/SITKIL"),

    DGR_UNXOD("DGR/UNXOD"),

    GEN_AOR("GEN/AOR"),

    GEN_ASYGEN("GEN/ASYGEN"),

    GEN_ASYSPL("GEN/ASYSPL"),

    GEN_BDYOR("GEN/BDYOR"),

    GEN_BDYPOA("GEN/BDYPOA"),

    GEN_BDYPT("GEN/BDYPT"),

    GEN_CKPGEN("GEN/CKPGEN"),

    GEN_CNTPTL("GEN/CNTPTL"),

    GEN_COLDZ("GEN/COLDZ"),

    GEN_COMCKP("GEN/COMCKP"),

    GEN_COMLOW("GEN/COMLOW"),

    GEN_COMMZ("GEN/COMMZ"),

    GEN_COMUP("GEN/COMUP"),

    GEN_CONTAR("GEN/CONTAR"),

    GEN_CORDON("GEN/CORDON"),

    GEN_CRDPNT("GEN/CRDPNT"),

    GEN_DIVRT("GEN/DIVRT"),

    GEN_DROPPT("GEN/DROPPT"),

    GEN_ENTPT("GEN/ENTPT"),

    GEN_EVENT("GEN/EVENT"),

    GEN_EXITPT("GEN/EXITPT"),

    GEN_FWCTPT("GEN/FWCTPT"),

    GEN_HOTZ("GEN/HOTZ"),

    GEN_INCGRD("GEN/INCGRD"),

    GEN_LA("GEN/LA"),

    GEN_LIMARE("GEN/LIMARE"),

    GEN_LOCAT("GEN/LOCAT"),

    GEN_MSR("GEN/MSR"),

    GEN_PSSGPT("GEN/PSSGPT"),

    GEN_PTINT("GEN/PTINT"),

    GEN_RCNSAR("GEN/RCNSAR"),

    GEN_RNDZPT("GEN/RNDZPT"),

    GEN_ROUTE("GEN/ROUTE"),

    GEN_SAFERT("GEN/SAFERT"),

    GEN_SAFZ("GEN/SAFZ"),

    GEN_SARPNT("GEN/SARPNT"),

    GEN_SEARAR("GEN/SEARAR"),

    GEN_SPRISK("GEN/SPRISK"),

    GEN_STRTPT("GEN/STRTPT"),

    GEN_SUPARE("GEN/SUPARE"),

    GEN_SUPPT("GEN/SUPPT"),

    GEN_TRSTRT("GEN/TRSTRT"),

    GEN_WARMZ("GEN/WARMZ");

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

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   * message RC-EDA et le lieu souhaité pour l&#39;intervention est
   * systématiquement reprécisé dans un objet MISSION
   */
  public enum WEATHEREnum {
    HUM("HUM"),

    ICY("ICY"),

    TDS("TDS"),

    TMP("TMP"),

    VIS("VIS"),

    WDS("WDS"),

    WIN("WIN"),

    HUM_CORECT("HUM/CORECT"),

    HUM_DRZLE("HUM/DRZLE"),

    HUM_FOG("HUM/FOG"),

    HUM_RAIN("HUM/RAIN"),

    HUM_RAINSR("HUM/RAINSR"),

    HUM_THSTRN("HUM/THSTRN"),

    ICY_BLWSNW("ICY/BLWSNW"),

    ICY_CLRICE("ICY/CLRICE"),

    ICY_CORECT("ICY/CORECT"),

    ICY_FDRZLE("ICY/FDRZLE"),

    ICY_FRAIN("ICY/FRAIN"),

    ICY_FRZFOG("ICY/FRZFOG"),

    ICY_HAIL("ICY/HAIL"),

    ICY_ICECRY("ICY/ICECRY"),

    ICY_ICEPLT("ICY/ICEPLT"),

    ICY_MIXICE("ICY/MIXICE"),

    ICY_RIMICE("ICY/RIMICE"),

    ICY_SLEET("ICY/SLEET"),

    ICY_SNOW("ICY/SNOW"),

    ICY_SNWGRN("ICY/SNWGRN"),

    ICY_SNWSHR("ICY/SNWSHR"),

    TDS_CORECT("TDS/CORECT"),

    TDS_LGTNNG("TDS/LGTNNG"),

    TDS_THST("TDS/THST"),

    VIS_CORECT("VIS/CORECT"),

    VIS_HAZE("VIS/HAZE"),

    VIS_SMOKE("VIS/SMOKE"),

    WIN_CORECT("WIN/CORECT"),

    WIN_CYCL("WIN/CYCL"),

    WIN_DSTDVL("WIN/DSTDVL"),

    WIN_DSTSND("WIN/DSTSND"),

    WIN_DSTSTR("WIN/DSTSTR"),

    WIN_FNLCLD("WIN/FNLCLD"),

    WIN_HURR("WIN/HURR"),

    WIN_SNDSTR("WIN/SNDSTR"),

    WIN_STORM("WIN/STORM"),

    WIN_TORN("WIN/TORN"),

    WIN_TRST("WIN/TRST"),

    WIN_TYPH("WIN/TYPH"),

    WIN_WHIR("WIN/WHIR"),

    WIN_WTRSPT("WIN/WTRSPT");

    private String value;

    WEATHEREnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static WEATHEREnum fromValue(String value) {
      for (WEATHEREnum b : WEATHEREnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_W_E_A_T_H_E_R = "WEATHER";
  private List<WEATHEREnum> WEATHER = new ArrayList<>();

  public static final String JSON_PROPERTY_F_R_E_E_T_E_X_T = "FREETEXT";
  private String FREETEXT;

  public static final String JSON_PROPERTY_P_O_S_I_T_I_O_N = "POSITION";
  private Position POSITION;

  public Egeo() {}

  public Egeo DATIME(OffsetDateTime DATIME) {

    this.DATIME = DATIME;
    return this;
  }

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   *message RC-EDA et le lieu souhaité pour l&#39;intervention est
   *systématiquement reprécisé dans un objet MISSION
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

  public Egeo TYPE(TYPEEnum TYPE) {

    this.TYPE = TYPE;
    return this;
  }

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   *message RC-EDA et le lieu souhaité pour l&#39;intervention est
   *systématiquement reprécisé dans un objet MISSION. A constituer depuis
   *ref_mapping_EMSI_EVENT_EGEO_TYPE_NEXSIS_ /!\\ plusieurs champs NEXSIS /!\\
   *plusieurs valeurs par champs d&#39;où un groupe&lt;EGEO&gt; à créer par type
   *différents
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

  public Egeo WEATHER(List<WEATHEREnum> WEATHER) {

    this.WEATHER = WEATHER;
    return this;
  }

  public Egeo addwEATHERItem(WEATHEREnum WEATHERItem) {
    if (this.WEATHER == null) {
      this.WEATHER = new ArrayList<>();
    }
    this.WEATHER.add(WEATHERItem);
    return this;
  }

  /**
   * Get WEATHER
   * @return WEATHER
   **/
  @JsonProperty(JSON_PROPERTY_W_E_A_T_H_E_R)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<WEATHEREnum> getWEATHER() {
    return WEATHER;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_W_E_A_T_H_E_R)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWEATHER(List<WEATHEREnum> WEATHER) {
    if (WEATHER == null) {
      return;
    }
    if (this.WEATHER == null) {
      this.WEATHER = new ArrayList<>();
    }
    this.WEATHER.addAll(WEATHER);
  }

  public Egeo FREETEXT(String FREETEXT) {

    this.FREETEXT = FREETEXT;
    return this;
  }

  /**
   * Optionnel La localisation de l&#39;affaire est transmise en amont dans un
   *message RC-EDA et le lieu souhaité pour l&#39;intervention est
   *systématiquement reprécisé dans un objet MISSION
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

  public Egeo POSITION(Position POSITION) {

    this.POSITION = POSITION;
    return this;
  }

  /**
   * Get POSITION
   * @return POSITION
   **/
  @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Position getPOSITION() {
    return POSITION;
  }

  @JsonProperty(JSON_PROPERTY_P_O_S_I_T_I_O_N)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPOSITION(Position POSITION) {
    this.POSITION = POSITION;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Egeo egeo = (Egeo)o;
    return Objects.equals(this.DATIME, egeo.DATIME) &&
        Objects.equals(this.TYPE, egeo.TYPE) &&
        Objects.equals(this.WEATHER, egeo.WEATHER) &&
        Objects.equals(this.FREETEXT, egeo.FREETEXT) &&
        Objects.equals(this.POSITION, egeo.POSITION);
  }

  @Override
  public int hashCode() {
    return Objects.hash(DATIME, TYPE, WEATHER, FREETEXT, POSITION);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Egeo {\n");
    sb.append("    DATIME: ").append(toIndentedString(DATIME)).append("\n");
    sb.append("    TYPE: ").append(toIndentedString(TYPE)).append("\n");
    sb.append("    WEATHER: ").append(toIndentedString(WEATHER)).append("\n");
    sb.append("    FREETEXT: ").append(toIndentedString(FREETEXT)).append("\n");
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
