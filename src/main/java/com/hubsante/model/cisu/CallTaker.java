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
 * CallTaker
 */
@JsonPropertyOrder({
        CallTaker.JSON_PROPERTY_ORGANIZATION,
        CallTaker.JSON_PROPERTY_CONTROL_ROOM,
        CallTaker.JSON_PROPERTY_CALLTAKER_U_R_I,
        CallTaker.JSON_PROPERTY_CALLTAKER_ID
})
@JsonTypeName("callTaker")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-15T16:43:16.580+02:00[Europe/Paris]")
public class CallTaker {
    public static final String JSON_PROPERTY_ORGANIZATION = "organization";
    private String organization;

    public static final String JSON_PROPERTY_CONTROL_ROOM = "controlRoom";
    private String controlRoom;

    public static final String JSON_PROPERTY_CALLTAKER_U_R_I = "calltakerURI";
    private String calltakerURI;

    public static final String JSON_PROPERTY_CALLTAKER_ID = "calltakerId";
    private String calltakerId;

    public CallTaker() {
    }

    public CallTaker organization(String organization) {

        this.organization = organization;
        return this;
    }

    /**
     * Organisation d&#39;appartenance de l&#39;opérateur ayant traité l&#39;alerte
     *
     * @return organization
     **/
    @JsonProperty(JSON_PROPERTY_ORGANIZATION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getOrganization() {
        return organization;
    }


    @JsonProperty(JSON_PROPERTY_ORGANIZATION)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public CallTaker controlRoom(String controlRoom) {

        this.controlRoom = controlRoom;
        return this;
    }

    /**
     * Salle opérationnelle de l&#39;opérateur de traitement
     *
     * @return controlRoom
     **/
    @JsonProperty(JSON_PROPERTY_CONTROL_ROOM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getControlRoom() {
        return controlRoom;
    }


    @JsonProperty(JSON_PROPERTY_CONTROL_ROOM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setControlRoom(String controlRoom) {
        this.controlRoom = controlRoom;
    }


    public CallTaker calltakerURI(String calltakerURI) {

        this.calltakerURI = calltakerURI;
        return this;
    }

    /**
     * Numéro de ligne directe permettant de recontacter l&#39;opérateur de traitement
     *
     * @return calltakerURI
     **/
    @JsonProperty(JSON_PROPERTY_CALLTAKER_U_R_I)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCalltakerURI() {
        return calltakerURI;
    }


    @JsonProperty(JSON_PROPERTY_CALLTAKER_U_R_I)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCalltakerURI(String calltakerURI) {
        this.calltakerURI = calltakerURI;
    }


    public CallTaker calltakerId(String calltakerId) {

        this.calltakerId = calltakerId;
        return this;
    }

    /**
     * Identifiant unique de l&#39;opérateur ayant traité l&#39;alerte
     *
     * @return calltakerId
     **/
    @JsonProperty(JSON_PROPERTY_CALLTAKER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCalltakerId() {
        return calltakerId;
    }


    @JsonProperty(JSON_PROPERTY_CALLTAKER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCalltakerId(String calltakerId) {
        this.calltakerId = calltakerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CallTaker callTaker = (CallTaker) o;
        return Objects.equals(this.organization, callTaker.organization) &&
                Objects.equals(this.controlRoom, callTaker.controlRoom) &&
                Objects.equals(this.calltakerURI, callTaker.calltakerURI) &&
                Objects.equals(this.calltakerId, callTaker.calltakerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organization
                , controlRoom
                , calltakerURI
                , calltakerId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CallTaker {\n");
        sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
        sb.append("    controlRoom: ").append(toIndentedString(controlRoom)).append("\n");
        sb.append("    calltakerURI: ").append(toIndentedString(calltakerURI)).append("\n");
        sb.append("    calltakerId: ").append(toIndentedString(calltakerId)).append("\n");
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
