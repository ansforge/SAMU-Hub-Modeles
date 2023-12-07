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
import com.hubsante.model.cisu.Contact;
import com.hubsante.model.cisu.DetailedName;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Caller
 */
@JsonPropertyOrder(
    {Caller.JSON_PROPERTY_CALLER_CONTACT, Caller.JSON_PROPERTY_CALLBACK_CONTACT,
     Caller.JSON_PROPERTY_LANGUAGE, Caller.JSON_PROPERTY_REQTYPE,
     Caller.JSON_PROPERTY_COMMUNICATION, Caller.JSON_PROPERTY_FREETEXT,
     Caller.JSON_PROPERTY_DETAILED_NAME})
@JsonTypeName("caller")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-07T09:49:45.602118Z[Etc/UTC]")
public class Caller {
  public static final String JSON_PROPERTY_CALLER_CONTACT = "callerContact";
  private Contact callerContact;

  public static final String JSON_PROPERTY_CALLBACK_CONTACT = "callbackContact";
  private Contact callbackContact;

  public static final String JSON_PROPERTY_LANGUAGE = "language";
  private String language;

  public static final String JSON_PROPERTY_REQTYPE = "reqtype";
  private String reqtype;

  public static final String JSON_PROPERTY_COMMUNICATION = "communication";
  private String communication;

  public static final String JSON_PROPERTY_FREETEXT = "freetext";
  private String freetext;

  public static final String JSON_PROPERTY_DETAILED_NAME = "detailedName";
  private DetailedName detailedName;

  public Caller() {}

  public Caller callerContact(Contact callerContact) {

    this.callerContact = callerContact;
    return this;
  }

  /**
   * Get callerContact
   * @return callerContact
   **/
  @JsonProperty(JSON_PROPERTY_CALLER_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Contact getCallerContact() {
    return callerContact;
  }

  @JsonProperty(JSON_PROPERTY_CALLER_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallerContact(Contact callerContact) {
    this.callerContact = callerContact;
  }

  public Caller callbackContact(Contact callbackContact) {

    this.callbackContact = callbackContact;
    return this;
  }

  /**
   * Get callbackContact
   * @return callbackContact
   **/
  @JsonProperty(JSON_PROPERTY_CALLBACK_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Contact getCallbackContact() {
    return callbackContact;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_CONTACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallbackContact(Contact callbackContact) {
    this.callbackContact = callbackContact;
  }

  public Caller language(String language) {

    this.language = language;
    return this;
  }

  /**
   * Langue parlée par le requérant. Permet de mettre en place des traducteurs
   *si besoin. Utilise la nomenclature LANGUE du SI-SAMU.
   * @return language
   **/
  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLanguage() {
    return language;
  }

  @JsonProperty(JSON_PROPERTY_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLanguage(String language) {
    this.language = language;
  }

  public Caller reqtype(String reqtype) {

    this.reqtype = reqtype;
    return this;
  }

  /**
   * Indique la relation du requérant avec l&#39;incident / le patient / la
   *victime
   * @return reqtype
   **/
  @JsonProperty(JSON_PROPERTY_REQTYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getReqtype() {
    return reqtype;
  }

  @JsonProperty(JSON_PROPERTY_REQTYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReqtype(String reqtype) {
    this.reqtype = reqtype;
  }

  public Caller communication(String communication) {

    this.communication = communication;
    return this;
  }

  /**
   * Indique si le requérant rencontre ou non des difficulté de communication
   * @return communication
   **/
  @JsonProperty(JSON_PROPERTY_COMMUNICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCommunication() {
    return communication;
  }

  @JsonProperty(JSON_PROPERTY_COMMUNICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCommunication(String communication) {
    this.communication = communication;
  }

  public Caller freetext(String freetext) {

    this.freetext = freetext;
    return this;
  }

  /**
   * Informations complémentaires sur le requérant  Les informations peuvent
   *être passées sous forme de texte libre ou via une liste d&#39;adjectif
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

  public Caller detailedName(DetailedName detailedName) {

    this.detailedName = detailedName;
    return this;
  }

  /**
   * Get detailedName
   * @return detailedName
   **/
  @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DetailedName getDetailedName() {
    return detailedName;
  }

  @JsonProperty(JSON_PROPERTY_DETAILED_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetailedName(DetailedName detailedName) {
    this.detailedName = detailedName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Caller caller = (Caller)o;
    return Objects.equals(this.callerContact, caller.callerContact) &&
        Objects.equals(this.callbackContact, caller.callbackContact) &&
        Objects.equals(this.language, caller.language) &&
        Objects.equals(this.reqtype, caller.reqtype) &&
        Objects.equals(this.communication, caller.communication) &&
        Objects.equals(this.freetext, caller.freetext) &&
        Objects.equals(this.detailedName, caller.detailedName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callerContact, callbackContact, language, reqtype,
                        communication, freetext, detailedName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Caller {\n");
    sb.append("    callerContact: ")
        .append(toIndentedString(callerContact))
        .append("\n");
    sb.append("    callbackContact: ")
        .append(toIndentedString(callbackContact))
        .append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    reqtype: ").append(toIndentedString(reqtype)).append("\n");
    sb.append("    communication: ")
        .append(toIndentedString(communication))
        .append("\n");
    sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
    sb.append("    detailedName: ")
        .append(toIndentedString(detailedName))
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
