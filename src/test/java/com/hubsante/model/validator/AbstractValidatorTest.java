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
import com.hubsante.model.Validator;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.config.Constants.*;
import static com.hubsante.model.utils.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public abstract class AbstractValidatorTest {
    protected static String TOO_MANY_SCHEMAS = "embeddedJsonContent: should be valid to one and only one schema, but";
    protected static String NO_SCHEMAS = "could not detect any schemas in the message, at least one is required";
    protected static String JSON_MISSING = "is missing but it is required";
    protected static String XML_MISSING = "is expected";
    protected final Validator validator = new Validator();

    public void validationPasses(String schema, boolean isXML) throws IOException {
        String input = getMessageString(schema, isXML);
        assertDoesNotThrow(isXML ?
                () -> validator.validateXML(input, FULL_XSD):
                () -> validator.validateJSON(input, FULL_SCHEMA));
    }

    // You can use this method to test several errors if and only if the errorType is the same
    public void validationFails(String schema, boolean isXML, String errorType, String... prefixes) throws IOException {
        String input = getMessageString(schema, isXML, false);

        assertThrows(ValidationException.class, isXML ?
                () -> validator.validateXML(input, FULL_XSD) :
                () -> validator.validateJSON(input, FULL_SCHEMA));

        // we verify the correct error message is thrown
        try {
            if (isXML) {
                validator.validateXML(input, FULL_XSD);
            } else {
                validator.validateJSON(input, FULL_SCHEMA);
            }
        } catch (ValidationException e) {
            String[] errors = e.getMessage().split("\n");
            Arrays.stream(prefixes).forEach(prefix -> checkErrorMessages(errors, errorType, prefix));
        }
    }

    public void checkErrorMessages(String[] errors, String expected, String prefix) {

        String[] errorMessages = { TOO_MANY_SCHEMAS, NO_SCHEMAS, JSON_MISSING, XML_MISSING };

        Arrays.stream(errorMessages).forEach(error -> {
            if (error.equals(expected)) {
                assertTrue(Arrays.stream(errors).anyMatch(err -> err.contains(prefix + error)));
            } else {
                assertTrue(Arrays.stream(errors).noneMatch(err -> err.contains(error)));
            }
        });
    }

    public void checkErrorMessages(String[] errors, String expected) {
        checkErrorMessages(errors, expected, "");
    }
}
