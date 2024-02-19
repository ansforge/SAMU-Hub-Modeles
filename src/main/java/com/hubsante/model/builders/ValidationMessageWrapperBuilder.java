/**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model.builders;

import com.hubsante.model.common.DistributionElement;
import com.hubsante.model.common.ValidationMessageWrapper;
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
        } else if (this.validationMessage.getPath().contains("embeddedJsonContent.message.info")) {
            return "INFO";
        } else if (splitPath.length == 5) {
            String substring = validationMessage.getMessage().substring(validationMessage.getMessage().indexOf("message") + 8);
            for (Field attribute : rcdeAttributes) {
                if (substring.contains(attribute.getName())) {
                    return "RC-DE";
                }
            }
        }
        return "MISC";
    }
}
