/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.edxlhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GeoResHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize then serialize JSON GEO-RES")
    public void end2end_GEO_RES_JSON() throws IOException {
        end2end("GEO-RES", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML GEO-RES")
    public void end2end_GEO_RES_XML() throws IOException {
        end2end("GEO-RES", true);
    }

    @Test
    @DisplayName("json and xml GEO-RES should be equal")
    public void jsonAndXmlGEO_RES() throws IOException {
        jsonEqualsXml("GEO-RES");
    }
}
