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

import com.hubsante.model.edxl.EdxlMessage;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;
import static com.hubsante.model.Sanitizer.sanitizeEdxl;

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
        EdxlMessage deserialzedEdxlMessage;
        if (Arrays.stream(useCasesWithNoRcDe).anyMatch(name -> jsonFile.getFileName().toString().contains(name))) {
            deserialzedEdxlMessage = sanitizeEdxl(edxlHandler.deserializeJsonEDXL(
                    wrapUseCaseMessageWithoutDistributionElement(new String(Files.readAllBytes(jsonFile)))));
        } else {
            deserialzedEdxlMessage = sanitizeEdxl(edxlHandler.deserializeJsonEDXL(
                    wrapUseCaseMessage(new String(Files.readAllBytes(jsonFile)))));
        }
        String xml = edxlHandler.serializeXmlEDXL(deserialzedEdxlMessage);
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

