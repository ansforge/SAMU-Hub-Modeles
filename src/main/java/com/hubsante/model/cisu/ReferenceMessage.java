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
import com.hubsante.model.cisu.Reference;
import com.hubsante.model.cisu.DistributionElement;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ReferenceMessage
 */
@JsonPropertyOrder({
        DistributionElement.JSON_PROPERTY_MESSAGE_ID,
        DistributionElement.JSON_PROPERTY_SENDER,
        DistributionElement.JSON_PROPERTY_SENT_AT,
        DistributionElement.JSON_PROPERTY_KIND,
        DistributionElement.JSON_PROPERTY_STATUS,
        DistributionElement.JSON_PROPERTY_RECIPIENTS,
        ReferenceMessage.JSON_PROPERTY_REFERENCE
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-15T16:46:46.250+02:00[Europe/Paris]")
public class ReferenceMessage extends DistributionElement {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    public static final String JSON_PROPERTY_REFERENCE = "reference";
    private Reference reference;

    public ReferenceMessage() {
    }

    public ReferenceMessage reference(Reference reference) {

        this.reference = reference;
        return this;
    }

    /**
     * Get reference
     *
     * @return reference
     **/
    @JsonProperty(JSON_PROPERTY_REFERENCE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Reference getReference() {
        return reference;
    }


    @JsonProperty(JSON_PROPERTY_REFERENCE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setReference(Reference reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReferenceMessage referenceMessage = (ReferenceMessage) o;
        return Objects.equals(this.reference, referenceMessage.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReferenceMessage {\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
