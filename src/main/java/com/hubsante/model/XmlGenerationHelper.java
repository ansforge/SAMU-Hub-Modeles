/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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

import com.hubsante.model.edxl.ContentMessage;
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XmlGenerationHelper {
    ContentMessageHandler contentMessageHandler = new ContentMessageHandler();
    EdxlHandler edxlHandler = new EdxlHandler();
    private static final String[] useCasesWithNoRcDe = {
            "RS-ERROR"
    };

    public XmlGenerationHelper() {
        contentMessageHandler = new ContentMessageHandler();
    }

    public void generateXmlFiles() {
        Path examplesDir = Paths.get("src/main/resources/sample/examples");

        try (Stream<Path> subfolders = Files.list(examplesDir)) {
            subfolders.filter(Files::isDirectory).forEach(subfolder -> {
                try (Stream<Path> jsonFiles = Files.list(subfolder)) {
                    List<Path> jsonFileList = jsonFiles.filter(path -> path.toString().endsWith(".json")).collect(Collectors.toList());
                    for (Path jsonFile : jsonFileList) {
                        convertJsonToXml(jsonFile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String[] useCases = {
            "createCase",
            "createCaseHealth",
            "emsi",
            "reference",
            "error",
            "geoPositionsUpdate",
            "geoResourcesRequest",
            "geoResourcesDetails",
            "resourcesInfo",
            "resourcesRequest",
            "resourcesResponse",
            "rpis"
    };

    @SneakyThrows
    private void convertJsonToXml(Path jsonFile) throws IOException {
        String json = new String(Files.readAllBytes(jsonFile));
        ContentMessage deserializedContentMessage = contentMessageHandler.deserializeJsonContentMessage(json);
        // We extract the actual content from the deserialized message by checking for the presence of any properties
        // specified in the useCases array
        Field useCase = Arrays.stream(useCases).filter(useCaseName -> {
            try {
                return deserializedContentMessage.getClass().getDeclaredField(useCaseName) != null;
            } catch (NoSuchFieldException e) {
                return false;
            }
        }).findFirst().map(useCaseName -> {
            try {
                return deserializedContentMessage.getClass().getDeclaredField(useCaseName);
            } catch (NoSuchFieldException e) {
                return null;
            }
        }).orElse(null);

        useCase.setAccessible(true);
        Object useCaseObject = useCase.get(deserializedContentMessage);

        String xml = contentMessageHandler.serializeXmlContent(useCaseObject);
        // We modify the case of the use case element name in the resulting xml to make sure it starts from a
        // lowercase letter
        String className = useCaseObject.getClass().getName().split("\\.")[useCaseObject.getClass().getName().split("\\.").length - 1];
        xml = xml.replaceAll(className , useCase.getName().substring(0, 1).toLowerCase() + useCase.getName().substring(1));
        xml = prettifyXml(xml);
        Path xmlFile = Paths.get(jsonFile.toString().replace(".json", ".xml"));
        Files.write(xmlFile, xml.getBytes());
        System.out.println("Converted " + jsonFile + " to " + xmlFile);
    }

    public static String prettifyXml(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return xmlString;
        }
    }
}

