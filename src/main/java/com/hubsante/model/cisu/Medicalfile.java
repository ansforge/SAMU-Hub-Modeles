/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.cisu.Operators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Medicalfile
 */
@JsonPropertyOrder({Medicalfile.JSON_PROPERTY_OPERATORS,
                    Medicalfile.JSON_PROPERTY_FREETEXT,
                    Medicalfile.JSON_PROPERTY_MEDICALHISTORY,
                    Medicalfile.JSON_PROPERTY_TREATMENTS})
@JsonTypeName("medicalfile")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Medicalfile {
  public static final String JSON_PROPERTY_OPERATORS = "operators";
  private Operators operators;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private List<String> freetext;

  public static final String JSON_PROPERTY_MEDICALHISTORY = "medicalhistory";
  private List<String> medicalhistory;

  public static final String JSON_PROPERTY_TREATMENTS = "treatments";
  private List<String> treatments;

  public Medicalfile() {}

  public Medicalfile operators(Operators operators) {

    this.operators = operators;
    return this;
  }

  /**
   * Get operators
   * @return operators
   **/
  @JsonProperty(JSON_PROPERTY_OPERATORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Operators getOperators() {
    return operators;
  }

  @JsonProperty(JSON_PROPERTY_OPERATORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperators(Operators operators) {
    this.operators = operators;
  }

  public Medicalfile freetext(List<String> freetext) {

    this.freetext = freetext;
    return this;
  }

  public Medicalfile addFreetextItem(String freetextItem) {
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

  public Medicalfile medicalhistory(List<String> medicalhistory) {

    this.medicalhistory = medicalhistory;
    return this;
  }

  public Medicalfile addMedicalhistoryItem(String medicalhistoryItem) {
    if (this.medicalhistory == null) {
      this.medicalhistory = new ArrayList<>();
    }
    this.medicalhistory.add(medicalhistoryItem);
    return this;
  }

  /**
   * Get medicalhistory
   * @return medicalhistory
   **/
  @JsonProperty(JSON_PROPERTY_MEDICALHISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getMedicalhistory() {
    return medicalhistory;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_MEDICALHISTORY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMedicalhistory(List<String> medicalhistory) {
    if (medicalhistory == null) {
      return;
    }
    if (this.medicalhistory == null) {
      this.medicalhistory = new ArrayList<>();
    }
    this.medicalhistory.addAll(medicalhistory);
  }

  public Medicalfile treatments(List<String> treatments) {

    this.treatments = treatments;
    return this;
  }

  public Medicalfile addTreatmentsItem(String treatmentsItem) {
    if (this.treatments == null) {
      this.treatments = new ArrayList<>();
    }
    this.treatments.add(treatmentsItem);
    return this;
  }

  /**
   * Get treatments
   * @return treatments
   **/
  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getTreatments() {
    return treatments;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_TREATMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTreatments(List<String> treatments) {
    if (treatments == null) {
      return;
    }
    if (this.treatments == null) {
      this.treatments = new ArrayList<>();
    }
    this.treatments.addAll(treatments);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Medicalfile medicalfile = (Medicalfile)o;
    return Objects.equals(this.operators, medicalfile.operators) &&
        Objects.equals(this.freetext, medicalfile.freetext) &&
        Objects.equals(this.medicalhistory, medicalfile.medicalhistory) &&
        Objects.equals(this.treatments, medicalfile.treatments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operators, freetext, medicalhistory, treatments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Medicalfile {\n");
    sb.append("    operators: ")
        .append(toIndentedString(operators))
        .append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
    sb.append("    medicalhistory: ")
        .append(toIndentedString(medicalhistory))
        .append("\n");
    sb.append("    treatments: ")
        .append(toIndentedString(treatments))
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
