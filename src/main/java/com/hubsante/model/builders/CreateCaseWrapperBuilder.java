package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.DistributionElement;
import com.hubsante.model.cisu.CreateCaseWrapper;

public class CreateCaseWrapperBuilder {

    private DistributionElement rcde;
    private CreateCase createCase;
    public CreateCaseWrapperBuilder(DistributionElement rcde, CreateCase createCase) {
        this.rcde = rcde;
        this.createCase = createCase;
    }

    public CreateCaseWrapper build() {
        CreateCaseWrapper createCaseMessage = new CreateCaseWrapper();
        createCaseMessage.setMessageId(rcde.getMessageId());
        createCaseMessage.setSender(rcde.getSender());
        createCaseMessage.setSentAt(rcde.getSentAt());
        if (!rcde.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("RC_EDA must be of kind REPORT");
        }
        createCaseMessage.setKind(rcde.getKind());
        createCaseMessage.setStatus(rcde.getStatus());
        createCaseMessage.setRecipients(rcde.getRecipients());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
