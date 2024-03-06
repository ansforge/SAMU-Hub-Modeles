package com.hubsante.model.validator;

import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.config.Constants.FULL_SCHEMA;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class ValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("invalid content valid envelope")
    public void invalidContentValidEnvelopeTest() throws IOException {
        String json = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.json");

        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateJSON(json, ENVELOPE_SCHEMA));
        assertThrows(ValidationException.class, () -> validator.validateJSON(json, FULL_SCHEMA));

        try {
            validator.validateJSON(json, FULL_SCHEMA);
        } catch (ValidationException e) {
            String[] expectedErrors = {
                    "Could not validate message against schema : errors occurred. ",
                    "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                    " - createCase.creation: is missing but it is required",
                    " - createCase.additionalInformation.customMap: object found, array expected"
            };
            String[] errors = e.getMessage().split("\n");
            checkErrorMessageArrayExactContent(errors, expectedErrors);
        }

        String xml = getInvalidMessage("RC-EDA/invalid-RC-EDA-valid-EDXL.xml");
        // envelope validation does not throw because envelope is ok
        assertDoesNotThrow(() -> validator.validateXML(xml, ENVELOPE_XSD));
        assertThrows(ValidationException.class, () -> validator.validateXML(xml, FULL_XSD));
    }

    @Test
    @DisplayName("too many valid schemas")
    void tooManyValidSchemas() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "embeddedJsonContent: should be valid to one and only one schema, but 2 are valid"
        };
        jsonValidationFails("too-many-valid-schemas.json", expectedErrors);
    }

    @Test
    @DisplayName("no schemas detected")
    void noSchemasDetected() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required "
        };
        jsonValidationFails("RC-EDA/invalid-RC-EDA-no-schemas.json", expectedErrors);
    }

    @Test
    @DisplayName("additional property fails")
    public void additionalPropertyFails() throws IOException {
        // unknown property below wrapper level will not pass validation
        String refLevelInvalid = getInvalidMessage("RC-REF/reference-level-additional-property.json");
        assertThrows(ValidationException.class, () -> validator.validateJSON(refLevelInvalid, FULL_SCHEMA));

        // unknown property at the wrapper level does not throw exception but will be ignored at deserialization
        String wrapperLevelInvalid = getInvalidMessage("RC-REF/wrapper-level-additional-property.json");
        assertDoesNotThrow(() -> validator.validateJSON(wrapperLevelInvalid, FULL_SCHEMA));
    }

    @Test
    @DisplayName("validation fails due to an unknown attribute at root level while additional properties are disallowed")
    public void jsonRcDeAdditionalPropertyAtRootValidationDoesntFail() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-at-root.json");
        assertThrows(ValidationException.class,() -> validator.validateJSON(json, FULL_SCHEMA));
    }

    @Test
    @DisplayName("validation fails due to an unknown attribute deeper than root level while additional properties are disallowed")
    public void jsonRcDeAdditionalPropValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.unexpectedUnknownProperty: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("EDXL-DE/unknown-property-deep.json", expectedErrors);
    }

    @Test
    @DisplayName("error in rc-de header")
    void headerError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - recipient: is missing but it is required"
        };
        jsonValidationFails("EDXL-DE/invalid-header.json", expectedErrors);
    }

    @Test
    @DisplayName("completely missing RC-DE")
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
    @DisplayName("error in content")
    void contentError() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required",
                " - reference.distributionIDS: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("RC-REF/RC-REF-error-in-content.json", expectedErrors);
    }

    @Test
    @DisplayName("error in envelope")
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
    @DisplayName("error in envelope and content")
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
    @DisplayName("error in envelope and RC-DE")
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
    @DisplayName("error in RC-DE")
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
    @DisplayName("error in RC-DE and content")
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

    @Test
    @DisplayName("missing required fields")
    void missingRequiredFields() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("multiple errors in envelope")
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

    @Test
    @DisplayName("multiple errors in content")
    void multipleErrorsInContent() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required",
                " - reference._errorproperty1: is not defined in the schema and the schema does not allow additional properties",
                " - reference._errorproperty2: is not defined in the schema and the schema does not allow additional properties",
                " - reference._errorproperty3: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("RC-REF/RC-REF-multiple-errors-in-content.json", expectedErrors);
    }

    @Test
    @DisplayName("multiple errors in RC-DE")
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
    @DisplayName("too many schemas and errors in content")
    void tooManySchemasAndErrorsInContent() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                "embeddedJsonContent: should be valid to one and only one schema, but 2 are valid",
                " - reference.distributionID: is missing but it is required",
                " - reference._errordistributionID: is not defined in the schema and the schema does not allow additional properties",
                " - emsi.CONTEXT: is missing but it is required",
                " - emsi.EVENT: is missing but it is required",
                " - emsi._errorproperty: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("RC-REF/RC-REF-too-many-schemas-and-errors-in-content.json", expectedErrors);
    }

    @Test
    @DisplayName("all examples files passing")
    public void examplesBundlePassingTest() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles();
        assert subFolders != null;
        List<File> exampleFiles = new ArrayList<>();

        Arrays.stream(subFolders).forEach(folder -> {
            if (!folder.getName().equals("work-in-progress")) {
                exampleFiles.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles())));
            }
        });

        AtomicBoolean allPass = new AtomicBoolean(true);

        exampleFiles.forEach(file -> {
            try {
                String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                String fullJson = wrapUseCaseMessage(useCaseJson);

                validator.validateJSON(fullJson, FULL_SCHEMA);
                log.info("File {} is valid against schema", file.getName());

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ValidationException e) {
                allPass.set(false);
                log.error("File " + file.getName() + " is not valid against schema: " + e.getMessage());
            }
        });

        if (!allPass.get()) {
            fail("Some files are not valid against schema");
        }
    }
}
