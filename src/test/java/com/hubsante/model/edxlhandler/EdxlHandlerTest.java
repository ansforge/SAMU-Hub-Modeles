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
package com.hubsante.model.edxlhandler;

import com.ctc.wstx.stax.WstxInputFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hubsante.model.TestMessagesHelper;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import javax.xml.stream.XMLInputFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessage;
import static com.hubsante.model.EdxlWrapperUtils.wrapUseCaseMessageWithoutDistributionElement;
import static com.hubsante.model.TestMessagesHelper.getInvalidMessage;
import static com.hubsante.model.Utils.createCustomJavaTimeModule;
import static com.hubsante.model.Utils.getXmlMapper;
import static com.hubsante.model.config.Constants.FULL_XSD;
import static com.hubsante.model.utils.TestFileUtils.getMessageByFileName;
import static com.hubsante.model.utils.TestFileUtils.getMessageString;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class EdxlHandlerTest extends AbstractEdxlHandlerTest {

    private static final String[] useCasesWithNoRcDe = {
            "RS-ERROR"
    };

    @Test
    @DisplayName("should consistently deserialize EDXL with several content objects")
    public void deserializeEDXLWithSeveralContentObjects() throws IOException {
        String json = getMessageString("EDXL-DE");
        EdxlMessage message = converter.deserializeJsonEDXL(json);

        assertEquals(2, message.getContent().size());
        assertEquals(2, message.getAllContentMessages().size());
        assertEquals(message.getFirstContentMessage(), message.getAllContentMessages().get(0));
    }

    @Test
    @DisplayName("should add XML prefix")
    public void verifyXmlPrefix() throws IOException {
        String json = getMessageByFileName("TECHNICAL/complete.json");
        EdxlMessage messageFromInput = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(messageFromInput);
        assertTrue(() -> xml.startsWith(xmlPrefix()));
    }

    @Test
    @DisplayName("should deserialize complete message with EDXL-DE envelope")
    public void deserializeCompleteMessages() throws IOException {
        File jsonMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/EDXL-DE/EDXL-DE.json").getFile());
        String useCaseJson = new String(Files.readAllBytes(jsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage message = converter.deserializeJsonEDXL(useCaseJson);

        File xmlMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/EDXL-DE/EDXL-DE.xml").getFile());
        String useCaseXml = new String(Files.readAllBytes(xmlMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage expectedMessage = converter.deserializeXmlEDXL(useCaseXml);
    }

    @Test
    @DisplayName("deserialization of a message with an unknown additional property not at root level fails")
    public void deserializationOfMessageWithUnknownPropertyNotAtRootLevelFails() throws IOException {
        String json = getInvalidMessage("EDXL-DE/unknown-property-deep.json");
        assertThrows(UnrecognizedPropertyException.class, () -> converter.deserializeJsonEDXL(json));
    }

    @Test
    @DisplayName("all json example files deserialize to same object xml example files deserialize to")
    public void jsonAndXmlExampleFilesDeserializeToSameObject() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();

        File[] subFolders = new File(rootFolder).listFiles(File::isDirectory);
        assert subFolders != null;
        List<File> exampleFiles = new ArrayList<>();

        Arrays.stream(subFolders).forEach(folder -> {
            exampleFiles.addAll(Arrays.asList(Objects.requireNonNull(folder.listFiles())));
        });

        // RS-ERROR messages cannot be compared due to sourceMessage not having any particular definitions
        // and not being deserialized correctly from XML, we remove the RS-ERROR files from the list
        List<File> filteredExampleFiles = exampleFiles.stream().filter(file -> !file.getName().startsWith("RS-ERROR")).collect(Collectors.toList());

        AtomicBoolean allPass = new AtomicBoolean(true);

        filteredExampleFiles.forEach(file -> {
            try {
                if (file.getName().endsWith(".json")) {
                    String jsonExample = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                    String xmlExample = new String(Files.readAllBytes(new File(file.getParentFile(), file.getName().replace(".json", ".xml")).toPath()), StandardCharsets.UTF_8);

                    JsonNode jsonNode = converter.jsonMapper.readTree(jsonExample);
                    String useCaseName = jsonNode.fieldNames().next();
                    JsonNode useCaseNode = jsonNode.get(useCaseName);

                    log.info("testing " + file.getName() + ": ");
                    assertEquals(
                            converter.jsonMapper.treeToValue(useCaseNode, Class.forName(ContentMessage.UseCaseHelper.useCases.get(useCaseName))),
                            converter.xmlMapper.readValue(xmlExample, Class.forName(ContentMessage.UseCaseHelper.useCases.get(useCaseName))));
                    log.info("xml and json are equal for " + useCaseName + " useCase.");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (AssertionFailedError e) {
                allPass.set(false);
                log.error("Files {} are not equivalent: {}", file.getName(), e.getMessage());
            }
        });
        if (!allPass.get()) {
            fail("Some files are not equivalent");
        }
    }

    @Test
    @DisplayName("serialized Xml EdxlMessages should contain xlink type")
    public void serializedXmlEdxlMessagesShouldContainXlinkType() throws IOException {
        File jsonMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/RC-EDA/RC-EDA.json").getFile());
        String json = new String(Files.readAllBytes(jsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage message = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(message);
        assertTrue(xml.contains("<content xlink:type=\"resource\""));
    }

    @Test
    @DisplayName("several content elements")
    public void severalContentElements() throws IOException, ValidationException {
        File jsonMessage = new File(TestMessagesHelper.class.getClassLoader().getResource("sample/valid/CustomContent/custom-content.json").getFile());
        String json = new String(Files.readAllBytes(jsonMessage.toPath()), StandardCharsets.UTF_8);
        EdxlMessage message = converter.deserializeJsonEDXL(json);
        String xml = converter.serializeXmlEDXL(message);
        validator.validateXML(xml, FULL_XSD);
        // xlink attribute must have been added at the EDXL Content Element, but not lower
        assertTrue(xml.contains("</descriptor><content xlink:type=\"resource\""));
        assertFalse(xml.contains("<customContent><content xlink:type=\"resource\""));
    }

    @Test
    @DisplayName("all json example files survive a JSON and XML serialization round trip")
    public void examplesSerializationRoundTrip() {
        AtomicBoolean allPass = new AtomicBoolean(true);

        getJsonExampleFiles().forEach(file -> {
            try {
                String fullJson = wrapExample(file);
                endToEndDeserializationCheck(fullJson, false);

                String fullXml = converter.serializeXmlEDXL(converter.deserializeJsonEDXL(fullJson));
                endToEndDeserializationCheck(fullXml, true);
                log.info("File {} has been successfully round tripped", file.getName());
            } catch (IOException | RuntimeException | AssertionFailedError e) {
                allPass.set(false);
                log.error("File {} could not be round tripped: {}", file.getName(), e.getMessage());
            }
        });

        if (!allPass.get()) {
            fail("Some files could not be round tripped");
        }
    }

    @Test
    @DisplayName("use case name matches the example root element and is not serialized")
    public void useCaseNameMatchesRootElementAndIsNotSerialized() {
        AtomicBoolean allPass = new AtomicBoolean(true);

        getJsonExampleFiles().forEach(file -> {
            try {
                String useCaseName = converter.jsonMapper.readTree(file).fieldNames().next();
                EdxlMessage message = converter.deserializeJsonEDXL(wrapExample(file));

                assertEquals(useCaseName, message.getFirstContentMessage().getUseCaseName());
                assertFalse(converter.serializeJsonEDXL(message).contains("useCaseName"), "useCaseName found in JSON");
                assertFalse(converter.serializeXmlEDXL(message).contains("useCaseName"), "useCaseName found in XML");
            } catch (IOException | AssertionFailedError e) {
                allPass.set(false);
                log.error("File {} has an invalid use case name: {}", file.getName(), e.getMessage());
            }
        });

        if (!allPass.get()) {
            fail("Some files have an invalid use case name");
        }
    }

    private List<File> getJsonExampleFiles() {
        String rootFolder = TestMessagesHelper.class.getClassLoader().getResource("sample/examples").getFile();
        File[] subFolders = new File(rootFolder).listFiles(File::isDirectory);
        assert subFolders != null;

        return Arrays.stream(subFolders)
                .flatMap(folder -> Arrays.stream(Objects.requireNonNull(folder.listFiles())))
                .filter(file -> file.getName().endsWith(".json"))
                .collect(Collectors.toList());
    }

    private String wrapExample(File file) throws IOException {
        String useCaseJson = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        if (Arrays.stream(useCasesWithNoRcDe).anyMatch(file.getName()::contains))
            return wrapUseCaseMessageWithoutDistributionElement(useCaseJson);
        return wrapUseCaseMessage(useCaseJson);
    }

    @Test
    @DisplayName("XXE injection should succeed in vulnerable config and fail in safe config")
    public void testXXEDifferentialBehavior() throws Exception {
        String xml = getInvalidMessage("EDXL-DE/external-entity.xml");

        // Mapper vulnérable (sans protection)
        WstxInputFactory vulInputFactory = new WstxInputFactory();
        vulInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, true);
        vulInputFactory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, true);
        XmlMapper vulnerableMapper = new XmlMapper(vulInputFactory);
        vulnerableMapper.registerModule(createCustomJavaTimeModule()).disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);// config par défaut

        // Mapper sécurisé (protection DTD + entités externes)
        XmlMapper secureMapper = getXmlMapper();

        // 1. Mapper vulnérable : doit injecter le contenu de l'entité
        EdxlMessage vulnerableMessage = vulnerableMapper.readValue(xml, EdxlMessage.class);
        String distributionID = vulnerableMessage.getDistributionID();

        assertNotNull(distributionID);
        assertFalse(distributionID.contains("&xxe;")); // Il ne doit pas rester l'entité brute

        // 2. Mapper sécurisé : doit échouer ou ne pas injecter
        Exception exception = assertThrows(JsonProcessingException.class, () -> {
            secureMapper.readValue(xml, EdxlMessage.class);
        });
        assertTrue(exception.getMessage().contains("Undeclared general entity"));
    }

}
