package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hubsante.model.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.Emsi;
import com.hubsante.model.report.ErrorReport;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseMessage.class),
        @JsonSubTypes.Type(GenericAckMessage.class),
        @JsonSubTypes.Type(Emsi.class),
        @JsonSubTypes.Type(ErrorReport.class),
        @JsonSubTypes.Type(CustomMessage.class)
})
public class UseCaseMessage {
}
