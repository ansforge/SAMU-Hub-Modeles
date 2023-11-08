package com.hubsante.model.builders;

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCDE.*;
import com.hubsante.model.cisu.RCEDA;
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

        RCDE rcDe = new RC_DE_Builder(MESSAGE_ID, SENDER_ID, recipientList)
                .build();
        RCEDA rcEda = new RC_EDA_Builder(rcDe, getCreateCaseMock())
                .build();

        assertEquals(MESSAGE_ID, rcEda.getMessageId());
        assertEquals(getCreateCaseMock(), rcEda.getCreateCase());
    }

    @Test
    @DisplayName("should not build a RC_EDA with invalid kind")
    public void shouldNotBuildRC_EDAWithInvalidKind() throws IOException {
        Recipient recipient = new Recipient().name(RECIPIENT_ID).URI("hubex:" + RECIPIENT_ID);
        List<Recipient> recipientList = Stream.of(recipient).collect(Collectors.toList());

        RCDE rcDe = new RC_DE_Builder(MESSAGE_ID, SENDER_ID, recipientList)
                .kind(KindEnum.ACK)
                .build();

        assertThrows(IllegalArgumentException.class, () -> new RC_EDA_Builder(rcDe, getCreateCaseMock()).build());
    }

    private CreateCase getCreateCaseMock() throws IOException {
        String json = getMessageString(true, "RC-EDA", false);
        return ((RCEDA) converter.deserializeJsonEDXL(json).getContentMessage()).getCreateCase();
    }
}
