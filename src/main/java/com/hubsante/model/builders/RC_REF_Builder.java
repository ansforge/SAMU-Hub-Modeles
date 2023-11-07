package com.hubsante.model.builders;

import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCREF;
import com.hubsante.model.cisu.Reference;

public class RC_REF_Builder {
    private RCDE distributionElement;
    private Reference reference;

    public RC_REF_Builder(RCDE distributionElement, String referencedDistributionId) {
        this.distributionElement = distributionElement;
        this.reference = new Reference().distributionID(referencedDistributionId);
    }

    public RCREF build() {
        RCREF referenceMessage = new RCREF();
        referenceMessage.setMessageId(distributionElement.getMessageId());
        referenceMessage.setSender(distributionElement.getSender());
        referenceMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(RCDE.KindEnum.ACK)) {
            throw new IllegalArgumentException("RC_REF must be of kind ACK");
        }
        referenceMessage.setKind(distributionElement.getKind());
        referenceMessage.setStatus(distributionElement.getStatus());
        referenceMessage.setRecipients(distributionElement.getRecipients());
        referenceMessage.setReference(reference);
        return referenceMessage;
    }
}
