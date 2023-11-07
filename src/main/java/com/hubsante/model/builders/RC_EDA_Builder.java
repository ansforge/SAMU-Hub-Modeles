package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCEDA;

public class RC_EDA_Builder {

    private RCDE distributionElement;
    private CreateCase createCase;
    public RC_EDA_Builder(RCDE distributionElement, CreateCase createCase) {
        this.distributionElement = distributionElement;
        this.createCase = createCase;
    }

    public RCEDA build() {
        RCEDA createCaseMessage = new RCEDA();
        createCaseMessage.setMessageId(distributionElement.getMessageId());
        createCaseMessage.setSender(distributionElement.getSender());
        createCaseMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(RCDE.KindEnum.REPORT)) {
            throw new IllegalArgumentException("RC_EDA must be of kind REPORT");
        }
        createCaseMessage.setKind(distributionElement.getKind());
        createCaseMessage.setStatus(distributionElement.getStatus());
        createCaseMessage.setRecipients(distributionElement.getRecipients());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
