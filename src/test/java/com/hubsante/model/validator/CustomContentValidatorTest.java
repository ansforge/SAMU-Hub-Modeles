package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CustomContentValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("Custom Content json validation passes")
    public void jsonCustomContentValidationPasses() throws IOException {
        validationPasses("EDXL-DE", false);
    }

    @Test
//    @Disabled // TODO bbo: enabled it after xsd generation
    @DisplayName("Custom Content xml validation passes")
    public void xmlCustomContentValidationPasses() throws IOException {
        validationPasses("EDXL-DE", true);
    }
    //endregion
}
