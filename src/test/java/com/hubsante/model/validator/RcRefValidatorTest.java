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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    @DisplayName("RC-REF incorrect property type validation fails")
    public void jsonRcRefIncorrectPropertyTypeValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Could not detect any schemas in the message, at least one is required ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: ",
                " - kind: integer found, string expected",
                " - recipient[0].name: integer found, string expected",
                " - status: does not have a value in the enumeration [Actual, Exercise, System]",
                " - kind: does not have a value in the enumeration [Report, Update, Cancel, Ack, Error]",
                " - recipient[0].URI: integer found, string expected",
                " - status: integer found, string expected"
        };
        jsonValidationFails("RC-REF/RC-REF-invalid-type.json", expectedErrors);
    }

    @Test
    @DisplayName("RC-REF array where object is expected validation fails")
    public void jsonRcRefArrayWhereObjectIsExpectedValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - reference.distributionID: array found, string expected"
        };
        jsonValidationFails("RC-REF/RC-REF-unexpected-array.json", expectedErrors);
    }

    @Test
    @DisplayName("RC-REF xml validation fails")
    public void xmlRcRefValidationFails() throws IOException {
        xmlValidationFails("RC-REF/RC-REF-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
    }
    //endregion
}
