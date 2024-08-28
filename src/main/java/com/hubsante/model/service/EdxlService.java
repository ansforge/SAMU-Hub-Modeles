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
package com.hubsante.model.service;

import com.hubsante.model.service.handlers.EdxlHandler;
import com.hubsante.modelsinterface.edxl.EdxlMessage;
import com.hubsante.modelsinterface.exception.ValidationException;
import com.hubsante.modelsinterface.interfaces.EdxlServiceInterface;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static com.hubsante.modelsinterface.config.Constants.ENVELOPE_SCHEMA;
import static com.hubsante.modelsinterface.config.Constants.ENVELOPE_XSD;

@Slf4j
public class EdxlService implements EdxlServiceInterface {

    private Validator validator;
    private EdxlHandler edxlHandler;

    @Override
    public String getDistributionIDFromEdxlMessage(String s) throws ValidationException, IOException {
            if (isJson(s)) {
                validator.validateJSON(s, ENVELOPE_SCHEMA);
                return edxlHandler.deserializeJsonEDXLEnvelope(s).getDistributionID();
            } else {
                validator.validateXML(s, ENVELOPE_XSD);
                return edxlHandler.deserializeXmlEDXLEnvelope(s).getDistributionID();
            }
    }

    private boolean isJson(String message) {
        if (message.startsWith("{") || message.startsWith("[")) {
            return true;
        } else return false;
    }

    @Override
    public String getDescriptorExplicitAddressValue(EdxlMessage edxlMessage) {
        return ((EdxlMessage) edxlMessage).getDescriptor().getExplicitAddress().getExplicitAddressValue();
    }

    @Override
    public String getDescriptorLanguage(EdxlMessage edxlMessageInterface) {
        return "";
    }

    @Override
    public String getDescriptorExplicitAddressScheme(EdxlMessage edxlMessageInterface) {
        return "";
    }
}
