package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AttributeType {
  @JsonProperty("code")
  @NotNull
  private String code;
  @JsonProperty("label")
  @NotNull
  private String label;
  @JsonProperty("comment")
  private String comment;

  public AttributeType(){
  }

  public AttributeType(
    String code, String label, String comment
  ) {
  	this.code = code;
  	this.label = label;
  	this.comment = comment;
  }

  public String getCode() { return this.code; }
  public void setCode(String code) { this.code = code; }

  public String getLabel() { return this.label; }
  public void setLabel(String label) { this.label = label; }

  public String getComment() { return this.comment; }
  public void setComment(String comment) { this.comment = comment; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AttributeType self = (AttributeType) o;
      return 
        Objects.equals(this.code, self.code) &&
        Objects.equals(this.label, self.label) &&
        Objects.equals(this.comment, self.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)code, (Object)label, (Object)comment);
  }

  @Override
  public String toString() {
    return "class AttributeType {\n" +   
      "    code: " + toIndentedString(code) + "\n" +
      "    label: " + toIndentedString(label) + "\n" +
      "    comment: " + toIndentedString(comment) + "\n" +
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