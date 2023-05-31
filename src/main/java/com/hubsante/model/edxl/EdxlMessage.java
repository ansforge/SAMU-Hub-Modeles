package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EdxlMessage extends EdxlEnvelope {

    @JsonProperty(value = "content", required = true)
    private Content content;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
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
