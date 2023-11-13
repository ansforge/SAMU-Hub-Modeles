package com.hubsante.model.builders;

import com.hubsante.model.cisu.DistributionElement;
import com.hubsante.model.cisu.ReferenceWrapper;
import com.hubsante.model.cisu.Reference;

public class ReferenceWrapperBuilder {
    private DistributionElement distributionElement;
    private Reference reference;

    public ReferenceWrapperBuilder(DistributionElement distributionElement, String referencedDistributionId) {
        this.distributionElement = distributionElement;
        this.reference = new Reference().distributionID(referencedDistributionId);
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
        referenceMessage.setRecipients(distributionElement.getRecipients());
        referenceMessage.setReference(reference);
        return referenceMessage;
    }
}
