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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.documentlink.DocumentLinkWrapper;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.edxl.EdxlMessage;
import com.hubsante.model.emsi.EmsiWrapper;
import com.hubsante.model.geolocation.GeoPositionsUpdateWrapper;
import com.hubsante.model.geolocation.GeoResourcesDetailsWrapper;
import com.hubsante.model.geolocation.GeoResourcesRequestWrapper;
import com.hubsante.model.health.CreateCaseHealthUpdateWrapper;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.interventionreport.InterventionReportWrapper;
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.report.ErrorWrapper;
import com.hubsante.model.resources.info.ResourcesEngagementWrapper;
import com.hubsante.model.resources.info.ResourcesInfoWrapper;
import com.hubsante.model.resources.request.ResourcesRequestWrapper;
import com.hubsante.model.resources.response.ResourcesResponseWrapper;
import com.hubsante.model.resources.status.ResourcesStatusWrapper;
import com.hubsante.model.rpis.RpisWrapper;
import com.hubsante.model.technical.TechnicalWrapper;
import com.hubsante.model.technical.noreq.TechnicalNoreqWrapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContentMessageDeserializer extends JsonDeserializer<ContentMessage> {

    private static final Map<String, Class> useCases = new HashMap<String, Class>() {{
        put("createCase", CreateCaseWrapper.class);
        put("createCaseHealth", CreateCaseHealthWrapper.class);
        put("createCaseHealthUpdate", CreateCaseHealthUpdateWrapper.class);
        put("reference", ReferenceWrapper.class);
        put("error", ErrorWrapper.class);
        put("emsi", EmsiWrapper.class);
        put("geoPositionsUpdate", GeoPositionsUpdateWrapper.class);
        put("geoResourcesRequest", GeoResourcesRequestWrapper.class);
        put("geoResourcesDetails", GeoResourcesDetailsWrapper.class);
        put("resourcesInfo", ResourcesInfoWrapper.class);
        put("resourcesRequest", ResourcesRequestWrapper.class);
        put("resourcesResponse", ResourcesResponseWrapper.class);
        put("resourcesStatus", ResourcesStatusWrapper.class);
        put("rpis", RpisWrapper.class);
        put("technical", TechnicalWrapper.class);
        put("technicalNoreq", TechnicalNoreqWrapper.class);
        put("documentLink", DocumentLinkWrapper.class);
        put("resourcesEngagement", ResourcesEngagementWrapper.class);
        put("interventionReport", InterventionReportWrapper.class);
    }};

    @Override
    public ContentMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = jp.getCodec();
        JsonNode node = codec.readTree(jp);
        String model = null;
        try {
            model = ((EdxlMessage) jp.getParsingContext().getParent().getParent().getParent().getParent().getCurrentValue()).getOther().getModel();
        } catch (NullPointerException e) {
            throw new JsonParseException(jp, "Model not found in $.other.model");
        }
        // Find model in useCases map, throw JsonParseException if not found
        Class clazz = useCases.get(model);
        if (clazz == null) {
            throw new JsonParseException(jp, "Unknown model: " + model);
        }

        return (ContentMessage) codec.treeToValue(node, clazz);
    }
}
