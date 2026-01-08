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

import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.DistributionKind;
import com.hubsante.model.edxl.DistributionStatus;
import com.hubsante.model.edxl.EdxlMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class EDXL_DE_BuilderTest {
    private final String DISTRIBUTION_ID = "id-12345";
    private final String SENDER_ID = "sender-x";
    private final String RECIPIENT_ID = "recipient-y";

    /*
    * Test the builder with a provided CreateCaseMessage
     */
    @Test
    @DisplayName("should build an EDXL Message")
    public void shouldBuildEDXLMessage() {
        // we don't test the content here, only the EDXL properties (see other builder tests)
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .build();

        assertEquals(DISTRIBUTION_ID, built.getDistributionID());
        assertEquals(SENDER_ID, built.getSenderID());
        assertEquals(RECIPIENT_ID, built.getDescriptor().getExplicitAddress().getExplicitAddressValue());

        assertNotNull(built.getDateTimeSent());
        assertNotNull(built.getDateTimeExpires());
        assertEquals(built.getDateTimeSent().plusDays(1), built.getDateTimeExpires());
        assertEquals(DistributionStatus.ACTUAL, built.getDistributionStatus());
        assertEquals(DistributionKind.REPORT, built.getDistributionKind());

        assertTrue(built.getFirstContentMessage() instanceof CustomMessage);
    }

    @Test
    @DisplayName("should build an EDXL Message with custom expedition date")
    public void shouldBuildEDXLMessageWithCustomExpeditionDate() throws IOException {
        OffsetDateTime customDateTime = OffsetDateTime.now();
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeSent(customDateTime)
                .build();

        assertEquals(customDateTime.truncatedTo(ChronoUnit.SECONDS), built.getDateTimeSent());
        assertEquals(built.getDateTimeSent().plusDays(1), built.getDateTimeExpires());
    }

    @Test
    @DisplayName("should build an EDXL Message with custom expiration date")
    public void shouldBuildEDXLMessageWithCustomExpirationDate() {
        OffsetDateTime customDateTimeExpires = OffsetDateTime.now().plusDays(1);
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeExpires(customDateTimeExpires)
                .build();

        assertEquals(customDateTimeExpires.truncatedTo(ChronoUnit.SECONDS), built.getDateTimeExpires());
    }

    @Test
    @DisplayName("should not build an EDXL Message with sent date after expiration date")
    public void shouldNotBuildEDXLWithSentDateAfterExpirationDate(){
        OffsetDateTime customDateTime = OffsetDateTime.now();
        ContentMessage contentMessage = getCustomContentMessage();

        assertThrows(IllegalArgumentException.class, () -> new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeSent(customDateTime)
                .dateTimeExpires(customDateTime.minusHours(1))
                .build());
    }

    @Test
    @DisplayName("should build an EDXL Message with custom expedition date and offset in seconds")
    public void shouldBuildEDXLMessageWithCustomExpeditionDateAndOffsetInSeconds() {
        OffsetDateTime customDateTime = OffsetDateTime.now();
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeSentAndExpiresAfterSeconds(customDateTime, 3600)
                .build();

        assertEquals(customDateTime.truncatedTo(ChronoUnit.SECONDS), built.getDateTimeSent());
        assertEquals(built.getDateTimeSent().plusHours(1), built.getDateTimeExpires());
    }

    @Test
    @DisplayName("should build an EDXL Message with custom expedition date and offset in hours")
    public void shouldBuildEDXLMessageWithCustomExpeditionDateAndOffsetInHours() {
        OffsetDateTime customDateTime = OffsetDateTime.now();
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeSentAndExpiresAfterHours(customDateTime, 24)
                .build();

        assertEquals(customDateTime.truncatedTo(ChronoUnit.SECONDS), built.getDateTimeSent());
        assertEquals(built.getDateTimeSent().plusDays(1), built.getDateTimeExpires());
    }

    @Test
    @DisplayName("should build an EDXL Message with custom expedition date and offset in days")
    public void shouldBuildEDXLMessageWithCustomExpeditionDateAndOffsetInDays() {
        OffsetDateTime customDateTime = OffsetDateTime.now();
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .dateTimeSentAndExpiresAfterDays(customDateTime, 1)
                .build();

        assertEquals(customDateTime.truncatedTo(ChronoUnit.SECONDS), built.getDateTimeSent());
        assertEquals(built.getDateTimeSent().plusDays(1), built.getDateTimeExpires());
    }

    @Test
    @DisplayName("should build an EDXL Message with custom distribution status")
    public void shouldBuildEDXLMessageWithCustomDistributionStatus() {
        ContentMessage contentMessage = getCustomContentMessage();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .distributionStatus(DistributionStatus.EXERCISE)
                .contentMessage(contentMessage)
                .build();

        assertEquals(DistributionStatus.EXERCISE, built.getDistributionStatus());
    }

    @Test
    @DisplayName("should throw exception if builder is not initialized with mandatory parameters")
    public void shouldThrowExceptionIfBuilderIsNotInitializedWithMandatoryParameters() {
        assertThrows(IllegalArgumentException.class, () -> new EDXL_DE_Builder(null, null, null));
    }

    private ContentMessage getCustomContentMessage() {
        return new CustomMessage();
    }
}
