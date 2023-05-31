package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hubsante.model.cisu.CreateEventMessage;
import com.hubsante.model.emsi.Emsi;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmbeddedContent {

    // TODO bbo : replace by CisuMessage with JsonSubType mapping depending on content ?
    private CreateEventMessage message;
    private Emsi emsi;

    private GenericAckMessage genericAckMessage;

    public EmbeddedContent() {
    }

    public EmbeddedContent(CreateEventMessage message) {
        this.message = message;
    }

    public EmbeddedContent(Emsi emsi) {
        this.emsi = emsi;
    }

    public EmbeddedContent(GenericAckMessage genericAckMessage) {
        this.genericAckMessage = genericAckMessage;
    }

    public CreateEventMessage getMessage() {
        return message;
    }

    public void setMessage(CreateEventMessage message) {
        this.message = message;
    }

    public Emsi getEmsi() {
        return emsi;
    }

    public void setEmsi(Emsi emsi) {
        this.emsi = emsi;
    }

    public GenericAckMessage getGenericAckMessage() {
        return genericAckMessage;
    }

    public void setGenericAckMessage(GenericAckMessage genericAckMessage) {
        this.genericAckMessage = genericAckMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddedContent that = (EmbeddedContent) o;
        return Objects.equals(message, that.message) && Objects.equals(emsi, that.emsi) && Objects.equals(genericAckMessage, that.genericAckMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, emsi, genericAckMessage);
    }


    /*
    * I had to override this toString method to avoid null values
     */
    @Override
    public String toString() {
        String embeddedContent = new StringBuilder()
                .append(message != null ? "message=" + message.toString() : "")
                .append(emsi !=null ? "emsi=" + emsi.toString() : "")
                .append(genericAckMessage != null ? "ackMessage=" + genericAckMessage.toString() : "")
                .toString();

        return "EmbeddedContent{" +
                embeddedContent +
                '}';
    }
}
