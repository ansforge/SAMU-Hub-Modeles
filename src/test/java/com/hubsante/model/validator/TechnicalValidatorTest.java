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
package com.hubsante.model.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.hubsante.model.config.Constants.TECHNICAL_SCHEMA;
import static com.hubsante.model.config.Constants.TECHNICAL_XSD;
import static com.hubsante.model.utils.TestFileUtils.getMessageByFileName;

public class TechnicalValidatorTest extends AbstractValidatorTest {

    @Test
    @DisplayName("Valid technical messages should pass validation")
    public void jsonTechnicalValidationPasses() throws Exception {
        validator.validateJSON(getMessageByFileName("TECHNICAL/complete.json"), TECHNICAL_SCHEMA);
        validator.validateJSON(getMessageByFileName("TECHNICAL/array-deserialization.json"), TECHNICAL_SCHEMA);
        validator.validateJSON(getMessageByFileName("TECHNICAL/nomenclature-test.json"), TECHNICAL_SCHEMA);
        validator.validateJSON(getMessageByFileName("TECHNICAL/regex-validation.json"), TECHNICAL_SCHEMA);

        validator.validateXML(getMessageByFileName("TECHNICAL/complete.xml"), TECHNICAL_XSD);
        validator.validateXML(getMessageByFileName("TECHNICAL/array-deserialization.xml"), TECHNICAL_XSD);
        validator.validateXML(getMessageByFileName("TECHNICAL/nomenclature-test.xml"), TECHNICAL_XSD);
        validator.validateXML(getMessageByFileName("TECHNICAL/regex-validation.xml"), TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with values that do not pass regex validation should not pass validation")
    public void technicalRegexValidationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.phoneNumberField: does not match the regex pattern \\+?[0-9]{2,14}",
            " - $.datetimeField: 2022-09-27 08:25:54 Z02:00 is an invalid date-time",
            " - $.datetimeField: does not match the regex pattern \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}[\\-+]\\d{2}:\\d{2}",
            " - $.dateField: does not match the regex pattern \\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])",
            " - $.emailField: does not match the regex pattern [\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}"
        };
        jsonValidationFails("TECHNICAL/doesnt-pass-regex-validation.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-pattern-valid: Value 'invalid_value' is not facet-valid with respect to pattern '\\+?[0-9]{2,14}' for type '#AnonType_phoneNumberFieldtechnical'.," +
            " cvc-type.3.1.3: The value 'invalid_value' of element 'phoneNumberField' is not valid.," +
            " cvc-pattern-valid: Value '2020 jan 1' is not facet-valid with respect to pattern '\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])' for type '#AnonType_dateFieldtechnical'.," +
            " cvc-type.3.1.3: The value '2020 jan 1' of element 'dateField' is not valid.," +
            " cvc-pattern-valid: Value 'email address@domain' is not facet-valid with respect to pattern '[\\w\\-\\.]+@([\\w\\-]+\\.)+[\\w\\-]{2,4}' for type '#AnonType_emailFieldtechnical'.," +
            " cvc-type.3.1.3: The value 'email address@domain' of element 'emailField' is not valid.," +
            " cvc-datatype-valid.1.2.1: '2022-09-27 08:25:54 Z02:00' is not a valid value for 'dateTime'.," +
            " cvc-type.3.1.3: The value '2022-09-27 08:25:54 Z02:00' of element 'datetimeField' is not valid.]"
        };
        xmlValidationFails("TECHNICAL/doesnt-pass-regex-validation.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with values or objects in places where arrays are expected should not pass validation")
    public void technicalArrayDeserializationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.enumArrayField: string found, array expected",
            " - $.arrayField: object found, array expected"
        };
        jsonValidationFails("TECHNICAL/expected-array.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        // We can't really test a string value being found instead of an array in an XML file
        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-type.3.1.2: Element 'arrayField' is a simple type, so it must have no element information item [children].," +
            " cvc-enumeration-valid: Value 'value' is not facet-valid with respect to enumeration '[ENUM_VALUE_10, ENUM_VALUE_20, ENUM_VALUE_30, ENUM_VALUE_40, ENUM_VALUE_50]'. It must be a value from the enumeration.," +
            " cvc-type.3.1.3: The value 'value' of element 'enumArrayField' is not valid.]"
        };
        xmlValidationFails("TECHNICAL/expected-array.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with values or arrays in places where objects are expected should not pass validation")
    public void technicalObjectDeserializationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.objectField: array found, object expected",
            " - $.objectLevel1: string found, object expected"
        };
        jsonValidationFails("TECHNICAL/expected-object.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-complex-type.2.4.a: Invalid content was found starting with element 'property'. " +
            "One of '{\"urn:emergency:cisu:2.0:technical\":objectPropertyString, " +
            "\"urn:emergency:cisu:2.0:technical\":objectPropertyNumber, " +
            "\"urn:emergency:cisu:2.0:technical\":objectPropertyRequiredString}' is expected., " +

            "cvc-complex-type.2.4.a: Invalid content was found starting with element 'objectField'. " +
            "One of '{\"urn:emergency:cisu:2.0:technical\":arrayField, \"urn:emergency:cisu:2.0:technical\":enumArrayField, " +
            "\"urn:emergency:cisu:2.0:technical\":requiredArray}' is expected., " +

            "cvc-complex-type.2.4.a: Invalid content was found starting with element 'property'. " +
            "One of '{\"urn:emergency:cisu:2.0:technical\":objectPropertyString, " +
            "\"urn:emergency:cisu:2.0:technical\":objectPropertyNumber, " +
            "\"urn:emergency:cisu:2.0:technical\":objectPropertyRequiredString}' is expected., " +

            "cvc-complex-type.2.3: Element 'objectLevel1' cannot have character [children], " +
            "because the type's content type is element-only.]"
        };
        xmlValidationFails("TECHNICAL/expected-object.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with objects or arrays in places where primitives are expected should not pass validation")
    public void technicalPrimitiveDeserializationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.optionalStringField: array found, string expected",
            " - $.requiredStringField: object found, string expected",
            " - $.numberField: object found, number expected"
        };
        jsonValidationFails("TECHNICAL/expected-primitive.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-type.3.1.2: Element 'requiredStringField' is a simple type, so it must have no element information item [children]., " +
            "cvc-complex-type.2.4.a: Invalid content was found starting with element 'optionalStringField'. One of '{\"urn:emergency:cisu:2.0:technical\":enumerationField, \"urn:emergency:cisu:2.0:technical\":numberField, \"urn:emergency:cisu:2.0:technical\":objectField, \"urn:emergency:cisu:2.0:technical\":arrayField, \"urn:emergency:cisu:2.0:technical\":enumArrayField, \"urn:emergency:cisu:2.0:technical\":requiredArray}' is expected., " +
            "cvc-type.3.1.2: Element 'numberField' is a simple type, so it must have no element information item [children]., " +
            "cvc-datatype-valid.1.2.1: '' is not a valid value for 'decimal'., " +
            "cvc-type.3.1.3: The value '' of element 'numberField' is not valid.]"
        };
        xmlValidationFails("TECHNICAL/expected-primitive.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages that are missing required fields should not pass validation")
    public void technicalRequiredFieldsValidationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.requiredStringField: is missing but it is required",
            " - $.requiredArray: is missing but it is required"
        };
        jsonValidationFails("TECHNICAL/missing-required-field.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        // XML validation will simply complain about encountering an unexpected element since it expects
        // to encounter fields in a specific order
        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-complex-type.2.4.a: Invalid content was found starting with element 'optionalStringField'. One of '{\"urn:emergency:cisu:2.0:technical\":requiredStringField}' is expected.]"
        };
        xmlValidationFails("TECHNICAL/missing-required-field.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with unknown enumerations should not pass validation")
    public void technicalUnknownEnumValidationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.nomenclatureField: does not have a value in the enumeration [MASC, FEM, AUTRE, INCONNU]",
            " - $.enumerationField: does not have a value in the enumeration [ENUM_VALUE_1, ENUM_VALUE_2, ENUM_VALUE_3, ENUM_VALUE_4, ENUM_VALUE_5]",
            " - $.enumArrayField[1]: does not have a value in the enumeration [ENUM_VALUE_10, ENUM_VALUE_20, ENUM_VALUE_30, ENUM_VALUE_40, ENUM_VALUE_50]"
        };
        jsonValidationFails("TECHNICAL/unknown-enum.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-enumeration-valid: Value 'ENUM_VALUE_100' is not facet-valid with respect to enumeration '[ENUM_VALUE_1, ENUM_VALUE_2, ENUM_VALUE_3, ENUM_VALUE_4, ENUM_VALUE_5]'. It must be a value from the enumeration.," +
            " cvc-type.3.1.3: The value 'ENUM_VALUE_100' of element 'enumerationField' is not valid., cvc-enumeration-valid: Value 'ENUM_VALUE_200' is not facet-valid with respect to enumeration '[ENUM_VALUE_10, ENUM_VALUE_20, ENUM_VALUE_30, ENUM_VALUE_40, ENUM_VALUE_50]'. It must be a value from the enumeration.," +
            " cvc-type.3.1.3: The value 'ENUM_VALUE_200' of element 'enumArrayField' is not valid., cvc-enumeration-valid: Value 'UNKNOWN' is not facet-valid with respect to enumeration '[MASC, FEM, AUTRE, INCONNU]'. It must be a value from the enumeration.," +
            " cvc-type.3.1.3: The value 'UNKNOWN' of element 'nomenclatureField' is not valid.]"
        };
        xmlValidationFails("TECHNICAL/unknown-enum.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with unknown fields should not pass validation")
    public void technicalUnknownFieldsValidationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.unknownField: is not defined in the schema and the schema does not allow additional properties"
        };
        jsonValidationFails("TECHNICAL/unknown-property.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        String[] expectedXmlErrors = {
            "Could not validate message against schema : errors occurred. ",
            "[cvc-complex-type.2.4.a: Invalid content was found starting with element 'unknownField'. One of '{\"urn:emergency:cisu:2.0:technical\":requiredArray, \"urn:emergency:cisu:2.0:technical\":arrayWithMaxLength, \"urn:emergency:cisu:2.0:technical\":phoneNumberField, \"urn:emergency:cisu:2.0:technical\":dateField, \"urn:emergency:cisu:2.0:technical\":emailField, \"urn:emergency:cisu:2.0:technical\":datetimeField, \"urn:emergency:cisu:2.0:technical\":objectLevel1, \"urn:emergency:cisu:2.0:technical\":nomenclatureField}' is expected.]"
        };
        xmlValidationFails("TECHNICAL/unknown-property.xml", expectedXmlErrors, TECHNICAL_XSD);
    }

    @Test
    @DisplayName("Messages with fields that are not of the expected type should not pass validation")
    public void technicalTypeValidationFails() throws IOException {
        String[] expectedJsonErrors = {
            "Could not validate message against schema : errors occurred. ",
            "Issues found on the envelope: ",
            " - $.numberField: string found, number expected",
            " - $.requiredStringField: integer found, string expected"
        };
        jsonValidationFails("TECHNICAL/wrong-type.json", expectedJsonErrors, TECHNICAL_SCHEMA);

        // XML validation will treat numbers as strings for string fields, so we only get an error for the number field
        String[] expectedXmlErrors = {
                "Could not validate message against schema : errors occurred. ",
                "[cvc-datatype-valid.1.2.1: 'string' is not a valid value for 'decimal'., cvc-type.3.1.3: The value 'string' of element 'numberField' is not valid.]"
        };
        xmlValidationFails("TECHNICAL/wrong-type.xml", expectedXmlErrors, TECHNICAL_XSD);
    }
}
