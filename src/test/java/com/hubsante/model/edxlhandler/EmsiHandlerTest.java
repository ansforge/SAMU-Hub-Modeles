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
