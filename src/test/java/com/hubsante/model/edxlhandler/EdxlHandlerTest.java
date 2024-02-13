package com.hubsante.model.edxlhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class EdxlHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize EDXL with several content objects")
    public void deserializeEDXLWithSeveralContentObjects() throws IOException {
        String json = getMessageString("EDXL-DE");
        EdxlMessage message = converter.deserializeJsonEDXL(json);

        assertEquals(2, message.getContent().size());
        assertEquals(2, message.getAllContentMessages().size());
        assertEquals(message.getFirstContentMessage(), message.getAllContentMessages().get(0));
    }

    @Test
    @DisplayName("should add XML prefix")
    public void verifyXmlPrefix() throws IOException {
        String json = getMessageString("RC-EDA");
        EdxlMessage messageFromInput = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(messageFromInput);
        assertTrue(() -> xml.startsWith(xmlPrefix()));
    }

    @Test
    @DisplayName("all examples files deserializing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles();
        assert subFolders != null;

        List<File> files = new ArrayList<>();
        Arrays.stream(subFolders).forEach(folder -> files.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles()))));

        AtomicBoolean allPass = new AtomicBoolean(true);

        files.forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                converter.deserializeJsonEDXL(fullJson);
                log.info("File {} has been successfully deserialized", file.getName());

            }catch (JsonProcessingException e) {
                allPass.set(false);
                log.error("File " + file.getName() + " could have not been deserialized: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        if (!allPass.get()) {
            fail("Some files are not valid against schema");
        }
    }

}
