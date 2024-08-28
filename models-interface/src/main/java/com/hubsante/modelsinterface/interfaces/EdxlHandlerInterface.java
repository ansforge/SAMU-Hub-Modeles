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
package com.hubsante.modelsinterface.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hubsante.modelsinterface.edxl.EdxlMessage;
import com.hubsante.modelsinterface.report.ErrorWrapper;

public interface EdxlHandlerInterface {

    EdxlMessage deserializeJsonEDXL(String jsonEDXL) throws JsonProcessingException;

    String serializeXmlEDXL(EdxlMessage errorEdxlMessage) throws JsonProcessingException;

    String serializeJsonEDXL(EdxlMessage errorEdxlMessage) throws JsonProcessingException;

    EdxlMessage deserializeXmlEDXL(String receivedEdxl) throws JsonProcessingException;

    EdxlEnvelopeInterface deserializeJsonEDXLEnvelope(String receivedEdxl) throws JsonProcessingException;

    EdxlEnvelopeInterface deserializeXmlEDXLEnvelope(String receivedEdxl) throws JsonProcessingException;
    
    ErrorWrapper getFirstContentMessageErrorWrapperFromXml(String msgString) throws JsonProcessingException;
    
    ErrorWrapper getFirstContentMessageErrorWrapperFromJson(String msgString) throws JsonProcessingException;
}
