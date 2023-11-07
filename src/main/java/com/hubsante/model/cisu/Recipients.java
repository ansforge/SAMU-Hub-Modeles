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
import com.hubsante.model.cisu.Recipient;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Recipients
 */
@JsonPropertyOrder({
        Recipients.JSON_PROPERTY_RECIPIENT
})
@JsonTypeName("recipients")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-11-07T12:09:36.642+01:00[Europe/Paris]")
public class Recipients {
    public static final String JSON_PROPERTY_RECIPIENT = "recipient";
    private List<Recipient> recipient = new ArrayList<>();

    public Recipients() {
    }

    public Recipients recipient(List<Recipient> recipient) {

        this.recipient = recipient;
        return this;
    }

    public Recipients addRecipientItem(Recipient recipientItem) {
        if (this.recipient == null) {
            this.recipient = new ArrayList<>();
        }
        this.recipient.add(recipientItem);
        return this;
    }

    /**
     * Get recipient
     *
     * @return recipient
     **/
    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<Recipient> getRecipient() {
        return recipient;
    }

    @JacksonXmlElementWrapper(useWrapping = false)

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setRecipient(List<Recipient> recipient) {
        if (recipient == null) {
            return;
        }
        if (this.recipient == null) {
            this.recipient = new ArrayList<>();
        }
        this.recipient.addAll(recipient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipients recipients = (Recipients) o;
        return Objects.equals(this.recipient, recipients.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recipients {\n");
        sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
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
