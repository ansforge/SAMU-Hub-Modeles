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
