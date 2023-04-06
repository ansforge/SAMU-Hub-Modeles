package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class AckMessageId {
  @JsonProperty("ackMessageId")
  @NotNull
  private String ackMessageId;
  private Map<String, Object> additionalProperties;

  public AckMessageId(){
  }

  public AckMessageId(
    String ackMessageId, Map<String, Object> additionalProperties
  ) {
  	this.ackMessageId = ackMessageId;
  	this.additionalProperties = additionalProperties;
  }

  public String getAckMessageId() { return this.ackMessageId; }
  public void setAckMessageId(String ackMessageId) { this.ackMessageId = ackMessageId; }

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
    AckMessageId self = (AckMessageId) o;
      return 
        Objects.equals(this.ackMessageId, self.ackMessageId) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)ackMessageId, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class AckMessageId {\n" +   
      "    ackMessageId: " + toIndentedString(ackMessageId) + "\n" +
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