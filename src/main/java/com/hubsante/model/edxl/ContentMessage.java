package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.report.ErrorReport;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(RCEDA.class),
        @JsonSubTypes.Type(RCDE.class),
        @JsonSubTypes.Type(ErrorReport.class),
        @JsonSubTypes.Type(CustomMessage.class)
})
public class ContentMessage {
}
