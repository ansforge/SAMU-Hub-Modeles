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
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - createCase.initialAlert.id: is missing but it is required",
                " - createCase.additionalInformation.customMap: object found, array expected",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - createCase.sender: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("RC-EDA/RC-EDA-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("RC-EDA xml validation fails")
    public void xmlRcEdaValidationFails() throws IOException {
        xmlValidationFails("RC-EDA/RC-EDA-missing-required-fields.xml", XML_MISSING, new String[]{ "caseId}' ", "locID}' "});
    }
    //endregion
}
