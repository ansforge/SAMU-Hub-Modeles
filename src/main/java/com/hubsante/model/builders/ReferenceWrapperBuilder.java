package com.hubsante.model.builders;

import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.ReferenceWrapper;
import com.hubsante.model.cisu.Reference;

public class ReferenceWrapperBuilder {
    private RCDE rcde;
    private Reference reference;

    public ReferenceWrapperBuilder(RCDE rcde, String referencedDistributionId) {
        this.rcde = rcde;
        this.reference = new Reference().distributionID(referencedDistributionId);
    }

    public ReferenceWrapper build() {
        ReferenceWrapper referenceMessage = new ReferenceWrapper();
        referenceMessage.setMessageId(rcde.getMessageId());
        referenceMessage.setSender(rcde.getSender());
        referenceMessage.setSentAt(rcde.getSentAt());
        if (!rcde.getKind().equals(RCDE.KindEnum.ACK)) {
            throw new IllegalArgumentException("RC_REF must be of kind ACK");
        }
        referenceMessage.setKind(rcde.getKind());
        referenceMessage.setStatus(rcde.getStatus());
        referenceMessage.setRecipients(rcde.getRecipients());
        referenceMessage.setReference(reference);
        return referenceMessage;
    }
}
