package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class PrimaryAlert {
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
  @NotNull
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
  @JsonProperty("alertCode")
  @NotNull
  private AlertCode alertCode;
  @JsonProperty("resource")
  @Size(min=0)
  private Object[] resource;
  private Map<String, Object> additionalProperties;

  public PrimaryAlert(){
  }

  public PrimaryAlert(
    String alertId, java.time.OffsetDateTime receivedAt, Reporting reporting, String alertInformation, LocationType alertLocation, Call call, Caller caller, CallTaker callTaker, AlertCode alertCode, Object[] resource, Map<String, Object> additionalProperties
  ) {
  	this.alertId = alertId;
  	this.receivedAt = receivedAt;
  	this.reporting = reporting;
  	this.alertInformation = alertInformation;
  	this.alertLocation = alertLocation;
  	this.call = call;
  	this.caller = caller;
  	this.callTaker = callTaker;
  	this.alertCode = alertCode;
  	this.resource = resource;
  	this.additionalProperties = additionalProperties;
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

  public AlertCode getAlertCode() { return this.alertCode; }
  public void setAlertCode(AlertCode alertCode) { this.alertCode = alertCode; }

  public Object[] getResource() { return this.resource; }
  public void setResource(Object[] resource) { this.resource = resource; }

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
    PrimaryAlert self = (PrimaryAlert) o;
      return 
        Objects.equals(this.alertId, self.alertId) &&
        Objects.equals(this.receivedAt, self.receivedAt) &&
        Objects.equals(this.reporting, self.reporting) &&
        Objects.equals(this.alertInformation, self.alertInformation) &&
        Objects.equals(this.alertLocation, self.alertLocation) &&
        Objects.equals(this.call, self.call) &&
        Objects.equals(this.caller, self.caller) &&
        Objects.equals(this.callTaker, self.callTaker) &&
        Objects.equals(this.alertCode, self.alertCode) &&
        Objects.equals(this.resource, self.resource) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)alertId, (Object)receivedAt, (Object)reporting, (Object)alertInformation, (Object)alertLocation, (Object)call, (Object)caller, (Object)callTaker, (Object)alertCode, (Object)resource, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class PrimaryAlert {\n" +   
      "    alertId: " + toIndentedString(alertId) + "\n" +
      "    receivedAt: " + toIndentedString(receivedAt) + "\n" +
      "    reporting: " + toIndentedString(reporting) + "\n" +
      "    alertInformation: " + toIndentedString(alertInformation) + "\n" +
      "    alertLocation: " + toIndentedString(alertLocation) + "\n" +
      "    call: " + toIndentedString(call) + "\n" +
      "    caller: " + toIndentedString(caller) + "\n" +
      "    callTaker: " + toIndentedString(callTaker) + "\n" +
      "    alertCode: " + toIndentedString(alertCode) + "\n" +
      "    resource: " + toIndentedString(resource) + "\n" +
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