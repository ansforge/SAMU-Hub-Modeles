package com.hubsante.model.edxlhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RcEdaHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RC-EDA")
    public void end2end_RC_EDA_JSON() throws IOException {
        end2end("RC-EDA", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RC-EDA")
    public void end2end_RC_EDA_XML() throws IOException {
        end2end("RC-EDA", true);
    }

    @Test
    @DisplayName("json and xml RC-EDA should be equal")
    public void jsonAndXmlRC_EDA() throws IOException {
        jsonEqualsXml("RC-EDA");
    }
}
