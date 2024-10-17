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

package com.hubsante.model.documentlink;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.documentlink.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * DocumentLink
 */
@JsonPropertyOrder({DocumentLink.JSON_PROPERTY_CASE_ID,
                    DocumentLink.JSON_PROPERTY_PATIENT_ID,
                    DocumentLink.JSON_PROPERTY_DOCUMENT})
@JsonTypeName("documentLink")
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class DocumentLink {
  @JacksonXmlProperty(isAttribute = true)
  String xmlns = "urn:emergency:cisu:2.0:documentLink";
  public static final String JSON_PROPERTY_CASE_ID = "caseId";
  private String caseId;

  public static final String JSON_PROPERTY_PATIENT_ID = "patientId";
  private String patientId;

  public static final String JSON_PROPERTY_DOCUMENT = "document";
  private List<Document> document = new ArrayList<>();

  public DocumentLink() {}

  public DocumentLink caseId(String caseId) {

    this.caseId = caseId;
    return this;
  }

  /**
   * Identifiant partagé du dossier, généré une seule fois par le système du
   *partenaire qui recoit la primo-demande de secours (créateur du dossier).  Il
   *est valorisé comme suit lors de sa création :
   *{pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré
   *de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être
   *unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par
   *celui qui génère l&#39;identifiant partagé doit donc être un numéro unique
   *dans son système.
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

  public DocumentLink patientId(String patientId) {

    this.patientId = patientId;
    return this;
  }

  /**
   * Indique l&#39;identifiant partagé du patient auquel les documents sont
   *rattachés
   * @return patientId
   **/
  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPatientId() {
    return patientId;
  }

  @JsonProperty(JSON_PROPERTY_PATIENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public DocumentLink document(List<Document> document) {

    this.document = document;
    return this;
  }

  public DocumentLink addDocumentItem(Document documentItem) {
    if (this.document == null) {
      this.document = new ArrayList<>();
    }
    this.document.add(documentItem);
    return this;
  }

  /**
   * Get document
   * @return document
   **/
  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Document> getDocument() {
    return document;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_DOCUMENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDocument(List<Document> document) {
    if (document == null) {
      return;
    }
    if (this.document == null) {
      this.document = new ArrayList<>();
    }
    this.document.addAll(document);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentLink documentLink = (DocumentLink)o;
    return Objects.equals(this.caseId, documentLink.caseId) &&
        Objects.equals(this.patientId, documentLink.patientId) &&
        Objects.equals(this.document, documentLink.document);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caseId, patientId, document);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentLink {\n");
    sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
    sb.append("    patientId: ")
        .append(toIndentedString(patientId))
        .append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
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
