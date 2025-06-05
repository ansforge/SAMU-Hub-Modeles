/**
 * Copyright © 2023-2025 Agence du Numerique en Sante (ANS)
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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RsErrorValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("RS-ERROR json validation passes")
    public void jsonRcRefValidationPasses() throws IOException {
        validationPasses("RS-ERROR", false);
    }

    @Test
    @DisplayName("RS-ERROR xml validation passes")
    public void xmlRcRefValidationPasses() throws IOException {
        validationPasses("RS-ERROR", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("RS-ERROR json validation fails")
    public void jsonRcRefValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message: ",
                " - error.sourceMessage: string found, object expected",
                " - error.errorCode.statusCode: is missing but it is required",
                " - error.referencedDistributionID: is missing but it is required"
        };
        jsonValidationFails("RS-ERROR/RS-ERROR-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("RS-ERROR xml validation fails")
    public void xmlRcRefValidationFails() throws IOException {
        xmlValidationFails("RS-ERROR/RS-ERROR-missing-required-fields.xml", XML_MISSING, new String[]{"referencedDistributionID}' "});
    }
    //endregion
}
