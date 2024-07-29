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

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.emsi.Reference;
import com.hubsante.model.geolocation.GeoPositionsUpdate;
import com.hubsante.model.geolocation.GeoResourcesDetails;
import com.hubsante.model.health.CreateCaseHealth;
import com.hubsante.model.report.Error;
import com.hubsante.model.resources.info.ResourcesInfo;
import com.hubsante.model.resources.request.ResourcesRequest;
import com.hubsante.model.resources.response.ResourcesResponse;
import com.hubsante.model.rpis.Rpis;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;
import static com.hubsante.model.Sanitizer.sanitizeEdxl;

@Slf4j
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
        String useCaseXml = extractXmlUseCase(xml);
        useCaseXml = prettifyXml(useCaseXml);
//        xml = prettifyXml(xml);
        Path xmlFile = Paths.get(jsonFile.toString().replace(".json", ".xml"));
        Files.write(xmlFile, xml.getBytes());
        System.out.println("Converted " + jsonFile + " to " + xmlFile);
    }

    private String extractXmlUseCase(String fullXML) {
        StringBuilder expressionBuilder = new StringBuilder("//*[(local-name()='");
        for (int i = 0; i < edxlHandler.useCases.keySet().size(); i++) {
            if (i > 0) {
                expressionBuilder.append("' or local-name()='");
            }
            expressionBuilder.append(edxlHandler.useCases.keySet().toArray()[i]);
        }
        expressionBuilder.append("')]");

        // XPath expression
        String expression = expressionBuilder.toString();

        try {
            // Parse the XML string into a Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // Important to handle namespaces
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(fullXML)));

            // Create XPathFactory object
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Compile the XPath expression to find the specified elements
            XPathExpression xPathExpression = xpath.compile(expression);

            // Execute the expression to find matching nodes
            Node node = (Node) xPathExpression.evaluate(document, XPathConstants.NODE);

            // Convert the node(s) back to a string
            if (node != null) {
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                StringWriter writer = new StringWriter();
                transformer.transform(new DOMSource(node), new StreamResult(writer));
                return writer.getBuffer().toString();
            } else {
                log.error("No matching nodes found");
                throw new RuntimeException();
            }
        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException | TransformerException e) {
            log.error("Could not extract XML usecase", e);
            throw  new RuntimeException();
        }
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

