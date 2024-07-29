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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.edxl.EdxlEnvelope;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.geolocation.GeoPositionsUpdate;
import com.hubsante.model.geolocation.GeoResourcesDetails;
import com.hubsante.model.geolocation.GeoResourcesRequest;
import com.hubsante.model.health.CreateCaseHealth;
import com.hubsante.model.health.update.CreateCaseHealthUpdate;
import com.hubsante.model.reference.Reference;
import com.hubsante.model.report.ErrorWrapper;
import com.hubsante.model.resources.info.ResourcesInfo;
import com.hubsante.model.resources.request.ResourcesRequest;
import com.hubsante.model.resources.response.ResourcesResponse;
import com.hubsante.model.resources.status.ResourcesStatus;
import com.hubsante.model.rpis.Rpis;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class EdxlHandler {

    public XmlMapper xmlMapper;

    public ObjectMapper jsonMapper;

    public final Map<String,String> useCases = Stream.of(new String[][] {
            {"emsi", Emsi.class.getCanonicalName()},
            {"geoPositionsUpdate", GeoPositionsUpdate.class.getCanonicalName()},
            {"geoResourcesRequest", GeoResourcesRequest.class.getCanonicalName()},
            {"geoResourcesDetails", GeoResourcesDetails.class.getCanonicalName()},
            {"createCase", CreateCase.class.getCanonicalName()},
            {"reference", Reference.class.getCanonicalName()},
            {"rpis", Rpis.class.getCanonicalName()},
            {"resourcesRequest", ResourcesRequest.class.getCanonicalName()},
            {"createCaseHealth", CreateCaseHealth.class.getCanonicalName()},
            {"createCaseHealthUpdate", CreateCaseHealthUpdate.class.getCanonicalName()},
            {"error", ErrorWrapper.class.getCanonicalName()},
            {"resourcesInfo", ResourcesInfo.class.getCanonicalName()},
            {"resourcesResponse", ResourcesResponse.class.getCanonicalName()},
            {"resourcesStatus", ResourcesStatus.class.getCanonicalName()}
    }).collect(Collectors.toMap(useCaseData -> useCaseData[0], useCaseData -> useCaseData[1]));

    public EdxlHandler() {
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

    public EdxlMessage deserializeJsonEDXL(String json) throws JsonProcessingException {
        return jsonMapper.readValue(json, EdxlMessage.class);
    }

    public EdxlEnvelope deserializeJsonEDXLEnvelope(String json) throws JsonProcessingException {
        return jsonMapper.readValue(json, EdxlEnvelope.class);
    }

    public EdxlMessage deserializeXmlEDXL(String xml) throws JsonProcessingException {
        return xmlMapper.readValue(xml, EdxlMessage.class);
    }

    public EdxlEnvelope deserializeXmlEDXLEnvelope(String xml) throws JsonProcessingException {
        return xmlMapper.readValue(xml, EdxlEnvelope.class);
    }

    public String serializeJsonEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(edxlMessage);
    }

    public String serializeXmlEDXL(EdxlMessage edxlMessage) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(edxlMessage);
    }
}
