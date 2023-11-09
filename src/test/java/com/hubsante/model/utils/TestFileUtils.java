package com.hubsante.model.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class TestFileUtils {
    static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    public static String getMessageString(String schemaName) throws IOException {
        return getMessageString(schemaName, false);
    }

    public static String getMessageString(String schemaName, boolean isXML) throws IOException {
        return getMessageString(schemaName, isXML, true);
    }
    public static String getMessageString(String schemaName, boolean isXML, boolean isValid) throws IOException {
        String resourcePath = getTestFilePath(isValid, schemaName, isXML);
        File file = new File(classLoader.getResource(resourcePath).getFile());
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }

    public static String getTestFilePath(boolean isValid, String schemaName, boolean isXML) {
        String subFolder = isValid ? "valid" : "failing";
        String fileName = isValid ? schemaName : schemaName + "-missing-required-fields";
        String extension = isXML ? ".xml" : ".json";

        return "sample/" + subFolder + "/" + schemaName + "/" + fileName + extension;
    }
}
