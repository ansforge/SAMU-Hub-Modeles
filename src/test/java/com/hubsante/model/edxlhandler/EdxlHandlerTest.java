/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model.edxlhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;
import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class EdxlHandlerTest extends AbstractEdxlHandlerTest {

    private static final String[] useCasesWithNoRcDe = {
            "RS-ERROR"
    };

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
        String json = getMessageString("RC-REF");
        EdxlMessage messageFromInput = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(messageFromInput);
        assertTrue(() -> xml.startsWith(xmlPrefix()));
    }

    @Test
    @DisplayName("all examples files deserializing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles(File::isDirectory);
        assert subFolders != null;

        List<File> files = new ArrayList<>();
        Arrays.stream(subFolders).forEach(folder -> {
                files.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles())));
            });

        AtomicBoolean allPass = new AtomicBoolean(true);

        files.forEach(file -> {
            try {
                if(file.getName().endsWith(".json")) {
                    String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    // We wrap the use case message in a full json message, except for messages which do not
                    // require RC-DE header
                    String fullJson;
                    if (Arrays.stream(useCasesWithNoRcDe).anyMatch(file.getName()::contains))
                        fullJson = wrapUseCaseMessageWithoutDistributionElement(useCaseJson);
                    else
                        fullJson = wrapUseCaseMessage(useCaseJson);

                    converter.deserializeJsonEDXL(fullJson);
                } else {
                    String useCaseXml = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    converter.deserializeXmlEDXL(useCaseXml);
                }
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

    @Test
    @Disabled  // ToDo(SSV): remove when recette Excel is up-to-date
    @DisplayName("all auto-generated test-case reception step files passing")
    public void autoGeneratedTestCasesPassingTest() throws IOException, URISyntaxException {
        // Get all files from resources/test-cases
        URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource("test-cases")).toURI();
        Path path = Paths.get(uri);
        List<File> files = Files.walk(path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        AtomicBoolean allPass = new AtomicBoolean(true);

        files.forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                converter.deserializeJsonEDXL(fullJson);
                log.info("File {} has been successfully deserialized", file.getName());

                validator.validateJSON(fullJson, FULL_SCHEMA);
                log.info("File {} is valid against schema", file.getName());

            }catch (JsonProcessingException e) {
                allPass.set(false);
                log.error("File " + file.getName() + " could have not been deserialized: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ValidationException e) {
                allPass.set(false);
                log.error("File " + file.getName() + " is not valid against schema: " + e.getMessage());
            }
        });
        if (!allPass.get()) {
            fail("Some files are not valid against schema");
        }
    }

    @Test
    @DisplayName("deserialization of a message with an unknown additional property not at root level fails")
    public void deserializationOfMessageWithUnknownPropertyNotAtRootLevelFails() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-deep.json");
        assertThrows(UnrecognizedPropertyException.class, () -> converter.deserializeJsonEDXL(json));
    }


}
