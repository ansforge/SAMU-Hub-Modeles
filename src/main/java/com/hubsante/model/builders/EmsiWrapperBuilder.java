package com.hubsante.model.builders;

import com.hubsante.model.common.DistributionElement;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.emsi.EmsiWrapper;

public class EmsiWrapperBuilder {
    private DistributionElement distributionElement;
    private Emsi emsi;

    public EmsiWrapperBuilder(DistributionElement distributionElement, Emsi emsi) {
        this.distributionElement = distributionElement;
        this.emsi = emsi;
    }

    public EmsiWrapper build() {
        EmsiWrapper emsiWrapper = new EmsiWrapper();
        emsiWrapper.setMessageId(distributionElement.getMessageId());
        emsiWrapper.setSender(distributionElement.getSender());
        emsiWrapper.setSentAt(distributionElement.getSentAt());
        if (!distributionElement.getKind().equals(DistributionElement.KindEnum.REPORT)) {
            throw new IllegalArgumentException("CreateCaseWrapper must be of kind REPORT");
        }
        emsiWrapper.setKind(distributionElement.getKind());
        emsiWrapper.setStatus(distributionElement.getStatus());
        emsiWrapper.setRecipients(distributionElement.getRecipients());
        emsiWrapper.setEmsi(emsi);
        return emsiWrapper;
    }
}
