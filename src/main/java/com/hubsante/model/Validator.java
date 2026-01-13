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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.builders.ValidationMessageWrapperBuilder;
import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.exception.ValidationException;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import lombok.extern.slf4j.Slf4j;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;
import java.lang.reflect.Field;

import static com.hubsante.model.config.Constants.FULL_XSD;
import static com.hubsante.model.config.Constants.FULL_XSD_NO_HEADER;

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
        javax.xml.validation.Validator validator;
        javax.xml.validation.Validator noHeaderValidator;
        try {
            validator = initValidator(xsdFile);
            noHeaderValidator = initValidator(FULL_XSD_NO_HEADER);

            List<String> xmlErrors = performXMLValidation(message, validator);
            if (!xmlErrors.isEmpty()) {
                // if validation has been performed on the upper level, it could have raised errors on missing RC-DE elements
                // but it some cases (Custom Content, Error...) it is valid so we test it on another sub schema
                if (xsdFile.equals(FULL_XSD)) {
                    List<String> noHeaderMessageXmlErrors = performXMLValidation(message, noHeaderValidator);
                    if (noHeaderMessageXmlErrors.isEmpty()) {
                        return;
                    }
                    xmlErrors.addAll(noHeaderMessageXmlErrors);
                }
                throw new ValidationException("Could not validate message against schema : errors occurred. \n" + xmlErrors);
            }

        } catch (SAXException e) {
            // Technically, SAXExceptions can be thrown by the validate method
            // But in our case, we add a errorHandler in the initValidator method, so the SAXException which could be thrown
            // should only come from the initValidator method
            log.error("Something went wrong with the XSD Validator" + e.getMessage());
            throw new ValidationException("Something went wrong with the XSD Validator.");
        }
    }

    private List<String> performXMLValidation(String message, javax.xml.validation.Validator validator) throws IOException, SAXException {

        validator.validate(new StreamSource(new StringReader(message)));
        XmlErrorHandler errorHandler = (XmlErrorHandler) validator.getErrorHandler();
        List<SAXParseException> xmlExceptions = errorHandler.getExceptions();

        List<String> xmlErrors = new ArrayList<>();
        if (!xmlExceptions.isEmpty()) {
            xmlExceptions.forEach(e -> xmlErrors.add(e.getMessage()));
        }
        return xmlErrors;
    }

    private javax.xml.validation.Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        // I have the hardest time to figure it out !
        // Ref: https://stackoverflow.com/questions/10997453/java-xml-validation-does-not-work-when-schema-comes-from-classpath
        Source schemaFile = new StreamSource(
                getClass().getClassLoader().getResourceAsStream("xsd/" + xsdPath),
                getClass().getClassLoader().getResource("xsd/" + xsdPath).toString());
        Schema schema = factory.newSchema(schemaFile);
        javax.xml.validation.Validator validator = schema.newValidator();
        validator.setErrorHandler(new XmlErrorHandler());
        return validator;
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
            // Log all validation messages
            for (ValidationMessage errorMsg : validationMessages) {
                log.debug("Validation error: {}", errorMsg);
            }
            StringBuilder errors = new StringBuilder();

            Set<ValidationMessageWrapper> validationMessageWrappers = new HashSet<>();

            // We use ValidationMessageWrapperBuilder to populate the set of validationMessageWrappers using the
            // .build() method, which will infer the type of the error based on the path of the error message.
            for (ValidationMessage validationMessage : validationMessages) {
                validationMessageWrappers.add(new ValidationMessageWrapperBuilder(validationMessage).build());
            }

            boolean containsAtLeastOneUseCaseError = false;
            boolean violatesOneOfConstraint = false;

            for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("CONTENT") || validationMessageWrapper.getType().equals("MISC")).collect(java.util.stream.Collectors.toSet())) {
                String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                if (error != null) {
                    if (!violatesOneOfConstraint && validationMessage.getValidationMessage().getType().equals("oneOf")) {
                        violatesOneOfConstraint = true;
                    }
                    if (!containsAtLeastOneUseCaseError && validationMessage.getValidationMessage().getPath().contains(".message")) {
                        containsAtLeastOneUseCaseError = true;
                    }
                }
            }

            // Append a special error message if the error string does not contain a single "use case" error and
            // the there is no 'oneOf' constraint violation
            if (!containsAtLeastOneUseCaseError && !violatesOneOfConstraint && validationMessageWrappers.stream().anyMatch(validationMessageWrapper -> validationMessageWrapper.getType().equals("MISSING_CONTENT")) && validationMessageWrappers.stream().noneMatch(validationMessageWrapper -> validationMessageWrapper.getType().equals("ERROR"))) {
                errors.append("Could not detect any schemas in the message, at least one is required \n");
            }

            // Append envelope error messages
            if (validationMessageWrappers.stream().anyMatch(e -> e.getType().equals("EDXL-DE"))) {
                errors.append("Issues found on the envelope: \n");
                for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("EDXL-DE")).collect(java.util.stream.Collectors.toSet())) {
                    String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                    if (error != null) {
                        errors.append(" - " + error).append("\n");
                    }
                }
            }

            // Append ERROR error messages
            if (validationMessageWrappers.stream().anyMatch(e -> e.getType().equals("ERROR"))) {
                errors.append("Issues found on the $.content[0].jsonContent.embeddedJsonContent.message: \n");
                for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("EDXL-DE") || validationMessageWrapper.getType().equals("ERROR")).collect(java.util.stream.Collectors.toSet())) {
                    String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                    if (error != null) {
                        errors.append(" - " + error).append("\n");
                    }
                }
            }

            // If any ERROR errors are present, we do not append the RC-DE validation messages
            if (validationMessageWrappers.stream().noneMatch(validationMessageWrapper -> validationMessageWrapper.getType().equals("ERROR")) && validationMessageWrappers.stream().anyMatch(e -> e.getType().equals("RC-DE"))) {
                errors.append("Issues found on the $.content[0].jsonContent.embeddedJsonContent.message header: \n");
                for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("RC-DE")).collect(java.util.stream.Collectors.toSet())) {
                    String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                    if (error != null) {
                        errors.append(" - " + error).append("\n");
                    }
                }
            }

            // Append CONTENT error messages
            if (validationMessageWrappers.stream().anyMatch(e -> e.getType().equals("CONTENT"))) {
                errors.append("Issues found on the $.content[0].jsonContent.embeddedJsonContent.message content: \n");
                for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("CONTENT")).collect(java.util.stream.Collectors.toSet())) {
                    String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                    if (error != null) {
                        errors.append(" - " + error).append("\n");
                    }
                }
            }

            // Append MISC error messages
            if (validationMessageWrappers.stream().anyMatch(e -> e.getType().equals("MISC"))) {
                for (ValidationMessageWrapper validationMessage : validationMessageWrappers.stream().filter(validationMessageWrapper -> validationMessageWrapper.getType().equals("MISC")).collect(java.util.stream.Collectors.toSet())) {
                    String error = formatValidationErrorMessage(validationMessage.getValidationMessage());
                    if (error != null) {
                        errors.append(error).append("\n");
                    }
                }
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
            // the error message is either irrelevant and we ignore it or it is an error in the RC-DE header.
            // In the latter case, we return the error message (starting after the ...message), and to verify
            // if that's the case, we check if the error contains any of the attributes of the class
            // DistributionElement.
            Field[] attributes = DistributionElement.class.getDeclaredFields();
            for (Field attribute : attributes) {
                String substring = errorMsg.getMessage().substring(errorMsg.getMessage().indexOf("message") + 8);
                if (substring.contains(attribute.getName())) {
                    return substring;
                }
            }
            return null;
        } else {
            // Otherwise, we return the part of error message that comes after the 'message' element
            return errorMsg.getMessage().substring(errorMsg.getMessage().indexOf("message") + 8);
        }
    }
}
