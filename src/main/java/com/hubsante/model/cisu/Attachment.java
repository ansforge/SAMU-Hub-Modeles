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
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Attachment
 */
@JsonPropertyOrder(
    {Attachment.JSON_PROPERTY_DESCRIPTION, Attachment.JSON_PROPERTY_MIME_TYPE,
     Attachment.JSON_PROPERTY_SIZE, Attachment.JSON_PROPERTY_U_R_I,
     Attachment.JSON_PROPERTY_DEREF_U_R_I, Attachment.JSON_PROPERTY_DIGEST})
@JsonTypeName("attachment")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T13:17:22.159266Z[Etc/UTC]")
public class Attachment {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_MIME_TYPE = "mimeType";
  private String mimeType;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public static final String JSON_PROPERTY_U_R_I = "URI";
  private String URI;

  public static final String JSON_PROPERTY_DEREF_U_R_I = "derefURI";
  private String derefURI;

  public static final String JSON_PROPERTY_DIGEST = "digest";
  private String digest;

  public Attachment() {}

  public Attachment description(String description) {

    this.description = description;
    return this;
  }

  /**
   * Décrit la ressource en précisant le type et le contenu, tels que «carte» ou
   *«photo»
   * @return description
   **/
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  public Attachment mimeType(String mimeType) {

    this.mimeType = mimeType;
    return this;
  }

  /**
   * L&#39;identifiant du type MIME de contenu et sous-type décrivant la
   *ressource
   * @return mimeType
   **/
  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMimeType() {
    return mimeType;
  }

  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public Attachment size(Integer size) {

    this.size = size;
    return this;
  }

  /**
   * Taille approximative de la ressource en kO
   * @return size
   **/
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSize() {
    return size;
  }

  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSize(Integer size) {
    this.size = size;
  }

  public Attachment URI(String URI) {

    this.URI = URI;
    return this;
  }

  /**
   * Une URI, généralement une URL, qui permet d&#39;atteindre la ressource sur
   *Internet ou sur un réseau privé Nous suggérons d&#39;employer le format
   *suivant de regex
   *(https?|ftp|file)://([\\w-]+(\\.[\\w-]+)*)(/[\\w\\-\\.]*)*_/?(\\?[^\\s]*)?
   * @return URI
   **/
  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getURI() {
    return URI;
  }

  @JsonProperty(JSON_PROPERTY_U_R_I)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setURI(String URI) {
    this.URI = URI;
  }

  public Attachment derefURI(String derefURI) {

    this.derefURI = derefURI;
    return this;
  }

  /**
   * Peut être utilisé à la place de l&#39;élément &#39;URI&#39; pour envoyer la
   *ressource encodée en base64 pour éviter des problèmes de transcodage (sur
   *des double quotes qui casseraient le message, …)
   * @return derefURI
   **/
  @JsonProperty(JSON_PROPERTY_DEREF_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDerefURI() {
    return derefURI;
  }

  @JsonProperty(JSON_PROPERTY_DEREF_U_R_I)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDerefURI(String derefURI) {
    this.derefURI = derefURI;
  }

  public Attachment digest(String digest) {

    this.digest = digest;
    return this;
  }

  /**
   * Hash de la ressource pour confirmer la réception de la bonne ressource La
   *ressource est hashée avec le protocole SHA-256
   * @return digest
   **/
  @JsonProperty(JSON_PROPERTY_DIGEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDigest() {
    return digest;
  }

  @JsonProperty(JSON_PROPERTY_DIGEST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDigest(String digest) {
    this.digest = digest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment)o;
    return Objects.equals(this.description, attachment.description) &&
        Objects.equals(this.mimeType, attachment.mimeType) &&
        Objects.equals(this.size, attachment.size) &&
        Objects.equals(this.URI, attachment.URI) &&
        Objects.equals(this.derefURI, attachment.derefURI) &&
        Objects.equals(this.digest, attachment.digest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, mimeType, size, URI, derefURI, digest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    sb.append("    description: ")
        .append(toIndentedString(description))
        .append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
    sb.append("    derefURI: ").append(toIndentedString(derefURI)).append("\n");
    sb.append("    digest: ").append(toIndentedString(digest)).append("\n");
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
