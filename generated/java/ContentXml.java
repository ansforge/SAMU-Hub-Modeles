package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class ContentXml {
  @JsonProperty("contentXML")
  private Object contentXml;

  public ContentXml(){
  }

  public ContentXml(
    Object contentXml
  ) {
  	this.contentXml = contentXml;
  }

  public Object getContentXml() { return this.contentXml; }
  public void setContentXml(Object contentXml) { this.contentXml = contentXml; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentXml self = (ContentXml) o;
      return 
        Objects.equals(this.contentXml, self.contentXml);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)contentXml);
  }

  @Override
  public String toString() {
    return "class ContentXml {\n" +   
      "    contentXml: " + toIndentedString(contentXml) + "\n" +
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