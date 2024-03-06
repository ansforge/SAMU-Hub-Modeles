package com.hubsante.model.validator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RsErrorValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RS-ERROR json validation passes")
    public void jsonRcRefValidationPasses() throws IOException {
        validationPasses("RS-ERROR", false);
    }

    @Test
    @Disabled // TODO bbo: enabled it after xsd generation
    @DisplayName("RS-ERROR xml validation passes")
    public void xmlRcRefValidationPasses() throws IOException {
        validationPasses("RS-ERROR", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RS-ERROR json validation fails")
    public void jsonRcRefValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message: ",
                " - error.sourceMessage: string found, object expected",
                " - error.referencedDistributionID: is missing but it is required",
                " - error.errorCode.statusCode: is missing but it is required"
        };
        jsonValidationFails("RS-ERROR/RS-ERROR-missing-required-fields.json", expectedErrors);
    }

    @Test
    @Disabled // TODO BBO: enabled it after xsd generation
    @DisplayName("RS-ERROR xml validation fails")
    public void xmlRcRefValidationFails() throws IOException {
        xmlValidationFails("RS-ERROR/RS-ERROR-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
    }
    //endregion
}
