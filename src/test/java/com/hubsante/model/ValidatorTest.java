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
import java.util.concurrent.atomic.AtomicBoolean;

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
    private static String UNDEFINED = "is not defined in the schema and the schema does not allow additional properties";
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
        String input = getMessageString("RC-EDA");
        assertDoesNotThrow(() -> validator.validateJSON(input, FULL_SCHEMA));
        // TODO bbo: add XML validation
    }

    @Test
    @DisplayName("RC-EDA validation fails")
    public void jsonRcEdaValidationFails() throws IOException {
        String input = getMessageString("RC-EDA", false, false);
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
    @DisplayName("RC-DE validation doesn't fail even with an unknown attribute at root level while additional properties are disallowed (but it would be cool if it did)")
    public void jsonRcDeAdditionalPropertyAtRootValidationDoesntFail() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-at-root.json");
        assertDoesNotThrow(() -> validator.validateJSON(json, FULL_SCHEMA));
    }

    @Test
    @DisplayName("RC-DE validation fails due to an unknown attribute deeper than root level while additional properties are disallowed")
    public void jsonRcDeAdditionalPropValidationFails() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-deep.json");
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, "is not defined in the schema and the schema does not allow additional properties", "reference.unexpectedUnknownProperty: ");
        }
    }

    @Test
    @DisplayName("invalid content valid enveloppe")
    public void invalidContentValidEnvelopeTest() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.json");

        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateJSON(json, ENVELOPE_SCHEMA));
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        String xml = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.xml");
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
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-no-schemas.json");

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
    @DisplayName("error in rc-de header")
    void headerError() throws IOException {
        String json = getInvalidMessage("EDXL-DE/invalid-header.json");

        // validation throws due to incorrect header (recipients instead of recipient)
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessagePresence(errors, MISSING, "recipient: ");
        }
    }

    @Test
    @DisplayName("completely fully missing RC-DE")
    void missingRCDE() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-completely-missing-RC-DE.json");

        // validation throws due to missing RC-DE
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessagePresence(errors, MISSING, "messageId: ");
            checkErrorMessagePresence(errors, MISSING, "sender: ");
            checkErrorMessagePresence(errors, MISSING, "sentAt: ");
            checkErrorMessagePresence(errors, MISSING, "kind: ");
            checkErrorMessagePresence(errors, MISSING, "status: ");
            checkErrorMessagePresence(errors, MISSING, "recipient: ");
        }
    }

    @Test
    @DisplayName("error in content")
    void contentError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-error-in-content.json");

        // validation throws due to incorrect content
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "reference.distributionID: ");
            checkErrorMessagePresence(errors, UNDEFINED, "reference.distributionIDS: ");
        }
    }

    @Test
    @DisplayName("error in envelope")
    void envelopeError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-error-in-envelope.json");

        // validation throws due to incorrect envelope
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessages(errors, MISSING, "dateTimeSent: ");
        }
    }

    @Test
    @DisplayName("error in envelope and content")
    void envelopeAndContentError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-error-in-envelope-and-content.json");

        // validation throws due to incorrect envelope and content
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessages(errors, MISSING, "reference.distributionID: ");
            checkErrorMessagePresence(errors, MISSING, "senderID: ");
        }
    }

    @Test
    @DisplayName("error in envelope and RC-DE")
    void envelopeAndRCDEError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-error-in-envelope-and-RC-DE.json");

        // validation throws due to incorrect envelope and RC-DE
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "distributionID: ");
            checkErrorMessagePresence(errors, MISSING, "messageId: ");
        }
    }

    @Test
    @DisplayName("error in RC-DE")
    void RCDEError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-error-in-RC-DE.json");

        // validation throws due to incorrect RC-DE
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "recipient: ");
        }
    }

    @Test
    @DisplayName("error in RC-DE and content")
    void RCDEAndContentError() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-errors-in-RC-DE-and-content.json");

        // validation throws due to incorrect RC-DE and content
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "recipient: ");
            checkErrorMessagePresence(errors, MISSING, "reference.distributionID: ");
        }
    }

    @Test
    @DisplayName("missing required fields")
    void missingRequiredFields() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-missing-required-fields.json");

        // validation throws due to missing required fields
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "reference.distributionID: ");
        }
    }

    @Test
    @DisplayName("multiple errors in envelope")
    void multipleErrorsInEnvelope() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-multiple-errors-in-envelope.json");

        // validation throws due to multiple errors in envelope
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "distributionID: ");
            checkErrorMessagePresence(errors, MISSING, "senderID: ");
            checkErrorMessagePresence(errors, MISSING, "descriptor: ");
        }
    }

    @Test
    @DisplayName("multiple errors in content")
    void multipleErrorsInContent() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-multiple-errors-in-content.json");

        // validation throws due to multiple errors in content
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "reference.distributionID: ");
            checkErrorMessagePresence(errors, UNDEFINED, "ERROR: ");
            checkErrorMessagePresence(errors, UNDEFINED, "ERROR2: ");
        }
    }

    @Test
    @DisplayName("multiple errors in RC-DE")
    void multipleErrorsInRCDE() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-multiple-errors-in-RC-DE.json");

        // validation throws due to multiple errors in RC-DE
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "kind: ");
            checkErrorMessagePresence(errors, MISSING, "recipient: ");
            checkErrorMessagePresence(errors, MISSING, "status: ");
        }
    }

    @Test
    @DisplayName("no schemas")
    void noSchemas() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-no-schemas.json");

        // validation throws due to no schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, "could not detect any schemas in the message, at least one is required ");
        }
    }

    @Test
    @DisplayName("too many schemas")
    void tooManySchemas() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-too-many-schemas.json");

        // validation throws due to too many schemas
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, "should be valid to one and only one schema, but 2 are valid");
        }
    }

    @Test
    @DisplayName("too many schemas and errors in content")
    void tooManySchemasAndErrorsInContent() throws IOException {
        String json = getInvalidMessage("RC-REF/RC-REF-too-many-schemas-and-errors-in-content.json");

        // validation throws due to too many schemas and errors in content
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            validator.validateJSON(json, FULL_SCHEMA);

        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");

            checkErrorMessagePresence(errors, MISSING, "reference.distributionID: ");
            checkErrorMessagePresence(errors, UNDEFINED, "reference.incorrectProp: ");

            checkErrorMessagePresence(errors, "string found, object expected", "emsi.CONTEXT: ");
            checkErrorMessagePresence(errors, MISSING, "emsi.EVENT.ID: ");
            checkErrorMessagePresence(errors, "object found, array expected", "emsi.EVENT.EGEO: ");
        }
    }

    @Test
    @DisplayName("all examples files passing")
    public void examplesBundlePassingTest() {
        String folder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] files = new File(folder).listFiles();
        assert files != null;
        AtomicBoolean allPass = new AtomicBoolean(true);

        Arrays.stream(files).forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                validator.validateJSON(fullJson, FULL_SCHEMA);
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

    public void checkErrorMessagePresence(String[] errors, String expected, String prefix) {
        String[] errorMessages = {TOO_MANY_SCHEMAS, NO_SCHEMAS, MISSING, UNDEFINED};

        Arrays.stream(errorMessages).forEach(error ->{
            if (error.equals(expected)) {
                assertTrue(Arrays.stream(errors).anyMatch(err -> err.contains(prefix + error)));
            }
        });
    }

    public void checkErrorMessagePresence(String[] errors, String expected) {
        checkErrorMessagePresence(errors, expected, "");
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
