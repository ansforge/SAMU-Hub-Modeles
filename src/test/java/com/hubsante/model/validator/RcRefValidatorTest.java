package com.hubsante.model.validator;

import com.hubsante.model.exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.config.Constants.FULL_XSD;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RcRefValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RC-REF json validation passes")
    public void jsonRcRefValidationPasses() throws IOException {
        validationPasses("RC-REF", false);
    }

    @Test
    @DisplayName("RC-REF xml validation passes")
    public void xmlRcRefValidationPasses() throws IOException {
        validationPasses("RC-REF", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RC-REF json validation fails")
    public void jsonRcRefValidationFails() throws IOException {
        validationFails("RC-REF", false, JSON_MISSING, "reference.distributionID: ");
    }

    @Test
    @DisplayName("RC-REF xml validation fails")
    public void xmlRcRefValidationFails() throws IOException {
        validationFails("RC-REF", true, XML_MISSING, "distributionID}' ");
    }
    //endregion
}
