package com.hubsante.model.builders;

import com.hubsante.model.edxl.*;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public class EDXL_DE_Builder {

    private String distributionID;
    private String senderID;
    private OffsetDateTime dateTimeSent;
    private OffsetDateTime dateTimeExpires;
    private DistributionStatus distributionStatus;
    private DistributionKind distributionKind;
    private Descriptor descriptor;
    private ContentMessage content;

    public EDXL_DE_Builder(@NotNull String distributionID, @NotNull String senderID, @NotNull String recipientId) {
        if (distributionID == null || senderID == null || recipientId == null) {
            throw new IllegalArgumentException("distributionID, senderID and recipientId must not be null");
        }
        this.distributionID = distributionID;
        this.senderID = senderID;
        this.dateTimeSent = OffsetDateTime.now();
        this.dateTimeExpires = this.dateTimeSent.plusDays(1L);
        this.distributionStatus = DistributionStatus.ACTUAL;
        this.distributionKind = DistributionKind.REPORT;

        ExplicitAddress recipientAddress = new ExplicitAddress("hubex", recipientId);
        this.descriptor = new Descriptor("fr-FR", recipientAddress);

        this.content = null;
    }

    public EDXL_DE_Builder dateTimeSent(OffsetDateTime dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
        this.dateTimeExpires = dateTimeSent.plusDays(1L);
        return this;
    }

    public EDXL_DE_Builder dateTimeSentNowWithOffsetInSeconds(long offset) {
        this.dateTimeSent = OffsetDateTime.now();
        this.dateTimeExpires = this.dateTimeSent.plusDays(offset);
        return this;
    }

    public EDXL_DE_Builder dateTimeSentNowWithOffsetInHours(long offset) {
        this.dateTimeSent = OffsetDateTime.now();
        this.dateTimeExpires = this.dateTimeSent.plusHours(offset);
        return this;
    }

    public EDXL_DE_Builder dateTimeSentNowWithOffsetInDays(long offset) {
        this.dateTimeSent = OffsetDateTime.now();
        this.dateTimeExpires = this.dateTimeSent.plusDays(offset);
        return this;
    }

    public EDXL_DE_Builder dateTimeExpires(OffsetDateTime dateTimeExpires) {
        if (dateTimeExpires.isBefore(this.dateTimeSent)) {
            throw new IllegalArgumentException("dateTimeExpires must be after dateTimeSent");
        }
        this.dateTimeExpires = dateTimeExpires;
        return this;
    }

    public EDXL_DE_Builder dateTimeSentAndExpiresAfterSeconds(OffsetDateTime dateTimeSent, long offset) {
        this.dateTimeSent = dateTimeSent;
        this.dateTimeExpires = dateTimeSent.plusSeconds(offset);
        return this;
    }

    public EDXL_DE_Builder dateTimeSentAndExpiresAfterHours(OffsetDateTime dateTimeSent, long offset) {
        this.dateTimeSent = dateTimeSent;
        this.dateTimeExpires = dateTimeSent.plusHours(offset);
        return this;
    }
    public EDXL_DE_Builder dateTimeSentAndExpiresAfterDays(OffsetDateTime dateTimeSent, long offset) {
        this.dateTimeSent = dateTimeSent;
        this.dateTimeExpires = dateTimeSent.plusDays(offset);
        return this;
    }

    public EDXL_DE_Builder distributionStatus(DistributionStatus distributionStatus) {
        this.distributionStatus = distributionStatus;
        return this;
    }

    public EDXL_DE_Builder distributionKind(DistributionKind distributionKind) {
        this.distributionKind = distributionKind;
        return this;
    }

    public EDXL_DE_Builder withLanguage(String language) {
        this.descriptor.setLanguage(language);
        return this;
    }

    public EDXL_DE_Builder contentMessage(ContentMessage contentMessage) {
        this.content = contentMessage;
        return this;
    }

    public EdxlMessage build() {
        return new EdxlMessage(this.distributionID, this.senderID, this.dateTimeSent, this.dateTimeExpires,
                this.distributionStatus, this.distributionKind, this.descriptor, this.content);
    }
}
