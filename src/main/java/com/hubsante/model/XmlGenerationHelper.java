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

import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;

@Slf4j
public class XmlGenerationHelper {
    EdxlHandler edxlHandler = new EdxlHandler();
    private static final String[] useCasesWithNoRcDe = {
            "RS-ERROR"
    };

    public void generateXmlFiles() {
        Path examplesDir = Paths.get("src/main/resources/sample/examples");
        ArrayList<String> errorsDuringConversion = new ArrayList<>();

        try (Stream<Path> subfolders = Files.list(examplesDir)) {
            subfolders.filter(Files::isDirectory).forEach(subfolder -> {
                try (Stream<Path> jsonFiles = Files.list(subfolder)) {
                    List<Path> jsonFileList = jsonFiles.filter(path -> path.toString().endsWith(".json")).collect(Collectors.toList());
                    for (Path jsonFile : jsonFileList) {
                        try {
                            convertJsonToXml(jsonFile);
                        } catch (IOException e) {
                            errorsDuringConversion.add("Could not convert file " + jsonFile.getFileName() + " to XML, " + e.getMessage());
                        } catch (RuntimeException e) {
                            errorsDuringConversion.add("Could not convert file " + jsonFile.getFileName() + " to XML, no nodes detected");
                        }
                    }
                } catch (IOException e) {
                    errorsDuringConversion.add("Error during file streaming in subfolder " + subfolder.getFileName() + ", " + e.getMessage());
                }
            });
        } catch (IOException e) {
            errorsDuringConversion.add("Error during file streaming in folder " + examplesDir.getFileName() + ", " + e.getMessage());
        }
        if (!errorsDuringConversion.isEmpty()) {
            log.error("Errors during conversion: ");
            errorsDuringConversion.forEach(log::error);
            System.exit(1);
        }

    }

    private void convertJsonToXml(Path jsonFile) throws IOException, RuntimeException {
        EdxlMessage deserializedEdxlMessage;
        if (Arrays.stream(useCasesWithNoRcDe).anyMatch(name -> jsonFile.getFileName().toString().contains(name))) {
            deserializedEdxlMessage = edxlHandler.deserializeJsonEDXL(
                    wrapUseCaseMessageWithoutDistributionElement(new String(Files.readAllBytes(jsonFile))));
        } else {
            deserializedEdxlMessage = edxlHandler.deserializeJsonEDXL(
                    wrapUseCaseMessage(new String(Files.readAllBytes(jsonFile))));
        }
        String xml = edxlHandler.serializeXmlEDXL(deserializedEdxlMessage);
        String useCaseXml = prettifyXml(extractXmlUseCase(xml));
        Path xmlFile = Paths.get(jsonFile.toString().replace(".json", ".xml"));
        Files.write(xmlFile, useCaseXml.getBytes());
        log.info("Converted " + jsonFile + " to " + xmlFile);
    }

    private String extractXmlUseCase(String fullXML) {
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
            String expression = getUseCaseXPathExpression();
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

    private static String getUseCaseXPathExpression() {
        StringBuilder expressionBuilder = new StringBuilder("//*[(local-name()='");
        for (int i = 0; i < ContentMessage.UseCaseHelper.useCases.keySet().size(); i++) {
            if (i > 0) {
                expressionBuilder.append("' or local-name()='");
            }
            expressionBuilder.append(ContentMessage.UseCaseHelper.useCases.keySet().toArray()[i]);
        }
        expressionBuilder.append("')]");

        // XPath expression
        return expressionBuilder.toString();
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
            log.error("Could not prettify XML, {}", e.getMessage());
            return xmlString;
        }
    }
}

