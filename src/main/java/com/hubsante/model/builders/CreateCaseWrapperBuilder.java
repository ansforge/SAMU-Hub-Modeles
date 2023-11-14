package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.DistributionElement;
import com.hubsante.model.cisu.CreateCaseWrapper;

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
        createCaseMessage.setRecipients(distributionElement.getRecipients());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
