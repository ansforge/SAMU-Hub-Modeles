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
package com.hubsante.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ValidatorTest {


    private static String TOO_MANY_SCHEMAS = "embeddedJsonContent: should be valid to one and only one schema, but";
    private static String NO_SCHEMAS = "could not detect any schemas in the message, at least one is required";
    private static String MISSING = "is missing but it is required";
    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private final Validator validator = new Validator();

    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

    /*
     * For now we chose to be a little verbose and test each message type separately,
     * to best identify eventual errors & postpone xsd validation
     * We could later use an array of UseCases and iterate over it in a single test
     * It will be relevant when first UseCases will be stable and we will be in an incremental development phase
     */
    @Test
    @DisplayName("RC-EDA validation passes")
    public void jsonRcEdaValidationPasses() throws IOException {
        String input = getMessageString("RC-EDA-CISU");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));
        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RC-EDA validation fails")
    public void jsonRcEdaValidationFails() throws IOException {
        String input = getMessageString("RC-EDA-CISU", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, MISSING, "createCase.initialAlert.id: ");
        }
        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("EMSI-DC validation passes")
    public void jsonEmsiDcValidationPasses() throws IOException {
        String input = getMessageString("EMSI-DC");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("EMSI-DC validation fails")
    public void jsonEmsiDcValidationFails() throws IOException {
        String input = getMessageString("EMSI-DC", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, MISSING, "emsi.CONTEXT.ID: ");
        }

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RC-REF validation passes")
    public void jsonRcRefValidationPasses() throws IOException {
        String input = getMessageString("RC-REF");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RC-REF validation fails")
    public void jsonRcRefValidationFails() throws IOException {
        String input = getMessageString("RC-REF", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, MISSING, "reference.distributionID: ");
        }

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RS-INFO validation passes")
    public void jsonRsInfoValidationPasses() throws IOException {
        String input = getMessageString("RS-INFO");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RS-INFO validation fails")
    public void jsonRsInfoValidationFails() throws IOException {
        String input = getMessageString("RS-INFO", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, MISSING, "errorCode.statusCode: ");
        }

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("invalid content valid enveloppe")
    public void invalidContentValidEnvelopeTest() throws IOException {
        String json = getInvalidMessage("RC-EDA-CISU/invalid-RC-EDA-CISU-valid-EDXL.json");

        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateJSON(json, ENVELOPE_SCHEMA));
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        String xml = getInvalidMessage("RC-EDA-CISU/invalid-RC-EDA-CISU-valid-EDXL.xml");
        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateXML(xml, ENVELOPE_XSD));
        assertThrows(ValidationException.class, () -> validator.validateXML(xml, "EDXL-DE.xsd"));
    }

    @Test
    @DisplayName("too many valid schemas")
    void tooManyValidSchemas() throws IOException {
        String json = getInvalidMessage("too-many-valid-schemas.json");

        // validation throws due to presence of both createcase and emsi schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, TOO_MANY_SCHEMAS);
        }
    }

    @Test
    @DisplayName("no schemas detected")
    void noSchemasDetected() throws IOException {
        String json = getInvalidMessage("RC-EDA-CISU/invalid-RC-EDA-CISU-no-schemas.json");

        // validation throws due to absence of schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, NO_SCHEMAS);
        }
    }

    @Test
    @DisplayName("all examples files passing")
    public void examplesBundlePassingTest() {
        String folder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] files = new File(folder).listFiles();
        assert files != null;

        Arrays.stream(files).forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                assertDoesNotThrow(() -> validator.validateJSON(fullJson, FULL_SCHEMA));
                log.info("File {} is valid against schema", file.getName());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void checkErrorMessages(String[] errors, String expected, String prefix) {

        String[] errorMessages = { TOO_MANY_SCHEMAS, NO_SCHEMAS, MISSING };

        Arrays.stream(errorMessages).forEach(error -> {
            if (error.equals(expected)) {
                assertTrue(Arrays.stream(errors).anyMatch(err -> err.contains(prefix + error)));
            } else {
                assertTrue(Arrays.stream(errors).noneMatch(err -> err.contains(error)));
            }
        });
    }

    public void checkErrorMessages(String[] errors, String expected) {
        checkErrorMessages(errors, expected, "");
    }
}
