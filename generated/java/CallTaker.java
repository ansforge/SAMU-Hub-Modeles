package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class CallTaker {
  @JsonProperty("organization")
  private String organization;
  @JsonProperty("controlRoom")
  private String controlRoom;
  @JsonProperty("calltakerURI")
  private String calltakerUri;

  public CallTaker(){
  }

  public CallTaker(
    String organization, String controlRoom, String calltakerUri
  ) {
  	this.organization = organization;
  	this.controlRoom = controlRoom;
  	this.calltakerUri = calltakerUri;
  }

  public String getOrganization() { return this.organization; }
  public void setOrganization(String organization) { this.organization = organization; }

  public String getControlRoom() { return this.controlRoom; }
  public void setControlRoom(String controlRoom) { this.controlRoom = controlRoom; }

  public String getCalltakerUri() { return this.calltakerUri; }
  public void setCalltakerUri(String calltakerUri) { this.calltakerUri = calltakerUri; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallTaker self = (CallTaker) o;
      return 
        Objects.equals(this.organization, self.organization) &&
        Objects.equals(this.controlRoom, self.controlRoom) &&
        Objects.equals(this.calltakerUri, self.calltakerUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)organization, (Object)controlRoom, (Object)calltakerUri);
  }

  @Override
  public String toString() {
    return "class CallTaker {\n" +   
      "    organization: " + toIndentedString(organization) + "\n" +
      "    controlRoom: " + toIndentedString(controlRoom) + "\n" +
      "    calltakerUri: " + toIndentedString(calltakerUri) + "\n" +
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