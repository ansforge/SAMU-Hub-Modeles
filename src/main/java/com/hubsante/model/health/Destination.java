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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.ExternalLocationId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Destination
 */
@JsonPropertyOrder({Destination.JSON_PROPERTY_EXTERNAL_LOCATION_ID,
                    Destination.JSON_PROPERTY_FREETEXT})
@JsonTypeName("destination")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Destination {
  public static final String JSON_PROPERTY_EXTERNAL_LOCATION_ID =
      "externalLocationId";
  private List<ExternalLocationId> externalLocationId;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public Destination() {}

  public Destination
  externalLocationId(List<ExternalLocationId> externalLocationId) {

    this.externalLocationId = externalLocationId;
    return this;
  }

  public Destination
  addExternalLocationIdItem(ExternalLocationId externalLocationIdItem) {
    if (this.externalLocationId == null) {
      this.externalLocationId = new ArrayList<>();
    }
    this.externalLocationId.add(externalLocationIdItem);
    return this;
  }

  /**
   * Get externalLocationId
   * @return externalLocationId
   **/
  @JsonProperty(JSON_PROPERTY_EXTERNAL_LOCATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalLocationId> getExternalLocationId() {
    return externalLocationId;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_EXTERNAL_LOCATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void
  setExternalLocationId(List<ExternalLocationId> externalLocationId) {
    if (externalLocationId == null) {
      return;
    }
    if (this.externalLocationId == null) {
      this.externalLocationId = new ArrayList<>();
    }
    this.externalLocationId.addAll(externalLocationId);
  }

  public Destination freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Champ libre qui permet de compléter les informations liées à la
   *localisation.  Spécificités 15-15 : En envoi, il est souhaitable de mapper
   *ici toute valeur en lien avec la localisation de l&#39;intervention qui ne
   *pourrait pas être transmise de manière structurée dans l&#39;objet location.
   *En réception, il est très important d&#39;intégrer et d&#39;afficher la
   *valeur de cet attribut, qui est suceptible de contenir des informations
   *d&#39;accès importantes.
   * @return freetext
   **/
  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFreetext() {
    return freetext;
  }

  @JsonProperty(JSON_PROPERTY_FREETEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreetext(String freetext) {
    this.freetext = freetext;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Destination destination = (Destination)o;
    return Objects.equals(this.externalLocationId,
                          destination.externalLocationId) &&
        Objects.equals(this.freetext, destination.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalLocationId, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Destination {\n");
    sb.append("    externalLocationId: ")
        .append(toIndentedString(externalLocationId))
        .append("\n");
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
