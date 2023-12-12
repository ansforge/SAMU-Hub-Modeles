/*
 *
 *
 *
 *
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator
 * (https://openapi-generator.tech). https://openapi-generator.tech Do not edit
 * the class manually.
 */

package com.hubsante.model.cisu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.*;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Objects;

/**
 * Contact
 */
@JsonPropertyOrder({Contact.JSON_PROPERTY_TYPE, Contact.JSON_PROPERTY_DETAIL})
@JsonTypeName("contact")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@javax.annotation.
Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen",
          date = "2023-12-12T12:51:21.739399Z[Etc/UTC]")
public class Contact {

  /**
   * Type de l&#39;URI utilisée par le requérant, cf. nomenclature EMSI
   */
  public enum TypeEnum {
    PSTADD("PSTADD"),

    EMLADD("EMLADD"),

    IPADD("IPADD"),

    FTPADD("FTPADD"),

    WWWADD("WWWADD"),

    PHNADD("PHNADD"),

    FAXADD("FAXADD"),

    PMRADD("PMRADD");

    private String value;

    TypeEnum(String value) { this.value = value; }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public Contact() {}

  public Contact type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Type de l&#39;URI utilisée par le requérant, cf. nomenclature EMSI
   * @return type
   **/
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Contact detail(String detail) {

    this.detail = detail;
    return this;
  }

  /**
   * Valeur de l&#39;URI utilisée pour contacter le partenaire
   * @return detail
   **/
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDetail() {
    return detail;
  }

  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDetail(String detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact)o;
    return Objects.equals(this.type, contact.type) &&
        Objects.equals(this.detail, contact.detail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, detail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("}");
    return sb.toString();
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
