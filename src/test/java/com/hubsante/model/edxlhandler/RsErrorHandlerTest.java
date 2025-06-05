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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.hubsante.model.edxl.EdxlMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RsErrorHandlerTest extends AbstractEdxlHandlerTest {
    @Test
    @DisplayName("should consistently deserialize then serialize JSON RS-ERROR")
    public void end2end_RS_ERROR_JSON() throws IOException {
        end2end("RS-ERROR", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RS-ERROR")
    public void end2end_RS_ERROR_XML() throws IOException {
        end2end("RS-ERROR", true);
    }

    @Test
    @DisplayName("should not deserialize JSON RS-ERROR with inconsistent enum")
    public void invalidJsonRsErrorEnumFails() throws IOException {
        String json = getInvalidMessage("RS-ERROR/RS-ERROR-invalid-enum.json");
        assertThrows(ValueInstantiationException.class, () -> converter.deserializeJsonEDXL(json)); // Or JsonProcessingException on a higher level (exception handled in the Dispatcher methods)
    }

    @Test
    @DisplayName("should not deserialize XML RS-ERROR with inconsistent enum")
    public void invalidXmlRsErrorEnumFails() throws IOException {
        String xml = getInvalidMessage("RS-ERROR/RS-ERROR-invalid-enum.xml");
        assertThrows(ValueInstantiationException.class, () -> converter.deserializeXmlEDXL(xml));
    }
}
