package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class GenericAckMessage {
  @JsonProperty("ackDistributionId")
  @NotNull
  private String ackDistributionId;

  public GenericAckMessage(){
  }

  public GenericAckMessage(
    String ackDistributionId
  ) {
  	this.ackDistributionId = ackDistributionId;
  }

  public String getAckDistributionId() { return this.ackDistributionId; }
  public void setAckDistributionId(String ackDistributionId) { this.ackDistributionId = ackDistributionId; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericAckMessage self = (GenericAckMessage) o;
      return 
        Objects.equals(this.ackDistributionId, self.ackDistributionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)ackDistributionId);
  }

  @Override
  public String toString() {
    return "class GenericAckMessage {\n" +   
      "    ackDistributionId: " + toIndentedString(ackDistributionId) + "\n" +
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