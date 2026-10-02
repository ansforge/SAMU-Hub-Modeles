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
package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.CreateCaseWrapper;
import com.hubsante.model.rcde.DistributionElement;

public class CreateCaseWrapperBuilder {

    private DistributionElement distributionElement;
    private CreateCase createCase;
    public CreateCaseWrapperBuilder(DistributionElement distributionElement, CreateCase createCase) {
        this.distributionElement = distributionElement;
        this.createCase = createCase;
    }

    public CreateCaseWrapper build() {
        CreateCaseWrapper createCaseMessage = new CreateCaseWrapper();
        createCaseMessage.setMessageId(distributionElement.getMessageId());
        createCaseMessage.setSender(distributionElement.getSender());
        createCaseMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("CreateCaseWrapper must be of kind REPORT");
        }
        createCaseMessage.setKind(distributionElement.getKind());
        createCaseMessage.setStatus(distributionElement.getStatus());
        createCaseMessage.setRecipient(distributionElement.getRecipient());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
