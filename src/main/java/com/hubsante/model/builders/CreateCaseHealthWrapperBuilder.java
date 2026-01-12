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

import com.hubsante.model.health.CreateCaseHealth;
import com.hubsante.model.health.CreateCaseHealthWrapper;
import com.hubsante.model.rcde.DistributionElement;

public class CreateCaseHealthWrapperBuilder {

    private DistributionElement distributionElement;
    private CreateCaseHealth createCaseHealth;

    public CreateCaseHealthWrapperBuilder(DistributionElement distributionElement, CreateCaseHealth createCaseHealth) {
        this.distributionElement = distributionElement;
        this.createCaseHealth = createCaseHealth;
    }
    
    public CreateCaseHealthWrapper build() {
        CreateCaseHealthWrapper createCaseHealthMessage = new CreateCaseHealthWrapper();
        createCaseHealthMessage.setMessageId(distributionElement.getMessageId());
        createCaseHealthMessage.setSender(distributionElement.getSender());
        createCaseHealthMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("CreateCaseWrapper must be of kind REPORT");
        }
        createCaseHealthMessage.setKind(distributionElement.getKind());
        createCaseHealthMessage.setStatus(distributionElement.getStatus());
        createCaseHealthMessage.setRecipient(distributionElement.getRecipient());
        createCaseHealthMessage.setCreateCaseHealth(createCaseHealth);
        return createCaseHealthMessage;
    }
}
