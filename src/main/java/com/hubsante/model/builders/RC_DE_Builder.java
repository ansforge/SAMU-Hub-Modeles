package com.hubsante.model.builders;

import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCDE.*;
import com.hubsante.model.cisu.Recipient;
import com.hubsante.model.cisu.Sender;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

public class RC_DE_Builder {
    private String messageId;
    private Sender sender;
    private OffsetDateTime sentAt;
    private RCDE.KindEnum kind;
    private RCDE.StatusEnum status;
    private List<Recipient> recipients;

    /*
    * Builder for DistributionElement
    * @param messageId the message id
    * @param senderId the sender (will construct a Sender with name = senderId and URI = hubex:senderId)
    * @param recipients the recipients (must contain at least one recipient)
    *
    * default values:
    * sentAt = now
    * kind = DistributionElement.KindEnum.REPORT
    * status = DistributionElement.StatusEnum.ACTUAL
    *
    * You can override these values by using the setters
    *
    * You can override the sentAt value by providing a custom OffsetDateTime, or an offset from now (in seconds, hours or days)
     */
    public RC_DE_Builder(@NotNull String messageId, @NotNull String senderId, @NotNull List<Recipient> recipients) {
        if (messageId == null || senderId == null || recipients == null) {
            throw new IllegalArgumentException("messageId, senderId and recipients cannot be null");
        }
        this.messageId = messageId;
        this.sender = new Sender().name(senderId).URI("hubex:" + senderId);
        this.sentAt = OffsetDateTime.now();
        this.kind = KindEnum.REPORT;
        this.status = StatusEnum.ACTUAL;
        this.recipients = recipients;
    }
    public RC_DE_Builder sender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public RC_DE_Builder sentAt(@NotNull OffsetDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    public RC_DE_Builder kind(KindEnum kind) {
        this.kind = kind;
        return this;
    }

    public RC_DE_Builder status(StatusEnum status) {
        this.status = status;
        return this;
    }

    public RC_DE_Builder recipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

    public RCDE build() {
        RCDE distributionElement = new RCDE();

        distributionElement.setMessageId(messageId);
        distributionElement.setSender(sender);
        if (sentAt == null) {
            throw new IllegalArgumentException("sentAt cannot be null");
        }
        distributionElement.setSentAt(sentAt);
        distributionElement.setKind(kind);
        distributionElement.setStatus(status);
        if (recipients.isEmpty()) {
            throw new IllegalArgumentException("recipients list cannot be empty");
        }
        distributionElement.setRecipients(recipients);

        return distributionElement;
    }
}
