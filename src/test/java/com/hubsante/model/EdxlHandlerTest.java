/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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
package com.hubsante.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class EdxlHandlerTest {
    private EdxlHandler converter = new EdxlHandler();

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RC-EDA")
    public void end2end_RC_EDA_JSON() throws IOException {
        String json = getMessageString( "RC-EDA");
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-EDA")
    public void end2end_RC_EDA_XML() throws IOException {
        String xml = getMessageString( "RC-EDA", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON EMSI-DC")
    public void end2end_EMSI_DC_JSON() throws IOException {
        String json = getMessageString("EMSI-DC");
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML EMSI-DC")
    public void end2end_EMSI_DC_XML() throws IOException {
        String xml = getMessageString("EMSI-DC", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RC-REF")
    public void end2end_RC_REF_JSON() throws IOException {
        String json = getMessageString("RC-REF");
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-REF")
    public void end2end_RC_REF_XML() throws IOException {
        String xml = getMessageString("RC-REF", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RS-INFO")
    public void end2end_RS_INFO_JSON() throws IOException {
        String json = getMessageString("RS-INFO");
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RS-INFO")
    public void end2end_RS_INFO_XML() throws IOException {
        String xml = getMessageString("RS-INFO", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize EDXL with several content objects")
    public void deserializeEDXLWithSeveralContentObjects() throws IOException {
        String json = getMessageString("EDXL-DE");
        EdxlMessage message = converter.deserializeJsonEDXL(json);

        assertEquals(2, message.getContent().size());
        assertEquals(2, message.getAllContentMessages().size());
        assertEquals(message.getFirstContentMessage(), message.getAllContentMessages().get(0));
    }

    @Test
    @DisplayName("should add XML prefix")
    public void verifyXmlPrefix() throws IOException {
        String json = getMessageString("RC-EDA");
        EdxlMessage messageFromInput = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(messageFromInput);
        assertTrue(() -> xml.startsWith(xmlPrefix()));
    }

    private void endToEndDeserializationCheck(String input, boolean isXML) throws JsonProcessingException {
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

    private String xmlPrefix() {
        return "<?xml version='1.0' encoding='UTF-8'?>";
    }
}
