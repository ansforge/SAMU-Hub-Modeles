package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class EdxlMessage {
  @JsonProperty("distributionID")
  @NotNull
  private String distributionId;
  @JsonProperty("senderID")
  @NotNull
  private String senderId;
  @JsonProperty("dateTimeSent")
  @NotNull
  private String dateTimeSent;
  @JsonProperty("dateTimeExpires")
  @NotNull
  private String dateTimeExpires;
  @JsonProperty("distributionStatus")
  @NotNull
  private DistributionStatus distributionStatus;
  @JsonProperty("distributionKind")
  @NotNull
  private DistributionKind distributionKind;
  @JsonProperty("descriptor")
  @NotNull
  private Descriptor descriptor;
  @JsonProperty("content")
  @NotNull
  private Content content;

  public EdxlMessage(){
  }

  public EdxlMessage(
    String distributionId, String senderId, String dateTimeSent, String dateTimeExpires, DistributionStatus distributionStatus, DistributionKind distributionKind, Descriptor descriptor, Content content
  ) {
  	this.distributionId = distributionId;
  	this.senderId = senderId;
  	this.dateTimeSent = dateTimeSent;
  	this.dateTimeExpires = dateTimeExpires;
  	this.distributionStatus = distributionStatus;
  	this.distributionKind = distributionKind;
  	this.descriptor = descriptor;
  	this.content = content;
  }

  public String getDistributionId() { return this.distributionId; }
  public void setDistributionId(String distributionId) { this.distributionId = distributionId; }

  public String getSenderId() { return this.senderId; }
  public void setSenderId(String senderId) { this.senderId = senderId; }

  public String getDateTimeSent() { return this.dateTimeSent; }
  public void setDateTimeSent(String dateTimeSent) { this.dateTimeSent = dateTimeSent; }

  public String getDateTimeExpires() { return this.dateTimeExpires; }
  public void setDateTimeExpires(String dateTimeExpires) { this.dateTimeExpires = dateTimeExpires; }

  public DistributionStatus getDistributionStatus() { return this.distributionStatus; }
  public void setDistributionStatus(DistributionStatus distributionStatus) { this.distributionStatus = distributionStatus; }

  public DistributionKind getDistributionKind() { return this.distributionKind; }
  public void setDistributionKind(DistributionKind distributionKind) { this.distributionKind = distributionKind; }

  public Descriptor getDescriptor() { return this.descriptor; }
  public void setDescriptor(Descriptor descriptor) { this.descriptor = descriptor; }

  public Content getContent() { return this.content; }
  public void setContent(Content content) { this.content = content; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EdxlMessage self = (EdxlMessage) o;
      return 
        Objects.equals(this.distributionId, self.distributionId) &&
        Objects.equals(this.senderId, self.senderId) &&
        Objects.equals(this.dateTimeSent, self.dateTimeSent) &&
        Objects.equals(this.dateTimeExpires, self.dateTimeExpires) &&
        Objects.equals(this.distributionStatus, self.distributionStatus) &&
        Objects.equals(this.distributionKind, self.distributionKind) &&
        Objects.equals(this.descriptor, self.descriptor) &&
        Objects.equals(this.content, self.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)distributionId, (Object)senderId, (Object)dateTimeSent, (Object)dateTimeExpires, (Object)distributionStatus, (Object)distributionKind, (Object)descriptor, (Object)content);
  }

  @Override
  public String toString() {
    return "class EdxlMessage {\n" +   
      "    distributionId: " + toIndentedString(distributionId) + "\n" +
      "    senderId: " + toIndentedString(senderId) + "\n" +
      "    dateTimeSent: " + toIndentedString(dateTimeSent) + "\n" +
      "    dateTimeExpires: " + toIndentedString(dateTimeExpires) + "\n" +
      "    distributionStatus: " + toIndentedString(distributionStatus) + "\n" +
      "    distributionKind: " + toIndentedString(distributionKind) + "\n" +
      "    descriptor: " + toIndentedString(descriptor) + "\n" +
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