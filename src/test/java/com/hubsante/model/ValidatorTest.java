/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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

import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.config.Constants.ENVELOPE_SCHEMA;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ValidatorTest {
    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private final Validator validator = new Validator();

    /*
     * For now we chose to be a little verbose and test each message type separately,
     * to best identify eventual errors & postpone xsd validation
     * We could later use an array of UseCases and iterate over it in a single test
     * It will be relevant when first UseCases will be stable and we will be in an incremental development phase
     */
    @Test
    @DisplayName("RC-EDA validation passes")
    public void jsonRcEdaValidationPasses() throws IOException {
        String input = getMessageString("RC-EDA");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));
        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RC-EDA validation fails")
    public void jsonRcEdaValidationFails() throws IOException {
        String input = getMessageString("RC-EDA", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        try{
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that attribute createCase.initialAlert.id is missing
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("createCase.initialAlert.id: is missing but it is required")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema")));
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
        String input = getMessageString( "EMSI-DC", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that no schemas are valid
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema, but")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("is missing but it is required")));
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
        String input = getMessageString( "RC-REF", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that attribute distributionID is missing
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("reference.distributionID: is missing but it is required")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema")));
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
        String input = getMessageString( "RS-INFO", false, false);
        assertThrows(ValidationException.class, () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try{
            validator.validateJSON(input, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that attribute errorCode.statusCode is missing
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("errorCode.statusCode: is missing but it is required")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema")));
        }

        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("invalid content valid enveloppe")
    public void invalidContentValidEnvelopeTest() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.json");

        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateJSON(json, ENVELOPE_SCHEMA));
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));
    }

    @Test
    @DisplayName("too many valid schemas")
    void tooManyValidSchemas() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-too-many-valid-schemas.json");

        // validation throws due to presence of both createcase and emsi schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that too many schemas are valid
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema, but 2 are valid")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("is missing but it is required")));
        }
    }

    @Test
    @DisplayName("no schemas detected")
    void noSchemasDetected() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-no-schemas.json");

        // validation throws due to absence of schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            // assert that no schemas are detected
            assertTrue(Arrays.stream(errors).anyMatch(error -> error.contains("could not detect any schemas in the message, at least one is required")));
            // assert that other errors are not present
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("embeddedJsonContent: should be valid to one and only one schema, but")));
            assertTrue(Arrays.stream(errors).noneMatch(error -> error.contains("is missing but it is required")));
        }
    }
}
