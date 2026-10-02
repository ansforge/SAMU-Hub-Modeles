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
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.edxl.DistributionKind;
import com.hubsante.model.edxl.EdxlMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReferenceWrapperBuilderTest {
    private final String DISTRIBUTION_ID = "id-12345";
    private final String SENDER_ID = "sender-x";
    private final String RECIPIENT_ID = "recipient-y";

    /*
     * Test the builder with a RC-REF built from builders
     * first we build a RC-DE
     * then we build a RC-REF from the RC-DE
     * then we build an EDXL Message from the RC-REF
     */
    @Test
    @DisplayName("should build an EDXL Message from a built RC-REF")
    public void shouldBuildEdxlFromRcRef() {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new DistributionElementBuilder(DISTRIBUTION_ID, SENDER_ID, recipientList)
                .kind(DistributionElement.KindEnum.ACK)
                .build();
        ReferenceWrapper referenceWrapper = new ReferenceWrapperBuilder(distributionElement, "id-67890")
                .build();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(referenceWrapper)
                .distributionKind(DistributionKind.ACK)
                .build();

        assertEquals("id-67890", ((ReferenceWrapper) built.getFirstContentMessage()).getReference().getDistributionID());
    }

    @Test
    @DisplayName("should not build a RC_REF with invalid kind")
    public void shouldNotBuildRC_REFWithInvalidKind() {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new DistributionElementBuilder(DISTRIBUTION_ID, SENDER_ID, recipientList)
                .kind(DistributionElement.KindEnum.REPORT)
                .build();

        assertThrows(IllegalArgumentException.class, () -> new ReferenceWrapperBuilder(distributionElement, "id-67890").build());
    }
}
