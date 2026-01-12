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
package com.hubsante.model;

import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.rcde.Recipient;
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.rcde.Sender;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.emsi.EmsiWrapper;

import java.util.ArrayList;
import java.util.List;

public class Sanitizer {

    public static EdxlMessage sanitizeEdxl(EdxlMessage edxlMessage) {
        // change sender, explicitAddressValue
        edxlMessage.setSenderID("fr.health.sender");
        edxlMessage.setDistributionID("fr.health.samu_id");
        edxlMessage.getDescriptor().getExplicitAddress().setExplicitAddressValue("fr.health.recipient");
        // access DE, change sender & recipients
        edxlMessage.setContentFrom(sanitizeContent(edxlMessage.getFirstContentMessage()));

        return edxlMessage;
    }

    private static ContentMessage sanitizeContent(ContentMessage contentMessage) {
        Class<? extends ContentMessage> clazz = contentMessage.getClass();

        switch (clazz.getSimpleName()) {
            case "CreateCaseWrapper":
                CreateCaseWrapper createCaseWrapper = (CreateCaseWrapper) contentMessage;
                createCaseWrapper.setMessageId("messageId");
                createCaseWrapper.setSender(sanitizeSender());
                sanitizeRecipients(createCaseWrapper.getRecipient());
                return createCaseWrapper;

            case "EmsiWrapper":
                EmsiWrapper emsiWrapper = (EmsiWrapper) contentMessage;
                emsiWrapper.setMessageId("messageId");
                emsiWrapper.setSender(sanitizeSender());
                sanitizeRecipients(emsiWrapper.getRecipient());
                return emsiWrapper;

            case "ReferenceWrapper":
                ReferenceWrapper referenceWrapper = (ReferenceWrapper) contentMessage;
                referenceWrapper.setMessageId("messageId");
                referenceWrapper.setSender(sanitizeSender());
                sanitizeRecipients(referenceWrapper.getRecipient());
                referenceWrapper.getReference().setDistributionID("neutral_distributionID");
                return referenceWrapper;

            default:
                return contentMessage;
        }
    }

    private static Sender sanitizeSender() {
        Sender revertedSender = new Sender();
        revertedSender.setName("sender");
        revertedSender.setURI("hubex:sender");
        return revertedSender;
    }

    private static void sanitizeRecipients(List<Recipient> recipients) {
        List<Recipient> sanitizedRecipients = new ArrayList<>();

        for (int i = 0; i < recipients.size(); i++) {
            Recipient recipient = recipients.get(i);
            recipient.setName("recipient_" + i);
            recipient.setURI("hubex:" + recipient.getName());
            sanitizedRecipients.add(recipient);
        }
        recipients.clear();
        recipients.addAll(sanitizedRecipients);
    }
}
