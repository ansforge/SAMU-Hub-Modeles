package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
              
public class Recipients {
  @JsonProperty("recipient")
  @JacksonXmlProperty(localName = "recipient")
  @JacksonXmlElementWrapper(useWrapping = false)
  @NotNull
  @Size(min=0)
  private List<AddresseeType> recipient;

  public Recipients(){
  }

  public Recipients(
    List<AddresseeType> recipient
  ) {
  	this.recipient = recipient;
  }

  public List<AddresseeType> getRecipient() { return this.recipient; }
  public void setRecipient(List<AddresseeType> recipient) {
    if (this.recipient == null) {
      this.recipient = new ArrayList<>();
    }
    this.recipient.addAll(recipient); }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipients self = (Recipients) o;
      return Objects.equals(this.recipient, self.recipient);
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