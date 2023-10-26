package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonPropertyOrder({
        "distributionID",
        "senderID",
        "dateTimeSent",
        "dateTimeExpires",
        "distributionStatus",
        "distributionKind",
        "descriptor",
        "content"})
public class EdxlMessage extends EdxlEnvelope {

    @JsonProperty(value = "content", required = true)
    private Content content;

    public EdxlMessage() {
        super();
    }

    public EdxlMessage(String distributionID, String senderID, OffsetDateTime dateTimeSent, OffsetDateTime dateTimeExpires,
                       DistributionStatus distributionStatus, DistributionKind distributionKind, Descriptor descriptor,
                       ContentMessage innerMessage) {
        super(distributionID, senderID, dateTimeSent, dateTimeExpires, distributionStatus, distributionKind, descriptor);
        this.setContentFrom(innerMessage);
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public <T extends ContentMessage> void setContentFrom(T embeddedContent) {
        this.setContent(new Content(new ContentObject(new ContentWrapper(new EmbeddedContent(embeddedContent)))));
    }

    public ContentMessage getContentMessage() {
        return this.getContent().getContentObject().getContentWrapper().getEmbeddedContent().getMessage();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EdxlMessage that = (EdxlMessage) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return "class EdxlMessage {\n" +
                        "    distributionID: " + toIndentedString(super.getDistributionID()) + "\n" +
                        "    senderId: " + toIndentedString(super.getSenderID()) + "\n" +
                        "    dateTimeSent: " + toIndentedString(super.getDateTimeSent()) + "\n" +
                        "    dateTimeExpires: " + toIndentedString(super.getDateTimeExpires()) + "\n" +
                        "    distributionStatus: " + toIndentedString(super.getDistributionStatus()) + "\n" +
                        "    distributionKind: " + toIndentedString(super.getDistributionKind()) + "\n" +
                        "    descriptor: " + toIndentedString(super.getDescriptor()) + "\n" +
                        "    content: " + toIndentedString(content) + "\n" +
                "}";
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
