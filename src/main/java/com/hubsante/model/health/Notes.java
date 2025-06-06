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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Notes
 */
@JsonPropertyOrder({Notes.JSON_PROPERTY_CREATION, Notes.JSON_PROPERTY_FREETEXT})
@JsonTypeName("notes")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Notes {
  public static final String JSON_PROPERTY_CREATION = "creation";
  private OffsetDateTime creation;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public Notes() {}

  public Notes creation(OffsetDateTime creation) {

    this.creation = creation;
    return this;
  }

  /**
   * A valoriser avec le groupe date heure de création de l&#39;information
   *complémentaire
   * @return creation
   **/
  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreation() {
    return creation;
  }

  @JsonProperty(JSON_PROPERTY_CREATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreation(OffsetDateTime creation) {
    this.creation = creation;
  }

  public Notes freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * A valoriser avec un texte libre contenant les indications complémentaires
   *renseignées sur l&#39;alerte/appel.  Spécificités 15-15 : cet attribut ne
   *doit pas être valorisé avec des notes à caractère médical, qui serait liée à
   *un interrogatoire ARM ou médecin, ou à un patient en particulier
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
    Notes notes = (Notes)o;
    return Objects.equals(this.creation, notes.creation) &&
        Objects.equals(this.freetext, notes.freetext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creation, freetext);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notes {\n");
    sb.append("    creation: ").append(toIndentedString(creation)).append("\n");
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
