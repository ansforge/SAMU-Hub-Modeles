package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
  private AttributeType[] riskThreat;
  @JsonProperty("healthMotive")
  @NotNull
  private AttributeType healthMotive;
  @JsonProperty("victims")
  private Victims victims;

  public AlertCode(){
  }

  public AlertCode(
    String version, AttributeType whatsHappen, AttributeType locationKind, AttributeType[] riskThreat, AttributeType healthMotive, Victims victims
  ) {
  	this.version = version;
  	this.whatsHappen = whatsHappen;
  	this.locationKind = locationKind;
  	this.riskThreat = riskThreat;
  	this.healthMotive = healthMotive;
  	this.victims = victims;
  }

  public String getVersion() { return this.version; }
  public void setVersion(String version) { this.version = version; }

  public AttributeType getWhatsHappen() { return this.whatsHappen; }
  public void setWhatsHappen(AttributeType whatsHappen) { this.whatsHappen = whatsHappen; }

  public AttributeType getLocationKind() { return this.locationKind; }
  public void setLocationKind(AttributeType locationKind) { this.locationKind = locationKind; }

  public AttributeType[] getRiskThreat() { return this.riskThreat; }
  public void setRiskThreat(AttributeType[] riskThreat) { this.riskThreat = riskThreat; }

  public AttributeType getHealthMotive() { return this.healthMotive; }
  public void setHealthMotive(AttributeType healthMotive) { this.healthMotive = healthMotive; }

  public Victims getVictims() { return this.victims; }
  public void setVictims(Victims victims) { this.victims = victims; }

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
                Arrays.equals(this.riskThreat, self.riskThreat) &&
        Objects.equals(this.healthMotive, self.healthMotive) &&
        Objects.equals(this.victims, self.victims);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)version, (Object)whatsHappen, (Object)locationKind, (Object)riskThreat, (Object)healthMotive, (Object)victims);
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