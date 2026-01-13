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

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class MessagesListTest {

    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @Test
    @DisplayName("Should be able to properly read messagesList.json and verify presence of all schemas mentioned in it")
    public void testMessagesList() {
        List<String> errors = new ArrayList<>();
        // We get messagesList.json from resources/sample/examples folder
        String path = "sample/examples/messagesList.json";
        // We read the contents of messagesList.json
        File file = new File(classLoader.getResource(path).getFile());
        String messagesList = null;
        JSONArray messagesListJsonArray = null;
        try {
            messagesList = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            // If we can't read messagesList.json, we fail the test
            fail("Error while reading messagesList.json: " + e.getMessage());
        }
        try {
            messagesListJsonArray = new JSONArray(messagesList);
        } catch (Exception e) {
            // If there is an exception while reading messagesList.json, we fail the test
            fail("Error while parsing messagesList.json: " + e.getMessage());
        }
        // We iterate over all the schemas mentioned in messagesList.json
        // and verify that they are present in the resources/json-schema folder
        System.out.println("Verifying presence of all schemas mentioned in messagesList.json");
        for (int i = 0; i < messagesListJsonArray.length(); i++) {
            JSONObject message = messagesListJsonArray.getJSONObject(i);
            String schemaName = message.getString("schemaName");
            String schemaPath = "json-schema/" + schemaName;
            try {
                new File(classLoader.getResource(schemaPath).getFile());
            } catch (NullPointerException e) {
                errors.add("Schema not found: "+ schemaPath);
            }
        }

        // We iterate over test messages mentioned in messagesList.json
        // and verify that they are present in the resources/sample/examples folder
        System.out.println("Verifying presence of all test messages mentioned in messagesList.json");
        for (int i = 0; i < messagesListJsonArray.length(); i++) {
            JSONObject message = messagesListJsonArray.getJSONObject(i);
            for (int j = 0; j < message.getJSONArray("examples").length(); j++) {
                JSONObject example = message.getJSONArray("examples").getJSONObject(j);
                String examplePath = "sample/examples/" + example.getString("file");
                try {
                    new File(classLoader.getResource(examplePath).getFile());
                } catch (NullPointerException e) {
                    errors.add("Message not found: " + examplePath);
                }
            }
        }
        
        if (!errors.isEmpty()) {
            fail(String.join("\n", errors));
        }
    }
}
