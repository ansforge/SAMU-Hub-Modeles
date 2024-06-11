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

package com.hubsante.model.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ResourcesInfo
 */
@JsonPropertyOrder({ResourcesInfo.JSON_PROPERTY_CASE_ID,
                    ResourcesInfo.JSON_PROPERTY_MOBILIZED_RESOURCES})
@JsonTypeName("resourcesInfo")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourcesInfo {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:resourcesInfo";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_MOBILIZED_RESOURCES =
      "mobilizedResources";
  private List<Resource> mobilizedResources;

  public ResourcesInfo() {}

  public ResourcesInfo caseId(String caseId) {

    this.caseId = caseId;
    return this;
  }

  /**
   * Identifiant de l&#39;affaire partagé entre tous les intervenants &#x3D; aux
   *champs {organization}.{senderCaseId} Il doit pouvoir être généré de façon
   *unique et décentralisée et ne présenter aucune ambiguïté.  Il est généré par
   *le système du partenaire récepteur de la primo-demande de secours (créateur
   *du dossier). Valorisation : {pays}.{domaine}.{organisation}.{structure
   *interne}*.{unité fonctionnelle}*.{numéro de dossier}
   * @return caseId
   **/
  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCaseId() {
    return caseId;
  }

  @JsonProperty(JSON_PROPERTY_CASE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }

  public ResourcesInfo mobilizedResources(List<Resource> mobilizedResources) {

    this.mobilizedResources = mobilizedResources;
    return this;
  }

  public ResourcesInfo
  addMobilizedResourcesItem(Resource mobilizedResourcesItem) {
    if (this.mobilizedResources == null) {
      this.mobilizedResources = new ArrayList<>();
    }
    this.mobilizedResources.add(mobilizedResourcesItem);
    return this;
  }

  /**
   * Get mobilizedResources
   * @return mobilizedResources
   **/
  @JsonProperty(JSON_PROPERTY_MOBILIZED_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Resource> getMobilizedResources() {
    return mobilizedResources;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_MOBILIZED_RESOURCES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMobilizedResources(List<Resource> mobilizedResources) {
    if (mobilizedResources == null) {
      return;
    }
    if (this.mobilizedResources == null) {
      this.mobilizedResources = new ArrayList<>();
    }
    this.mobilizedResources.addAll(mobilizedResources);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcesInfo resourcesInfo = (ResourcesInfo)o;
    return Objects.equals(this.caseId, resourcesInfo.caseId) &&
        Objects.equals(this.mobilizedResources,
                       resourcesInfo.mobilizedResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, mobilizedResources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesInfo {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    mobilizedResources: ")
        .append(toIndentedString(mobilizedResources))
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
