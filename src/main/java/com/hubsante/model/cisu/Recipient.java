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
 * Recipient
 */
@JsonPropertyOrder({
        Recipient.JSON_PROPERTY_NAME,
        Recipient.JSON_PROPERTY_U_R_I
})
@JsonTypeName("recipient")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:09:36.642+01:00[Europe/Paris]")
public class Recipient {
    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_U_R_I = "URI";
    private String URI;

    public Recipient() {
    }

    public Recipient name(String name) {

        this.name = name;
        return this;
    }

    /**
     * Identifiant technique du système emetteur Format :  &#x3D;&gt; Pour les SAMU : {clé de routage}-{nom solution LRM} où clé de routage désigne le nom de la clé de routage utilisée par le LRM pour les échanges et {nom solution LRM} est le nom donné par l&#39;éditeur à sa solution (libre) &#x3D;&gt; Pour NeXSIS : à définir {sga|sgo}-nexsis
     *
     * @return name
     **/
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }


    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(String name) {
        this.name = name;
    }


    public Recipient URI(String URI) {

        this.URI = URI;
        return this;
    }

    /**
     * uri du système. Permet d&#39;identifier le vecteur utilisé par les échanges Format : &#x3D;&gt; Pour les LRM : sge:{recipient:name} &#x3D;&gt; Pour NexSIS : sge:{recipient:name}
     *
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipient recipient = (Recipient) o;
        return Objects.equals(this.name, recipient.name) &&
                Objects.equals(this.URI, recipient.URI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name
                , URI);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recipient {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    URI: ").append(toIndentedString(URI)).append("\n");
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
