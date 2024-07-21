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

}
