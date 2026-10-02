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
package com.hubsante.model.builders;

import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.ValidationMessageWrapper;
import com.networknt.schema.ValidationMessage;

import java.lang.reflect.Field;

public class ValidationMessageWrapperBuilder {

    private final ValidationMessage validationMessage;

    public ValidationMessageWrapperBuilder(ValidationMessage validationMessage) {
        this.validationMessage = validationMessage;
    }

    public ValidationMessageWrapper build() {
        ValidationMessageWrapper validationMessageWrapper = new ValidationMessageWrapper();
        validationMessageWrapper.setValidationMessage(validationMessage);
        validationMessageWrapper.setType(this.inferType());
        return validationMessageWrapper;
    }

    private String inferType() {
        String[] splitPath = this.validationMessage.getPath().split("\\.");
        Field[] rcdeAttributes = DistributionElement.class.getDeclaredFields();

        // If the error is not inside 'content' (i.e. path[1] != 'content'), then it cannot be anything other
        // than an EDXL-DE error.
        if (splitPath.length == 1 || !splitPath[1].contains("content")) {
            return "EDXL-DE";
        } else if (this.validationMessage.getPath().contains("embeddedJsonContent.message.error")) {
            return "ERROR";
        } else if (this.validationMessage.getPath().startsWith("$.content[0].jsonContent.embeddedJsonContent.message")) {
            String substring = validationMessage.getMessage().substring(validationMessage.getMessage().indexOf("message") + 8);
            for (Field attribute : rcdeAttributes) {
                if (substring.contains(attribute.getName())) {
                    return "RC-DE";
                }
            }
            // If the error is inside the actual 'content' of the message then it's a CONTENT error
            if (splitPath.length >= 6)
                return "CONTENT";
            // And if the error is neither an RC-DE error nor CONTENT error but is a 'required' error, then it's a MISSING_CONTENT error
            if (validationMessage.getType().equals("required")) {
                return "MISSING_CONTENT";
            }
        }
        return "MISC";
    }

}
