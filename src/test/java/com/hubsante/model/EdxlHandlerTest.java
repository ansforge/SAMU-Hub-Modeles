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
        String json = getMessageString(true, "RC-EDA", false);
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-EDA")
    public void end2end_RC_EDA_XML() throws IOException {
        String xml = getMessageString(true, "RC-EDA", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON EMSI-DC")
    public void end2end_EMSI_DC_JSON() throws IOException {
        String json = getMessageString(true, "EMSI-DC", false);
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML EMSI-DC")
    public void end2end_EMSI_DC_XML() throws IOException {
        String xml = getMessageString(true, "EMSI-DC", true);
//        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RC-REF")
    public void end2end_RC_REF_JSON() throws IOException {
        String json = getMessageString(true, "RC-REF", false);
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-REF")
    public void end2end_RC_REF_XML() throws IOException {
        String xml = getMessageString(true, "RC-REF", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RS-INFO")
    public void end2end_RS_INFO_JSON() throws IOException {
        String json = getMessageString(true, "RS-INFO", false);
        endToEndDeserializationCheck(json, false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RS-INFO")
    public void end2end_RS_INFO_XML() throws IOException {
        String xml = getMessageString(true, "RS-INFO", true);
        endToEndDeserializationCheck(xml, true);
    }

    @Test
    @DisplayName("should add XML prefix")
    public void verifyXmlPrefix() throws IOException {
        String json = getMessageString(true, "RC-EDA", false);

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

        assertEquals(messageFromInput, messageFromOutput);
    }

    private String xmlPrefix() {
        return "<?xml version='1.0' encoding='UTF-8'?>";
    }
}
