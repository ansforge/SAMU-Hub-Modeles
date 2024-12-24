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

package com.hubsante.model.reference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Reference
 */
@JsonPropertyOrder({Reference.JSON_PROPERTY_DISTRIBUTION_I_D,
                    Reference.JSON_PROPERTY_REFUSED,
                    Reference.JSON_PROPERTY_ERROR_DISTRIBUTION_I_D,
                    Reference.JSON_PROPERTY_STEP})
@JsonTypeName("reference")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Reference {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:3.0";
  public static final String JSON_PROPERTY_DISTRIBUTION_I_D = "distributionID";
  private String distributionID;

  public static final String JSON_PROPERTY_REFUSED = "refused";
  private Boolean refused;

  public static final String JSON_PROPERTY_ERROR_DISTRIBUTION_I_D =
      "errorDistributionID";
  private String errorDistributionID;

  public static final String JSON_PROPERTY_STEP = "step";
  private String step;

  public Reference() {}

  public Reference distributionID(String distributionID) {

    this.distributionID = distributionID;
    return this;
  }

  /**
   * Identifiant unique du message référencé
   * @return distributionID
   **/
  @JsonProperty(JSON_PROPERTY_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDistributionID() {
    return distributionID;
  }

  @JsonProperty(JSON_PROPERTY_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDistributionID(String distributionID) {
    this.distributionID = distributionID;
  }

  public Reference refused(Boolean refused) {

    this.refused = refused;
    return this;
  }

  /**
   * Indique si le message acquitté a été refusé
   * @return refused
   **/
  @JsonProperty(JSON_PROPERTY_REFUSED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRefused() {
    return refused;
  }

  @JsonProperty(JSON_PROPERTY_REFUSED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRefused(Boolean refused) {
    this.refused = refused;
  }

  public Reference errorDistributionID(String errorDistributionID) {

    this.errorDistributionID = errorDistributionID;
    return this;
  }

  /**
   * Identifiant unique du message d&#39;erreur lié
   * @return errorDistributionID
   **/
  @JsonProperty(JSON_PROPERTY_ERROR_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getErrorDistributionID() {
    return errorDistributionID;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_DISTRIBUTION_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorDistributionID(String errorDistributionID) {
    this.errorDistributionID = errorDistributionID;
  }

  public Reference step(String step) {

    this.step = step;
    return this;
  }

  /**
   * Nomenclature permettant d&#39;identifier les différentes étapes
   *d&#39;intégration et de consultation du dossier dans le système émetteur
   * @return step
   **/
  @JsonProperty(JSON_PROPERTY_STEP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStep() {
    return step;
  }

  @JsonProperty(JSON_PROPERTY_STEP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStep(String step) {
    this.step = step;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reference reference = (Reference)o;
    return Objects.equals(this.distributionID, reference.distributionID) &&
        Objects.equals(this.refused, reference.refused) &&
        Objects.equals(this.errorDistributionID,
                       reference.errorDistributionID) &&
        Objects.equals(this.step, reference.step);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distributionID, refused, errorDistributionID, step);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reference {\n");
    sb.append("    distributionID: ")
        .append(toIndentedString(distributionID))
        .append("\n");
    sb.append("    refused: ").append(toIndentedString(refused)).append("\n");
    sb.append("    errorDistributionID: ")
        .append(toIndentedString(errorDistributionID))
        .append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
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
