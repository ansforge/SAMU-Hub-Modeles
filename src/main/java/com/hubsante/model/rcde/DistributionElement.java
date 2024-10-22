/**
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
/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.rcde;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import com.hubsante.model.edxl.ContentMessage;
import com.hubsante.model.rcde.Recipient;
import com.hubsante.model.rcde.Sender;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * DistributionElement
 */
@JsonPropertyOrder({DistributionElement.JSON_PROPERTY_MESSAGE_ID,
                    DistributionElement.JSON_PROPERTY_SENDER,
                    DistributionElement.JSON_PROPERTY_SENT_AT,
                    DistributionElement.JSON_PROPERTY_KIND,
                    DistributionElement.JSON_PROPERTY_STATUS,
                    DistributionElement.JSON_PROPERTY_RECIPIENT})
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class DistributionElement extends ContentMessage {
  public static final String JSON_PROPERTY_MESSAGE_ID = "messageId";
  private String messageId;

  public static final String JSON_PROPERTY_SENDER = "sender";
  private Sender sender;

  public static final String JSON_PROPERTY_SENT_AT = "sentAt";
  private OffsetDateTime sentAt;

  /**
   * Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
   */
  public enum KindEnum {
    REPORT("Report"),

    UPDATE("Update"),

    CANCEL("Cancel"),

    ACK("Ack"),

    ERROR("Error");

    private String value;

    KindEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static KindEnum fromValue(String value) {
      for (KindEnum b : KindEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_KIND = "kind";
  private KindEnum kind;

  /**
   * Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir
   * DST)
   */
  public enum StatusEnum {
    ACTUAL("Actual"),

    EXERCISE("Exercise"),

    SYSTEM("System");

    private String value;

    StatusEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";
  private List<Recipient> recipient = new ArrayList<>();

  public DistributionElement() {}

  public DistributionElement messageId(String messageId) {

    this.messageId = messageId;
    return this;
  }

  /**
   * Identifiant partagé de l&#39;affaire/dossier, généré une seule fois par le
   *système du partenaire qui recoit la primo-demande de secours (créateur du
   *dossier).  Il est valorisé comme suit lors de sa création :
   *{pays}.{domaine}.{organisation}.{senderCaseId}  Il doit pouvoir être généré
   *de façon décentralisée et ne présenter aucune ambiguïté.  Il doit être
   *unique dans l&#39;ensemble des systèmes : le numéro de dossier fourni par
   *celui qui génère l&#39;identifiant partagé doit donc être un numéro unique
   *dans son système.
   * @return messageId
   **/
  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMessageId() {
    return messageId;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public DistributionElement sender(Sender sender) {

    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
   **/
  @JsonProperty(JSON_PROPERTY_SENDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Sender getSender() {
    return sender;
  }

  @JsonProperty(JSON_PROPERTY_SENDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSender(Sender sender) {
    this.sender = sender;
  }

  public DistributionElement sentAt(OffsetDateTime sentAt) {

    this.sentAt = sentAt;
    return this;
  }

  /**
   * Groupe date heure de début de partage lié à l&#39;envoi du message. Il doit
   *être cohérent avec le champ &lt;dateTimeSent&gt; de l&#39;enveloppe EDXL
   *(voir DST).  L&#39;indicateur de fuseau horaire Z ne doit pas être utilisé.
   *Le fuseau horaire pour UTC doit être représenté par &#39;-00:00&#39;
   * @return sentAt
   **/
  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public OffsetDateTime getSentAt() {
    return sentAt;
  }

  @JsonProperty(JSON_PROPERTY_SENT_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSentAt(OffsetDateTime sentAt) {
    this.sentAt = sentAt;
  }

  public DistributionElement kind(KindEnum kind) {

    this.kind = kind;
    return this;
  }

  /**
   * Prend la valeur &lt;distributionKind de l&#39;enveloppe EDXL (voir DST)
   * @return kind
   **/
  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public KindEnum getKind() {
    return kind;
  }

  @JsonProperty(JSON_PROPERTY_KIND)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKind(KindEnum kind) {
    this.kind = kind;
  }

  public DistributionElement status(StatusEnum status) {

    this.status = status;
    return this;
  }

  /**
   * Prend la valeur &lt;distributionStatus&gt; de l&#39;enveloppe EDXL (voir
   *DST)
   * @return status
   **/
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public DistributionElement recipient(List<Recipient> recipient) {

    this.recipient = recipient;
    return this;
  }

  public DistributionElement addRecipientItem(Recipient recipientItem) {
    if (this.recipient == null) {
      this.recipient = new ArrayList<>();
    }
    this.recipient.add(recipientItem);
    return this;
  }

  /**
   * Get recipient
   * @return recipient
   **/
  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<Recipient> getRecipient() {
    return recipient;
  }

  @JacksonXmlElementWrapper(useWrapping = false)

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecipient(List<Recipient> recipient) {
    if (recipient == null) {
      return;
    }
    if (this.recipient == null) {
      this.recipient = new ArrayList<>();
    }
    this.recipient.addAll(recipient);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DistributionElement distributionElement = (DistributionElement)o;
    return Objects.equals(this.messageId, distributionElement.messageId) &&
        Objects.equals(this.sender, distributionElement.sender) &&
        Objects.equals(this.sentAt, distributionElement.sentAt) &&
        Objects.equals(this.kind, distributionElement.kind) &&
        Objects.equals(this.status, distributionElement.status) &&
        Objects.equals(this.recipient, distributionElement.recipient) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(messageId, sender, sentAt, kind, status, recipient,
                        super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DistributionElement {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    messageId: ")
        .append(toIndentedString(messageId))
        .append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
    sb.append("    sentAt: ").append(toIndentedString(sentAt)).append("\n");
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    recipient: ")
        .append(toIndentedString(recipient))
        .append("\n");
    sb.append("}");
    return sb.toString();
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
