package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.CreateCaseMessage;
import com.hubsante.model.cisu.DistributionElement;

public class RC_EDA_Builder {

    private DistributionElement distributionElement;
    private CreateCase createCase;
    public RC_EDA_Builder(DistributionElement distributionElement, CreateCase createCase) {
        this.distributionElement = distributionElement;
        this.createCase = createCase;
    }

    public CreateCaseMessage build() {
        CreateCaseMessage createCaseMessage = new CreateCaseMessage();
        createCaseMessage.setMessageId(distributionElement.getMessageId());
        createCaseMessage.setSender(distributionElement.getSender());
        createCaseMessage.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("RC_EDA must be of kind REPORT");
        }
        createCaseMessage.setKind(distributionElement.getKind());
        createCaseMessage.setStatus(distributionElement.getStatus());
        createCaseMessage.setRecipients(distributionElement.getRecipients());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
