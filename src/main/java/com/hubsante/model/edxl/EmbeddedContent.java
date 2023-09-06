package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmbeddedContent {
    private ContentMessage useCaseMessage;
    public EmbeddedContent() {
    }

    public EmbeddedContent(ContentMessage useCaseMessage) {
        this.useCaseMessage = useCaseMessage;
    }

    public <T extends ContentMessage> T getMessage() {
        return (T) useCaseMessage;
    }

    public <T extends ContentMessage> void setMessage(T message) {
        this.useCaseMessage = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddedContent that = (EmbeddedContent) o;
        return Objects.equals(useCaseMessage, that.useCaseMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useCaseMessage);
    }


    /*
    * I had to override this toString method to avoid null values
     */
    @Override
    public String toString() {
        String embeddedContent = new StringBuilder()
                .append(useCaseMessage != null ? "inner message=" + useCaseMessage.toString() : "")
                .toString();

        return "EmbeddedContent{" +
                embeddedContent +
                '}';
    }
}
