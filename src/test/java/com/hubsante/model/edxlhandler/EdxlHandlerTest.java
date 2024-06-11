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
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
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

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;
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
    @DisplayName("all examples files deserializing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles();
        assert subFolders != null;

        List<File> files = new ArrayList<>();
        Arrays.stream(subFolders).forEach(folder -> {
            if (!folder.getName().equals("work-in-progress")) {
                files.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles())));
            }});

        AtomicBoolean allPass = new AtomicBoolean(true);

        files.forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                // We wrap the use case message in a full json message, except for RS-ERROR message, which does not
                // require RC-DE header
                String fullJson;
                if (!file.getName().contains("RS-ERROR"))
                    fullJson = wrapUseCaseMessage(useCaseJson);
                else
                    fullJson = wrapUseCaseMessageWithoutDistributionElement(useCaseJson);

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

    @Test
    @DisplayName("deserialization of a message with an unknown additional property not at root level fails")
    public void deserializationOfMessageWithUnknownPropertyNotAtRootLevelFails() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-deep.json");
        assertThrows(UnrecognizedPropertyException.class, () -> converter.deserializeJsonEDXL(json));
    }


}
