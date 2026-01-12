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
import static org.junit.jupiter.api.Assertions.*;

public class EnvelopeValidatorTest extends AbstractValidatorTest{
    
    private static final Logger log = LoggerFactory.getLogger(EnvelopeValidatorTest.class);

    @Test
    @DisplayName("check EDXL envelope schemas availability")
    public void checkEdxlEnvelopeSchemasAvailability() {
        assertDoesNotThrow(() -> new File(Thread.currentThread().getContextClassLoader()
                .getResource("json-schema/" + ENVELOPE_SCHEMA).getFile()));

        assertDoesNotThrow(() -> new File(Thread.currentThread().getContextClassLoader()
                .getResource("xsd/" + ENVELOPE_XSD).getFile()));
    }

    //region Fails validation
    @Test
    @DisplayName("All failing envelope tests must throw corresponding error messages")
    public void batchFailingValidation() throws IOException {
        boolean areAllTestsPassing = true;
        log.info("Running batch failing validation tests for schema: {}", "EDXL-DE");
        String folderPath = Objects.requireNonNull(TestMessagesHelper.class.getClassLoader().getResource("sample/failing/EDXL-DE")).getFile();
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(new File(folderPath).listFiles())));
        log.info("Files discovered: {}", files);

        //For each 'message.json' file in the list, we validate it against TECHNICAL schema using jsonValidationFails
        //and compare received errors with the array of expected errors in the file 'message.json.errors'.
        //We do the same for the corresponding .xml files ('message.xml' and 'message.xml.errors' respectively.)
        for (File file : files) {
            if (file.getName().endsWith(".json")) {
                String message = file.getName().replace(".json", "");
                String[] expectedErrors = getInvalidMessage("EDXL-DE/" + message + ".json.errors").split(System.lineSeparator());
                try {
                    jsonValidationFails("EDXL-DE/" + message + ".json", expectedErrors, FULL_SCHEMA);
                    //Check that a corresponding .xml file exists for the current .json file and run validation on it
                    if(new File(folderPath + "/" + message + ".xml").exists()) {
                        expectedErrors = getInvalidMessage("EDXL-DE/" + message + ".xml.errors").split(System.lineSeparator());
                        xmlValidationFails("EDXL-DE/" + message + ".xml", expectedErrors, FULL_SCHEMA);
                    }
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
    //endregion
}
