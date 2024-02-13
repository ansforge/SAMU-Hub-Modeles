package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class EmsiValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("EMSI-DC json validation passes")
    public void jsonEmsiDcValidationPasses() throws IOException {
        validationPasses("EMSI-DC", false);
    }

    @Test
    @DisplayName("EMSI-DC xml validation passes")
    public void xmlEmsiValidationPasses() throws IOException {
        validationPasses("EMSI-DC", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("EMSI-DC json validation fails")
    public void jsonEmsiDcValidationFails() throws IOException {
        validationFails("EMSI-DC", false, JSON_MISSING, "emsi.CONTEXT.ID: ");
    }

    @Test
    @DisplayName("EMSI-DC xml validation fails")
    public void xmlEmsiValidationFails() throws IOException {
        validationFails("EMSI-DC", true, XML_MISSING, "ID}' ", "EVENT}' ");
    }
    //endregion
}
