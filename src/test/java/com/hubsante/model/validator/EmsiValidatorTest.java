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

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class EmsiValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("EMSI-DC json validation passes")
    public void jsonEmsiDcValidationPasses() throws IOException {
        validationPasses("EMSI-DC", false);
    }

    @Test
    @DisplayName("EMSI-DC xml validation passes")
    public void xmlEmsiValidationPasses() throws IOException {
        validationPasses("EMSI-DC", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("EMSI-DC json validation fails")
    public void jsonEmsiDcValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - emsi.CONTEXT.ID: is missing but it is required",
                " - emsi.CONTEXT.EXTERNAL_INFO[0].URI: is missing but it is required",
                " - emsi.EVENT.CERTAINTY: string found, integer expected"
        };
        jsonValidationFails("EMSI-DC/EMSI-DC-missing-required-fields.json",  expectedErrors);
    }

    @Test
    @DisplayName("EMSI-DC xml validation fails")
    public void xmlEmsiValidationFails() throws IOException {
        xmlValidationFails("EMSI-DC/EMSI-DC-missing-required-fields.xml", XML_MISSING, new String[]{"ID}' ", "EVENT}' "});
    }
    //endregion
}
