package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class CisuMessage extends MessageEnvelope {
  @JsonProperty("content")
  @NotNull
  private Object content;
  @JsonProperty("to")
  @NotNull
  private String to;
  @JsonProperty("senderId")
  @NotNull
  private String senderId;
  @JsonProperty("distributionId")
  @NotNull
  private String distributionId;

  public CisuMessage(){
  }

  public CisuMessage(
    Object content, String to, String senderId, String distributionId
  ) {
  	this.content = content;
  	this.to = to;
  	this.senderId = senderId;
  	this.distributionId = distributionId;
  }

  public Object getContent() { return this.content; }
  public void setContent(Object content) { this.content = content; }

  /**
   * ID du destinataire
   */
  public String getTo() { return this.to; }
  public void setTo(String to) { this.to = to; }

  /**
   * ID de l'émetteur
   */
  public String getSenderId() { return this.senderId; }
  public void setSenderId(String senderId) { this.senderId = senderId; }

  /**
   * ID du message
   */
  public String getDistributionId() { return this.distributionId; }
  public void setDistributionId(String distributionId) { this.distributionId = distributionId; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CisuMessage self = (CisuMessage) o;
      return 
        Objects.equals(this.content, self.content) &&
        Objects.equals(this.to, self.to) &&
        Objects.equals(this.senderId, self.senderId) &&
        Objects.equals(this.distributionId, self.distributionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)content, (Object)to, (Object)senderId, (Object)distributionId);
  }

  @Override
  public String toString() {
    return "class CisuMessage {\n" +   
      "    content: " + toIndentedString(content) + "\n" +
      "    to: " + toIndentedString(to) + "\n" +
      "    senderId: " + toIndentedString(senderId) + "\n" +
      "    distributionId: " + toIndentedString(distributionId) + "\n" +
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