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

import com.hubsante.model.rcde.DistributionElement;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.emsi.EmsiWrapper;

public class EmsiWrapperBuilder {
    private DistributionElement distributionElement;
    private Emsi emsi;

    public EmsiWrapperBuilder(DistributionElement distributionElement, Emsi emsi) {
        this.distributionElement = distributionElement;
        this.emsi = emsi;
    }

    public EmsiWrapper build() {
        EmsiWrapper emsiWrapper = new EmsiWrapper();
        emsiWrapper.setMessageId(distributionElement.getMessageId());
        emsiWrapper.setSender(distributionElement.getSender());
        emsiWrapper.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("CreateCaseWrapper must be of kind REPORT");
        }
        emsiWrapper.setKind(distributionElement.getKind());
        emsiWrapper.setStatus(distributionElement.getStatus());
        emsiWrapper.setRecipient(distributionElement.getRecipient());
        emsiWrapper.setEmsi(emsi);
        return emsiWrapper;
    }
}
