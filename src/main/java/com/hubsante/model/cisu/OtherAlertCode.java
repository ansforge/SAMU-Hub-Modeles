package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OtherAlertCode {
  @JsonProperty("version")
  @NotNull
  private String version;
  @JsonProperty("whatsHappen")
  @NotNull
  private OptionalAttributeType whatsHappen;
  @JsonProperty("locationKind")
  @NotNull
  private OptionalAttributeType locationKind;
  @JsonProperty("otherRiskThreat")
  @Size(min=0)
  private OptionalAttributeType[] otherRiskThreat;
  @JsonProperty("healthMotive")
  @NotNull
  private OptionalAttributeType healthMotive;
  @JsonProperty("victims")
  private Victims victims;

  public OtherAlertCode(){
  }

  public OtherAlertCode(
    String version, OptionalAttributeType whatsHappen, OptionalAttributeType locationKind, OptionalAttributeType[] otherRiskThreat, OptionalAttributeType healthMotive, Victims victims
  ) {
  	this.version = version;
  	this.whatsHappen = whatsHappen;
  	this.locationKind = locationKind;
  	this.otherRiskThreat = otherRiskThreat;
  	this.healthMotive = healthMotive;
  	this.victims = victims;
  }

  public String getVersion() { return this.version; }
  public void setVersion(String version) { this.version = version; }

  public OptionalAttributeType getWhatsHappen() { return this.whatsHappen; }
  public void setWhatsHappen(OptionalAttributeType whatsHappen) { this.whatsHappen = whatsHappen; }

  public OptionalAttributeType getLocationKind() { return this.locationKind; }
  public void setLocationKind(OptionalAttributeType locationKind) { this.locationKind = locationKind; }

  public OptionalAttributeType[] getOtherRiskThreat() { return this.otherRiskThreat; }
  public void setOtherRiskThreat(OptionalAttributeType[] otherRiskThreat) { this.otherRiskThreat = otherRiskThreat; }

  public OptionalAttributeType getHealthMotive() { return this.healthMotive; }
  public void setHealthMotive(OptionalAttributeType healthMotive) { this.healthMotive = healthMotive; }

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
    OtherAlertCode self = (OtherAlertCode) o;
      return 
        Objects.equals(this.version, self.version) &&
        Objects.equals(this.whatsHappen, self.whatsHappen) &&
        Objects.equals(this.locationKind, self.locationKind) &&
        Objects.equals(this.otherRiskThreat, self.otherRiskThreat) &&
        Objects.equals(this.healthMotive, self.healthMotive) &&
        Objects.equals(this.victims, self.victims);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)version, (Object)whatsHappen, (Object)locationKind, (Object)otherRiskThreat, (Object)healthMotive, (Object)victims);
  }

  @Override
  public String toString() {
    return "class OtherAlertCode {\n" +   
      "    version: " + toIndentedString(version) + "\n" +
      "    whatsHappen: " + toIndentedString(whatsHappen) + "\n" +
      "    locationKind: " + toIndentedString(locationKind) + "\n" +
      "    otherRiskThreat: " + toIndentedString(otherRiskThreat) + "\n" +
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