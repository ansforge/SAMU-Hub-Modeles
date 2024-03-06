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
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - emsi.CONTEXT.ID: is missing but it is required",
                " - emsi.CONTEXT.EXTERNAL_INFO[0].URI: is missing but it is required",
                " - emsi.EVENT.CERTAINTY: string found, integer expected"
        };
        jsonValidationFails("EMSI-DC/EMSI-DC-missing-required-fields.json",  expectedErrors);
    }

    @Test
    @DisplayName("EMSI-DC xml validation fails")
    public void xmlEmsiValidationFails() throws IOException {
        xmlValidationFails("EMSI-DC/EMSI-DC-missing-required-fields.xml", XML_MISSING, new String[]{"ID}' ", "EVENT}' "});
    }
    //endregion
}
