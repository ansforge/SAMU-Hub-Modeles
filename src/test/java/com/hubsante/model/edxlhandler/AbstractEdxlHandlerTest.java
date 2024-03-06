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
package com.hubsante.model.edxlhandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hubsante.model.EdxlHandler;
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.hubsante.model.utils.Sanitizer.sanitizeEdxl;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public abstract class AbstractEdxlHandlerTest {
    protected EdxlHandler converter = new EdxlHandler();

    protected void end2end(String schema, boolean isXML) throws IOException {
        String json = getMessageString(schema, isXML);
        endToEndDeserializationCheck(json, isXML);
    }

    protected void jsonEqualsXml(String schema) throws IOException {
        String json = getMessageString(schema);
        String xml = getMessageString(schema, true);

        EdxlMessage messageFromJson = sanitizeEdxl(converter.deserializeJsonEDXL(json));
        EdxlMessage messageFromXml = sanitizeEdxl(converter.deserializeXmlEDXL(xml));
        assertEquals(messageFromJson, messageFromXml);
    }
    protected void endToEndDeserializationCheck(String input, boolean isXML) throws JsonProcessingException {
        EdxlMessage messageFromInput;
        EdxlMessage messageFromOutput;

        if (isXML) {
            messageFromInput = converter.deserializeXmlEDXL(input);
            String output = converter.serializeXmlEDXL(messageFromInput);
            messageFromOutput = converter.deserializeXmlEDXL(output);
        } else {
            messageFromInput = converter.deserializeJsonEDXL(input);
            String output = converter.serializeJsonEDXL(messageFromInput);
            messageFromOutput = converter.deserializeJsonEDXL(output);
        }

        /*
         * We prefer compare objects instead of strings to avoid noise such as indentation issues, line breaks, etc.
         * (basically, our serializer generates one-liners but we prefer to store our commit files with indentation for readability)
         */
        assertEquals(messageFromInput, messageFromOutput);
    }
    protected String xmlPrefix() {
        return "<?xml version='1.0' encoding='UTF-8'?>";
    }
}
