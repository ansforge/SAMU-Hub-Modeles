/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.exception.ValidationException;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Set;

@Slf4j
public class Validator {

    private ObjectMapper jsonMapper;
    private XmlMapper xmlMapper;

    public Validator() {
        xmlMapper = (XmlMapper) new XmlMapper()
                .registerModule(new JavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

        xmlMapper.configure(com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        jsonMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    }

    public void validateXML(String message, String xsdFile) throws IOException, ValidationException {
        try {
            javax.xml.validation.Validator validator = initValidator(xsdFile);
            validator.validate(new StreamSource(new StringReader(message)));
        } catch (SAXException e) {
            // TODO bbo: check what message is wrapped by SAXException
            throw new ValidationException("Could not validate message against schema : errors occurred. \n" + e.getMessage());
        }
    }

    private javax.xml.validation.Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(getClass().getClassLoader().getResource("xsd/" + xsdPath).getFile()));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    public void validateJSON(String message, String jsonSchemaFile) throws IOException, ValidationException {
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        // If the schema file references local sub-schema, it must reference the classpath as its id
        // the library behavior is to construct an URI from the id, and then add the schema file name to it
        // if the id is a http URI, it will try to download the subschema online
        // Ref.: https://github.com/networknt/json-schema-validator/issues/55
        InputStream schemaStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("json-schema/" + jsonSchemaFile);
        JsonSchema jsonSchema = factory.getSchema(schemaStream);

        JsonNode jsonNode = jsonMapper.readTree(message);
        Set<ValidationMessage> validationMessages = jsonSchema.validate(jsonNode);

        if (!validationMessages.isEmpty()) {
            StringBuilder errors = new StringBuilder();
            for (ValidationMessage errorMsg : validationMessages) {
                errors.append(errorMsg.getMessage()).append("\n");
            }
            throw new ValidationException("Could not validate message against schema : errors occurred. \n" + errors);
        }
    }
}
