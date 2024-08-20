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

package com.hubsante.model.health;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.Caller;
import com.hubsante.model.health.Notes;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Alert
 */
@JsonPropertyOrder({Alert.JSON_PROPERTY_RECEPTION, Alert.JSON_PROPERTY_NOTES,
                    Alert.JSON_PROPERTY_CALLER})
@JsonTypeName("alert")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Alert {
  public static final String JSON_PROPERTY_RECEPTION = "reception";
  private OffsetDateTime reception;

  public static final String JSON_PROPERTY_NOTES = "notes";
  private List<Notes> notes;

  public static final String JSON_PROPERTY_CALLER = "caller";
  private Caller caller;

  public Alert() {}

  public Alert reception(OffsetDateTime reception) {

    this.reception = reception;
    return this;
  }

  /**
   * A valoriser avec le groupe date heure de réception de l&#39;alerte/appel
   * @return reception
   **/
  @JsonProperty(JSON_PROPERTY_RECEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getReception() {
    return reception;
  }

  @JsonProperty(JSON_PROPERTY_RECEPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReception(OffsetDateTime reception) {
    this.reception = reception;
  }

  public Alert notes(List<Notes> notes) {

    this.notes = notes;
    return this;
  }

  public Alert addNotesItem(Notes notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
   **/
  @JsonProperty(JSON_PROPERTY_NOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Notes> getNotes() {
    return notes;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_NOTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotes(List<Notes> notes) {
    if (notes == null) {
      return;
    }
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.addAll(notes);
  }

  public Alert caller(Caller caller) {

    this.caller = caller;
    return this;
  }

  /**
   * Get caller
   * @return caller
   **/
  @JsonProperty(JSON_PROPERTY_CALLER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Caller getCaller() {
    return caller;
  }

  @JsonProperty(JSON_PROPERTY_CALLER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCaller(Caller caller) {
    this.caller = caller;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alert alert = (Alert)o;
    return Objects.equals(this.reception, alert.reception) &&
        Objects.equals(this.notes, alert.notes) &&
        Objects.equals(this.caller, alert.caller);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reception, notes, caller);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Alert {\n");
    sb.append("    reception: ")
        .append(toIndentedString(reception))
        .append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    caller: ").append(toIndentedString(caller)).append("\n");
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
