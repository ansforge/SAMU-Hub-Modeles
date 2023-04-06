package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class AlertCode {
  @JsonProperty("version")
  @NotNull
  private String version;
  @JsonProperty("whatsHappen")
  @NotNull
  private AttributeType whatsHappen;
  @JsonProperty("locationKind")
  @NotNull
  private AttributeType locationKind;
  @JsonProperty("riskThreat")
  @Size(min=0)
  private Object[] riskThreat;
  @JsonProperty("healthMotive")
  @NotNull
  private AttributeType healthMotive;
  @JsonProperty("victims")
  private Victims victims;
  private Map<String, Object> additionalProperties;

  public AlertCode(){
  }

  public AlertCode(
    String version, AttributeType whatsHappen, AttributeType locationKind, Object[] riskThreat, AttributeType healthMotive, Victims victims, Map<String, Object> additionalProperties
  ) {
  	this.version = version;
  	this.whatsHappen = whatsHappen;
  	this.locationKind = locationKind;
  	this.riskThreat = riskThreat;
  	this.healthMotive = healthMotive;
  	this.victims = victims;
  	this.additionalProperties = additionalProperties;
  }

  public String getVersion() { return this.version; }
  public void setVersion(String version) { this.version = version; }

  public AttributeType getWhatsHappen() { return this.whatsHappen; }
  public void setWhatsHappen(AttributeType whatsHappen) { this.whatsHappen = whatsHappen; }

  public AttributeType getLocationKind() { return this.locationKind; }
  public void setLocationKind(AttributeType locationKind) { this.locationKind = locationKind; }

  public Object[] getRiskThreat() { return this.riskThreat; }
  public void setRiskThreat(Object[] riskThreat) { this.riskThreat = riskThreat; }

  public AttributeType getHealthMotive() { return this.healthMotive; }
  public void setHealthMotive(AttributeType healthMotive) { this.healthMotive = healthMotive; }

  public Victims getVictims() { return this.victims; }
  public void setVictims(Victims victims) { this.victims = victims; }

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
    AlertCode self = (AlertCode) o;
      return 
        Objects.equals(this.version, self.version) &&
        Objects.equals(this.whatsHappen, self.whatsHappen) &&
        Objects.equals(this.locationKind, self.locationKind) &&
        Objects.equals(this.riskThreat, self.riskThreat) &&
        Objects.equals(this.healthMotive, self.healthMotive) &&
        Objects.equals(this.victims, self.victims) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)version, (Object)whatsHappen, (Object)locationKind, (Object)riskThreat, (Object)healthMotive, (Object)victims, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class AlertCode {\n" +   
      "    version: " + toIndentedString(version) + "\n" +
      "    whatsHappen: " + toIndentedString(whatsHappen) + "\n" +
      "    locationKind: " + toIndentedString(locationKind) + "\n" +
      "    riskThreat: " + toIndentedString(riskThreat) + "\n" +
      "    healthMotive: " + toIndentedString(healthMotive) + "\n" +
      "    victims: " + toIndentedString(victims) + "\n" +
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