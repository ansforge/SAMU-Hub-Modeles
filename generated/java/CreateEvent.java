package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class CreateEvent {
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
  @JsonProperty("primaryAlert")
  @NotNull
  private PrimaryAlert primaryAlert;
  @JsonProperty("otherAlert")
  @Size(min=0)
  private Object[] otherAlert;

  public CreateEvent(){
  }

  public CreateEvent(
    String eventId, java.time.OffsetDateTime createdAt, Severity severity, LocationType eventLocation, PrimaryAlert primaryAlert, Object[] otherAlert
  ) {
  	this.eventId = eventId;
  	this.createdAt = createdAt;
  	this.severity = severity;
  	this.eventLocation = eventLocation;
  	this.primaryAlert = primaryAlert;
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

  public PrimaryAlert getPrimaryAlert() { return this.primaryAlert; }
  public void setPrimaryAlert(PrimaryAlert primaryAlert) { this.primaryAlert = primaryAlert; }

  public Object[] getOtherAlert() { return this.otherAlert; }
  public void setOtherAlert(Object[] otherAlert) { this.otherAlert = otherAlert; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateEvent self = (CreateEvent) o;
      return 
        Objects.equals(this.eventId, self.eventId) &&
        Objects.equals(this.createdAt, self.createdAt) &&
        Objects.equals(this.severity, self.severity) &&
        Objects.equals(this.eventLocation, self.eventLocation) &&
        Objects.equals(this.primaryAlert, self.primaryAlert) &&
        Objects.equals(this.otherAlert, self.otherAlert);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)eventId, (Object)createdAt, (Object)severity, (Object)eventLocation, (Object)primaryAlert, (Object)otherAlert);
  }

  @Override
  public String toString() {
    return "class CreateEvent {\n" +   
      "    eventId: " + toIndentedString(eventId) + "\n" +
      "    createdAt: " + toIndentedString(createdAt) + "\n" +
      "    severity: " + toIndentedString(severity) + "\n" +
      "    eventLocation: " + toIndentedString(eventLocation) + "\n" +
      "    primaryAlert: " + toIndentedString(primaryAlert) + "\n" +
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