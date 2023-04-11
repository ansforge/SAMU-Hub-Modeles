package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class AckMessageId {
  @JsonProperty("ackMessageId")
  @NotNull
  private String ackMessageId;

  public AckMessageId(){
  }

  public AckMessageId(
    String ackMessageId
  ) {
  	this.ackMessageId = ackMessageId;
  }

  public String getAckMessageId() { return this.ackMessageId; }
  public void setAckMessageId(String ackMessageId) { this.ackMessageId = ackMessageId; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AckMessageId self = (AckMessageId) o;
      return 
        Objects.equals(this.ackMessageId, self.ackMessageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)ackMessageId);
  }

  @Override
  public String toString() {
    return "class AckMessageId {\n" +   
      "    ackMessageId: " + toIndentedString(ackMessageId) + "\n" +
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