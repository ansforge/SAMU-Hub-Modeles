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
package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.emsi.EmsiWrapper;
import com.hubsante.model.geolocation.*;
import com.hubsante.model.health.CreateCaseHealth;
import com.hubsante.model.health.CreateCaseHealthUpdate;
import com.hubsante.model.health.CreateCaseHealthUpdateWrapper;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.reference.Reference;
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.report.ErrorWrapper;
import com.hubsante.model.resources.info.ResourcesInfo;
import com.hubsante.model.resources.info.ResourcesInfoWrapper;
import com.hubsante.model.resources.request.ResourcesRequest;
import com.hubsante.model.resources.request.ResourcesRequestWrapper;
import com.hubsante.model.resources.response.ResourcesResponse;
import com.hubsante.model.resources.response.ResourcesResponseWrapper;
import com.hubsante.model.resources.status.ResourcesStatus;
import com.hubsante.model.resources.status.ResourcesStatusWrapper;
import com.hubsante.model.rpis.Rpis;
import com.hubsante.model.rpis.RpisWrapper;
import com.hubsante.model.technical.TechnicalWrapper;
import com.hubsante.model.technical.noreq.TechnicalNoreqWrapper;
import com.hubsante.model.documentlink.DocumentLinkWrapper;
import com.hubsante.model.resources.info.ResourcesEngagementWrapper;
import com.hubsante.model.interventionreport.InterventionReportWrapper;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseWrapper.class),
        @JsonSubTypes.Type(CreateCaseHealthWrapper.class),
        @JsonSubTypes.Type(CreateCaseHealthUpdateWrapper.class),
        @JsonSubTypes.Type(ReferenceWrapper.class),
        @JsonSubTypes.Type(ErrorWrapper.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EmsiWrapper.class),
        @JsonSubTypes.Type(GeoPositionsUpdateWrapper.class),
        @JsonSubTypes.Type(GeoResourcesRequestWrapper.class),
        @JsonSubTypes.Type(GeoResourcesDetailsWrapper.class),
        @JsonSubTypes.Type(ResourcesInfoWrapper.class),
        @JsonSubTypes.Type(ResourcesRequestWrapper.class),
        @JsonSubTypes.Type(ResourcesResponseWrapper.class),
        @JsonSubTypes.Type(ResourcesStatusWrapper.class),
        @JsonSubTypes.Type(RpisWrapper.class),
        @JsonSubTypes.Type(TechnicalWrapper.class),
        @JsonSubTypes.Type(TechnicalNoreqWrapper.class),
        @JsonSubTypes.Type(DocumentLinkWrapper.class),
        @JsonSubTypes.Type(ResourcesEngagementWrapper.class),
        @JsonSubTypes.Type(InterventionReportWrapper.class),
})
public class ContentMessage {

    /** This equals override is used to avoid breaking the equals override in the messages without RC-DE headers
     * (in particular ErrorWrapper), as without the override the equality check would only pass when comparing
     * an object to itself, and we care about the actual values.
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    // As this class has no fields, the hashcode is always 0
    @Override
    public int hashCode() {
        return 0;
    }

    public static class UseCaseHelper {
        public static final Map<String,String> useCases = Stream.of(new String[][] {
                {"createCase", CreateCase.class.getCanonicalName()},
                {"createCaseHealth", CreateCaseHealth.class.getCanonicalName()},
                {"createCaseHealthUpdate", CreateCaseHealthUpdate.class.getCanonicalName()},
                {"reference", Reference.class.getCanonicalName()},
                {"error", ErrorWrapper.class.getCanonicalName()},
                {"emsi", Emsi.class.getCanonicalName()},
                {"geoPositionsUpdate", GeoPositionsUpdate.class.getCanonicalName()},
                {"geoResourcesRequest", GeoResourcesRequest.class.getCanonicalName()},
                {"geoResourcesDetails", GeoResourcesDetails.class.getCanonicalName()},
                {"resourcesInfo", ResourcesInfo.class.getCanonicalName()},
                {"resourcesRequest", ResourcesRequest.class.getCanonicalName()},
                {"resourcesResponse", ResourcesResponse.class.getCanonicalName()},
                {"resourcesStatus", ResourcesStatus.class.getCanonicalName()},
                {"rpis", Rpis.class.getCanonicalName()}
        }).collect(Collectors.toMap(useCaseData -> useCaseData[0], useCaseData -> useCaseData[1]));
    }
}
