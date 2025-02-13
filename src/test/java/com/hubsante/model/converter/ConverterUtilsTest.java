package com.hubsante.model.converter;

import com.hubsante.model.EdxlHandler;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.edxl.EdxlMessage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

public class ConverterUtilsTest {
    @Test
    public void testIsCisuModel() throws IOException {
        EdxlHandler converter = new EdxlHandler();

        File RCJsonMessage = new File(Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/RC-EDA/RC-EDA.json")).getFile());
        String RCJsonUseCase = new String(Files.readAllBytes(RCJsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage RCMessage = converter.deserializeJsonEDXL(RCJsonUseCase);
        assertTrue(ConverterUtils.isCisuModel(RCMessage));

        File RSJsonMessage = new File(Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/RS-EDA/RS-EDA.json")).getFile());
        String RSUseCaseJson = new String(Files.readAllBytes(RSJsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage RSMessage = converter.deserializeJsonEDXL(RSUseCaseJson);
        assertTrue(ConverterUtils.isCisuModel(RSMessage));
    }

    @Test
    public void testIsNotCisuModel() throws IOException {
        EdxlHandler converter = new EdxlHandler();

        File EDXLDEJsonMessage = new File(Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/EDXL-DE/EDXL-DE.json")).getFile());
        String EDXLDEJsonUseCase = new String(Files.readAllBytes(EDXLDEJsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage EDXLDEMessage = converter.deserializeJsonEDXL(EDXLDEJsonUseCase);
        assertFalse(ConverterUtils.isCisuModel(EDXLDEMessage));

        File CustomJsonMessage = new File(Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/CustomContent/custom-content.json")).getFile());
        String CustomUseCaseJson = new String(Files.readAllBytes(CustomJsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage CustomMessage = converter.deserializeJsonEDXL(CustomUseCaseJson);
        assertFalse(ConverterUtils.isCisuModel(CustomMessage));
    }
}
