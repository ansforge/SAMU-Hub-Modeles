package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class Victims {
  @JsonProperty("count")
  @NotNull
  private Count count;
  @JsonProperty("mainVictim")
  private MainVictim mainVictim;
  @JsonProperty("comment")
  private String comment;

  public Victims(){
  }

  public Victims(
    Count count, MainVictim mainVictim, String comment
  ) {
  	this.count = count;
  	this.mainVictim = mainVictim;
  	this.comment = comment;
  }

  public Count getCount() { return this.count; }
  public void setCount(Count count) { this.count = count; }

  public MainVictim getMainVictim() { return this.mainVictim; }
  public void setMainVictim(MainVictim mainVictim) { this.mainVictim = mainVictim; }

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
    Victims self = (Victims) o;
      return 
        Objects.equals(this.count, self.count) &&
        Objects.equals(this.mainVictim, self.mainVictim) &&
        Objects.equals(this.comment, self.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)count, (Object)mainVictim, (Object)comment);
  }

  @Override
  public String toString() {
    return "class Victims {\n" +   
      "    count: " + toIndentedString(count) + "\n" +
      "    mainVictim: " + toIndentedString(mainVictim) + "\n" +
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