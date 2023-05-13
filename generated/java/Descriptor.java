package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Descriptor {
  @JsonProperty("language")
  @NotNull
  private String language;
  @JsonProperty("explicitAddress")
  @NotNull
  private ExplicitAddress explicitAddress;

  public Descriptor(){
  }

  public Descriptor(
    String language, ExplicitAddress explicitAddress
  ) {
  	this.language = language;
  	this.explicitAddress = explicitAddress;
  }

  public String getLanguage() { return this.language; }
  public void setLanguage(String language) { this.language = language; }

  public ExplicitAddress getExplicitAddress() { return this.explicitAddress; }
  public void setExplicitAddress(ExplicitAddress explicitAddress) { this.explicitAddress = explicitAddress; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Descriptor self = (Descriptor) o;
      return 
        Objects.equals(this.language, self.language) &&
        Objects.equals(this.explicitAddress, self.explicitAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)language, (Object)explicitAddress);
  }

  @Override
  public String toString() {
    return "class Descriptor {\n" +   
      "    language: " + toIndentedString(language) + "\n" +
      "    explicitAddress: " + toIndentedString(explicitAddress) + "\n" +
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