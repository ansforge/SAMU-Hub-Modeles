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
import com.hubsante.model.reference.ReferenceWrapper;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.EmsiWrapper;
import com.hubsante.model.geolocation.GeoResourceDetailsWrapper;
import com.hubsante.model.geolocation.GeoPositionUpdateWrapper;
import com.hubsante.model.geolocation.GeoResourceRequestWrapper;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.error.ErrorWrapper;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseWrapper.class),
        @JsonSubTypes.Type(CreateCaseHealthWrapper.class),
        @JsonSubTypes.Type(ReferenceWrapper.class),
        @JsonSubTypes.Type(ErrorWrapper.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EmsiWrapper.class),
        @JsonSubTypes.Type(GeoPositionUpdateWrapper.class),
        @JsonSubTypes.Type(GeoResourceRequestWrapper.class),
        @JsonSubTypes.Type(GeoResourceDetailsWrapper.class)
})
public class ContentMessage {

    /** This equals override is used to avoid breaking the equals override in the messages without RC-DE
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
