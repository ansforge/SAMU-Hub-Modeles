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

public class GeoReqValidatorTest extends AbstractValidatorTest {

    //region Passes validation
    @Test
    @DisplayName("GEO-REQ json validation passes")
    void GeoReqValidationPasses() throws IOException {
        validationPasses("GEO-REQ", false);
    }

    @Test
    @DisplayName("GEO-REQ xml validation passes")
    public void xmlGeoReqValidationPasses() throws IOException {
        validationPasses("GEO-REQ", true);
    }
    //endregion

    //region Fails validation
    @Test
    @DisplayName("GEO-REQ json validation fails")
    void GeoReqValidationFails() throws IOException {
        String[] expectedErrors = {
                "Could not validate message against schema : errors occurred. ",
                "Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: ",
                " - geoReq.resourceRequest_error: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("GEO-REQ/GEO-REQ-missing-required-fields.json", expectedErrors);
    }

//    @Test
//    @DisplayName("GEO-REQ xml validation fails")
//    public void xmlGeoReqValidationFails() throws IOException {
//        xmlValidationFails("GEO-REQ/GEO-REQ-missing-required-fields.xml", XML_MISSING, new String[]{"distributionID}' "});
//    }

    //endregion

}
