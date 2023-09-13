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

import java.util.List;
import java.util.Objects;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.hubsante.model.cisu.Recipients;
import com.hubsante.model.cisu.Sender;

import java.time.OffsetDateTime;

import com.hubsante.model.edxl.ContentMessage;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * DistributionElement
 */
@JsonPropertyOrder({
        DistributionElement.JSON_PROPERTY_MESSAGE_ID,
        DistributionElement.JSON_PROPERTY_SENDER,
        DistributionElement.JSON_PROPERTY_SENT_AT,
        DistributionElement.JSON_PROPERTY_KIND,
        DistributionElement.JSON_PROPERTY_STATUS,
        DistributionElement.JSON_PROPERTY_RECIPIENTS
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JacksonXmlRootElement(localName = "message")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-13T17:53:43.059+02:00[Europe/Paris]")
public class DistributionElement extends ContentMessage {
    @JacksonXmlProperty(isAttribute = true)
    String xmlns = "urn:emergency:cisu:2.0";
    public static final String JSON_PROPERTY_MESSAGE_ID = "messageId";
    private String messageId;

    public static final String JSON_PROPERTY_SENDER = "sender";
    private Sender sender;

    public static final String JSON_PROPERTY_SENT_AT = "sentAt";
    private OffsetDateTime sentAt;

    /**
     * Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
     */
    public enum KindEnum {
        REPORT("Report"),

        UPDATE("Update"),

        CANCEL("Cancel"),

        ACK("Ack"),

        ERROR("Error");

        private String value;

        KindEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static KindEnum fromValue(String value) {
            for (KindEnum b : KindEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_KIND = "kind";
    private KindEnum kind;

    /**
     * Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)
     */
    public enum StatusEnum {
        ACTUAL("Actual"),

        EXERCISE("Exercise"),

        SYSTEM("System");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

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

    public static final String JSON_PROPERTY_RECIPIENTS = "recipients";
    private List<Recipient> recipients;

    public DistributionElement() {
    }

    public DistributionElement messageId(String messageId) {

        this.messageId = messageId;
        return this;
    }

    /**
     * Identifiant technique permettant d&#39;identifier le message envoyé. Cet identifiant est utilisé par NexSIS pour assurer le routage des messages Préconisation : réemployer le contenu de la balise &lt;distributionId&gt; de l&#39;enveloppe EDXL (cf. DST)
     *
     * @return messageId
     **/
    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getMessageId() {
        return messageId;
    }


    @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    public DistributionElement sender(Sender sender) {

        this.sender = sender;
        return this;
    }

    /**
     * Get sender
     *
     * @return sender
     **/
    @JsonProperty(JSON_PROPERTY_SENDER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public Sender getSender() {
        return sender;
    }


    @JsonProperty(JSON_PROPERTY_SENDER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSender(Sender sender) {
        this.sender = sender;
    }


    public DistributionElement sentAt(OffsetDateTime sentAt) {

        this.sentAt = sentAt;
        return this;
    }

    /**
     * Groupe date heure de début de partage lié à l&#39;envoi du message. Il doit  être cohérent avec le champ &lt;dateTimeSent&gt; de l&#39;enveloppe EDXL (voir DST).  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé. Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39;
     *
     * @return sentAt
     **/
    @JsonProperty(JSON_PROPERTY_SENT_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public OffsetDateTime getSentAt() {
        return sentAt;
    }


    @JsonProperty(JSON_PROPERTY_SENT_AT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSentAt(OffsetDateTime sentAt) {
        this.sentAt = sentAt;
    }


    public DistributionElement kind(KindEnum kind) {

        this.kind = kind;
        return this;
    }

    /**
     * Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
     *
     * @return kind
     **/
    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public KindEnum getKind() {
        return kind;
    }


    @JsonProperty(JSON_PROPERTY_KIND)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setKind(KindEnum kind) {
        this.kind = kind;
    }


    public DistributionElement status(StatusEnum status) {

        this.status = status;
        return this;
    }

    /**
     * Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir DST)
     *
     * @return status
     **/
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public StatusEnum getStatus() {
        return status;
    }


    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    public DistributionElement recipients(List<Recipient> recipients) {

        this.recipients = recipients;
        return this;
    }

    /**
     * Get recipients
     *
     * @return recipients
     **/
    @JsonProperty(JSON_PROPERTY_RECIPIENTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    @JacksonXmlElementWrapper(useWrapping = true)
    public List<Recipient> getRecipients() {
        return recipients;
    }


    @JsonProperty(JSON_PROPERTY_RECIPIENTS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    @JacksonXmlElementWrapper(useWrapping = true)
    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DistributionElement distributionElement = (DistributionElement) o;
        return Objects.equals(this.messageId, distributionElement.messageId) &&
                Objects.equals(this.sender, distributionElement.sender) &&
                Objects.equals(this.sentAt, distributionElement.sentAt) &&
                Objects.equals(this.kind, distributionElement.kind) &&
                Objects.equals(this.status, distributionElement.status) &&
                Objects.equals(this.recipients, distributionElement.recipients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, sender, sentAt, kind, status, recipients);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DistributionElement {\n");
        sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
        sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
        sb.append("    sentAt: ").append(toIndentedString(sentAt)).append("\n");
        sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
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
