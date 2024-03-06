package com.hubsante.model.edxlhandler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
}
