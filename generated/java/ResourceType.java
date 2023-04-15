package com.hubsante.message;
              
import java.util.Objects;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.*;
              
public class ResourceType {
  @JsonProperty("resourceDesc")
  @NotNull
  private String resourceDesc;
  @JsonProperty("mimeType")
  @NotNull
  private String mimeType;
  @JsonProperty("size")
  private Integer size;
  @JsonProperty("uri")
  private String uri;
  @JsonProperty("derefURI")
  private String derefUri;
  @JsonProperty("digest")
  private String digest;

  public ResourceType(){
  }

  public ResourceType(
    String resourceDesc, String mimeType, Integer size, String uri, String derefUri, String digest
  ) {
  	this.resourceDesc = resourceDesc;
  	this.mimeType = mimeType;
  	this.size = size;
  	this.uri = uri;
  	this.derefUri = derefUri;
  	this.digest = digest;
  }

  public String getResourceDesc() { return this.resourceDesc; }
  public void setResourceDesc(String resourceDesc) { this.resourceDesc = resourceDesc; }

  public String getMimeType() { return this.mimeType; }
  public void setMimeType(String mimeType) { this.mimeType = mimeType; }

  public Integer getSize() { return this.size; }
  public void setSize(Integer size) { this.size = size; }

  public String getUri() { return this.uri; }
  public void setUri(String uri) { this.uri = uri; }

  public String getDerefUri() { return this.derefUri; }
  public void setDerefUri(String derefUri) { this.derefUri = derefUri; }

  public String getDigest() { return this.digest; }
  public void setDigest(String digest) { this.digest = digest; }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceType self = (ResourceType) o;
      return 
        Objects.equals(this.resourceDesc, self.resourceDesc) &&
        Objects.equals(this.mimeType, self.mimeType) &&
        Objects.equals(this.size, self.size) &&
        Objects.equals(this.uri, self.uri) &&
        Objects.equals(this.derefUri, self.derefUri) &&
        Objects.equals(this.digest, self.digest);
  }

  @Override
  public int hashCode() {
    return Objects.hash((Object)resourceDesc, (Object)mimeType, (Object)size, (Object)uri, (Object)derefUri, (Object)digest);
  }

  @Override
  public String toString() {
    return "class ResourceType {\n" +   
      "    resourceDesc: " + toIndentedString(resourceDesc) + "\n" +
      "    mimeType: " + toIndentedString(mimeType) + "\n" +
      "    size: " + toIndentedString(size) + "\n" +
      "    uri: " + toIndentedString(uri) + "\n" +
      "    derefUri: " + toIndentedString(derefUri) + "\n" +
      "    digest: " + toIndentedString(digest) + "\n" +
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