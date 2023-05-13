package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Content {
  @JsonProperty("contentObject")
  @NotNull
  private Object contentObject;

  public Content(){
  }

  public Content(
    Object contentObject
  ) {
  	this.contentObject = contentObject;
  }

  public Object getContentObject() { return this.contentObject; }
  public void setContentObject(Object contentObject) { this.contentObject = contentObject; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Content self = (Content) o;
      return 
        Objects.equals(this.contentObject, self.contentObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)contentObject);
  }

  @Override
  public String toString() {
    return "class Content {\n" +   
      "    contentObject: " + toIndentedString(contentObject) + "\n" +
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