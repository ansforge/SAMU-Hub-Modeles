/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model;

import com.hubsante.model.edxl.ContentMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XmlGenerationHelper {
    ContentMessageHandler contentMessageHandler = new ContentMessageHandler();

    public XmlGenerationHelper() {
        contentMessageHandler = new ContentMessageHandler();
    }

    public void generateXmls() {
        Path examplesDir = Paths.get("src/main/resources/sample/examples");

        try (
                Stream<Path> subfolders = Files.list(examplesDir)) {
            subfolders.filter(Files::isDirectory).forEach(subfolder -> {
                try (Stream<Path> jsonFiles = Files.list(subfolder)) {
                    List<Path> jsonFileList = jsonFiles.filter(path -> path.toString().endsWith(".json")).collect(Collectors.toList());
                    for (Path jsonFile : jsonFileList) {
                        convertJsonToXml(jsonFile);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private void convertJsonToXml(Path jsonFile) {
        try {
            String json = new String(Files.readAllBytes(jsonFile));
            ContentMessage deserializedMessage = contentMessageHandler.deserializeJsonContentMessage(json);
            String xml = contentMessageHandler.serializeXmlContentMessage(deserializedMessage);

            Path xmlFile = Paths.get(jsonFile.toString().replace(".json", ".xml"));
            Files.write(xmlFile, xml.getBytes());
            System.out.println("Converted " + jsonFile + " to " + xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

