package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtherAlert {
  @JsonProperty("alertId")
  @NotNull
  private String alertId;
  @JsonProperty("receivedAt")
  @NotNull
  private java.time.OffsetDateTime receivedAt;
  @JsonProperty("reporting")
  @NotNull
  private Reporting reporting;
  @JsonProperty("alertInformation")
  private String alertInformation;
  @JsonProperty("alertLocation")
  private LocationType alertLocation;
  @JsonProperty("call")
  @NotNull
  private Call call;
  @JsonProperty("caller")
  @NotNull
  private Caller caller;
  @JsonProperty("callTaker")
  @NotNull
  private CallTaker callTaker;
  @JsonProperty("otherAlertCode")
  @NotNull
  private OtherAlertCode otherAlertCode;
  @JsonProperty("resource")
  @Size(min=0)
  private ResourceType[] resource;

  public OtherAlert(){
  }

  public OtherAlert(
    String alertId, java.time.OffsetDateTime receivedAt, Reporting reporting, String alertInformation, LocationType alertLocation, Call call, Caller caller, CallTaker callTaker, OtherAlertCode otherAlertCode, ResourceType[] resource
  ) {
  	this.alertId = alertId;
  	this.receivedAt = receivedAt;
  	this.reporting = reporting;
  	this.alertInformation = alertInformation;
  	this.alertLocation = alertLocation;
  	this.call = call;
  	this.caller = caller;
  	this.callTaker = callTaker;
  	this.otherAlertCode = otherAlertCode;
  	this.resource = resource;
  }

  public String getAlertId() { return this.alertId; }
  public void setAlertId(String alertId) { this.alertId = alertId; }

  public java.time.OffsetDateTime getReceivedAt() { return this.receivedAt; }
  public void setReceivedAt(java.time.OffsetDateTime receivedAt) { this.receivedAt = receivedAt; }

  public Reporting getReporting() { return this.reporting; }
  public void setReporting(Reporting reporting) { this.reporting = reporting; }

  public String getAlertInformation() { return this.alertInformation; }
  public void setAlertInformation(String alertInformation) { this.alertInformation = alertInformation; }

  public LocationType getAlertLocation() { return this.alertLocation; }
  public void setAlertLocation(LocationType alertLocation) { this.alertLocation = alertLocation; }

  public Call getCall() { return this.call; }
  public void setCall(Call call) { this.call = call; }

  public Caller getCaller() { return this.caller; }
  public void setCaller(Caller caller) { this.caller = caller; }

  public CallTaker getCallTaker() { return this.callTaker; }
  public void setCallTaker(CallTaker callTaker) { this.callTaker = callTaker; }

  public OtherAlertCode getOtherAlertCode() { return this.otherAlertCode; }
  public void setOtherAlertCode(OtherAlertCode otherAlertCode) { this.otherAlertCode = otherAlertCode; }

  public ResourceType[] getResource() { return this.resource; }
  public void setResource(ResourceType[] resource) { this.resource = resource; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OtherAlert self = (OtherAlert) o;
      return 
        Objects.equals(this.alertId, self.alertId) &&
        Objects.equals(this.receivedAt, self.receivedAt) &&
        Objects.equals(this.reporting, self.reporting) &&
        Objects.equals(this.alertInformation, self.alertInformation) &&
        Objects.equals(this.alertLocation, self.alertLocation) &&
        Objects.equals(this.call, self.call) &&
        Objects.equals(this.caller, self.caller) &&
        Objects.equals(this.callTaker, self.callTaker) &&
        Objects.equals(this.otherAlertCode, self.otherAlertCode) &&
        Objects.equals(this.resource, self.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)alertId, (Object)receivedAt, (Object)reporting, (Object)alertInformation, (Object)alertLocation, (Object)call, (Object)caller, (Object)callTaker, (Object)otherAlertCode, (Object)resource);
  }

  @Override
  public String toString() {
    return "class OtherAlert {\n" +   
      "    alertId: " + toIndentedString(alertId) + "\n" +
      "    receivedAt: " + toIndentedString(receivedAt) + "\n" +
      "    reporting: " + toIndentedString(reporting) + "\n" +
      "    alertInformation: " + toIndentedString(alertInformation) + "\n" +
      "    alertLocation: " + toIndentedString(alertLocation) + "\n" +
      "    call: " + toIndentedString(call) + "\n" +
      "    caller: " + toIndentedString(caller) + "\n" +
      "    callTaker: " + toIndentedString(callTaker) + "\n" +
      "    otherAlertCode: " + toIndentedString(otherAlertCode) + "\n" +
      "    resource: " + toIndentedString(resource) + "\n" +
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