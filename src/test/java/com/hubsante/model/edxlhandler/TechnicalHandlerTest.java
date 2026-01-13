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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hubsante.model.Utils;
import com.hubsante.model.technical.Technical;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.utils.TestFileUtils.getMessageByFileName;
import static org.junit.jupiter.api.Assertions.*;

public class TechnicalHandlerTest {

    private static XmlMapper xmlMapper = Utils.getXmlMapper();

    private static ObjectMapper jsonMapper = Utils.getJsonMapper();

    @Test
    @DisplayName("Complete TECHNICAL messages should deserialize to same object from json and xml files")
    public void testCompleteTechnicalDeserialization() throws IOException {
        String json = getMessageByFileName("TECHNICAL/complete.json");
        Technical jsonTechnical = jsonMapper.readValue(json, Technical.class);

        String xml = getMessageByFileName("TECHNICAL/complete.xml");
        Technical xmlTechnical = xmlMapper.readValue(xml, Technical.class);

        assertEquals(jsonTechnical, xmlTechnical);

        String jsonSerialized = jsonMapper.writeValueAsString(jsonTechnical);
        assertTrue(jsonSerialized.contains("2022-09-27T08:25:54+00:00"));
        assertFalse(jsonSerialized.contains("2022-09-27T08:25:54Z"));

        String xmlSerialized = xmlMapper.writeValueAsString(xmlTechnical);
        assertTrue(xmlSerialized.contains("2022-09-27T08:25:54+00:00"));
        assertFalse(xmlSerialized.contains("2022-09-27T08:25:54Z"));
    }

    @Test
    @DisplayName("Deserialized arrays should be of correct size")
    public void testDeserializedArrays() throws IOException {
        String json = getMessageByFileName("TECHNICAL/array-deserialization.json");
        Technical jsonTechnical = jsonMapper.readValue(json, Technical.class);

        String xml = getMessageByFileName("TECHNICAL/array-deserialization.xml");
        Technical xmlTechnical = xmlMapper.readValue(xml, Technical.class);

        assertEquals(jsonTechnical.getRequiredArray().size(), 1);
        assertEquals(jsonTechnical.getEnumArrayField().size(), 3);
        assertEquals(jsonTechnical.getArrayWithMaxLength().size(), 5);

        assertEquals(xmlTechnical.getRequiredArray().size(), 1);
        assertEquals(xmlTechnical.getEnumArrayField().size(), 3);
        assertEquals(xmlTechnical.getArrayWithMaxLength().size(), 5);
    }

    @Test
    @DisplayName("Nomenclatures should be deserialized correctly")
    public void testNomenclatures() throws IOException {
        String json = getMessageByFileName("TECHNICAL/nomenclature-test.json");
        Technical jsonTechnical = jsonMapper.readValue(json, Technical.class);

        String xml = getMessageByFileName("TECHNICAL/nomenclature-test.xml");
        Technical xmlTechnical = xmlMapper.readValue(xml, Technical.class);

        assertEquals(jsonTechnical.getNomenclatureField().getValue(), "M");
        assertEquals(jsonTechnical.getEnumArrayField().get(0).getValue(), "ENUM_VALUE_10");
        assertEquals(jsonTechnical.getEnumArrayField().get(1).getValue(), "ENUM_VALUE_20");
        assertEquals(jsonTechnical.getEnumArrayField().get(2).getValue(), "ENUM_VALUE_30");

        assertEquals(xmlTechnical.getNomenclatureField().getValue(), "M");
        assertEquals(xmlTechnical.getEnumArrayField().get(0).getValue(), "ENUM_VALUE_10");
        assertEquals(xmlTechnical.getEnumArrayField().get(1).getValue(), "ENUM_VALUE_20");
        assertEquals(xmlTechnical.getEnumArrayField().get(2).getValue(), "ENUM_VALUE_30");
    }

    @Test
    @DisplayName("Regex-compliant values should pass deserialization")
    public void testRegexCompliantValues() throws IOException {
        String json = getMessageByFileName("TECHNICAL/regex-validation.json");
        assertDoesNotThrow(() -> jsonMapper.readValue(json, Technical.class));

        String xml = getMessageByFileName("TECHNICAL/regex-validation.xml");
        assertDoesNotThrow(() -> xmlMapper.readValue(xml, Technical.class));
    }
}
