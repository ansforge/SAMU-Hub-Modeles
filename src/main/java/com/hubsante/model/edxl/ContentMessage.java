/**
 * Copyright © 2023 Agence du Numerique en Sante (ANS)
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
import com.hubsante.model.report.ErrorReport;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseWrapper.class),
        @JsonSubTypes.Type(ReferenceWrapper.class),
        @JsonSubTypes.Type(ErrorReport.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EmsiWrapper.class)
})
public class ContentMessage {
}
