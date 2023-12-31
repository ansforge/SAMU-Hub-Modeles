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
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
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

        // We explicitly set the Locale to ensure cross platform consistency
        Locale.setDefault(Locale.ENGLISH);
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

            boolean containsAtLeastOneUseCaseError = false;
            boolean violatesOneOfConstraint = false;

            for (ValidationMessage errorMsg : validationMessages) {
                String error = formatValidationErrorMessage(errorMsg);
                if (error != null) {
                    errors.append(error).append("\n");
                    if(!violatesOneOfConstraint && errorMsg.getType().equals("oneOf")){
                        violatesOneOfConstraint = true;
                    }
                    if(!containsAtLeastOneUseCaseError && errorMsg.getPath().contains(".message.")){
                        containsAtLeastOneUseCaseError = true;
                    }
                }
            }
            // Append a special error message if the error string does not contain a single "use case" error and
            // the there is no 'oneOf' constraint violation
            if (!containsAtLeastOneUseCaseError && !violatesOneOfConstraint) {
                errors.append("could not detect any schemas in the message, at least one is required \n");
            }
            throw new ValidationException("Could not validate message against schema : errors occurred. \n" + errors);
        }
    }

    private String formatValidationErrorMessage(ValidationMessage errorMsg) {
        // We split the path string on '.'
        List<String> path = Arrays.asList(errorMsg.getPath().split("\\."));
        // We find the index of the element 'message' in the errorMsg's path
        int messageIndex = path.indexOf("message");
        if (messageIndex < 0) {
            // Due to the current state of our schema, which contains only one 'oneOf' constraint,
            // if the error type indicates the violation of that constraint, we verify the argument of the
            // error and ignore it if it is '0' (which means that no use case is valid or there are no use
            // cases in the message at all), otherwise we return the error message.
            if (errorMsg.getType().equals("oneOf")) {
                return Arrays.stream(errorMsg.getArguments()).anyMatch(arg -> arg.equals("0")) ?
                        null : errorMsg.getMessage().substring(errorMsg.getMessage().indexOf(path.get((path.size() - 1))));
            } else {
                return errorMsg.getMessage().substring(errorMsg.getMessage().indexOf(path.get(0)));
            }
        } else if (path.indexOf("message") + 1 >= path.size()) {
            // If the path contains the element 'message' and ends immediately after the message 'use case',
            // the error message is irrelevant and we ignore it.
            return null;
        } else {
            // Otherwise, we return the part of error message that comes after the 'message' element
            return errorMsg.getMessage().substring(errorMsg.getMessage().indexOf("message") + 8);
        }
    }
}
