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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class DistributionElementBuilderTest {
    private final static String MESSAGE_ID = "id-12345";
    private final String SENDER_ID = "sender-x";
    private final List<Recipient> RECIPIENT_LIST = Stream.of(new Recipient().name("recipient-y").URI("hubex:recipient-y")).collect(Collectors.toList());


    @Test
    @DisplayName("Should build a DistributionElement")
    public void shouldBuildRC_DEwithDefaults() {
        DistributionElement actual = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, RECIPIENT_LIST)
                .build();

        assertEquals(MESSAGE_ID, actual.getMessageId());
        assertEquals(SENDER_ID, actual.getSender().getName());
        assertNotNull(actual.getSentAt());
        assertEquals(DistributionElement.KindEnum.REPORT, actual.getKind());
        assertEquals(DistributionElement.StatusEnum.ACTUAL, actual.getStatus());
        assertEquals(1, actual.getRecipient().size());
    }

    @Test
    @DisplayName("should not build a RC-DE without at least one recipient")
    public void shouldNotBuildRC_DEwithoutRecipient() {
        DistributionElementBuilder builder = new DistributionElementBuilder(MESSAGE_ID, "samu-x", new ArrayList<>());

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    @DisplayName("should build a RC-DE with custom expedition date")
    public void shouldBuildRC_DEwithCustomExpeditionDate() {
        OffsetDateTime customDateTime = OffsetDateTime.now().plusHours(2);
        DistributionElement actual = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID,RECIPIENT_LIST)
                .sentAt(customDateTime)
                .build();
        assertEquals(customDateTime.truncatedTo(ChronoUnit.SECONDS), actual.getSentAt());
    }

    @Test
    @DisplayName("should not build a RC-DE with invalid expedition date")
    public void shouldNotBuildRC_DEwithInvalidExpeditionDate() {
        DistributionElementBuilder builder = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, RECIPIENT_LIST)
                .sentAt(null);

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    @DisplayName("should build a RC-DE with ack Kind")
    public void shouldBuildRC_DEwithAckKind() {
        DistributionElement actual = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, RECIPIENT_LIST)
                .kind(DistributionElement.KindEnum.ACK)
                .build();

        assertEquals(DistributionElement.KindEnum.ACK, actual.getKind());
    }

    @Test
    @DisplayName("should build a RC-DE with error Kind")
    public void shouldBuildRC_DEwithCancelKind() {
        DistributionElement actual = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, RECIPIENT_LIST)
                .kind(DistributionElement.KindEnum.ERROR)
                .build();

        assertEquals(DistributionElement.KindEnum.ERROR, actual.getKind());
    }

    @Test
    @DisplayName("should build a RC-DE with provided recipient list")
    public void shouldBuildRC_DEwithProvidedRecipientList() {
        List<Recipient> providedRecipientList = new ArrayList<>();
        providedRecipientList.add(new Recipient().name("samu-z").URI("hubex:samu-z"));
        providedRecipientList.add(new Recipient().name("samu-y").URI("hubex:samu-y"));
        DistributionElement actual = new DistributionElementBuilder(MESSAGE_ID, "samu-x", providedRecipientList)
                .build();

        assertEquals(2, actual.getRecipient().size());
    }
}
