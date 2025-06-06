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

package com.hubsante.model.resources.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.resources.request.Request;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * ResourcesRequest
 */
@JsonPropertyOrder({ResourcesRequest.JSON_PROPERTY_CASE_ID,
                    ResourcesRequest.JSON_PROPERTY_REQUEST,
                    ResourcesRequest.JSON_PROPERTY_STATUS})
@JsonTypeName("resourcesRequest")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class ResourcesRequest {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:eda:1.9:resourcesrequest";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_REQUEST = "request";
  private Request request;

  /**
   * A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant
   */
  public enum StatusEnum {
    ANNULEE("ANNULEE");

    private String value;

    StatusEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public ResourcesRequest() {}

  public ResourcesRequest caseId(String caseId) {

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

  public ResourcesRequest request(Request request) {

    this.request = request;
    return this;
  }

  /**
   * Get request
   * @return request
   **/
  @JsonProperty(JSON_PROPERTY_REQUEST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Request getRequest() {
    return request;
  }

  @JsonProperty(JSON_PROPERTY_REQUEST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRequest(Request request) {
    this.request = request;
  }

  public ResourcesRequest status(StatusEnum status) {

    this.status = status;
    return this;
  }

  /**
   * A valoriser avec l&#39;état d&#39;annulation de la demande le cas échéant
   * @return status
   **/
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourcesRequest resourcesRequest = (ResourcesRequest)o;
    return Objects.equals(this.caseId, resourcesRequest.caseId) &&
        Objects.equals(this.request, resourcesRequest.request) &&
        Objects.equals(this.status, resourcesRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, request, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourcesRequest {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    request: ").append(toIndentedString(request)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
