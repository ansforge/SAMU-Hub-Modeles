package com.hubsante.model.validator;

import com.hubsante.model.exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.config.Constants.FULL_XSD;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RcRefValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RC-REF json validation passes")
    public void jsonRcRefValidationPasses() throws IOException {
        validationPasses("RC-REF", false);
    }

    @Test
    @DisplayName("RC-REF xml validation passes")
    public void xmlRcRefValidationPasses() throws IOException {
        validationPasses("RC-REF", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RC-REF json validation fails")
    public void jsonRcRefValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required",
        };
        jsonValidationFails("RC-REF/RC-REF-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("RC-REF xml validation fails")
    public void xmlRcRefValidationFails() throws IOException {
        xmlValidationFails("RC-REF/RC-REF-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
    }
    //endregion
}
