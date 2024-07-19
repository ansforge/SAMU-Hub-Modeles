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

package com.hubsante.model.health.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.health.update.ExternalId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * AdministrativeFile
 */
@JsonPropertyOrder({AdministrativeFile.JSON_PROPERTY_EXTERNAL_ID})
@JsonTypeName("administrativeFile")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class AdministrativeFile {
  public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
  private List<ExternalId> externalId;

  public AdministrativeFile() {}

  public AdministrativeFile externalId(List<ExternalId> externalId) {

    this.externalId = externalId;
    return this;
  }

  public AdministrativeFile addExternalIdItem(ExternalId externalIdItem) {
    if (this.externalId == null) {
      this.externalId = new ArrayList<>();
    }
    this.externalId.add(externalIdItem);
    return this;
  }

  /**
   * Get externalId
   * @return externalId
   **/
  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ExternalId> getExternalId() {
    return externalId;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_EXTERNAL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExternalId(List<ExternalId> externalId) {
    if (externalId == null) {
      return;
    }
    if (this.externalId == null) {
      this.externalId = new ArrayList<>();
    }
    this.externalId.addAll(externalId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdministrativeFile administrativeFile = (AdministrativeFile)o;
    return Objects.equals(this.externalId, administrativeFile.externalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdministrativeFile {\n");
    sb.append("    externalId: ")
        .append(toIndentedString(externalId))
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