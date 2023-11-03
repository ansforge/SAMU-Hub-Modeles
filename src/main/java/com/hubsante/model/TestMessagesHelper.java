package com.hubsante.model;

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestMessagesHelper {
    /*
     * @param message the name of the message (RC-EDA, RS-INFO, EMSI-DC, etc.)
     * @return the sample message as a Stream of a JSON String
     */
    public static String getSampleMessageAsStream(String message) throws IOException {
        return getSampleMessageAsStream(message, false);
    }

    /*
     * @param message the name of the message (RC-EDA, RS-INFO, EMSI-DC, etc.)
     * @param isXML whether the message is XML or JSON
     * @return the sample message as a Stream of a JSON or XML String
     */
    public static String getSampleMessageAsStream(String message, boolean isXML) throws IOException {
        String extension = isXML ? ".xml" : ".json";
        String filepath = message + "/" + message + extension;
        String json;
        try (InputStream is = TestMessagesHelper.class.getClassLoader().getResourceAsStream("sample/valid/" + filepath)) {
            assert is != null;
            json = new String(ByteStreams.toByteArray(is), StandardCharsets.UTF_8);
        }
        return json;
    }

    public static String getInvalidMessageAsStream(String messagePath) throws IOException {
        String json;
        try (InputStream is = TestMessagesHelper.class.getClassLoader().getResourceAsStream("sample/failing/" + messagePath)) {
            assert is != null;
            json = new String(ByteStreams.toByteArray(is), StandardCharsets.UTF_8);
        }
        return json;
    }
}
