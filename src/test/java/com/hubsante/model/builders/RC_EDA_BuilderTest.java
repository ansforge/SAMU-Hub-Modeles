package com.hubsante.model.builders;

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.CreateCaseMessage;
import com.hubsante.model.cisu.DistributionElement;
import com.hubsante.model.cisu.Recipient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RC_EDA_BuilderTest {
    private final String MESSAGE_ID = "id-12345";
    private final String SENDER_ID = "sender-x";
    private final String RECIPIENT_ID = "recipient-y";
    private EdxlHandler converter = new EdxlHandler();
    @Test
    @DisplayName("should build a RC-EDA Message")
    public void shouldBuildRC_EDAMessage() throws IOException {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new RC_DE_Builder(MESSAGE_ID, SENDER_ID, recipientList)
                .build();
        CreateCaseMessage createCaseMessage = new RC_EDA_Builder(distributionElement, getCreateCaseMock())
                .build();

        assertEquals(MESSAGE_ID, createCaseMessage.getMessageId());
        assertEquals(getCreateCaseMock(), createCaseMessage.getCreateCase());
    }

    @Test
    @DisplayName("should not build a RC_EDA with invalid kind")
    public void shouldNotBuildRC_EDAWithInvalidKind() throws IOException {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        DistributionElement distributionElement = new RC_DE_Builder(MESSAGE_ID, SENDER_ID, recipientList)
                .kind(DistributionElement.KindEnum.ACK)
                .build();

        assertThrows(IllegalArgumentException.class, () -> new RC_EDA_Builder(distributionElement, getCreateCaseMock()).build());
    }

    private CreateCase getCreateCaseMock() throws IOException {
        String json = getMessageString(true, "RC-EDA", false);
        return ((CreateCaseMessage) converter.deserializeJsonEDXL(json).getFirstContentMessage()).getCreateCase();
    }
}
