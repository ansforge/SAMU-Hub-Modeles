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
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * CallerName
 */
@JsonPropertyOrder({
        CallerName.JSON_PROPERTY_COMPLETE,
        CallerName.JSON_PROPERTY_CALLER_LAST_NAME,
        CallerName.JSON_PROPERTY_CALLER_FIRST_NAME
})
@JsonTypeName("callerName")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-15T16:43:16.580+02:00[Europe/Paris]")
public class CallerName {
    public static final String JSON_PROPERTY_COMPLETE = "complete";
    private String complete;

    public static final String JSON_PROPERTY_CALLER_LAST_NAME = "callerLastName";
    private String callerLastName;

    public static final String JSON_PROPERTY_CALLER_FIRST_NAME = "callerFirstName";
    private String callerFirstName;

    public CallerName() {
    }

    public CallerName complete(String complete) {

        this.complete = complete;
        return this;
    }

    /**
     * Prénom et nom usuel du requérant. Si les champs callerLastName et callerFirstName sont renseignés, le champ callerName doit contenir la chaîne de caractère suivante : \&quot;{callerFirstName} {callerLastName}\&quot;. Note : NexSIS ne dispose que de ces informations (concaténées) et pas de deux champs séparés.
     *
     * @return complete
     **/
    @JsonProperty(JSON_PROPERTY_COMPLETE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getComplete() {
        return complete;
    }


    @JsonProperty(JSON_PROPERTY_COMPLETE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setComplete(String complete) {
        this.complete = complete;
    }


    public CallerName callerLastName(String callerLastName) {

        this.callerLastName = callerLastName;
        return this;
    }

    /**
     * Nom du requérant
     *
     * @return callerLastName
     **/
    @JsonProperty(JSON_PROPERTY_CALLER_LAST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCallerLastName() {
        return callerLastName;
    }


    @JsonProperty(JSON_PROPERTY_CALLER_LAST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCallerLastName(String callerLastName) {
        this.callerLastName = callerLastName;
    }


    public CallerName callerFirstName(String callerFirstName) {

        this.callerFirstName = callerFirstName;
        return this;
    }

    /**
     * Prénom du réquérant
     *
     * @return callerFirstName
     **/
    @JsonProperty(JSON_PROPERTY_CALLER_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCallerFirstName() {
        return callerFirstName;
    }


    @JsonProperty(JSON_PROPERTY_CALLER_FIRST_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCallerFirstName(String callerFirstName) {
        this.callerFirstName = callerFirstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CallerName callerName = (CallerName) o;
        return Objects.equals(this.complete, callerName.complete) &&
                Objects.equals(this.callerLastName, callerName.callerLastName) &&
                Objects.equals(this.callerFirstName, callerName.callerFirstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complete
                , callerLastName
                , callerFirstName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CallerName {\n");
        sb.append("    complete: ").append(toIndentedString(complete)).append("\n");
        sb.append("    callerLastName: ").append(toIndentedString(callerLastName)).append("\n");
        sb.append("    callerFirstName: ").append(toIndentedString(callerFirstName)).append("\n");
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
