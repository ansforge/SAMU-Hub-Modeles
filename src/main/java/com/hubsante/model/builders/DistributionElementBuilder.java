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


import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.rcde.Recipient;
import com.hubsante.model.rcde.Sender;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class DistributionElementBuilder {
    private String messageId;
    private Sender sender;
    private OffsetDateTime sentAt;
    private DistributionElement.KindEnum kind;
    private DistributionElement.StatusEnum status;
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
    public DistributionElementBuilder(@NotNull String messageId, @NotNull String senderId, @NotNull List<Recipient> recipients) {
        if (messageId == null || senderId == null || recipients == null) {
            throw new IllegalArgumentException("messageId, senderId and recipients cannot be null");
        }
        this.messageId = messageId;
        this.sender = new Sender().name(senderId).URI("hubex:" + senderId);
        this.sentAt = OffsetDateTime.now();
        this.kind = DistributionElement.KindEnum.REPORT;
        this.status = DistributionElement.StatusEnum.ACTUAL;
        this.recipients = recipients;
    }
    public DistributionElementBuilder sender(Sender sender) {
        this.sender = sender;
        return this;
    }

    public DistributionElementBuilder sentAt(@NotNull OffsetDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    public DistributionElementBuilder kind(DistributionElement.KindEnum kind) {
        this.kind = kind;
        return this;
    }

    public DistributionElementBuilder status(DistributionElement.StatusEnum status) {
        this.status = status;
        return this;
    }

    public DistributionElementBuilder recipients(List<Recipient> recipients) {
        this.recipients = recipients;
        return this;
    }

    public DistributionElement build() {
        DistributionElement distributionElement = new DistributionElement();

        distributionElement.setMessageId(messageId);
        distributionElement.setSender(sender);
        if (sentAt == null) {
            throw new IllegalArgumentException("sentAt cannot be null");
        }
        distributionElement.setSentAt(sentAt.truncatedTo(SECONDS));
        distributionElement.setKind(kind);
        distributionElement.setStatus(status);
        if (recipients.isEmpty()) {
            throw new IllegalArgumentException("recipients list cannot be empty");
        }
        distributionElement.setRecipient(recipients);

        return distributionElement;
    }
}
