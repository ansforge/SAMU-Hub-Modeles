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

package com.hubsante.model.rpis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.rpis.HealthMotive;
import com.hubsante.model.rpis.WhatsHappen;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Regulation
 */
@JsonPropertyOrder({Regulation.JSON_PROPERTY_WHATS_HAPPEN,
                    Regulation.JSON_PROPERTY_HEALTH_MOTIVE,
                    Regulation.JSON_PROPERTY_MEDICAL_LEVEL})
@JsonTypeName("regulation")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Regulation {
  public static final String JSON_PROPERTY_WHATS_HAPPEN = "whatsHappen";
  private WhatsHappen whatsHappen;

  public static final String JSON_PROPERTY_HEALTH_MOTIVE = "healthMotive";
  private HealthMotive healthMotive;

  /**
   * Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code
   * de la nomenclature  SI-SAMU-NIVSOIN. Permet de déduire avec la donnée
   * \&quot;niveau de médicalisation du transport\&quot;, si un UMHP est devenu
   * un SMUR.
   */
  public enum MedicalLevelEnum {
    MED("MED"),

    PARAMED("PARAMED"),

    SECOURS("SECOURS"),

    SANS("SANS");

    private String value;

    MedicalLevelEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MedicalLevelEnum fromValue(String value) {
      for (MedicalLevelEnum b : MedicalLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_MEDICAL_LEVEL = "medicalLevel";
  private MedicalLevelEnum medicalLevel;

  public Regulation() {}

  public Regulation whatsHappen(WhatsHappen whatsHappen) {

    this.whatsHappen = whatsHappen;
    return this;
  }

  /**
   * Get whatsHappen
   * @return whatsHappen
   **/
  @JsonProperty(JSON_PROPERTY_WHATS_HAPPEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WhatsHappen getWhatsHappen() {
    return whatsHappen;
  }

  @JsonProperty(JSON_PROPERTY_WHATS_HAPPEN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWhatsHappen(WhatsHappen whatsHappen) {
    this.whatsHappen = whatsHappen;
  }

  public Regulation healthMotive(HealthMotive healthMotive) {

    this.healthMotive = healthMotive;
    return this;
  }

  /**
   * Get healthMotive
   * @return healthMotive
   **/
  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public HealthMotive getHealthMotive() {
    return healthMotive;
  }

  @JsonProperty(JSON_PROPERTY_HEALTH_MOTIVE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setHealthMotive(HealthMotive healthMotive) {
    this.healthMotive = healthMotive;
  }

  public Regulation medicalLevel(MedicalLevelEnum medicalLevel) {

    this.medicalLevel = medicalLevel;
    return this;
  }

  /**
   * Type d’équipe (médical, paramédicale, secouriste). A valoriser par un code
   *de la nomenclature  SI-SAMU-NIVSOIN. Permet de déduire avec la donnée
   *\&quot;niveau de médicalisation du transport\&quot;, si un UMHP est devenu
   *un SMUR.
   * @return medicalLevel
   **/
  @JsonProperty(JSON_PROPERTY_MEDICAL_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public MedicalLevelEnum getMedicalLevel() {
    return medicalLevel;
  }

  @JsonProperty(JSON_PROPERTY_MEDICAL_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalLevel(MedicalLevelEnum medicalLevel) {
    this.medicalLevel = medicalLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Regulation regulation = (Regulation)o;
    return Objects.equals(this.whatsHappen, regulation.whatsHappen) &&
        Objects.equals(this.healthMotive, regulation.healthMotive) &&
        Objects.equals(this.medicalLevel, regulation.medicalLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(whatsHappen, healthMotive, medicalLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Regulation {\n");
    sb.append("    whatsHappen: ")
        .append(toIndentedString(whatsHappen))
        .append("\n");
    sb.append("    healthMotive: ")
        .append(toIndentedString(healthMotive))
        .append("\n");
    sb.append("    medicalLevel: ")
        .append(toIndentedString(medicalLevel))
        .append("\n");
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
