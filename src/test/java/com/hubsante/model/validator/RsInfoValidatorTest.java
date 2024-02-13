package com.hubsante.model.validator;

import com.hubsante.model.exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RsInfoValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RS-INFO validation passes")
    public void jsonRsInfoValidationPasses() throws IOException {
        validationPasses("RS-INFO", false);
    }

    //TODO bbo: add XML test after merging model evol (info object inside message)
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RS-INFO validation fails")
    public void jsonRsInfoValidationFails() throws IOException {
        validationFails("RS-INFO", false, JSON_MISSING, "errorCode.statusCode: ");
    }

    //TODO bbo: add xml test after merging model evol (info object inside message)
    //endregion
}
