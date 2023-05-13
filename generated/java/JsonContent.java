package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class JsonContent {
  @JsonProperty("JsonContent")
  private Object jsonContent;

  public JsonContent(){
  }

  public JsonContent(
    Object jsonContent
  ) {
  	this.jsonContent = jsonContent;
  }

  public Object getJsonContent() { return this.jsonContent; }
  public void setJsonContent(Object jsonContent) { this.jsonContent = jsonContent; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonContent self = (JsonContent) o;
      return 
        Objects.equals(this.jsonContent, self.jsonContent);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)jsonContent);
  }

  @Override
  public String toString() {
    return "class JsonContent {\n" +   
      "    jsonContent: " + toIndentedString(jsonContent) + "\n" +
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