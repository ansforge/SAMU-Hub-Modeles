package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hubsante.model.custom.CustomMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.EMSI;
import com.hubsante.model.report.ErrorReport;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(RCEDA.class),
        @JsonSubTypes.Type(RCREF.class),
        @JsonSubTypes.Type(ErrorReport.class),
        @JsonSubTypes.Type(CustomMessage.class),
        @JsonSubTypes.Type(EMSI.class)
})
public class ContentMessage {
}
