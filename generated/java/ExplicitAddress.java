package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class ExplicitAddress {
  @JsonProperty("explicitAddressScheme")
  @NotNull
  private String explicitAddressScheme;
  @JsonProperty("explicitAddressValue")
  @NotNull
  private String explicitAddressValue;

  public ExplicitAddress(){
  }

  public ExplicitAddress(
    String explicitAddressScheme, String explicitAddressValue
  ) {
  	this.explicitAddressScheme = explicitAddressScheme;
  	this.explicitAddressValue = explicitAddressValue;
  }

  public String getExplicitAddressScheme() { return this.explicitAddressScheme; }
  public void setExplicitAddressScheme(String explicitAddressScheme) { this.explicitAddressScheme = explicitAddressScheme; }

  public String getExplicitAddressValue() { return this.explicitAddressValue; }
  public void setExplicitAddressValue(String explicitAddressValue) { this.explicitAddressValue = explicitAddressValue; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExplicitAddress self = (ExplicitAddress) o;
      return 
        Objects.equals(this.explicitAddressScheme, self.explicitAddressScheme) &&
        Objects.equals(this.explicitAddressValue, self.explicitAddressValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)explicitAddressScheme, (Object)explicitAddressValue);
  }

  @Override
  public String toString() {
    return "class ExplicitAddress {\n" +   
      "    explicitAddressScheme: " + toIndentedString(explicitAddressScheme) + "\n" +
      "    explicitAddressValue: " + toIndentedString(explicitAddressValue) + "\n" +
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