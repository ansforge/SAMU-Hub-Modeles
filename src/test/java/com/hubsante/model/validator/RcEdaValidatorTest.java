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
