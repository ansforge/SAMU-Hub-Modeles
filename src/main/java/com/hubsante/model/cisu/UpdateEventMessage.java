package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UpdateEventMessage implements CisuMessage {
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
  @JsonProperty("updateEvent")
  @NotNull
  private UpdateEvent updateEvent;

  public UpdateEventMessage(){
  }

  public UpdateEventMessage(
    String messageId, AddresseeType sender, java.time.OffsetDateTime sentAt, MsgType msgType, Status status, Recipients recipients, UpdateEvent updateEvent
  ) {
  	this.messageId = messageId;
  	this.sender = sender;
  	this.sentAt = sentAt;
  	this.msgType = msgType;
  	this.status = status;
  	this.recipients = recipients;
  	this.updateEvent = updateEvent;
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

  public UpdateEvent getUpdateEvent() { return this.updateEvent; }
  public void setUpdateEvent(UpdateEvent updateEvent) { this.updateEvent = updateEvent; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateEventMessage self = (UpdateEventMessage) o;
      return 
        Objects.equals(this.messageId, self.messageId) &&
        Objects.equals(this.sender, self.sender) &&
        Objects.equals(this.sentAt, self.sentAt) &&
        Objects.equals(this.msgType, self.msgType) &&
        Objects.equals(this.status, self.status) &&
        Objects.equals(this.recipients, self.recipients) &&
        Objects.equals(this.updateEvent, self.updateEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)messageId, (Object)sender, (Object)sentAt, (Object)msgType, (Object)status, (Object)recipients, (Object)updateEvent);
  }

  @Override
  public String toString() {
    return "class UpdateEventMessage {\n" +   
      "    messageId: " + toIndentedString(messageId) + "\n" +
      "    sender: " + toIndentedString(sender) + "\n" +
      "    sentAt: " + toIndentedString(sentAt) + "\n" +
      "    msgType: " + toIndentedString(msgType) + "\n" +
      "    status: " + toIndentedString(status) + "\n" +
      "    recipients: " + toIndentedString(recipients) + "\n" +
      "    updateEvent: " + toIndentedString(updateEvent) + "\n" +
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