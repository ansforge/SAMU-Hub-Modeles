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
import com.hubsante.model.geolocation.GeoPositionsUpdateWrapper;
import com.hubsante.model.geolocation.GeoResourcesDetailsWrapper;
import com.hubsante.model.geolocation.GeoResourcesRequestWrapper;
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.EmsiWrapper;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.report.ErrorWrapper;
import com.hubsante.model.resources.ResourcesInfo;
import com.hubsante.model.resources.ResourcesRequest;
import com.hubsante.model.resources.ResourcesResponse;
import com.hubsante.model.rpis.Rpis;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseWrapper.class),
        @JsonSubTypes.Type(CreateCaseHealthWrapper.class),
        @JsonSubTypes.Type(ReferenceWrapper.class),
        @JsonSubTypes.Type(ErrorWrapper.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EmsiWrapper.class),
        @JsonSubTypes.Type(GeoPositionsUpdateWrapper.class),
        @JsonSubTypes.Type(GeoResourcesRequestWrapper.class),
        @JsonSubTypes.Type(GeoResourcesDetailsWrapper.class),
        @JsonSubTypes.Type(ResourcesInfo.class),
        @JsonSubTypes.Type(ResourcesRequest.class),
        @JsonSubTypes.Type(ResourcesResponse.class),
        @JsonSubTypes.Type(Rpis.class),
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
}
