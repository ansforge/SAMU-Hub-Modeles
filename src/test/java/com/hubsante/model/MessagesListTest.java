package com.hubsante.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.fail;

public class MessagesListTest {

    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    @Test
    @DisplayName("Should be able to properly read messagesList.json and verify presence of all schemas mentioned in it")
    public void testMessagesList() {
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
            File schemaFile = new File(classLoader.getResource(schemaPath).getFile());
            if (!schemaFile.exists()) {
                fail("Schema " + schemaName + " mentioned in messagesList.json not found in resources/json-schema folder");
            }
        }
    }
}
