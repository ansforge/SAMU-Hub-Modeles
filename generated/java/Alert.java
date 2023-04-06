package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Alert {
  @JsonProperty("alertId")
  @NotNull
  private String alertId;
  private Map<String, Object> additionalProperties;

  public Alert(){
  }

  public Alert(
    String alertId, Map<String, Object> additionalProperties
  ) {
  	this.alertId = alertId;
  	this.additionalProperties = additionalProperties;
  }

  public String getAlertId() { return this.alertId; }
  public void setAlertId(String alertId) { this.alertId = alertId; }

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
    Alert self = (Alert) o;
      return 
        Objects.equals(this.alertId, self.alertId) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)alertId, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class Alert {\n" +   
      "    alertId: " + toIndentedString(alertId) + "\n" +
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