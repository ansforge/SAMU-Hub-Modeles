package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EdxlMessage extends EdxlEnvelope {

//    @JsonProperty(value = "content", required = true)
    private List<ContentObject> content;

    public EdxlMessage() {
        super();
    }

    public EdxlMessage(String distributionID, String senderID, OffsetDateTime dateTimeSent, OffsetDateTime dateTimeExpires,
                       DistributionStatus distributionStatus, DistributionKind distributionKind, Descriptor descriptor,
                       ContentMessage innerMessage) {
        super(distributionID, senderID, dateTimeSent, dateTimeExpires, distributionStatus, distributionKind, descriptor);
        this.setContentFrom(innerMessage);
    }

    public EdxlMessage content(List<ContentObject> content) {
        this.content = content;
        return this;
    }

    public EdxlMessage addContentObject(ContentObject contentObject) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(contentObject);
        return this;
    }

    @JacksonXmlElementWrapper(useWrapping = true, localName = "content")
    @JsonProperty(value = "content")
    @JacksonXmlProperty(localName = "contentObject")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<ContentObject> getContent() {
        return content;
    }

    @JacksonXmlElementWrapper(useWrapping = true, localName = "content")
    @JsonProperty(value = "content")
    @JacksonXmlProperty(localName = "contentObject")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setContent(List<ContentObject> content) {
        this.content = content;
    }

    public <T extends ContentMessage> void setContentFrom(T embeddedContent) {
        List<ContentObject> contentObjectList = new ArrayList<>();
        contentObjectList.add(new ContentObject(new ContentWrapper(new EmbeddedContent(embeddedContent))));
        this.setContent(contentObjectList);
    }

    public ContentMessage getContentMessage() {
        return this.getContent().get(0).getContentWrapper().getEmbeddedContent().getMessage();
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
