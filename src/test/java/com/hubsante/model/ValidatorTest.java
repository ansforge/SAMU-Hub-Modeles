package com.hubsante.model;

import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.config.Constants.ENVELOPE_SCHEMA;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
