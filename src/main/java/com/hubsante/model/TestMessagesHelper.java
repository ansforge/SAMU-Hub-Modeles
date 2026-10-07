/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
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

import com.google.common.io.ByteStreams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class TestMessagesHelper {
    /**
     * Allows to get a valid sample message as a JSON String
     *
     * @param message type of the message (RC-EDA, RS-INFO, EMSI-DC, etc.)
     * @return the sample message as a JSON String
     * @throws IOException if a sample message of the specified message type does not exist
     */
    public static String getSampleMessage(String message) throws IOException {
        return getSampleMessage(message, false);
    }

    /**
     * Allows to get a valid sample message as a JSON or XML String
     *
     * @param message type of the message (RC-EDA, RS-INFO, EMSI-DC, etc.)
     * @param isXML   whether the message is XML or JSON
     * @return the sample message as a JSON or XML String
     * @throws IOException if a sample message of the specified message type and format does not exist
     */
    public static String getSampleMessage(String message, boolean isXML) throws IOException {
        String extension = isXML ? ".xml" : ".json";
        String filepath = message + "/" + message + extension;
        String json;
        try (InputStream is = TestMessagesHelper.class.getClassLoader().getResourceAsStream("sample/valid/" + filepath)) {
            assert is != null;
            json = new String(ByteStreams.toByteArray(is), StandardCharsets.UTF_8);
        }
        return json;
    }

    /**
     * Allows to get an invalid sample message as a JSON String
     *
     * @param messagePath complete filename of the invalid message template (RC-EDA-missing-required-fields.json,
     *                    RS-ERROR-missing-required-fields.json, EMSI-DC-missing-required-fields.json, etc.)
     * @return the sample invalid message as a JSON String
     * @throws IOException if the specified filename does not correspond to an existing invalid sample message
     */
    public static String getInvalidMessage(String messagePath) throws IOException {
        String json;
        try (InputStream is = TestMessagesHelper.class.getClassLoader().getResourceAsStream("sample/failing/" + messagePath)) {
            assert is != null;
            json = new String(ByteStreams.toByteArray(is), StandardCharsets.UTF_8);
        }
        return json;
    }
}
