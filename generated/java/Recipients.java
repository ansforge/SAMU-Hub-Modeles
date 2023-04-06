package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Recipients {
  @JsonProperty("recipient")
  @NotNull
  @Size(min=1)
  private Object[] recipient;
  private Map<String, Object> additionalProperties;

  public Recipients(){
  }

  public Recipients(
    Object[] recipient, Map<String, Object> additionalProperties
  ) {
  	this.recipient = recipient;
  	this.additionalProperties = additionalProperties;
  }

  public Object[] getRecipient() { return this.recipient; }
  public void setRecipient(Object[] recipient) { this.recipient = recipient; }

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
    Recipients self = (Recipients) o;
      return 
        Objects.equals(this.recipient, self.recipient) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)recipient, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class Recipients {\n" +   
      "    recipient: " + toIndentedString(recipient) + "\n" +
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