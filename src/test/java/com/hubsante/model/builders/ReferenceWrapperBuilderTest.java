package com.hubsante.model.builders;

import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCDE.*;
import com.hubsante.model.cisu.ReferenceWrapper;
import com.hubsante.model.cisu.Recipient;
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

        RCDE rcDe = new RC_DE_Builder(DISTRIBUTION_ID, SENDER_ID, recipientList)
                .kind(KindEnum.ACK)
                .build();
        ReferenceWrapper rcRef = new ReferenceWrapperBuilder(rcDe, "id-67890")
                .build();

        EdxlMessage built = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(rcRef)
                .distributionKind(DistributionKind.ACK)
                .build();

        assertEquals("id-67890", ((ReferenceWrapper) built.getContentMessage()).getReference().getDistributionID());
    }

    @Test
    @DisplayName("should not build a RC_REF with invalid kind")
    public void shouldNotBuildRC_REFWithInvalidKind() {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        RCDE rcDe = new RC_DE_Builder(DISTRIBUTION_ID, SENDER_ID, recipientList)
                .kind(RCDE.KindEnum.REPORT)
                .build();

        assertThrows(IllegalArgumentException.class, () -> new ReferenceWrapperBuilder(rcDe, "id-67890").build());
    }
}
