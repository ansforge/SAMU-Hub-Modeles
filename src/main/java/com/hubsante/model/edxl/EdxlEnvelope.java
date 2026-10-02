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
package com.hubsante.model.edxl;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.OffsetDateTime;
import java.util.Objects;

/*
* We need JsonAutoDetect to override Jackson default behavior :
* We disable getter usage to force Jackson to use only field accessors.
* This way, the "@JacksonXmlProperty" annotated methods can generate specific XML (ie namespaces)
*  but they're not triggered at Json serialization
 */
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE
)
@JsonPropertyOrder({
        "distributionID",
        "senderID",
        "dateTimeSent",
        "dateTimeExpires",
        "distributionStatus",
        "distributionKind",
        "descriptor"
})
@JacksonXmlRootElement(localName = "edxlDistribution")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true) // mandatory to deserialize EdxlEnvelope only from full EdxlMessage
public class EdxlEnvelope {

    @JsonProperty(value = "distributionID", required = true)
    private String distributionID;

    @JsonProperty(value = "senderID", required = true)
    private String senderID;

    @JsonProperty(value = "dateTimeSent", required = true)
    private OffsetDateTime dateTimeSent;

    @JsonProperty(value = "dateTimeExpires", required = true)
    private OffsetDateTime dateTimeExpires;

    @JsonProperty(value = "distributionStatus", required = true)
    private DistributionStatus distributionStatus;

    @JsonProperty(value = "distributionKind", required = true)
    private DistributionKind distributionKind;

    @JsonProperty(value = "descriptor", required = true)
    private Descriptor descriptor;

    public EdxlEnvelope(String distributionID, String senderID, OffsetDateTime dateTimeSent, OffsetDateTime dateTimeExpires, DistributionStatus distributionStatus, DistributionKind distributionKind, Descriptor descriptor) {
        this.distributionID = distributionID;
        this.senderID = senderID;
        this.dateTimeSent = dateTimeSent;
        this.dateTimeExpires = dateTimeExpires;
        this.distributionStatus = distributionStatus;
        this.distributionKind = distributionKind;
        this.descriptor = descriptor;
    }

    /*
    * This is a workaround to handle namespaces with prefixes
    * see https://stackoverflow.com/questions/16442805/jackson-xml-deserializing-xml-with-namespace-prefixes
     */
    @JacksonXmlProperty(localName = "xlink:type", isAttribute = true)
    public String getXmlnsXlinkType() {
        return "extended";
    }

    @JacksonXmlProperty(localName = "xmlns", isAttribute = true)
    public String getXmlns() {
        return "urn:oasis:names:tc:emergency:EDXL:DE:2.0";
    }

    @JacksonXmlProperty(localName = "xmlns:xlink", isAttribute = true)
    public String getXmlnsXlink() {
        return "http://www.w3.org/1999/xlink";
    }

    @JacksonXmlProperty(localName = "xmlns:ct", isAttribute = true)
    public String getXmlnsCt() {
        return "urn:oasis:names:tc:emergency:edxl:ct:1.0";
    }

    public EdxlEnvelope() {
    }

    public String getDistributionID() {
        return distributionID;
    }

    public void setDistributionID(String distributionID) {
        this.distributionID = distributionID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public OffsetDateTime getDateTimeSent() {
        return dateTimeSent;
    }

    public void setDateTimeSent(OffsetDateTime dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }

    public OffsetDateTime getDateTimeExpires() {
        return dateTimeExpires;
    }

    public void setDateTimeExpires(OffsetDateTime dateTimeExpires) {
        this.dateTimeExpires = dateTimeExpires;
    }

    public DistributionStatus getDistributionStatus() {
        return distributionStatus;
    }

    public void setDistributionStatus(DistributionStatus distributionStatus) {
        this.distributionStatus = distributionStatus;
    }

    public DistributionKind getDistributionKind() {
        return distributionKind;
    }

    public void setDistributionKind(DistributionKind distributionKind) {
        this.distributionKind = distributionKind;
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdxlEnvelope that = (EdxlEnvelope) o;
        return
                distributionID.equals(that.distributionID) &&
                senderID.equals(that.senderID) &&
                dateTimeSent.equals(that.dateTimeSent) &&
                dateTimeExpires.equals(that.dateTimeExpires) &&
                distributionStatus == that.distributionStatus &&
                distributionKind == that.distributionKind &&
                descriptor.equals(that.descriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributionID, senderID, dateTimeSent, dateTimeExpires, distributionStatus, distributionKind, descriptor);
    }

    @Override
    public String toString() {
        return "class EdxlMessage {\n" +
                "    distributionID: " + toIndentedString(distributionID) + "\n" +
                "    senderId: " + toIndentedString(senderID) + "\n" +
                "    dateTimeSent: " + toIndentedString(dateTimeSent) + "\n" +
                "    dateTimeExpires: " + toIndentedString(dateTimeExpires) + "\n" +
                "    distributionStatus: " + toIndentedString(distributionStatus) + "\n" +
                "    distributionKind: " + toIndentedString(distributionKind) + "\n" +
                "    descriptor: " + toIndentedString(descriptor) + "\n" +
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
