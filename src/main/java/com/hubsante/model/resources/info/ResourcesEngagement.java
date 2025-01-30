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

package com.hubsante.model.resources.info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.info.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * ResourcesEngagement
 */
@JsonPropertyOrder({ResourcesEngagement.JSON_PROPERTY_CASE_ID,
                    ResourcesEngagement.JSON_PROPERTY_RESOURCE})
@JsonTypeName("resourcesEngagement")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourcesEngagement {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:eda:1.9:resourcesengagement";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_RESOURCE = "resource";
  private List<Resource> resource = new ArrayList<>();

  public ResourcesEngagement() {}

  public ResourcesEngagement caseId(String caseId) {

    this.caseId = caseId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant partagé de l&#39;affaire/dossier, généré
   *une seule fois par le système du partenaire qui recoit la primo-demande de
   *secours (créateur du dossier).  Il est valorisé comme suit lors de sa
   *création :  {pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir
   *être généré de façon décentralisée et ne présenter aucune ambiguïté.  Il
   *doit être unique dans l&#39;ensemble des systèmes : le numéro de dossier
   *fourni par celui qui génère l&#39;identifiant partagé doit donc être un
   *numéro unique dans son système.
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

  public ResourcesEngagement resource(List<Resource> resource) {

    this.resource = resource;
    return this;
  }

  public ResourcesEngagement addResourceItem(Resource resourceItem) {
    if (this.resource == null) {
      this.resource = new ArrayList<>();
    }
    this.resource.add(resourceItem);
    return this;
  }

  /**
   * Get resource
   * @return resource
   **/
  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Resource> getResource() {
    return resource;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_RESOURCE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResource(List<Resource> resource) {
    if (resource == null) {
      return;
    }
    if (this.resource == null) {
      this.resource = new ArrayList<>();
    }
    this.resource.addAll(resource);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcesEngagement resourcesEngagement = (ResourcesEngagement)o;
    return Objects.equals(this.caseId, resourcesEngagement.caseId) &&
        Objects.equals(this.resource, resourcesEngagement.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, resource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesEngagement {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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
