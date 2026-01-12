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

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.health.CreateCaseHealth;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.rcde.Recipient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateCaseHealthWrapperBuilderTest {
    private final String MESSAGE_ID = "id-12345";
    private final String SENDER_ID = "sender-x";
    private final String RECIPIENT_ID = "recipient-y";
    private EdxlHandler converter = new EdxlHandler();

    private CreateCaseHealth createCaseHealth = new CreateCaseHealth();

    @Test
    @DisplayName("should build a RS-EDA Message")
    public void shouldBuildRS_EDAMessage() throws IOException {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, recipientList)
                .build();
        CreateCaseHealthWrapper wrapper = new CreateCaseHealthWrapperBuilder(distributionElement, createCaseHealth).build();
        assertEquals(MESSAGE_ID, wrapper.getMessageId());
        assertEquals(createCaseHealth, wrapper.getCreateCaseHealth());
    }

    @Test
    @DisplayName("should not build a RC_EDA with invalid kind")
    public void shouldNotBuildRC_EDAWithInvalidKind() throws IOException {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new DistributionElementBuilder(MESSAGE_ID, SENDER_ID, recipientList)
                .kind(DistributionElement.KindEnum.ACK)
                .build();

        assertThrows(IllegalArgumentException.class, () -> new CreateCaseHealthWrapperBuilder(distributionElement, createCaseHealth).build());
    }
}
