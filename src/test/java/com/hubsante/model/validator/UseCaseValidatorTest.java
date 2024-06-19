/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class UseCaseValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("Valid error message is thrown: valid envelope and errors in use case")
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
    @DisplayName("Valid error message is thrown: too many valid use cases")
    void tooManyValidSchemas() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "embeddedJsonContent: should be valid to one and only one schema, but 2 are valid"
        };
        jsonValidationFails("too-many-valid-schemas.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: no use cases detected")
    void noSchemasDetected() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required "
        };
        jsonValidationFails("RC-EDA/invalid-RC-EDA-no-schemas.json", expectedErrors);
    }

    @Test
    @DisplayName("Additional properties below wrapper level do not pass validation")
    public void additionalPropertyFails() throws IOException {
        // unknown property below wrapper level will not pass validation
        String refLevelInvalid = getInvalidMessage("RC-REF/reference-level-additional-property.json");
        assertThrows(ValidationException.class, () -> validator.validateJSON(refLevelInvalid, FULL_SCHEMA));

        // unknown property at the wrapper level does not throw exception but will be ignored at deserialization
        String wrapperLevelInvalid = getInvalidMessage("RC-REF/wrapper-level-additional-property.json");
        assertDoesNotThrow(() -> validator.validateJSON(wrapperLevelInvalid, FULL_SCHEMA));
    }



    @Test
    @DisplayName("Valid error message is thrown: unknown property at use case content level")
    public void jsonRcRefAdditionalPropertyFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.unexpectedUnknownProperty: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("EDXL-DE/unknown-property-deep.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: errors in the use case content")
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
    @DisplayName("Valid error message is thrown: missing a required field in use case content")
    void missingRequiredFields() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: is missing but it is required"
        };
        jsonValidationFails("RC-REF/RC-REF-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("Valid error message is thrown: multiple errors in use case content")
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
    @DisplayName("Valid error message is thrown: too many schemas detected and multiple errors in use case content")
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
        File[] subFolders = new File(rootFolder).listFiles(File::isDirectory);
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
