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

public class GeoPosValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("GEO-POS json validation passes")
    void geoPosValidationPasses() throws IOException {
        validationPasses("GEO-POS", false);
    }

    @Test
    @DisplayName("GEO-POS xml validation passes")
    public void xmlGeoPosValidationPasses() throws IOException {
        validationPasses("GEO-POS", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("GEO-POS json validation fails")
    void geoPosValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - geoPositionsUpdate.position[0].coord[0].lat: is missing but it is required",
                " - geoPositionsUpdate.position[0].coord[0].lon: is missing but it is required"
        };
        jsonValidationFails("GEO-POS/GEO-POS-missing-required-fields.json", expectedErrors);
    }

    @Test
    @DisplayName("GEO-POS xml validation fails")
    public void xmlGeoPosValidationFails() throws IOException {
        xmlValidationFails("GEO-POS/GEO-POS-missing-required-fields.xml", XML_MISSING, new String[]{"One of '{\"urn:emergency:cisu:2.0:geoPositionsUpdate\":lat}' "});
    }

    //endregion

}
