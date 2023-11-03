package com.hubsante.model.builders;

import com.hubsante.model.cisu.DistributionElement;
import com.hubsante.model.cisu.Reference;
import com.hubsante.model.cisu.ReferenceMessage;

public class RC_REF_Builder {
    private DistributionElement distributionElement;
    private Reference reference;

    public RC_REF_Builder(DistributionElement distributionElement, String referencedDistributionId) {
        this.distributionElement = distributionElement;
        this.reference = new Reference().distributionID(referencedDistributionId);
    }

    public ReferenceMessage build() {
        ReferenceMessage referenceMessage = new ReferenceMessage();
        referenceMessage.setMessageId(distributionElement.getMessageId());
        referenceMessage.setSender(distributionElement.getSender());
        referenceMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.ACK)) {
            throw new IllegalArgumentException("RC_REF must be of kind ACK");
        }
        referenceMessage.setKind(distributionElement.getKind());
        referenceMessage.setStatus(distributionElement.getStatus());
        referenceMessage.setRecipients(distributionElement.getRecipients());
        referenceMessage.setReference(reference);
        return referenceMessage;
    }
}
