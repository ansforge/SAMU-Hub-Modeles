package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;
              
public class CancelEvent {
  @JsonProperty("eventId")
  @NotNull
  private String eventId;
  @JsonProperty("cancelReason")
  @NotNull
  private CancelReason cancelReason;
  @JsonProperty("cancelInformation")
  private String cancelInformation;
  @JsonProperty("createdAt")
  private java.time.OffsetDateTime createdAt;
  @JsonProperty("severity")
  private Severity severity;
  @JsonProperty("eventLocation")
  private LocationType eventLocation;
  @JsonProperty("otherAlert")
  private OtherAlert otherAlert;

  public CancelEvent(){
  }

  public CancelEvent(
    String eventId, CancelReason cancelReason, String cancelInformation, java.time.OffsetDateTime createdAt, Severity severity, LocationType eventLocation, OtherAlert otherAlert
  ) {
  	this.eventId = eventId;
  	this.cancelReason = cancelReason;
  	this.cancelInformation = cancelInformation;
  	this.createdAt = createdAt;
  	this.severity = severity;
  	this.eventLocation = eventLocation;
  	this.otherAlert = otherAlert;
  }

  public String getEventId() { return this.eventId; }
  public void setEventId(String eventId) { this.eventId = eventId; }

  public CancelReason getCancelReason() { return this.cancelReason; }
  public void setCancelReason(CancelReason cancelReason) { this.cancelReason = cancelReason; }

  public String getCancelInformation() { return this.cancelInformation; }
  public void setCancelInformation(String cancelInformation) { this.cancelInformation = cancelInformation; }

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
    CancelEvent self = (CancelEvent) o;
      return 
        Objects.equals(this.eventId, self.eventId) &&
        Objects.equals(this.cancelReason, self.cancelReason) &&
        Objects.equals(this.cancelInformation, self.cancelInformation) &&
        Objects.equals(this.createdAt, self.createdAt) &&
        Objects.equals(this.severity, self.severity) &&
        Objects.equals(this.eventLocation, self.eventLocation) &&
        Objects.equals(this.otherAlert, self.otherAlert);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)eventId, (Object)cancelReason, (Object)cancelInformation, (Object)createdAt, (Object)severity, (Object)eventLocation, (Object)otherAlert);
  }

  @Override
  public String toString() {
    return "class CancelEvent {\n" +   
      "    eventId: " + toIndentedString(eventId) + "\n" +
      "    cancelReason: " + toIndentedString(cancelReason) + "\n" +
      "    cancelInformation: " + toIndentedString(cancelInformation) + "\n" +
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