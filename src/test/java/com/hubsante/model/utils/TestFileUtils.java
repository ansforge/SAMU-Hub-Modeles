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

    public static String getMessageByFileName(String fileName) throws IOException {
        String path = "sample/valid/" + fileName;
        File file = new File(classLoader.getResource(path).getFile());
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }
}
