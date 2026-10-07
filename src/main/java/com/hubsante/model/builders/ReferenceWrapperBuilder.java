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
import com.hubsante.model.reference.Reference;
import com.hubsante.model.reference.ReferenceWrapper;

public class ReferenceWrapperBuilder {
    private DistributionElement distributionElement;
    private Reference reference;

    public ReferenceWrapperBuilder(DistributionElement distributionElement, String referencedDistributionId) {
        this.distributionElement = distributionElement;
        this.reference = new Reference().distributionID(referencedDistributionId);
    }

    public ReferenceWrapperBuilder refused(boolean refused) {
        this.reference.setRefused(refused);
        return this;
    }

    public ReferenceWrapperBuilder infoDistributionID(String infoDistributionID) {
        this.reference.setErrorDistributionID(infoDistributionID);
        return this;
    }

    public ReferenceWrapper build() {
        ReferenceWrapper referenceMessage = new ReferenceWrapper();
        referenceMessage.setMessageId(distributionElement.getMessageId());
        referenceMessage.setSender(distributionElement.getSender());
        referenceMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.ACK)) {
            throw new IllegalArgumentException("ReferenceWrapper must be of kind ACK");
        }
        referenceMessage.setKind(distributionElement.getKind());
        referenceMessage.setStatus(distributionElement.getStatus());
        referenceMessage.setRecipient(distributionElement.getRecipient());
        // Check if reference.refused is not null and set to true, if it is check if reference.infoDistributionID
        // is set, otherwise throw an IllegalArgumentException
        if (this.reference.getRefused() != null && this.reference.getRefused() && this.reference.getErrorDistributionID() == null) {
            throw new IllegalArgumentException("ReferenceWrapper must have infoDistributionID set when refused is true");
        }

        referenceMessage.setReference(reference);
        return referenceMessage;
    }
}
