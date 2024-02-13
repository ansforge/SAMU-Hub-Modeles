package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RcEdaValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RC-EDA json validation passes")
    public void jsonRcEdaValidationPasses() throws IOException {
        validationPasses("RC-EDA", false);
    }

    @Test
    @DisplayName("RC-EDA xml validation passes")
    public void xmlRcEdaValidationPasses() throws IOException {
        validationPasses("RC-EDA", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RC-EDA json validation fails")
    public void jsonRcEdaValidationFails() throws IOException {
        validationFails("RC-EDA", false, JSON_MISSING, "createCase.initialAlert.id: ");
    }

    @Test
    @DisplayName("RC-EDA xml validation fails")
    public void xmlRcEdaValidationFails() throws IOException {
        validationFails("RC-EDA", true, XML_MISSING, "caseId}' ", "locID}' ");
    }
    //endregion
}
