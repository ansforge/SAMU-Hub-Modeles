package com.hubsante.model.converter;

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.builders.EDXL_DE_Builder;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ConverterUtilsTest {
    @ParameterizedTest
    @CsvSource({"true, true", "false, false", ", false"})
    void testIsDirectCisuForHealthActor(Boolean directCisuPreference, boolean expectedDirectCisuForHealthActor) {
        assertEquals(expectedDirectCisuForHealthActor, ConverterUtils.isDirectCisuForHealthActor(directCisuPreference));
    }

    @Test
    public void testGetRecipientID() {
        String DISTRIBUTION_ID = "id-12345";
        String SENDER_ID = "sender-x";
        String RECIPIENT_ID = "recipient-y";
        ContentMessage contentMessage = new CustomMessage();

        EdxlMessage message = new EDXL_DE_Builder(DISTRIBUTION_ID, SENDER_ID, RECIPIENT_ID)
                .contentMessage(contentMessage)
                .build();

        assertEquals(RECIPIENT_ID, ConverterUtils.getRecipientID(message));
    }

    @ParameterizedTest
    @CsvSource({"fr.health, fr.health, false", "fr.health, not.fr.health, true","not.health, fr.health, true", "not.health, not.fr.health, true"})
    void testIsPartOfCisuExchange(String senderID, String recipientID, Boolean expectedPartOfCisu) {
        String DISTRIBUTION_ID = "id-12345";
        ContentMessage contentMessage = new CustomMessage();

        EdxlMessage message = new EDXL_DE_Builder(DISTRIBUTION_ID, senderID, recipientID)
                .contentMessage(contentMessage)
                .build();

        assertEquals(expectedPartOfCisu, ConverterUtils.isPartOfCisuExchange(message));
    }

    @Test
    public void testIsCisuModel() throws IOException {
        EdxlHandler converter = new EdxlHandler();
        File jsonRCMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/RC-EDA/RC-EDA.json").getFile());
        String useRCCaseJson = new String(Files.readAllBytes(jsonRCMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage RCMessage = converter.deserializeJsonEDXL(useRCCaseJson);
        assertTrue(ConverterUtils.isCisuModel(RCMessage));

//        File jsonRSMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/examples/RS-EDA/RS-EDA-SMUR_FemmeEnceinte_DelphineVigneau.01.json").getFile());
//        String useRSCaseJson = new String(Files.readAllBytes(jsonRSMessage.toPath()), StandardCharsets.UTF_8);
//        EdxlMessage RSMessage = converter.deserializeJsonEDXL(useRSCaseJson);
       // assertTrue(ConverterUtils.isCisuModel(RSMessage));
    }
}
