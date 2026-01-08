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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.utils.TestFileUtils.getMessageByFileName;

public class TechnicalValidatorTest extends AbstractValidatorTest {

    private static final Logger log = LoggerFactory.getLogger(TechnicalValidatorTest.class);

    @Test
    @DisplayName("All valid technical messages should pass validation")
    public void jsonTechnicalValidationPasses() throws Exception {
        String[] folders = {"TECHNICAL"};

        for (String folder : folders) {
            log.info("Running passing validation tests for schema: {}", folder);
            String folderPath = Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/" + folder)).getFile();
            List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(folderPath).listFiles())));
            log.info("Files discovered: {}", files);

            for (File file : files) {
                if (file.getName().endsWith(".json")) {
                    validator.validateJSON(getMessageByFileName(folder + "/" + file.getName()), folder.equals("TECHNICAL") ? TECHNICAL_SCHEMA : TECHNICAL_NOREQ_SCHEMA);
                } else if (file.getName().endsWith(".xml")) {
                    validator.validateXML(getMessageByFileName(folder + "/" + file.getName()), folder.equals("TECHNICAL") ? TECHNICAL_XSD : TECHNICAL_NOREQ_XSD);
                }
            }
        }
    }

    @Test
    @DisplayName("All failing technical tests must throw corresponding error messages")
    public void batchFailingValidation() throws IOException {
        boolean areAllTestsPassing = true;
        //Get list of all files in /sample/examples/failing/TECHNICAL and /sample/examples/failing/TECHNICAL_NOREQ
        // limiting ourselves to .json files only
        String[] folders = {"TECHNICAL","TECHNICAL_NOREQ"};
        log.info("Following schemas detected for batch error message validation test: {}", Arrays.toString(folders));
        for (String folder : folders) {
            log.info("Running batch failing validation tests for schema: {}", folder);
            String folderPath = Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/failing/" + folder)).getFile();
            List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(folderPath).listFiles())));
            log.info("Files discovered: {}", files);

            //For each 'message.json' file in the list, we validate it against TECHNICAL schema using jsonValidationFails
            //and compare received errors with the array of expected errors in the file 'message.json.errors'.
            //We do the same for the corresponding .xml files ('message.xml' and 'message.xml.errors' respectively.)
            for (File file : files) {
                if (file.getName().endsWith(".json")) {
                    String message = file.getName().replace(".json", "");
                    String[] expectedErrors = getInvalidMessage(folder + "/" + message + ".json.errors").split("\n");
                    try {
                        jsonValidationFails(folder + "/" + message + ".json", expectedErrors, folder.equals("TECHNICAL") ? TECHNICAL_SCHEMA : TECHNICAL_NOREQ_SCHEMA);
                        expectedErrors = getInvalidMessage(folder + "/" + message + ".xml.errors").split("\n");
                        xmlValidationFails(folder + "/" + message + ".xml", expectedErrors, folder.equals("TECHNICAL") ? TECHNICAL_XSD : TECHNICAL_NOREQ_XSD);
                        log.info("Error comparison for {} complete", message);
                    } catch ( AssertionFailedError e ) {
                        areAllTestsPassing = false;
                        log.error("Error comparison for {} failed", message);
                    }
                }
            }
            if (!areAllTestsPassing) {
                throw new AssertionFailedError("One or more tests failed");
            }
        }
    }
}
