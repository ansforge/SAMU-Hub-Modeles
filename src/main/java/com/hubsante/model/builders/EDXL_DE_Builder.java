/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.builders;

import com.hubsante.model.edxl.*;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;

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
        if (this.distributionID == null | this.senderID == null | this.dateTimeSent == null | this.dateTimeExpires == null
                | this.distributionStatus == null | this.distributionKind == null | this.descriptor == null) {
            throw new IllegalArgumentException("unprovided mandatory field(s)");
        }
        this.dateTimeSent = this.dateTimeSent.truncatedTo(SECONDS);
        this.dateTimeExpires = this.dateTimeExpires.truncatedTo(SECONDS);

        return new EdxlMessage(this.distributionID, this.senderID, this.dateTimeSent, this.dateTimeExpires,
                this.distributionStatus, this.distributionKind, this.descriptor, this.content);
    }
}
