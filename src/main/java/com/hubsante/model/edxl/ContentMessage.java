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
import com.hubsante.model.common.ReferenceWrapper;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.EmsiWrapper;
import com.hubsante.model.geolocalisation.positionUpdate.PositionUpdateWrapper;
import com.hubsante.model.geolocalisation.resource.ResourceWrapper;
import com.hubsante.model.geolocalisation.resourceDetails.ResourceDetailsWrapper;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.report.ErrorWrapper;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseWrapper.class),
        @JsonSubTypes.Type(CreateCaseHealthWrapper.class),
        @JsonSubTypes.Type(ReferenceWrapper.class),
        @JsonSubTypes.Type(ErrorWrapper.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EmsiWrapper.class),
        @JsonSubTypes.Type(PositionUpdateWrapper.class),
        @JsonSubTypes.Type(ResourceWrapper.class),
        @JsonSubTypes.Type(ResourceDetailsWrapper.class)
})
public class ContentMessage {
}
