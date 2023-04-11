package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Alert {
  @JsonProperty("alertId")
  @NotNull
  private String alertId;

  public Alert(){
  }

  public Alert(
    String alertId
  ) {
  	this.alertId = alertId;
  }

  public String getAlertId() { return this.alertId; }
  public void setAlertId(String alertId) { this.alertId = alertId; }

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
        Objects.equals(this.alertId, self.alertId);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)alertId);
  }

  @Override
  public String toString() {
    return "class Alert {\n" +   
      "    alertId: " + toIndentedString(alertId) + "\n" +
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