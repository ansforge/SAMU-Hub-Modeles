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
package com.hubsante.model.validator;

import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.exception.ValidationException;
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

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.config.Constants.FULL_XSD;
import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
public class UseCaseValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("all examples files passing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles(File::isDirectory);
        assert subFolders != null;
        List<File> exampleFiles = new ArrayList<>();

        Arrays.stream(subFolders).forEach(folder -> {
            exampleFiles.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles())));
        });

        AtomicBoolean allPass = new AtomicBoolean(true);

        exampleFiles.forEach(file -> {
            try {
                if (file.getName().endsWith(".json")) {
                    String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    String fullJson = wrapUseCaseMessage(useCaseJson);

                    validator.validateJSON(fullJson, FULL_SCHEMA);
                } else {
                    String useCaseXml = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    validator.validateXML(useCaseXml, FULL_XSD);
                }
                log.info("File {} is valid against schema", file.getName());

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
}
