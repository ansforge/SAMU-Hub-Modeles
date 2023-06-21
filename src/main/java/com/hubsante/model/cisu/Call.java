package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Call {
  @JsonProperty("source")
  @NotNull
  private String source;
  @JsonProperty("dialledURI")
  private String dialledUri;

  public Call(){
  }

  public Call(
    String source, String dialledUri
  ) {
  	this.source = source;
  	this.dialledUri = dialledUri;
  }

  public String getSource() { return this.source; }
  public void setSource(String source) { this.source = source; }

  public String getDialledUri() { return this.dialledUri; }
  public void setDialledUri(String dialledUri) { this.dialledUri = dialledUri; }

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
        Objects.equals(this.dialledUri, self.dialledUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)source, (Object)dialledUri);
  }

  @Override
  public String toString() {
    return "class Call {\n" +   
      "    source: " + toIndentedString(source) + "\n" +
      "    dialledUri: " + toIndentedString(dialledUri) + "\n" +
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