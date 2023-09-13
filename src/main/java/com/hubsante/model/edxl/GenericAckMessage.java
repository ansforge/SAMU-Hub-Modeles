package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.hubsante.model.cisu.DistributionElement;

@JsonRootName(value = "message")
public class GenericAckMessage extends DistributionElement {

    @JsonProperty(value = "ackDistributionId", required = true)
    private String ackDistributionId;

    public String getAckDistributionId() {
        return ackDistributionId;
    }

    public void setAckDistributionId(String ackDistributionId) {
        this.ackDistributionId = ackDistributionId;
    }

    public GenericAckMessage() {
    }

    public GenericAckMessage(String ackDistributionId) {
        this.ackDistributionId = ackDistributionId;
    }
}
