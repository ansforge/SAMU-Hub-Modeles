package com.hubsante.model.builders;

import com.hubsante.model.cisu.CreateCase;
import com.hubsante.model.cisu.RCDE;
import com.hubsante.model.cisu.RCEDA;

public class RC_EDA_Builder {

    private RCDE rcde;
    private CreateCase createCase;
    public RC_EDA_Builder(RCDE rcde, CreateCase createCase) {
        this.rcde = rcde;
        this.createCase = createCase;
    }

    public RCEDA build() {
        RCEDA createCaseMessage = new RCEDA();
        createCaseMessage.setMessageId(rcde.getMessageId());
        createCaseMessage.setSender(rcde.getSender());
        createCaseMessage.setSentAt(rcde.getSentAt());
        if (!rcde.getKind().equals(RCDE.KindEnum.REPORT)) {
            throw new IllegalArgumentException("RC_EDA must be of kind REPORT");
        }
        createCaseMessage.setKind(rcde.getKind());
        createCaseMessage.setStatus(rcde.getStatus());
        createCaseMessage.setRecipients(rcde.getRecipients());
        createCaseMessage.setCreateCase(createCase);
        return createCaseMessage;
    }
}
