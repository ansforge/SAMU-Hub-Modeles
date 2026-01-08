/**
 * Copyright © 2023-2026 Agence du Numerique en Sante (ANS)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hubsante.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hubsante.model.builders.EDXL_DE_Builder;
import com.hubsante.model.rcde.Recipient;
import com.hubsante.model.rcde.Sender;
import com.hubsante.model.edxl.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EdxlWrapperUtils {

    static ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);

    public static String wrapUseCaseMessage(String useCaseMessage) throws JsonProcessingException {
        JsonNode contentMessage = mapper.readTree(useCaseMessage);
        contentMessage = addDistributionElementFields(contentMessage);
        JsonNode envelope = addEnvelope(contentMessage);

        return mapper.writeValueAsString(envelope);
    }

    public static String wrapUseCaseMessageWithoutDistributionElement(String useCaseMessage) throws JsonProcessingException {
        JsonNode contentMessage = mapper.readTree(useCaseMessage);
        JsonNode envelope = addEnvelope(contentMessage);

        return mapper.writeValueAsString(envelope);
    }
    
    public static JsonNode addEnvelope(JsonNode jsonNode) {
        OffsetDateTime sentAt = OffsetDateTime.of(LocalDateTime.parse("2023-12-15T00:00:00"), ZoneOffset.ofHours(2)).truncatedTo(ChronoUnit.SECONDS);
        OffsetDateTime expiresAt = sentAt.plusDays(1);

        EdxlMessage edxlMessage = new EDXL_DE_Builder("sender_123", "sender", "recipient")
                .dateTimeSent(sentAt)
                .dateTimeExpires(expiresAt)
                .build();

        ObjectNode envelopeNode = mapper.valueToTree(edxlMessage);
        ((ObjectNode) envelopeNode.get("content").get(0).get("jsonContent").get("embeddedJsonContent")).put("message", jsonNode);
        return envelopeNode;
    }

    public static JsonNode addDistributionElementFields(JsonNode jsonNode) {
        if (jsonNode instanceof ObjectNode) {
            Sender sender = new Sender().name("sender").URI("hubex:sender");
            Recipient recipient = new Recipient().name("recipient").URI("hubex:recipient");
            List<Recipient> recipients = new ArrayList<>();
            recipients.add(recipient);

            ObjectNode objectNode = (ObjectNode) jsonNode;
            objectNode.put("messageId", "sender_123");
            objectNode.put("sender", mapper.valueToTree(sender));
            objectNode.put("sentAt", "2023-12-14T00:00:00+02:00");
            objectNode.put("kind", "Report");
            objectNode.put("status", "Actual");
            objectNode.put("recipient", mapper.valueToTree(recipients));
        }
        return jsonNode;
    }
}
