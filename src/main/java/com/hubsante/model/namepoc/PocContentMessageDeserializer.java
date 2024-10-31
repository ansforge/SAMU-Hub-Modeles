package com.hubsante.model.namepoc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class PocContentMessageDeserializer extends JsonDeserializer<PocContentMessage> {

    @Override
    public PocContentMessage deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectCodec codec = jp.getCodec();

        JsonNode node = codec.readTree(jp);

        PocEdxlMessage bruh = (PocEdxlMessage) jp.getParsingContext().getParent().getParent().getParent().getParent().getCurrentValue();
        String model = ((PocEdxlMessage) jp.getParsingContext().getParent().getParent().getParent().getParent().getCurrentValue()).getOther().getModel();

        switch (model) {
            case "cat":
                return codec.treeToValue(node, CatWrapper.class);
            case "horse":
                return codec.treeToValue(node, HorseWrapper.class);
            default:
                throw new JsonMappingException(jp,
                        "Unknown model: " + model);
        }
    }
}
