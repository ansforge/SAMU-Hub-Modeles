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
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.hubsante.model.cisu;

import java.util.Objects;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hubsante.model.cisu.Contact;
import com.hubsante.model.cisu.DetailedName;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Caller
 */
@JsonPropertyOrder({
        Caller.JSON_PROPERTY_CALLER_CONTACT,
        Caller.JSON_PROPERTY_CALLBACK_CONTACT,
        Caller.JSON_PROPERTY_LANGUAGE,
        Caller.JSON_PROPERTY_FREETEXT,
        Caller.JSON_PROPERTY_DETAILED_NAME
})
@JsonTypeName("caller")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-30T16:37:50.003054300+01:00[Europe/Paris]")
public class Caller {
    public static final String JSON_PROPERTY_CALLER_CONTACT = "callerContact";
    private Contact callerContact;

    public static final String JSON_PROPERTY_CALLBACK_CONTACT = "callbackContact";
    private Contact callbackContact;

    public static final String JSON_PROPERTY_LANGUAGE = "language";
    private String language;

    public static final String JSON_PROPERTY_FREETEXT = "freetext";
    private String freetext;

    public static final String JSON_PROPERTY_DETAILED_NAME = "detailedName";
    private DetailedName detailedName;

    public Caller() {
    }

    public Caller callerContact(Contact callerContact) {

        this.callerContact = callerContact;
        return this;
    }

    /**
     * Get callerContact
     *
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
     *
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
     * Langue parlée par le requérant. Permet de mettre en place des traducteurs si besoin. Utilise la nomenclature LANGUE du SI-SAMU.
     *
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


    public Caller freetext(String freetext) {

        this.freetext = freetext;
        return this;
    }

    /**
     * Information sur le requérant : malentendant, impliqué dans l&#39;accident, … Les informations peuvent être passées sous forme de texte libre ou via une liste d&#39;adjectif
     *
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
     *
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
        Caller caller = (Caller) o;
        return Objects.equals(this.callerContact, caller.callerContact) &&
                Objects.equals(this.callbackContact, caller.callbackContact) &&
                Objects.equals(this.language, caller.language) &&
                Objects.equals(this.freetext, caller.freetext) &&
                Objects.equals(this.detailedName, caller.detailedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(callerContact
                , callbackContact
                , language
                , freetext
                , detailedName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Caller {\n");
        sb.append("    callerContact: ").append(toIndentedString(callerContact)).append("\n");
        sb.append("    callbackContact: ").append(toIndentedString(callbackContact)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    freetext: ").append(toIndentedString(freetext)).append("\n");
        sb.append("    detailedName: ").append(toIndentedString(detailedName)).append("\n");
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
