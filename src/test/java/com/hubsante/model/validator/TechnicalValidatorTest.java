package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.hubsante.model.config.Constants.TECHNICAL_SCHEMA;
import static com.hubsante.model.utils.TestFileUtils.getMessageByFileName;

public class TechnicalValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("Full TECHNICAL json validation passes")
    public void jsonTechnicalValidationPasses() throws Exception {
        validator.validateJSON(getMessageByFileName("TECHNICAL/complete.json"), TECHNICAL_SCHEMA);
    }

}
