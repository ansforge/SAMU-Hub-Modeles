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
package com.hubsante.model.edxlhandler;

import com.hubsante.model.edxl.EdxlMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class EmsiHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize then serialize JSON EMSI-DC")
    public void end2end_EMSI_DC_JSON() throws IOException {
        end2end("EMSI-DC", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML EMSI-DC")
    public void end2end_EMSI_DC_XML() throws IOException {
        end2end("EMSI-DC", true);
    }

    @Test
    @DisplayName("json and xml EMSI should be equal")
    public void jsonAndXmlEMSI() throws IOException {
        jsonEqualsXml("EMSI-DC");
    }
}
