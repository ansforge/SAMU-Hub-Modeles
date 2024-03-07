package com.hubsante.model.validator;

import com.hubsante.model.exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EnvelopeValidatorTest extends AbstractValidatorTest{

    //region Passes validation
    //endregion

    //region Fails validation
    @Test
    @DisplayName("Additional properties in envelope do not pass validation")
    public void jsonRcDeAdditionalPropertyAtRootValidationFails() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-at-root.json");
        assertThrows(ValidationException.class,() -> validator.validateJSON(json, FULL_SCHEMA));
    }

    @Test
    @DisplayName("Valid error message is thrown: multiple errors in the envelope")
    void envelopeError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the envelope: ",
                " - $.descriptor.explicitAddress.explicitAddressScheme: is missing but it is required",
                " - $.descriptor.explicitAddress.explicitAddressValue: is missing but it is required",
                " - $.descriptor.explicitAddress._errorexplicitAddressScheme: is not defined in the schema and the schema does not allow additional properties",
                " - $.descriptor.explicitAddress._errorexplicitAddressValue: is not defined in the schema and the schema does not allow additional properties",
                " - $.descriptor.explicitAddress._errorUnknownProperty: is not defined in the schema and the schema does not allow additional properties",
                " - $.dateTimeSent: is missing but it is required",
                " - $.descriptor._errorExplicitAddress: is not defined in the schema and the schema does not allow additional properties",
                " - $.descriptor._errorUnknownProperty: is not defined in the schema and the schema does not allow additional properties",
                " - $.descriptor.language: is missing but it is required",
                " - $.descriptor._errorlanguage: is not defined in the schema and the schema does not allow additional properties",
                " - $._errordateTimeSent: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("RC-REF/RC-REF-error-in-envelope.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: multiple errors in the envelope and use case content")
    void envelopeAndContentError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required",
                " - reference._errordistributionID: is not defined in the schema and the schema does not allow additional properties",
                "Issues found on the envelope: ",
                " - $._errorsenderID: is not defined in the schema and the schema does not allow additional properties",
                " - $.senderID: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-error-in-envelope-and-content.json", expectedErrors);
    }


    @Test
    @DisplayName("Valid error message is thrown: multiple errors in the envelope and the RC-DE header")
    void envelopeAndRCDEError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the envelope: ",
                " - $._errordistributionID: is not defined in the schema and the schema does not allow additional properties",
                " - $.distributionID: is missing but it is required",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - messageId: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-error-in-envelope-and-RC-DE.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: multiple errors in the envelope")
    void multipleErrorsInEnvelope() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the envelope: ",
                " - $._errordescriptor: is not defined in the schema and the schema does not allow additional properties",
                " - $.descriptor: is missing but it is required",
                " - $._errorsenderID: is not defined in the schema and the schema does not allow additional properties",
                " - $.senderID: is missing but it is required",
                " - $._errordistributionID: is not defined in the schema and the schema does not allow additional properties",
                " - $.distributionID: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-multiple-errors-in-envelope.json", expectedErrors);
    }
    //endregion
}
