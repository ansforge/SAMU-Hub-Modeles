package com.hubsante.message;
              
import java.util.Objects;
import java.util.Map;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Call {
  @JsonProperty("source")
  @NotNull
  private String source;
  @JsonProperty("dialledURI")
  private String dialledUri;
  private Map<String, Object> additionalProperties;

  public Call(){
  }

  public Call(
    String source, String dialledUri, Map<String, Object> additionalProperties
  ) {
  	this.source = source;
  	this.dialledUri = dialledUri;
  	this.additionalProperties = additionalProperties;
  }

  public String getSource() { return this.source; }
  public void setSource(String source) { this.source = source; }

  public String getDialledUri() { return this.dialledUri; }
  public void setDialledUri(String dialledUri) { this.dialledUri = dialledUri; }

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
    Call self = (Call) o;
      return 
        Objects.equals(this.source, self.source) &&
        Objects.equals(this.dialledUri, self.dialledUri) &&
        Objects.equals(this.additionalProperties, self.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)source, (Object)dialledUri, (Object)additionalProperties);
  }

  @Override
  public String toString() {
    return "class Call {\n" +   
      "    source: " + toIndentedString(source) + "\n" +
      "    dialledUri: " + toIndentedString(dialledUri) + "\n" +
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