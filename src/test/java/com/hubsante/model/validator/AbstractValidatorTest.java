/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
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

import com.hubsante.model.Validator;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public abstract class AbstractValidatorTest {
    protected static String XML_MISSING = "is expected";
    protected final Validator validator = new Validator();

    public void validationPasses(String schema, boolean isXML) throws IOException {
        String input = getMessageString(schema, isXML);
        assertDoesNotThrow(isXML ?
                () -> validator.validateXML(input, FULL_XSD) :
                () -> validator.validateJSON(input, FULL_SCHEMA));
    }

    public void jsonValidationFails(String messageRef, String[] expectedErrors, String schema) throws IOException {
        String input = getInvalidMessage(messageRef);

        try {
            validator.validateJSON(input, schema);
            fail();
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessageArrayExactContent(errors, expectedErrors);
        }
    }

    public void jsonValidationFails(String messageRef, String[] expectedErrors) throws IOException {
        jsonValidationFails(messageRef, expectedErrors, FULL_SCHEMA);
    }

    public void xmlValidationFails(String messageRef, String[] expectedErrors, String schema) throws IOException {
        String input = getInvalidMessage(messageRef);

        try {
            validator.validateXML(input, schema);
            fail();
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            checkErrorMessageArrayExactContent(errors, expectedErrors);
        }
    }

    public void xmlValidationFails(String messageRef, String errorType, String[] expectedErrors) throws IOException {
        String input = getInvalidMessage(messageRef);

        try {
            validator.validateXML(input, FULL_XSD);
            fail();
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            Arrays.stream(expectedErrors).forEach(expected -> checkErrorMessages(errors, errorType, expected));
        }
    }

    public void checkErrorMessages(String[] errors, String expected, String prefix) {

        String[] errorMessages = {XML_MISSING};

        Arrays.stream(errorMessages).forEach(error -> {
            if (error.equals(expected)) {
                assertTrue(Arrays.stream(errors).anyMatch(err -> err.contains(prefix + error)));
            } else {
                assertTrue(Arrays.stream(errors).noneMatch(err -> err.contains(error)));
            }
        });
    }

    /**
     * Check if the error message array contains all of and only the expected errors
     *
     * @param errors
     * @param expectedErrors
     */
    public void checkErrorMessageArrayExactContent(String[] errors, String[] expectedErrors) {
        List<String> errorList = Arrays.asList(errors);
        List<String> expectedErrorList = Arrays.asList(expectedErrors);
        try {
            assertTrue(errorList.containsAll(expectedErrorList));
            assertTrue(expectedErrorList.containsAll(errorList));
        } catch (AssertionError e) {
            log.error("Expected errors: {}", expectedErrorList);
            log.error("Actual errors: {}", errorList);
            throw e;
        }
    }
}
