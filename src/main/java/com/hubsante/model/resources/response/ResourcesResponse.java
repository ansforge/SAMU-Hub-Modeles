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

package com.hubsante.model.resources.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.response.Response;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * ResourcesResponse
 */
@JsonPropertyOrder({ResourcesResponse.JSON_PROPERTY_CASE_ID,
                    ResourcesResponse.JSON_PROPERTY_REQUEST_ID,
                    ResourcesResponse.JSON_PROPERTY_RESPONSE})
@JsonTypeName("resourcesResponse")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourcesResponse {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:resourcesResponse";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_RESPONSE = "response";
  private Response response;

  public ResourcesResponse() {}

  public ResourcesResponse caseId(String caseId) {

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

  public ResourcesResponse requestId(String requestId) {

    this.requestId = requestId;
    return this;
  }

  /**
   * A valoriser avec l&#39;identifiant unique partagé de la demande de
   *ressource,  généré une seule fois par le système du partenaire qui émet la
   *demande  Il est valorisé comme suit lors de sa création :
   *{orgID}.request.{ID unique de la demande dans le système émetteur}  OU -
   *uniquement si un ID unique de la demande n&#39;est pas disponible :  OrgId
   *émetteur}.request.{senderCaseId}.{numéro d’ordre chronologique}
   * @return requestId
   **/
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getRequestId() {
    return requestId;
  }

  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public ResourcesResponse response(Response response) {

    this.response = response;
    return this;
  }

  /**
   * Get response
   * @return response
   **/
  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Response getResponse() {
    return response;
  }

  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResponse(Response response) {
    this.response = response;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcesResponse resourcesResponse = (ResourcesResponse)o;
    return Objects.equals(this.caseId, resourcesResponse.caseId) &&
        Objects.equals(this.requestId, resourcesResponse.requestId) &&
        Objects.equals(this.response, resourcesResponse.response);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, requestId, response);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesResponse {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    requestId: ")
        .append(toIndentedString(requestId))
        .append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
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