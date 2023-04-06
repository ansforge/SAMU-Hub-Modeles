package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Caller {
  @JsonProperty("callerURI")
  @NotNull
  private String callerUri;
  @JsonProperty("callbackURI")
  private String callbackUri;
  @JsonProperty("spokenLanguage")
  private String spokenLanguage;
  @JsonProperty("callerInformation")
  private String callerInformation;
  @JsonProperty("callerName")
  private String callerName;
  private Map<String, Object> additionalProperties;

  public Caller(){
  }

  public Caller(
    String callerUri, String callbackUri, String spokenLanguage, String callerInformation, String callerName, Map<String, Object> additionalProperties
  ) {
  	this.callerUri = callerUri;
  	this.callbackUri = callbackUri;
  	this.spokenLanguage = spokenLanguage;
  	this.callerInformation = callerInformation;
  	this.callerName = callerName;
  	this.additionalProperties = additionalProperties;
  }

  public String getCallerUri() { return this.callerUri; }
  public void setCallerUri(String callerUri) { this.callerUri = callerUri; }

  public String getCallbackUri() { return this.callbackUri; }
  public void setCallbackUri(String callbackUri) { this.callbackUri = callbackUri; }

  public String getSpokenLanguage() { return this.spokenLanguage; }
  public void setSpokenLanguage(String spokenLanguage) { this.spokenLanguage = spokenLanguage; }

  public String getCallerInformation() { return this.callerInformation; }
  public void setCallerInformation(String callerInformation) { this.callerInformation = callerInformation; }

  public String getCallerName() { return this.callerName; }
  public void setCallerName(String callerName) { this.callerName = callerName; }

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
    Caller self = (Caller) o;
      return 
        Objects.equals(this.callerUri, self.callerUri) &&
        Objects.equals(this.callbackUri, self.callbackUri) &&
        Objects.equals(this.spokenLanguage, self.spokenLanguage) &&
        Objects.equals(this.callerInformation, self.callerInformation) &&
        Objects.equals(this.callerName, self.callerName) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)callerUri, (Object)callbackUri, (Object)spokenLanguage, (Object)callerInformation, (Object)callerName, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class Caller {\n" +   
      "    callerUri: " + toIndentedString(callerUri) + "\n" +
      "    callbackUri: " + toIndentedString(callbackUri) + "\n" +
      "    spokenLanguage: " + toIndentedString(spokenLanguage) + "\n" +
      "    callerInformation: " + toIndentedString(callerInformation) + "\n" +
      "    callerName: " + toIndentedString(callerName) + "\n" +
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