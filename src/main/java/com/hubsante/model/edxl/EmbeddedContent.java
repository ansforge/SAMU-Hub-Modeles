package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hubsante.model.cisu.CreateEventMessage;
import com.hubsante.model.emsi.Emsi;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmbeddedContent {
    private EdxlInnerMessage innerMessage;
    public EmbeddedContent() {
    }

    public EmbeddedContent(EdxlInnerMessage innerMessage) {
        this.innerMessage = innerMessage;
    }

    public <T extends EdxlInnerMessage> T getMessage() {
        return (T) innerMessage;
    }

    public <T extends EdxlInnerMessage> void setMessage(T message) {
        this.innerMessage = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddedContent that = (EmbeddedContent) o;
        return Objects.equals(innerMessage, that.innerMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerMessage);
    }


    /*
    * I had to override this toString method to avoid null values
     */
    @Override
    public String toString() {
        String embeddedContent = new StringBuilder()
                .append(innerMessage != null ? "inner message=" + innerMessage.toString() : "")
                .toString();

        return "EmbeddedContent{" +
                embeddedContent +
                '}';
    }
}
