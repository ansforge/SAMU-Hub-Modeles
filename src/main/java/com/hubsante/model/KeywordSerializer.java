package com.hubsante.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hubsante.model.edxl.Keyword;

import java.io.IOException;

public class KeywordSerializer extends JsonSerializer<Keyword> {
    @Override
    public void serialize(Keyword value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("ct:ValueListURI", value.getValueListURI());
        gen.writeStringField("ct:Value", value.getValue());
        gen.writeEndObject();
    }
}
