package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class AnonymousSchema_100 {
  @JsonProperty("messageId")
  @NotNull
  private String messageId;
  @JsonProperty("sender")
  @NotNull
  private AddresseeType sender;
  @JsonProperty("sentAt")
  @NotNull
  private java.time.OffsetDateTime sentAt;
  @JsonProperty("msgType")
  @NotNull
  private MsgType msgType;
  @JsonProperty("status")
  @NotNull
  private Status status;
  @JsonProperty("recipients")
  @NotNull
  private Recipients recipients;
  @JsonProperty("ackMessage")
  private AckMessageId ackMessage;
  @JsonProperty("createEvent")
  private CreateEvent createEvent;
  @JsonProperty("ackEvent")
  @NotNull
  private AckEvent ackEvent;
  @JsonProperty("updateEvent")
  private UpdateEvent updateEvent;
  @JsonProperty("cancelEvent")
  private CancelEvent cancelEvent;
  private Map<String, Object> additionalProperties;

  public AnonymousSchema_100(){
  }

  public AnonymousSchema_100(
    String messageId, AddresseeType sender, java.time.OffsetDateTime sentAt, MsgType msgType, Status status, Recipients recipients, AckMessageId ackMessage, CreateEvent createEvent, AckEvent ackEvent, UpdateEvent updateEvent, CancelEvent cancelEvent, Map<String, Object> additionalProperties
  ) {
  	this.messageId = messageId;
  	this.sender = sender;
  	this.sentAt = sentAt;
  	this.msgType = msgType;
  	this.status = status;
  	this.recipients = recipients;
  	this.ackMessage = ackMessage;
  	this.createEvent = createEvent;
  	this.ackEvent = ackEvent;
  	this.updateEvent = updateEvent;
  	this.cancelEvent = cancelEvent;
  	this.additionalProperties = additionalProperties;
  }

  public String getMessageId() { return this.messageId; }
  public void setMessageId(String messageId) { this.messageId = messageId; }

  public AddresseeType getSender() { return this.sender; }
  public void setSender(AddresseeType sender) { this.sender = sender; }

  public java.time.OffsetDateTime getSentAt() { return this.sentAt; }
  public void setSentAt(java.time.OffsetDateTime sentAt) { this.sentAt = sentAt; }

  public MsgType getMsgType() { return this.msgType; }
  public void setMsgType(MsgType msgType) { this.msgType = msgType; }

  public Status getStatus() { return this.status; }
  public void setStatus(Status status) { this.status = status; }

  public Recipients getRecipients() { return this.recipients; }
  public void setRecipients(Recipients recipients) { this.recipients = recipients; }

  public AckMessageId getAckMessage() { return this.ackMessage; }
  public void setAckMessage(AckMessageId ackMessage) { this.ackMessage = ackMessage; }

  public CreateEvent getCreateEvent() { return this.createEvent; }
  public void setCreateEvent(CreateEvent createEvent) { this.createEvent = createEvent; }

  public AckEvent getAckEvent() { return this.ackEvent; }
  public void setAckEvent(AckEvent ackEvent) { this.ackEvent = ackEvent; }

  public UpdateEvent getUpdateEvent() { return this.updateEvent; }
  public void setUpdateEvent(UpdateEvent updateEvent) { this.updateEvent = updateEvent; }

  public CancelEvent getCancelEvent() { return this.cancelEvent; }
  public void setCancelEvent(CancelEvent cancelEvent) { this.cancelEvent = cancelEvent; }

  public Map<String, Object> getAdditionalProperties() { return this.additionalProperties; }
  public void setAdditionalProperties(Map<String, Object> additionalProperties) { this.additionalProperties = additionalProperties; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnonymousSchema_100 self = (AnonymousSchema_100) o;
      return 
        Objects.equals(this.messageId, self.messageId) &&
        Objects.equals(this.sender, self.sender) &&
        Objects.equals(this.sentAt, self.sentAt) &&
        Objects.equals(this.msgType, self.msgType) &&
        Objects.equals(this.status, self.status) &&
        Objects.equals(this.recipients, self.recipients) &&
        Objects.equals(this.ackMessage, self.ackMessage) &&
        Objects.equals(this.createEvent, self.createEvent) &&
        Objects.equals(this.ackEvent, self.ackEvent) &&
        Objects.equals(this.updateEvent, self.updateEvent) &&
        Objects.equals(this.cancelEvent, self.cancelEvent) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)messageId, (Object)sender, (Object)sentAt, (Object)msgType, (Object)status, (Object)recipients, (Object)ackMessage, (Object)createEvent, (Object)ackEvent, (Object)updateEvent, (Object)cancelEvent, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class AnonymousSchema_100 {\n" +   
      "    messageId: " + toIndentedString(messageId) + "\n" +
      "    sender: " + toIndentedString(sender) + "\n" +
      "    sentAt: " + toIndentedString(sentAt) + "\n" +
      "    msgType: " + toIndentedString(msgType) + "\n" +
      "    status: " + toIndentedString(status) + "\n" +
      "    recipients: " + toIndentedString(recipients) + "\n" +
      "    ackMessage: " + toIndentedString(ackMessage) + "\n" +
      "    createEvent: " + toIndentedString(createEvent) + "\n" +
      "    ackEvent: " + toIndentedString(ackEvent) + "\n" +
      "    updateEvent: " + toIndentedString(updateEvent) + "\n" +
      "    cancelEvent: " + toIndentedString(cancelEvent) + "\n" +
      "    additionalProperties: " + toIndentedString(additionalProperties) + "\n" +
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