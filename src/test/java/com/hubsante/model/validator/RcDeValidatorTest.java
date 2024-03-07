package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RcDeValidatorTest extends AbstractValidatorTest{

    //region Passes validation
    //endregion

    //region Fails validation
    @Test
    @DisplayName("Valid error message is thrown: RC-DE is fully missing")
    void missingRCDE() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - sentAt: is missing but it is required",
                " - kind: is missing but it is required",
                " - recipient: is missing but it is required",
                " - messageId: is missing but it is required",
                " - status: is missing but it is required",
                " - sender: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-completely-missing-RC-DE.json", expectedErrors);
    }

    @Test
    @DisplayName("RC-DE validation fails")
    void RCDEError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - recipient: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-error-in-RC-DE.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: RC-DE has multiple missing fields")
    void multipleErrorsInRCDE() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - kind: is missing but it is required",
                " - recipient: is missing but it is required",
                " - status: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-multiple-errors-in-RC-DE.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: RC-DE and use case content contain multiple errors")
    void RCDEAndContentError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required",
                " - reference.distributionIDERROR: is not defined in the schema and the schema does not allow additional properties",
                " - reference.dateTimeSentERROR: is not defined in the schema and the schema does not allow additional properties",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - recipient: is missing but it is required",
                " - status: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-errors-in-RC-DE-and-content.json", expectedErrors);
    }
    //endregion
}
