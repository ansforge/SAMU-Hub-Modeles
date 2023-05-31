package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
              
public class UpdateEvent {
  @JsonProperty("eventId")
  @NotNull
  private String eventId;
  @JsonProperty("createdAt")
  @NotNull
  private java.time.OffsetDateTime createdAt;
  @JsonProperty("severity")
  @NotNull
  private Severity severity;
  @JsonProperty("eventLocation")
  @NotNull
  private LocationType eventLocation;
  @JsonProperty("otherAlert")
  @NotNull
  private OtherAlert otherAlert;

  public UpdateEvent(){
  }

  public UpdateEvent(
    String eventId, java.time.OffsetDateTime createdAt, Severity severity, LocationType eventLocation, OtherAlert otherAlert
  ) {
  	this.eventId = eventId;
  	this.createdAt = createdAt;
  	this.severity = severity;
  	this.eventLocation = eventLocation;
  	this.otherAlert = otherAlert;
  }

  public String getEventId() { return this.eventId; }
  public void setEventId(String eventId) { this.eventId = eventId; }

  public java.time.OffsetDateTime getCreatedAt() { return this.createdAt; }
  public void setCreatedAt(java.time.OffsetDateTime createdAt) { this.createdAt = createdAt; }

  public Severity getSeverity() { return this.severity; }
  public void setSeverity(Severity severity) { this.severity = severity; }

  public LocationType getEventLocation() { return this.eventLocation; }
  public void setEventLocation(LocationType eventLocation) { this.eventLocation = eventLocation; }

  public OtherAlert getOtherAlert() { return this.otherAlert; }
  public void setOtherAlert(OtherAlert otherAlert) { this.otherAlert = otherAlert; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateEvent self = (UpdateEvent) o;
      return 
        Objects.equals(this.eventId, self.eventId) &&
        Objects.equals(this.createdAt, self.createdAt) &&
        Objects.equals(this.severity, self.severity) &&
        Objects.equals(this.eventLocation, self.eventLocation) &&
        Objects.equals(this.otherAlert, self.otherAlert);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)eventId, (Object)createdAt, (Object)severity, (Object)eventLocation, (Object)otherAlert);
  }

  @Override
  public String toString() {
    return "class UpdateEvent {\n" +   
      "    eventId: " + toIndentedString(eventId) + "\n" +
      "    createdAt: " + toIndentedString(createdAt) + "\n" +
      "    severity: " + toIndentedString(severity) + "\n" +
      "    eventLocation: " + toIndentedString(eventLocation) + "\n" +
      "    otherAlert: " + toIndentedString(otherAlert) + "\n" +
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