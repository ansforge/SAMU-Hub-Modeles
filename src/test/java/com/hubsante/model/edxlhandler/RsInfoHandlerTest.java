package com.hubsante.model.edxlhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RsInfoHandlerTest extends AbstractEdxlHandlerTest {

    @Test
    @DisplayName("should consistently deserialize then serialize JSON RS-INFO")
    public void end2end_RS_INFO_JSON() throws IOException {
        end2end("RS-INFO", false);
    }

    @Test
    @DisplayName("should consistently deserialize then serialize XML RS-INFO")
    public void end2end_RS_INFO_XML() throws IOException {
        end2end("RS-INFO", true);
    }
}
