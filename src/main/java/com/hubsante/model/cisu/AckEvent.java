package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
              
public class AckEvent {
  @JsonProperty("eventId")
  @NotNull
  private String eventId;
  @JsonProperty("alert")
  @Size(min=0)
  private Alert[] alert;

  public AckEvent(){
  }

  public AckEvent(
    String eventId, Alert[] alert
  ) {
  	this.eventId = eventId;
  	this.alert = alert;
  }

  public String getEventId() { return this.eventId; }
  public void setEventId(String eventId) { this.eventId = eventId; }

  public Alert[] getAlert() { return this.alert; }
  public void setAlert(Alert[] alert) { this.alert = alert; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AckEvent self = (AckEvent) o;
      return 
        Objects.equals(this.eventId, self.eventId) &&
        Objects.equals(this.alert, self.alert);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)eventId, (Object)alert);
  }

  @Override
  public String toString() {
    return "class AckEvent {\n" +   
      "    eventId: " + toIndentedString(eventId) + "\n" +
      "    alert: " + toIndentedString(alert) + "\n" +
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