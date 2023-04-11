package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Recipients {
  @JsonProperty("recipient")
  @NotNull
  @Size(min=1)
  private Object[] recipient;

  public Recipients(){
  }

  public Recipients(
    Object[] recipient
  ) {
  	this.recipient = recipient;
  }

  public Object[] getRecipient() { return this.recipient; }
  public void setRecipient(Object[] recipient) { this.recipient = recipient; }

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
        Objects.equals(this.recipient, self.recipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)recipient);
  }

  @Override
  public String toString() {
    return "class Recipients {\n" +   
      "    recipient: " + toIndentedString(recipient) + "\n" +
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