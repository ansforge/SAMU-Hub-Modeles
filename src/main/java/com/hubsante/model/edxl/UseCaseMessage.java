package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.hubsante.model.GenericMessage;
import com.hubsante.model.cisu.*;
import com.hubsante.model.emsi.Emsi;

import java.util.HashMap;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(CreateCaseMessage.class),
        @JsonSubTypes.Type(GenericAckMessage.class),
        @JsonSubTypes.Type(Emsi.class),
        @JsonSubTypes.Type(GenericMessage.class)
})
public class UseCaseMessage {
}
