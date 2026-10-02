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

import com.networknt.schema.ValidationMessage;

public class ValidationMessageWrapper {

    private ValidationMessage validationMessage;
    private String type;

    public ValidationMessageWrapper() {
    }

    public ValidationMessageWrapper(ValidationMessage validationMessage, String type) {
        this.validationMessage = validationMessage;
        this.type = type;
    }

    public ValidationMessage getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(ValidationMessage validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ValidationMessageWrapper that = (ValidationMessageWrapper) o;
        return this.validationMessage.equals(that.validationMessage) &&
                this.type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return this.validationMessage.hashCode() + this.type.hashCode();
    }

    @Override
    public String toString() {
        return "ValidationMessageWrapper{" +
                "validationMessage=" + validationMessage +
                ", type='" + type + '\'' +
                '}';
    }
}