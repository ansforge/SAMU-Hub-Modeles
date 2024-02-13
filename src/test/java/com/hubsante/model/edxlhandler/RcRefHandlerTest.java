package com.hubsante.model.edxlhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RcRefHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RC-REF")
    public void end2end_RC_REF_JSON() throws IOException {
        end2end("RC-REF", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-REF")
    public void end2end_RC_REF_XML() throws IOException {
        end2end("RC-REF", true);
    }

    @Test
    @DisplayName("json and xml RC-REF should be equal")
    public void jsonAndXmlRC_REF() throws IOException {
        jsonEqualsXml("RC-REF");
    }
}
