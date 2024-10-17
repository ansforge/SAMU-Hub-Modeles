package com.hubsante.model.namepoc; /**
 * Copyright © 2023-2024 Agence du Numerique en Sante (ANS)
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.hubsante.model.edxl.Descriptor;
import com.hubsante.model.edxl.DistributionKind;
import com.hubsante.model.edxl.DistributionStatus;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonPropertyOrder({
        "distributionID",
        "senderID",
        "dateTimeSent",
        "dateTimeExpires",
        "distributionStatus",
        "distributionKind",
        "descriptor",
        "content"})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PocEdxlMessage extends PocEdxlEnvelope {
    private List<PocContentObject> content;

    public PocEdxlMessage() {
        super();
    }

    public PocEdxlMessage(String distributionID, String senderID, OffsetDateTime dateTimeSent, OffsetDateTime dateTimeExpires,
                          DistributionStatus distributionStatus, DistributionKind distributionKind, Descriptor descriptor,
                          PocContentMessage innerMessage) {
        super(distributionID, senderID, dateTimeSent, dateTimeExpires, distributionStatus, distributionKind, descriptor);
        this.setContentFrom(innerMessage);
    }

    public PocEdxlMessage content(List<PocContentObject> content) {
        this.content = content;
        return this;
    }

    public PocEdxlMessage addPocContentObject(PocContentObject pocContentObject) {
        if (this.content == null) {
            this.content = new ArrayList<>();
        }
        this.content.add(pocContentObject);
        return this;
    }

    @JacksonXmlElementWrapper(useWrapping = true, localName = "content")
    @JsonProperty(value = "content")
    @JacksonXmlProperty(localName = "pocContentObject")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<PocContentObject> getContent() {
        return content;
    }

    @JacksonXmlElementWrapper(useWrapping = true, localName = "content")
    @JsonProperty(value = "content")
    @JacksonXmlProperty(localName = "pocContentObject")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setContent(List<PocContentObject> content) {
        this.content = content;
    }

    public <T extends PocContentMessage> void setContentFrom(T pocEmbeddedContent) {
        List<PocContentObject> pocContentObjectList = new ArrayList<>();
        pocContentObjectList.add(new PocContentObject(new PocContentWrapper(new PocEmbeddedContent(pocEmbeddedContent))));
        this.setContent(pocContentObjectList);
    }

    public PocContentMessage getFirstPocMessage() {
        return this.getContent().stream().findFirst().orElseThrow(ArrayIndexOutOfBoundsException::new)
                .getPocContentWrapper().getPocEmbeddedContent().getMessage();
    }

    public List<PocContentMessage> getAllPocMessages() {
        return this.content.stream()
                .map(pocContentObject -> ((PocContentMessage) pocContentObject.getPocContentWrapper().getPocEmbeddedContent().getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PocEdxlMessage that = (PocEdxlMessage) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }

    @Override
    public String toString() {
        return "class EdxlMessage {\n" +
                "    distributionID: " + toIndentedString(super.getDistributionID()) + "\n" +
                "    senderId: " + toIndentedString(super.getSenderID()) + "\n" +
                "    dateTimeSent: " + toIndentedString(super.getDateTimeSent()) + "\n" +
                "    dateTimeExpires: " + toIndentedString(super.getDateTimeExpires()) + "\n" +
                "    distributionStatus: " + toIndentedString(super.getDistributionStatus()) + "\n" +
                "    distributionKind: " + toIndentedString(super.getDistributionKind()) + "\n" +
                "    descriptor: " + toIndentedString(super.getDescriptor()) + "\n" +
                "    content: " + toIndentedString(content) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
